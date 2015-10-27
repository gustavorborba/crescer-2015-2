using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Metodos
    {
        string nome;
        int numero;
        public void Cadastro(Agenda agenda)
        {
            Console.WriteLine("Digite o nome seguido do numero");
            nome = Console.ReadLine();
            numero = int.Parse(Console.ReadLine());
            agenda.AdicionarContato(new Contato() { Nome = nome, Numero = numero });
            Console.WriteLine("Cadastro efetuado com sucesso!!");
        }

        public void Listar(Agenda agenda)
        {
            foreach (var contato in agenda.ListarContatos())
            {
                Console.WriteLine("Nome: " + contato.Nome);
                Console.WriteLine("Telefone: " + contato.Numero);
            }
        }
        public void ListarOrdenadoAsc(Agenda agenda)
        {
            foreach (var contato in agenda.ListarContatosOrdenados())
            {
                Console.WriteLine("Nome: " + contato.Nome);
                Console.WriteLine("Telefone: " + contato.Numero);
            }
        }

        public void ExcluirNome(Agenda agenda)
        {
            Console.WriteLine("Digite o nome a ser excluido");
            nome = Console.ReadLine();
            agenda.RemoverContatoPorNome(nome);
            Console.WriteLine("Removido com sucesso!");
        }
        public void ExcluirNumero(Agenda agenda)
        {
            Console.WriteLine("Digite o numero a ser excluido");
            numero = int.Parse(Console.ReadLine());
            agenda.RemoverPorNumero(numero);
            Console.WriteLine("Removido com sucesso!");
        }
    }
}
