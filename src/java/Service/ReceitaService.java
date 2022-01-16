/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Enum.TipoReceita;
import Model.Receita;
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
 * de Receita
 */
public class ReceitaService implements ILancamentoService<Receita>{

    public void cadastrar(Receita lancamento) {
        String sql = "insert into Receita (valor, data, dataEsperada, contaId, "
                     + "numeroConta, descricao, tipo) "
                     + "values(?, ?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1, lancamento.getValor());
            stm.setDate(2, lancamento.getData());
            stm.setDate(3, lancamento.getDataEsperada());
            stm.setInt(4, lancamento.getContaId());
            stm.setInt(5, lancamento.getNumeroConta());
            stm.setString(6, lancamento.getDescricao());   
            stm.setInt(7, lancamento.getTipo().ordinal());
                    
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível cadastrar esta receita");
        }
    }

    public void editar(Receita lancamentoEditado) {
        String sql = "update Receita set valor = ?, data = ?, dataEsperada = ?,"
                     + "contaId = ?, numeroConta = ?, descricao = ?, tipo = ? "
                     + "where id = ?";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1, lancamentoEditado.getValor());
            stm.setDate(2, lancamentoEditado.getData());
            stm.setDate(3, lancamentoEditado.getDataEsperada());
            stm.setInt(4, lancamentoEditado.getContaId());
            stm.setInt(5, lancamentoEditado.getNumeroConta());
            stm.setString(6, lancamentoEditado.getDescricao());   
            stm.setInt(7, lancamentoEditado.getTipo().ordinal());
            stm.setInt(8, lancamentoEditado.getId());
            
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível editar esta receita");
        }
    }

    public void deletar(Integer id) {
        Connection con = Conexao.conectar();
        String sql = "delete from Receita where id = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();                       
        } catch (SQLException ex){
            System.out.println("Erro: Não foi possível excluir a receita");
        }
    }

    public List<Receita> listarTodos() {
        Connection con = Conexao.conectar();
        String sql = "select * from Receita";
        List<Receita> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId(rs.getInt("id"));
                receita.setValor(rs.getDouble("saldo"));
                receita.setData(rs.getDate("data"));
                receita.setDataEsperada(rs.getDate("dataEsperada"));
                receita.setContaId(rs.getInt("contaId"));
                receita.setNumeroConta(rs.getInt("numeroConta"));
                receita.setDescricao(rs.getString("descricao"));
                receita.setTipo(TipoReceita.converterPorInteiro(rs.getInt("tipo")));

                lista.add(receita);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de receitas");
        }
        
        return lista;
    }

    public List<Receita> listarPorPeriodo(Date dataInicio, Date dataFim) {
        Connection con = Conexao.conectar();
        String sql = "select * from Receita where data between ? and ?";
        List<Receita> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1, dataInicio);
            stm.setDate(2, dataFim);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId(rs.getInt("id"));
                receita.setValor(rs.getDouble("saldo"));
                receita.setData(rs.getDate("data"));
                receita.setDataEsperada(rs.getDate("dataEsperada"));
                receita.setContaId(rs.getInt("contaId"));
                receita.setNumeroConta(rs.getInt("numeroConta"));
                receita.setDescricao(rs.getString("descricao"));
                receita.setTipo(TipoReceita.converterPorInteiro(rs.getInt("tipo")));

                lista.add(receita);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de receitas");
        }
        
        return lista;
    }

    public double retonarTotal(Integer contaId) {
        Connection con = Conexao.conectar();
        String sql = "select sum(valor) as total from Receita where contaId = ?";
        double total = 0;

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, contaId);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar o total de receitas");
        }
        
        return total;
    }
    
    public List<Receita> listarPorTipo(TipoReceita tipo){
        Connection con = Conexao.conectar();
        String sql = "select * from Receita where tipo = ?";
        List<Receita> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, tipo.ordinal());
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId(rs.getInt("id"));
                receita.setValor(rs.getDouble("saldo"));
                receita.setData(rs.getDate("data"));
                receita.setDataEsperada(rs.getDate("dataEsperada"));
                receita.setContaId(rs.getInt("contaId"));
                receita.setNumeroConta(rs.getInt("numeroConta"));
                receita.setDescricao(rs.getString("descricao"));
                receita.setTipo(TipoReceita.converterPorInteiro(rs.getInt("tipo")));

                lista.add(receita);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de receitas");
        }
        
        return lista;
    }
    
}
