package com.br.cacique.MVCModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static final String BANCO = "mack";
    public static final String USUARIO = "root";
    public static final String SENHA = "root";
    
    private ConnectionFactory(){        
    }
    
    public static Connection getConnection()  throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost/"+BANCO+";create=true;user="+USUARIO+";password="+SENHA);
    }

}
