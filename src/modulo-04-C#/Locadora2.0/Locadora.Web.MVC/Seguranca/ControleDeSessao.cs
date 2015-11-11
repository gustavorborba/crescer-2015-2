using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using Locadora.Web.MVC.Seguranca.Model;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Seguranca
{
    public class ControleDeSessao
    {
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";
        public static UsuarioModel UsuarioLogado
        {
            get
            {
                return HttpContext.Current.Session[USUARIO_LOGADO] as UsuarioModel;
            }
        }
        public static void CriarSessaoDeUsuario(Usuario usuarioAutenticado)
        {
            var usuarioLogado = new UsuarioModel(usuarioAutenticado);
            FormsAuthentication.SetAuthCookie(usuarioLogado.Email, true);
            HttpContext.Current.Session[USUARIO_LOGADO] = usuarioLogado;
        }
    }
}