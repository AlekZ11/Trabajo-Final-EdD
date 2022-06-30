/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tablas;

import controlador.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Marcas;

/**
 *
 * @author LENOVO LEGION 5
 */
public class TablaMarcas extends AbstractTableModel{
    ListaEnlazadaServices<Marcas> lm = new ListaEnlazadaServices<>();

    public TablaMarcas(ListaEnlazadaServices<Marcas> lc) {
        this.lm = lc;
    }
    
    @Override
    public int getRowCount() {
        return lm.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombres";
            default:
                return null;
        }            
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marcas m = lm.obtenerDato(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getNombres();
            default:
                return null;
        }
    }
    
}
