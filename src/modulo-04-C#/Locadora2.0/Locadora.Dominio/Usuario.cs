using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario
    {
        public int IDUsuario { get; private set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public ICollection<Permissao> Permissoes { get; set; }
        public Usuario() { }
        public Usuario(int id)
        {
            this.IDUsuario = id;
        }
    }
}
