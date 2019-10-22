package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session技术学习：
 *      解决一个用户不同请求处理的数据共享问题
 *      原理：
 *          用户第一次访问服务器，服务器会创建一个session对象给此用户，
 *          并将该session对象的JSESSIONID使用cookie存储到浏览器中，
 *          保证用户其他请求能够获取到同一个session对象以及不同请求的数据共享
 *      特点：
 *          1、服务器端的数据存储技术
 *          2、由服务器创建
 *          3、依赖Cookie技术
 *          4、有效期：一次会话
 *          5、默认存储时间30分钟
 *      使用：
 *          1、创建/获取session对象
 *              HttpSession session = req.getSession();
 *              如果请求中有JSESSIONID则直接返回该session对象，
 *              如果没有则创建新的session对象，并将JSESSIONID用cookie存储到浏览器内存中。
 *              如果session对象失效了，也会重新创建一个session对象，将JSESSIONID用cookie存储到浏览器内存中。
 *          2、设置session存储时间
 *              session.setMaxInactiveInterval(1800);
 *              指定的时间内，session未被使用就会被销毁，否则会重新计时。
 *          3、设置session强制失效
 *              session.invalidate();
 *          4、数据的存储与获取
 *              存储：session.setAttribute(String name,Object value);
 *              获取：session.getAttribute(String name,Object value); 返回Object类型
 *      使用场景：
 *          用户登录系统后，将用户个人信息存储到session中供其他请求使用。
 *      注：
 *          JSESSIONID存储在了Cookie的临时存储空间中，浏览器关闭即失效
 *
 */

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = "张三";
        //处理请求信息
            //创建session对象(即是创建，又是获取)
            HttpSession session = req.getSession();
            //设置session的存储时间
            //session.setMaxInactiveInterval(60);
            //设置session强制失效
            //session.invalidate();
            //存储数据
            session.setAttribute("name",name);
        //响应处理结果
    }
}
