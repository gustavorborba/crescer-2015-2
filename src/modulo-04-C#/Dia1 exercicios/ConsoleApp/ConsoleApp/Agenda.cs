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
            var indexSeremRemovidos = new List<int>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    indexSeremRemovidos.Add(i);
                }
            }
            foreach (var indice in indexSeremRemovidos)
            {
                contatos.RemoveAt(indice);
            }
        }
        public List<Contato> ListarContatos()
        {
            return contatos;
        }
        public List<Contato> ListarContatosOrdenados()
        {
            var ordenado = contatos;
            ordenado.Sort((a, b) => a.Nome.CompareTo(b.Nome));
            return ordenado;
        }
        public int GetQuantidadeContatos()
        {
            return contatos.Count;
        }
        public void RemoverPorNumero(int numero)
        {
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numero) {
                    contatos.RemoveAt(i);
                }
            }
        }
    }
}
