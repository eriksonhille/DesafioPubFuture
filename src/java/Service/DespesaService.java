/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Despesa;
import Model.Enum.TipoDespesa;
import Service.Abstraction.ILancamentoService;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erikson Hille
 * Esta classe (service) ficará responsável por implementar o ILancamentoService
 * e então implementar todos os métodos descritos na mesma para a entidade 
 * de Despesa
 */
public class DespesaService implements ILancamentoService<Despesa>{

    public void cadastrar(Despesa lancamento) {
        String sql = "insert into Despesa (valor, data, dataEsperada, contaId, "
                     + "numeroConta, tipo) "
                     + "values(?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1, lancamento.getValor());
            stm.setDate(2, lancamento.getData());
            stm.setDate(3, lancamento.getDataEsperada());
            stm.setInt(4, lancamento.getContaId());
            stm.setInt(5, lancamento.getNumeroConta());
            stm.setInt(6, lancamento.getTipo().ordinal());
                    
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível cadastrar esta despesa");
        }
    }

    public void editar(Despesa lancamentoEditado) {
        String sql = "update Despesa set valor = ?, data = ?, dataEsperada = ?,"
                     + "contaId = ?, numeroConta = ?, tipo = ? "
                     + "where id = ?";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1, lancamentoEditado.getValor());
            stm.setDate(2, lancamentoEditado.getData());
            stm.setDate(3, lancamentoEditado.getDataEsperada());
            stm.setInt(4, lancamentoEditado.getContaId());
            stm.setInt(5, lancamentoEditado.getNumeroConta());
            stm.setInt(6, lancamentoEditado.getTipo().ordinal());
            stm.setInt(7, lancamentoEditado.getId());
            
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível editar esta despesa");
        }
    }

    public void deletar(Integer id) {
        Connection con = Conexao.conectar();
        String sql = "delete from Despesa where id = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();                       
        } catch (SQLException ex){
            System.out.println("Erro: Não foi possível excluir a despesa");
        }
    }

    public List<Despesa> listarTodos() {
        Connection con = Conexao.conectar();
        String sql = "select * from Despesa";
        List<Despesa> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id"));
                despesa.setValor(rs.getDouble("saldo"));
                despesa.setData(rs.getDate("data"));
                despesa.setDataEsperada(rs.getDate("dataEsperada"));
                despesa.setContaId(rs.getInt("contaId"));
                despesa.setNumeroConta(rs.getInt("numeroConta"));
                despesa.setTipo(TipoDespesa.converterPorInteiro(rs.getInt("tipo")));

                lista.add(despesa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de despesas");
        }
        
        return lista;
    }

    public List<Despesa> listarPorPeriodo(Date dataInicio, Date dataFim) {
        Connection con = Conexao.conectar();
        String sql = "select * from Despesa where data between ? and ?";
        List<Despesa> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1, dataInicio);
            stm.setDate(2, dataFim);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id"));
                despesa.setValor(rs.getDouble("saldo"));
                despesa.setData(rs.getDate("data"));
                despesa.setDataEsperada(rs.getDate("dataEsperada"));
                despesa.setContaId(rs.getInt("contaId"));
                despesa.setNumeroConta(rs.getInt("numeroConta"));
                despesa.setTipo(TipoDespesa.converterPorInteiro(rs.getInt("tipo")));

                lista.add(despesa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de despesas");
        }
        
        return lista;
    }

    public double retonarTotal(Integer contaId) {
        Connection con = Conexao.conectar();
        String sql = "select sum(valor) as total from Despesa where contaId = ?";
        double total = 0;

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, contaId);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar o total de despesas");
        }
        
        return total;
    }
    
    public List<Despesa> listarPorTipo(TipoDespesa tipo){
        Connection con = Conexao.conectar();
        String sql = "select * from Despesa where tipo = ?";
        List<Despesa> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, tipo.ordinal());
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id"));
                despesa.setValor(rs.getDouble("saldo"));
                despesa.setData(rs.getDate("data"));
                despesa.setDataEsperada(rs.getDate("dataEsperada"));
                despesa.setContaId(rs.getInt("contaId"));
                despesa.setNumeroConta(rs.getInt("numeroConta"));
                despesa.setTipo(TipoDespesa.converterPorInteiro(rs.getInt("tipo")));

                lista.add(despesa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de despesas");
        }
        
        return lista;
    }
    
}
