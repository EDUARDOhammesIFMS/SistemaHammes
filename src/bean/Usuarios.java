/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author u06614150154
 */

//sistema
public class Usuarios {
    
    private int idCodigo_eha;
    private String nome_eha;
    private String apelido_eha;
    private String cpf_eha;
    private Date dataNascimento_eha;
    private String senha_eha;
    private int nivel_eha;
    private String ativo_eha;

    public Usuarios() {
        this.idCodigo_eha = idCodigo_eha;
        this.nome_eha = nome_eha;
        this.apelido_eha = apelido_eha;
        this.cpf_eha = cpf_eha;
        this.dataNascimento_eha = dataNascimento_eha;
        this.senha_eha = senha_eha;
        this.nivel_eha = nivel_eha;
        this.ativo_eha = ativo_eha;
        
    }

    public int getIdCodigo_eha() {
        return idCodigo_eha;
    }

    public void setIdCodigo_eha(int idCodigo_eha) {
        this.idCodigo_eha = idCodigo_eha;
    }

    public String getNome_eha() {
        return nome_eha;
    }

    public void setNome_eha(String nome_eha) {
        this.nome_eha = nome_eha;
    }

    public String getApelido_eha() {
        return apelido_eha;
    }

    public void setApelido_eha(String apelido_eha) {
        this.apelido_eha = apelido_eha;
    }

    public String getCpf_eha() {
        return cpf_eha;
    }

    public void setCpf_eha(String cpf_eha) {
        this.cpf_eha = cpf_eha;
    }

    public Date getDataNascimento_eha() {
        return dataNascimento_eha;
    }

    public void setDataNascimento_eha(Date dataNascimento_eha) {
        this.dataNascimento_eha = dataNascimento_eha;
    }

    public String getSenha_eha() {
        return senha_eha;
    }

    public void setSenha_eha(String senha_eha) {
        this.senha_eha = senha_eha;
    }

    public int getNivel_eha() {
        return nivel_eha;
    }

    public void setNivel_eha(int nivel_eha) {
        this.nivel_eha = nivel_eha;
    }

    public String getAtivo_eha() {
        return ativo_eha;
    }

    public void setAtivo_eha(String ativo_eha) {
        this.ativo_eha = ativo_eha;
    }

    public java.sql.Date getDataNascimento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    


    
}



