using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class AgendaMenu
    {
        private Agenda agenda = new Agenda();
        string nome;
        int numero;
        public void Cadastro()
        {
            Console.WriteLine("Digite o nome seguido do numero");
            nome = Console.ReadLine();
            numero = int.Parse(Console.ReadLine());
            this.agenda.AdicionarContato(new Contato() { Nome = nome, Numero = numero });
            Console.WriteLine("Cadastro efetuado com sucesso!!");
        }

        public void Listar()
        {
            foreach (var contato in this.agenda.ListarContatos())
            {
                Console.WriteLine("Nome: " + contato.Nome);
                Console.WriteLine("Telefone: " + contato.Numero);
            }
        }
        public void ListarOrdenadoAsc()
        {
            foreach (var contato in this.agenda.ListarContatosOrdenados())
            {
                Console.WriteLine("Nome: " + contato.Nome);
                Console.WriteLine("Telefone: " + contato.Numero);
            }
        }

        public void ExcluirNome()
        {
            Console.WriteLine("Digite o nome a ser excluido");
            nome = Console.ReadLine();
            this.agenda.RemoverContatoPorNome(nome);
            Console.WriteLine("Removido com sucesso!");
        }
        public void ExcluirNumero()
        {
            Console.WriteLine("Digite o numero a ser excluido");
            numero = int.Parse(Console.ReadLine());
            this.agenda.RemoverPorNumero(numero);
            Console.WriteLine("Removido com sucesso!");
        }
    }
}
