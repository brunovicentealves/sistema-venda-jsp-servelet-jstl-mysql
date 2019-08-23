/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Produto;
import Modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruno.alves
 */
public class ProdutoControle extends HttpServlet {
    Produto produto = new Produto();
    ProdutoDAO pdao = new ProdutoDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao.equalsIgnoreCase("listar")){
        
        request.getRequestDispatcher("Produto.jsp").forward(request, response);
        
        }else if(acao.equalsIgnoreCase("cadastrar")){
        String nome = request.getParameter("txtnomeproduto");
        double preco = Double.parseDouble(request.getParameter("txtpreco"));
        int estoque = Integer.parseInt(request.getParameter("txtestoque"));
        String status = request.getParameter("txtstatusproduto");
        
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setEstoque(estoque);
        produto.setStatus(status);
        
        String resposta = pdao.CadastrarProduto(produto);
        request.getRequestDispatcher("Produto.jsp").forward(request, response);
        
        }else if(acao.equalsIgnoreCase("excluir")){
         id = Integer.parseInt(request.getParameter("id"));
       String resposta= pdao.deletarProduto(id);
        
        request.getRequestDispatcher("Produto.jsp").forward(request, response);
        }else if(acao.equalsIgnoreCase("listarid")){
         id = Integer.parseInt(request.getParameter("id"));
        
        Produto produto = pdao.listarProdutoId(id);
        
        request.setAttribute("editar",produto);
        request.getRequestDispatcher("Produto.jsp").forward(request, response);
        }else if(acao.equalsIgnoreCase("editar")){
            String nome = request.getParameter("txtnomeproduto");
        double preco = Double.parseDouble(request.getParameter("txtpreco"));
        int estoque = Integer.parseInt(request.getParameter("txtestoque"));
        String status = request.getParameter("txtstatusproduto");
        produto.setIdproduto(id);
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setEstoque(estoque);
        produto.setStatus(status);
        
        String resposta = pdao.editarProduto(produto);
            request.getRequestDispatcher("Produto.jsp").forward(request, response);
            
            }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
