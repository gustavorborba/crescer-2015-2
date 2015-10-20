//1.A
function ordenaPorNacionais(arrai){
  arrai.sort(function(a,b){
    return a.titulos[0].qtd < b.titulos[0].qtd;
  });
}

//1.B
function ordenaPorContinentais(arrai){
  arrai.sort(function(a,b){
    return a.titulos[1].qtd < b.titulos[1].qtd;
  });
}
//1.C
function ordenaPorMundiais(arrai){
  arrai.sort(function(a,b){
    return a.titulos[2].qtd < b.titulos[2].qtd;
  });
}

//2
//2.A
function somarPorNacionais(arrai){
  var somatorio=0;
  arrai.forEach(function(elem){
    somatorio+=elem.titulos[0].qtd;
  })
  return somatorio;
}
//2.B
function somarPorContinentais(arrai){
  var somatorio=0;
  arrai.forEach(function(elem){
    somatorio+=elem.titulos[1].qtd;
  })
  return somatorio;
}
//2.C
function somarPorTodosOsTitulos(arrai){
  var somatorio=0;
  arrai.forEach(function(elem){
    somatorio+=elem.titulos[0].qtd;
    somatorio+=elem.titulos[1].qtd;
    somatorio+=elem.titulos[2].qtd;
  })
  return somatorio;
}

//3
function apenasOsMelhores(arrai){
  return arrai.filter(function(elem){
    return elem.titulos[0].qtd > 18;
  });
}

//4
function calcularIdadeMedia(arrai){
  var datahoje=new Date().getFullYear();
  return arrai.reduce(function(acumulador,elem){
    return acumulador + datahoje-elem.fundacao.getFullYear();
  },0)/arrai.length;
}
