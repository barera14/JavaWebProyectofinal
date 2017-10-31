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
                     <form action="EmpleadosController?action=create" method="post" class="form-horizontal" role="form">
                              
                                <div class="form-group">
                                  <label class="col-lg-4 control-label">Nombres</label>
                                  <div class="col-lg-8">
                                    <input name="nombres" type="text" class="form-control" placeholder="Nombres">
                                  </div>
                                </div>
                                   <div class="form-group">
                                  <label class="col-lg-4 control-label">Apellidos</label>
                                  <div class="col-lg-8">
                                      <input name="apellidos" type="text" class="form-control" placeholder="Apellidos">
                                  </div>
                                </div>
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Documento</label>
                                  <div class="col-lg-8">
                                      <input name="documento" type="number" class="form-control" placeholder="Documento">
                                  </div>
                                </div>
                                 
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Correo</label>
                                  <div class="col-lg-8">
                                      <input name="correo" type="email" class="form-control" placeholder="Correo">
                                  </div>
                                </div>
                              <div class="form-group">
                                  <label class="col-lg-4 control-label">Contraseña</label>
                                  <div class="col-lg-8">
                                      <input name="password" type="password" class="form-control" placeholder="Contraseña">
                                  </div>
                                </div>
                                <div class="form-group">
                                  <label class="col-lg-4 control-label">Tipo de Usuario</label>
                                  <div class="col-lg-8">
                                    <select name="tipo" class="form-control">
                                        <option>Seleccione</option>
                                        <option value="Gerente">Gerente</option>
                                         <option value="DirVentas">DirVentas</option>
                                          <option value="Vendedor">Vendedor</option>
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