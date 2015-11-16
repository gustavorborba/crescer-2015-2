using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Teste
{
    [TestClass]
    public class PermissaoTest
    {
        [TestMethod]
        public void PermissaoConstrutor()
        {
            Permissao permissao = new Permissao();
            permissao.Descricao = "ADMIN";

            Assert.AreEqual(permissao.Descricao, "ADMIN");

        }
    }
}
