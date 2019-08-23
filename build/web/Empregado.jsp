<%-- 
    Document   : Empregado
    Created on : 19/07/2019, 12:30:17
    Author     : bruno.alves
--%>


<%@page import="Modelo.Empregado"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.EmpregadoDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap-reboot.min.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap-reboot.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
<link href="css/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
<link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
<!-- javascript-->
<script src="js/bootstrap.bundle.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/datatables.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="js/dataTables.bootstrap4.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empregado</title>
    </head>
    <body>
        <div class="d-flex" >
            <div class="card  col-sm-4"> 
                <div class="card-body">
                    <form action="EmpregadoControle?" method="GET">
                        <div class="form-group">
                            <input type="text" name="txtnome" required="Preecha o campo" class="form-control"  placeholder="Nome"value="${empregado.getNome()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtcpf" required="Preecha o campo"class="form-control"  placeholder="cpf" value="${empregado.getCpf()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txttelefone" required="Preecha o campo"class="form-control" placeholder="telefone"value="${empregado.getTelefone()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtstatus" required="Preecha o campo"class="form-control" placeholder="Status"value="${empregado.getStatus()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtusuario" required="Preecha o campo" class="form-control" placeholder="Usuario" value="${empregado.getUsuario()}">
                        </div>
                        <input type="submit" name="acao" value="cadastrar" class="btn btn-info ">
                        <input type="submit" name="acao" value="editar" class="btn btn-success ">
                    </form>
                </div>

            </div>
            <div class="card  col-sm-8"> 
                <br>
                <table id="minhaTabela" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th scope="col">Id:</th>
                            <th scope="col">Cpf:</th>
                            <th scope="col">Nome:</th>
                            <th scope="col">Telefone:</th>
                            <th scope="col">Status:</th>
                            <th scope="col">Usuario:</th>
                            <th scope="col">Editar :</th>
                            <th scope="col">Excluir :</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            EmpregadoDAO edao = new EmpregadoDAO();
                            List<Empregado> list = edao.listar();
                            Iterator<Empregado> iter = list.iterator();
                            Empregado emp = null;
                            while (iter.hasNext()) {
                                emp = iter.next();
                        %>
                        <tr>
                            <th scope="row"><%= emp.getIdempregado()%></th>
                            <td><%= emp.getCpf()%></td>
                            <td><%=emp.getNome()%></td>
                            <td><%= emp.getTelefone()%></td>
                            <td><%=emp.getStatus()%></td>
                            <td><%=emp.getUsuario()%></td>
                            <td><a href="EmpregadoControle?acao=listarid&id=<%= emp.getIdempregado()%>"><button type="button" class="btn btn-warning">Editar</button></a></td>
                            <td><a href="EmpregadoControle?acao=excluir&id=<%= emp.getIdempregado()%>"><button type="button" class="btn btn-danger">Excluir</button></a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('#minhaTabela').DataTable({
                    "language": {
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ registros",
                        "infoEmpty": "Mostrando 0 a 0 de 0 Registros",
                        "search": "Busca:",
                        "lengthMenu": "Mostrando _MENU_ Registros",
                        "zeroRecords": "Não foi encontrado nenhum registro",
                        "paginate": {
                            "first": "First",
                            "last": "Last",
                            "next": "Proximo",
                            "previous": "Anterior"
                        },
                    }
                });

                $('#minhaTabela').DataTable({
                    "ajax": baseURL,
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "pageLength": 300,
                    "columnDefs": [
                        {"width": "50%", "targets": 3}
                    ]
                });
            });
        </script>
    </body>
</html>
