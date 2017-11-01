/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import Controlador.HibernateUtil;
import Modelos.Clientes;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Query;
/**
 *
 * @author Alejandro Bernal
 */
public class EmpleadosController extends HttpServlet {

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
            administrar(request, response);
            break;
        case "delete":
            eliminar(request, response);
            break;
        
        
    }
    }

private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empleados empleado = (Empleados) sesion.get(Empleados.class, Integer.parseInt(request.getParameter("id")));

        sesion.beginTransaction();
        sesion.delete(empleado);
        sesion.getTransaction().commit();
        sesion.close();

        try {
            response.sendRedirect("EmpleadosController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
   private void registrar(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
               String nombre=request.getParameter("nombres");
          String apellido=request.getParameter("apellidos");
          String documento=request.getParameter("documento");
          String correo=request.getParameter("correo");
          String passSIn=request.getParameter("password");
          String encriptMD5=DigestUtils.md5Hex(passSIn);
          System.out.println("incriptado"+encriptMD5);
         
          String perfil=request.getParameter("tipo");
          
            //Creamos objeto con datos de formulario
            Empleados salon= new Empleados(nombre,apellido, documento,correo,encriptMD5,perfil);
            //guardamos objeto en BD
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(salon);
            session.getTransaction().commit();
            session.close();
    
     
        try {
            response.sendRedirect("EmpleadosController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            
            
 }
    private void administrar(HttpServletRequest request, HttpServletResponse response){
        
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            
            Query q =(Query) sesion.createQuery("FROM Empleados");
            ArrayList emp =(ArrayList) q.list();
            sesion.close();
            
            ArrayList<Empleados> sal = new ArrayList<Empleados>();
            
            for(Object Salone: emp){
             Empleados objemp = (Empleados) Salone;
             sal.add(objemp);
             
            }
            
            request.setAttribute("listaEmpleados", emp);
            
       try {     
            request.getRequestDispatcher("AdministarEmpleado.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
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
