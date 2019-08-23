<%-- 
    Document   : index
    Created on : 17/07/2019, 15:26:41
    Author     : bruno.alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
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

        <title>Login</title>
    </head>
    <div class="container mt-4 col-lg-4">
        <div class="card col-sm-10">
            <div class="card-body text-center">
                <form class="form-sign" action="Login" method="POST">
                    <div class="form-group">
                        <h3>Login</h3>   
                        <img src="img/login.png" alt="70" width="170"/>
                    </div >
                    <div class="form-group">
                        <label>Usuario:</label>
                        <input type="text" name="txtusuario" value=""class="form-control">
                    </div >
                    <div class="form-group">
                        <label>Digite a senha :</label>
                        <input type="password" name="txtpassword" value=""class="form-control">
                    </div>
                    <input type="submit" name="acao" value="Logar" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
    <body>

    </body>
</html>
