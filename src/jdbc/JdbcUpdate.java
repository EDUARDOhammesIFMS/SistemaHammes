/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u06614150154
 */
public class JdbcUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://localhost:3306/lojaPeçaCarro?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            user = "root";
            pass = "";
//           url = "jdbc:mysql://10.7.0.51:33062/db_eduardo_aquino";
//           user = "eduardo_aquino";
//           pass = "eduardo_aquino";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, pass);
            String sql = "update grupo set nome=?, ativo=? where idgrupo=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
//            pst.setString(1, "nao sei");
//            pst.setString(2, "N");
//            pst.setInt(3, 6);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
