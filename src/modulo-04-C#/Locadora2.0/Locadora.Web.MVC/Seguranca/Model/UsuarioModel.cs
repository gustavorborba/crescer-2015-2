using Locadora.Dominio;
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
        public string[] Permissoes { get; private set; }
        public UsuarioModel(Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Senha = usuario.Email;
            this.Permissoes = usuario.Permissoes.Select(p => p.Descricao).ToArray();
        }
    }
}