package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletConfig对象
 *      获取web.xml中给每个serlvet单独配置的数据
 *      使用：
 *          使用ServletConfig对象
 *          获取web.xml中的配置数据
 */

public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        //获取web.xml中的配置数据
        String config = servletConfig.getInitParameter("config");
        System.out.println(config);
    }
}
