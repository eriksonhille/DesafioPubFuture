/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Model.Conta;
import Model.Enum.TipoConta;
import Service.Abstraction.IContaService;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erikson Hille
 * Esta classe (service) ficará responsável por implementar o IContaService
 * e então implementar todos os métodos descritos na mesma
 */
public class ContaService implements IContaService {
    
    public void cadastrar(Conta conta) {
        String sql = "insert into Conta (numero, saldo, tipo, instituicaoFinanceira) "
                     + "values(?, ?, ?, ?)";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, conta.getNumero());
            stm.setDouble(2, conta.getSaldo());
            stm.setInt(3, conta.getTipo().ordinal());
            stm.setString(4, conta.getInstituicaoFinanceira());           
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível cadastrar esta conta");
        }
    }

    public void editar(Conta contaEditada) {
        String sql = "update Conta set numero = ?, saldo = ?, tipo = ?, instituicaoFinanceira = ? "
                    + "where id = ?";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, contaEditada.getNumero());
            stm.setDouble(2, contaEditada.getSaldo());
            stm.setInt(3, contaEditada.getTipo().ordinal());
            stm.setString(4, contaEditada.getInstituicaoFinanceira());
            stm.setInt(5, contaEditada.getId());
            
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível editar esta conta");
        }
    }

    public void deletar(Integer id) {
        Connection con = Conexao.conectar();
        String sql = "delete from Conta where id = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();                       
        } catch (SQLException ex){
            System.out.println("Erro: Não foi possível excluir a conta");
        }
    }

    public List<Conta> listarTodas() {
        Connection con = Conexao.conectar();
        String sql = "select * from Conta";
        List<Conta> lista = new ArrayList<>();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setNumero(rs.getInt("numero"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setTipo(TipoConta.converterPorInteiro(rs.getInt("tipo")));
                conta.setInstituicaoFinanceira(rs.getString("instituicaoFinanceira"));

                lista.add(conta);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar a lista de contas");
        }
        
        return lista;
    }

    public void TransferirSaldo(Conta contaEnvio, Conta contaDestino) {
         String sql = "update Conta set saldo = case id "
                    + " when ? then (?)"
                    + " else ? "
                    + "where id in (?,?)";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, contaDestino.getId());
            stm.setDouble(2, (contaDestino.getSaldo() + contaEnvio.getSaldo()));
            stm.setDouble(3, 0);
            stm.setInt(4, contaEnvio.getId());
            stm.setInt(5, contaDestino.getId());
            
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível transferir os saldos entre as contas");
        }
    }

    public double RetornarSaldo(Integer id) {
        Connection con = Conexao.conectar();
        String sql = "select saldo from Conta where id = ?";
        double saldo = 0;

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                saldo = rs.getDouble("saldo");
            }

        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possível retornar o saldo da conta");
        }
        
        return saldo;
    }
    
}
