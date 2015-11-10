using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca.Model
{
    public class UsuarioModel
    {
        [Required(ErrorMessage ="Campo Email Obrigatorio")]
        public string Email { get; private set; }

        [Required(ErrorMessage = "Campo Senha Obrigatorio")]
        public string Senha { get; private set; }
        public string[] Autorizacao { get; private set; }
        public UsuarioModel(string email,string senha, string[] autorizacao)
        {
            this.Email = email;
            this.Senha = senha;
            this.Autorizacao = autorizacao;
        }
    }
}