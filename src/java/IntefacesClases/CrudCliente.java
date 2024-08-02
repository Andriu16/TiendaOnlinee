/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntefacesClases;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author user
 */
public interface CrudCliente {
     public List<Cliente> getPersonas();

    public boolean add(Cliente clie);

    public boolean buscarCorreoRepetido(String Correo);

    public Cliente identificar(Cliente Correo);
}
