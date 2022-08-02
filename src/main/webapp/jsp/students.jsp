<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoStudent" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Students" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<div class="my_list">
  <%
    DaoStudent daoStudent = new DaoStudent();
    List<Students> students = daoStudent.getAll();
    daoStudent.close();
    session.setAttribute("arrStudents", students);
  %>
  <h2 class="center_brown">Number of students: <%=students.size()%></h2>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>ID</th>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Email</th>
      <th>Grantholder</th>
      <th class="align-right">Update - Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${arrStudents}" var="el">
      <tr>
        <th>${el.ID}</th>
        <td>${el.firstName}</td>
        <td>${el.lastName} </td>
        <td>${el.email}</td>
        <td>${el.grantHolder}</td>
        <td class="align-right">
          <a href="jsp/students-update.jsp?ID=${el.ID}"
             class="btn btn-outline-success btn-sm">Update</a>
          <a href="jsp/students-delete.jsp?ID=${el.ID}"
             class="btn btn-outline-danger btn-sm">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
