
package modelo;

import java.util.List;


public class compra {
    int id;
    Cliente cliente;
    int idpago;
    String fecha;
    Double monto;
    String estado;
    
    private List<carrito>detallecompras;

    public compra() {
    }

    public compra(Cliente cliente, int idpago, String fecha, Double monto, String estado, List<carrito> detallecompras) {
       
        this.cliente = cliente;
        this.idpago = idpago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.detallecompras = detallecompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<carrito> getDetallecompras() {
        return detallecompras;
    }

    public void setDetallecompras(List<carrito> detallecompras) {
        this.detallecompras = detallecompras;
    }
    
}
