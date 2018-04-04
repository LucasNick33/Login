package br.edu.ifmt.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas 2667
 */
public class BaseDao {
    
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/padrao";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection con;

    // Conectar ao banco
    private static void abrir() {
        try {
            // Registrar o driver
            Class.forName(DRIVER);
            // Capturar a conexão
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getCon(){
        if(con == null){
            abrir();
        }
        return con;
    }
    
}
