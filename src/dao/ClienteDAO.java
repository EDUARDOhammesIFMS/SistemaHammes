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
import bean.Cliente;
import com.mysql.cj.protocol.Resultset;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author rooki
 */
public class ClienteDAO extends DAO_Abstract{
    
    private Connection cnt;
    
    public ClienteDAO(){
    
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
        Cliente cliente = (Cliente) object;
        
        try {
            String sql = "insert into cliente_eha values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, cliente.getId_cliente_eha());
            pst.setString(2, cliente.getNome_eha());
            pst.setString(3, cliente.getEmail_eha());
            pst.setString(4, cliente.getTelefone_eha());
            pst.setString(5, cliente.getEndereco_eha());//cliente.getData_nascimento_eha());
            pst.setString(6, cliente.getEstado_eha());
            pst.setString(7, cliente.getCep_eha());
            pst.setString(8, cliente.getEstado_civil_eha());
            pst.setString(9, cliente.getStatus_eha());
            pst.setString(10, cliente.getRg_eha());
            pst.setDate(11, (Date) cliente.getData_nascimento_eha());
            pst.setDate(12, (Date) cliente.getData_cadastro_eha());
            pst.setString(13, cliente.getCpf_eha());
            pst.setString(14, cliente.getNacionalidade_eha());
            pst.setString(15, cliente.getUf_eha());
            pst.setString(16, cliente.getComplemento_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Object object) {
        Cliente cliente = (Cliente) object;

        try {
            
            String sql = "update cliente_eha set nome_eha = ?, email_eha = ?, telefone_eha = ?, "
                    + "endereco_eha = ?, estado_eha = ?, cep_eha = ?, estado_civil_eha = ? "
                    + "status_eha = ?, rg_eha = ?, data_nascimento_eha = ?, data_cadastro_eha = ? "
                    + "cpf_eha = ?, nacionalidade_eha = ?, uf_eha = ?, complemento_eha = ? "
                    + "where id_cliente_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(16, cliente.getId_cliente_eha());
            pst.setString(1, cliente.getNome_eha());
            pst.setString(2, cliente.getEmail_eha());
            pst.setString(3, cliente.getTelefone_eha());
            pst.setString(4, cliente.getEndereco_eha());//cliente.getData_nascimento_eha());
            pst.setString(5, cliente.getEstado_eha());
            pst.setString(6, cliente.getCep_eha());
            pst.setString(7, cliente.getEstado_civil_eha());
            pst.setString(8, cliente.getStatus_eha());
            pst.setString(9, cliente.getRg_eha());
            pst.setDate(10, (Date) cliente.getData_nascimento_eha());
            pst.setDate(11, (Date) cliente.getData_cadastro_eha());
            pst.setString(12, cliente.getCpf_eha());
            pst.setString(13, cliente.getNacionalidade_eha());
            pst.setString(14, cliente.getUf_eha());
            pst.setString(15, cliente.getComplemento_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro sql:" + ex.getMessage());
            System.exit(0);
        }
        
    }

    @Override
    public void delete(Object object) {
        Cliente cliente = (Cliente) object;

        try {
            String sql = "delete from cliente_eha where id_cliente_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, cliente.getId_cliente_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public Object list(int id) {
        Cliente cliente = new Cliente();
        try {
            
            String sql = "select * from  cliente_eha where id_cliente_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                cliente.setId_cliente_eha(rs.getInt("id_cliente_eha"));
                cliente.setNome_eha(rs.getString("nome_eha"));
                cliente.setEmail_eha(rs.getString("email_eha"));
                cliente.setTelefone_eha(rs.getString("telefone_eha"));
                cliente.setEndereco_eha(rs.getString("endereco_eha"));
                cliente.setEstado_eha(rs.getString("estado_eha"));
                cliente.setCep_eha(rs.getString("cep_eha"));
                cliente.setEstado_civil_eha(rs.getString("estado_civil_eha"));
                cliente.setStatus_eha(rs.getString("status_eha"));
                cliente.setRg_eha(rs.getString("rg_eha"));
                cliente.setData_nascimento_eha(rs.getDate("data_nascimento_eha"));
                cliente.setData_cadastro_eha(rs.getDate("data_cadastro_eha"));
                cliente.setCpf_eha(rs.getString("cpf_eha"));
                cliente.setNacionalidade_eha(rs.getString("nacionalidade_eha"));
                cliente.setUf_eha(rs.getString("uf_eha"));
                cliente.setComplemento_eha(rs.getString("complemento_eha"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        return cliente;
    }

    @Override
    public ArrayList listAll() {
        return null;
    }
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insert(cliente);
    }
}
