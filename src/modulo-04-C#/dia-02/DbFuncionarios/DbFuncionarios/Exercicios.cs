using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Exercicios
    {
       public static BaseDeDados baseDeDados = new BaseDeDados();
       public List<Funcionario> funcionarios = baseDeDados.Funcionarios;
        public IList<Funcionario> OrdenadoPorCargo()
        {
            //var ordenado = funcionarios.OrderByDescending(funcionario => funcionario.Cargo.Titulo).ToList();   descen
            var ordenado = funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList(); //            Ascend
            return ordenado;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var resultado = funcionarios.Where(funcionario => funcionario.Nome.Contains(nome)).OrderBy(funcionario => funcionario.Nome).ToList();
            return resultado;
        }

        public dynamic BuscaRapida(string nome)
        {
            var query = from funcionario in funcionarios
                        where funcionario.Nome == nome
                         select new {
                             Nome=funcionario.Nome,
                             Titulo=funcionario.Cargo.Titulo
                         };
            return query.ToList();

        }

        public IList<Funcionario> BuscarPorTurno(params object[] turnos)
        {
            var lista = funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).ToList();
            return lista;
        }

        public dynamic QtdFuncionariosPorTurno()
        {
            var query = from funcionario in funcionarios
                        select new
                        {
                            Turno = funcionario.TurnoTrabalho,
                            Quantidade = funcionarios.Count(func => func.TurnoTrabalho == funcionario.TurnoTrabalho)
        };
            return query.ToList();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var resultado = funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo).ToList();
            return resultado;
        }

        public IList<Funcionario> FiltarPorIdadeAprocimada(int idade)
        {
            var resultado=funcionarios.Where(funcionario => ((DateTime.Today.Year-funcionario.DataNascimento.Year) >= idade-5) &&
            ((DateTime.Today.Year - funcionario.DataNascimento.Year) <=idade+5)).ToList();
            return resultado;
        }

        public double SalarioMedio(TurnoTrabalho turno)
        {
            var qtdFuncionarios = funcionarios.Where(funcionario => turno.Equals(funcionario.TurnoTrabalho)).ToList();            
            double soma = qtdFuncionarios.Sum(funcionario => funcionario.Cargo.Salario);
            return soma / qtdFuncionarios.Count;

        }
    }
    
}
