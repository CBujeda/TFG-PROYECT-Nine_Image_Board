﻿
namespace APPSTART
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.StartBack = new System.Windows.Forms.Button();
            this.front_server = new System.Windows.Forms.Button();
            this.Config_gen = new System.Windows.Forms.Button();
            this.start_all = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label5 = new System.Windows.Forms.Label();
            this.panel2 = new System.Windows.Forms.Panel();
            this.shell = new System.Windows.Forms.Label();
            this.goConfig = new System.Windows.Forms.Button();
            this.auto_install = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.test_node = new System.Windows.Forms.Button();
            this.panel4 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel3.SuspendLayout();
            this.panel4.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            resources.ApplyResources(this.label1, "label1");
            this.label1.Name = "label1";
            // 
            // label2
            // 
            resources.ApplyResources(this.label2, "label2");
            this.label2.Name = "label2";
            // 
            // label3
            // 
            resources.ApplyResources(this.label3, "label3");
            this.label3.Name = "label3";
            // 
            // StartBack
            // 
            resources.ApplyResources(this.StartBack, "StartBack");
            this.StartBack.Name = "StartBack";
            this.StartBack.UseVisualStyleBackColor = true;
            this.StartBack.Click += new System.EventHandler(this.StartBack_Click);
            // 
            // front_server
            // 
            resources.ApplyResources(this.front_server, "front_server");
            this.front_server.Name = "front_server";
            this.front_server.UseVisualStyleBackColor = true;
            this.front_server.Click += new System.EventHandler(this.front_server_Click);
            // 
            // Config_gen
            // 
            resources.ApplyResources(this.Config_gen, "Config_gen");
            this.Config_gen.Name = "Config_gen";
            this.Config_gen.UseVisualStyleBackColor = true;
            this.Config_gen.Click += new System.EventHandler(this.Config_gen_Click);
            // 
            // start_all
            // 
            resources.ApplyResources(this.start_all, "start_all");
            this.start_all.Name = "start_all";
            this.start_all.UseVisualStyleBackColor = true;
            this.start_all.Click += new System.EventHandler(this.start_all_Click);
            // 
            // label4
            // 
            resources.ApplyResources(this.label4, "label4");
            this.label4.Name = "label4";
            // 
            // panel1
            // 
            resources.ApplyResources(this.panel1, "panel1");
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel1.Controls.Add(this.label5);
            this.panel1.Name = "panel1";
            // 
            // label5
            // 
            resources.ApplyResources(this.label5, "label5");
            this.label5.Name = "label5";
            // 
            // panel2
            // 
            resources.ApplyResources(this.panel2, "panel2");
            this.panel2.BackColor = System.Drawing.Color.Black;
            this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel2.Controls.Add(this.shell);
            this.panel2.Name = "panel2";
            this.panel2.Paint += new System.Windows.Forms.PaintEventHandler(this.panel2_Paint);
            // 
            // shell
            // 
            resources.ApplyResources(this.shell, "shell");
            this.shell.ForeColor = System.Drawing.Color.Yellow;
            this.shell.Name = "shell";
            // 
            // goConfig
            // 
            resources.ApplyResources(this.goConfig, "goConfig");
            this.goConfig.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(128)))));
            this.goConfig.Name = "goConfig";
            this.goConfig.UseVisualStyleBackColor = false;
            this.goConfig.Click += new System.EventHandler(this.goConfig_Click);
            // 
            // auto_install
            // 
            resources.ApplyResources(this.auto_install, "auto_install");
            this.auto_install.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            this.auto_install.Name = "auto_install";
            this.auto_install.UseVisualStyleBackColor = false;
            this.auto_install.Click += new System.EventHandler(this.auto_install_Click);
            // 
            // label6
            // 
            resources.ApplyResources(this.label6, "label6");
            this.label6.Name = "label6";
            // 
            // panel3
            // 
            resources.ApplyResources(this.panel3, "panel3");
            this.panel3.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel3.Controls.Add(this.test_node);
            this.panel3.Controls.Add(this.label6);
            this.panel3.Controls.Add(this.auto_install);
            this.panel3.Name = "panel3";
            // 
            // test_node
            // 
            resources.ApplyResources(this.test_node, "test_node");
            this.test_node.BackColor = System.Drawing.Color.LemonChiffon;
            this.test_node.Name = "test_node";
            this.test_node.UseVisualStyleBackColor = false;
            this.test_node.Click += new System.EventHandler(this.test_node_Click);
            // 
            // panel4
            // 
            resources.ApplyResources(this.panel4, "panel4");
            this.panel4.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel4.Controls.Add(this.label4);
            this.panel4.Controls.Add(this.start_all);
            this.panel4.Name = "panel4";
            // 
            // Form1
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.goConfig);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.Config_gen);
            this.Controls.Add(this.front_server);
            this.Controls.Add(this.StartBack);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.panel4);
            this.Controls.Add(this.panel3);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button StartBack;
        private System.Windows.Forms.Button front_server;
        private System.Windows.Forms.Button Config_gen;
        private System.Windows.Forms.Button start_all;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label shell;
        private System.Windows.Forms.Button goConfig;
        private System.Windows.Forms.Button auto_install;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.Button test_node;
    }
}

