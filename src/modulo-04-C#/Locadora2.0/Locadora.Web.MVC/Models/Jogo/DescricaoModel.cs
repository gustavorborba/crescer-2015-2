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

        [Required]
        public  Categoria Categorias { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }

        [Required]
        public Selo Selos { get; set; }
        public decimal Preco { get; set; }
        public int ID { get; set; }
    }
}