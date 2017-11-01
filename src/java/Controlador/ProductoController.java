/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Empleados;
import Modelos.Productos;
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
public class ProductoController extends HttpServlet {

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

        switch (action) {
            case "create":
                registrar(request, response);
                break;
            case "admin":
                administrar(request, response);
                break;

            case "delete":
                eliminar(request, response);
                break;
            case "update":
                actualizar(request, response);
                break;

        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int valor = Integer.parseInt(request.getParameter("valor"));

        //Creamos objeto con datos de formulario
        Productos produ = new Productos(nombre, descripcion, valor);
        //guardamos objeto en BD
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(produ);
        session.getTransaction().commit();
        session.close();

        try {
            response.sendRedirect("ProductoController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void administrar(HttpServletRequest request, HttpServletResponse response) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query q = (Query) sesion.createQuery("FROM Productos");
        ArrayList emp = (ArrayList) q.list();
        sesion.close();

        ArrayList<Productos> pro = new ArrayList<Productos>();

        for (Object Salone : emp) {
            Productos objemp = (Productos) Salone;
            pro.add(objemp);

        }

        request.setAttribute("listaProducto", emp);

        try {
            request.getRequestDispatcher("AdministrarProductos.jsp").forward(request, response);
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

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Productos producto = (Productos) sesion.get(Productos.class, Integer.parseInt(request.getParameter("id")));

        sesion.beginTransaction();
        sesion.delete(producto);
        sesion.getTransaction().commit();
        sesion.close();

        try {
            response.sendRedirect("ProductoController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Productos producto = (Productos) sesion.get(Productos.class, Integer.parseInt(request.getParameter("id")));

        if (request.getMethod().equalsIgnoreCase("GET")) {
            request.setAttribute("producto", producto);
           
            try {
                request.getRequestDispatcher("UpdateProductos.jsp").forward(request, response);//Redirecionar
            } catch (ServletException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        } else {
            producto.setNombre(request.getParameter("nombre"));
            producto.setDescripcion(request.getParameter("descripcion"));
            producto.setValor(Integer.parseInt(request.getParameter("valor")));

            sesion.beginTransaction();
            sesion.saveOrUpdate(producto);
            sesion.getTransaction().commit();

            
            try {
                response.sendRedirect("ProductoController?action=admin");
            } catch (IOException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
}


