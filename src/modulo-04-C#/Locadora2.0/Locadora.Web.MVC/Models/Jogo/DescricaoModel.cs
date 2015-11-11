using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;
using System.ComponentModel.DataAnnotations;

namespace Locadora.Web.MVC.Models
{
    public class DescricaoModel 
    {
        [Required(ErrorMessage = "Campo Nome Obrigatorio")]
        [StringLength(250, MinimumLength = 5, ErrorMessage = "O nome deve ter entre 5 e 250 caracteres")]
        public string Nome { get; set; }

        [Range(1, int.MaxValue, ErrorMessage = "Categoria é Obrigatorio")]
        public  Categoria Categorias { get; set; }

        [Required(ErrorMessage = "Campo Descricao Obrigatorio")]
        public string Descricao { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }

        [Range(1, int.MaxValue, ErrorMessage = "Selo é Obrigatorio")]
        public Selo Selos { get; set; }

        public int ID { get; set; }
    }
}