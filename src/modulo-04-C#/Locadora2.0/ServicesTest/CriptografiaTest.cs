using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Services.Security;

namespace ServicesTest
{
    [TestClass]
    public class CriptografiaTest
    {
        [TestMethod]
        public void Criptografia()
        {
            CripografiaRepositorio criptografar = new CripografiaRepositorio();
            var senhaCriptografada = criptografar.Criptografar("1");

            Assert.AreEqual(senhaCriptografada, "131819FAD1672FDB1D6F6C8BD8FB43A4");
        }
    }
}
