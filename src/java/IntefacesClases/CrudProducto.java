/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntefacesClases;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.Recomendaciones;
import modelo.compra;
import modelo.ultimosDatos;

/**
 *
 * @author user
 */
public interface CrudProducto {
   public void agregarProd(Producto p);
  public List  listarProductos();
  public void listarIMG(int id ,HttpServletResponse response);
public Producto listarID(int id);
public int GenerarCompra(compra compras);
public List listarCategoria(String categoria);
public boolean dteFinal(ultimosDatos pz);
public boolean recomendaciones(Recomendaciones resc);
//public List listarDetalle();
public List listaSugerencias();

    
    
  
}
