/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Denuncia;
import modelo.Despacho;
import modelo.Estado;
import modelo.Funcionario;
import modelo.TipoFuncionario;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class DespachoDAO implements GenericoDAO<Despacho> {
    
    private static final String INSERIR = "insert into despacho(id_funcionario,id_denucia,data_despacho,id_estado)values(?,?,now(),?)";
    
    private static final String BUSCAR_TODOS = "select id_despacho,nome_funcionario,id_denucia,descricao_estado,data_despacho from despacho \n" +
"inner join funcionario on despacho.id_funcionario=funcionario.id_funcionario\n" +
"inner join estado on estado.id_estado=despacho.id_estado\n" +
"inner join denuncia on denuncia.id_denuncia=despacho.id_denucia";
    
    private static final String ATUALIZAR = "update despacho set id_funcionario=?, id_denucia=?,id_estado=? where id_despacho=?";
    
    private static final String ELIMINAR = "delete from despacho where id_despacho=?";
    private static final String BUSCAR_POR_CODIGO = "select * from despacho where id_despacho=?";
    
    private static final String CONTADOR_CIDADAO = "select count(*) from cidadao";
    
    @Override
    public boolean  save(Despacho despacho) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (despacho == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, despacho.getFuncionario().getCodigoFuncionario());
            ps.setInt(2, despacho.getDenuncia().getCodigoDenuncia());
            ps.setInt(3, despacho.getEstado().getCodigoEstado());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados : " + e.getLocalizedMessage());
            
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;
        
    }
    
    @Override
    public boolean update(Despacho despacho) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (despacho == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, despacho.getFuncionario().getCodigoFuncionario());
            ps.setInt(2, despacho.getDenuncia().getCodigoDenuncia());
            ps.setInt(3, despacho.getEstado().getCodigoEstado());
            ps.setInt(4, despacho.getCodigoDespacho());
            ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados : " + e.getLocalizedMessage());
            
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;
    }
    
    @Override
    public boolean delete(Despacho despacho) {
        
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (despacho == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, despacho.getCodigoDespacho());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao eliminar os dados os dados : " + e.getLocalizedMessage());
            
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;
    }
    
    @Override
    public Despacho findById(Integer id) {
        return null;
        
    }
    
    @Override
    public List<Despacho> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Despacho> despachos = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Despacho despacho = new Despacho();
                popularComDados(despacho, rs);
                despachos.add(despacho);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
            
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return despachos;
    }
    
    private void popularComDados(Despacho despacho, ResultSet rs) {
        try {
            despacho.setCodigoDespacho(rs.getInt(1));
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFuncionario(rs.getString(2));
            despacho.setFuncionario(funcionario);
            Denuncia denuncia = new Denuncia();
            denuncia.setCodigoDenuncia(rs.getInt(3));
            despacho.setDenuncia(denuncia);
            Estado estado = new Estado();
            estado.setDescricaoEstado(rs.getString(4));
            despacho.setEstado(estado);
            despacho.setDataDespacho(rs.getDate(5));
           
            
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }
        
    }
}
