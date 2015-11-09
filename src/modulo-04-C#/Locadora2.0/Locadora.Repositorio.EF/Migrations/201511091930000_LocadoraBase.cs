namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class LocadoraBase : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Categoria = c.Int(nullable: false),
                        Descricao = c.String(nullable: false),
                        Selos = c.Int(nullable: false),
                        VideoUrl = c.String(),
                        ImagemUrl = c.String(),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
        }
    }
}
