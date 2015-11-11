﻿using Locadora.Web.MVC.Seguranca.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Locadora.Web.MVC.Models.Login;
using Locadora.Dominio.Servicos;
namespace Locadora.Web.MVC.Seguranca
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult LoginUsuario(LoginModel model)
        {
            
            if (ModelState.IsValid)
            {
               // ValidarUsuario validar = new ValidarUsuario();
                //apenas teste para conferir, depois será retirado;
                string usuarioAtual = 
                //var usuarioAtual = validar.ValidarUsuario(model.Email,model.Senha);
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