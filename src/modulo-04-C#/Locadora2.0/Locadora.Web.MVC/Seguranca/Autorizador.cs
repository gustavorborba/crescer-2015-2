using Locadora.Web.MVC.Seguranca.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Seguranca
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioModel usuarioLogado = ControleDeSessao.UsuarioLogado;
            if (usuarioLogado != null)
            {
                GenericIdentity myIdentity = new GenericIdentity(usuarioLogado.Email);
                GenericPrincipal principal = new GenericPrincipal(myIdentity, usuarioLogado.Permissoes);
                Thread.CurrentPrincipal = HttpContext.Current.User = principal;
                base.OnAuthorization(filterContext);
            }
        }
    }
}