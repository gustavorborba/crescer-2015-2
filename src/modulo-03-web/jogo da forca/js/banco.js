function Banco(options){
  options = options || {};
  this.baseURL = 'http://localhost:3000/';
};

Banco.prototype.buscarJogadores = function(args){
  $.get(this.baseURL+'pessoas'+(args.query || ''))
  .done(function(data) {
    args.callback({data:data, nome:args.nome
      ,callback:args.cbCallback
      ,self:args.self}
    );
  });
};

Banco.prototype.buscarOuCriarJogador = function(args){
  if(!!args.data){
    if(args.data.length>0){
      args.callback({jogador:new Jogador(
        args.data[0]
      )}
    );
  }else{
    args.self.criarJogador({callback:args.self.buscarOuCriarJogador
      ,data:[{nome:args.nome,pontuacao:0}]
      ,self:args.self,cbCallback:args.callback});
    }
  }else{
    this.buscarJogadores({nome:args.nome
      ,query:'?nome='+args.nome
      ,callback:this.buscarOuCriarJogador
      ,cbCallback:args.callback,self:this}
    );
  }
};

Banco.prototype.criarJogador = function(args){
  $.post('http://localhost:3000/pessoas',{ nome: args.data[0].nome, pontuacao: 0 })
  .done(function(){
    args.callback(
      {callback:args.cbCallback
        ,data:[{nome:args.data[0].nome,pontuacao:0}],self:args.self
      }
    );
  });
};

Banco.prototype.topRanking = function(args){
  if(!!args.data){
    args.callback(args.data.map(function(elem){
      return new Jogador({pontuacao:elem.pontuacao,nome:elem.nome});
    }));
  }else if(!!args.callback){
    this.buscarJogadores({query:'?_sort=pontuacao&_order=DESC&_end=5'
    ,callback:this.topRanking
    ,cbCallback:args.callback});
  }
};

Banco.prototype.buscarPalavra = function(args){
  var randomId = parseInt(Math.random()*96);
  var tamanhoMinimo = args.self.tamanhoMinimoPalavra;
  var query = this.baseURL+ 'palavras' + '?nome.length_gte='+tamanhoMinimo
  +'&id_gte='+randomId+'&id_lte='+randomId;
  args.selfBusca = this;
  $.get(query)
  .done(function(data) {
    if(data.length && args.selfBusca.verificarReincidencia(data[0].nome,args.self.jogador.nome)){
      args.callback({palavra:data[0].nome,dica:data[0].dica,self:args.self});
    }else{
      args.selfBusca.buscarPalavra(args);
    }
  });
};

Banco.prototype.localStorageContainsUsuario = function(usuarios,nomeDoUsuario){
  for (var i = 0; i < usuarios.length; i++) {
    if (usuarios[i].nome === nomeDoUsuario) {
      return i;
    }
  }
  return -1;
};

Banco.prototype.listarPalavrasRepetidas = function(nomeDoUsuario) {
  var indice = this.criarListaDePalavrasParaUsuario(nomeDoUsuario);
  var listaPalavras = JSON.parse(localStorage.palavraRepetidas);
  localStorage.setItem('palavraRepetidas', JSON.stringify(listaPalavras));
  return listaPalavras[indice].palavrasRepetidas;
};

Banco.prototype.criarListaDePalavrasParaUsuario = function(nomeDoUsuario) {
  if (localStorage.palavraRepetidas === undefined) {
    this.resetarPalavrasRepetidas();
  }
  var usuarios = JSON.parse(localStorage.palavraRepetidas);
  var indice = this.localStorageContainsUsuario(usuarios, nomeDoUsuario);
  if (indice === -1) {
    usuarios.push({'nome': nomeDoUsuario, 'palavrasRepetidas': []});
    indice = usuarios.length - 1;
  }
  localStorage.setItem('palavraRepetidas', JSON.stringify(usuarios));
  return indice;
};

Banco.prototype.resetarPalavrasRepetidas = function() {
  localStorage.setItem('palavraRepetidas', '[]');
};

Banco.prototype.verificarReincidencia = function(palavra, nomeDoUsuario){
  var lista = this.listarPalavrasRepetidas(nomeDoUsuario);
  for(var i=0,len=lista.length;i<len;i++){
    if(palavra===lista[i].nome) {
      return false;
    }
  }
  return true;
}

Banco.prototype.adicionarPalavraRepetida = function(nomeDoUsuario, palavraDeRetorno) {
  var indice = this.criarListaDePalavrasParaUsuario(nomeDoUsuario);
  var listaPalavras = JSON.parse(localStorage.palavraRepetidas);
  listaPalavras[indice].palavrasRepetidas.push({'nome': palavraDeRetorno});
  localStorage.setItem('palavraRepetidas', JSON.stringify(listaPalavras));
};

Banco.prototype.postVitoria = function(jogador){
  var url = (this.baseURL+'pessoas/'+jogador.id);
  $.ajax({
    url: url,
    type: 'PATCH',
    data: {"pontuacao": jogador.pontuacao},
  });
};
