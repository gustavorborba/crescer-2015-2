using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcao = 1;
            string nome;
            int numero;
            var agenda = new Agenda();
            Console.WriteLine("Olá digite uma das seguintes opções:");
            while (opcao != 0)
            {
                Console.WriteLine("MENU");
                Console.WriteLine("1-Cadastrar novos contatos");
                Console.WriteLine("2-Listar contatos");
                Console.WriteLine("3-Listar contatos de forma ordenada");
                Console.WriteLine("4-Excluir por nome");
                Console.WriteLine("5-Excluir por numero");
                opcao = int.Parse(Console.ReadLine());
                switch (opcao)
                {
                    case 1:
                        Console.WriteLine("Digite o nome seguido do numero");
                        nome = Console.ReadLine();
                        numero = int.Parse(Console.ReadLine());
                        agenda.AdicionarContato(new Contato() { Nome = nome, Numero = numero });
                        Console.WriteLine("Cadastro efetuado com sucesso!!");
                        break;
                    case 2:
                        foreach (var contato in agenda.ListarContatos())
                        {
                            Console.WriteLine("Nome: "+contato.Nome);
                            Console.WriteLine("Telefone: " + contato.Numero);                            
                        }
                        break;
                    case 3:
                        foreach (var contato in agenda.ListarContatosOrdenados())
                        {
                            Console.WriteLine("Nome: " + contato.Nome);
                            Console.WriteLine("Telefone: " + contato.Numero);
                        }
                        break;
                    case 4:
                        Console.WriteLine("Digite o nome a ser excluido");
                        nome = Console.ReadLine();
                        agenda.RemoverContatoPorNome(nome);
                        break;
                    case 5:
                        Console.WriteLine("Digite o numero a ser excluido");

                        break;

                }
            }
            
        }
    }
}
