using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;
namespace LocadoraWEB.Models
{
    public class RelatorioModel
    {
        public List<Jogo> Jogos { get;set; }
        public int Quantidade { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }
        public decimal ValorMedio { get; set; }
    }
}