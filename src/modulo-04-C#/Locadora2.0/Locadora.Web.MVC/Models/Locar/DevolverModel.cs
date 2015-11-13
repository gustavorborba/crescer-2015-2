using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models.Locar
{
    public class DevolverModel
    {
        public int IDJogo { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public DateTime? DataLocacao { get; set; }

        public DevolverModel(Jogo jogo)
        {
            this.Nome = jogo.Nome;
            this.DataLocacao = jogo.DataLocacao;
            this.Preco = jogo.CalcularPrecoFinal();
            this.IDJogo = jogo.IDJogo;
        }
    }
}