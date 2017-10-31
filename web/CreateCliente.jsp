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
                  <div class="pull-left">Cliente</div>
                  <div class="widget-icons pull-right">
                    <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> 
                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
                  </div>
                  <div class="clearfix"></div>
                </div>

                <div class="widget-content">
                  <div class="padd">

                    <h6>Registrar Cliente</h6>
                    <hr />
                    <!-- Form starts.  -->
                     <form action="ClientesController?action=create" method="post" class="form-horizontal" role="form">
                              
                                <div class="form-group">
                                  <label class="col-lg-4 control-label">Razon Social</label>
                                  <div class="col-lg-8">
                                    <input name="razon_social" type="text" class="form-control" placeholder="Razon Social">
                                  </div>
                                </div>
                                   <div class="form-group">
                                  <label class="col-lg-4 control-label">Nit</label>
                                  <div class="col-lg-8">
                                      <input name="nit" type="text" class="form-control" placeholder="Nit">
                                  </div>
                                </div>
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Ciudad</label>
                                  <div class="col-lg-8">
                                      <input name="ciudad" type="text" class="form-control" placeholder="Ciudad">
                                  </div>
                                </div>
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Direccion</label>
                                  <div class="col-lg-8">
                                      <input name="direccion" type="text" class="form-control" placeholder="Direccion">
                                  </div>
                                </div>
                                 <div class="form-group">
                                  <label class="col-lg-4 control-label">Telefono</label>
                                  <div class="col-lg-8">
                                      <input name="telefono" type="text" class="form-control" placeholder="Telefono">
                                  </div>
                                </div>
                              <div class="form-group">
                                  <label class="col-lg-4 control-label">Contraseña</label>
                                  <div class="col-lg-8">
                                      <input name="password" type="password" class="form-control" placeholder="Contraseña">
                                  </div>

                                </div>                                                        <hr />


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