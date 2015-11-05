using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers.Jogo
{
    public class BuscarJogosController : Controller
    {
        // GET: BuscarJogos
        public ActionResult Buscar(string nome)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
            var jogos = repositorio.BuscarPorNome(nome);


            return View();
        }
    }
}