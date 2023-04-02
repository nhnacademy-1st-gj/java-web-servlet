<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="LoginPage"/></title>
</head>
<body>
<h1><fmt:message key="LoginPage"/></h1>
<form method="post" action="/login.do">
    <fmt:message key="id"/><input type="text" name="id"/><br/>
    <fmt:message key="password"/><input type="password" name="password"><br/>
    <input type="submit">
</form>
</fmt:bundle>
</body>
</html>
