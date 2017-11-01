/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Clientes;
import Modelos.Cotizaciones;
import Modelos.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class CotizacionesController extends HttpServlet {

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
        case "select":
            Select(request, response);
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
              SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
             int emple=Integer.parseInt(request.getParameter("idEmpleado"));
          int clie=Integer.parseInt(request.getParameter("idCliente"));
          
              String numero=request.getParameter("numero");
          String fecha=request.getParameter("fecha");
          int descuento=Integer.parseInt(request.getParameter("descuento"));
          String estado=request.getParameter("estado");
          Date fechafin = new Date();
        try {
             fechafin = sm.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(CotizacionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
             
              Session sesion = HibernateUtil.getSessionFactory().openSession();
             Empleados emp=(Empleados) sesion.get(Empleados.class, emple);
             Clientes cli=(Clientes) sesion.get(Clientes.class, clie);
            //Creamos objeto con datos de formulario
            Cotizaciones salon= new Cotizaciones(cli, emp, numero, fechafin,descuento,estado);
            //guardamos objeto en BD
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(salon);
            session.getTransaction().commit();
            session.close();
    
        try {
            response.sendRedirect("CotizacionesController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(CotizacionesController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void Select(HttpServletRequest request, HttpServletResponse response){
        
          
              Session sesion = HibernateUtil.getSessionFactory().openSession();
             Query qprofesor =(Query) sesion.createQuery("FROM Clientes");
            ArrayList listaprofesor =(ArrayList) qprofesor.list();
            
            
            ArrayList<Clientes> arrayProfesor = new ArrayList<Clientes>();
            
            for(Object Obj: listaprofesor){
             Clientes prof = (Clientes) Obj;
             arrayProfesor.add(prof);
             
            }
            request.setAttribute("arrayClientes", arrayProfesor);
            
            
            
            Query qCarrera =(Query) sesion.createQuery("FROM Empleados");
            ArrayList listaCarrera =(ArrayList) qCarrera.list();
      
            
            ArrayList<Empleados> arrayCarrera = new ArrayList<Empleados>();
            
            for(Object Obj: listaCarrera){
             Empleados salon = (Empleados) Obj;
             arrayCarrera.add(salon);
             
            }
           
            request.setAttribute("arrayEmpleados", listaCarrera);
          
                 sesion.close();
            try {     
            request.getRequestDispatcher("CreateCotizacion.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CotizacionesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CotizacionesController.class.getName()).log(Level.SEVERE, null, ex);
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
