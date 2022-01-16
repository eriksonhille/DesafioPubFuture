/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enum;

/**
 *
 * @author Erikson Hille
 * Enum responsável por armanezar as informações do Tipo de Receita
 * que a entidade de Receita poderá ter
 */
public enum TipoReceita {
    Salario,
    Presente, 
    Premio, 
    Outros;
    
    //este método ficará responsável por converter o valor salvo no banco 
    //no enum que corresponde ao seu valor
    public static TipoReceita converterPorInteiro(int valor){
        switch(valor){
            case 0:
                return Salario;
            case 1:
                return Presente;
            case 2:
                return Premio;
        }
        
        return Outros;
    }
}
