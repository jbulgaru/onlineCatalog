<%@ page import="com.stefanini.onlinecatalog.dao.DaoProfessor" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Professors" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Prof_Stud_Subj" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update grade</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<%
    DaoProf_Stud_Subj daoProfStudSubj = new DaoProf_Stud_Subj();
    String id = request.getParameter("ID");
    Prof_Stud_Subj profStudSubj = daoProfStudSubj.find(Integer.valueOf(id));
    System.out.println(profStudSubj);

%>
<h3 class="center_brown">Update Professor data</h3>
<br/>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletProf_Stud_Subj" method="post">
        <input name='update' type='hidden' value=<%=profStudSubj.getID()%>>
        <input name='ID' type='hidden' value=<%=profStudSubj.getID()%>>
        <div class="form-group">
            <input class="form-control" name='SubjectID' type='text' value=<%=profStudSubj.getSubjectID().getID()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='StudentID' type='text' value=<%=profStudSubj.getStudentID().getID()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='ProfessorID' type='text' value=<%=profStudSubj.getProfessorID().getID()%>><br/>
        </div>
        <div class="form-group">
            <input class="form-control" name='Grade' type='text' value=<%=profStudSubj.getGrade()%>><br/>
        </div>
        <div><p class="center_brown">Are you sure you want to update this record ?</p></div>
        <div>
            <input class="btn btn-outline-danger btn-sm" name='Update' type='submit' value="Update"/>
            <a class="btn btn-outline-primary btn-sm float-right" href="/OnlineCatalog/ServletProf_Stud_Subj">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
