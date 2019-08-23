<%-- 
    Document   : Produto
    Created on : 22/07/2019, 16:38:09
    Author     : bruno.alves
--%>

<%@page import="Modelo.Produto"%>
<%@page import="Modelo.ProdutoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
        <title>Cliente</title>
    </head>
    <body>
        <div class="d-flex" >
            <div class="card  col-sm-4"> 
                <div class="card-body">
                    <form action="ProdutoControle?" method="GET">
                        <div class="form-group">

                            <input type="text" name="txtnomeproduto" required="Preecha o campo"placeholder="Nome Produto" class="form-control" value="${ editar.getNome()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtpreco" required="Preecha o campo" pattern="([0-9]{1,3}\.)?[0-9]{1,3}.[0-9]{2}$" class="form-control" placeholder="Preço do Produto" value="${ editar.getPreco()}">
                        </div>
                        <div class="form-group">
                            <input type="number" name="txtestoque" required="Preecha o campo"class="form-control" placeholder="Quantidade" value="${ editar.getEstoque()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtstatusproduto" required="Preecha o campo" class="form-control"  placeholder="Status" value="${ editar.getStatus()}">
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
                            <th>Id:</th>
                            <th>Nome :</th>
                            <th>Preço :</th>
                            <th>Estoque:</th>
                            <th>Status:</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           ProdutoDAO pdao = new ProdutoDAO();
                            List<Produto> list = pdao.listarProduto();
                            Iterator<Produto> iter = list.iterator();
                            Produto pro = null;
                            while (iter.hasNext()) {
                                pro = iter.next();
                        %>
                        <tr>
                            <th><%= pro.getIdproduto()%></th>
                            <td><%= pro.getNome()%></td>
                            <td><%=pro.getPreco()%></td>
                            <td><%= pro.getEstoque()%></td>
                            <td><%=pro.getStatus()%></td>
                            <td><a href="ProdutoControle?acao=listarid&id=<%= pro.getIdproduto()%>"><button type="button" class="btn btn-warning">Editar</button></a>
                            </td>
                            <td><a href="ProdutoControle?acao=excluir&id=<%= pro.getIdproduto()%>"><button type="button" class="btn btn-danger">Excluir</button></a></td>
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


