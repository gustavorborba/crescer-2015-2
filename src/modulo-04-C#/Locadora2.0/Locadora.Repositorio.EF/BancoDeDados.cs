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
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
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
                Property(p => p.DataLocacao).IsOptional();
                Property(p => p.IDCliente).IsOptional();
                HasOptional(p => p.Cliente).WithMany().HasForeignKey(p => p.IDCliente);
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

        class PermissaoMap : EntityTypeConfiguration<Permissao>
        {
            public PermissaoMap()
            {
                ToTable("Permissao");
                HasKey(p => p.IDPermissao);
                Property(p => p.Descricao).IsRequired().HasMaxLength(255);
            }
        }

        class UsuarioMap : EntityTypeConfiguration<Usuario>
        {
            public UsuarioMap()
            {
                ToTable("Usuario");
                HasKey(p => p.IDUsuario);
                Property(p => p.Nome).IsRequired().HasMaxLength(255);
                Property(p => p.Email).IsRequired().HasMaxLength(255);

                HasMany(u => u.Permissoes).WithMany(p => p.Usuarios).Map(m =>
                {
                    m.ToTable("UsuarioPermissao");
                    m.MapLeftKey("IDUsuario");
                    m.MapRightKey("IDPermissao");
                });
            }
        }
    }
}
