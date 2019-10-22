package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext对象
 *      解决不同用户使用相同数据的问题
 *      特点：
 *          服务器创建，用户共享
 *      作用域：
 *          整个项目
 *      声明周期：
 *          服务器启动到服务器关闭
 *      使用：
 *          获取ServletContext对象
 *             第一种方式(常用)
 *             ServletContext servletContext1 = this.getServletContext();
 *             第二种方式
 *             ServletContext servletContext2 = this.getServletConfig().getServletContext();
 *             第三种方式(常用)
 *             ServletContext servletContext3 = req.getSession().getServletContext();
 *         使用ServletContext对象完成数据共享
 *             数据存储
 *             servletContext1.setAttribute(String key,Object value);
 *             数据获取
 *             servletContext.getAttribute(String key);
 *        获取项目web.xml文件全局配置数据
 *              作用：将静态数据和代码解耦
 *                  <context-param>
 *                      <param-name>name</param-name>
 *                      <param-value>zhangsan</param-value>
 *                  </context-param>
 *
 *             根据键的名字返回web.xml中配置的全局数据的值返回String类型
 *                  servletContext.getInitParameter("name");
 *        获取项目WEB-INF下的资源绝对路径
 *             动态获取项目的根目录，参数为项目根目录中的文件夹
 *             String path = servletContext.getPath(String path);
 *        获取项目WEB-INF下的资源的流对象
 *             此方式只能获取项目根目录下的资源流对象
 *             InputStream is = servletContext.getResourceAsStream(String path);
 *
 */

@WebServlet(name = "ServletContextServlet1",urlPatterns = "/servletcontext1")
public class ServletContextServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取ServletContext对象
            //第一种方式(常用)
            ServletContext servletContext1 = this.getServletContext();
            //第二种方式
            ServletContext servletContext2 = this.getServletConfig().getServletContext();
            //第三种方式(常用)
            ServletContext servletContext3 = req.getSession().getServletContext();
        //使用ServletContext对象完成数据共享
            //数据存储
            servletContext1.setAttribute("str","ServletContext对象学习");

    }
}
