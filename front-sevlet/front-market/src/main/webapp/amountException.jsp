<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="AmountException"/></title>
</head>
<body>
<fmt:message key="OutofStock"/>
<br/>
<a href='foodListView.jsp'><fmt:message key="ToFoodList"/></a> <br/><br/>
</fmt:bundle>
</body>
</html>
