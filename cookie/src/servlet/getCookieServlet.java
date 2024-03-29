package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getCookieServlet",urlPatterns = "/getCookie")
public class getCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取Cookie信息
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for (Cookie cookie:cookies){
                    String key = cookie.getName();
                    String value = cookie.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        //处理请求信息
        //响应处理结果

    }
}
