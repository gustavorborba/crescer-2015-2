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

            var agenda = new Agenda();
            Metodos metodo = new Metodos();
            const int cadastrar=1;
            const int listar=2;
            const int listarAsc=3;
            const int excluirNome=4;
            const int excluirNumero=5;

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
                Console.Clear();
                switch (opcao)
                {
                    case cadastrar:
                        metodo.Cadastro(agenda);
                        break;
                    case listar:
                        metodo.Listar(agenda);
                        break;
                    case listarAsc:
                        metodo.ListarOrdenadoAsc(agenda);
                        break;
                    case excluirNome:
                        metodo.ExcluirNome(agenda);
                        break;
                    case excluirNumero:
                        metodo.ExcluirNumero(agenda);
                        break;
                    default:
                        opcao = 0;
                        break;

                }
            }

        }
    }
}
