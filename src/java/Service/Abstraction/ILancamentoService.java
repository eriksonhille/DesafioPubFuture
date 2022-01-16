/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Abstraction;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Erikson Hille
 * Esta interface é responsável por encapsular a regra das funcionalidades
 * que um lançamento terá.
 * Quem a implementar terá que implementar todos os métodos que estão descritos 
 * na mesma.
 * Ela é feita de maneira genérica para quem a implementar definir o tipo da
 * entidade que irá realizar as ações
 */
public interface ILancamentoService<T> {
    void cadastrar(T lancamento);
    void editar(T lancamentoEditado);
    void deletar(Integer id);
    List<T> listarTodos();
    List<T> listarPorPeriodo(Date dataInicio, Date dataFim);
    double retonarTotal(Integer contaId);
}
