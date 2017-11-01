<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <jsp:include page="Head.jsp" />
<jsp:include page="menu.jsp"/>  
<!-- Main bar -->
<link rel="stylesheet" href="style/select2.min.css"> 
<script src="js/select2.min.js"></script>
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


              <div class="widget wgreen">
                
                <div class="widget-head">
                  <div class="pull-left">Empleado</div>
                  <div class="widget-icons pull-right">
                    <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
                  </div>
                  <div class="clearfix"></div>
                </div>

                <div class="widget-content">
                  <div class="padd">

                    <h6>Registrar Empleado</h6>
                    <hr />
                    <!-- Form starts.  -->
                     <form action="CotizacionesController?action=create" method="post" class="form-horizontal" role="form">
                              
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Cliente</label>
                                  <div class="col-lg-8">
                                    <select name="idCliente" class="form-control">
                                        <option>Seleccione</option>
                                        <c:forEach  var="clien" items="${requestScope.arrayClientes}">
                                      <option value="${clien.idCliente}"><c:out value="${clien.razonSocial}"/></option>
                                   </c:forEach>
                                                         </select>
                                  </div>
                                </div> 
                                  
               
                          <div class="form-group">
                                  <label class="col-lg-4 control-label">Empleado</label>
                                  <div class="col-lg-8">
                                    <select name="idEmpleado" class="form-control">
                                        <option>Seleccione</option>
                                          <c:forEach  var="empl" items="${requestScope.arrayEmpleados}">
                                      <option value="${empl.idEmpleado}"><c:out value="${empl.nombres}"/></option>
                                   </c:forEach>
                                                         </select>
                                  </div>
                                </div> 
                         
                                <div class="form-group">
                                  <label class="col-lg-4 control-label">Cotizacion Nº</label>
                                  <div class="col-lg-8">
                                    <input name="numero" type="number" class="form-control" placeholder="Numero Cotizacion">
                                  </div>
                                </div>
                         
                               <div class="form-group">
                                  <label class="col-lg-4 control-label">Fecha</label>
                                  <div class="col-lg-8">
                                      <input name="fecha" type="date" min="2017-11-01" max="2022-12-31"  class="form-control" placeholder="Numero Cotizacion">
                                  </div>
                                </div>
                                   <div class="form-group">
                                  <label class="col-lg-4 control-label">Descuento</label>
                                  <div class="col-lg-8">
                                    <input name="descuento" type="number" class="form-control" placeholder="Numero Cotizacion">
                                  </div>
                                </div>  
                         <div class="form-group">
                                  <label class="col-lg-4 control-label">Estado</label>
                                  <div class="col-lg-8">
                                    <select name="estado" class="form-control">
                                        <option>Seleccione</option>
                                        <option value="Edicion">Edicion</option>
                                         <option value="Finalizada">Finalizada</option>
                                          <option value="Aprobada">Aprobada</option>
                                          <option value="Aceptada">Aceptada</option>
                                          <option value="Rechazada">Rechazada</option>
                                                         </select>
                                  </div>
                                </div>  
                         <hr />
                                <div class="form-group">
                                  <div class="col-lg-offset-1 col-lg-9">
                                    <button type="submit" class="btn btn-primary">Enviar</button>
                                     <button type="button" class="btn btn-danger" onclick="javascript:history.go(-1)">Cancelar</button>
                                  </div>
                                </div>
                              </form>
                  </div>
                </div>
                  <div class="widget-foot">
                    <!-- Footer goes here -->
                  </div>
              </div>  

            </div>

          </div>

        </div>
      </div>
          <!-- Today status ends -->

          <!-- Dashboard Graph starts -->

            </div>
          </div>
       


<jsp:include page="footer.jsp"/>