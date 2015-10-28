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
            var a=banco.BuscarPorNome("LOL");
            foreach (var item in a)
            {
                item.EditarJogo("League of Legends", "1", "MAISOUMENOS");
                banco.EditarJogo(item);
            }
            Console.Read();
        }
    }
}
