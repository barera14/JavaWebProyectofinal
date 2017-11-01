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
<<<<<<< HEAD

            <c:forEach var="emp" items="${requestScope.listaProducto}">          
            <tr>

                <td><c:out value="${emp.nombre}"/></td>
                <td> <c:out value="${emp.descripcion}"/></td>
                <td> <c:out value="${emp.valor}"/></td>
                          

                <td> 
                    <button class="btn btn-sm btn-success" type="button" title="Editar"  onclick="location.href='ProductoController?action=update&id=<c:out value="${emp.idProducto}"/>'"><i class="icon-pencil"></i> </button>
                    <button class="btn btn-sm btn-danger" type="button" title="Eliminar"  onclick="location.href='ProductoController?action=delete&id=<c:out value="${emp.idProducto}"/>'"><i class="icon-remove"></i></button>
                </td>
                
                
            </tr>
     </c:forEach>

=======
<c:forEach var="prod" items="${requestScope.listaProducto}">
                     
            <tr>

                <td> <c:out value="${prod.nombre}"/></td>
                <td> <c:out value="${prod.descripcion}"/></td>
                <td> <c:out value="${prod.valor}"/></td>
                          

                <td> 
                    <button class="btn btn-sm btn-success" type="button" title="Editar"  onclick="location.href='EmpleadosController?action=update&id=${prod.idProducto}'"><i class="icon-pencil"></i> </button>
                    <button class="btn btn-sm btn-danger" type="button" title="Eliminar"  onclick="location.href='EmpleadosController?action=delete&id=${prod.idProducto}'"><i class="icon-remove"></i></button>
                </td>emp
                
                
            </tr>
    
 </c:forEach>
>>>>>>> 5d3abd86c32a14aacce74f6f0392a286e903036f
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