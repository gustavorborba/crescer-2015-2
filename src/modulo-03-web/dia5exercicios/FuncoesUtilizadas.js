//mostra o album do artista na tela
var albums=function(album) {
  $('h2').empty();
  urlspotfy='https://api.spotify.com/v1/artists/'+ album+'/albums?limit=50';
  $.get(urlspotfy)
  .done(function(data) {
    var dados=data.items;
      dados.forEach(function(elem){
      $('h2').append(
        $('<img>')
        .attr('src', elem.images[1].url)
      )
    });
  });
};

var pesquisarIDNome=function(nome){
  nome.replace(' ','+');
  $.get('https://api.spotify.com/v1/search?q='+nome+'&type=artist')
  .done(function(data){
     albums(data.artists.items[0].id);
  })
};

$('#Pesquisar').click(function(){
  console.log('Entrou ae');
  if($('#Artista').val().toUpperCase()==='JUSTIN BIEBER'){
    var rand=Math.floor((Math.random() * 10) + 1);
    if(rand>8){
    pesquisarIDNome('Justin Bieber');
  }else{
    albums('Douchebag');
    alert("Erro 404, existia ou não uma pagina aqui, eis a questão");
  }
}else{
    pesquisarIDNome($('#Artista').val());
}
});
