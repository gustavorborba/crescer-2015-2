using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio;
namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {
        BancoDeDados banco;

        public int Atualizar(Jogo jogo)
        {
            using (banco = new BancoDeDados())
            {
                banco.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return banco.SaveChanges();
            }
        }
        public Jogo BuscarPorID(int id)
        {
            using(banco = new BancoDeDados())
            {
                var jogo = banco.Jogo.Find(id);
                return jogo;
            }
        }
        public IList<Jogo> BuscarPorNome(string nome)
        {
            using(banco=new BancoDeDados())
            {
                return banco.Jogo.Where(p => p.Nome.Contains(nome)).ToList();
            }
        }
        public IList<Jogo> BuscarTodos()
        {
            using(banco = new BancoDeDados())
            {
                return banco.Jogo.ToList();
            }
        }
        public int Criar(Jogo jogo)
        {
            using(banco = new BancoDeDados())
            {
                banco.Jogo.Add(jogo);
                return banco.SaveChanges();
            }
        }
        public int Excluir(int id)
        {
            using(banco= new BancoDeDados())
            {
                banco.Jogo.Remove(banco.Jogo.Find(id));
                return banco.SaveChanges();
            }
        }
    }
}
