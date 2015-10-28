using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        private string ID;
        private string Nome;
        private string Preco;
        private string Categoria;

        public Jogo(string id, string nome, string preco, string categoria)
        {
            this.ID = id;
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
    }
}
