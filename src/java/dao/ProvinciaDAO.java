/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Provincia;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class ProvinciaDAO implements GenericoDAO<Provincia> {

    private static final String BUSCAR_POR_CODIGO = "select*from provincia where id_provincia=?";
    private static final String BUSCAR_TODOS = "select * from provincia order by id_provincia";

    @Override
    public boolean save(Provincia provincia) {
        return false;

    }

    @Override
    public boolean update(Provincia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Provincia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provincia findById(Integer codigo) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Provincia provincia = new Provincia();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, provincia.getCodigoProvincia());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um Municpio com o codigo: " + codigo);
            }
            popularComDados(provincia, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return provincia;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Provincia> findAll() {
     PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Provincia> listaProvincia= new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia provincia = new Provincia();
                listaProvincia.add(provincia);
                popularComDados(provincia, rs);
                
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return listaProvincia;
    }

    private void popularComDados(Provincia provincia, ResultSet rs) {
        try {
            provincia.setCodigoProvincia(rs.getInt(1));
            provincia.setDescricaoDenucia(rs.getString(2));
           

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
