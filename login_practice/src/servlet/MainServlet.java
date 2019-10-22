package servlet;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求数据
        User user = (User) req.getSession().getAttribute("user");
        int num = (int) this.getServletContext().getAttribute("num");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+ user.getUsername() +"访问</h3>");
        resp.getWriter().write("当前网页的浏览次数为：" + num);
        resp.getWriter().write("<hr>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
