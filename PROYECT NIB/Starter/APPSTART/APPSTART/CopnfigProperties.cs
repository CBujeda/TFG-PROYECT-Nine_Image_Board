using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace APPSTART
{
    public partial class CopnfigProperties : Form
    {

        DataTable dt;

        public CopnfigProperties()
        {
            InitializeComponent();
            txtFilePath.Text = "./config.properties";
            bindData("./config.properties");
           


        }

        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            String path = openFileDialog1.FileName;
            txtFilePath.Text = path;
            String[] extension = path.Split(".");
            if (extension.Length >= 2) {
                if (extension[1].Equals("properties")) {
                    bindData(path);
                }
                else
                {
                    txtFilePath.Text = "No es valido";
                }
            }
            
        }
        private void bindData(String path)
        {
            dt = new DataTable();
            String[] lines = {};
            try
            {
                lines = System.IO.File.ReadAllLines(path);
            }
            catch { }
            if (lines.Length > 0) {
                String[] headerLavels = { "Propiedades", "Values" };
                foreach (String headerWord in headerLavels) {
                    dt.Columns.Add(new DataColumn(headerWord));
                }
                for (int i = 0; i < lines.Length;i++) {
                    String[] dataWord = lines[i].Split("=");
                    if (dataWord.Length == 2) { 
                        DataRow dr = dt.NewRow();
                        int columnIndex = 0;
                        foreach (String headerWord in headerLavels)
                        {
                            dr[headerWord] = dataWord[columnIndex++];
                            
                        }
                        dt.Rows.Add(dr);
                    }
                    
                }
            }

            if (dt.Rows.Count> 0) {
                ConfigDataView.DataSource = dt;
                ConfigDataView.Columns["Values"].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
                ConfigDataView.Columns["Propiedades"].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
                changeColors();
            }
        }
        
        private void changeColors() {
            foreach (DataGridViewRow row in ConfigDataView.Rows)
            {
                foreach (DataGridViewColumn col in ConfigDataView.Columns)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.Append(ConfigDataView[0, row.Index].Value);
                    
                    if (sb.ToString().Contains("#")) { 
                    ConfigDataView[col.Index, row.Index].Style.BackColor = Color.Green;
                    }
                }
            }
      
        }
        private void Edit_Click(object sender, EventArgs e)
        {
            
        }
        private void editToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String url = txtFilePath.Text;
            Process.Start("notepad.exe", url);
        }


        private void ConfigDataView_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            //var row = ConfigDataView.Rows[e.RowIndex];
            //var changedValue = (string)row.Cells[e.ColumnIndex].Value;
            //System.Console.WriteLine(changedValue.ToString());
        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
        }



        //------------------------------------------------------------

        private void aplicarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }
        private void ConfigDataView_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {

        }


        private void txtFilePath_Click(object sender, EventArgs e)
        {

        }

        private void ConfigDataView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        
    }
}
