
package controlador;

import com.google.gson.Gson;
import controlador.lista.ListaEnlazadaServices;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Autos;

/**
 *
 * @author LENOVO LEGION 5
 */
public class ControladorAutos {
    ListaEnlazadaServices<Autos> listaAutos = new ListaEnlazadaServices<Autos>();

    public ListaEnlazadaServices<Autos> getListaCliente() {
        return listaAutos;
    }

    public void setListaCliente(ListaEnlazadaServices<Autos> listaCliente) {
        this.listaAutos = listaCliente;
    }

    public int getSize() {
        return listaAutos.getSize();
    }

    public void guardar() throws IOException {
        Gson json = new Gson();
        Autos[] clientes = new Autos[listaAutos.getSize()];
        for (int i = 0; i < listaAutos.getSize(); i++) {
            clientes[i] = listaAutos.obtenerDato(i);
        }
        String jsons = json.toJson(clientes);
        FileWriter fw = new FileWriter("Autos" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar() {
        try {
            System.out.println("Cargando data");
            Gson json = new Gson();
            FileReader fr = new FileReader("Autos" + ".json");
            StringBuilder jsons = new StringBuilder();
            boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Autos[] aux = json.fromJson(jsons.toString(), Autos[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                listaAutos.insertarAlInicio(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados");
        }

    }
    public String[][] toArray(){
        String[][] carro = new String[getSize()][4];
        for (int i = 0; i < carro.length; i++) {
            carro[i][0] = listaAutos.obtenerDato(i).getChasis();
            carro[i][1] = listaAutos.obtenerDato(i).getMarca().toString();
            carro[i][2] = listaAutos.obtenerDato(i).getModelo();
            carro[i][3] = listaAutos.obtenerDato(i).getColor();
            carro[i][4] = listaAutos.obtenerDato(i).getPrecio().toString();
            carro[i][5] = listaAutos.obtenerDato(i).getAnio()+"";
        }
        return carro;
    }
}
