﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
namespace LocadoraUI
{
    class Program
    {
        static void Main(string[] args)
        {
            Banco banco = new Banco();
            Console.WriteLine(banco.JogoMaisBarato());
            Console.Read();
        }
    }
}
