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
    <button onclick="location.href='writePost.jsp'"><fmt:message key="WritePost"/></button>
    <br/><br/>

    <c:set var="postRepository" value="${applicationScope.postRepository}"/>
    <c:set var="postList" value="${postRepository.getPosts()}"/>
    <table border="1">
        <tr>
            <td><fmt:message key="PostId"/></td>
            <td><fmt:message key="PostTitle"/></td>
            <td><fmt:message key="PostWriter"/></td>
            <td><fmt:message key="PostTime"/></td>
        </tr>
        <c:forEach items="${postList}" var="post">
            <tr>
                <td>${post.getId()}</td>
                <td><a href="/eachPost.do?postId=${post.getId()}"/>${post.getTitle()}</td>
                <td>${post.getWriterUserId()}</td>
                <td>${post.getWriteTime()}</td>
            </tr>
        </c:forEach>
    </table>
    </body>
</fmt:bundle>
</html>
