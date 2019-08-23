/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cliente;
import Modelo.ClienteDAO;
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
public class ClienteControle extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
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
        if (acao.equalsIgnoreCase("listar")) {

            request.getRequestDispatcher("Cliente.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("cadastrar")) {
            String nome = request.getParameter("txtnome");
            String cpf = request.getParameter("txtcpf");
            String telefone = request.getParameter("txttelefone");
            String endereco = request.getParameter("txtendereco");
            String numero = request.getParameter("txtnumero");
            String bairro = request.getParameter("txtbairro");
            String cidade = request.getParameter("txtcidade");
            int cep = Integer.parseInt(request.getParameter("txtcep"));
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setCep(cep);

            String respota = cdao.cadastrarCliente(cliente);
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);

            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (acao.equalsIgnoreCase("excluir")) {
             id = Integer.parseInt(request.getParameter("id"));

            cdao.deleteCliente(id);

            request.getRequestDispatcher("Cliente.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("listarid")) {

             id = Integer.parseInt(request.getParameter("id"));
            Cliente teste = cdao.listarClienteId(id);

            request.setAttribute("cliente", teste);

            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (acao.equalsIgnoreCase("editar")){
            String nome = request.getParameter("txtnome");
            String cpf = request.getParameter("txtcpf");
            String telefone = request.getParameter("txttelefone");
            String endereco = request.getParameter("txtendereco");
            String numero = request.getParameter("txtnumero");
            String bairro = request.getParameter("txtbairro");
            String cidade = request.getParameter("txtcidade");
            int cep = Integer.parseInt(request.getParameter("txtcep"));
            cliente.setIdcliente(id);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setCep(cep);
            
            String resposta = cdao.editarCliente(cliente);
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);

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
