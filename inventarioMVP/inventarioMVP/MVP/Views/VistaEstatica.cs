using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace inventarioMVP.MVP.Views
{
    public class VistaEstatica : Form
    {
        private TableLayoutPanel tableLayoutPanel1;
        private TableLayoutPanel tableLayoutPanel2;
        public EventHandler<string> FiltrarPorCategoria;
        public EventHandler<string> SacarInfoProducto;
        public EventHandler<string> EliminarProducto;
        public EventHandler<string> EliminarCategoria;
        public EventHandler AñadirProducto;
        public EventHandler AñadirCategoria;
        public EventHandler<string> ModificarCategoria;
        public EventHandler<string> ModificarProducto;
        public EventHandler Guardar;
        public EventHandler Cargar;
        private ListBox ListCat;
        private ListBox ListProd;
        private Button BañadirCat;
        private Button BeliminarProd;
        private Button BmodificarProd;
        private Button BAñadirProd;
        private Button BeliminarCat;
        private Button BmodificarCat;
        private TableLayoutPanel tableLayoutPanel5;
        private Label DatosCat;
        private TableLayoutPanel tableLayoutPanel6;
        private Label DatosProd;
        private TableLayoutPanel tableLayoutPanel11;
        private TableLayoutPanel tableLayoutPanel12;
        private Label Lcategoria;
        private TableLayoutPanel tableLayoutPanel3;
        private Label MuestraNombre;
        private Label NombreaCat;
        private Label MuestraId;
        private Label IdCat;
        private Label InfoCat;
        private TableLayoutPanel tableLayoutPanel4;
        private Label DesProd;
        private Label PrecioProd;
        private Label NombreProd;
        private Label MuestraNombreProd;
        private Label InfoProd;
        private TextBox TextBoxCat;
        private TableLayoutPanel tableLayoutPanel8;
        private TextBox TextBPrecio;
        private TableLayoutPanel tableLayoutPanel7;
        private TextBox textBoxProd;
        private TableLayoutPanel tableLayoutPanel10;
        private TextBox TextBDescrip;
        private TableLayoutPanel tableLayoutPanel9;
        private TextBox TextBCatProd;
        private Label ProdDes;
        private Label CatProd;
        private Label PrecioProducto;
        private Label DatNomProd;
        private Label MuestraDescripcion;
        private Label MuestraPrecio;
        private TableLayoutPanel tableLayoutPanel13;
        private Button Bcargar;
        private Button BGuardar;
        private System.ComponentModel.IContainer components = null;
        public string MostrarNombreProd { get => MuestraNombreProd.Text; set => MuestraNombreProd.Text = value; }
        public string MostrarPrecio { get => MuestraPrecio.Text; set => MuestraPrecio.Text = value; }
        public string MostrarDescripcion { get => MuestraDescripcion.Text; set => MuestraDescripcion.Text = value; }
        public string MostrarNombre { get => MuestraNombre.Text; set => MuestraNombre.Text = value; }
        public string MostrarId { get => MuestraId.Text; set => MuestraId.Text = value; }
        public List<string> ListBoxCat
        {
            get
            {
                List<string> list = new List<string>();
                foreach (string item in ListCat.Items)
                {
                    list.Add(item);
                }
                return list;
            }
            set
            {
                ListCat.Items.Clear();
                foreach (string item in value)
                {
                    ListCat.Items.Add(item);
                }
                ListCat.SelectedIndexChanged += CategoriaSeleccionada;
            }
        }
        public List<string> ListBoxProd
        {
            get
            {
                List<string> list = new List<string>();
                foreach (string item in ListProd.Items)
                {
                    list.Add(item);
                }
                return list;
            }

            set
            {



                ListProd.Items.Clear();
                foreach (string item in value)
                {

                    ListProd.Items.Add(item);
                }
                ListProd.SelectedIndexChanged += ProductoSeleccionado;
            }
        }

        public string RecogerNombreCat { get => TextBoxCat.Text; }
        public string RecogerNombreProd { get => textBoxProd.Text; }
        public string RecogerPrecioProd { get => TextBPrecio.Text; }
        public string RecogerCategoriaProd { get => TextBCatProd.Text; }
        public string RecogerDescripcion { get => TextBDescrip.Text; }
        private void AttachEventHandler()
        {
            BeliminarProd.Click += EliminarProdSeleccionado;
            BeliminarCat.Click += EliminarCatSeleccionado;
            BañadirCat.Click += AñadirCat;
            BmodificarCat.Click += ModificarCat;
            BAñadirProd.Click += AñadirProd;
            BmodificarProd.Click += ModificarProd;
            BGuardar.Click += Guardar_Click;
            Bcargar.Click += Cargar_Click;

        }
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }
        public VistaEstatica()
        {
            InitializeComponent();
            AttachEventHandler();
        }

        private void VistaEstatica_Load(object sender, EventArgs e)
        {

        }


        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            tableLayoutPanel1 = new TableLayoutPanel();
            ListCat = new ListBox();
            ListProd = new ListBox();
            tableLayoutPanel2 = new TableLayoutPanel();
            BeliminarCat = new Button();
            BmodificarCat = new Button();
            BañadirCat = new Button();
            BeliminarProd = new Button();
            BmodificarProd = new Button();
            BAñadirProd = new Button();
            tableLayoutPanel3 = new TableLayoutPanel();
            MuestraNombre = new Label();
            NombreaCat = new Label();
            MuestraId = new Label();
            IdCat = new Label();
            InfoCat = new Label();
            tableLayoutPanel4 = new TableLayoutPanel();
            MuestraPrecio = new Label();
            MuestraDescripcion = new Label();
            DesProd = new Label();
            PrecioProd = new Label();
            NombreProd = new Label();
            MuestraNombreProd = new Label();
            InfoProd = new Label();
            tableLayoutPanel5 = new TableLayoutPanel();
            tableLayoutPanel12 = new TableLayoutPanel();
            Lcategoria = new Label();
            tableLayoutPanel11 = new TableLayoutPanel();
            TextBoxCat = new TextBox();
            DatosCat = new Label();
            tableLayoutPanel6 = new TableLayoutPanel();
            tableLayoutPanel8 = new TableLayoutPanel();
            TextBPrecio = new TextBox();
            tableLayoutPanel7 = new TableLayoutPanel();
            textBoxProd = new TextBox();
            tableLayoutPanel10 = new TableLayoutPanel();
            TextBDescrip = new TextBox();
            tableLayoutPanel9 = new TableLayoutPanel();
            TextBCatProd = new TextBox();
            ProdDes = new Label();
            CatProd = new Label();
            PrecioProducto = new Label();
            DatNomProd = new Label();
            DatosProd = new Label();
            tableLayoutPanel13 = new TableLayoutPanel();
            Bcargar = new Button();
            BGuardar = new Button();
            tableLayoutPanel1.SuspendLayout();
            tableLayoutPanel2.SuspendLayout();
            tableLayoutPanel3.SuspendLayout();
            tableLayoutPanel4.SuspendLayout();
            tableLayoutPanel5.SuspendLayout();
            tableLayoutPanel12.SuspendLayout();
            tableLayoutPanel11.SuspendLayout();
            tableLayoutPanel6.SuspendLayout();
            tableLayoutPanel8.SuspendLayout();
            tableLayoutPanel7.SuspendLayout();
            tableLayoutPanel10.SuspendLayout();
            tableLayoutPanel9.SuspendLayout();
            tableLayoutPanel13.SuspendLayout();
            SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            tableLayoutPanel1.ColumnCount = 3;
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 37.60684F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 62.39316F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Absolute, 448F));
            tableLayoutPanel1.Controls.Add(ListCat, 0, 1);
            tableLayoutPanel1.Controls.Add(ListProd, 0, 2);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel2, 2, 3);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel3, 1, 1);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel4, 1, 2);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel5, 2, 1);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel6, 2, 2);
            tableLayoutPanel1.Controls.Add(tableLayoutPanel13, 0, 3);
            tableLayoutPanel1.Dock = DockStyle.Fill;
            tableLayoutPanel1.Location = new Point(0, 0);
            tableLayoutPanel1.Name = "tableLayoutPanel1";
            tableLayoutPanel1.RowCount = 4;
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 5F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 15F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 70F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 10F));
            tableLayoutPanel1.Size = new Size(960, 601);
            tableLayoutPanel1.TabIndex = 0;
            tableLayoutPanel1.Paint += tableLayoutPanel1_Paint;
            // 
            // ListCat
            // 
            ListCat.Dock = DockStyle.Fill;
            ListCat.FormattingEnabled = true;
            ListCat.ItemHeight = 15;
            ListCat.Location = new Point(3, 33);
            ListCat.Name = "ListCat";
            ListCat.Size = new Size(186, 84);
            ListCat.TabIndex = 0;
            // 
            // ListProd
            // 
            ListProd.Dock = DockStyle.Fill;
            ListProd.FormattingEnabled = true;
            ListProd.ItemHeight = 15;
            ListProd.Location = new Point(3, 123);
            ListProd.Name = "ListProd";
            ListProd.Size = new Size(186, 414);
            ListProd.TabIndex = 1;
            // 
            // tableLayoutPanel2
            // 
            tableLayoutPanel2.ColumnCount = 3;
            tableLayoutPanel2.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel2.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel2.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel2.Controls.Add(BeliminarCat, 2, 1);
            tableLayoutPanel2.Controls.Add(BmodificarCat, 1, 1);
            tableLayoutPanel2.Controls.Add(BañadirCat, 0, 1);
            tableLayoutPanel2.Controls.Add(BeliminarProd, 2, 0);
            tableLayoutPanel2.Controls.Add(BmodificarProd, 1, 0);
            tableLayoutPanel2.Controls.Add(BAñadirProd, 0, 0);
            tableLayoutPanel2.Dock = DockStyle.Fill;
            tableLayoutPanel2.Location = new Point(514, 543);
            tableLayoutPanel2.Name = "tableLayoutPanel2";
            tableLayoutPanel2.RowCount = 2;
            tableLayoutPanel2.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel2.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel2.Size = new Size(443, 55);
            tableLayoutPanel2.TabIndex = 2;
            // 
            // BeliminarCat
            // 
            BeliminarCat.Dock = DockStyle.Fill;
            BeliminarCat.Location = new Point(297, 30);
            BeliminarCat.Name = "BeliminarCat";
            BeliminarCat.Size = new Size(143, 22);
            BeliminarCat.TabIndex = 11;
            BeliminarCat.Text = "Eliminar Categoría";
            BeliminarCat.UseVisualStyleBackColor = true;
            // 
            // BmodificarCat
            // 
            BmodificarCat.Dock = DockStyle.Fill;
            BmodificarCat.Location = new Point(150, 30);
            BmodificarCat.Name = "BmodificarCat";
            BmodificarCat.Size = new Size(141, 22);
            BmodificarCat.TabIndex = 10;
            BmodificarCat.Text = "Modificar categoría";
            BmodificarCat.UseVisualStyleBackColor = true;
            // 
            // BañadirCat
            // 
            BañadirCat.Dock = DockStyle.Fill;
            BañadirCat.Location = new Point(3, 30);
            BañadirCat.Name = "BañadirCat";
            BañadirCat.Size = new Size(141, 22);
            BañadirCat.TabIndex = 9;
            BañadirCat.Text = "Añadir Categoría";
            BañadirCat.UseVisualStyleBackColor = true;
            // 
            // BeliminarProd
            // 
            BeliminarProd.Dock = DockStyle.Fill;
            BeliminarProd.Location = new Point(297, 3);
            BeliminarProd.Name = "BeliminarProd";
            BeliminarProd.Size = new Size(143, 21);
            BeliminarProd.TabIndex = 8;
            BeliminarProd.Text = "Eliminar producto";
            BeliminarProd.UseVisualStyleBackColor = true;
            // 
            // BmodificarProd
            // 
            BmodificarProd.Dock = DockStyle.Fill;
            BmodificarProd.Location = new Point(150, 3);
            BmodificarProd.Name = "BmodificarProd";
            BmodificarProd.Size = new Size(141, 21);
            BmodificarProd.TabIndex = 7;
            BmodificarProd.Text = "Modificar producto";
            BmodificarProd.UseVisualStyleBackColor = true;
            // 
            // BAñadirProd
            // 
            BAñadirProd.Dock = DockStyle.Fill;
            BAñadirProd.Location = new Point(3, 3);
            BAñadirProd.Name = "BAñadirProd";
            BAñadirProd.Size = new Size(141, 21);
            BAñadirProd.TabIndex = 6;
            BAñadirProd.Text = "Añadir producto";
            BAñadirProd.UseVisualStyleBackColor = true;
            // 
            // tableLayoutPanel3
            // 
            tableLayoutPanel3.ColumnCount = 2;
            tableLayoutPanel3.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel3.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel3.Controls.Add(MuestraNombre, 1, 2);
            tableLayoutPanel3.Controls.Add(NombreaCat, 0, 2);
            tableLayoutPanel3.Controls.Add(MuestraId, 1, 1);
            tableLayoutPanel3.Controls.Add(IdCat, 0, 1);
            tableLayoutPanel3.Controls.Add(InfoCat, 0, 0);
            tableLayoutPanel3.Dock = DockStyle.Fill;
            tableLayoutPanel3.Location = new Point(195, 33);
            tableLayoutPanel3.Name = "tableLayoutPanel3";
            tableLayoutPanel3.RowCount = 3;
            tableLayoutPanel3.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel3.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel3.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel3.Size = new Size(313, 84);
            tableLayoutPanel3.TabIndex = 3;
            // 
            // MuestraNombre
            // 
            MuestraNombre.AutoSize = true;
            MuestraNombre.Dock = DockStyle.Fill;
            MuestraNombre.Location = new Point(159, 64);
            MuestraNombre.Name = "MuestraNombre";
            MuestraNombre.Size = new Size(151, 20);
            MuestraNombre.TabIndex = 4;
            MuestraNombre.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // NombreaCat
            // 
            NombreaCat.AutoSize = true;
            NombreaCat.Dock = DockStyle.Fill;
            NombreaCat.Location = new Point(3, 64);
            NombreaCat.Name = "NombreaCat";
            NombreaCat.Size = new Size(150, 20);
            NombreaCat.TabIndex = 3;
            NombreaCat.Text = "Nombre categoría";
            NombreaCat.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // MuestraId
            // 
            MuestraId.AutoSize = true;
            MuestraId.Dock = DockStyle.Fill;
            MuestraId.Location = new Point(159, 32);
            MuestraId.Name = "MuestraId";
            MuestraId.Size = new Size(151, 32);
            MuestraId.TabIndex = 2;
            MuestraId.TextAlign = ContentAlignment.MiddleCenter;
            MuestraId.Click += label2_Click;
            // 
            // IdCat
            // 
            IdCat.AutoSize = true;
            IdCat.Dock = DockStyle.Fill;
            IdCat.Location = new Point(3, 32);
            IdCat.Name = "IdCat";
            IdCat.Size = new Size(150, 32);
            IdCat.TabIndex = 1;
            IdCat.Text = "Id Categoría";
            IdCat.TextAlign = ContentAlignment.MiddleLeft;
            IdCat.Click += IdCat_Click;
            // 
            // InfoCat
            // 
            InfoCat.AutoSize = true;
            tableLayoutPanel3.SetColumnSpan(InfoCat, 2);
            InfoCat.Dock = DockStyle.Fill;
            InfoCat.Location = new Point(3, 0);
            InfoCat.Name = "InfoCat";
            InfoCat.Size = new Size(307, 32);
            InfoCat.TabIndex = 0;
            InfoCat.Text = "Información de categoría";
            InfoCat.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // tableLayoutPanel4
            // 
            tableLayoutPanel4.ColumnCount = 2;
            tableLayoutPanel4.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel4.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel4.Controls.Add(MuestraPrecio, 1, 2);
            tableLayoutPanel4.Controls.Add(MuestraDescripcion, 0, 4);
            tableLayoutPanel4.Controls.Add(DesProd, 0, 3);
            tableLayoutPanel4.Controls.Add(PrecioProd, 0, 2);
            tableLayoutPanel4.Controls.Add(NombreProd, 0, 1);
            tableLayoutPanel4.Controls.Add(MuestraNombreProd, 1, 1);
            tableLayoutPanel4.Controls.Add(InfoProd, 0, 0);
            tableLayoutPanel4.Dock = DockStyle.Fill;
            tableLayoutPanel4.Location = new Point(195, 123);
            tableLayoutPanel4.Name = "tableLayoutPanel4";
            tableLayoutPanel4.RowCount = 5;
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Percent, 56.4102554F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Percent, 43.5897446F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 19F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 334F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 229F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 246F));
            tableLayoutPanel4.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel4.Size = new Size(313, 414);
            tableLayoutPanel4.TabIndex = 4;
            tableLayoutPanel4.Paint += tableLayoutPanel4_Paint;
            // 
            // MuestraPrecio
            // 
            MuestraPrecio.AutoSize = true;
            MuestraPrecio.Dock = DockStyle.Fill;
            MuestraPrecio.Location = new Point(159, 40);
            MuestraPrecio.Name = "MuestraPrecio";
            MuestraPrecio.Size = new Size(151, 20);
            MuestraPrecio.TabIndex = 32;
            MuestraPrecio.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // MuestraDescripcion
            // 
            MuestraDescripcion.AutoSize = true;
            tableLayoutPanel4.SetColumnSpan(MuestraDescripcion, 2);
            MuestraDescripcion.Dock = DockStyle.Fill;
            MuestraDescripcion.Location = new Point(3, 79);
            MuestraDescripcion.Name = "MuestraDescripcion";
            MuestraDescripcion.Size = new Size(307, 335);
            MuestraDescripcion.TabIndex = 31;
            // 
            // DesProd
            // 
            DesProd.AutoSize = true;
            tableLayoutPanel4.SetColumnSpan(DesProd, 2);
            DesProd.Dock = DockStyle.Fill;
            DesProd.Location = new Point(3, 60);
            DesProd.Name = "DesProd";
            DesProd.Size = new Size(307, 19);
            DesProd.TabIndex = 30;
            DesProd.Text = "Descripción";
            DesProd.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // PrecioProd
            // 
            PrecioProd.AutoSize = true;
            PrecioProd.Dock = DockStyle.Fill;
            PrecioProd.Location = new Point(3, 40);
            PrecioProd.Name = "PrecioProd";
            PrecioProd.Size = new Size(150, 20);
            PrecioProd.TabIndex = 29;
            PrecioProd.Text = "Precio";
            PrecioProd.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // NombreProd
            // 
            NombreProd.AutoSize = true;
            NombreProd.Dock = DockStyle.Fill;
            NombreProd.Location = new Point(3, 23);
            NombreProd.Name = "NombreProd";
            NombreProd.Size = new Size(150, 17);
            NombreProd.TabIndex = 20;
            NombreProd.Text = "Nombre producto";
            NombreProd.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // MuestraNombreProd
            // 
            MuestraNombreProd.AutoSize = true;
            MuestraNombreProd.Dock = DockStyle.Fill;
            MuestraNombreProd.Location = new Point(159, 23);
            MuestraNombreProd.Name = "MuestraNombreProd";
            MuestraNombreProd.Size = new Size(151, 17);
            MuestraNombreProd.TabIndex = 12;
            MuestraNombreProd.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // InfoProd
            // 
            InfoProd.AutoSize = true;
            tableLayoutPanel4.SetColumnSpan(InfoProd, 2);
            InfoProd.Dock = DockStyle.Fill;
            InfoProd.Location = new Point(3, 0);
            InfoProd.Name = "InfoProd";
            InfoProd.Size = new Size(307, 23);
            InfoProd.TabIndex = 1;
            InfoProd.Text = "Información del producto";
            InfoProd.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // tableLayoutPanel5
            // 
            tableLayoutPanel5.ColumnCount = 2;
            tableLayoutPanel5.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel5.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel5.Controls.Add(tableLayoutPanel12, 0, 1);
            tableLayoutPanel5.Controls.Add(tableLayoutPanel11, 1, 1);
            tableLayoutPanel5.Controls.Add(DatosCat, 0, 0);
            tableLayoutPanel5.Dock = DockStyle.Fill;
            tableLayoutPanel5.Location = new Point(514, 33);
            tableLayoutPanel5.Name = "tableLayoutPanel5";
            tableLayoutPanel5.RowCount = 2;
            tableLayoutPanel5.RowStyles.Add(new RowStyle(SizeType.Percent, 38.3333321F));
            tableLayoutPanel5.RowStyles.Add(new RowStyle(SizeType.Percent, 61.6666679F));
            tableLayoutPanel5.Size = new Size(443, 84);
            tableLayoutPanel5.TabIndex = 5;
            tableLayoutPanel5.Paint += tableLayoutPanel5_Paint;
            // 
            // tableLayoutPanel12
            // 
            tableLayoutPanel12.ColumnCount = 3;
            tableLayoutPanel12.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.Controls.Add(Lcategoria, 0, 1);
            tableLayoutPanel12.Dock = DockStyle.Fill;
            tableLayoutPanel12.Location = new Point(3, 35);
            tableLayoutPanel12.Name = "tableLayoutPanel12";
            tableLayoutPanel12.RowCount = 3;
            tableLayoutPanel12.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel12.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel12.Size = new Size(215, 46);
            tableLayoutPanel12.TabIndex = 21;
            // 
            // Lcategoria
            // 
            Lcategoria.AutoSize = true;
            tableLayoutPanel12.SetColumnSpan(Lcategoria, 3);
            Lcategoria.Dock = DockStyle.Fill;
            Lcategoria.Location = new Point(3, 15);
            Lcategoria.Name = "Lcategoria";
            Lcategoria.Size = new Size(209, 15);
            Lcategoria.TabIndex = 9;
            Lcategoria.Text = "Nombre categoría";
            Lcategoria.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // tableLayoutPanel11
            // 
            tableLayoutPanel11.ColumnCount = 3;
            tableLayoutPanel11.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.Controls.Add(TextBoxCat, 0, 1);
            tableLayoutPanel11.Dock = DockStyle.Fill;
            tableLayoutPanel11.Location = new Point(224, 35);
            tableLayoutPanel11.Name = "tableLayoutPanel11";
            tableLayoutPanel11.RowCount = 3;
            tableLayoutPanel11.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.RowStyles.Add(new RowStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel11.Size = new Size(216, 46);
            tableLayoutPanel11.TabIndex = 20;
            // 
            // TextBoxCat
            // 
            tableLayoutPanel11.SetColumnSpan(TextBoxCat, 3);
            TextBoxCat.Dock = DockStyle.Fill;
            TextBoxCat.Location = new Point(0, 15);
            TextBoxCat.Margin = new Padding(0);
            TextBoxCat.Name = "TextBoxCat";
            TextBoxCat.Size = new Size(216, 23);
            TextBoxCat.TabIndex = 7;
            // 
            // DatosCat
            // 
            DatosCat.AutoSize = true;
            tableLayoutPanel5.SetColumnSpan(DatosCat, 2);
            DatosCat.Dock = DockStyle.Fill;
            DatosCat.Location = new Point(3, 0);
            DatosCat.Name = "DatosCat";
            DatosCat.Size = new Size(437, 32);
            DatosCat.TabIndex = 1;
            DatosCat.Text = "Datos de categoría";
            DatosCat.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // tableLayoutPanel6
            // 
            tableLayoutPanel6.ColumnCount = 2;
            tableLayoutPanel6.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel6.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel6.Controls.Add(tableLayoutPanel8, 1, 2);
            tableLayoutPanel6.Controls.Add(tableLayoutPanel7, 1, 1);
            tableLayoutPanel6.Controls.Add(tableLayoutPanel10, 1, 4);
            tableLayoutPanel6.Controls.Add(tableLayoutPanel9, 1, 3);
            tableLayoutPanel6.Controls.Add(ProdDes, 0, 4);
            tableLayoutPanel6.Controls.Add(CatProd, 0, 3);
            tableLayoutPanel6.Controls.Add(PrecioProducto, 0, 2);
            tableLayoutPanel6.Controls.Add(DatNomProd, 0, 1);
            tableLayoutPanel6.Controls.Add(DatosProd, 0, 0);
            tableLayoutPanel6.Dock = DockStyle.Fill;
            tableLayoutPanel6.Location = new Point(514, 123);
            tableLayoutPanel6.Name = "tableLayoutPanel6";
            tableLayoutPanel6.RowCount = 5;
            tableLayoutPanel6.RowStyles.Add(new RowStyle(SizeType.Percent, 5.673759F));
            tableLayoutPanel6.RowStyles.Add(new RowStyle(SizeType.Percent, 8.274232F));
            tableLayoutPanel6.RowStyles.Add(new RowStyle(SizeType.Percent, 8.037825F));
            tableLayoutPanel6.RowStyles.Add(new RowStyle(SizeType.Percent, 8.037825F));
            tableLayoutPanel6.RowStyles.Add(new RowStyle(SizeType.Percent, 70.68558F));
            tableLayoutPanel6.Size = new Size(443, 414);
            tableLayoutPanel6.TabIndex = 6;
            // 
            // tableLayoutPanel8
            // 
            tableLayoutPanel8.ColumnCount = 3;
            tableLayoutPanel8.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel8.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel8.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel8.Controls.Add(TextBPrecio, 1, 0);
            tableLayoutPanel8.Dock = DockStyle.Fill;
            tableLayoutPanel8.Location = new Point(224, 60);
            tableLayoutPanel8.Name = "tableLayoutPanel8";
            tableLayoutPanel8.RowCount = 1;
            tableLayoutPanel8.RowStyles.Add(new RowStyle(SizeType.Percent, 100F));
            tableLayoutPanel8.Size = new Size(216, 27);
            tableLayoutPanel8.TabIndex = 20;
            // 
            // TextBPrecio
            // 
            TextBPrecio.Location = new Point(74, 3);
            TextBPrecio.Name = "TextBPrecio";
            TextBPrecio.Size = new Size(65, 23);
            TextBPrecio.TabIndex = 0;
            // 
            // tableLayoutPanel7
            // 
            tableLayoutPanel7.ColumnCount = 3;
            tableLayoutPanel7.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel7.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel7.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel7.Controls.Add(textBoxProd, 1, 0);
            tableLayoutPanel7.Dock = DockStyle.Fill;
            tableLayoutPanel7.Location = new Point(224, 26);
            tableLayoutPanel7.Name = "tableLayoutPanel7";
            tableLayoutPanel7.RowCount = 1;
            tableLayoutPanel7.RowStyles.Add(new RowStyle(SizeType.Percent, 100F));
            tableLayoutPanel7.Size = new Size(216, 28);
            tableLayoutPanel7.TabIndex = 19;
            // 
            // textBoxProd
            // 
            textBoxProd.Location = new Point(74, 3);
            textBoxProd.Name = "textBoxProd";
            textBoxProd.Size = new Size(65, 23);
            textBoxProd.TabIndex = 0;
            textBoxProd.TextChanged += textBoxProd_TextChanged;
            // 
            // tableLayoutPanel10
            // 
            tableLayoutPanel10.ColumnCount = 1;
            tableLayoutPanel10.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel10.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel10.Controls.Add(TextBDescrip, 0, 0);
            tableLayoutPanel10.Dock = DockStyle.Fill;
            tableLayoutPanel10.Location = new Point(224, 126);
            tableLayoutPanel10.Name = "tableLayoutPanel10";
            tableLayoutPanel10.RowCount = 2;
            tableLayoutPanel10.RowStyles.Add(new RowStyle(SizeType.Percent, 37.80488F));
            tableLayoutPanel10.RowStyles.Add(new RowStyle(SizeType.Percent, 62.19512F));
            tableLayoutPanel10.RowStyles.Add(new RowStyle(SizeType.Absolute, 68F));
            tableLayoutPanel10.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel10.Size = new Size(216, 285);
            tableLayoutPanel10.TabIndex = 18;
            // 
            // TextBDescrip
            // 
            TextBDescrip.Dock = DockStyle.Fill;
            TextBDescrip.Location = new Point(3, 3);
            TextBDescrip.Name = "TextBDescrip";
            tableLayoutPanel10.SetRowSpan(TextBDescrip, 3);
            TextBDescrip.Size = new Size(210, 23);
            TextBDescrip.TabIndex = 0;
            // 
            // tableLayoutPanel9
            // 
            tableLayoutPanel9.ColumnCount = 3;
            tableLayoutPanel9.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel9.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel9.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 33.3333321F));
            tableLayoutPanel9.Controls.Add(TextBCatProd, 1, 0);
            tableLayoutPanel9.Dock = DockStyle.Fill;
            tableLayoutPanel9.Location = new Point(224, 93);
            tableLayoutPanel9.Name = "tableLayoutPanel9";
            tableLayoutPanel9.RowCount = 1;
            tableLayoutPanel9.RowStyles.Add(new RowStyle(SizeType.Percent, 100F));
            tableLayoutPanel9.Size = new Size(216, 27);
            tableLayoutPanel9.TabIndex = 17;
            // 
            // TextBCatProd
            // 
            TextBCatProd.Location = new Point(74, 3);
            TextBCatProd.Name = "TextBCatProd";
            TextBCatProd.Size = new Size(65, 23);
            TextBCatProd.TabIndex = 0;
            // 
            // ProdDes
            // 
            ProdDes.AutoSize = true;
            ProdDes.Dock = DockStyle.Top;
            ProdDes.ImageAlign = ContentAlignment.MiddleLeft;
            ProdDes.Location = new Point(3, 123);
            ProdDes.Name = "ProdDes";
            ProdDes.Size = new Size(215, 15);
            ProdDes.TabIndex = 14;
            ProdDes.Text = "Descripción producto";
            ProdDes.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // CatProd
            // 
            CatProd.AutoSize = true;
            CatProd.Dock = DockStyle.Fill;
            CatProd.ImageAlign = ContentAlignment.MiddleLeft;
            CatProd.Location = new Point(3, 90);
            CatProd.Name = "CatProd";
            CatProd.Size = new Size(215, 33);
            CatProd.TabIndex = 10;
            CatProd.Text = "Categoría producto";
            CatProd.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // PrecioProducto
            // 
            PrecioProducto.AutoSize = true;
            PrecioProducto.Dock = DockStyle.Fill;
            PrecioProducto.ImageAlign = ContentAlignment.MiddleLeft;
            PrecioProducto.Location = new Point(3, 57);
            PrecioProducto.Name = "PrecioProducto";
            PrecioProducto.Size = new Size(215, 33);
            PrecioProducto.TabIndex = 7;
            PrecioProducto.Text = "Precio producto";
            PrecioProducto.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // DatNomProd
            // 
            DatNomProd.AutoSize = true;
            DatNomProd.Dock = DockStyle.Fill;
            DatNomProd.ImageAlign = ContentAlignment.TopLeft;
            DatNomProd.Location = new Point(3, 23);
            DatNomProd.Name = "DatNomProd";
            DatNomProd.Size = new Size(215, 34);
            DatNomProd.TabIndex = 5;
            DatNomProd.Text = "Nombre Producto";
            DatNomProd.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // DatosProd
            // 
            DatosProd.AutoSize = true;
            tableLayoutPanel6.SetColumnSpan(DatosProd, 2);
            DatosProd.Dock = DockStyle.Fill;
            DatosProd.Location = new Point(3, 0);
            DatosProd.Name = "DatosProd";
            DatosProd.Size = new Size(437, 23);
            DatosProd.TabIndex = 2;
            DatosProd.Text = "Datos de producto";
            DatosProd.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // tableLayoutPanel13
            // 
            tableLayoutPanel13.ColumnCount = 2;
            tableLayoutPanel13.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel13.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            tableLayoutPanel13.Controls.Add(Bcargar, 1, 0);
            tableLayoutPanel13.Controls.Add(BGuardar, 0, 0);
            tableLayoutPanel13.Location = new Point(3, 543);
            tableLayoutPanel13.Name = "tableLayoutPanel13";
            tableLayoutPanel13.RowCount = 2;
            tableLayoutPanel13.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            tableLayoutPanel13.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel13.Size = new Size(186, 55);
            tableLayoutPanel13.TabIndex = 9;
            // 
            // Bcargar
            // 
            Bcargar.Dock = DockStyle.Fill;
            Bcargar.Location = new Point(96, 3);
            Bcargar.Name = "Bcargar";
            Bcargar.Size = new Size(87, 29);
            Bcargar.TabIndex = 10;
            Bcargar.Text = "Cargar";
            Bcargar.UseVisualStyleBackColor = true;
            // 
            // BGuardar
            // 
            BGuardar.Dock = DockStyle.Fill;
            BGuardar.Location = new Point(3, 3);
            BGuardar.Name = "BGuardar";
            BGuardar.Size = new Size(87, 29);
            BGuardar.TabIndex = 9;
            BGuardar.Text = "Guardar";
            BGuardar.UseVisualStyleBackColor = true;
            // 
            // VistaEstatica
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(960, 601);
            Controls.Add(tableLayoutPanel1);
            Name = "VistaEstatica";
            Text = "Form1";
            Load += VistaEstatica_Load;
            tableLayoutPanel1.ResumeLayout(false);
            tableLayoutPanel2.ResumeLayout(false);
            tableLayoutPanel3.ResumeLayout(false);
            tableLayoutPanel3.PerformLayout();
            tableLayoutPanel4.ResumeLayout(false);
            tableLayoutPanel4.PerformLayout();
            tableLayoutPanel5.ResumeLayout(false);
            tableLayoutPanel5.PerformLayout();
            tableLayoutPanel12.ResumeLayout(false);
            tableLayoutPanel12.PerformLayout();
            tableLayoutPanel11.ResumeLayout(false);
            tableLayoutPanel11.PerformLayout();
            tableLayoutPanel6.ResumeLayout(false);
            tableLayoutPanel6.PerformLayout();
            tableLayoutPanel8.ResumeLayout(false);
            tableLayoutPanel8.PerformLayout();
            tableLayoutPanel7.ResumeLayout(false);
            tableLayoutPanel7.PerformLayout();
            tableLayoutPanel10.ResumeLayout(false);
            tableLayoutPanel10.PerformLayout();
            tableLayoutPanel9.ResumeLayout(false);
            tableLayoutPanel9.PerformLayout();
            tableLayoutPanel13.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private void CategoriaSeleccionada(object sender, EventArgs e)
        {
            if (ListCat.SelectedItem != null)
            {
                string CategoriaSeleccionada = ListCat.SelectedItem.ToString();
                FiltrarPorCategoria?.Invoke(this, CategoriaSeleccionada);
            }
        }
        private void ProductoSeleccionado(object sender, EventArgs e)
        {
            if (ListProd.SelectedItem != null)
            {
                string ProductoSeleccionado = ListProd.SelectedItem.ToString();
                SacarInfoProducto?.Invoke(this, ProductoSeleccionado);
            }
        }
        private void EliminarProdSeleccionado(object sender, EventArgs e)
        {
            if (ListProd.SelectedItem != null)
            {
                string ProductoSeleccionado = ListProd.SelectedItem.ToString();
                EliminarProducto?.Invoke(this, ProductoSeleccionado);
            }
        }
        private void EliminarCatSeleccionado(object sender, EventArgs e)
        {
            if (ListCat.SelectedItem != null)
            {
                string CategoriaSeleccionada = ListCat.SelectedItem.ToString();
                EliminarCategoria?.Invoke(this, CategoriaSeleccionada);
            }
        }
        private void AñadirCat(object sender, EventArgs e)
        {
            AñadirCategoria?.Invoke(this, e);
        }
        private void ModificarCat(object sender, EventArgs e)
        {
            if (ListCat.SelectedItem != null)
            {
                string CategoriaSeleccionada = ListCat.SelectedItem.ToString();
                ModificarCategoria?.Invoke(this, CategoriaSeleccionada);
            }
        }
        private void ModificarProd(object sender, EventArgs e)
        {
            if (ListProd.SelectedItem != null)
            {
                string ProdSeleccionada = ListProd.SelectedItem.ToString();
                ModificarProducto?.Invoke(this, ProdSeleccionada);
            }
        }

        private void AñadirProd(object sender, EventArgs e)
        {
            AñadirProducto?.Invoke(this, e);
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void tableLayoutPanel4_Paint(object sender, PaintEventArgs e)
        {

        }

        private void tableLayoutPanel5_Paint(object sender, PaintEventArgs e)
        {

        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void textBoxProd_TextChanged(object sender, EventArgs e)
        {

        }

        private void IdCat_Click(object sender, EventArgs e)
        {

        }

        public void MostrarMensaje(string mensajeAmostrar)
        {
            MessageBox.Show(mensajeAmostrar);

        }

        private void Guardar_Click(Object sender, EventArgs e)
        {
           Guardar?.Invoke(this, e);
        }

        private void Cargar_Click(object sender, EventArgs e)
        {
            Cargar?.Invoke(this, e);
        }
    }
}
    

