using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models.Login
{
    public class LoginModel
    {
        [Required(ErrorMessage ="Campo Obrigatorio")]
        public string Email { get; set; }
        [Required(ErrorMessage ="Campo Obrigatorio")] 
        public string Senha { get; set; }
    }
}