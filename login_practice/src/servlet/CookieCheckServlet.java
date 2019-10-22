package servlet;

import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Cookie信息校验
 *      判断请求中是否携带正确的Cookie信息
 *      如果存在，判断Cookie信息是否正确
 *              如果判断正确，直接响应主页面给用户
 *              如果判断错误，响应登录页面给用户
 *      如果不存在，请求转发给登录页面
 */
@WebServlet(name = "CookieCheckServlet",urlPatterns = "/cookiecheck")
public class CookieCheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        Cookie[] cookies = req.getCookies();
        //处理请求信息
        if (cookies != null){
            //遍历Cookie信息
            String user_id = "";
            for (Cookie cookie:cookies){
                if ("user_id".equals(cookie.getName())){
                    user_id = cookie.getValue();
                }
            }
            //校验user_id是否存在
            if ("".equals(user_id)){
                req.getRequestDispatcher("page").forward(req,resp);
                return;
            }else {
                LoginService loginService = new LoginServiceImpl();
                User user =  loginService.checkUseridService(user_id);
                if (user != null){
                    //将用户数据存储到session中
                    req.getSession().setAttribute("user",user);
                    //创建网页计数器
                    ServletContext servletContext = this.getServletContext();
                    if (servletContext.getAttribute("num") !=null){
                        int num = (int) servletContext.getAttribute("num");
                        num+=1;
                        servletContext.setAttribute("num",num);
                    }else {
                        servletContext.setAttribute("num",1);
                    }
                    resp.sendRedirect("/login_practice/main");
                    return;
                }else{
                    req.getRequestDispatcher("page").forward(req,resp);
                    return;
                }
            }
        }else{
            //响应处理结果
            req.getRequestDispatcher("page").forward(req,resp);
        }
        //响应处理结果
            //直接响应
            //请求转发
            //重定向
    }
}
