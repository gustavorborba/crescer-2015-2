//EX1
String.prototype.isPalindrome=function(){
  var palavra=this;
  for(var i=0;i<palavra.length/2;i++){
    if(palavra[i]!=palavra[palavra.length-1-i]){
      return false;
    }
  }
  return true;
}
//EX2
Date.prototype.bissexto=function(){
  var ano=this.getFullYear();
  if(ano % 4 == 0 && (ano % 100 != 0) || (ano % 400 == 0)){
    return true;
  }
  return false
}
