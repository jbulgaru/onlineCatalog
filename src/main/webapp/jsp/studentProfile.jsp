<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoStudent" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Students" %>
<%@ page import="java.util.List" %>
<%@ page import="com.stefanini.onlinecatalog.entity.Prof_Stud_Subj" %>
<%@ page import="com.stefanini.onlinecatalog.dao.DaoProf_Stud_Subj" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student profile</title>
</head>
<jsp:include page="/jsp/navbar.jsp"/>
<body>
<div class="my_list">
        <%
DaoStudent daoStudent = new DaoStudent();
Students student = daoStudent.find(Integer.valueOf(request.getParameter("studentId")));
List<Prof_Stud_Subj> subjList = new DaoProf_Stud_Subj().findAllCoursesByStudentId(student.getID());
session.setAttribute("listCurses", subjList);
  %>
            <section style="background-color: #eee;">
                <div class="container py-5">


                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card mb-4">
                                <div class="card-body text-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                                         class="rounded-circle img-fluid" style="width: 150px;">
                                    <h5 class="my-3"><%=student.getFirstName() + " " +student.getLastName() %></h5>
                                    <p class="text-muted mb-1">Student</p>
                                    <div class="d-flex justify-content-center mb-2">
                                        <a href="students-update.jsp?ID=<%=student.getID()%>"
                                           class="btn btn-outline-success btn-sm">Update</a>
                                        <a href="students-delete.jsp?ID=<%=student.getID()%>"
                                           class="btn btn-outline-danger btn-sm">Delete</a>
                                    </div>
                                </div>
                            </div>
                            <div class="card mb-4 mb-lg-0">
                                <div class="card-body p-0">
                                    <ul class="list-group list-group-flush rounded-3">
                                        <p  class="center_brown">Number of subjects: <%=subjList.size()%></p>
                                        <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                            <i class="fas fa-globe fa-lg text-warning">Subject</i>
                                            <p class="mb-0">Classroom</p>
                                        </li>
                                        <c:forEach items="${listCurses}" var="el">
                                            <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                                <i class="fas fa-globe fa-lg text-warning">${el.subjectID.name.toString()}</i>
                                                <p class="mb-0">${el.subjectID.room.toString()}</p>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Full Name</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0"><%=student.getFirstName() +" "+ student.getLastName()%></p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Email</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0"><%=student.getEmail()%></p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Phone</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">xxx xxx xx</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Mobile</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">xxx xxx xx</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Address</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">Macedonia, Greece</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="card mb-4 mb-md-0">
                                        <div class="card-body">
                                            <p class="mb-4"><span class="text-primary font-italic me-1"><%=student.getFirstName()%> professors </span> list
                                            </p>
                                            <ul class="list-group list-group-flush rounded-3">
                                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                                    <i class="fas fa-globe fa-lg text-warning">Professor name</i>
                                                    <p class="mb-0">Lastname</p>
                                                </li>
                                                <c:forEach items="${listCurses}" var="el">
                                                    <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                                        <i class="fas fa-globe fa-lg text-warning">${el.professorID.firstName.toString()}</i>
                                                        <p class="mb-0">${el.professorID.lastName.toString()}</p>
                                                    </li>
                                                </c:forEach>
                                            </ul>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                <div class="card mb-4 mb-md-0">
                                    <div class="card-body">
                                        <p class="mb-4"><span class="text-primary font-italic me-1"><%=student.getFirstName()%> grades </span> list
                                        </p>
                                        <ul class="list-group list-group-flush rounded-3">
                                            <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                                <i class="fas fa-globe fa-lg text-warning">Subject</i>
                                                <p class="mb-0">Grade</p>
                                            </li>
                                            <c:forEach items="${listCurses}" var="el">
                                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                                    <i class="fas fa-globe fa-lg text-warning">${el.subjectID.name}</i>
                                                    <p class="mb-0">${el.grade}</p>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
</body>
</html>
