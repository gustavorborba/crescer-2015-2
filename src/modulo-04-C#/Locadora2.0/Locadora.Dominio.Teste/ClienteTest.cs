using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Teste
{
    [TestClass]
    public class ClienteTest
    {
        [TestMethod]
        public void ClienteTeste()
        {
            Cliente cliente = new Cliente(1);
            cliente.Nome = "Mau";
            Assert.AreEqual(1, cliente.IDCliente);
            Assert.AreEqual("Mau",cliente.Nome);
        }
    }
}
