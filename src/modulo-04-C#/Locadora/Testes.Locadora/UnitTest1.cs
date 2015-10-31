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

    }
}
