<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="RegisterServlet" method="post" enctype="multipart/form-data">
    <table border="1">
        <caption>注册页面</caption>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="name" value="${sessionScope.login.name}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" value="${sessionScope.login.password}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="gender" value="male"
                       <c:if test="${sessionScope.login.gender eq 1}">checked="checked"</c:if>/>男
                <input type="radio" name="gender" value="female"
                       <c:if test="${sessionScope.login.gender eq 0}">checked="checked"</c:if>/>女
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>生日:</td>
            <td><input type="date" value="${sessionScope.login.birthday}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="email" name="email" value="${sessionScope.login.email}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>出生城市:</td>
            <td><select name="city">
                <optgroup label="请选择">
                    <option value="Tokyo" <c:if test="${sessionScope.login.city eq 'Tokyo'}">selected="selected"</c:if>>
                        东京
                    </option>
                    <option value="New York"
                            <c:if test="${sessionScope.login.city eq 'New York'}">selected="selected"</c:if>>纽约
                    </option>
                    <option value="Toronto"
                            <c:if test="${sessionScope.login.city eq 'Toronro'}">selected="selected"</c:if>>多伦多
                    </option>
                    <option value="London"
                            <c:if test="${sessionScope.login.city eq 'London'}">selected="selected"</c:if>>伦敦
                    </option>
                    <option value="Melbourne"
                            <c:if test="${sessionScope.login.city eq 'Melbourne'}">selected="selected"</c:if>>墨尔本
                    </option>
                </optgroup>
            </select></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td><input type="checkbox" name="hobby" value="typeCode"
                       <c:if test="${fn:contains(sessionScope.login.hobby,'typeCode')}">checked="checked"
            </c:if>/>敲代码<input type="checkbox" name="hobby"
                               value="writeBug"
                               <c:if test="${fn:contains(sessionScope.login.hobby,'writeBug')}">checked="checked"
            </c:if>/>写BUG<input
                    type="checkbox" name="hobby" value="debug"
                    <c:if test="${fn:contains(sessionScope.login.hobby,'debug')}">checked="checked"
            </c:if>/>debug<input type="checkbox" name="hobby" value="sleep"
                                 <c:if test="${fn:contains(sessionScope.login.hobby,'sleep')}">checked="checked"
            </c:if>/>睡觉<input
                    type="checkbox" name="hobby" value="playGame"
                    <c:if test="${fn:contains(sessionScope.login.hobby,'playGame')}">checked="checked"
            </c:if>/>玩游戏
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>身份:</td>
            <td><input type="radio" name="role"/>普通用户<input type="radio" name="role" disabled/>管理员</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>头像:</td>
            <td><input type="file" name=""/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="verify"/></td>
            <td><img src="CodeServlet" alt=""></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>

