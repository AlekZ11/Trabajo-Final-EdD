/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import controlador.lista.ListaEnlazadaServices;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Factura;

/**
 *
 * @author Usuario iTC
 */
public class ControladorFacturas {
    ListaEnlazadaServices<Factura> listaFactura = new ListaEnlazadaServices<>();

    /**
     * @return the listaFactura
     */
    public ListaEnlazadaServices<Factura> getListaFactura() {
        return listaFactura;
    }

    /**
     * @param listaFactura the listaFactura to set
     */
    public void setListaFactura(ListaEnlazadaServices<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }
    
    public void guardar() throws IOException {
        Gson json = new Gson();
        Factura[] factura = new Factura[listaFactura.getSize()];
        for (int i = 0; i < listaFactura.getSize(); i++) {
            factura[i] = listaFactura.obtenerDato(i);
        }
        String jsons = json.toJson(factura);
        FileWriter fw = new FileWriter("Facturas" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar() throws FileNotFoundException, IOException {
        try {
            System.out.println("Cargando data");
            Gson json = new Gson();
            FileReader fr = new FileReader("Facturas" + ".json");
            StringBuilder jsons = new StringBuilder();
            boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Factura[] aux = json.fromJson(jsons.toString(), Factura[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                listaFactura.insertarAlInicio(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados");
        }

    }
}
