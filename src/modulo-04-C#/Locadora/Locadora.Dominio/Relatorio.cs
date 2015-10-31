using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Relatorio
    {
        string local = @"C:\Users\Gustavo\Desktop\Crescer2\src\modulo-04-C#\Locadora\Locadora.Dominio\Arquivos\game_store.xml";
        public int QuantidadeJogos()
        {
            return XElement.Load(this.local).Nodes().Count();
        }

        public double ValorMedioJogo()
        {
            var quantidade = QuantidadeJogos();
            return XElement.Load(this.local).Elements().Sum(it => Convert.ToDouble(it.Element("preco").Value)) / quantidade;
        }
        public string JogoMaisCaro()
        {
            string maisCaro = XElement.Load(this.local).Elements().Max(it => double.Parse(it.Element("preco").Value.Replace(".", ","))).ToString();
            var jogo = XElement.Load(this.local).Elements("jogo").FirstOrDefault(it => it.Element("preco").Value == maisCaro);
            return jogo.Element("nome").Value;
        }

        public string JogoMaisBarato()
        {
            string maisCaro = XElement.Load(this.local).Elements().Min(it => double.Parse(it.Element("preco").Value.Replace(".", ","))).ToString();
            var jogo = XElement.Load(this.local).Elements("jogo").FirstOrDefault(it => it.Element("preco").Value == maisCaro);
            return jogo.Element("nome").Value;
        }

        public IList<Jogo> ListarJogos()
        {
            List<Jogo> jogoLista = new List<Jogo>();
            var asd = XElement.Load(local).Elements();
            foreach (var f in asd)
            {
                jogoLista.Add(new Jogo(
                         Convert.ToInt32(f.Attribute("id").Value),
                          f.Element("nome").Value,
                         f.Element("preco").Value,
                          (ECategoria)Enum.Parse(typeof(ECategoria), f.Element("categoria").Value),
                          f.Element("quantidade").Value, 
                          (EDisponibilidade)(Enum.Parse(typeof(EDisponibilidade), 
                          f.Element("disponivel").Value))));
            };
            return jogoLista;
        }

        public static string Truncate(string jogo, int length)
        {
            if (jogo.Length > length)
            {
                jogo = jogo.Substring(0, length);
            }
            return jogo;
        }
        public string Espacamento(string jogo, int length)
        {
            int espaco = length - jogo.Length;
            int espacamento = espaco / 2 + jogo.Length;
            return jogo.PadRight(length);

        }
        public void GerarRelatiorio()
        {
            var lista = ListarJogos();
            const string caminho = @"C:\Users\Gustavo\Desktop\Crescer2\src\modulo-04-C#\Locadora\Locadora.Dominio\Arquivos\relatorio.txt";
            const string cabecalho = "                              LOCADORA NUNES GAMES                              ";
            string data = (DateTime.Now.ToString("dd:MM:yyyy"));
            const string espaco = ("                                                            ");
            string horario = (DateTime.Now.ToString("HH:mm:ss"));
            const string relatorioJogos = "                               Relatorio de jogos                              ";
            const string espacamento = "================================================================================";
            const string segundoEspacamento = "--------------------------------------------------------------------------------";
            const string jogos = "ID     CATEGORIA         NOME                                     PRECO   Disponivel";
            string quebraLinha = Environment.NewLine;
            string[] jogo = new string[lista.Count];
            for(int i = 0; i < lista.Count; i++)
            {
                jogo[i] = string.Format("{0}\t{1}\t{2}\t  R$:{3}   {4}",Espacamento(Truncate(Convert.ToString(lista[i].ID), 7),7), 
                                                              Espacamento(Truncate(Convert.ToString(lista[i].Categoria),10),10),
                                                              Espacamento(Truncate(lista[i].Nome,38),38), 
                                                              Espacamento(Truncate(lista[i].Preco,5),5),
                                                              Espacamento(Truncate(Convert.ToString(lista[i].Disponivel),3),3));
            }
            string jogoMaisCaro = ("Jogo Mais Caro"+quebraLinha + "\t"+JogoMaisCaro());
            string jogoMaisBarato = ("Jogo mais Barato"+quebraLinha + "\t" + JogoMaisBarato());
            using (var file = new StreamWriter(caminho, false))
            {
                file.WriteLine(cabecalho);
                file.Write(data);
                file.Write(espaco);
                file.WriteLine(horario);
                //file.Write(quebraLinha);
                file.WriteLine(relatorioJogos);
                //file.Write(quebraLinha);
                file.WriteLine(espacamento);
                file.WriteLine(jogos);
                for (int i = 0; i < jogo.Length; i++)
                {
                    file.WriteLine(jogo[i]);
                }
                file.WriteLine(segundoEspacamento);
                file.WriteLine(jogoMaisCaro);
                file.WriteLine(jogoMaisBarato);
                file.WriteLine(espacamento);
            }
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