using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public interface IServicoCriptografia
    {
        string Criptografar(string senha);
        string GerarMd5(string texto);
    }
}
