using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
namespace LocadoraUI
{
    public class JogoUI
    {
        Banco banco = new Banco();
        public int CadastrarJogo()
        {
            string nome;
            string preco;
            int quantidade;
            string categoria;
            ECategoria enCategoria;
            EDisponibilidade disponivel;
            Console.WriteLine("Digite o nome do jogo");
            nome = Console.ReadLine();
            Console.WriteLine("Digite o Preco");
            preco = Console.ReadLine();
            Console.WriteLine("Digite a categoria");
            categoria = Console.ReadLine().ToUpper();
            try
            {
                enCategoria = (ECategoria)(Enum.Parse(typeof(ECategoria), categoria));
                Console.WriteLine("Digite a quantidade de jogos");
            }
            catch (Exception)
            {
                Console.WriteLine("Categoria Invalida");
                return 0;
            }
            quantidade = int.Parse(Console.ReadLine());
            disponivel = quantidade > 0 ? EDisponibilidade.SIM : EDisponibilidade.NAO;
            int sucesso=banco.CadastrarJogoEmXML(new Jogo(nome,preco,enCategoria,Convert.ToString(quantidade),disponivel));
            if(sucesso == 0)
            {
                Console.WriteLine("Cadastro realizado com sucesso");
            }
            else
            {
                Console.WriteLine("Jogo ja se encontra no banco de dados");
            }
            return 0;
        } 
        public void BucarPorNome()
        {
            string nome;
            Console.WriteLine("Digite o nome do jogo");
            nome = Console.ReadLine().ToUpper();
            var jogo=banco.BuscarPorNome(nome);
            try
            {
                Console.WriteLine("ID: " + jogo.ID);
                Console.WriteLine("Nome " + jogo.Nome);
                Console.WriteLine("Preco " + jogo.Preco);
                Console.WriteLine("Quantidade " + jogo.Quantidade);
            }
            catch (Exception)
            {
                Console.WriteLine("Jogo informado nao se encontra no banco de dados");
            }
        }
        public void EditarJogo()
        {
            string nome;
            string novaQuantidade;
            Console.WriteLine("Digite o nome do jogo");
            nome = Console.ReadLine();
            var jogo = banco.BuscarPorNome(nome);
            try
            {
                Console.WriteLine("O que gostaria de mudar");
                const int nomeJogo= 1;
                const int quantidade = 2;
                const int categoria = 3;
                int opcao;
                Console.WriteLine("1-Nome 2- Quantidade 3- Categoria");
                opcao = int.Parse(Console.ReadLine());
                switch (opcao)
                {
                    case nomeJogo:
                        Console.WriteLine("Digite o novo nome");
                        nome = Console.ReadLine();
                        jogo.Nome = nome;
                        break;
                    case quantidade:
                        Console.WriteLine("Digite a nova Quantidade");
                        novaQuantidade = Console.ReadLine();
                        jogo.Quantidade = novaQuantidade;
                        if(Convert.ToUInt32(novaQuantidade) == 0)
                        {
                            jogo.Disponivel = EDisponibilidade.NAO;
                        }
                        else
                        {
                            jogo.Disponivel = EDisponibilidade.SIM;
                        }
                        break;
                    case categoria:
                        Console.WriteLine("digite a nova categoria");
                        nome = Console.ReadLine().ToUpper();                        
                        jogo.Categoria = (ECategoria)Enum.Parse(typeof(ECategoria), nome);
                        break;
                    default:
                        break;
                }
                banco.EditarJogo(jogo);
            }
            catch (Exception)
            {
                Console.WriteLine("Conteudo Invalido");
            }
        }
    }
}
