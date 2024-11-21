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
    internal class Rcategoria : genericI<Categoria>
    {
        XmlFileDataAccessLayer paraGuardar= new XmlFileDataAccessLayer("./archivoCat.XML");
        List<Categoria> Categorias = new();
        public void Add(Categoria item)
        {
           Categorias.Add(item);
        }

        public Categoria? Get(int id)
        {
            Boolean encontrado = false;
            Categoria? item = null;
            for (int i = 0; i < Categorias.Count && !encontrado; i++) {
                if (Categorias[i].Id == id)
                {
                    encontrado = true;
                    item = Categorias[i];
                }
            }
           
            return item;
        }

        public List<Categoria> GetAll()
        {
            return Categorias;
        }

        public void Remove(Categoria item)
        {
            Categorias.Remove(item);
        }

        public void Update(Categoria item)
        {
            for (int i = 0; i < Categorias.Count; i++) {
                if (item.Id == Categorias[i].Id)
                { Categorias[i] = item; }
                        }
        }

        public void Save() 
        {
            paraGuardar.SaveData(Categorias);     
        }
        public void Load() {
          Categorias = paraGuardar.LoadData<Categoria>();       
        }
    }

   
    }

   
