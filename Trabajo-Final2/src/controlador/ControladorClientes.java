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
import modelo.Cliente;

/**
 *
 * @author LENOVO LEGION 5
 */
public class ControladorClientes {
    ListaEnlazadaServices<Cliente> listaCliente = new ListaEnlazadaServices<Cliente>();

    public ListaEnlazadaServices<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ListaEnlazadaServices<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getSize() {
        return listaCliente.getSize();
    }
    
    public int getClienteById(int id){
        int x = 0;
        for (int i = 0; i < getSize(); i++) {
            if(listaCliente.obtenerDato(i).getIdentificacion() == id){
                x = i;
                break;
            }
        }
        return x;
    }

    public void guardar() throws IOException {
        Gson json = new Gson();
        Cliente[] clientes = new Cliente[listaCliente.getSize()];
        for (int i = 0; i < listaCliente.getSize(); i++) {
            clientes[i] = listaCliente.obtenerDato(i);
        }
        String jsons = json.toJson(clientes);
        FileWriter fw = new FileWriter("Clientes" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar() throws FileNotFoundException, IOException {
        try {
            System.out.println("Cargando data");
            Gson json = new Gson();
            FileReader fr = new FileReader("Clientes" + ".json");
            StringBuilder jsons = new StringBuilder();
            boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Cliente[] aux = json.fromJson(jsons.toString(), Cliente[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                listaCliente.insertarAlInicio(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados");
        }

    }

}
