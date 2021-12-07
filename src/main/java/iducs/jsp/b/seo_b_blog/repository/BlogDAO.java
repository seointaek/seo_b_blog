package iducs.jsp.b.seo_b_blog.repository;

import iducs.jsp.b.seo_b_blog.model.Blog;

import java.util.List;

// crud : create read update delete
// http method : post, get, put, delete
public interface BlogDAO {
    int create(Blog blog);
    Blog read(Blog blog);
    List<Blog> readList();
    int update(Blog blog);
    int delete(Blog blog);
}
