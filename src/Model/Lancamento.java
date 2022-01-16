/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author A
 */
public class Lancamento {

   

    public static void setDataEsperada(Date aDataEsperada) {
        dataEsperada = aDataEsperada;
    }

    public static Date getData() {
        return data;
    }

    public static void setData(Date aData) {
        data = aData;
    }
    private Integer id;
    private String descricao;
    private double valor;
    private static Date data ;
    private static Date dataEsperada;
    private int NrConta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNrConta() {
        return NrConta;
    }

    public void setNrConta(int NrConta) {
        this.NrConta = NrConta;
    }

  
}