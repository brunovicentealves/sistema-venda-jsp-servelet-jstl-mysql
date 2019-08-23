/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author bruno.alves
 */
public class Produto {
     private int idproduto;
     private String nome;
     private double preco;
     private int estoque;
     private String status;

    public Produto() {
    }

    public Produto(int idproduto, String nome, double preco, int estoque, String status) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.status = status;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
     
     
    
}
