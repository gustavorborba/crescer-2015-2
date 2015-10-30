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
        public IList<Jogo> BuscarPorNome(string nome)
        {
            List<Jogo> ListaJogo = new List<Jogo>();
            var jogosBanco = XElement.Load(this.local);
            foreach (XElement item in jogosBanco.Elements("jogo").Where(it => it.Element("nome").Value==nome))
            {
                ListaJogo.Add(new Jogo(Convert.ToInt32(item.Attribute("id").Value), item.Element("nome").Value, item.Element("preco").Value, (ECategoria)(Enum.Parse(typeof(ECategoria), item.Element("categoria").Value))));
            }
            return ListaJogo;
        }

        public void  CadastrarJogoEmXML(Jogo jogo)
        {
            XElement jogosBanco = XElement.Load(local);
            jogosBanco.Add(jogo.ToXml());
            jogosBanco.Save(local);
        }

        public void EditarJogo(Jogo jogo)
        {
            var jogosBanco = XElement.Load(this.local);
            foreach (XElement jogos in jogosBanco.Elements("jogo").Where(it => Convert.ToInt32(it.Attribute("id").Value) == jogo.ID))
            {
                jogos.ReplaceAll(jogo.ToXml());
            }
            jogosBanco.Save(local);
        }
        public int ProcimoID()
        {
            return  XElement.Load(this.local).Elements().Max(it => Convert.ToInt32(it.Attribute("id").Value)) + 1;
        }

        public void GerarRelatiorio()
        {
            string caminho = @"C:\Users\Gustavo\Desktop\Crescer2\src\modulo-04-C#\Locadora\Locadora.Dominio\Arquivos\relatorio.txt";
            using (var file = new StreamWriter(caminho, false))
            {
                file.WriteLine("                              LOCADORA NUNES GAMES                              ");
                file.Write(DateTime.Now.ToString("dd:MM:yyyy"));
                file.Write("                                                            ");
                file.Write(DateTime.Now.ToString("HH:mm:ss"));
            }   
        }

        public int QuantidadeJogos()
        {
            return XElement.Load(this.local).Nodes().Count();
        }

        public double ValorMedioJogo()
        {
            var quantidade = QuantidadeJogos();
            return XElement.Load(this.local).Elements().Sum(it => Convert.ToDouble(it.Element("preco").Value))/quantidade;
        }
        public string JogoMaisBarato()
        {
            string maisCaro = XElement.Load(this.local).Elements().Min(it => double.Parse(it.Element("preco").Value)).ToString();
            var jogo = XElement.Load(this.local).Elements("jogo").FirstOrDefault(it => it.Element("preco").Value == maisCaro);
            return jogo.Element("nome").Value;
            
        }
    }
}

//            LOCADORA NUNES GAMES
//28 / 10 / 2015                                                              14:27:35
//                              Relatório de jogos

//================================================================================
//ID       Categoria Nome                          Preço Disponivel
//1        RPG Chrono Trigger R$ 60                SIM
//2        CORRIDA Top Gear R$ 20                SIM
//3        AVENTURA Super Metroid R$ 30                NÃO
//--------------------------------------------------------------------------------
//Quantidade total de jogos: 3
//Quantidade de jogos disponíveis: 2
//Valor médio por jogo: R$ 36,67
//Jogo mais caro:
//            Chrono Trigger
//Jogo mais barato:
//            Top Gear
//================================================================================