using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace inventarioMVP.MVP.Modelo.Dataclasses

{
    public class Producto
    {
        private int id;
        private string nombre;
        private string descripcion;
        private double precio;
        private int idCategoria;

        public Producto()
        {
        }

        public Producto(string N, string D, double P, int IdCat, int IdProd)
        {
            id = IdProd;
            nombre = N;
            descripcion = D;
            precio = P;
            idCategoria = IdCat;

        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get =>descripcion; set =>descripcion =value; }

        public double Precio { get =>precio; set =>precio = value; }
        public int IdCategoria { get =>idCategoria; set =>idCategoria=value; }
        public int IdProducto { get =>id; set => id=value; }
       

         public string ToStringComplex()
        {
            return "Producto:" + Nombre + "\n" +
                   "Precio: " + Precio + "\n" +
                   "Descripcion: " + Descripcion + "\n" +
                   "Id de categoría" + IdCategoria + "\n" +
                   "Id de producto" + IdProducto;

        }
        public string ToStringSimple()
        {
            return "  Id  " + IdProducto + " "  + Nombre;
                   

        }
    }
}
