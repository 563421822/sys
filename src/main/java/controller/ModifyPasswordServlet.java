package controller;

import lombok.SneakyThrows;
import service.ICommonService;
import service.impl.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String code = (String) req.getSession().getAttribute("code");
        String verify = req.getParameter("verify");
        System.out.println("生成的验证码:" + code + "输入的验证码:" + verify);

        if (code.equalsIgnoreCase(verify)) {
            ICommonService service = new CommonServiceImpl();
            int result = service.modifyPassword(name, oldPassword, newPassword);
            if (result > 0) {
                req.setAttribute("status", "修改成功!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                resp.getWriter().write("修改失败");
            }
        } else {
            resp.getWriter().write("验证码错误");
        }
    }
}
