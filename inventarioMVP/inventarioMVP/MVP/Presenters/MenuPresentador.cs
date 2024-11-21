using inventarioMVP.Modelo;
using inventarioMVP.MVP.Modelo.Dataclasses;
using inventarioMVP.MVP.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace inventarioMVP.MVP.Presenters;

internal class MenuPresentador
{
    private VistaEstatica mainView;
    private ModeloDeMVP modeloDeMVP;
    public MenuPresentador(VistaEstatica mainView, ModeloDeMVP modeloDeMVP)
    {
        this.mainView = mainView;
        this.modeloDeMVP = modeloDeMVP;
        mainView.FiltrarPorCategoria += MostrarInfodeCat;
        mainView.SacarInfoProducto += MostrarInfodeProd;
        mainView.EliminarProducto += EliminarProducto;
        mainView.EliminarCategoria += EliminarCategoria;
        mainView.AñadirCategoria += AñadirCategoria;
        mainView.ModificarCategoria += ModificarCategoria;
        mainView.AñadirProducto += AñadirProducto;
        mainView.ModificarProducto += ModificarProducto;
        mainView.Guardar += Guardar;
        mainView.Cargar += Cargar;
    }
    private void MostrarInfodeCat(object sender, string msg)
    {
        mainView.MostrarNombre = msg;
        mainView.MostrarId = modeloDeMVP.SacarIdXNombreCat(msg).ToString();
        mainView.ListBoxProd = modeloDeMVP.SacarNombreProdxCat(msg);
    }
    private void MostrarInfodeProd(object sender, string msg)
    {
        Producto p = modeloDeMVP.APresentadorProd(msg);      
        mainView.MostrarNombreProd = p.Nombre;
        mainView.MostrarPrecio = p.Precio.ToString();
        mainView.MostrarDescripcion = p.Descripcion;
    }
    private void EliminarProducto(object sender, string msg)
    {
        Producto p=modeloDeMVP.EliminarProducto(msg);
        if (p != null)
        {
            string vacio = "";
            string NomCat = modeloDeMVP.SacarNombreXidCat(p.IdCategoria);
            mainView.ListBoxProd = modeloDeMVP.SacarNombreProdxCat(NomCat);
            mainView.MostrarNombreProd = vacio;
            mainView.MostrarPrecio = vacio;
            mainView.MostrarDescripcion = vacio;
            mainView.MostrarMensaje("Producto eliminado correctamente");
        }
        else { mainView.MostrarMensaje("Producto no eliminado"); }
    }
   
    private void EliminarCategoria(object sender, string msg)
    {
        string vacio ="";
        Categoria c = modeloDeMVP.EliminarCategoria(msg);
        if (c != null)
        {
            mainView.ListBoxCat = modeloDeMVP.SacarNombreCategorías();
            mainView.MostrarNombre = vacio;
            mainView.MostrarId = vacio;
            mainView.MostrarMensaje("Categoría eliminada correctamente");
        }
        else { mainView.MostrarMensaje("Categoria no eliminada"); }
    }
    private void AñadirCategoria(object sender, EventArgs e)
    {
        string Cat = mainView.RecogerNombreCat;
        Categoria c =modeloDeMVP.AñadirCategoria(Cat);
        if (c != null)
        {
            List<string> lista = modeloDeMVP.SacarNombreCategorías();
            mainView.ListBoxCat = lista;
            mainView.MostrarMensaje("Categoría añadida correctamente");
        }
        else { mainView.MostrarMensaje("Categoría no añadida"); }

    }
    private void AñadirProducto(object sender, EventArgs e)
    {
        string nombre = mainView.RecogerNombreProd;
        string precio = mainView.RecogerPrecioProd;
        string descripcion = mainView.RecogerDescripcion;
        string categoria = mainView.RecogerCategoriaProd;
        Producto p= modeloDeMVP.AñadirProducto(nombre, precio, descripcion, categoria);
        if (p != null)
        {
            string c = modeloDeMVP.SacarNombreXidCat(p.IdCategoria);
            mainView.ListBoxProd = modeloDeMVP.SacarNombreProdxCat(c);
            mainView.MostrarMensaje("Producto añadido correctamente");
        }
        else { mainView.MostrarMensaje("Producto no añadido"); }
    }
    private void ModificarCategoria(object sender, string msg)
    {
     string Cat = mainView.RecogerNombreCat;
     Categoria c = modeloDeMVP.ModificarCategoria(Cat, msg);
        if (c != null)
        {
            mainView.ListBoxCat = modeloDeMVP.SacarNombreCategorías();
            mainView.MostrarMensaje("Categoría modificada correctamente");
        }
        else { mainView.MostrarMensaje("Categoría no modificada"); }
    }
    private void ModificarProducto(object sender, string msg)
    {
       string nombre = mainView.RecogerNombreProd;
       string precio = mainView.RecogerPrecioProd;
       string descripcion = mainView.RecogerDescripcion;
       string categoria = mainView.RecogerCategoriaProd;
       Producto p = modeloDeMVP.ModificarProducto(msg, nombre, precio, descripcion, categoria);
        if (p != null)
        {
            string cat = modeloDeMVP.SacarNombreXidCat(p.IdCategoria);
            mainView.ListBoxProd = modeloDeMVP.SacarNombreProdxCat(cat);
        }
    }
    private void Guardar(object sender, EventArgs e) {
        modeloDeMVP.GuardarCategorias();
        modeloDeMVP.GuardarProductos();
        mainView.MostrarMensaje("Guardado correctamente");
    }
    private void Cargar(object sender, EventArgs e)
    {
        modeloDeMVP.SacarCategorias();
        modeloDeMVP.SacarProductos();
        mainView.ListBoxCat = modeloDeMVP.SacarNombreCategorías();
        mainView.MostrarMensaje("Cargado correctamente");
    }

}

