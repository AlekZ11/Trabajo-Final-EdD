/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

/**
 *
 * @author LENOVO LEGION 5
 */
public class TablaClientes extends AbstractTableModel{
    ListaEnlazadaServices<Cliente> lc = new ListaEnlazadaServices<>();

    public TablaClientes(ListaEnlazadaServices<Cliente> lc) {
        this.lc = lc;
    }
    
    @Override
    public int getRowCount() {
        return lc.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombres";
            case 1:
                return "Identificacion";
            case 2:
                return "Telefono";
            case 3:
                return "Direccion";
            /*case 4:
                return "Pago";*/
            default:
                return null;
        }            
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente p = lc.obtenerDato(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNombres();
            case 1:
                return p.getIdentificacion();
            case 2:
                return p.getTelefono();
            case 3:
                return p.getDireccion();
            /*case 4:
                return p.getPago();*/
            default:
                return null;
        }
    }
    
}
