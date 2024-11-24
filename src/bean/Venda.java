/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author rooki
 */
public class Venda {
    
    private int id_venda_eha;
    private String formaPagamento_eha;
    private Date dataVenda_eha;
    private int taxaEntrega_eha;
    private String local_eha;
    private String statusEntrega_ldm;
    private int valorTotal_eha;
    private int desconto_eha;

    public int getId_venda_eha() {
        return id_venda_eha;
    }

    public void setId_venda_eha(int id_venda_eha) {
        this.id_venda_eha = id_venda_eha;
    }

    public String getFormaPagamento_eha() {
        return formaPagamento_eha;
    }

    public void setFormaPagamento_eha(String formaPagamento_eha) {
        this.formaPagamento_eha = formaPagamento_eha;
    }

    public Date getDataVenda_eha() {
        return dataVenda_eha;
    }

    public void setDataVenda_eha(Date dataVenda_eha) {
        this.dataVenda_eha = dataVenda_eha;
    }

    public int getTaxaEntrega_eha() {
        return taxaEntrega_eha;
    }

    public void setTaxaEntrega_eha(int quantidadeVendida_eha) {
        this.taxaEntrega_eha = quantidadeVendida_eha;
    }

    public String getLocal_eha() {
        return local_eha;
    }

    public void setLocal_eha(String local_eha) {
        this.local_eha = local_eha;
    }

    public String getStatusEntrega_ldm() {
        return statusEntrega_ldm;
    }

    public void setStatusEntrega_ldm(String statusEntrega_ldm) {
        this.statusEntrega_ldm = statusEntrega_ldm;
    }

    public int getValorTotal_eha() {
        return valorTotal_eha;
    }

    public void setValorTotal_eha(int valorTotal_eha) {
        this.valorTotal_eha = valorTotal_eha;
    }

    public int getDesconto_eha() {
        return desconto_eha;
    }

    public void setDesconto_eha(int desconto_eha) {
        this.desconto_eha = desconto_eha;
    }
    
    
}
