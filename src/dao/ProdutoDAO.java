/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;

/**
 *
 * @author rooki
 */
public class ProdutoDAO extends DAO_Abstract{
    
    private Connection cnt;
    
    public ProdutoDAO() {
    
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
        Produto produto = (Produto) object;
        
        try {
            String sql = "insert into produto_eha values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, produto.getId_produto_eha());
            pst.setString(2, produto.getNome_eha());
            pst.setString(3, produto.getDescricao_eha());
            pst.setInt(4, produto.getPreco_eha());
            pst.setInt(5, produto.getEstoque_eha());
            pst.setString(6, produto.getMarca_eha());
            pst.setString(7, produto.getCompatibilidade_eha());
            pst.setString(8, produto.getCategoria_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Object object) {
        Produto produto = (Produto) object;

        try {
            
            String sql = "update produto_eha set nome_eha = ?, descricao_eha = ?, preco_eha = ?, "
                    + "estoque_eha = ?, marca_eha = ?, compatibilidade_eha = ?, categoria_eha = ? "
                    + "where id_produto_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(8, produto.getId_produto_eha());
            pst.setString(1, produto.getNome_eha());
            pst.setString(2, produto.getDescricao_eha());
            pst.setInt(3, produto.getPreco_eha());
            pst.setInt(4, produto.getEstoque_eha());
            pst.setString(5, produto.getMarca_eha());
            pst.setString(6, produto.getCompatibilidade_eha());
            pst.setString(7, produto.getCategoria_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro sql:" + ex.getMessage());
            System.exit(0);
        }
        
    }

    @Override
    public void delete(Object object) {
        Produto produto = (Produto) object;

        try {
            String sql = "delete from produto_eha where id_produto_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, produto.getId_produto_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public Object list(int id) {
        Produto produto = new Produto();
        try {
            
            String sql = "select * from  produto_eha where id_produto_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                produto.setId_produto_eha(rs.getInt("id_produto_eha"));
                produto.setNome_eha(rs.getString("nome_eha"));
                produto.setDescricao_eha(rs.getString("descricao_eha"));
                produto.setPreco_eha(rs.getInt("preco_eha"));
                produto.setEstoque_eha(rs.getInt("estoque_eha"));
                produto.setMarca_eha(rs.getString("marca_eha"));
                produto.setCompatibilidade_eha(rs.getString("compatibilidade_eha"));
                produto.setCategoria_eha(rs.getString("categoria_eha"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        return produto;
    }

    @Override
    public ArrayList listAll() {
        return null;
    }
    
    
    
public static void main(String[] args) {
        Produto produto = new Produto();
        
        produto.setCategoria_eha("dsacdd");
        produto.setCompatibilidade_eha("dacnkdbkasj");
        produto.setDescricao_eha("dnjskvcnkjds");
        produto.setEstoque_eha(232112);
        produto.setId_produto_eha(1);
        produto.setMarca_eha("dsjkvnds");
        produto.setNome_eha("dnjksvnbksdj");
        produto.setPreco_eha(1213);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.insert(produto);
    }
}
