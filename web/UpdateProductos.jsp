<%@page import="Modelos.Productos"%>
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
                            <div class="pull-left">Productos</div>
                            <div class="widget-icons pull-right">
                                <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> 
                                <a href="#" class="wclose"><i class="icon-remove"></i></a>
                            </div>
                            <div class="clearfix"></div>
                        </div>

                        <div class="widget-content">
                            <div class="padd">

                                <h6>Registrar Producto</h6>
                                <hr />
                                <!-- Form starts.  -->
                                <% Productos SActualizar = (Productos) request.getAttribute("salon");%>
                                <form action="ProductoController?action=update&id=<%= SActualizar.getIdProducto()%>" method="post" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">Nombre</label>
                                        <div class="col-lg-8">
                                            <input name="nombre" type="text" class="form-control" placeholder="Nombre" value="<%= SActualizar.getNombre()%>"> <br>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">Descripcion</label>
                                        <div class="col-lg-8">
                                            <input name="descripcion" type="text" class="form-control" placeholder="Descripcion" value="<%= SActualizar.getDescripcion()%>"><br>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">Valor</label>
                                        <div class="col-lg-8">
                                            <input name="valor"type="number" class="form-control" placeholder="Valor"value="<%= SActualizar.getValor()%>>"<br>
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