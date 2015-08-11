package br.lp.connectionfactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Lê um arquivo .properties contendo as configurações do banco de dados, e cria
 * uma conexão.
 *
 * @author bruce
 */
public class ConnectionFactory {

    public static String BANCO;
    public static String USUARIO = "root";
    public static String SENHA = "root";

    public ConnectionFactory() {
        //Faz a leitura do arquivo
        final String CONFIGFILE = "config/dbconf.properties";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(CONFIGFILE));
            Properties properties = new Properties();
            properties.load(reader);

            /*Seta as propriedades do banco, caso haja algum erro no arquivo
             elas serão inicializadas com valores padrão.  */
            BANCO = properties.getProperty("database", "mack");
            USUARIO = properties.getProperty("username", "root");
            SENHA = properties.getProperty("password", "root");
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo de configuração não encontrado");
        } catch (IOException ex) {
            System.err.println("IOException");
            System.err.println(ex.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.err.println("Erro ao fechar o leitor de arquivo");
            }
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost/" + BANCO + ";create=true;user=" + USUARIO + ";password=" + SENHA);

    }

}
