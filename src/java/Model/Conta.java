/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.TipoConta;

/**
 *
 * @author Erikson Hille
 * Classe de Conta, responsável por armanezar todas as informações 
 * que pertencem a uma conta
 */
public class Conta {
    private Integer id;
    private int numero;
    private double saldo;
    private TipoConta tipo;
    private String instituicaoFinanceira;

    public Conta(){
    }
    
    public Conta(int numero, double saldo, TipoConta tipo, String instituicaoFinanceira) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }
}
