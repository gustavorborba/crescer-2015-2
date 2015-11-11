using Locadora.Dominio;
using Locadora.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Services.Security
{
    public class Validacao
    {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();

        public Usuario ValidarUsuario(string email, string senha)
        {
            var usuario = repositorio.BuscarPorEmail(email);
            if (usuario == null)
            {
                return null;
            }
            if (usuario.Senha == senha)
            {
                return usuario;
            }
            return null;
        }
        private string Criptografar()
        {
            return null;
        }
    }
}
