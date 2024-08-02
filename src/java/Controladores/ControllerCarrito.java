/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ConexionBaseDtos.Fecha;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import matodosDAO.ClienteDao;
import matodosDAO.ProductoDAO;
import modelo.Cliente;
import modelo.Producto;
import modelo.Recomendaciones;
import modelo.carrito;
import modelo.compra;
import modelo.pago;
import modelo.ultimosDatos;

@WebServlet(name = "ControllerCarrito", urlPatterns = {"/ControllerCarrito"})
@MultipartConfig
public class ControllerCarrito extends HttpServlet {

    ultimosDatos ultimodate = new ultimosDatos();
    Producto prodc = new Producto();
    ProductoDAO metodProd = new ProductoDAO();
    List<Producto> productos = new ArrayList<>();
    List<carrito> listaCarrito = new ArrayList<>();
    double totalPagar = 0.0;
    int cantidad = 1;
    int item;
    Fecha fecha = new Fecha();
    Recomendaciones recomen = new Recomendaciones();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {

            case "Confirmar":
                String acceso = "";

                String Nombre = request.getParameter("txtNombre");
                double Precio = Double.parseDouble(request.getParameter("txtPrecio"));
                String txtDescripcion = request.getParameter("txtDescripcion");
                int txtStock = Integer.parseInt(request.getParameter("txtStock"));
                String Categoria = request.getParameter("txtCodCategoria");
                String Marca = request.getParameter("txtCodMarca");
                Part part = request.getPart("fileFoto");
                InputStream inputStream = part.getInputStream();

                prodc.setNombres(Nombre);
                prodc.setDescripcion(txtDescripcion);
                prodc.setPrecio(Precio);
                prodc.setStock(txtStock);
//                        prodc.setCodSCategoria(new categoria());

                prodc.setCategoria(Categoria);

                //probarlo sin conectar las bases de datos ,que sea solo en una
//                        prodc.setCodSMarca(new marca());
                prodc.setMarca(Marca);
                prodc.setImagen(inputStream);
                metodProd.agregarProd(prodc);

                response.sendRedirect("javasp/agregarProducto.jsp");

                break;

            case "Inic":
                List<Producto> lista = metodProd.listarProductos();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("javasp/home1.jsp").forward(request, response);

                break;

            case "Categoriaz":
                String tecno = request.getParameter("categori");
                List<Producto> listapr = metodProd.listarCategoria(tecno);
                request.setAttribute("listapr", listapr);
                request.getRequestDispatcher("javasp/Tecnologia.jsp").forward(request, response);
                //  request.getRequestDispatcher("javasp/"+tecno+".jsp").forward(request, response);
                break;
            case "CategoriaA":
                String tecnoA = request.getParameter("categori");
                List<Producto> listaprA = metodProd.listarCategoria(tecnoA);
                request.setAttribute("listaprA", listaprA);
                request.getRequestDispatcher("javasp/Artesanias.jsp").forward(request, response);

                break;
            case "CategoriaB":
                String tecnoB = request.getParameter("categori");
                List<Producto> listaprB = metodProd.listarCategoria(tecnoB);
                request.setAttribute("listaprB", listaprB);
                request.getRequestDispatcher("javasp/Cocina.jsp").forward(request, response);

                break;
            case "CategoriaC":
                String tecnoC = request.getParameter("categori");
                List<Producto> listaprC = metodProd.listarCategoria(tecnoC);
                request.setAttribute("listaprC", listaprC);
                request.getRequestDispatcher("javasp/Deportes.jsp").forward(request, response);

                break;
            case "CategoriaD":
                String tecnoD = request.getParameter("categori");
                List<Producto> listaprD = metodProd.listarCategoria(tecnoD);
                request.setAttribute("listaprD", listaprD);
                request.getRequestDispatcher("javasp/Limpieza.jsp").forward(request, response);

                break;
            case "CategoriaE":
                String tecnoE = request.getParameter("categori");
                List<Producto> listaprE = metodProd.listarCategoria(tecnoE);
                request.setAttribute("listaprE", listaprE);
                request.getRequestDispatcher("javasp/Muebles.jsp").forward(request, response);

                break;
            case "CategoriaF":
                String tecnoF = request.getParameter("categori");
                List<Producto> listaprF = metodProd.listarCategoria(tecnoF);
                request.setAttribute("listaprF", listaprF);
                request.getRequestDispatcher("javasp/ropa.jsp").forward(request, response);

                break;

            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                int idtxt = Integer.parseInt(request.getParameter("id"));
                prodc = metodProd.listarID(idtxt);
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idtxt == listaCarrito.get(i).getIdProducto()) {
                            pos = i;
                        }
                    }
                    if (idtxt == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    } else {
                        item = item + 1;
                        carrito car = new carrito();
                        car.setItem(item);
                        car.setIdProducto(prodc.getId());
                        car.setNombres(prodc.getNombres());
                        car.setDescripcion(prodc.getDescripcion());
                        car.setPrecioCompra(prodc.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * prodc.getPrecio());
                        listaCarrito.add(car);
                    }

                } else {
                    item = item + 1;
                    carrito car = new carrito();
                    car.setItem(item);
                    car.setIdProducto(prodc.getId());
                    car.setNombres(prodc.getNombres());
                    car.setDescripcion(prodc.getDescripcion());
                    car.setPrecioCompra(prodc.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * prodc.getPrecio());
                    listaCarrito.add(car);
                }

                request.setAttribute("contador", listaCarrito.size());
                //no
                request.getRequestDispatcher("ControllerCarrito?accion=Inic").forward(request, response);

                break;

            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getItem() == idproducto) {
                        listaCarrito.remove(i);
                    }
                }

                request.getRequestDispatcher("ControllerCarrito?accion=Carrito").forward(request, response);

                break;

            case "Eliminar":
               

                request.getRequestDispatcher("javasp/ListaProductos.jsp").forward(request, response);
                break;
            case "Carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();

                }
                request.setAttribute("totalPagar", totalPagar);

                request.getRequestDispatcher("javasp/carrito.jsp").forward(request, response);
                break;

            case "GenerarCompra":

                Cliente cli = new Cliente();
                cli.setIDuser(7);

                ProductoDAO dao = new ProductoDAO();
                compra comp = new compra(cli, 1, fecha.FechaBD(), totalPagar, "Cancelado", listaCarrito);
                int res = dao.GenerarCompra(comp);
                if (res != 0 && totalPagar > 0) {

                    //cambiar
//                    List<ultimosDatos> listaulty = metodProd.listarDetalle();
//                    request.setAttribute("listaulty", listaulty);
                    request.getRequestDispatcher("javasp/DatosFinales.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("javasp/error.jsp").forward(request, response);

                }

                break;

            case "DatosListos":
                int IDdetalle = Integer.parseInt(request.getParameter("txtIDdetalle"));
                String Departamento = request.getParameter("txtDepartamento");
                String Distrito = request.getParameter("txtDistrito");
                String Avenida = request.getParameter("txtAvenida");
                String Referencia = request.getParameter("txtReferencia");
                String DireccionExacta = request.getParameter("txtDireccionExacta");
                String FechaDeseada = request.getParameter("txtFechaDeseada");
                String tipoEntrega = request.getParameter("txtTipoEntrega");

                ultimodate.setCompra(new compra());
                ultimodate.getCompra().setId(IDdetalle);
                ultimodate.setDepartamento(Departamento);
                ultimodate.setDistrito(Distrito);
                ultimodate.setAvenida(Avenida);
                ultimodate.setReferencia(Referencia);
                ultimodate.setDireccExac(DireccionExacta);
                ultimodate.setFechDes(FechaDeseada);
                ultimodate.setTipoEntrega(tipoEntrega);
                metodProd.dteFinal(ultimodate);
                request.getRequestDispatcher("javasp/registrofinal.jsp").forward(request, response);

                break;

            case "Correcto":
                int IDuser = Integer.parseInt(request.getParameter("txtIdusuario"));
                String NombreProducRecomenado = request.getParameter("txtProduName");
                String marcaProducRecomend = request.getParameter("txtProduMarca");
                String descProducrecomend = request.getParameter("txtProduDescrip");

                recomen.setCliente(new Cliente());
                recomen.getCliente().setIDuser(IDuser);
                recomen.setNombreProduc(NombreProducRecomenado);
                recomen.setMarcaProduc(marcaProducRecomend);
                recomen.setDescripProduc(descProducrecomend);
                metodProd.recomendaciones(recomen);
                request.getRequestDispatcher("ControllerCarrito?accion=Inic").forward(request, response);
                break;

            case "Sugerencias":
                List<Recomendaciones> listarecomen = metodProd.listaSugerencias();
                request.setAttribute("listarecomen", listarecomen);
                request.getRequestDispatcher("javasp/listaSugerencias.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("javasp/ropa.jsp").forward(request, response);
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
