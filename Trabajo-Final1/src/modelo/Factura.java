/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Usuario iTC
 */
public class Factura {
    private final LocalDate fechaVenta;
    private String vendedor;
    private Cliente cliente;
    private Autos auto;
    private Double Matricula;
    private Double venta;

    public Factura() {
        this.fechaVenta = LocalDate.now();
    }

    /**
     * @return the fechaVenta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the auto
     */
    public Autos getAuto() {
        return auto;
    }

    /**
     * @param auto the auto to set
     */
    public void setAuto(Autos auto) {
        this.auto = auto;
    }

    public Double getMatricula() {
        return Matricula;
    }

    public void setMatricula(Double Matricula) {
        this.Matricula = Matricula;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }
    
    
}
