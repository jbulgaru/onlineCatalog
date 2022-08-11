
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download GrantHolders</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>

<h3 class="center_brown">Sending file...</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletStudentSaveGrantHoldersToXML" method="post">
        <input name='save' type='hidden' value=<%=request.getParameter("save")%>>
        <div><p class="center_brown h2">Are you sure you want to send this file ?</p></div>
        <div>
            <br>
            <br>
            <input class="btn btn-outline-danger btn-lg" name='saveXML' type='submit' value="Save"/>
            <a class="btn btn-outline-primary btn-lg float-right" href="/OnlineCatalog/ServletStudentSaveGrantHoldersToXML">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
