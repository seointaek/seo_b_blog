package iducs.jsp.b.seo_b_blog.repository;

import java.sql.*;

public class DAOImplOracle implements DAO {
    Connection conn = null;
    @Override
    public Connection getConnection() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String dbUser = "system";
        String dbPw = "cometrue";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }
    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs){

    }

}
