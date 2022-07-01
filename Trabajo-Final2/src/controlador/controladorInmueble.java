package controlador;

import com.google.gson.Gson;
import controlador.lista.ListaEnlazadaServices;
import java.io.FileReader;
import java.io.FileWriter;
import modelo.Cliente;
import modelo.inmueble;

/**
 *
 * @author patob
 */
public class controladorInmueble {
    private ListaEnlazadaServices<inmueble> inmuebles = new ListaEnlazadaServices<>();
    
    public inmueble[] toArray(){
        inmueble[] in = new inmueble[getInmuebles().getSize()];
        for (int j = 0; j < in.length; j++) {
            in[j] = getInmuebles().obtenerDato(j);
        }
        return in;
    }
    public void guardar(){
        try {
            inmueble[] guarda = toArray();
            Gson json = new Gson();
            String jsons = json.toJson(guarda);
            FileWriter fw = new FileWriter("Inmueble" + ".json");
            fw.write(jsons);
            fw.flush();
        } catch (Exception e) {
        }
    }
    public void cargar(){
        try {
            System.out.println("Cargando data");
            Gson json = new Gson();
            FileReader fr = new FileReader("Inmueble" + ".json");
            StringBuilder jsons = new StringBuilder();
            boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            inmueble[] aux = json.fromJson(jsons.toString(), inmueble[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                getInmuebles().insertarAlInicio(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados");
        }
    }

    /**
     * @return the inmuebles
     */
    public ListaEnlazadaServices<inmueble> getInmuebles() {
        return inmuebles;
    }

    /**
     * @param inmuebles the inmuebles to set
     */
    public void setInmuebles(ListaEnlazadaServices<inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
}
