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
            Banco banco = new Banco();
            Jogo jogo = new Jogo("World of Warcraft","120",ECategoria.RPG);
            banco.CadastrarJogoEmXML(jogo);
            Console.Read();
        }
    }
}
