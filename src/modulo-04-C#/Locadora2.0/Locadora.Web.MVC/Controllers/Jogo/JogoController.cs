using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Seguranca;

namespace Locadora.Web.MVC.Controllers.Jogo
{
    [Autorizador]
    public class JogoController : Controller
    {
        IJogoRepositorio repositorio = new JogoRepositorio();

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
            var jogo = repositorio.BuscarPorID(id);

            DescricaoModel descricao = new DescricaoModel();
            descricao.Nome = jogo.Nome;
            descricao.Categorias = jogo.Categoria;
            descricao.Selos = jogo.Selos;
            descricao.Imagem = jogo.ImagemUrl;
            descricao.Video = jogo.VideoUrl;
            descricao.Descricao = jogo.Descricao;
            descricao.ID = jogo.IDJogo;
            return View(descricao);
        }
        public ActionResult JogosDisponiveis(string nome)
        {
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
                    ID = item.IDJogo
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

        [Autorizador(Roles ="ADMIN")]
        [HttpGet]
        public ActionResult Editar(int? id)
        {
            if (id.HasValue)
            {
                var jogo = repositorio.BuscarPorID(Convert.ToInt32(id));
                var model = new DescricaoModel();
                model.Nome = jogo.Nome;
                model.Categorias = jogo.Categoria;
                model.Selos = jogo.Selos;
                model.Descricao = jogo.Descricao;
                model.Imagem = jogo.ImagemUrl;
                model.Video = jogo.VideoUrl;
                model.ID = jogo.IDJogo;
                model.Preco = jogo.Preco;
                return View(model);
            }
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(DescricaoModel model)
        {
            TempData["Mensagem"] = null;
            var nomeRepetido = repositorio.BuscarPorNome(model.Nome).Any() ? true : false;

            if (nomeRepetido && model.ID == 0)
            {
                TempData["Mensagem"] = "O jogo ja se encontra na base de dados";
                return View("Editar", model);
            }
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

                if (model.ID == 0)
                {
                    repositorio.Criar(jogo);
                    TempData["Mensagem"] = "Jogo Criado com Sucesso!";
                }
                else
                {
                    repositorio.Atualizar(jogo);
                    TempData["Mensagem"] = "Jogo Atualizado com Sucesso!";
                }
                return RedirectToAction("JogosDisponiveis", "Jogo");
            }
            TempData["Mensagem"] = "Ocorreu os seguintes erros: ";
            return View("Editar",model);
        }
    }
}
