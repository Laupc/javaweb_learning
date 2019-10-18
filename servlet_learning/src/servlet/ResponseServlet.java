package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *  Response对象：
 *      作用：
 *          响应数据到浏览器的一个对象
 *      使用：
 *          设置响应行
 *          设置响应头
 *              setHeader(String name,String value)  //在响应头中设置响应信息，同键会覆盖
 *              addHeader(String name,String value)  //在响应头中添加响应信息，同键不会覆盖
 *          设置响应状态
 *              sendError(int num,Strng msg)
 *          设置响应编码
 *              resp.setHeader("content-type","text/html;charset=utf-8");
 *              或
 *              resp.setContentType("text/html;charset=utf-8");
 *          设置响应实体
 *              resp.getWrite().write(String str)
 *
 *
 *  service请求处理代码流程：
 *        1、设置响应编码格式
 *        2、获取请求数据
 *        3、处理请求数据
 *        4、响应处理结果
 */
@WebServlet(name = "ResponseServlet",urlPatterns = "/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
            //获取请求行
            //获取请求头
            //获取用户数据
        //处理请求

        //响应处理结果
            //设置响应头
            resp.setHeader("mouse","dell");
            resp.setHeader("mouse","benq");
            resp.addHeader("keywords","logitic");
            resp.addHeader("keywords","thikdpad");
            //设置响应编码格式
            resp.setHeader("content-type","text/html;charset=utf-8");
            resp.setContentType("text/html;charset=utf-8");
            //设置响应状态码
            //resp.sendError(404,"Not Found");
            //设置响应实体
            resp.getWriter().write("<h1>这是响应实体</h1>");
    }
}
