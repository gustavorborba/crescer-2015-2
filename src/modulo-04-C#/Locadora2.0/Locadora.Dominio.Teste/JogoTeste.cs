using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Teste
{
    [TestClass]
    public class JogoTeste
    {
        [TestMethod]
        public void JogoTesteCriacao()
        {
            Jogo jogo = new Jogo(2);
            jogo.ImagemUrl = "imagem";
            jogo.Nome = "Nome";
            jogo.Selos = Selo.BRONZE;
            jogo.Categoria = Categoria.AVENTURA;

            Assert.AreEqual(2, jogo.IDJogo);
            Assert.AreEqual("imagem",jogo.ImagemUrl);
            Assert.AreEqual("Nome", jogo.Nome);
            Assert.AreEqual(Selo.BRONZE, jogo.Selos);
            Assert.AreEqual(Categoria.AVENTURA, jogo.Categoria);

        }
        [TestMethod]
        public void LocarEDevolver()
        {
            Jogo jogo = new Jogo();
            Cliente cliente = new Cliente(2);

            jogo.LocarPara(cliente);
            Assert.AreEqual(2, jogo.IDCliente);
            Assert.AreEqual(2, jogo.Cliente.IDCliente);
            jogo.DevolverJogo();
            Assert.AreEqual(null, jogo.IDCliente);
            Assert.AreEqual(null, jogo.Cliente);
        }
        [TestMethod]
        public void CalcularPrecoTest()
        {
            Jogo jogo = new Jogo();

            jogo.DataLocacao = DateTime.Now;
            jogo.Selos = Selo.OURO;
            var preco = jogo.CalcularPrecoFinal();
            Assert.AreEqual(15,preco);
            jogo.Selos = Selo.PRATA;
            preco = jogo.CalcularPrecoFinal();
            Assert.AreEqual(10, preco);
            jogo.Selos = Selo.BRONZE;
            preco = jogo.CalcularPrecoFinal();
            Assert.AreEqual(5,preco);
        }
    }
}
