<%-- 
    Document   : Venda
    Created on : 31/07/2019, 13:16:31
    Author     : bruno.alves
--%>

<%@page import="Controle.VendaControle"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Venda"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class=" card col-sm-4">
                &nbsp
                <div class="text-center">
                    <label>Dados do Cliente</label>
                </div>
                &nbsp
                <form action="VendaControle" method="GET">
                    <div class="form-row">
                        <div class="col-3">
                            <button type="submit"   class="btn btn-dark" name="acao" value="buscarcliente">Buscar</button>
                        </div>
                        <div class="col">

                            <input type="text"  name="txtcodigocliente" placeholder="Codigo Cliente"    class="form-control" value="${cli.getIdcliente()}">
                        </div>
                    </div>
                    &nbsp
                    <div>
                        <input type="text"  name="txtnomecliente" placeholder="Nome do Cliente" class="form-control" value="${cli.getNome()}">
                    </div>
                    &nbsp
                    <div class="text-center">
                        <label>Dados do Produto </label>
                    </div>
                    &nbsp
                    <div class="form-row">
                        <div class="col-3">

                            <button type="submit"   class="btn btn-dark" name="acao" value="buscarproduto" >Buscar</button>
                        </div>
                        <div class="col">
                            <input type="text" name="txtcodigoproduto" placeholder="Codigo do Produto" class="form-control" value="${produto.getIdproduto()}">
                        </div>
                    </div>
                    &nbsp
                    <div>
                        <input type="text"   name="txtnomeproduto"placeholder="Nome do Produto" class="form-control" value="${produto.getNome()}">
                    </div>
                    &nbsp
                    <div class="form-row">
                        <div class="col-6">
                            <input type="text"  name="txtprodutoestoque"placeholder="Estoque" class="form-control" value="${produto.getEstoque()}">
                        </div>
                        <div class="col">
                            <input type="text" name="txtprodutopreco" placeholder="Preco" class="form-control" value="${produto.getPreco()}">
                        </div>
                    </div>
                        &nbsp
                        <div class="form-row">
                        <div class="col-6">
                            <input type="text"  name="txtprodutoquantidade" placeholder="Quantidade de venda" class="form-control">
                        </div>
                    </div>
                    &nbsp
                    <div>
                        <button type="submit"   class="btn btn-success" name="acao" value="adcionarcarrinho">Adicionar ao Carrinho</button>
                    </div>

                </form>
            </div>
            <div class=" card col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-3 ml-auto">
                            <label>Nº serie : </label>
                            &nbsp
                            <input type="text" name="numeroSerie" class="form-control">
                        </div>
                        &nbsp
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Nro</th>
                                    <th scope="col">ID_Produto</th>
                                    <th scope="col">Produto</th>
                                    <th scope="col">Preço</th>
                                    <th scope="col">QTD</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="ite" items="${lista}">
                                <tr>
                                    <th scope="row"><c:out value="${ite.getItem()}"/></th>
                                    <td ><c:out value="${ite.getIdproduto()}"/></td>
                                     <td ><c:out value="${ite.getDescricaoproduto()}"/></td>
                                      <td ><c:out value="${ite.getPreco()}"/></td>
                                      <td ><c:out value="${ite.getQuantidadevenda()}"/></td>
                                      <td ><c:out value="${ite.getSubtotal()}"/></td>
                                       <td><a href=""><button type="button" class="btn btn-warning">Editar</button></a>
                                           <a href=""><button type="button" class="btn btn-danger">Excluir</button></a>
                                       </td>
                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                        <div class="card-footer d-flex">
                            <div>
                                <input type="button" name="acao" value="Realizar a Venda" class="btn btn-outline-primary">
                                <a href="VendaControle?acao=cencelarvenda"><button type="button" class="btn btn-outline-danger">Cancelar venda</button></a>
                            </div>
                            <div class="col-sm-3 ml-auto">
                                <input type="text" name="txttotal" value="${totalpagar}" class="form-control text-center font-weight">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
