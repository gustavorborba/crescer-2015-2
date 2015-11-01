using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
namespace LocadoraUI
{
    class Program
    {
        static void Main(string[] args)
        {
            JogoUI jogo = new JogoUI();
            int opcao = 1;
            const int cadastrar = 1;
            const int buscar = 2;
            const int editar = 3;
            const int relatorio=4;
            while (opcao != 0)
            {
                Console.WriteLine("Digite uma das opcoes!");
                Console.WriteLine("1- Cadastrar jogos");
                Console.WriteLine("2- Buscar Jogos");
                Console.WriteLine("3- Editar Jogos");
                Console.WriteLine("4- Gerar Relatorio");
                Console.WriteLine("0-Sair");
                opcao = int.Parse(Console.ReadLine());
                Console.Clear();
                switch (opcao)
                {
                    case cadastrar:
                        jogo.CadastrarJogo();
                        break;
                    case buscar:
                        jogo.BucarPorNome();
                        break;
                    case editar:
                        jogo.EditarJogo();
                        break;
                    case relatorio:
                        jogo.GerarRelatorio();
                        break;
                    default:
                        opcao = 0;
                        break;
                }
            }
        }
    }
}
