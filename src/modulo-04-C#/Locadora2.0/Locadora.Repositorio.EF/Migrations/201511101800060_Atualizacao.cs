namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Atualizacao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        IDPermissao = c.Int(nullable: false, identity: true),
                        Descricao = c.String(nullable: false, maxLength: 255),
                    })
                .PrimaryKey(t => t.IDPermissao);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        IDUsuario = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 255),
                        Email = c.String(nullable: false, maxLength: 255),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.IDUsuario);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IDUsuario = c.Int(nullable: false),
                        IDPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IDUsuario, t.IDPermissao })
                .ForeignKey("dbo.Usuario", t => t.IDUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IDPermissao, cascadeDelete: true)
                .Index(t => t.IDUsuario)
                .Index(t => t.IDPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IDPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IDUsuario", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "IDPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IDUsuario" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }
    }
}
