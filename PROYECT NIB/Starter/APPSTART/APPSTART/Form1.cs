using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace APPSTART
{
    public partial class Form1 : Form
    {
        private bool var_startback;
        public Form1()
        {
            InitializeComponent();
            StartBack.Text = "START";
            var_startback = false;
        }

        private void StartBack_Click(object sender, EventArgs e)
        {
            if (var_startback == true)
            {
                var_startback = false;
                StartBack.Text = "START";
            }
            else {
                var_startback = true;
                StartBack.Text = "STOP";
            }
        }
    }
}
