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
import bean.Usuarios;
import com.mysql.cj.protocol.Resultset;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author u06614150154
 */
public class UsuariosDAO extends DAO_Abstract{
    
    private Connection cnt;
    
    public UsuariosDAO(){
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
        Usuarios usuarios = (Usuarios) object;
        
        try {
            String sql = "insert into usuarios_eha values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, usuarios.getIdCodigo_eha());
            pst.setString(2, usuarios.getNome_eha());
            pst.setString(3, usuarios.getApelido_eha());
            pst.setString(4, usuarios.getCpf_eha());
            pst.setDate(5, (Date) usuarios.getDataNascimento_eha());
            pst.setString(6, usuarios.getSenha_eha());
            pst.setInt(7, usuarios.getNivel_eha());
            pst.setString(8, usuarios.getAtivo_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;

        try {
            
            String sql = "update usuarios_eha set nome_eha = ?, apelido_eha = ?, cpf_eha = ?, "
                    + "dataNascimento_eha = ?, senha_eha = ?, nivel_eha = ?, ativo_eha = ? "
                    + "where idCodigo_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(8, usuarios.getIdCodigo_eha());
            pst.setString(1, usuarios.getNome_eha());
            pst.setString(2, usuarios.getApelido_eha());
            pst.setString(3, usuarios.getCpf_eha());
            pst.setDate(4, (Date) usuarios.getDataNascimento_eha());
            pst.setString(5, usuarios.getSenha_eha());
            pst.setInt(6, usuarios.getNivel_eha());
            pst.setString(7, usuarios.getAtivo_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro sql:" + ex.getMessage());
            System.exit(0);
        }
        
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;

        try {
            String sql = "delete from usuarios_eha where idCodigo_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, usuarios.getIdCodigo_eha());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();
        try {
            
            String sql = "select * from  usuarios_eha where idCodigo_eha = ? ";
            PreparedStatement pst = cnt.prepareStatement(sql);            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                usuarios.setIdCodigo_eha(rs.getInt("idCodigo_eha"));
                usuarios.setNome_eha(rs.getString("nome_eha"));
                usuarios.setApelido_eha(rs.getString("apelido_eha"));
                usuarios.setCpf_eha(rs.getString("cpf_eha"));
                usuarios.setDataNascimento_eha(rs.getDate("dataNascimento_eha"));
                usuarios.setSenha_eha(rs.getString("senha_eha"));
                usuarios.setNivel_eha(rs.getInt("nivel_eha"));
                usuarios.setAtivo_eha(rs.getString("ativo_eha"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        return usuarios;
    }

    @Override
    public ArrayList listAll() {
        ArrayList lista = new ArrayList();
        
        try {
            
            
            PreparedStatement pst = cnt.prepareStatement("select * from usuarios_eha");   
            ResultSet rs;
            rs = pst.executeQuery();
            
            while(rs.next()){
                Usuarios usuarios = new Usuarios();
                
                usuarios.setIdCodigo_eha(rs.getInt("idCodigo_eha"));
                usuarios.setNome_eha(rs.getString("nome_eha"));
                usuarios.setApelido_eha(rs.getString("apelido_eha"));
                usuarios.setCpf_eha(rs.getString("cpf_eha"));
                usuarios.setDataNascimento_eha(rs.getDate("dataNascimento_eha"));
                usuarios.setSenha_eha(rs.getString("senha_eha"));
                usuarios.setNivel_eha(rs.getInt("nivel_eha"));
                usuarios.setAtivo_eha(rs.getString("ativo_eha"));
                
                lista.add(usuarios);
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro Class:" + ex.getMessage());
            System.exit(0);
        }
        
        return (ArrayList) lista;
    }
    
    public static void main(String[] args) {
        
    }
    
}
