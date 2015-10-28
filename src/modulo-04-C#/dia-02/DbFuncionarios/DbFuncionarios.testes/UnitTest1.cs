using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Linq;
namespace DbFuncionarios.testes
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void OrdenadoPorCargo()
        {
            Exercicios exer = new Exercicios();
            var ordenado = exer.OrdenadoPorCargo().ToList();
            Assert.AreEqual(ordenado.First().Cargo.Titulo, "Analista");
        }
        [TestMethod]
        public void BuscaPorNome()
        {
            Exercicios exer = new Exercicios();
            var busca = exer.BuscarPorNome("Lucas Leal").ToList();
            Assert.AreEqual(busca.Count,1);
            Assert.AreEqual(busca.First().Nome,"Lucas Leal");
        }
    }
}
