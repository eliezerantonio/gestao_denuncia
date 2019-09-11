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
import modelo.Cidadao;
import modelo.Denuncia;
import modelo.Despacho;
import modelo.Estado;
import modelo.Funcionario;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class EstadoDAO implements GenericoDAO<Estado> {

    private static final String BUSCAR_TODOS = "select * from estado";
    private static final String BUSCAR_POR_CODIGO= "select * from estado where id_estado=?";

    @Override
    public boolean save(Estado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Estado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Estado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Estado estado = new Estado(id);
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, estado.getCodigoEstado());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um registo com o codigo: " + id);
            }
            popularComDados(estado, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return estado;
    }

    @Override
    public List<Estado> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                popularComDados(estado, rs);
                estados.add(estado);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return estados;
    }

    private void popularComDados(Estado estado, ResultSet rs) {
        try {
            estado.setCodigoEstado(rs.getInt(1));
            estado.setDescricaoEstado(rs.getString(2));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }

    }
}
