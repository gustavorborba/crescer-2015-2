using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocarModel
    {
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public DateTime DataEntrega { get; set; }
        public string Imagem { get; set; }
        public Selo Selos { get; set; }
        public int IDJogo { get; set; }

        public LocarModel(Jogo jogo)
        {
            this.Nome = jogo.Nome;
            this.Selos = jogo.Selos;
            this.Imagem = jogo.ImagemUrl;
            this.IDJogo = jogo.IDJogo;
            if (this.Selos == Dominio.Selo.OURO)
            {
                this.DataEntrega = DateTime.Now.AddDays(1);
                this.Preco = 15;
            }
            if (jogo.Selos == Dominio.Selo.PRATA)
            {
                this.DataEntrega = DateTime.Now.AddDays(2);
                this.Preco = 10;
            }
            if (jogo.Selos == Dominio.Selo.BRONZE)
            {
                this.DataEntrega = DateTime.Now.AddDays(3);
                this.Preco = 5;
            }
        }
    }
}