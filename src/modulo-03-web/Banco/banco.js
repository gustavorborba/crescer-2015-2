var cadastro=function(nome) {
  var jogadores=[];
  var sd='';
  $.get('http://localhost:3000/pessoas')
  .done(function(data) {
      data.forEach(function(elem){
        jogadores.push(elem);
        if(elem.nome===nome){
          sd=elem.nome;
        }
    });
    if(sd===''){
      $.post('http://localhost:3000/pessoas',
      { nome: nome, Pontuacao: 0 }
    );
  }else{
    console.log("Nome já consta");
  }
  });
};

$('#btnid').click(function(){
  var nome=$('#idUsuario');
    cadastro(nome);
});

var ranking=function(){
  var jogadores=[];
  $.get('http://localhost:3000/pessoas')
  .done(function(data){
    data.forEach(function(elem){
      jogadores.push(elem);
    })
    jogadores.sort(function(elem,elem2){
      return elem.Pontuacao < elem2.Pontuacao;

    });
    //tenho dados aqui, inicialiar funcao;
      jogadores.forEach(function(elem){
        console.log(elem.nome);
      });
  });
};

var postVitoria=function(pontos){
  $.get('http://localhost:3000/pessoas')
  .done(function(data){
    for(var i=0;i<data.length;i++){
     if(data[i].nome==='Teste'){
      //  console.log(data[i].Pontuacao);
        data[i].Pontuacao+=pontos;
        console.log(data[i].Pontuacao);
      }
    }
  });
};
