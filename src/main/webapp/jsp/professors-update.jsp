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
    <title>Update</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoProfessor daoProfessor = new DaoProfessor();
    String id = request.getParameter("ID");
    Professors p = (Professors) daoProfessor.get(Integer.valueOf(id)).orElse(null);
%>
<h3 class="center_brown">Update Professor data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog-1.0-SNAPSHOT/ServletProfessors" method="post">
        <input class="form-control" name='id' type='hidden' value=<%=p.getID()%>><br/>
        <div class="form-group">
            <input class="form-control" name='firstName' type='text' value="<%=p.getFirstName()%>"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='lastName' type='text' value="<%=p.getLastName()%>"><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='email' type='email' value="<%=p.getEmail()%>"><br/>
        </div>
        <div>
            <input class="btn btn-outline-success btn-sm" type='submit' value="Update"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog-1.0-SNAPSHOT/ServletProfessors">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
