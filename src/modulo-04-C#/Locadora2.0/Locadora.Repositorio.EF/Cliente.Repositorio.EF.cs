﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        BancoDeDados banco;

        public IList<Cliente> BuscarPorNome(string nome)
        {
            using(banco=new BancoDeDados())
            {
                return banco.Cliente.Where(c => c.Nome == nome).ToList();
            }
        }
    }
}