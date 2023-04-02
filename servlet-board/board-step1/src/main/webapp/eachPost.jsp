<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
    <head>
        <title><fmt:message key="PostList"/></title>
    </head>

    <body>
    <c:set var="post" value="${requestScope.post}"/>
    <table border="1">
        <tr>
            <td><fmt:message key="PostId"/></td>
            <td><fmt:message key="PostTitle"/></td>
            <td><fmt:message key="PostWriter"/></td>
            <td><fmt:message key="PostTime"/></td>
            <td><fmt:message key="PostViewCount"/></td>
        </tr>
        <tr>
            <td>${post.getId()}</td>
            <td>${post.getTitle()}</td>
            <td>${post.getWriterUserId()}</td>
            <td>${post.getWriteTime()}</td>
            <td>${post.getViewCount()}</td>
        </tr>
        <tr>
            <td><fmt:message key="PostContent"/></td>
            <td colspan="4">${post.getContent()}</td>
        </tr>
    </table>
    <form method="post" action="modifyPost.do">
        <input type="hidden" name="postId" value="${post.getId()}">
        <input type="submit" value="<fmt:message key="Remove"/>">
    </form>
    <form method="post" action="deletePost.do">
        <input type="hidden" name="postId" value="${post.getId()}">
        <input type="submit" value="<fmt:message key="Remove"/>">
    </form>
    </body>
</fmt:bundle>
</html>

<%--수정 삭제 수정은 cotroller에서 localdatetime 다시 set--%>
