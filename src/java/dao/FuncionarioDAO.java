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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Denuncia;
import modelo.Funcionario;
import modelo.Municipio;
import modelo.TipoDenuncia;
import modelo.TipoFuncionario;
import util.Conexao;

/**
 *
 * @author eliezer
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario> {

    private static final String INSERIR = "insert into funcionario(	nome_funcionario,	sobrenome_funcionario,	\n"
            + "telefone_funcionario,	email_funcionario,usuario_funcionario,	senha_funcionario,	Sexo,	tipo_funcionario) values(\n"
            + "?,?,?,?,?,?,?,?)";
    private static final String BUSCAR_POR_CODIGO = "select *from funcionario where id_funcionario=?";
    private static final String ELIMINAR = "delete from funcionario where id_funcionario=?";
    private static final String BUSCAR_TODOS = "select *from funcionario";
    private static final String ATUALIZAR = "update funcionario set	nome_funcionario =?,	sobrenome_funcionario=?,	\n"
            + "telefone_funcionario=?,	email_funcionario,usuario_funcionario=?,	senha_funcionario=?,	Sexo=?,	tipo_funcionario=? where id_funcionario=?";

    @Override
    public boolean save(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.out.println("O valor inserido nao pode ser nulo");
        }

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setString(3, funcionario.getTelefoneFuncionario());
            ps.setString(4, funcionario.getEmailFuncionario()
            );
            ps.setString(5, funcionario.getUsuarioFuncionario());
            ps.setString(6, funcionario.getSenhaFuncionario());
            ps.setInt(7, funcionario.getTipoFuncionario().getCodigoTipoFuncionario());
            ps.execute();
        } catch (SQLException ex) {

            System.out.println("Erro ao salvar Funcionario" +ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;

    }

    @Override
    public boolean update(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.out.println("O valor inserido nao pode ser nulo");
        }

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setString(3, funcionario.getTelefoneFuncionario());
            ps.setString(4, funcionario.getEmailFuncionario()
            );
            ps.setString(5, funcionario.getUsuarioFuncionario());
            ps.setString(6, funcionario.getSenhaFuncionario());
            ps.setInt(7, funcionario.getTipoFuncionario().getCodigoTipoFuncionario());
            ps.setInt(8, funcionario.getCodigoFuncionario());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;
    }

    @Override
    public boolean delete(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.out.println("O valor inserido nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
        } catch (SQLException ex) {

            System.out.println("Erro ao eliminar funcionario" +ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps);
        }
        return false;

    }

    public boolean logar(Funcionario funcionario) {

        boolean controlo = false;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (funcionario.getUsuarioFuncionario().equals(rs.getString("usuario_funcionario"))
                        && funcionario.getSenhaFuncionario().equals(rs.getString("senha_funcionario"))) {

                    controlo = true;

                }

            }
            return controlo;

        } catch (SQLException e) {
            System.out.println("Erro na conexao");

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return controlo;

    }

    @Override
    public Funcionario findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario(id);
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, funcionario.getCodigoFuncionario());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao foi econtrado nem um registo com o codigo: " + id);
            }
            popularComDados(funcionario, rs);

        } catch (SQLException e) {
            System.out.println("Erro ao ler os dados" + e.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn, ps, rs);
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn
                    = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection((com.mysql.jdbc.Connection) conn);
        }
        return funcionarios;
    }

    private void popularComDados(Funcionario funcionario, ResultSet rs) {
        try {
            funcionario.setCodigoFuncionario(rs.getInt(1));
            funcionario.setNomeFuncionario(rs.getString(3));
            funcionario.setSobrenomeFuncionario(rs.getString(4));
            funcionario.setTelefoneFuncionario(rs.getString(5));
            funcionario.setEmailFuncionario(rs.getString(6));
            funcionario.setSexo(rs.getString(7));
            TipoFuncionario tipoFuncionario = new TipoFuncionario();
            funcionario.setTipoFuncionario(tipoFuncionario);
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: *****" + ex.getLocalizedMessage());
        }

    }
}
