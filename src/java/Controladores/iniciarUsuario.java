/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import matodosDAO.ClienteDao;
import modelo.Cliente;
import modelo.cargo;

/**
 *
 * @author user
 */
@WebServlet(name = "iniciarUsuario", urlPatterns = {"/iniciarUsuario"})
public class iniciarUsuario extends HttpServlet {
    String inicio = "index.html";
    Cliente cl = new Cliente();
    cargo ca = new cargo();
    ClienteDao dao = new ClienteDao();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        String acceso = "";
        String Nombre = request.getParameter("txtNombre");
        String Apellidos = request.getParameter("txtApellidos");
        String Direccion = request.getParameter("txtDireccion");
        String Correo = request.getParameter("txtcorreo");
        String FechaNac = request.getParameter("txtFecha");
        String Identificacion = request.getParameter("txtIdentificacion");
        String Contrasena = request.getParameter("txtContrasena");
        int IDCargo = Integer.parseInt(request.getParameter("txtIDCargo"));
        
        boolean buscarCorreoRepetido=dao.buscarCorreoRepetido(Correo);
        
        if (buscarCorreoRepetido == true) {
            System.out.println("USUARIO REGISTRADO");

            out.println("alert('ATENCION, EL USUARIO CON EL CORREO: " + Correo + "  YA ESTA REGISTRADO')");
            out.println("location='index.html'");

        } else{
        String accion =request.getParameter("accion");
            if (accion.equalsIgnoreCase("agregarUser")) {
                
                cl.setNombre(Nombre);
                cl.setApellidos(Apellidos);
                cl.setDireccion(Direccion);
                cl.setCorreo(Correo);
                cl.setFechaNac(FechaNac);
                cl.setIdentificacion(Identificacion);
                cl.setContrasena(Contrasena);
                cl.setCargo(new cargo());
                cl.getCargo().setCodigo(IDCargo);
                dao.add(cl);
                
                acceso=inicio;
                
                
            } else {
                System.out.println("ERROR");
                acceso="index.html";
            }
        
        }
         RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
       
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
