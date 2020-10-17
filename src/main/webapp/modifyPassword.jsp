<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="ModifyPasswordServlet" method="post">
    <table>
        <caption>${sessionScope.login.role}修改密码页面</caption>
        <tr>
            <td>原密码:</td>
            <td><input type="password" name="oldPassword"/></td>
            <td><input type="hidden" name="name" value="${sessionScope.login.name}"/></td>
        </tr>
        <tr>
            <td>新密码:</td>
            <td><input type="password" name="newPassword"/></td>
            <td></td>
        </tr>
        <tr>
            <td>确认新密码:</td>
            <td><input type="password" name="confirm"/></td>
            <td></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="verify"/></td>
            <td><img src="CodeServlet" alt="验证码加载失败"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</body>
</html>
