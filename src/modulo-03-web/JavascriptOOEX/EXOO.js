  function Item(sku,descricao,quantidade,valorunitario){
  this.sku=sku;
  this.descricao=descricao;
  this.quantidade=quantidade;
  this.valorunitario=valorunitario;
}

function CarrinhoDeCompras(){
    this.itens=new Array();
}

//Metodos CARRINHODECOMPRAS

CarrinhoDeCompras.prototype.adicionarItem= function(item){
  if(item instanceof Item){
      this.itens.push(item);
  }
}
CarrinhoDeCompras.prototype.encontrarPorSku=function(skus){
  for(var i=0;i<this.itens.length;i++){
    if(this.itens[i].sku===skus){
      return i;
    }
  }
  return -1;
}
CarrinhoDeCompras.prototype.removerItem=function(skuExcluir){
  var index=this.encontrarPorSku(skuExcluir);
  if(index>-1){
    this.itens.splice(index,1);
  }
}
CarrinhoDeCompras.prototype.atualizarQuantidade=function(skuAtt,novaQuantidade){
  var index=this.encontrarPorSku(skuAtt);
  if(index>-1){
    this.itens[index].quantidade=novaQuantidade;
  }
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

//Metodos ITEM

Item.prototype.calcularSubTotal=function(){
  return this.valorunitario*this.quantidade;
}
