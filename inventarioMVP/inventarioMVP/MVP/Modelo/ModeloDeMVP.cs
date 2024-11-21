using inventarioMVP.MVP.Modelo.Dataclasses;
using inventarioMVP.MVP.Repositories;
using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace inventarioMVP.Modelo
{
    internal class ModeloDeMVP
    {

        Rcategoria Rcat = new();
        Rproductos Rprod = new();


      
        public List<string> SacarNombreCategorías()
        {
            List<string> nombres = new();
            foreach (Categoria i in Rcat.GetAll())
            { nombres.Add(i.Nombre); }
            return nombres;
        }              
        public List<string> SacarNombreProdxCat(string nombre)
        {
            List<string> nombres = new();
            int Id = SacarIdXNombreCat(nombre);
            List<Producto> filtrada = Rprod.GetAll().Where(c => c.IdCategoria == Id).ToList();
            foreach (Producto p in filtrada)
            {
                nombres.Add(p.Nombre);
            }
            return nombres;
        }
        public int SacarIdXNombreCat(string nombre)
        {
            int id = -1;
            for (int i = 0; i < Rcat.GetAll().Count; i++)
            {
                if (nombre.Equals(Rcat.GetAll()[i].Nombre))
                {
                    id = Rcat.GetAll()[i].Id;
                }
            }
            return id;
        }
        public string SacarNombreXidCat(int id)
        {
            string nombre = "";
            for (int i = 0; i < Rcat.GetAll().Count; i++)
            {
                if (id == Rcat.GetAll()[i].Id)
                {
                    nombre = Rcat.GetAll()[i].Nombre;
                }
            }
            return nombre;
        }
        public int SacarIdXNombreProd(string nombre)
        {
            int id = -1;
            for (int i = 0; i < Rprod.GetAll().Count; i++)
            {
                if (nombre.Equals(Rprod.GetAll()[i].Nombre))
                {
                    id = Rprod.GetAll()[i].IdProducto;
                }
            }
            return id;
        }
        public Producto APresentadorProd(string nombre) {
            int id = SacarIdXNombreProd(nombre);
            return Rprod.Get(id);
        }
        public Categoria AñadirCategoria(string nombre)
        {
            Categoria c = null;
            if (!String.IsNullOrEmpty(nombre))
            {
                int id = SacarIdXNombreCat(nombre);
                c = Rcat.Get(id);
                if (c == null)
                {
                    c = new Categoria();
                    c.Id = SacarUltimoIdCat() + 1;
                    c.Nombre = nombre;
                    Rcat.Add(c);
                }
            }
            return c;
        }
        public Categoria ModificarCategoria(string nomNuevo, string nomAntiguo) {
            if (!String.IsNullOrEmpty(nomNuevo))
            {
                int id = SacarIdXNombreCat(nomAntiguo);
                Categoria c = Rcat.Get(id);
                if (c == null) { return null; }
                else {
                    c.Nombre = nomNuevo;
                    Rcat.Update(c);
                    return c;
                }
            }
            else { return null; }
        }
        public Categoria EliminarCategoria(string nombre)
        {
            int Id = SacarIdXNombreCat(nombre);
            Categoria categoria = Rcat.Get(Id);
            Rcat.Remove(categoria);
            return categoria;
        }
        public Producto AñadirProducto(string nombreNuevo, string precio, string descripcion, string categoria)
        {
            Producto p = null;
            if (!String.IsNullOrEmpty(nombreNuevo) || !String.IsNullOrEmpty(precio)
                || !String.IsNullOrEmpty(descripcion) || !String.IsNullOrEmpty(categoria))
            {
                p = Rprod.GetAll().Find(p => p.Nombre.Equals(nombreNuevo));
                if (p == null)
                {
                    p = new();
                    p.Nombre = nombreNuevo;
                    p.Precio = Double.Parse(precio);
                    p.IdProducto = SacarUltimoIdProd() + 1;
                    p.Descripcion = descripcion;
                    int Id = SacarIdXNombreCat(categoria);
                    if (Id != -1)
                    {
                        p.IdCategoria = Id;
                        Rprod.Add(p);
                    }
                }
            }
            return p;
        }
        public Producto ModificarProducto(string nombreAntiguo, string nombreNuevo, string precio, string descripcion, string categoria) {
            Producto? p = Rprod.GetAll().Find(p => p.Nombre.Equals(nombreAntiguo));
            if (p != null)
            {
                Categoria? c = Rcat.GetAll().Find(c => c.Id.Equals(p.IdCategoria));
                if (c != null)
                {
                    if (!String.IsNullOrEmpty(nombreNuevo)) p.Nombre = nombreNuevo;
                    if (!String.IsNullOrEmpty(precio)) p.Precio = Double.Parse(precio);
                    if (!String.IsNullOrEmpty(descripcion)) p.Descripcion = descripcion;
                    if (!String.IsNullOrEmpty(categoria)) p.IdCategoria = c.Id;
                    Rprod.Update(p);
                    return p;
                }
            }
            return null;
        }
        public Producto EliminarProducto(string nombre)
        {
            int Id = SacarIdXNombreProd(nombre);
            Producto p = Rprod.Get(Id);
            Rprod.Remove(p);
            return p;
        }

        /* Método usado en entorno de pruebas
        public void GenerarCategoriasYProductos()
        {
            for (int i = 1; i <= 5; i++)
            {
                Categoria c = new();
                c.Nombre = $"Categoría {i}";
                c.Id = i;
                Rcat.Add(c);
            }

            // Generar 50 productos
            for (int i = 1; i <= 50; i++)
            {
                string descripcion = $"Descripción del Producto {i}";
                double precio = Math.Round(new Random().NextDouble() * 100, 2); 

                Rprod.Add(new Producto($"Producto {i}", descripcion, precio, (i % 5 + 1), i)); 
            }
        } */
        public int SacarUltimoIdCat() 
        {
            if (Rcat.GetAll().Count == 0)
            {
                return -1;
            }
            else { return Rcat.GetAll().Last().Id; }
        }
        public int SacarUltimoIdProd()
        {
            if (Rprod.GetAll().Count == 0)
            {
                return -1;
            }
            else { return Rprod.GetAll().Last().IdProducto; }
        }
        public void GuardarCategorias() {
            Rcat.Save();
        }
        public void SacarCategorias() {
            Rcat.Load();
        }
        public void GuardarProductos()
        {
            Rprod.Save();
        }
        public void SacarProductos()
        {
            Rprod.Load();
        }

    }
}



     