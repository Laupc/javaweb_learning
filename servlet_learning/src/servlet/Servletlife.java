package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="Servletlife", urlPatterns = "/life")
public class Servletlife extends HttpServlet {
    /**
     *  从第一次调用servlet开始，servlet加载进内存，servlet就会初始化
     *  在服务器没有停止之前，再次调用都不会调用init
     *
     *  若在xml中配置了load-on-starup，启动服务器就会初始化servlet
     */
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet init......");
    }

    /**
     * service()：
     *      处理get/post方式的请求，如果servlet中有service方法，会优先调用
     * doGet()：
     *      处理get方式的请求
     * doPost()：
     *      处理post方式的请求
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello Servlet");
        System.out.println("this is life of servlet");
    }

    /**
     * Servlet初始化完毕后，关闭服务器就会销毁Servlet，也只有在关闭的时候才会调用destroy
     */
    @Override
    public void destroy() {
        System.out.println("Servlet destroy......");
    }
}
