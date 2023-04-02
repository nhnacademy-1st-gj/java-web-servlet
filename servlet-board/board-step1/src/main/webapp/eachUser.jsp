<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
    <head>
        <title><fmt:message key="EditUserProfile"/></title>
    </head>
    <body>

    <h3><fmt:message key="EditUserProfile"/></h3>
    <c:set var="user" value="${requestScope.user}"/>

    <form method="post" action="/modifyUser.do">
        <input type="hidden" name="userId" value="${user.getId()}">
        <fmt:message key="Id"/><input type="text" name="userName" placeholder="${user.getId()}" disabled><br/>
        <fmt:message key="Name"/><input type="text" name="userName" placeholder="${user.getName()}"><br/>
        <input type="submit" value="<fmt:message key="Submit"/>">
    </form>
    <form method="post" action="deleteUser.do">
        <input type="hidden" name="userId" value="${user.getId()}">
        <input type="submit" value="<fmt:message key="Remove"/>">
        <br/><br/>
    </form>

    </body>
</fmt:bundle>
</html>


