<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="Modelos.Productos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <jsp:include page="Head.jsp" />
<jsp:include page="menu.jsp"/>  


  	<!-- Main bar -->
  	<div class="mainbar">
      
	    <!-- Page heading -->
	    <div class="page-head">
        <!-- Page heading -->
	        <h2 class="pull-left">Dashboard 
			  <!-- page meta -->
			  <span class="page-meta">Something Goes Here</span>
			</h2>


			<!-- Breadcrumb -->
			<div class="bread-crumb pull-right">
			  <a href="index.html"><i class="icon-home"></i> Home</a> 
			  <!-- Divider -->
			  <span class="divider">/</span> 
			  <a href="#" class="bread-current">Dashboard</a>
			</div>

			<div class="clearfix"></div>

	    </div>
	    <!-- Page heading ends -->



	    <!-- Matter -->
    <div class="matter">
        <div class="container">

          <div class="row">

            <div class="col-md-12">



                <div class="widget wviolet">

                <div class="widget-head">
                  <div class="pull-left">Tables</div>
                  <div class="widget-icons pull-right">
                    <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
                  </div>
                  <div class="clearfix"></div>
                </div>

                  <div class="widget-content">

                    <table class="table table-bordered ">
                      <thead>
                        <tr>
                          
                          <th>Nombres</th>
                          <th>Descripcion</th>
                          <th>Valor</th>
                          <th>Acciones</th>
                          
                        </tr>
                      </thead>
                      <tbody>
<% Productos prod = (Productos)request.getAttribute("listaProducto");%>
                     
            <tr>

                <td> <%= prod.getNombre() %></td>
                <td> <%= prod.getDescripcion()%></td>
                <td> <%= prod.getValor() %></td>
                          

                <td> 
                    <button class="btn btn-sm btn-success" type="button" title="Editar"  onclick="location.href='EmpleadosController?action=update&id=<%= prod.getIdProducto()%>'"><i class="icon-pencil"></i> </button>
                    <button class="btn btn-sm btn-danger" type="button" title="Eliminar"  onclick="location.href='EmpleadosController?action=delete&id=<%= prod.getIdProducto()%>'"><i class="icon-remove"></i></button>
                </td>emp
                
                
            </tr>
    

                      </tbody>
                    </table>


                  </div>
          </div>

        </div>
      </div>
          <!-- Today status ends -->

          <!-- Dashboard Graph starts -->
</div>
            </div>
          </div>
<jsp:include page="footer.jsp"/>