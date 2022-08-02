<%@ page import="com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Prof_Stud_Subj" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete grade</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
    String id = request.getParameter("ID");
    Prof_Stud_Subj grade = daoProf_stud_subj.find(Integer.valueOf(id));
    daoProf_stud_subj.close();
%>
<h3 class="center_brown">Delete grade for student</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog-1.0-SNAPSHOT/ServletProf_Stud_Subj" method="post">
        <input name='delete' type='hidden' value=<%=grade.getID()%>>
        <div class="form-group">
            <input class="form-control" name='SubjectID' type='text' value=<%=grade.getSubjectID().getName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='StudentID' type='text' value=<%=grade.getStudentID().getFirstName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='ProfessorsID' type='text' value=<%=grade.getProfessorID().getFirstName()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='Grade' type='text' value=<%=grade.getGrade()%>><br/>
        </div>
        <div><p class="center_brown">Are you sure you want to delete this record ?</p></div>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='Delete' type='submit' value="Delete"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog-1.0-SNAPSHOT/ServletProf_Stud_Subj">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
