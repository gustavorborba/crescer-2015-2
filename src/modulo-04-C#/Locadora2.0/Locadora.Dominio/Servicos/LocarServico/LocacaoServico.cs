using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos.LocarServico
{
    public class LocacaoServico
    {
        private IClienteRepositorio clienteRepositorio;
        private IJogoRepositorio jogoRepositorio;

        public LocacaoServico(IJogoRepositorio jogoRepositorio, IClienteRepositorio clienteRepositorio)
        {
            this.clienteRepositorio = clienteRepositorio;
            this.jogoRepositorio = jogoRepositorio;
        }

        public bool LocacaoValida(string nome,int id)
        {
            bool locar = clienteRepositorio.PodeLocar(nome);
            var jogo = jogoRepositorio.BuscarPorID(id);
            var cliente = clienteRepositorio.BuscarPorNome(nome).FirstOrDefault(p => p.Nome == nome);
            bool clienteValido = cliente == null ? false : true;
            if (locar && jogo.DataLocacao == null && clienteValido)
            {
                Locar(jogo,cliente);
                return true;
            }
            return false;
        }
        public void Locar(Jogo jogo, Cliente cliente)
        {
            jogo.LocarPara(cliente);
            jogo.DataLocacao = DateTime.Now;
            jogoRepositorio.Atualizar(jogo);
        }
        public int Devolver(int id)
        {
            return 0;
        }
    }
}
