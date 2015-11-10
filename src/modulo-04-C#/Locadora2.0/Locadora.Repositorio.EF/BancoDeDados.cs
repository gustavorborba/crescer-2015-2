using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORADOIS")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }

        class JogoMap : EntityTypeConfiguration<Jogo>
        {
            public JogoMap()
            {
                ToTable("Jogo");
                HasKey(p => p.IDJogo);
                Property(p => p.Nome).IsRequired().HasMaxLength(255);
                Property(p => p.Descricao).IsRequired();
                Property(p => p.Categoria).IsRequired();
                Property(p => p.Selos).IsRequired();
                Property(p => p.ImagemUrl).IsOptional();
                Property(p => p.VideoUrl).IsOptional();
                HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IDCliente"));
            }
        }
        class ClienteMap : EntityTypeConfiguration<Cliente>
        {
            public ClienteMap()
            {
                ToTable("Cliente");
                HasKey(p => p.IDCliente);

                Property(p => p.Nome).IsRequired().HasMaxLength(255);
            }
        }
    }
}
