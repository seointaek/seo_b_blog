package iducs.jsp.b.seo_b_blog.controller;

import iducs.jsp.b.seo_b_blog.model.Blog;
import iducs.jsp.b.seo_b_blog.repository.BlogDAOImpl;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "post", value = "/blogs/post.do")
public class BlogController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException  {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("UTF-8");

        Blog blog = new Blog();
        blog.setName(request.getParameter("name"));
        blog.setEmail(request.getParameter("email"));
        blog.setPhone(request.getParameter("phone"));
        blog.setMessage(request.getParameter("message"));
        // 데이터베이스 처리 요청 또는 서비스 요청 코드가 추가
        BlogDAOImpl dao = new BlogDAOImpl();
        if(dao.create(blog) > 0) {
            // 처리된 결과를 애트리뷰트로 설정한다.
            /*
            request.setAttribute("name", blog.getName());
            request.setAttribute("email", blog.getEmail());
            */
            request.setAttribute("blog", blog);
            // 처리 결과를 view에 전달한다.
            request.getRequestDispatcher("about.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
    public void destroy() {
    }
}