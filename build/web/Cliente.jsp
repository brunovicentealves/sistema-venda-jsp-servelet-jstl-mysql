<%-- 
    Document   : Cliente
    Created on : 22/07/2019, 14:33:26
    Author     : bruno.alves
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
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
                    <form action="ClienteControle" method="GET">
                        <div class="form-group">
                            <input type="text" name="txtnome" required="Preecha o campo" class="form-control"  placeholder="Nome" value="${cliente.getNome()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtcpf" required="Preecha o campo" class="form-control" placeholder="Cpf" value="${cliente.getCpf()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txttelefone" required="Preecha o campo" class="form-control"  placeholder="Telefone" value="${cliente.getTelefone()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="txtendereco" required="Preecha o campo" class="form-control"  placeholder="Endereço" value="${cliente.getEndereco()}">
                        </div>
                        <div class="row">
                            <div class="col">
                                <input type="text" name="txtnumero" required="Preecha o campo" class="form-control"  placeholder="Nº" value="${cliente.getNumero()}">
                            </div>
                            <div class="col">
                                <input type="text" name="txtcep" required="Preecha o campo"class="form-control"  placeholder="Cep" value="${cliente.getCep()}">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col">
                                <input type="text" name="txtbairro" required="Preecha o campo"class="form-control" placeholder="Bairro" value="${cliente.getBairro()}">
                            </div>
                            <div class="col">
                                <input type="text" name="txtcidade"  required="Preecha o campo" class="form-control"  placeholder="Cidade" value="${cliente.getCidade()}">
                            </div>
                        </div>
                        <br>
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
                            
                            <th>Nome :</th>
                            <th>Telefone:</th>
                            <th>Endereço:</th>
                            <th>Cidade:</th>
                            <th>Bairro:</th>
                            <th>Cep:</th>
                            <th>Editar:</th>
                            <th>Excluir:</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ClienteDAO cdao = new ClienteDAO();
                            List<Cliente> list = cdao.listarCliente();
                            Iterator<Cliente> iter = list.iterator();
                            Cliente cli = null;
                            while (iter.hasNext()) {
                                cli = iter.next();
                        %>
                        <tr>
                            <td><%= cli.getNome()%></td>
                            <td><%= cli.getTelefone()%></td>
                            <td><%=cli.getEndereco()+", Nº"+cli.getNumero()%></td>
                            <td><%=cli.getCidade()%></td>
                            <td><%=cli.getBairro()%></td>
                            <td><%=cli.getCep()%></td>
                            <td><a href="ClienteControle?acao=listarid&id=<%= cli.getIdcliente()%>"><button type="button" class="btn btn-warning">Editar</button></a>
                            </td>
                            <td><a href="ClienteControle?acao=excluir&id=<%= cli.getIdcliente()%>"><button type="button" class="btn btn-danger">Excluir</button></a></td>
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

