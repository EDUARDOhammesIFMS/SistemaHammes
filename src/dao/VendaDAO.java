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
import bean.Venda;
import com.mysql.cj.protocol.Resultset;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author rooki
 */
public class VendaDAO extends DAO_Abstract{
    
    private Connection cnt;
    
    public VendaDAO(){
    
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://localhost:3306/lojaPeçaCarro?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
        Venda venda = (Venda) object;
        
        try {
            String sql = "insert into venda_eha values(?,?,?,?,?,?,?,?,     ?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, venda.getId_venda_eha());
            pst.setString(2, venda.getFormaPagamento_eha());
            pst.setDate(3, (Date) venda.getDataVenda_eha());
            pst.setInt(4, venda.getTaxaEntrega_eha());
            pst.setString(5, venda.getLocal_eha());
            pst.setString(6, venda.getStatusEntrega_ldm());
            pst.setInt(7, venda.getValorTotal_eha());
            pst.setInt(8, venda.getDesconto_eha());
            
            pst.setString(9, null); //fk
            pst.setString(10, null);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Object object) {
        Venda venda = (Venda) object;

        try {
            
            String sql = "update venda_eha set formaPagamento_eha = ?, dataVenda_eha = ?, taxaEntrega_eha = ?, "
                    + "local_eha = ?, statusEntrega_ldm = ?, valorTotal_eha = ?, desconto_eha = ?, fk_cliente_eha = ?, fk_usuarios_eha = ? "
                    + "where id_venda_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(10, venda.getId_venda_eha());
            pst.setString(1, venda.getFormaPagamento_eha());
            pst.setDate(2, (Date) venda.getDataVenda_eha());
            pst.setInt(3, venda.getTaxaEntrega_eha());
            pst.setString(4, venda.getLocal_eha());
            pst.setString(5, venda.getStatusEntrega_ldm());
            pst.setInt(6, venda.getValorTotal_eha());
            pst.setInt(7, venda.getDesconto_eha());
            
            pst.setString(8, null); //fk
            pst.setString(9, null);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro sql:" + ex.getMessage());
            System.exit(0);
        }
        
    }

    @Override
    public void delete(Object object) {
        Venda venda = (Venda) object;

        try {
            String sql = "delete from venda_eha where id_venda_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, venda.getId_venda_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public Object list(int id) {
        Venda venda = new Venda();
        try {
            
            String sql = "select * from  venda_eha where id_venda_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                venda.setId_venda_eha(rs.getInt("id_venda_eha"));
                venda.setFormaPagamento_eha(rs.getString("formaPagamento_eha"));
                venda.setDataVenda_eha(rs.getDate("dataVenda_eha"));
                venda.setTaxaEntrega_eha(rs.getInt("taxaEntrega_eha"));
                venda.setLocal_eha(rs.getString("local_eha"));
                venda.setStatusEntrega_ldm(rs.getString("statusEntrega_ldm"));
                venda.setValorTotal_eha(rs.getInt("valorTotal_eha"));
                venda.setDesconto_eha(rs.getInt("desconto_eha"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        return venda;
    }

    @Override
    public ArrayList listAll() {
        return null;
    }
    
    public static void main(String[] args) {
        
    }
    
}
