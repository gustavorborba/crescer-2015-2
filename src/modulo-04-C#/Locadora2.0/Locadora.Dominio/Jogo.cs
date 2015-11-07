﻿using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public decimal Preco { get; set; }

        public Categoria Categoria { get; set; }

        public string Descricao { get; set; }

        public Selo Selos { get; set; }

        public string VideoUrl { get; set; }

        public string ImagemUrl { get; set; }

        public int? IdClienteLocacao { get; private set; }
        
        public Jogo()
        {

        }

        public Jogo(int id, int? idClienteLocacao = null)
        {
            this.Id = id;
            this.IdClienteLocacao = idClienteLocacao;
        }

        public void LocarPara(Cliente cliente)
        {
            this.IdClienteLocacao = cliente.Id;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Selo:" + this.Selos);
            builder.AppendLine("Descricao" + this.Descricao);
            builder.AppendLine("ImagemURL" + this.ImagemUrl);
            builder.AppendLine("VideoURL" + this.VideoUrl);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Preco == jogoComp.Preco
                    && this.Categoria == jogoComp.Categoria
                    && this.IdClienteLocacao == jogoComp.IdClienteLocacao
                    && this.Selos == jogoComp.Selos
                    && this.Descricao == jogoComp.Descricao
                    && this.ImagemUrl == jogoComp.ImagemUrl
                    && this.VideoUrl == jogoComp.VideoUrl;
            }

            return false;
        }
    }
}