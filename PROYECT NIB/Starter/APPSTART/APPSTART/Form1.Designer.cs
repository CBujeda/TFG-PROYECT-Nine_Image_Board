
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.StartBack = new System.Windows.Forms.Button();
            this.front_server = new System.Windows.Forms.Button();
            this.Config_gen = new System.Windows.Forms.Button();
            this.start_all = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 68);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(85, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "Back Server";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 104);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(88, 20);
            this.label2.TabIndex = 1;
            this.label2.Text = "Front Server";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 136);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(83, 20);
            this.label3.TabIndex = 2;
            this.label3.Text = "Config Gen";
            // 
            // StartBack
            // 
            this.StartBack.Location = new System.Drawing.Point(124, 64);
            this.StartBack.Name = "StartBack";
            this.StartBack.Size = new System.Drawing.Size(94, 29);
            this.StartBack.TabIndex = 3;
            this.StartBack.Text = "NONE";
            this.StartBack.UseVisualStyleBackColor = true;
            this.StartBack.Click += new System.EventHandler(this.StartBack_Click);
            // 
            // front_server
            // 
            this.front_server.Location = new System.Drawing.Point(124, 100);
            this.front_server.Name = "front_server";
            this.front_server.Size = new System.Drawing.Size(94, 29);
            this.front_server.TabIndex = 4;
            this.front_server.Text = "NONE";
            this.front_server.UseVisualStyleBackColor = true;
            // 
            // Config_gen
            // 
            this.Config_gen.Location = new System.Drawing.Point(124, 136);
            this.Config_gen.Name = "Config_gen";
            this.Config_gen.Size = new System.Drawing.Size(94, 29);
            this.Config_gen.TabIndex = 5;
            this.Config_gen.Text = "NONE";
            this.Config_gen.UseVisualStyleBackColor = true;
            // 
            // start_all
            // 
            this.start_all.Location = new System.Drawing.Point(606, 64);
            this.start_all.Name = "start_all";
            this.start_all.Size = new System.Drawing.Size(94, 29);
            this.start_all.TabIndex = 6;
            this.start_all.Text = "NONE";
            this.start_all.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(488, 68);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(78, 20);
            this.label4.TabIndex = 7;
            this.label4.Text = "START ALL";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.panel1.Location = new System.Drawing.Point(3, 46);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(252, 148);
            this.panel1.TabIndex = 8;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.start_all);
            this.Controls.Add(this.Config_gen);
            this.Controls.Add(this.front_server);
            this.Controls.Add(this.StartBack);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Form1";
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
    }
}

