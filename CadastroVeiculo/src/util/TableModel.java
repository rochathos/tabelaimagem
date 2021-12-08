/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.util.List;

import entidade.Veiculo;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Atila
 */
public class TableModel  extends AbstractTableModel{
    private List<Veiculo> lista;
    
    private String[] colunas = {"codigo", "modelo","marca","ano","placa"};
    
    public TableModel(List<Veiculo> lista){
        this.lista = lista;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    public String getColumnName(int  columnIndex){
        return colunas[columnIndex];
    }
    
    public Class<?> getColumnClass(int columnIndex){
        return String.class;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Veiculo veiculo = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                veiculo.setIdveiculo(Long.parseLong(aValue.toString()));
              
            case 1:
                veiculo.setModelo(aValue.toString());
                
            case 2:
                veiculo.setMarca(aValue.toString());
                
            case 3:
                veiculo.setAno(Integer.parseInt(aValue.toString()));
                
            case 4:
                veiculo.setPlaca(aValue.toString());
                
                default:
                    System.err.println("Indice da coluna é Invalido");
                
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Veiculo veiculoSelecionado = lista.get(rowIndex);
        Object valueObject = null;
        
        switch(columnIndex){
            case 0:
                valueObject = veiculoSelecionado.getIdveiculo();
                break;
            case 1 :
                valueObject = veiculoSelecionado.getModelo();
                break;
            case 2 :
                valueObject = veiculoSelecionado.getMarca();
                break;
            case 3:
                valueObject = veiculoSelecionado.getAno();
                break;
            case 4:
                valueObject = veiculoSelecionado.getPlaca();
                break;
                default:
                
        }
        
        return valueObject;
        
        
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
     return false;
    }
    
    public Object getSelecionado(int rowIndex){
        return lista.get(rowIndex);    
    
   
    }
    
    public void refreshData(List<Veiculo> novosveiculos){
        this.lista = novosveiculos;
        fireTableDataChanged();
    }
    
    public void limpar(){
        lista.clear();
        fireTableDataChanged();
    }
    public boolean isEmpity(){
        return lista.isEmpty();
    }
}
