<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Example cars</title>
    </head>
    <body>
        <h1><%= request.getAttribute("message") %></h1>
        <ul>
            <c:forEach items="${cars}" var="car">
                <li>${car}</li>
            </c:forEach>
        </ul>
    </body>
</html>