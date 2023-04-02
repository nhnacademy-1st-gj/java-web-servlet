<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="InsufficientBalance"/></title>
</head>
<body>
<fmt:message key="Transactionisdeclined"/><br/>
<fmt:message key="InsufficientBalance"/><br/>
<a href='foodListView.jsp'><fmt:message key="ToFoodList"/></a>
</fmt:bundle>
</body>
</html>
