<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${requestScope.status eq '修改成功!'}">
    <script type="text/javascript">
        alert("${requestScope.status}");
    </script>
</c:if>
<c:choose>
    <c:when test="${sessionScope.login.role eq 'admin'}">
        <h1>管理员首页</h1>
        <h2><a href="modifyPassword.jsp">修改密码</a></h2>
        <h2><a href="information.jsp"></a>修改账户信息</h2>
        <h2><a href="ManageUser"></a>管理用户</h2>
        <h3><a href="ExitServlet"></a>注销</h3>
    </c:when>
    <c:otherwise>
        <h1>普通用户首页</h1>
        <h2><a href="modifyPassword.jsp">修改密码</a></h2>
        <h2><a href="information.jsp"></a>修改账户信息</h2>
        <h3><a href="ExitServletServlet">注销</a></h3>
    </c:otherwise>
</c:choose>
<img src="${sessionScope.login.avatar}" alt=""/>
<jsp:getProperty name="" property=""/>
</body>
</html>
<jsp:useBean id=""></jsp:useBean>