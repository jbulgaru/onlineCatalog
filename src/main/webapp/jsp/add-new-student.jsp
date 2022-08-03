<%@ page import="com.stefanini.onlinecatalog.dao.DaoStudent" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Students" %><%--
  Created by IntelliJ IDEA.
  User: ybulharu
  Date: 8/2/2022
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<h3 class="center_brown">Add new student</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog-1.0-SNAPSHOT/ServletStudents" method="post">
        <input name='newStudent' type='hidden'>
        <div class="form-group">
            <input class="form-control" name='FirstName' type='text'  placeholder="FirstName"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='LastName' type='text' placeholder="LastName"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='Email' type='email' placeholder="Email"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='GrantHolder' type='text' placeholder="GrantHolder"><br/>
        </div>
        <div><p class="center_brown">Are you sure you want to update this record ?</p></div>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='add' type='submit' value="Add"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog-1.0-SNAPSHOT/ServletStudents">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
