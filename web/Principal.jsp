<%-- 
    Document   : Principal
    Created on : 18/07/2019, 11:09:27
    Author     : bruno.alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-reboot.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-reboot.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <!-- javascript-->
        <script src="js/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <title>JSP Page</title>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info ">
            <a class="navbar-brand"  target="myframe" href="Dashboard.jsp">Sistema de Vendas</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNav">
                <ul class="navbar-nav ">
                    <li class="nav-item active">
                        <a class="btn btn-outline-dark btn-sm"   target="myframe"  href="EmpregadoControle?acao=listar" >Empregado</a>
                    </li>
                    &nbsp
                    <li class="nav-item active">
                        <a class="btn btn-outline-dark btn-sm" target="myframe" href="ClienteControle?acao=listar">Cliente</a>
                    </li>
                    &nbsp
                    <li class="nav-item active">
                        <a class="btn btn-outline-dark btn-sm" target="myframe" href="ProdutoControle?acao=listar">Produto</a>
                    </li>
                    &nbsp
                    <li class="nav-item active">
                        <a class="btn btn-outline-dark btn-sm"  target="myframe" href="Venda.jsp">Venda</a>
                    </li>
                </ul>

            </div>
            <div >
                <ul class="nav justify-content-end">

                    <li class="nav-item active">
                        ${nomeusuario}
                    </li>
                    &nbsp
                    &nbsp
                    &nbsp
                    <li class="nav-item active">
                        <a class="btn btn-outline-dark btn-sm" href="Login?acao=Sair">Deslogar</a>
                    </li>

                </ul>
            </div>

        </nav>
        <div class=" m-4 text-center" style=" height: 650px">
            <iframe name="myframe"  style="border:none;height:100%; width:100%"></iframe>
        </div>
    </body>
</html>
