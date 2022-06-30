/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import controlador.lista.ListaEnlazadaServices;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Marcas;

/**
 *
 * @author LENOVO LEGION 5
 */
public class ControladorMarcas {
    ListaEnlazadaServices<Marcas> listaMarcas = new ListaEnlazadaServices<>();

    public ListaEnlazadaServices<Marcas> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(ListaEnlazadaServices<Marcas> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public int getSize() {
        return listaMarcas.getSize();
    }

    public void guardar() throws IOException {
        Gson json = new Gson();
        Marcas[] clientes = new Marcas[listaMarcas.getSize()];
        for (int i = 0; i < listaMarcas.getSize(); i++) {
            clientes[i] = listaMarcas.obtenerDato(i);
        }
        String jsons = json.toJson(clientes);
        FileWriter fw = new FileWriter("Marcas" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar(){
        try {
            System.out.println("Cargando data");
            Gson json = new Gson();
            FileReader fr = new FileReader("Marcas" + ".json");
            StringBuilder jsons = new StringBuilder();
            boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Marcas[] aux = json.fromJson(jsons.toString(), Marcas[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                listaMarcas.insertarAlInicio(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados");
        }

    }
    
    public String[] toArray(){
        String[] x = new String[getSize()];
        for (int i = 0; i < x.length; i++) {
            x[i] = listaMarcas.obtenerDato(i).getNombres();
        }
        return x;
    }

}
