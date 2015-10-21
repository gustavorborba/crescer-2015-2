function CarrinhoDeCompras(){
    this.itens=new Array();
}

CarrinhoDeCompras.prototype.adicionarItem= function(item){
  if(item instanceof Item){
      this.itens.push(item);
  }
}
CarrinhoDeCompras.prototype.removerItem=function(skuExcluir){
  this.itens = this.itens.filter(function(item) {
    return item.sku !== sku;
  });
}
CarrinhoDeCompras.prototype.atualizarQuantidade=function(skuAtt,novaQuantidade){
  this.itens.map(function(item) {
    if (item.sku === skuAtt) {
      item.quantidade = novaQuantidade;
    }
    return item;
  });
}
CarrinhoDeCompras.prototype.totalValorCarrinho=function(){
  var sorte=this.sorteDeDwarf();
  var total=this.itens.reduce(function(soma,elem){
    return soma + elem.calcularSubTotal();
  },0);

  if(sorte<=4){
      total=total-(total*0.1);
  }
  return total;
}
CarrinhoDeCompras.prototype.sorteDeDwarf=function(){
  return Math.floor((Math.random() * 10) + 1);
}
CarrinhoDeCompras.prototype.forcarCompra=function(){
  this.times=setInterval(
    function(){
      this.itens.forEach(function(elem){
          elem.valorunitario+=elem.valorunitario*0.1;
      })}.bind(this),5000);
}

CarrinhoDeCompras.prototype.concluirPedido=function(){
  clearInterval(this.times);
  delete this.times;
}
