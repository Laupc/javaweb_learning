package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/**
 *  request对象的学习：
 *      作用：request对象中封存了当前请求的所有请求信息
 *      使用：
 *           获取请求行数据
 *                  req.getMethod()
 *                  req.getRequestURL()
 *                  req.getRequestURI()
 *                  req.getScheme()
 *           获取请求头数据
 *                  req.getHeader("User-Agent")
 *                  req.getHeaderNames()
 *           获取用户数据
 *                  req.getParameter("username")      //getParameter不可以获取同键不同值的对象，比如多选框
 *                  req.getParameterValues("combox")  //数组类型，遍历时注意空指针异常
 *
 *
 *      注意：
 *           request对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。
 */
@WebServlet(name = "RequestServlet",urlPatterns = "/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求行数据
            //获取请求方式
            System.out.println(req.getMethod());
            //获取请求URL/URI
            System.out.println(req.getRequestURL());
            System.out.println(req.getRequestURI());
            //获取请求协议
            System.out.println(req.getScheme());
            System.out.println("---------------------------------------");
        //获取请求头数据
            //获取指定的请求头信息
            System.out.println(req.getHeader("User-Agent"));
            //获取所有请求头信息
            Enumeration enumeration = req.getHeaderNames();
            while (enumeration.hasMoreElements()){
                String name = (String) enumeration.nextElement();
                System.out.println(name + ":" + req.getHeader(name));
            }
            //获取用户数据
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username + ":" + password);
            //获取所有用户请求数据键的枚举集合,使用方法类似   获取所有的请求头信息
            Enumeration enumeration1 = req.getParameterNames();
    }
}
