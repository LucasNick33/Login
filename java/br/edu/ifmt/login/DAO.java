package br.edu.ifmt.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas 2667
 */
public class DAO {
    
    public static boolean login(String login, String senha){
        try {
            String sql = "SELECT COUNT(0) FROM USUARIO WHERE LOGIN = ? AND SENHA = ?;";
            PreparedStatement ps = BaseDao.getCon().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean retorno = rs.getInt(1) > 0;
            ps.close();
            rs.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
