<%@ page import="com.stefanini.onlinecatalog.entity.Professors" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoProfessor" %>
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
    DaoProfessor daoProfessor = new DaoProfessor();
    String id = request.getParameter("ID");
    Professors p = (Professors) daoProfessor.get(Integer.valueOf(id)).orElse(null);
%>
<h3 class="center_brown">Delete Professor data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletProfessors" method="post">
        <input name='id' type='hidden' value=<%=p.getID()%>>
        <input name='delete' type='hidden' value="true">
        <div class="form-group">
            <input class="form-control" name='firstName' type='text' value=<%=p.getFirstName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='lastName' type='text' value=<%=p.getLastName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='email' type='email' value=<%=p.getEmail()%>><br/>
        </div>
        <div><p class="center_brown">Are you sure you want to delete this record ?</p></div>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='Delete' type='submit' value="Delete"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog/ServletProfessors">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
