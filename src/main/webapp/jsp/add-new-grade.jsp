<%--
  Created by IntelliJ IDEA.
  User: ybulharu
  Date: 8/1/2022
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New grade</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<h3 class="center_brown">Add New Grade</h3>
<br/>

<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog-1.0-SNAPSHOT/ServletProf_Stud_Subj" method="post">
        <input class="form-control" name='newGrade' type='hidden' value="newGrade"><br/>
        <div class="form-group">
            <input class="form-control" name='SubjectID' type='text' placeholder="Subject ID"/><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='StudentID' type='text' placeholder="Student ID"/><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='ProfessorID' type='text' placeholder="Professor ID"/><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='Grade' type='text' placeholder="Grade"/><br/>
        </div>
        <div>
            <input class="btn btn-outline-success btn-sm" name='Submit' type='submit'/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog-1.0-SNAPSHOT/ServletProf_Stud_Subj">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
