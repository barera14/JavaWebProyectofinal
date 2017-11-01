/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alejandro Bernal
 */
public class ClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
    
    switch(action){
        case "create":
            registrar(request,response);
            break;
        case "admin":
            Admin(request, response);
            break;
              case "delete":
            eliminar(request, response);
            break;
         case "update":
            actualizar(request, response);
            break;
        
    }
    }
 private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
      response.setContentType("text/html;charset=UTF-8");          
     String nombre=request.getParameter("razon_social");
          String apellido=request.getParameter("nit");
          String documento=request.getParameter("ciudad");
          String correo=request.getParameter("direccion");
          String perfil=request.getParameter("telefono");
          String passSIn=request.getParameter("password");
          String encriptMD5=DigestUtils.md5Hex(passSIn);
          System.out.println("incriptado"+encriptMD5);
  
            //Creamos objeto con datos de formulario
            Clientes salon= new Clientes(nombre,apellido, documento,correo,perfil,encriptMD5);
            //guardamos objeto en BD
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(salon);
            session.getTransaction().commit();
            session.close();           
    
        try {
            response.sendRedirect("ClientesController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    private void Admin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query q = sesion.createQuery("FROM Clientes");
        //Query q = sesion.createQuery("FROM Odontologos WHERE especialidad = 'General'"); Con el WHERE para condición
        ArrayList listaObjetos = (ArrayList) q.list();
        sesion.close();

        ArrayList<Clientes> cli = new ArrayList<Clientes>();
        for (Object client : listaObjetos) {

            Clientes cliente = (Clientes) client;
            cli.add(cliente);

        }

        request.setAttribute("ArrayCliente", cli);
        
        
        try {
            request.getRequestDispatcher("AdministrarClientes.jsp").forward(request, response);//Redirecionar
        } catch (ServletException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Clientes cliente = (Clientes) sesion.get(Clientes.class, Integer.parseInt(request.getParameter("id")));

        if (request.getMethod().equalsIgnoreCase("GET")) {
            request.setAttribute("cliente", cliente);
            try {
                request.getRequestDispatcher("UpdateClientes.jsp").forward(request, response);//Redirecionar
            } catch (ServletException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             response.setContentType("text/html;charset=UTF-8");
            cliente.setRazonSocial(request.getParameter("razon_social"));
            cliente.setNit(request.getParameter("nit"));
            cliente.setCiudad(request.getParameter("ciudad"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setContrasena(request.getParameter("password"));

            sesion.beginTransaction();
            sesion.saveOrUpdate(cliente);
            sesion.getTransaction().commit();

            try {
                response.sendRedirect("ClientesController?action=admin");
            } catch (IOException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Clientes clientes = (Clientes) sesion.get(Clientes.class, Integer.parseInt(request.getParameter("id")));

        sesion.beginTransaction();
        sesion.delete(clientes);
        sesion.getTransaction().commit();
        sesion.close();

        try {
            response.sendRedirect("ClientesController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
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
