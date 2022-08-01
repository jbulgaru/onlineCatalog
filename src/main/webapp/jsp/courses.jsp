<%--
  Created by IntelliJ IDEA.
  User: vparasch
  Date: 7/28/2022
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<jsp:useBean id="listCourses" class="com.stefanini.onlinecatalog.entity.ListCourses" scope="request"/>

<div class="my_list">
    <h2 class="center_brown">Courses List: <%=listCourses.getSize()%> items</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Classroom</th>
            <th class="align-right">Update-Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCourses.getCoursesList()}" var="element">
            <tr>
                <th>${element.ID}</th>
                <td>${element.name}</td>
                <td>${element.room}</td>
                <td class="align-right">
                    <a href="jsp/courses-update.jsp?ID=${element.ID}"
                       class="btn btn-outline-success btn-sm">Update</a>
                    <a href="jsp/courses-delete.jsp?ID=${element.ID}"
                       class="btn btn-outline-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
