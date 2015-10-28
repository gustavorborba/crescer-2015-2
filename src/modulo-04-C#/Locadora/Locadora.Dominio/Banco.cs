﻿using System;
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
            var jogosBanco = XElement.Load(this.local);
            foreach (XElement item in jogosBanco.Elements("jogo").Where(it => it.Element("nome").Value==nome))
            {
                 ListaJogo.Add(new Jogo(Convert.ToInt32(item.Attribute("id").Value), item.Element("nome").Value, item.Element("preco").Value, item.Element("categoria").Value));
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
    }
}
