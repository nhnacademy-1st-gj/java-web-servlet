<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="FoodList"/></title>
</head>
<body>
<a href='cartView.jsp'><fmt:message key="ToCart"/></a> <br/>

<c:forEach items="${applicationScope.foodList}" var="food">
    <form action="cart.do" method="POST">
        <fmt:message key="Name"/>: ${food.getName()} | <fmt:message key="Won"/>: ${food.getPrice()} | <fmt:message
            key="Quantity"/>: ${food.getQuantity()}<br/>
        <input type="number" name="quantity">
        <input type="hidden" name="food" value="${food.getName()}"/>
        <input type="submit" value="submit">
    </form>
    <br/>
</c:forEach>
</fmt:bundle>
</body>
</html>
