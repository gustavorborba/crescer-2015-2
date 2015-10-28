using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public int ID { get; private set; } = -1;
        public string Nome { get; private set; }
        public string Preco { get; private set; }
        public string Categoria { get; private set; }

        public Jogo(int id, string nome, string preco, string categoria)
        {
            this.ID = id;
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
        public Jogo(string nome, string preco, string categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
        public XElement ToXml()
        {
            if (ID == -1)
            {
                Banco banco = new Banco();
                ID = banco.ProcimoID();
            }
            XElement jogoToXml = new XElement("jogo",
                new XAttribute("id", ID),
                new XElement("nome", Nome),
                new XElement("preco", Preco),
                new XElement("categoria", Categoria)
                );
           return jogoToXml;
        }

        public void EditarJogo(string nome, string preco,string categoria)
        {
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }
    }
}
