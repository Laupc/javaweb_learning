package servlet;

import pojo.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求中文乱码解决：
 *      1、使用String进行数据重新编码
 *          username = new String(username.getBytes("ISO8859-1"),"utf-8");
 *      2、使用公共配置
 *          GET方式：
 *              设置请求编码格式
 *              req.setCharacterEncoding("utf-8");
 *              修改tomcat配置文件
 *              <Connector port="8080" protocol="HTTP/1.1"
 *                         connectionTimeout="20000"
 *                         redirectPort="8443" useBodyEncodingForURI="true" />
 *          POST方式:
 *              设置请求编码格式
 *              req.setCharacterEncoding("utf-8");
 *
 * Servlet流程总结：
 *          浏览器发起请求到服务器
 *          服务器接收浏览器的请求，进行解析，创建request对象存储请求数据
 *          服务器调用对应的servlet进行处理，并将request对象作为实参传递给servlet方法
 *          servlet的方法进行请求处理
 *
 *         //设置请求编码格式
 *         //设置响应编码格式
 *         //获取请求信息
 *         //处理请求信息
 *               //创建业务层对象
 *               //调用业务层对象方法
 *         //响应处理结果
 *
 *  请求转发：
 *      作用：实现多个servlet联动操作请求，避免代码冗余，让servlet职责明确
 *      使用：
 *          req.getRequestDispatcher(path).forward(req,resp);
 *          path为相对路径，直接写servlet别名即可
 *      特点：
 *          一次请求，浏览器地址栏信息不变
 *   重定向：
 *      作用：解决了表单重复提交的问题，以及当前servlet无法处理请求的问题
 *      使用：
 *          resp.sendRedirect("/login_practice/main");
 *      特点：
 *          两次请求，浏览器地址栏信息改变
 *    若请求中有表单数据，且不能重复提交的请求， 使用重定向
 *   若请求被servlet接受后，无法处理，建议使用重定向
 *
 *
 */



@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
            req.setCharacterEncoding("utf-8");
        //设置响应编码格式
            resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            String username = req.getParameter("username");
            //转编码格式
            username = new String(username.getBytes("ISO8859-1"),"utf-8");
            String password = req.getParameter("password");
        //处理请求信息
            //获取业务层对象
            LoginService loginService = new LoginServiceImpl();
            User user = loginService.checkLoginService(username,password);
            //响应处理结果
            if (user != null){
                //创建Cookie实现三天免登陆
                Cookie cookie = new Cookie("user_id",user.getUser_id()+"");
                cookie.setMaxAge(3*24*3600);
                cookie.setPath("/login_practice/cookiecheck");
                resp.addCookie(cookie);
                //重定向
                resp.sendRedirect("/login_practice/main");
            }else {
                //请求转发
                req.setAttribute("msg","用户名或密码错误");
                req.getRequestDispatcher("page").forward(req,resp);
                return;
            }
    }
}
