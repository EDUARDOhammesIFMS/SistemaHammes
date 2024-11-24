/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u06614150154
 */
public class ControllerUsuarios extends AbstractTableModel {
    
    private List lista;
    
    public void setLista (List lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista != null ? lista.size() : 0;
    };

    @Override
    public int getColumnCount() {
        return 4;
    };

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Usuarios usuarios  = (Usuarios) lista.get(rowIndex);
        
        if(columnIndex == 0) {
            return usuarios.getIdCodigo_eha();
        }
        if (columnIndex == 1){
            return usuarios.getNome_eha();
        }
        if (columnIndex == 2){
            return usuarios.getCpf_eha();
        }
        if (columnIndex == 3){
            return usuarios.getNivel_eha();
        }
    return "";
    }
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "CPF";
        }
        if (columnIndex == 3) {
            return "Nível";
        }
        return "";
    }
}
