
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
    <head>
        <h1><fmt:message key="WritePost"/></h1>
    </head>
    <body>
    <c:set var="id" value="${sessionScope.id}"/>
    <form method="post" action="/writePost.do">
        <fmt:message key="Title"/> <input type="text" name="title"><br/>
        <fmt:message key="Content"/><textarea name="content" rows="7" cols="40"></textarea><br/>
        <input type="hidden" name="userId" value="${id}">
        <input type="submit">
    </form>

    </body>
</fmt:bundle>
</html>
