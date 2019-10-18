package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie:
 *      作用：解决了发送了不同请求的数据共享问题
 *      使用:
 *          //创建Cookie对象
 *              Cookie cookie = new Cookie("mouse","thinkpad");
 *              //设置Cookie(可选)
 *                  //设置有效期
 *                  cookie.setMaxAge(int seconds) //设置有效期，保存在硬盘
 *                  //设置有效路径
 *                  cookie.setPath(path)    //只有该path才会带有该cookie信息
 *              //响应Cookie信息给客户端
 *              resp.addCookie(cookie);
 *          //获取Cookie对象
 *
 *
 *       注：一个Cookie对象只能存储一条数据
 *          需要多个Cookie则需要多个Cookie对象
 *       特点：
 *          1、浏览器端的数据存储技术
 *          2、存储的数据在服务器端声明
 *          3、临时存储：存储在浏览器的运行内存中，浏览器关闭，Cookie也会失效
 *          4、定时存储：设置了Cookie的有效期，存储在了客户端的硬盘中，
 *                      在有效期内符合该要求的请求都会附带该Cookie
 *          5、默认Cookie信息附带给任何接下来的请求
 */

@WebServlet(name = "CookieServlet",urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //处理请求信息
        //响应处理结果
            //使用Cookie进行浏览器端的数据存储
                //创建Cookie对象
                Cookie cookie1 = new Cookie("mouse","thinkpad");
                Cookie cookie2 = new Cookie("key","dell");
                //设置Cookie
                    //设置Cookie的有效期
                    cookie2.setMaxAge(3*24*3600);
                    cookie2.setPath("/cookie/getCookie");
                //响应Cookie信息
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                resp.getWriter().write("Cookie学习");
    }
}
