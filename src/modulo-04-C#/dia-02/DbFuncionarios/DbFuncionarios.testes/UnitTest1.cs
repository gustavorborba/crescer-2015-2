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
            var ordenado = exer.OrdenadoPorCargo();
            Assert.AreNotEqual(ordenado, exer.funcionarios);
        }
        [TestMethod]
        public void BuscaPorNome()
        {
            Exercicios exer = new Exercicios();
            var busca = exer.BuscarPorNome("Lucas Leal").ToList();
            Assert.AreEqual(busca.Count,1);
        }
    }
}
