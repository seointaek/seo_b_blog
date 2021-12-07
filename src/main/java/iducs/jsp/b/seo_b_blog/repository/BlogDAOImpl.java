package iducs.jsp.b.seo_b_blog.repository;

import iducs.jsp.b.seo_b_blog.model.Blog;

import java.sql.*;
import java.util.List;

public class BlogDAOImpl extends DAOImplOracle implements BlogDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BlogDAOImpl(){
        conn = getConnection();
    }
    @Override
    public int create(Blog blog) {
        String query = "insert into blogb values(seq_blogb.nextval, ?, ?, ?, ?";
        int rows = 0;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, blog.getName());
            pstmt.setString(2, blog.getEmail());
            pstmt.setString(3, blog.getPhone());
            pstmt.setString(4, blog.getMessage());

            rows = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public Blog read(Blog blog) {
        return null;
    }

    @Override
    public List<Blog> readList() {
        return null;
    }

    @Override
    public int update(Blog blog) {
        return 0;
    }

    @Override
    public int delete(Blog blog) {
        return 0;
    }
}
