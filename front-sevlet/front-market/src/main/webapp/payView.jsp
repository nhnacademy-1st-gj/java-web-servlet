<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="Payment"/></title>
</head>
<body>
<fmt:message key="PaymentBalance"/>: <c:out value="${sessionScope.cartBalance}"/><br/>
<fmt:message key="RemainingBalance"/>: <c:out value="${sessionScope.remainingBalance}"/><br/>
</fmt:bundle>

</body>
</html>
