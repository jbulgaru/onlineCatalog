<%@ page import="com.stefanini.onlinecatalog.entity.Students" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoStudent" %><%--
  Created by IntelliJ IDEA.
  User: ybulharu
  Date: 8/2/2022
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoStudent daoStudent = new DaoStudent();
    String id = request.getParameter("ID");
    Students student = daoStudent.find(Integer.valueOf(id));
    System.out.println(student);

%>
<h3 class="center_brown">Update Professor data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletStudents" method="post">
        <input name='delete' type='hidden' value=<%=student.getID()%>>

        <div class="form-group">
            <input class="form-control" name='FirstName' type='text' value=<%=student.getFirstName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='LastName' type='text' value=<%=student.getLastName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='Email' type='email' value=<%=student.getEmail()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='GrantHolder' type='text' value=<%=student.getGrantHolder()%>><br/>
        </div>
        <div><p class="center_brown h4">Are you sure you want to delete this record ?<br>

        </p></div>
        <br>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='Update' type='submit' value="Delete"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog/ServletStudents">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
