using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio;
namespace Locadora.Web.MVC.Controllers.Jogo
{
    public class JogoController : Controller
    {
        IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Buscar(string nome)
        {

            var jogos = repositorio.BuscarPorNome(nome);

            return View();
        }
        public ActionResult Detalhes(int id)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
            var jogo = repositorio.BuscarPorId(id);

            DescricaoModel descricao = new DescricaoModel();
            descricao.Nome = jogo.Nome;
            descricao.Categorias = jogo.Categoria;
            descricao.Selos = jogo.Selos;
            descricao.Imagem = jogo.ImagemUrl;
            descricao.Video = jogo.VideoUrl;
            descricao.Descricao = jogo.Descricao;
            return View(descricao);
        }
        public ActionResult JogosDisponiveis(string nome)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
            var model = new RelatorioModel();
            var fazer = nome == null;
            List<Locadora.Dominio.Jogo> jogos;
            if (fazer)
            {
                jogos = repositorio.BuscarTodos().ToList();
            }
            else
            {
                jogos = repositorio.BuscarPorNome(nome).ToList();
            }
            if (!jogos.Any())
            {
                return View();
            }
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

        [HttpGet]
        public ActionResult Editar(int? id)
        {
            if (id.HasValue)
            {
                var jogo = repositorio.BuscarPorId(Convert.ToInt32(id));
                var model = new DescricaoModel();
                model.Nome = jogo.Nome;
                model.Categorias = jogo.Categoria;
                model.Selos = jogo.Selos;
                model.Descricao = jogo.Descricao;
                model.Imagem = jogo.ImagemUrl;
                model.Video = jogo.VideoUrl;
                model.ID = jogo.Id;
                model.Preco = jogo.Preco;
                return View(model);
            }
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(DescricaoModel model)
        {
            if (ModelState.IsValid)
            {
                var jogo = new Dominio.Jogo(model.ID);
                jogo.Nome = model.Nome;
                jogo.Categoria = model.Categorias;
                jogo.Descricao = model.Descricao;
                jogo.Selos = model.Selos;
                jogo.ImagemUrl = model.Imagem;
                jogo.VideoUrl = model.Video;
                jogo.Preco = model.Preco;
                repositorio.Atualizar(jogo);

                TempData["Mensagem"] = "Jogo Atualizado com Sucesso!";

                return RedirectToAction("JogosDisponiveis", "Jogo");
            }

            return View("Editar",model);
        }

        public ActionResult Criar()
        {
            return View("Editar");
        }

        public ActionResult SalvarCriacao(DescricaoModel model)
        {
            var jogo = new Dominio.Jogo();
            jogo.Nome = model.Nome;
            jogo.Categoria = model.Categorias;
            jogo.Descricao = model.Descricao;
            jogo.Selos = model.Selos;
            jogo.ImagemUrl = model.Imagem;
            jogo.VideoUrl = model.Video;
            jogo.Preco = model.Preco;
            repositorio.Criar(jogo);

            TempData["Mensagem"] = "";

            return RedirectToAction("JogosDisponiveis", "Jogo");
        }
    }
}