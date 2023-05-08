package com.nib.app.utils.sqLite;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nib.app.utils.NIBShell;

public class SLUtils {
	
	private Connection connection;
	private String id_bbdd;
	
	private final String mainTable = "Master";
    public  Connection getConnection(String id_bbdd) {
        Connection connection = null;
        this.id_bbdd = id_bbdd;
        try {
            Class.forName("org.sqlite.JDBC");
            File dbFile = new File("staticBBDD/"+id_bbdd+".db");
            if (!dbFile.getParentFile().exists()) {
                dbFile.getParentFile().mkdirs();
            }
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath());
            //createTables(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        this.connection = connection;
        return connection;
    }

    public void createTables() throws SQLException {
    		this.printInfoSql("Creando Tablas de NIB BBDD 'Id = " + this.id_bbdd +"'" );
			PreparedStatement statement = this.connection.prepareStatement(
					  " CREATE TABLE IF NOT EXISTS "+mainTable+" ( "
	        		+ "	iddb_binary	INTEGER PRIMARY KEY AUTOINCREMENT, "
	        		+ "	Binary	BLOB, "
	        		+ "	id_img	INTEGER );"
				);
			statement.executeUpdate();
    }
    
    public void savePost(byte[] imageBytes,Long ext) throws SQLException {
    	PreparedStatement pstmt = this.connection.prepareStatement(
    			"INSERT INTO "+mainTable+" (Binary,id_img) VALUES (?,?)"
    			);
    	pstmt.setBytes(1, imageBytes);
    	pstmt.setFloat(2, ext);
    	pstmt.executeUpdate();
    	pstmt.close();
    	this.connection.close();
    }
    
    public byte[] getPostByIdPost(Long id) {
    	try {
			PreparedStatement pstmt = 
					this.connection.prepareStatement(
							"SELECT Binary FROM "+mainTable+" WHERE id_img = ?"
							);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			byte[] imageBytes = rs.getBytes("Binary");
			rs.close();
			pstmt.close();
			this.closeConexion();
			return imageBytes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
    
    
    public void closeConexion() {
    	try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void printInfoSql(String str) {
    	new NIBShell().printInfoSql(str);
    }
}
