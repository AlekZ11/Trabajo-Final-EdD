package modelo;

/**
 *
 * @author LENOVO LEGION 5
 */
public class Cliente {
   private String nombres;
   private Integer identificacion;
   private String telefono;

    public Cliente(String nombres, Integer identificacion, String telefono) {
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
