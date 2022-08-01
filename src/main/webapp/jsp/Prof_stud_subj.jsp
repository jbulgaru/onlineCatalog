<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.stefanini.onlinecatalog.entity.ListCourses" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Prof_Stud_Subj" %>
<%@ page import="java.util.List" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registru</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<div class="my_list">
    <%
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();
        List<Prof_Stud_Subj> prof_stud_subjList = daoProf_stud_subj.getAll();
        daoProf_stud_subj.close();
        session.setAttribute("arr", prof_stud_subjList);

    %>


    <h2 class="center_brown">List: <%=prof_stud_subjList.size()%> grades</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>  Subject</th>
            <th>Student</th>
            <th>Professor</th>
            <th>Grade</th>
            <th class="align-right">Update  Delete</th>
        </tr>
        <tr>
            <th></th>
            <th>ID   Name</th>
            <th>ID   Firstname  Lastname</th>
            <th>ID   Firstname  Lastname</th>
            <th></th>
            <th class="align-right"></th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${arr}" var="element">
            <tr>
                <th>${element.ID}</th>
                <td>${element.subjectID.ID}:      ${element.subjectID.name}:  </td>
                <td>${element.subjectID.ID}:      ${element.studentID.firstName}:      ${element.studentID.lastName}</td>
                <td>${element.professorID.ID}:    ${element.professorID.firstName}:    ${element.professorID.lastName}</td>
                <td>${element.grade}</td>
                <td class="align-right">
                    <a href="jsp/grade-update.jsp?ID=${element.ID}"
                       class="btn btn-outline-success btn-sm">Update</a>
                    <a href="jsp/grade-delete.jsp?ID=${element.ID}"
                       class="btn btn-outline-danger btn-sm">Delete</a>
                </td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
