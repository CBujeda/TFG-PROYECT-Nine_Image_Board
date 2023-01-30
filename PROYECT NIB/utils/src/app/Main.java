package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	
	private static String _fCyan="[36m";
	private static String _fBMag="[95m";
	public static void main(String[] args) {

		Properties prop = new Properties();

		File f = new File("");
		String path = f.getAbsolutePath();
		String[] fold = path.split("\\\\");
		String path_raiz = "";
		for (int i = 0; i < fold.length - 2; i++) {
			path_raiz = path_raiz + "\\" + fold[i];
		}
		System.out.println("Generando proyecto.. \n In >"+path_raiz);
		File backprops = new File(path_raiz + "\\PROYECT NIB\\Compiled\\back.properties");
		File frontStart = new File(path_raiz + "\\Start Front.bat");
		File backStart = new File(path_raiz + "\\Start Backend.bat");
		File props = new File(path_raiz + "\\config.properties");
		if (props.exists()) {
			try {
				InputStream is = new FileInputStream(props);
				try {
					prop.load(is);
					String NIB_B_Port = prop.getProperty("NIB_B_Port");
					String NIB_F_Port = prop.getProperty("NIB_F_Port");
					String NIB_B_ip = prop.getProperty("NIB_B_ip");
					String MySql_ip = prop.getProperty("MySql_ip");
					String MySql_port = prop.getProperty("MySql_Port");
					String MySql_bbdd = prop.getProperty("MySql_bbdd");
					String MySql_user = prop.getProperty("MySql_user");
					String MySql_pass = prop.getProperty("MySql_passs");
					String NIB_B_Version = prop.getProperty("NIB_B_Version");
					
					String ngPath = prop.getProperty("ngPath");
					String javaPath = prop.getProperty("javaPath");
					// Default Values
					if(ngPath == null) {ngPath = "ng";}
					if(javaPath == null) {javaPath = "java";}
					if(NIB_B_Port == null) {NIB_B_Port = "3000";}
					if(NIB_F_Port == null) {NIB_F_Port = "8080";}
					if(NIB_B_ip == null) {NIB_B_ip = "localhost";}
					if(MySql_ip == null) {MySql_ip = "localhost";}
					if(MySql_port == null) {MySql_port = "3306";}
					if(MySql_bbdd == null) {MySql_bbdd = "ninbooru";}
					if(MySql_user == null) {MySql_user = "root";}
					if(MySql_pass == null) {MySql_pass = "root";}
					if(NIB_B_Version == null) {NIB_B_Version = "0.0.1-SNAPSHOT";}
					
					System.out.println("[GEN] back.properties");
					String genPropBack = ""
							+ "server.port="+NIB_B_Port+"\n"
							+ "spring.datasource.url=jdbc:mysql://"+MySql_ip+":"+MySql_port+"/"+MySql_bbdd+"\n"
							+ "spring.datasource.username="+MySql_user+"\n"
							+ "spring.datasource.password="+MySql_pass+"\n"
							+ "spring.datasource.driver-class-name=com.mysql.jdbc.Driver"+"\n"
							+ "pring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect"+"\n"
							+ "spring.jpa.generate-ddl=true"+"\n"
							+ "spring.jpa.hibernate.ddl-auto=update"+"\n";
					
					// Back props
					Formatter fo = new Formatter(backprops);
					fo.format(genPropBack);
					fo.flush();
					fo.close();
					System.out.println("[GEN] Start Front.bat");
					String genStartFront = 
							"cd ./PROYECT NIB \n"
							+ "cd ./FrontEnd_NIB \n"
							+ "title NINE IMAGE BOARD - FrontEnd \n"
							+ "chcp 1252 \n"
							+ "@ECHO OFF \n"
							+ "cls \n"
							+ "echo. \n"
							+ "echo.                          \n"
							+ "echo          ,--.                   \n"
							+ "echo        ,--.'^|   ,---,    ,---,. \r\n"
							+ "echo    ,--,:  : ^|,`--.' ^|  ,'  .'  \\\r\n"
							+ "echo ,`--.'`^|  ' :^|   :  :,---.' .' ^|\r\n"
							+ "echo ^|   :  :  ^| ^|:   ^|  '^|   ^|  ^|: ^|\r\n"
							+ "echo :   ^|   \\ ^| :^|   :  ^|:   :  :  /\r\n"
							+ "echo ^|   : '  '; ^|'   '  ;:   ^|    ; \r\n"
							+ "echo '   ' ;.    ;^|   ^|  ^|^|   :     \\\r\n"
							+ "echo ^|   ^| ^| \\   ^|'   :  ;^|   ^|   . ^|\r\n"
							+ "echo '   : ^|  ; .'^|   ^|  ''   :  '; ^|\r\n"
							+ "echo ^|   ^| '`--'  '   :  ^|^|   ^|  ^| ; \r\n"
							+ "echo '   : ^|      ;   ^|.' ^|   :   /     \r\n"
							+ "echo ;   ^|.'      '---'   ^|   ^| ,'   		(v1.0.1)\r\n"
							+ "echo '---'                `----'     \r\n"
							+ "echo Power by Angular\r\n"
							+ "echo.\r\n"
							+ ""+ngPath+" serve --port "+NIB_F_Port+"\r\n"
							+ "pause > nul\r\n"
							+ "exit";
					Formatter foStart = new Formatter(frontStart);
					foStart.format(genStartFront);
					foStart.flush();
					foStart.close();
					System.out.println("[GEN] Start Backend.bat");
					String genStartBack = 
							"cd ./PROYECT NIB \r\n"
							+ "cd ./Compiled \r\n"
							+ "title NINE IMAGE BOARD - BackendEnd \r\n"
							+ "\r\n"
							+ "@ECHO OFF\r\n"
							+ "cls\r\n"
							+ "echo."+_fCyan+"\r\n"
							+ "echo.                          \r\n"
							+ "echo          ,--.                   \r\n"
							+ "echo        ,--.'^|   ,---,    ,---,. \r\n"
							+ "echo    ,--,:  : ^|,`--.' ^|  ,'  .'  \\\r\n"
							+ "echo ,`--.'`^|  ' :^|   :  :,---.' .' ^|\r\n"
							+ "echo ^|   :  :  ^| ^|:   ^|  '^|   ^|  ^|: ^|\r\n"
							+ "echo :   ^|   \\ ^| :^|   :  ^|:   :  :  /\r\n"
							+ "echo ^|   : '  '; ^|'   '  ;:   ^|    ; \r\n"
							+ "echo '   ' ;.    ;^|   ^|  ^|^|   :     \\\r\n"
							+ "echo ^|   ^| ^| \\   ^|'   :  ;^|   ^|   . ^|\r\n"
							+ "echo '   : ^|  ; .'^|   ^|  ''   :  '; ^|\r\n"
							+ "echo ^|   ^| '`--'  '   :  ^|^|   ^|  ^| ; \r\n"
							+ "echo '   : ^|      ;   ^|.' ^|   :   /     \r\n"
							+ "echo ;   ^|.'      '---'   ^|   ^| ,'   		(v1.0.1)\r\n"
							+ "echo '---'                `----'     \r\n"
							+ "echo 	Power by SpringBoot\r\n"+ "echo "+_fBMag+" \n"
							+ "\r\n"
							+ "\""+javaPath+"\" -jar Backend_NIB-"+NIB_B_Version + ".jar --spring.config.location=back.properties"+"\n"
							+ "pause > nul \n"
							+ "exit";
					
					Formatter fbStart = new Formatter(backStart);
					fbStart.format(genStartBack);
					fbStart.flush();
					fbStart.close();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No existe archivo de propiedades");
		}
	}
}
