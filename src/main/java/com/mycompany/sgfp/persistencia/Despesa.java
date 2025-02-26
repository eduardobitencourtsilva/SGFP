package com.mycompany.sgfp.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="despesas")
public class Despesa {
    @Id
    private int id;
    private String nome;
    private double valor;
    private String tipo;
    private String categoria;
    private String status;

    public Despesa() {
    }

    public Despesa(int id, String nome, double valor, String tipo, String categoria, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.status = status;
    }

    public Despesa(String nome, double valor, String tipo, String categoria, String status) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.status = status;
    }

    public Despesa(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
