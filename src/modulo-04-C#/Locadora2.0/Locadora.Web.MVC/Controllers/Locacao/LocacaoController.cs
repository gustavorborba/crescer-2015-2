using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.EF;

namespace Locadora.Web.MVC.Controllers.Locacao
{
    public class LocacaoController : Controller
    {
        // GET: Locacao
        public ActionResult LocarPartial(int id)
        {
            JogoRepositorio repositorio = new JogoRepositorio();
            var jogo = repositorio.BuscarPorID(id);

            LocarModel model = new LocarModel();
            model.Nome = jogo.Nome;
            model.IDJogo = jogo.IDJogo;
            model.Imagem = jogo.ImagemUrl;
            if(jogo.Selos == Dominio.Selo.OURO)
            {
                model.DataEntrega = DateTime.Now.AddDays(1);
                model.Preco = 15;
            }
            if(jogo.Selos == Dominio.Selo.PRATA)
            {
                model.DataEntrega = DateTime.Now.AddDays(2);
                model.Preco = 10;
            }
            if(jogo.Selos == Dominio.Selo.BRONZE)
            {
                model.DataEntrega = DateTime.Now.AddDays(3);
                model.Preco = 5;
            }

            return View(model);
        }

        public ActionResult Locar(int id)
        {


            return View();
        }
        public ActionResult SalvarLocacao()
        {

            return View();
        }
    }
}