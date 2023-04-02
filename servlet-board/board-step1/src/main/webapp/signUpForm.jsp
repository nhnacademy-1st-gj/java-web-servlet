<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
    <head>
        <title><fmt:message key="SignUpPage"/></title>
    </head>
    <body>
    <h1><fmt:message key="SignUpPage"/></h1>
    <c:if test="${requestScope.existsId != null}">
        ${requestScope.existsId} is already used by other user
    </c:if>
    <form method="post" action="/signUp.do">
        <fmt:message key="Id"/> <input type="text" name="id"/><br/>
        <fmt:message key="Password"/><input type="password" name="password"/><br/>
        <fmt:message key="Name"/><input type="text" name="name"/><br/>
        <input type="submit">
    </form>
    <a href="loginForm.jsp"><fmt:message key="LoginPage"/></a>

    </body>
</fmt:bundle>
</html>
