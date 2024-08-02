/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matodosDAO;

import ConexionBaseDtos.ConfigMySql;
import IntefacesClases.CrudProducto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Producto;
import modelo.Recomendaciones;
import modelo.carrito;
import modelo.categoria;
import modelo.compra;
import modelo.ultimosDatos;

/**
 *
 * @author user
 */
public class ProductoDAO implements CrudProducto {

    Connection con;
    ConfigMySql cn = new ConfigMySql();
    PreparedStatement ps;
    Producto pr = new Producto();
    ResultSet rs;
    int r = 0;

    @Override
    public void agregarProd(Producto p) {
        String sql = "INSERT INTO producto (Nombres,Descripcion,Precio,Stock,Categoria,Marca,img)VALUES(?,?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombres());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setString(5, p.getCategoria());
            ps.setString(6, p.getMarca());
            ps.setBlob(7, p.getImagen());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public List listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setPrecio(rs.getDouble(4));
                pr.setStock(rs.getInt(5));
                pr.setCategoria(rs.getString(6));
                pr.setMarca(rs.getString(7));
                pr.setImagen(rs.getBinaryStream(8));
                lista.add(pr);

            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public void listarIMG(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM producto WHERE IDproducto=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();

            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("img");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {
        }
    }

    @Override
    public Producto listarID(int id) {
        String sql = "SELECT * FROM producto WHERE IDproducto=" + id;
        Producto p = new Producto();

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));

                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setMarca(rs.getString(7));
                p.setImagen(rs.getBinaryStream(8));

            }

        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public int GenerarCompra(compra compras) {
        int idcompras;
        String sql = "INSERT INTO compras(IDuser,IDpago,FechaCompra,Monto,Estado) VALUES(?,?,?,?,?)";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, compras.getCliente().getIDuser());
            ps.setInt(2, compras.getIdpago());
            ps.setString(3, compras.getFecha());
            ps.setDouble(4, compras.getMonto());
            ps.setString(5, compras.getEstado());
            r = ps.executeUpdate();
            sql = "Select @@IDENTITY AS IDcompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idcompras = rs.getInt("IDcompras");
            rs.close();

            for (carrito detalle : compras.getDetallecompras()) {
                int IDdetalle;
                sql = "INSERT INTO detallecompra(IDproducto,IDcompras,Cantidad,PrecioCompra)VALUES(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idcompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r = ps.executeUpdate();

                
                
            }

        } catch (Exception e) {
        }

        return r;

    }

    @Override
    public List listarCategoria(String categoria) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE Categoria=" + categoria;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setDescripcion(rs.getString(3));
                pr.setPrecio(rs.getDouble(4));
                pr.setStock(rs.getInt(5));
                pr.setCategoria(rs.getString(6));
                pr.setMarca(rs.getString(7));
                pr.setImagen(rs.getBinaryStream(8));
                lista.add(pr);

            }
        } catch (Exception e) {
        }
        return lista;

    }

    @Override
    public boolean dteFinal(ultimosDatos pz) {

        String sql = "INSERT INTO ultimosdatos(IDdetalle,Departamento,Distrito,Avenida,Referencia,DireccionExacta,FechaDeseada,TipoEntrega) VALUES(?,?,?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = cn.conectar().prepareStatement(sql);
            ps.setInt(1, pz.getCompra().getId());
            ps.setString(2, pz.getDepartamento());
            ps.setString(3, pz.getDistrito());
            ps.setString(4, pz.getAvenida());
            ps.setString(5, pz.getReferencia());
            ps.setString(6, pz.getDireccExac());
            ps.setString(7, pz.getFechDes());
            ps.setString(8, pz.getTipoEntrega());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERR" + e);
        }

        return false;
    }

//    @Override
//    public List listarDetalle() {
//        List<compra> lista = new ArrayList<>();
//        String sql = "SELECT * FROM detallecompra";
//        try {
//            con = cn.conectar();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                compra prz = new compra();
//                prz.setCompra(new compra());
//                pr.getCompra().setId(rs.getInt(1));
//                pr.setDepartamento(rs.getString(2));
//                pr.setDistrito(rs.getString(3));
//                pr.setAvenida(rs.getString(4));
//                pr.setReferencia(rs.getString(5));
//                pr.setDireccExac(rs.getString(6));
//                pr.setFechDes(rs.getString(7));
//                pr.setTipoEntrega(rs.getString(8));
//
//            }
//        } catch (Exception e) {
//        }
//        return lista;
//
//    }

    @Override
    public boolean recomendaciones(Recomendaciones resc) {
        String sql = "INSERT INTO recomendacion(IDuser,NombreProducRecomenado,marcaProducRecomend,descProducrecomend) VALUES(?,?,?,?)";
        try {
            con = cn.conectar();
            ps = cn.conectar().prepareStatement(sql);
            
            ps.setInt(1, resc.getCliente().getIDuser());
            ps.setString(2, resc.getNombreProduc());
            ps.setString(3, resc.getMarcaProduc());
            ps.setString(4, resc.getDescripProduc());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERR" + e);
        }

        return false;

    }

    @Override
    public List listaSugerencias() {
        List<Recomendaciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM recomendacion";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Recomendaciones recomen = new Recomendaciones();
                recomen.setIDrecomendacion(rs.getInt(1));
               recomen.setCliente(new Cliente());
               recomen.getCliente().setIDuser(rs.getInt(2));
               recomen.setNombreProduc(rs.getString(3));
               recomen.setMarcaProduc(rs.getString(4));
               recomen.setDescripProduc(rs.getString(5));
                lista.add(recomen);

            }
        } catch (Exception e) {
            System.out.println("ERR");
        }
        return lista;
    }

   
   
    
   

}
