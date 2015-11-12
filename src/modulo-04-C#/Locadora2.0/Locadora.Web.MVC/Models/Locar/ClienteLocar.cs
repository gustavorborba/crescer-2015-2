using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ClienteLocar
    {
        public int IDJogo { get; set; }
        [Required(ErrorMessage ="Campo Obrigatorio")]
        public string Nome { get; set; }
    }
}