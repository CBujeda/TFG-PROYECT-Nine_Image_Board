
namespace APPSTART
{
    partial class CopnfigProperties
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CopnfigProperties));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.Archivo = new System.Windows.Forms.ToolStripDropDownButton();
            this.abrirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aplicarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.guardarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.resetearToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.Separator = new System.Windows.Forms.ToolStripLabel();
            this.txtFilePath = new System.Windows.Forms.ToolStripLabel();
            this.ConfigDataView = new System.Windows.Forms.DataGridView();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ConfigDataView)).BeginInit();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.Archivo,
            this.Separator,
            this.txtFilePath});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(800, 27);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // Archivo
            // 
            this.Archivo.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Archivo.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.abrirToolStripMenuItem,
            this.editToolStripMenuItem,
            this.aplicarToolStripMenuItem,
            this.guardarToolStripMenuItem,
            this.resetearToolStripMenuItem});
            this.Archivo.Image = ((System.Drawing.Image)(resources.GetObject("Archivo.Image")));
            this.Archivo.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Archivo.Name = "Archivo";
            this.Archivo.Size = new System.Drawing.Size(73, 24);
            this.Archivo.Text = "Archivo";
            // 
            // abrirToolStripMenuItem
            // 
            this.abrirToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("abrirToolStripMenuItem.Image")));
            this.abrirToolStripMenuItem.Name = "abrirToolStripMenuItem";
            this.abrirToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.abrirToolStripMenuItem.Text = "Abrir";
            this.abrirToolStripMenuItem.Click += new System.EventHandler(this.abrirToolStripMenuItem_Click);
            // 
            // editToolStripMenuItem
            // 
            this.editToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("editToolStripMenuItem.Image")));
            this.editToolStripMenuItem.Name = "editToolStripMenuItem";
            this.editToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.editToolStripMenuItem.Text = "Edit";
            this.editToolStripMenuItem.Click += new System.EventHandler(this.editToolStripMenuItem_Click);
            // 
            // aplicarToolStripMenuItem
            // 
            this.aplicarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("aplicarToolStripMenuItem.Image")));
            this.aplicarToolStripMenuItem.Name = "aplicarToolStripMenuItem";
            this.aplicarToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.aplicarToolStripMenuItem.Text = "Aplicar";
            this.aplicarToolStripMenuItem.Visible = false;
            this.aplicarToolStripMenuItem.Click += new System.EventHandler(this.aplicarToolStripMenuItem_Click);
            // 
            // guardarToolStripMenuItem
            // 
            this.guardarToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("guardarToolStripMenuItem.Image")));
            this.guardarToolStripMenuItem.Name = "guardarToolStripMenuItem";
            this.guardarToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.guardarToolStripMenuItem.Text = "Guardar";
            this.guardarToolStripMenuItem.Visible = false;
            this.guardarToolStripMenuItem.Click += new System.EventHandler(this.guardarToolStripMenuItem_Click);
            // 
            // resetearToolStripMenuItem
            // 
            this.resetearToolStripMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("resetearToolStripMenuItem.Image")));
            this.resetearToolStripMenuItem.Name = "resetearToolStripMenuItem";
            this.resetearToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.resetearToolStripMenuItem.Text = "Resetear";
            this.resetearToolStripMenuItem.Visible = false;
            // 
            // Separator
            // 
            this.Separator.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.Separator.Name = "Separator";
            this.Separator.Size = new System.Drawing.Size(13, 24);
            this.Separator.Text = "|";
            // 
            // txtFilePath
            // 
            this.txtFilePath.Name = "txtFilePath";
            this.txtFilePath.Size = new System.Drawing.Size(17, 24);
            this.txtFilePath.Text = "$";
            this.txtFilePath.Click += new System.EventHandler(this.txtFilePath_Click);
            // 
            // ConfigDataView
            // 
            this.ConfigDataView.AllowUserToDeleteRows = false;
            this.ConfigDataView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.ConfigDataView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ConfigDataView.Location = new System.Drawing.Point(0, 27);
            this.ConfigDataView.Name = "ConfigDataView";
            this.ConfigDataView.ReadOnly = true;
            this.ConfigDataView.RowHeadersWidth = 51;
            this.ConfigDataView.RowTemplate.Height = 29;
            this.ConfigDataView.Size = new System.Drawing.Size(800, 423);
            this.ConfigDataView.TabIndex = 2;
            this.ConfigDataView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.ConfigDataView_CellContentClick);
            this.ConfigDataView.CellEndEdit += new System.Windows.Forms.DataGridViewCellEventHandler(this.ConfigDataView_CellEndEdit);
            this.ConfigDataView.CellValueChanged += new System.Windows.Forms.DataGridViewCellEventHandler(this.ConfigDataView_CellValueChanged);
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "config.properties";
            // 
            // CopnfigProperties
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.ConfigDataView);
            this.Controls.Add(this.toolStrip1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "CopnfigProperties";
            this.Text = "Configuración";
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ConfigDataView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripDropDownButton Archivo;
        private System.Windows.Forms.ToolStripMenuItem guardarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem resetearToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aplicarToolStripMenuItem;
        private System.Windows.Forms.DataGridView ConfigDataView;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.ToolStripMenuItem abrirToolStripMenuItem;
        private System.Windows.Forms.ToolStripLabel txtFilePath;
        private System.Windows.Forms.ToolStripLabel Separator;
        private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
    }
}