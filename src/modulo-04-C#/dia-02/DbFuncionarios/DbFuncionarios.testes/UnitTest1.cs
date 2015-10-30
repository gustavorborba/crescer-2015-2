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
        [TestMethod]
        public void BuscaPorTurno()
        {
            Exercicios exer = new Exercicios();
            var funcionarios = exer.BuscarPorTurno(TurnoTrabalho.Noite);
            Assert.AreEqual(funcionarios.Any(it => it.Nome== "Rafael Benetti"), true);
            Assert.AreEqual(funcionarios.Any(it => it.Nome== "Lucas Kauer"),true);
            Assert.AreEqual(funcionarios.Count,2);
        }
        [TestMethod]
        public void BuscaPorCargo()
        {
            Exercicios exer = new Exercicios();
            Cargo gerente = new Cargo("Gerente", 550.5);
            var funcionarios = exer.BuscarPorCargo(gerente);
            Assert.AreEqual(funcionarios.Any(it => it.Nome=="Margarete Ricardo"),true);
            Assert.AreEqual(funcionarios.Count,1);
        }
        [TestMethod]
        public void FiltrarPorIdadeAprocimada()
        {
            Exercicios exer = new Exercicios();
            var funcionarios = exer.FiltarPorIdadeAprocimada(18);
            Assert.AreEqual(funcionarios.Count,4);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Lucas Leal"), true);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Maurício Borges"), true);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Felipe Nervo"), true);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Lucas Kauer"), true);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Eduardo Arnold"), false);

        }
        [TestMethod]
        public void AniversariantesDoMes()
        {
            Exercicios exer = new Exercicios();
            var funcionarios = exer.AniversariantesDoMes();
            Assert.AreEqual(funcionarios.Count,1);
            Assert.AreEqual(funcionarios.Any(it => it.Nome == "Margarete Ricardo"), true);
        }
    }
}
