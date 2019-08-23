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
public class Empregado {
    
    private int idempregado;
    private String cpf;
     private String nome;
    private String telefone;
    private String Status;
    private String usuario;

    public Empregado() {
    }

    public Empregado(int idempregado, String cpf,String nome, String telefone, String Status, String usuario) {
        this.idempregado = idempregado;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.Status = Status;
        this.usuario = usuario;
         
        
    }

    public int getIdempregado() {
        return idempregado;
    }

    public void setIdempregado(int idempregado) {
        this.idempregado = idempregado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
