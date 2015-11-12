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
using Locadora.Dominio.Servicos.LocarServico;

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
            LocarModel model = new LocarModel(jogo);

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
            LocacaoServico locacao = new LocacaoServico(new JogoRepositorio(), new ClienteRepositorio());
            var locarJogo = locacao.LocacaoValida(locar.Nome,locar.IDJogo);
            if (locarJogo)
            {
                TempData["Mensagem"] = "Jogo locado com sucesso";
                return RedirectToAction("JogosDisponiveis", "Jogo");
            }
            TempData["Mensagem"] = "Jogo indisponivel ou cliente invalido";
            return RedirectToAction("Locar","Locacao", new { id = locar.IDJogo});
        }
        public ActionResult Devolver()
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