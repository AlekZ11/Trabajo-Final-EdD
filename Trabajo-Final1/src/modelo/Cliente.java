/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO LEGION 5
 */
public class Cliente {
   private String nombres;
   private Integer identificacion;
   private HistorialCompras historial;

    public Cliente(String name, Integer identificacion) {
        this.nombres = name;
        this.identificacion = identificacion;
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

    public HistorialCompras getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialCompras historial) {
        this.historial = historial;
    }
}
