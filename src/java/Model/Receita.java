/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.TipoReceita;
import java.sql.Date;

/**
 *
 * @author Erikson Hille
 * Classe de Receita, responsável por armanezar todas as informações 
 * que pertencem a uma receita
 * esta classe herda todos os atributos e métodos da classe de Lancamento
 */
public class Receita extends Lancamento{
    private String descricao;
    private TipoReceita tipo;

    public Receita(){
        
    }
    
    public Receita(double valor, Date data, Date dataEsperada,
                   Integer contaId, int numeroConta, String descricao,
                   TipoReceita tipo){
        this.valor = valor;
        this.data = data;
        this.dataEsperada = dataEsperada;
        this.contaId = contaId;
        this.numeroConta = numeroConta;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoReceita getTipo() {
        return tipo;
    }

    public void setTipo(TipoReceita tipo) {
        this.tipo = tipo;
    }
    
    
}
