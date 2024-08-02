/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Recomendaciones {
    int IDrecomendacion;
    Cliente cliente;
    String NombreProduc;
    String MarcaProduc;
    String DescripProduc;

    public Recomendaciones() {
    }

    public Recomendaciones( Cliente cliente, String NombreProduc, String MarcaProduc, String DescripProduc) {
        
        this.cliente = cliente;
        this.NombreProduc = NombreProduc;
        this.MarcaProduc = MarcaProduc;
        this.DescripProduc = DescripProduc;
    }

    public int getIDrecomendacion() {
        return IDrecomendacion;
    }

    public void setIDrecomendacion(int IDrecomendacion) {
        this.IDrecomendacion = IDrecomendacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreProduc() {
        return NombreProduc;
    }

    public void setNombreProduc(String NombreProduc) {
        this.NombreProduc = NombreProduc;
    }

    public String getMarcaProduc() {
        return MarcaProduc;
    }

    public void setMarcaProduc(String MarcaProduc) {
        this.MarcaProduc = MarcaProduc;
    }

    public String getDescripProduc() {
        return DescripProduc;
    }

    public void setDescripProduc(String DescripProduc) {
        this.DescripProduc = DescripProduc;
    }
    
    
    
    
}
