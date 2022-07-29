<%@ page import="com.stefanini.onlinecatalog.dao.DaoSubject" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Subjects" %>
<%--
  Created by IntelliJ IDEA.
  User: vparasch
  Date: 7/28/2022
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoSubject daoSubject = new DaoSubject();
    String id = request.getParameter("ID");
    Subjects course = (Subjects) daoSubject.get(Integer.valueOf(id)).orElse(null);
%>
<h3 class="center_brown">Delete Course data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletCourses" method="post">
        <input name='id' type='hidden' value=<%=course.getID()%>>
        <input name='delete' type='hidden' value="true">
        <div class="form-group">
            <input class="form-control" name='name' type='text' value=<%=course.getName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='classroom' type='number' value=<%=course.getRoom()%>><br/>
        </div>
        <div><p class="center_brown">Are you sure you want to delete this Course ?</p></div>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='Delete' type='submit' value="Delete"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog/ServletCourses">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
