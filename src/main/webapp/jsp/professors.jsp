<%--
  Created by IntelliJ IDEA.
  User: vparasch
  Date: 7/28/2022
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Professors" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Professors</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<jsp:useBean id="listProfessors" class="com.stefanini.onlinecatalog.entity.ListProfessors" scope="request"/>

<h2 class="center_brown">Professors List: <%=listProfessors.getSize()%> items</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProfessors.getProfessorsList()}" var="element">
        <tr>
            <th>${element.ID}</th>
            <td>${element.firstName}</td>
            <td>${element.lastName}</td>
            <td>${element.email}</td>
            <td>
                <a href="/OnlineCatalog/professors-edit-delete">EDIT</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
