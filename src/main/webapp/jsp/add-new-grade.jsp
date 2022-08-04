<%@ page import="com.stefanini.onlinecatalog.dao.DaoSubject" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Subjects" %>
<%@ page import="java.util.List" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoProfessor" %>
<%@ page import="com.stefanini.onlinecatalog.entity.ListProfessors" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Professors" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoStudent" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Students" %><%--
  Created by IntelliJ IDEA.
  User: ybulharu
  Date: 8/1/2022
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New grade</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<br/>
<h3 class="center_brown">Add New Grade</h3>
<%
    DaoSubject daoSubject = new DaoSubject();
    List<Subjects> courses = daoSubject.getAll();
    daoSubject.closeEntityManager();
    request.setAttribute("courses", courses);

    DaoProfessor daoProfessor = new DaoProfessor();
    List<Professors> professors = daoProfessor.getAll();
    daoProfessor.closeEntityManager();
    request.setAttribute("professors", professors);

    DaoStudent daoStudent = new DaoStudent();
    List<Students> students = daoStudent.getAll();
    daoStudent.close();
    request.setAttribute("students", students);
%>
<div class="mx-auto col-lg-3">
    <form action="/OnlineCatalog/ServletProf_Stud_Subj" method="post">
        <input class="form-control" name='newGrade' type='hidden' value="newGrade"><br/>

        <div class="form-floating mb-3">
            <select id="SubjectID" name="SubjectID" class="form-control mb-2">
                <c:forEach items="${courses}" var="course" varStatus="loop">
                    <option value="${course.ID}">
                            ${course.name}
                    </option>
                </c:forEach>
            </select>
            <label for="SubjectID">select Course</label>
        </div>
        <div class="form-floating mb-3">
            <select id="StudentID" name="StudentID" class="form-control mb-2">
                <c:forEach items="${students}" var="student" varStatus="loop">
                    <option value="${student.ID}">
                            ${student.getFullName()}
                    </option>
                </c:forEach>
            </select>
            <label for="StudentID">select Student</label>
        </div>
        <div class="form-floating mb-3">
            <select id="ProfessorID" name="ProfessorID" class="form-control mb-2">
                <c:forEach items="${professors}" var="professor" varStatus="loop">
                    <option value="${professor.ID}">
                            ${professor.getFullName()}
                    </option>
                </c:forEach>
            </select>
            <label for="ProfessorID">select Professor</label>
        </div>
        <div class="form-floating mb-3">
            <input id="grade" class="form-control" name='Grade' type='text' placeholder="Grade"/><br/>
            <label for="grade">finally ... GRADE :)</label>
        </div>
        <div>
            <input class="btn btn-outline-success" name='Submit' type='submit'/>
            <a class="btn btn-outline-primary float-right" href="/OnlineCatalog/ServletProf_Stud_Subj">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
