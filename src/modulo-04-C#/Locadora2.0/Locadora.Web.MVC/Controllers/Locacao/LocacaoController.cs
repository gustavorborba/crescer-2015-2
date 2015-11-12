using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Models.Login;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;

namespace Locadora.Web.MVC.Controllers.Locacao
{
    public class LocacaoController : Controller
    {
        // GET: Locacao
        [HttpGet]
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
        [HttpGet]
        public ActionResult Locar(int id)
        {
            ClienteLocar locar = new ClienteLocar();
            locar.IDJogo = id;
            return View(locar);
        }
        [HttpPost]
        public ActionResult SalvarLocacao(ClienteLocar locar)
        {

            return View();
        }
        public JsonResult ClienteAutocomplete(string term)
        {
            IList<Cliente> ClienteEncontrados = ObterJogosPorFiltro(term);

            var json = ClienteEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Cliente> ObterJogosPorFiltro(string nome)
        {
            IClienteRepositorio clienteRepositorio = new  ClienteRepositorio();

            if (string.IsNullOrEmpty(nome))
                return clienteRepositorio.BuscarTodos();
            else
            {
                return clienteRepositorio.BuscarPorNome(nome);
            }
                
        }
    }
}