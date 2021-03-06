﻿using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Repositorio;
namespace Locadora.Repositorio.EF
{
    public class UsuarioRepositorio :  IUsuarioRepositorio
    {
        BancoDeDados banco;

        public Usuario BuscarPorEmail(string email)
        {
            using(banco=new BancoDeDados())
            {
                return banco.Usuario.Include("Permissoes").FirstOrDefault(u => u.Email == email);
            }
        }
    }
}
