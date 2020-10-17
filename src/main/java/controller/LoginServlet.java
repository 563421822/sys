package controller;

import entity.Entity;
import lombok.SneakyThrows;
import service.ICommonService;
import service.impl.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String remember = req.getParameter("remember");

//        获得用户输入的验证码的值
        String verify = req.getParameter("verify");
//        获得session中的验证码的值
        String code = (String) req.getSession().getAttribute("code");
        if (code.equalsIgnoreCase(verify)) {//验证码输入正确
            ICommonService service = new CommonServiceImpl();
//            返回实体类对象
            Entity entity = service.login(name, password, role);
            if (entity != null) {//登录成功
                if ("on".equals(remember)) {//勾选了记住我
                    Cookie n = new Cookie("name", name);
                    Cookie p = new Cookie("password", password);
                    resp.addCookie(n);
                    resp.addCookie(p);
                }
                req.getSession().setAttribute("login", "");
                resp.sendRedirect("index.jsp");
            } else {
                resp.getWriter().write("登录失败");
            }
        } else {
            resp.getWriter().write("验证码输入错误");
        }
    }
}