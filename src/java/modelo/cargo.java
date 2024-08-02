
package modelo;


public class cargo {
    private int codigo;
    private String NombreCargo;
    private boolean estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCargo() {
        return NombreCargo;
    }

    public void setNombreCargo(String NombreCargo) {
        this.NombreCargo = NombreCargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}

