using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace APPSTART
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            StartBack.Text = "START";
            front_server.Text = "START";
        }

        private void StartBack_Click(object sender, EventArgs e)
        {  
            StartBack.Text = "STARTING...";
            StartBack.Enabled = false;
            StartBack.BackColor = Color.Yellow;
            StartBack.ForeColor = Color.Black;
            shell.Text = shell.Text + "Click StartBack \n";
            StartBack.BackColor = Color.GreenYellow;
        }

        private void front_server_Click(object sender, EventArgs e)
        {
            front_server.Text = "STARTING...";
            front_server.Enabled = false;
            front_server.BackColor = Color.Yellow;
            front_server.ForeColor = Color.Black;
            shell.Text = shell.Text + "Click Front \n";
            front_server.BackColor = Color.GreenYellow;
        }

        private void Config_gen_Click(object sender, EventArgs e)
        {
            Config_gen.Text = "STARTING...";
            Config_gen.Enabled = false;
            Config_gen.BackColor = Color.Yellow;
            Config_gen.ForeColor = Color.Black;
            for (int i = 0; i < 50; i++) {
                addShell(i+"");


            }
            Config_gen.BackColor = Color.GreenYellow;
        }

        private void addShell(String txt) { addShell("INFO",txt); }
        private void addShell(String type,String txt) {
            shell.Text = "["+type+"] -> " + txt + " \n" + shell.Text;
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
