package controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int width = 120;
        int height = 40;
        int codeCount = 4;
        int lineCount = 10;
        ValidateCode code = new ValidateCode(width, height, codeCount, lineCount);
        //否则根本不是来自ajax
        //        每次获得新的验证码
//        每次都将新的code值存在session中
        req.getSession().setAttribute("code", code.getCode());
//        将图片以流的方式写出,内存图片
        code.write(resp.getOutputStream());
    }
}