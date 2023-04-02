<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
<head>
    <title><fmt:message key="MyCart"/></title>
</head>
<body>

<h2><fmt:message key="MyCart"/></h2>
<a href='foodListView.jsp'><fmt:message key="ToFoodList"/></a> <br/><br/>

<form action="pay.do" method="post">
    <c:forEach items="${sessionScope.cart.getItems()}" var="item">
        <input type="checkbox" name="itemQty" value="${item.getQuantity()}">
        <input type="hidden" name="itemName" value="${item.getName()}"/>
        <fmt:message key="Name"/>: ${item.getName()} |
        <fmt:message key="Won"/>: ${item.getPrice()} | <fmt:message key="Quantity"/>: ${item.getQuantity()}<br/>
    </c:forEach>
    <input type="submit">
</form>
</fmt:bundle>

</body>
</html>
