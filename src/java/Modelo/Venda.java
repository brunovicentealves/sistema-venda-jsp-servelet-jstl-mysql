/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author bruno.alves
 */
public class Venda {
    
    private Integer idvenda ;
    private Integer item;
    private Integer idcliente;
    private Integer idempregado;
    private Integer idproduto;
    private String nunserie;
    private String descricaoproduto;
    private  String fecha;
    private Double preco;
    private Integer quantidadeestoque;
    private Integer quantidadevenda;
    private Double subtotal;
    private String status;

    public Venda() {
    }

    public Venda(Integer id, Integer item, Integer idcliente, Integer idempregado, Integer idproduto, String nunserie, String descricaoproduto, String fecha, Double preco, Integer quantidadeestoque,Integer quantidadevenda, Double subtotal, String status) {
        this.idvenda = id;
        this.item = item;
        this.idcliente = idcliente;
        this.idempregado = idempregado;
        this.idproduto = idproduto;
        this.nunserie = nunserie;
        this.descricaoproduto = descricaoproduto;
        this.fecha = fecha;
        this.preco = preco;
        this.quantidadeestoque = quantidadeestoque;
        this.quantidadevenda = quantidadevenda;
        this.subtotal = subtotal;
        this.status = status;
    }

    public Integer getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(Integer quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public Integer getQuantidadevenda() {
        return quantidadevenda;
    }

    public void setQuantidadevenda(Integer quantidadevenda) {
        this.quantidadevenda = quantidadevenda;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer id) {
        this.idvenda = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdempregado() {
        return idempregado;
    }

    public void setIdempregado(Integer idempregado) {
        this.idempregado = idempregado;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getNunserie() {
        return nunserie;
    }

    public void setNunserie(String nunserie) {
        this.nunserie = nunserie;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
          
    
}
