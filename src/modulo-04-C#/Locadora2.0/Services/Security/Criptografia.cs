using Locadora.Dominio;
using Locadora.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Servicos;
namespace Services.Security
{
    public class Cripografar : IServicoCriptografia
    {
        public string Criptografar(string senha)
        { 
            senha += "%$CWI_CRESCER_2015-2&%";
            return GerarMd5(senha);
        }

        public string GerarMd5(string texto)
        {
            System.Security.Cryptography.MD5 md5 = System.Security.Cryptography.MD5.Create();

            byte[] inputBytes = Encoding.ASCII.GetBytes(texto);
            byte[] hash = md5.ComputeHash(inputBytes);
            var sb = new StringBuilder();

            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }

            return sb.ToString();
        }
    }
}
