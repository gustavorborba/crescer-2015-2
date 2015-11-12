using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo 
    {
        public int IDJogo { get; private set; }
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public string Descricao { get; set; }

        public Selo Selos { get; set; }

        public string VideoUrl { get; set; }

        public string ImagemUrl { get; set; }

        public Cliente Cliente { get; private set; }
        
        public DateTime DataDevolucao { get; set; }

        public Jogo()
        {

        }

        public Jogo(int id)
        {
            this.IDJogo = id;
        }

        public void LocarPara(Cliente cliente)
        {
            this.Cliente = cliente;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.IDJogo);
            builder.AppendLine("Nome: " + this.Nome);
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

                return this.IDJogo == jogoComp.IDJogo
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Cliente.IDCliente == jogoComp.Cliente.IDCliente
                    && this.Selos == jogoComp.Selos
                    && this.Descricao == jogoComp.Descricao
                    && this.ImagemUrl == jogoComp.ImagemUrl
                    && this.VideoUrl == jogoComp.VideoUrl;
            }

            return false;
        }
    }
}
