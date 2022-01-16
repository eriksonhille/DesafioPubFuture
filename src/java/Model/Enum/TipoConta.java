/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enum;

/**
 *
 * @author Erikson Hille
 * Enum responsável por armanezar as informações do Tipo de Conta
 * que a entidade de Conta poderá ter
 */
public enum TipoConta {
    Carteira,
    ContaCorrente,
    Poupanca;
    
    //este método ficará responsável por converter o valor salvo no banco 
    //no enum que corresponde ao seu valor
    public static TipoConta converterPorInteiro(int valor){
        switch(valor){
            case 0:
                return Carteira;
            case 1:
                return ContaCorrente;
        }
        
        return Poupanca;
    }
}
