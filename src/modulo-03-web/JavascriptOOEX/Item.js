function Item(sku,descricao,quantidade,valorunitario){
  this.sku=sku;
  this.descricao=descricao;
  this.quantidade=quantidade;
  this.valorunitario=valorunitario;
}

Item.prototype.calcularSubTotal=function(){
  return this.valorunitario*this.quantidade;
}
