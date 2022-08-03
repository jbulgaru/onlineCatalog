<%--
  Created by IntelliJ IDEA.
  User: ybulharu
  Date: 8/2/2022
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download GrantHolders</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>

<h3 class="center_brown">Downloading file...</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog-1.0-SNAPSHOT/ServletStudentSaveGrantHoldersToXML" method="post">
        <input name='save' type='hidden' value=<%=request.getParameter("save")%>>
<%--        <input name='saveGenius' type='hidden' value=${requestScope.get("ID")}>--%>

        <div><p class="center_brown h2">Are you sure you want to download this file ?</p></div>
        <div>
            <br>
            <br>
            <input class="btn btn-outline-danger btn-lg" name='saveXML' type='submit' value="Save"/>
            <a class="btn btn-outline-primary btn-lg float-right" href="/OnlineCatalog-1.0-SNAPSHOT/ServletStudentSaveGrantHoldersToXML">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
