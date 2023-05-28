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
using System.Net;

namespace APPSTART
{
    public partial class Form1 : Form
    {
        Thread t0;

        //private BackgroundWorker backgroundWorker;

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

        //-----------------------START APP

        private void executebat(String path) {
            string batFilePath = @"" + path + "";
            Process process = new Process();
            process.StartInfo.FileName = "cmd.exe";
            process.StartInfo.Arguments = "/c " + batFilePath;
            process.StartInfo.CreateNoWindow = true;
            process.StartInfo.UseShellExecute = false;
            process.Start();
            process.WaitForExit();
            int exitCode = process.ExitCode;
            Console.WriteLine("Exit Code: " + exitCode);
            addShell(" [ Exit Code ] " + exitCode);
        }

        private void start_all_Click(object sender, EventArgs e)
        {
            addShell("Scripts Iniciados");
            this.t0 = new Thread(() => this.executebat("\"./Start Auto.bat\""));
            this.t0.Start();
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

        // ------------------------ Integrated shell
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

        private void goConfig_Click(object sender, EventArgs e)
        {
            CopnfigProperties c = new CopnfigProperties();
            c.ShowDialog();
        }

        //-----------------------INSTALL SECCTION -----------------------

        private void auto_install_Click(object sender, EventArgs e)
        {
            if (!testNode()) {
                addShell("", "Descargando version de node");

            }
        }
        private void test_node_Click(object sender, EventArgs e)
        {
            testNode();
        }

        private String nodeVersion = "v18.12.0";
        private String node64 = "https://nodejs.org/dist/v18.12.0/node-v18.12.0-x64.msi";
        private String node86 = "https://nodejs.org/dist/v18.12.0/node-v18.12.0-x86.msi";
        private void download(String urlDownlad, String name) {

            {
                //string url = "https://www.example.com/archivo.zip"; // URL del archivo a descargar
                string destino = @".down/"; // Ruta de destino para guardar el archivo descargado

                WebClient webClient = new WebClient();

                try
                {
                    webClient.DownloadFile(urlDownlad, destino);
                    Console.WriteLine("Descarga completada.");
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error al descargar el archivo: " + ex.Message);
                }
            }
        }

        private Boolean test64_86(){

            return true;
        }

        private Boolean testNode() {
            // Ejecutar el comando "node --version" en el símbolo del sistema
            string output = RunCommand("node --version");
            if (!string.IsNullOrEmpty(output))
            {
                addShell("", "Node.js está instalado.");
                addShell("", "Versión: " + output);
                if (output.Equals(this.nodeVersion)) {
                    return true;
                }
                else
                {
                    return false;
                }
                
            }
            else
            {
                addShell("", "Node.js no está instalado.");
                return false;
            }
        }


        static string RunCommand(string command)
        {
            Process process = new Process();
            process.StartInfo.FileName = "cmd.exe";
            process.StartInfo.Arguments = "/c " + command;
            process.StartInfo.RedirectStandardOutput = true;
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.CreateNoWindow = true;

            process.Start();
            string output = process.StandardOutput.ReadToEnd().Trim();
            process.WaitForExit();

            return output;
        }

        
    }
}
