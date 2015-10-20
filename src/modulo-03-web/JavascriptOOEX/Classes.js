function Item(sku,descricao,quantidade,valorunitario){
  this.sku=sku;
  this.descricao=descricao;
  this.quantidade=quantidade;
  this.valorunitario=valorunitario;
}



function CarrinhoDeCompras(){
    this.itens=new Array();
}

CarrinhoDeCompras.prototype.adicionarItem= function(item){
  this.itens.push(item);
}
CarrinhoDeCompras.prototype.removerItem=function(sku){
  var index=itens.sku.indexOf(sku);
  this.itens.splice(index,1);
}
