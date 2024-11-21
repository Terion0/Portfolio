using inventarioMVP.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using inventarioMVP.MVP.Modelo.Dataclasses;
using CompanyDirectory.DataAccess;

namespace inventarioMVP.MVP.Repositories
{
    internal class Rproductos : genericI<Producto>
    {
        XmlFileDataAccessLayer paraGuardar = new XmlFileDataAccessLayer("./archivoProd.XML");
        List<Producto> Productos = new();
        public void Add(Producto item)
        {
            Productos.Add(item);
        }
        public Producto? Get(int id)
        {
            Producto item = null;
            bool encontrado = false;
            for (int i = 0; i < Productos.Count && !encontrado; i++)
            {
                if (Productos[i].IdProducto == id)
                {
                    encontrado = true;
                    item = Productos[i];
                }
            }
            return item;
        }
        public List<Producto> GetAll()
        {
            return Productos;
        }
        public void Remove(Producto item)
        {
            Productos.Remove(item);
        }
        public void Update(Producto item)
        {
            for (int i = 0; i < Productos.Count; i++)
            {
                if (Productos[i].IdProducto == item.IdProducto)
                {

                    Productos[i] = item;
                }
            }
         
        }
        public void Save()
        {
            paraGuardar.SaveData(Productos);
        }
        public void Load()
        {
            Productos = paraGuardar.LoadData<Producto>();
        }
    }
}

