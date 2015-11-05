using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;
namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis()
        {
           IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

           var jogos = repositorio.BuscarTodos().ToList();

            var model = new RelatorioModel();
            foreach (var item in jogos)
            {
                JogoModel jogo = new JogoModel()
                {
                    Nome = item.Nome,
                    Preco = item.Preco,
                    Categoria = item.Categoria.ToString(),
                    ID = item.Id
                };
                model.ListaJogos.Add(jogo);
            }
            decimal barato = model.ListaJogos.Min(it => it.Preco);
            model.MaisBarato = model.ListaJogos.FirstOrDefault(it => it.Preco == barato).Nome;
            decimal caro = model.ListaJogos.Max(it => it.Preco);
            model.MaisCaro = model.ListaJogos.FirstOrDefault(it => it.Preco == caro).Nome;
            model.TotalJogos = model.ListaJogos.Count;
            return View(model);
        }
    }
}