using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ValidarUsuario
    {
        private IUsuarioRepositorio usuarioRepositorio;
        private IServicoCriptografia servicoCriptografia;

        public ValidarUsuario(IUsuarioRepositorio usuarioRepositorio, IServicoCriptografia servicoCriptografia)
        {
            this.usuarioRepositorio = usuarioRepositorio;
            this.servicoCriptografia = servicoCriptografia;
        }

        public Usuario Validar(string email, string senha)
        {
            var usuario = usuarioRepositorio.BuscarPorEmail(email);
            if (usuario == null)
            {
                return null;
            }
            senha = servicoCriptografia.Criptografar(senha);
            if (usuario.Senha == senha)
            {
                return usuario;
            }
            return null;
        }
    }
}
