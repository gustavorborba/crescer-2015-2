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
    if(nome===''){
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
    buscarJogadores(nome);
});

var ranking=function(){
  var jogadores=[];
  $.get('http://localhost:3000/pessoas')
  .done(function(data){
    data.forEach(function(elem){
      jogadores.push(elem);
    })
    jogadores.sort(function(elem,elem2){
      return elem.nome > elem2.nome;

    });
    //tenho dados aqui, inicialiar funcao;
      jogadores.forEach(function(elem){
        console.log(elem.nome);
      });
  });
};
