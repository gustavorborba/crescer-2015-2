using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers.Jogo
{
    public class JogoController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Buscar(string nome)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
            var jogos = repositorio.BuscarPorNome(nome);


            return View();
        }
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
    }
}