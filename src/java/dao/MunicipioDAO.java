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
import modelo.Municipio;
import modelo.Provincia;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class MunicipioDAO implements GenericoDAO<Municipio> {

    private static final String BUSCAR_POR_CODIGO = "select* from municipio where id_municipio=?";
    private static final String BUSCAR_TODOS = "select m.id_municipio,m.nome_municipio, p.nome_provincia from municipio m inner join provincia p on \n"
            + "p.id_provincia=m.id_provincia";

    @Override
    public boolean save(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean  delete(Municipio t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Municipio municipio = new Municipio(id);
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);

            ps.setInt(1, municipio.getCodigoMunicipio());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + municipio.getCodigoMunicipio()
                );
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return municipio;

    }

    /**
     *
     * @return
     */
    @Override
    public List<Municipio> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                municipios.add(municipio);
                popularComDados(municipio, rs);

            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return municipios;
    }

    private void popularComDados(Municipio municipio, ResultSet rs) {
        try {
            municipio.setCodigoMunicipio(rs.getInt(1));
            municipio.setNomeMunicipio(rs.getString(2));
            Provincia provincia = new Provincia();
            provincia.setDescricaoDenucia(rs.getString(2));
            municipio.setProvicia(provincia);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
