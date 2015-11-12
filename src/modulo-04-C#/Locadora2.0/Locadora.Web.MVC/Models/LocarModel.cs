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
        public int IDJogo { get; set; }
    }
}