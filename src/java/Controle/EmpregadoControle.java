/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Empregado;
import Modelo.EmpregadoDAO;
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
public class EmpregadoControle extends HttpServlet {

    Empregado empregado = new Empregado();
    EmpregadoDAO edao = new EmpregadoDAO();
    int id =0;

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
            request.getRequestDispatcher("Empregado.jsp").forward(request, response);
        } else if (acao.equalsIgnoreCase("cadastrar")) {
            String cpf = request.getParameter("txtcpf");
            String nome = request.getParameter("txtnome");
            String telefone = request.getParameter("txttelefone");
            String status = request.getParameter("txtstatus");
            String usuario = request.getParameter("txtusuario");
            empregado.setCpf(cpf);
            empregado.setNome(nome);
            empregado.setTelefone(telefone);
            empregado.setStatus(status);
            empregado.setUsuario(usuario);
            String Resposta = edao.cadastrar(empregado);
            request.getRequestDispatcher("Empregado.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("excluir")) {
             id = Integer.parseInt(request.getParameter("id"));

            String resposta = edao.delete(id);
            request.getRequestDispatcher("Empregado.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("listarid")) {
            id = Integer.parseInt(request.getParameter("id"));

            Empregado empregado = edao.listarid(id);

            request.setAttribute("empregado", empregado);

            request.getRequestDispatcher("Empregado.jsp").forward(request, response);

        } else if (acao.equalsIgnoreCase("editar")) {
            String cpf = request.getParameter("txtcpf");
            String nome = request.getParameter("txtnome");
            String telefone = request.getParameter("txttelefone");
            String status = request.getParameter("txtstatus");
            String usuario = request.getParameter("txtusuario");
            empregado.setIdempregado(id);
            empregado.setCpf(cpf);
            empregado.setNome(nome);
            empregado.setTelefone(telefone);
            empregado.setStatus(status);
            empregado.setUsuario(usuario);
             edao.editar(empregado);
              request.getRequestDispatcher("Empregado.jsp").forward(request, response);

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
