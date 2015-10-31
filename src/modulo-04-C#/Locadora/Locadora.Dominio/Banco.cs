using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Banco
    {
        string local = @"C:\Users\Gustavo\Desktop\Crescer2\src\modulo-04-C#\Locadora\Locadora.Dominio\Arquivos\game_store.xml";
        public Jogo BuscarPorNome(string nome)
        {
            var jogosBanco = XElement.Load(this.local).Elements("jogo").FirstOrDefault(it => it.Element("nome").Value.ToUpper() == nome.ToUpper());
            try
            {
                Jogo jogo = new Jogo(Convert.ToInt32(jogosBanco.Attribute("id").Value), jogosBanco.Element("nome").Value, jogosBanco.Element("preco").Value,
                                       (ECategoria)(Enum.Parse(typeof(ECategoria), jogosBanco.Element("categoria").Value)),
                                        jogosBanco.Element("quantidade").Value,
                                       (EDisponibilidade)(Enum.Parse(typeof(EDisponibilidade), jogosBanco.Element("disponivel").Value)));
                return jogo;
            }
            catch (Exception)
            {
                return null;
            }
        }

        public int CadastrarJogoEmXML(Jogo jogo)
        {
            var repetido = XElement.Load(this.local).Elements().FirstOrDefault(it => it.Element("nome").Value.ToUpper() == jogo.Nome.ToUpper());
            if(repetido == null)
            {
                var jogosBanco = XElement.Load(local);
                jogosBanco.Add(jogo.ToXml());
                jogosBanco.Save(local);
                return 0;
            }
            return -1;
        }

        public void EditarJogo(Jogo jogo)
        {
            var jogosBanco = XElement.Load(this.local);
            foreach (XElement jogos in jogosBanco.Elements("jogo").Where(it => Convert.ToInt32(it.Attribute("id").Value) == jogo.ID))
            {
                jogos.ReplaceWith(jogo.ToXml());
            }
            jogosBanco.Save(local);
        }
        public int ProcimoID()
        {
            return XElement.Load(this.local).Elements().Max(it => Convert.ToInt32(it.Attribute("id").Value)) + 1;
        }
    }
}

        