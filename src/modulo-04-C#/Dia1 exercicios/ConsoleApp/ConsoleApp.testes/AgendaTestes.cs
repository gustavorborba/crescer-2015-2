using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.testes
{
    [TestClass]
    public class AgendaTeste
    {
        [TestMethod]
        public void AgendaDevePossuirUmContato()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato() { Nome="Mephisto",Numero=6667});
            Assert.AreEqual(agenda.GetQuantidadeContatos(), 1);
        }
        [TestMethod]

        public void AgendaTemListagemAscendente()
        {
            var agenda = new Agenda();
            var contato1 = new Contato()
            {
                Nome = "Mamon",
                Numero = 66667
            };
            var contato2 = new Contato()
            {
                Nome = "Amon",
                Numero = 66668
            };
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            var ordenado = agenda.ListarContatosOrdenados();
            Assert.AreEqual(ordenado.Equals(agenda), false);
        }
        [TestMethod]
        public void TodosContatosIguaisSãoExcluidos(){
          var agenda = new Agenda();
          var contato1 = new Contato()
          {
              Nome = "Mamon",
              Numero = 66667
          };
          var contato2 = new Contato()
          {
              Nome = "Amon",
              Numero = 66668
          };
          var contato3 = new Contato()
          {
              Nome = "Amon",
              Numero = 66668
          };
          agenda.AdicionarContato(contato1);
          agenda.AdicionarContato(contato2);
          agenda.AdicionarContato(contato3);
          agenda.RemoverContatoPorNome("Amon");
          Assert.AreEqual(agenda.GetQuantidadeContatos(),1);
        }
    }
}
