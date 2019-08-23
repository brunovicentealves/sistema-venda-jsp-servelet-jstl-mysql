/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Produto;
import Modelo.ProdutoDAO;
import Modelo.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruno.alves
 */
public class VendaControle extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    Cliente cliente = new Cliente();
    Produto produto = new Produto();
    ProdutoDAO pdao = new ProdutoDAO();
    Venda venda = new Venda();
    int id;
    int item;
    String descricao;
    Double preco;
    int estoque;
    int quantidade;
    Double subtotal;
    double totalpagar;

    List<Venda> lista = new ArrayList<>();

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
        if (acao.equalsIgnoreCase("buscarcliente")) {
            String codigocliente = request.getParameter("txtcodigocliente");
            Cliente cli = cdao.buscarCliente(codigocliente);

            request.setAttribute("cli",cli);

            request.getRequestDispatcher("Venda.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("buscarproduto")) {
            id = Integer.parseInt(request.getParameter("txtcodigoproduto"));

            produto = pdao.listarProdutoId(id);
            request.setAttribute("produto", produto);
            
             for (int i = 0; i < lista.size(); i++) {

                totalpagar = totalpagar + lista.get(i).getSubtotal();
            }
            request.setAttribute("totalpagar", totalpagar);
            request.setAttribute("lista", lista);
            totalpagar = totalpagar - totalpagar;

            request.getRequestDispatcher("Venda.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("adcionarcarrinho")) {

            item = item + 1;
            id = Integer.parseInt(request.getParameter("txtcodigoproduto"));
            descricao = request.getParameter("txtnomeproduto");
            preco = Double.parseDouble(request.getParameter("txtprodutopreco"));
            estoque = Integer.parseInt(request.getParameter("txtprodutoestoque"));
            quantidade = Integer.parseInt(request.getParameter("txtprodutoquantidade"));
            subtotal = preco * quantidade;
            Venda venda = new Venda();
            venda.setItem(item);
            venda.setIdproduto(id);
            venda.setDescricaoproduto(descricao);
            venda.setPreco(preco);
            venda.setQuantidadevenda(quantidade);
            venda.setQuantidadeestoque(estoque);
            venda.setSubtotal(subtotal);
            lista.add(venda);

            for (int i = 0; i < lista.size(); i++) {

                totalpagar = totalpagar + lista.get(i).getSubtotal();
            }
            request.setAttribute("totalpagar", totalpagar);
            request.setAttribute("lista", lista);
            totalpagar = totalpagar - totalpagar;
            request.getRequestDispatcher("Venda.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("cencelarvenda")) {

            for (int i = 0; i < lista.size(); i++) {

                lista.remove(i);
            }
            request.getRequestDispatcher("Venda.jsp").forward(request, response);
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
