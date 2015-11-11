using Locadora.Web.MVC.Seguranca.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Locadora.Web.MVC.Models.Login;
using Services.Security;
namespace Locadora.Web.MVC.Seguranca
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult LoginUsuario(LoginModel model)
        {
            var validar = new Validacao();
            if (ModelState.IsValid)
            {
                var usuarioAtual = validar.ValidarUsuario(model.Email,model.Senha);
                if(usuarioAtual != null)
                {
                    ControleDeSessao.CriarSessaoDeUsuario(usuarioAtual);
                    return RedirectToAction("Index","Jogo");
                }
            }
            return View("Index", model);
        }
        public ActionResult Encerrar()
        {
            ControleDeSessao.Encerrar();
            return RedirectToAction("Index", "Login");
        }
    }
}