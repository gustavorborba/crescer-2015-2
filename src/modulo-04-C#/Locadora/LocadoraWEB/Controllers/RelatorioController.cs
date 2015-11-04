using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio;
namespace LocadoraWEB.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult JogosDisponiveis()
        {
            Relatorio relatorio = new Relatorio();
            var item = relatorio.ListarJogos();
            var model = new LocadoraWEB.Models.RelatorioModel
            {
                Jogos = item.ToList(),
                Quantidade = item.Count,
                JogoMaisCaro = relatorio.JogoMaisCaro(),
                JogoMaisBarato = relatorio.JogoMaisBarato(),
                ValorMedio = relatorio.ValorMedioJogo()
        };
            return View(model);
        }
    }
}