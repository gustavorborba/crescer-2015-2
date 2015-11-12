using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente
    {
        public int IDCliente { get; private set; }
        public string Nome { get; set; }

        public Cliente()
        {

        }

        public Cliente(int id)
        {
            this.IDCliente = id;
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }


        public override bool Equals(object obj)
        {
            if (obj.GetType() == typeof(Jogo))
            {
                Cliente jogoComp = (Cliente)obj;

                return this.Nome == jogoComp.Nome;
            }

            return false;
        }

    }
}
