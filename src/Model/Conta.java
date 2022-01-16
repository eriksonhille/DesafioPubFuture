/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Enum.TipoConta;

/**
 *
 * @author A
 */


public class Conta  {
    private int id;
    private String banco;
    private int nrConta;
    private String tipo;
    private int Contaid;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getContaid() {
        return Contaid;
    }

    public void setContaid(int Contaid) {
        this.Contaid = Contaid;
    }

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public void setTipo(TipoConta tipoConta) {
        
    }
    
}
