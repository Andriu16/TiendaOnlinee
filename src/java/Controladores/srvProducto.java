/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import matodosDAO.ClienteDao;
import matodosDAO.ProductoDAO;
import modelo.Cliente;
import modelo.Producto;


/**
 *
 * @author user
 */
@WebServlet(name = "srvProducto", urlPatterns = {"/srvProducto"})
@MultipartConfig
public class srvProducto extends HttpServlet {

    ClienteDao dao1 = new ClienteDao();
    String inicio = "javasp/vistaAdmin.jsp";
    Producto produc = new Producto();
    ProductoDAO metodProd = new ProductoDAO();
    String addprod = "javasp/agregarProducto.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    
                    
                    case "iniciar":

                        Verificar(request, response);

                        break;

                    default:
                        response.sendRedirect("javasp/vistaAdmin.jsp");
                }

            } else {
                response.sendRedirect("javasp/vistaAdmin.jsp");
            }

        } catch (Exception e) {
            System.out.println("ERR" + e);
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

    private void Verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        HttpSession sesion;
        Cliente cliente;
        cliente = this.obtenerUsuario(request);

        dao1 = new ClienteDao();
        cliente = dao1.identificar(cliente);
        //

        //
        if ((cliente != null) && (cliente.getCargo().getNombreCargo().equals("ADMIN"))) {
            sesion = request.getSession();
            sesion.setAttribute("cliente", cliente);
            request.setAttribute("msje", "Bienvenido");

            this.getServletConfig().getServletContext().getRequestDispatcher("/javasp/vistaAdmin.jsp").forward(request, response);
            acceso = inicio;
        } else if (cliente != null && cliente.getCargo().getNombreCargo().equals("COMPRADOR")) {
           

            sesion = request.getSession();
            sesion = request.getSession();
            sesion.setAttribute("COMPRADOR", cliente);
            this.getServletConfig().getServletContext().getRequestDispatcher("/javasp/home1.jsp").forward(request, response);
            acceso = "/javasp/home1.jsp";
            System.out.println("si se entro home");
        } else {
            request.setAttribute("msje", "DATA INCORRECTA");//no sale alerta
            request.getRequestDispatcher("index.html").forward(request, response);
            System.out.println("no entro home");
        }

    }

    private Cliente obtenerUsuario(HttpServletRequest request) {
        Cliente u = new Cliente();
        u.setCorreo(request.getParameter("txtCorreo"));
        u.setContrasena(request.getParameter("txtContrasena"));
        return u;
    }

}
