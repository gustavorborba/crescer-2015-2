using Locadora.Web.MVC.Seguranca.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult LoginUsuario(string email,string senha)
        {
            if(email == "Amon")
            {
                var usuarioLogado = new UsuarioModel(email, senha, new string[] { } );
                FormsAuthentication.SetAuthCookie(usuarioLogado.Email,true);
            }

            return RedirectToAction("Index", "Jogo");
        }
    }
}