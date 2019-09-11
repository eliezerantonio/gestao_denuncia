/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eliezer
 */
public class Conexao {

    public static Connection getConnection() throws SQLException {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/denuncias";
        String user = "root";
        String password = "1223";
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro na conexao com a base de dados: " + ex.getMessage());
            return null;
        }
        return con;
    }

    public static void closeConnection(Connection conn) {
        close(conn, null, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        close(conn, ps, rs);
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao desalocar recurso: " + ex.getMessage());
        }
    }

}
