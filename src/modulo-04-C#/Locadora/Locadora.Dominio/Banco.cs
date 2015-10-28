using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
     public class Banco
    {
        string local = @"C:\Users\Gustavo\Desktop\Crescer2\src\modulo-04-C#\Locadora\Locadora.Dominio\Arquivos\game_store.xml";
        public IList<Jogo> BuscarPorNome(string nome)
        {
            List<Jogo> ListaJogo = new List<Jogo>();
            XElement jogosBanco = XElement.Load(this.local);
            foreach (XElement item in jogosBanco.Elements("jogo"))
            {
                if(item.Element("nome").Value == nome)
                {
                    ListaJogo.Add(new Jogo(item.Attribute("id").Value, item.Element("nome").Value, item.Element("preco").Value, item.Element("categoria").Value));
                }

            }
            return ListaJogo;
        }
        public void  CadastrarJogoEmXML(Jogo jogo)
        {
            int id = XElement.Load(this.local).Elements().Max(it => Convert.ToInt32(it.Attribute("id").Value)) +1;
            XElement jogosBanco = XElement.Load(local);
            jogosBanco.Add(jogo.ToXml(id.ToString()));
            jogosBanco.Save(local);

        }
    }
}
