/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidadao;
import modelo.Municipio;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class CidadaoDAO implements GenericoDAO<Cidadao> {

    private static final String INSERIR = "insert into cidadao(	nome_cidadao,	sobrenome_cidadao,	telefone_cidadao,"
            + "	email_cidadao,	data_nascimento_cidadao, usuario_cidado,senha_cidadao,"
            + "data_cadastro_cidadao,id_municipio_cidadao)values(?,?,?,?,?,?,?,now(),?)";
    
    private static final String BUSCAR_TODOS = "select id_cidadao,nome_cidadao,	sobrenome_cidadao,\n" +
"	telefone_cidadao,	email_cidadao	,data_nascimento_cidadao,\n" +
"	usuario_cidado,	senha_cidadao	,\n" +
"	data_cadastro_cidadao,	nome_municipio from cidadao  inner join\n" +
"	 municipio  on  municipio.id_municipio=cidadao.id_municipio_cidadao";
    
    private static final String ATUALIZAR = "update cidadao set  nome_cidadao=?,sobrenome_cidadao=?,	"
            + "telefone_cidadao=?,email_cidadao=?,data_nascimento_cidadao=?,usuario_cidado=?,"
            + "senha_cidadao=?,id_municipio_cidadao=?,  where id_cidadao=?";

    private static final String ELIMINAR = "delete from cidadao where id_cidadao=?";
    private static final String BUSCAR_POR_CODIGO = "select * from ciadao where id_cidadao";

    private static final String CONTADOR_CIDADAO = "select count(*) from cidadao";

    @Override
    public boolean save(Cidadao cidadao) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (cidadao == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, cidadao.getNomeCidadao());
            ps.setString(2, cidadao.getSobrenomeCidadao());
            ps.setString(3, cidadao.getTelefoneCidadao());
            ps.setString(4, cidadao.getEmailCidadao());
            ps.setDate(5, new java.sql.Date(cidadao.getDataNascimentoCidadao().getTime()));
            ps.setString(6, cidadao.getUsuarioCidadao());
            ps.setString(7, cidadao.getSenhaCidadao());
            ps.setInt(8, cidadao.getMunicipio().getCodigoMunicipio());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados : " + e.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;

    }

    @Override
    public boolean update(Cidadao cidadao) {
        boolean controlo = false;

        PreparedStatement ps = null;
        Connection conn = null;

        if (cidadao == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setString(1, cidadao.getNomeCidadao());
            ps.setString(2, cidadao.getSobrenomeCidadao());
            ps.setString(3, cidadao.getTelefoneCidadao());
            ps.setString(4, cidadao.getEmailCidadao());
            ps.setDate(5, new java.sql.Date(cidadao.getDataNascimentoCidadao().getTime()));
            ps.setString(6, cidadao.getUsuarioCidadao());
            ps.setString(7, cidadao.getSenhaCidadao());
            ps.setInt(8, cidadao.getCodigoCidadao());
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Sucesso");
            controlo = true;
            return controlo;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados" + e.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return controlo;
    }

    @Override
    public boolean delete(Cidadao cidadao) {

        PreparedStatement ps = null;
        Connection conn = null;

        if (cidadao == null) {
            System.out.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

            ps.setInt(1, cidadao.getCodigoCidadao());
            ps.execute();
            //JOptionPane.showMessageDialog(null, "Sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao eliminar os dados" + e.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;
    }

    @Override
    public Cidadao findById(Integer codigo) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Cidadao cidadao = new Cidadao();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, cidadao.getCodigoCidadao());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um registo com o codigo: " + codigo);
            }
            popularComDados(cidadao, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return cidadao;

    }

    @Override
    public List<Cidadao> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Cidadao> listaCidadao = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cidadao cidadao = new Cidadao();
                popularComDados(cidadao, rs);
                listaCidadao.add(cidadao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return listaCidadao;

    }

    public List<Cidadao> contador() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Cidadao> listaCidadao = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(CONTADOR_CIDADAO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cidadao cidadao = new Cidadao();
                popularComDados(cidadao, rs);
                listaCidadao.add(cidadao);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return listaCidadao;

    }

    private void popularComDados(Cidadao cidadao, ResultSet rs) {
        try {
            cidadao.setCodigoCidadao(rs.getInt(1));
            cidadao.setNomeCidadao(rs.getString(2));
            cidadao.setSobrenomeCidadao(rs.getString(3));
            cidadao.setTelefoneCidadao(rs.getString(4));
            cidadao.setEmailCidadao(rs.getString(5));
            cidadao.setDataNascimentoCidadao(rs.getDate(6));
            cidadao.setUsuarioCidadao(rs.getString(7));
            cidadao.setSenhaCidadao(rs.getString(8));
            cidadao.setDataCadastro(rs.getDate(9));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString(2));
            cidadao.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }
    }

}
