﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        private string ID = null;;
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
        public Jogo(string nome, string preco, string categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
        public XElement ToXml(string id)
        {
            XElement jogoToXml = new XElement("jogo",
                new XAttribute("id", id),
                new XElement("nome", Nome),
                new XElement("preco", Preco),
                new XElement("categoria", Categoria)
                );
                return jogoToXml;

        }
    }
}
