<%@ page import="com.stefanini.onlinecatalog.dao.DaoProfessor" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Professors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update grade</title>
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

</body>
</html>
