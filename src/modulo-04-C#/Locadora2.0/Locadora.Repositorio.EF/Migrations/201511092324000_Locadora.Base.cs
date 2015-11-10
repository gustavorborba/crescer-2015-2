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
                    IDCliente = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false),
                })
                .PrimaryKey(t => t.IDCliente);

            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    IDJogo = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    Categoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    Selos = c.Int(nullable: false),
                    VideoUrl = c.String(),
                    ImagemUrl = c.String(),
                    IDCliente = c.Int(),
                })
                .PrimaryKey(t => t.IDJogo)
                .ForeignKey("dbo.Cliente", t => t.IDCliente)
                .ForeignKey("dbo.Selo", t => t.Selos)
                .ForeignKey("dbo.Categoria", t => t.Categoria)
                .Index(t => t.IDCliente);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    IDSelo = c.Int(nullable: false, identity: true),
                    Selo = c.String(nullable: false, maxLength: 10),
                })
                .PrimaryKey(t => t.IDSelo);

            CreateTable(
                 "dbo.Categoria",
                 c => new
                 {
                    IDCategoria = c.Int(nullable: false, identity: true),
                    Categoria = c.String(nullable: false, maxLength: 10),
                 })
                .PrimaryKey(t => t.IDCategoria);
        }


        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IDCliente", "dbo.Cliente");
            DropForeignKey("dbo.Jogo","Selos","dbo.Selos");
            DropForeignKey("dbo.Jogo","Categoria","dbo.Categoria");
            DropIndex("dbo.Jogo", new[] { "IDCliente" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
        }
    }
}
