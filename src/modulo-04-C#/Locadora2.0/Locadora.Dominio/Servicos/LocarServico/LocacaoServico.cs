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

        public bool LocacaoValida(string nomeCliente,int id)
        {
            bool locar = clienteRepositorio.PodeLocar(nomeCliente);
            var jogo = jogoRepositorio.BuscarPorID(id);
            if(locar && jogo.DataLocacao == null)
            {
                Locar(jogo,nomeCliente);
                return true;
            }
            return false;
        }
        public void Locar(Jogo jogo, string nome)
        {
            var cliente = clienteRepositorio.BuscarPorNome(nome).FirstOrDefault(p => p.Nome == nome);
            jogo.LocarPara(cliente);
            jogo.DataLocacao = DateTime.Now;
            jogoRepositorio.Atualizar(jogo);
        }
    }
}
