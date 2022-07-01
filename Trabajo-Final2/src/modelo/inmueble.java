package modelo;

/**
 *
 * @author patob
 */
public class inmueble {
   private String direccion;
   private Double tamanio;
   private Integer habitaciones;
   private Integer banios;
   private Double precio;

    public inmueble() {
    }

    public inmueble(String direccion, Double tamanio, Integer habitaciones, Integer banios, Double precio) {
        this.direccion = direccion;
        this.tamanio = tamanio;
        this.habitaciones = habitaciones;
        this.banios = banios;
        this.precio = precio;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the tamanio
     */
    public Double getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * @return the habitaciones
     */
    public Integer getHabitaciones() {
        return habitaciones;
    }

    /**
     * @param habitaciones the habitaciones to set
     */
    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    /**
     * @return the banios
     */
    public Integer getBanios() {
        return banios;
    }

    /**
     * @param banios the banios to set
     */
    public void setBanios(Integer banios) {
        this.banios = banios;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
   
}
