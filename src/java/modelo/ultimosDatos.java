/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author user
 */
public class ultimosDatos {
  compra compra;

  String Departamento,Distrito,Avenida,Referencia,DireccExac,FechDes,TipoEntrega;

    public ultimosDatos() {
    }

    public ultimosDatos(String Departamento, String Distrito, String Avenida, String Referencia, String DireccExac, String FechDes, String TipoEntrega) {
        this.Departamento = Departamento;
        this.Distrito = Distrito;
        this.Avenida = Avenida;
        this.Referencia = Referencia;
        this.DireccExac = DireccExac;
        this.FechDes = FechDes;
        this.TipoEntrega = TipoEntrega;
    }

    public compra getCompra() {
        return compra;
    }

    public void setCompra(compra compra) {
        this.compra = compra;
    }

   

   

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public String getAvenida() {
        return Avenida;
    }

    public void setAvenida(String Avenida) {
        this.Avenida = Avenida;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getDireccExac() {
        return DireccExac;
    }

    public void setDireccExac(String DireccExac) {
        this.DireccExac = DireccExac;
    }

    public String getFechDes() {
        return FechDes;
    }

    public void setFechDes(String FechDes) {
        this.FechDes = FechDes;
    }

    public String getTipoEntrega() {
        return TipoEntrega;
    }

    public void setTipoEntrega(String TipoEntrega) {
        this.TipoEntrega = TipoEntrega;
    }
  
  
 
 
}
