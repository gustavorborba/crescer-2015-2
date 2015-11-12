namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Refactoring4 : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Jogo", "DataDevolucao");
        }
    }
}
