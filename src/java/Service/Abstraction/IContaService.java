/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Abstraction;

import Model.Conta;
import java.util.List;

/**
 *
 * @author Erikson Hille
 * Esta interface é responsável por encapsular a regra das funcionalidades
 * que uma conta terá.
 * Quem a implementar terá que implementar todos os métodos que estão descritos 
 * na mesma.
 */
public interface IContaService {
    void cadastrar(Conta conta);
    void editar(Conta contaEditada);
    void deletar(Integer id);
    List<Conta> listarTodas();
    void TransferirSaldo(Conta contaEnvio, Conta contaDestino);
    double RetornarSaldo(Integer id);
}
