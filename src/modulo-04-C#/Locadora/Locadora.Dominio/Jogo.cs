using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public string ID { get; private set; }
        public string Nome { get; private set; }
        public string Preco { get; private set; }
        public string Categoria { get; private set; }

        public Jogo(string id, string nome, string preco, string categoria)
        {
            this.ID = id;
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
    }
}
