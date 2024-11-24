/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author u06614150154
 */
public class JdbcInsert {
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
            Statement stm = cnt.createStatement();
            //stm.executeUpdate("");
        } catch (ClassNotFoundException ex) {
            System.out.println("erro class:"+ex.getMessage());
            System.exit(0);
        } catch (SQLException ex) {
            //Logger.getLogger(JdbcInsert.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
        System.out.println("rodou");
    }
            
}
