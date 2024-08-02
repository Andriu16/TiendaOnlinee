/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matodosDAO;

import ConexionBaseDtos.ConfigMySql;
import IntefacesClases.CrudCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.cargo;
//ultima modificacion fue cambiar el IDcliente "IDuser" de que estaba en String a int
public class ClienteDao implements CrudCliente {

    ConfigMySql cn = new ConfigMySql();

    @Override
    public List<Cliente> getPersonas() {
        List<Cliente> personas = new ArrayList<>();
        String sql = "SELECT U.IDuser,U.Nombre,U.Apellidos,U.Direccion,U.Correo,U.FechaNac,"
                + "U.Identificacion,U.Contrasena,C.IDCargo,C.Nombrecargo,"
                + "C.Estado FROM register U"
                + "  INNER JOIN cargo C ON U.IDCargo=C.IDCargo ";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setIDuser(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDireccion(rs.getString(4));
                p.setCorreo(rs.getString(5));
                p.setFechaNac(rs.getString(6));
                p.setIdentificacion(rs.getString(7));
                p.setContrasena(rs.getString(8));
                p.setCargo(new cargo());
                p.getCargo().setCodigo(rs.getInt("IDCargo"));
                p.getCargo().setNombreCargo(rs.getString("Nombrecargo"));

                p.getCargo().setEstado(true);
                personas.add(p);

            }

        } catch (Exception e) {
            System.out.println("ERR" + e);
        }
        return personas;
    }

    @Override
    public boolean add(Cliente clie) {

        String sql = "INSERT INTO register(Nombre,Apellidos,Direccion,Correo,FechaNac,Identificacion,Contrasena,IDCargo)values('" + clie.getNombre() + "','" + clie.getApellidos() + "','" + clie.getDireccion() + "','" + clie.getCorreo() + "','" + clie.getFechaNac() + "','" + clie.getIdentificacion() + "','" + clie.getContrasena() + "','" + clie.getCargo().getCodigo() + "')";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {

        }
        return false;

    }

    @Override
    public boolean buscarCorreoRepetido(String Correo) {
        boolean correoRepetido = false;
        String consulta = "SELECT Correo FROM register WHERE Correo=?";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(consulta);
            ps.setString(1, Correo);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                correoRepetido = true;
            } else {
                correoRepetido = false;
            }

        } catch (Exception e) {
            System.out.println("ERR" + e);

        }

        return correoRepetido;
    }

    @Override
    public Cliente identificar(Cliente Correo) {
        Cliente usu = null;
        Connection con = null;
        ResultSet resultado = null;
        Statement st = null;
        try {

            String consulta = "SELECT U.IDuser,C.Nombrecargo FROM register U"
                    + " INNER JOIN cargo C ON U.IDCargo=C.IDCargo "
                    + "WHERE C.Estado = 1 AND U.Correo='" + Correo.getCorreo() + "' "
                    + "AND U.Contrasena='" + Correo.getContrasena() + "'";
            con = cn.conectar();
            st = con.createStatement();
            resultado = st.executeQuery(consulta);

            if (resultado.next()) {
                usu = new Cliente();
                usu.setCorreo(resultado.getString("IDuser"));
                usu.setCorreo(Correo.getCorreo());
                usu.setCargo(new cargo());
                usu.getCargo().setNombreCargo(resultado.getString("Nombrecargo"));
                usu.setEstado(true);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
        } finally {
            try {
                if (resultado != null && resultado.isClosed() == false) {
                    resultado.close();
                }
                resultado = null;
                if (st != null && st.isClosed() == false) {
                    st.close();
                }
                st = null;
                if (con != null & con.isClosed() == false) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println("ERR" + ex);
            }

            return usu;
        }

    }
}
