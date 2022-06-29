/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.lista.ListaEnlazadaServices;

/**
 *
 * @author LENOVO LEGION 5
 */
public class HistorialCompras {
    ListaEnlazadaServices<String> historial = new ListaEnlazadaServices<>();

    public HistorialCompras(Autos auto) {
        historial.insertarAlInicio(auto.getModelo() + "--" + auto.getChasis()+ "--" + String.valueOf(auto.getPrecio()));
    }

    public ListaEnlazadaServices<String> getHistorial() {
        return historial;
    }

    public void setHistorial(ListaEnlazadaServices<String> historial) {
        this.historial = historial;
    }
    
    
}
