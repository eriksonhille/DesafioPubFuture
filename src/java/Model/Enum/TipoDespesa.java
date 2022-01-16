/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enum;

/**
 *
 * @author Erikson Hille
 * Enum responsável por armanezar as informações do Tipo de Despesa
 * que a entidade de Despesa poderá ter
 */
public enum TipoDespesa {
    Alimentacao,
    Educacao, 
    Lazer, 
    Moradia, 
    Roupa, 
    Saude,
    Transporte, 
    Outros;
    
    //este método ficará responsável por converter o valor salvo no banco 
    //no enum que corresponde ao seu valor
    public static TipoDespesa converterPorInteiro(int valor){
        switch(valor){
            case 0:
                return Alimentacao;
            case 1:
                return Educacao;
            case 2:
                return Lazer;
            case 3:
                return Moradia;
            case 4:
                return Roupa;
            case 5:
                return Saude;
            case 6:
                return Transporte;
        }
        
        return Outros;
    }
}
