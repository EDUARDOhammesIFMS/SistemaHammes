/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Vendedor;
import com.mysql.cj.protocol.Resultset;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author rooki
 */
public class VendedorDAO extends DAO_Abstract{
    
    private Connection cnt;
    
    public VendedorDAO(){
    
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://localhost:3306/lojaPeçaCarro?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
            user = "root";
            pass = "";
//           url = "jdbc:mysql://10.7.0.51:33062/db_eduardo_aquino";
//           user = "eduardo_aquino";
//           pass = "eduardo_aquino";
            
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("erro class:"+ex.getMessage());
            System.exit(0);
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }
    
    @Override
    public void insert(Object object) {
        Vendedor vendedor = (Vendedor) object;
        
        try {
            String sql = "insert into vendedor_eha values(?,?,?,?,?,?,?,?,     ?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, vendedor.getId_vendedor_eha());
            pst.setString(2, vendedor.getNome_eha());
            pst.setString(3, vendedor.getCpf_eha());
            pst.setString(4, vendedor.getTelefone_eha());
            pst.setString(5, vendedor.getEmail_eha());
            pst.setDate(6, (Date) vendedor.getDataContratacao_eha());
            pst.setInt(7, vendedor.getSalario_eha());
            pst.setString(8, vendedor.getStatus_eha());
            
            pst.setString(9, null); //fk
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Object object) {
        Vendedor vendedor = (Vendedor) object;

        try {
            
            String sql = "update vendedor_eha set nome_eha = ?, cpf_eha = ?, telefone_eha = ?, "
                    + "email_eha = ?, dataContratacao_eha = ?, salario_eha = ?, status_eha = ?, fk_venda_eha = ? "
                    + "where id_vendedor_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(9, vendedor.getId_vendedor_eha());
            pst.setString(1, vendedor.getNome_eha());
            pst.setString(2, vendedor.getCpf_eha());
            pst.setString(3, vendedor.getTelefone_eha());
            pst.setString(4, vendedor.getEmail_eha());
            pst.setDate(5, (Date) vendedor.getDataContratacao_eha());
            pst.setInt(6, vendedor.getSalario_eha());
            pst.setString(7, vendedor.getStatus_eha());
            
            pst.setString(8, null); //fk
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro sql:" + ex.getMessage());
            System.exit(0);
        }
        
    }

    @Override
    public void delete(Object object) {
        Vendedor vendedor = (Vendedor) object;

        try {
            String sql = "delete from vendedor_eha where id_vendedor_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, vendedor.getId_vendedor_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public Object list(int id) {
        Vendedor vendedor = new Vendedor();
        try {
            
            String sql = "select * from  vendedor_eha where id_vendedor_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                vendedor.setId_vendedor_eha(rs.getInt("id_vendedor_eha"));
                vendedor.setNome_eha(rs.getString("nome_eha"));
                vendedor.setCpf_eha(rs.getString("cpf_eha"));
                vendedor.setEmail_eha(rs.getString("email_eha"));
                vendedor.setTelefone_eha(rs.getString("telefone_eha"));
                vendedor.setDataContratacao_eha(rs.getDate("dataContratacao_eha"));
                vendedor.setSalario_eha(rs.getInt("salario_eha"));
                vendedor.setStatus_eha(rs.getString("status_eha"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        return vendedor;
    }

    @Override
    public ArrayList listAll() {
        return null;
    }
    
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor();
        
                vendedor.setId_vendedor_eha(1);
                vendedor.setNome_eha("piter");
                vendedor.setCpf_eha("06614150154");
                vendedor.setEmail_eha("piter@gmail.com");
                vendedor.setTelefone_eha("6796357155");
                vendedor.setDataContratacao_eha(null);
                vendedor.setSalario_eha(2110);
                vendedor.setStatus_eha("saudável");
        
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.insert(vendedor);
    }
}
