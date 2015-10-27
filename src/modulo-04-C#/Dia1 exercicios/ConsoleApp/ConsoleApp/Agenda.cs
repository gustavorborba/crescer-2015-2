using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos=new List<Contato>();

        public void AdicionarContato(Contato cont)
        {
            contatos.Add(cont);
        }

        public void RemoverContatoPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }
        public List<Contato> ListarContatos()
        {
            return contatos;
        }
        public List<Contato> ListarContatosOrdenados()
        {
            var ordenado = contatos;
            ordenado.Sort((a, b) => a.Nome.CompareTo(b.Nome)); //não consegui fazer na mão à tempo, deixei por enquanto
            return ordenado;
        }
        public int GetQuantidadeContatos()
        {
            return contatos.Count;
        }
        public void RemoverPorNumero(int numero)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numero)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }
    }
}
