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
import modelo.Estado;
import modelo.TipoDenuncia;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class TipoDenunciaDAO implements GenericoDAO<TipoDenuncia> {

    private static final String BUSCAR_TODOS = "select * from tipo_denuncia";
    private static final String BUSCAR_POR_CODIGO = "select * from tipo_denuncia where id_tipo_denuncia=?";

    @Override
    public boolean save(TipoDenuncia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TipoDenuncia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(TipoDenuncia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoDenuncia findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        TipoDenuncia tipoDenuncia = new TipoDenuncia(id);
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, tipoDenuncia.getCodigoTipoDenuncia());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um registo com o codigo: " + id);
            }
            popularComDados(tipoDenuncia, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return tipoDenuncia;

    }

    @Override
    public List<TipoDenuncia> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<TipoDenuncia> tipoDenuncias = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDenuncia tipoDenuncia = new TipoDenuncia();
                popularComDados(tipoDenuncia, rs);
                tipoDenuncias.add(tipoDenuncia);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return tipoDenuncias;
    }

    private void popularComDados(TipoDenuncia tipoDenuncia, ResultSet rs) {
        try {
            tipoDenuncia.setCodigoTipoDenuncia(rs.getInt(1));
            tipoDenuncia.setDescricaoDenuncia(rs.getString(2));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }

    }
}
