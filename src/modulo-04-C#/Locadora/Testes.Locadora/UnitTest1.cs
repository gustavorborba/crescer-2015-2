using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.IO;
using Locadora.Dominio;
namespace Testes.Locadora
{
    [TestClass]
    public class UnitTest1
    {
        Banco banco = new Banco();
        [TestMethod]
        public void BuscarPorNome1()
        {
            var jogo = banco.BuscarPorNome("halo");
            Assert.AreEqual(jogo.Nome,"Halo");
            Assert.AreEqual(jogo.ID,21);          
        }

        [TestMethod]
        public void CadastrarJogoEmXML()
        {
            Jogo jogo = new Jogo("Mario Verde", "25", ECategoria.AVENTURA, "0", EDisponibilidade.NAO);
            banco.CadastrarJogoEmXML(jogo);
            var jogoBanco = banco.BuscarPorNome("Mario Verde");
            Assert.AreEqual(jogoBanco.Nome,"Mario Verde");
        }

        [TestMethod]
        public void EditarJogo()
        {
            Jogo jogo = new Jogo("Mario Verde", "25", ECategoria.AVENTURA, "0", EDisponibilidade.NAO);
            banco.CadastrarJogoEmXML(jogo);
            var jogoBanco = banco.BuscarPorNome("Mario Verde");
            Assert.AreEqual(jogoBanco.Nome, "Mario Verde");

            jogoBanco.Nome = "Luidi";
            banco.EditarJogo(jogoBanco);

            var jogoBanco2 = banco.BuscarPorNome("Luidi");
            Assert.AreEqual(jogoBanco2.Nome,"Luidi");
        }
    }
}
