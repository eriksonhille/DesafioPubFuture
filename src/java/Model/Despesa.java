/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.TipoDespesa;
import java.sql.Date;

/**
 *
 * @author Erikson Hille
 * Classe de Despesa, responsável por armanezar todas as informações 
 * que pertencem a uma despesa
 * esta classe herda todos os atributos e métodos da classe de Lancamento
 */
public class Despesa extends Lancamento{
    private TipoDespesa tipo;

    public Despesa(){
        
    }
    
    public Despesa(double valor, Date data, Date dataEsperada,
                   Integer contaId, int numeroConta, TipoDespesa tipo){
        this.valor = valor;
        this.data = data;
        this.dataEsperada = dataEsperada;
        this.contaId = contaId;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
    }
    
    public TipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesa tipo) {
        this.tipo = tipo;
    }
    
    
}
