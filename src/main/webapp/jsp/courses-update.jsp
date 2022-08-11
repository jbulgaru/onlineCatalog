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
    <title>Update</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoSubject daoSubject = new DaoSubject();
    String id = request.getParameter("ID");
    Subjects course = (Subjects) daoSubject.get(Integer.valueOf(id)).orElse(null);
    System.out.println(course.getName());
%>
<h3 class="center_brown">Update Course data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletCourses" method="post">
        <input class="form-control" name='id' type='hidden' readonly value=<%=course.getID()%>><br/>
        <div class="form-group">
            <input class="form-control" name='name' type='text' required value="<%=course.getName()%>"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='classroom' type='number' required value=<%=course.getRoom()%>><br/>
        </div>
        <div>
            <input class="btn btn-outline-success btn-sm" type='submit' value="Update"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog/ServletCourses">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
