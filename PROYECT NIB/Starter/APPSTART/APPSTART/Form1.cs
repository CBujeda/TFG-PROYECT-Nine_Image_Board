using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
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
        Thread t0;
        Thread t1;
        Thread t2;

        public Form1()
        {
            InitializeComponent();
            Config_gen.Enabled = false;
            StartBack.Enabled = false;
            front_server.Enabled = false;
            front_server.Text = "STOP";
            StartBack.Text = "STOP";
            StartBack.BackColor = Color.Red;
            front_server.BackColor = Color.Red;
            Config_gen.BackColor = Color.Orange;
            start_all.Text = "START";
            addShell("Aplicación Iniciada");
        }
        private void start_all_Click(object sender, EventArgs e)
        {
            start_all.BackColor = Color.GreenYellow;
            StartBack.BackColor = Color.GreenYellow;
            front_server.BackColor = Color.GreenYellow;
            Thread.Sleep(1000);
            front_server.Text = "STARTED";
            StartBack.Text = "STARTED";
            start_all.Text = "STARTED";
            start_all.Enabled = false;
            StartBack.Enabled = false;
            front_server.Enabled = false;
            this.t0 = new Thread(() => ExecuteCommand("start \"\" configurator.bat"));
            this.t0.Start();
            this.t0.Join();
            this.t1 = new Thread(() => ExecuteCommand("start \"\" \"./Start Backend.bat\""));
            this.t1.Start();
            this.t2 = new Thread(() => ExecuteCommand("start \"\" \"./Start Front.bat\""));
            this.t2.Start();
            
            while (true) {
                Thread.Sleep(1000);
                if (!this.t1.IsAlive && !this.t2.IsAlive) {
                    break;
                }
            }
            start_all.BackColor = Color.Empty;
            StartBack.BackColor = Color.Red;
            front_server.BackColor = Color.Red;
            start_all.Text = "START";
            front_server.Text = "STOP";
            StartBack.Text = "STOP";
            start_all.Enabled = true;
            StartBack.Enabled = true;
            front_server.Enabled = true;
            // Terminar
        }
        private void StartBack_Click(object sender, EventArgs e)
        {
            
            
        }

      

        private void front_server_Click(object sender, EventArgs e)
        {
        }

        private void Config_gen_Click(object sender, EventArgs e)
        {

        }

        private void addShell(String txt) { addShell("INFO", txt); }
        private void addShell(String type, String txt) {
            shell.Text = "『" + getTime() + "』" + " [" + type + "] ► " + txt + " \n" + shell.Text;
        }
        public String getTime() {
            return DateTime.Now.ToString("HH:mm:ss tt");
        }


        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }


        private void ExecuteCommand(string command)
        {
            int exitCode;
            ProcessStartInfo processInfo;
            Process process;

            processInfo = new ProcessStartInfo("cmd.exe", "/c " + command);
            processInfo.CreateNoWindow = true;
            processInfo.UseShellExecute = false;
            // *** Redirect the output ***
            processInfo.RedirectStandardError = true;
            processInfo.RedirectStandardOutput = true;

            process = Process.Start(processInfo);
            process.WaitForExit();

            // *** Read the streams ***
            // Warning: This approach can lead to deadlocks, see Edit #2
            string output = process.StandardOutput.ReadToEnd();
            string error = process.StandardError.ReadToEnd();
            String dta = ("output>>" + (String.IsNullOrEmpty(output) ? "(none)" : output));
            
            exitCode = process.ExitCode;
            Console.WriteLine("output>>" + (String.IsNullOrEmpty(output) ? "(none)" : output));
            Console.WriteLine("error>>" + (String.IsNullOrEmpty(error) ? "(none)" : error));
            Console.WriteLine("ExitCode: " + exitCode.ToString(), "ExecuteCommand");
            process.Close();

        }

        private void goConfig_Click(object sender, EventArgs e)
        {
            CopnfigProperties c = new CopnfigProperties();
            c.ShowDialog();
        }
    }

}
