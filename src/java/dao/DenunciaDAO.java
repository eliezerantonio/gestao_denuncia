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
import modelo.Municipio;
import modelo.TipoDenuncia;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class DenunciaDAO implements GenericoDAO<Denuncia> {

    private static final String INSERIR = "insert into denuncia(id_municipio,	tipo_denuncia,	descricao_denuncia,data_registro_denuncia,	nome_cidadao,telefone_cidadao, 	email_cidadao,	data_ocorrencia) values(?,?,?,now(),?,?,?,?)\n"
            + " ";
    private static final String BUSCAR_POR_CODIGO = "select * from denuncia where id_denuncia =?";
    private static final String BUSCAR_TODOS = "select * from denuncia ";

    @Override
    public boolean save(Denuncia denuncia) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (denuncia == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, denuncia.getMunicipio().getCodigoMunicipio());
            ps.setInt(2, denuncia.getTipoDenuncia().getCodigoTpoDenuncia());
            ps.setString(3, denuncia.getDescricaoDenuncia());
            ps.setString(4, denuncia.getNomeCidadaoDenuncia());
            ps.setString(5, denuncia.getEmailCidadaoDenuncia());
            ps.setDate(6, new java.sql.Date(denuncia.getDataOcorrenciaDenuncia().getTime()));

        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean update(Denuncia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Denuncia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Denuncia findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Denuncia denuncia = new Denuncia(id);
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, denuncia.getCodigoDenuncia());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um registo com o codigo: " + id);
            }
            popularComDados(denuncia, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados#" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return denuncia;

    }

    @Override
    public List<Denuncia> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Denuncia> denuncias = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Denuncia denuncia = new Denuncia();
                popularComDados(denuncia, rs);
                denuncias.add(denuncia);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados*: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return denuncias;
    }

    private void popularComDados(Denuncia denuncia, ResultSet rs) {
        try {
            denuncia.setCodigoDenuncia(rs.getInt(1));
            denuncia.setNomeCidadaoDenuncia(rs.getString(6));
            denuncia.setEmailCidadaoDenuncia(rs.getString(8));
            denuncia.setTelefoneCidadaoDenuncia(rs.getString(7));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString(2));
            denuncia.setMunicipio(municipio);
            TipoDenuncia tipoDenuncia = new TipoDenuncia();
            tipoDenuncia.setDescricaoDenuncia(rs.getString(2));
            denuncia.setTipoDenuncia(tipoDenuncia);
            denuncia.setDataRegistoDenuncia(rs.getDate(5));
            denuncia.setDataOcorrenciaDenuncia(rs.getDate(9));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }

    }
}
