using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> ListaJogos;
        public int TotalJogos { get; set; }
        public string MaisCaro { get; set; }
        public string MaisBarato { get; set; }

        public RelatorioModel()
        {
            ListaJogos = new List<JogoModel>();
        }
    }
}