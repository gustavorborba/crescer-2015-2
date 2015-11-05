using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;

namespace Locadora.Web.MVC.Controllers.Jogo
{
    public class DescricaoController : Controller
    {
        // GET: Descricao
        public ActionResult Detalhes(int id)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
            var jogo = repositorio.BuscarPorId(id);

            DescricaoModel descricao = new DescricaoModel();
            descricao.Nome = jogo.Nome;
            descricao.Categoria = jogo.Categoria.ToString();
            descricao.Selo = jogo.Selos.ToString();
            descricao.Imagem = jogo.ImagemUrl;
            descricao.Video = jogo.VideoUrl;
            descricao.Descricao = jogo.Descricao;
            return View(descricao);
        }
    }
}