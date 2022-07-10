<%--
  Created by IntelliJ IDEA.
  User: anselme
  Date: 2022-07-10
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <%@ include file="../components/layout/page-header.jsp" %>
</head>
<body>
<%@ include file="../components/atoms/navbar.jsp" %>
<div class="container pt-5">
    <div class="row row-cols-3">
        <div>
            <div class="card p-5 bg-warning text-white" style="min-height: 150px">
                <h1>Students [${totalStudents}]</h1>
            </div>
        </div>
        <div>
            <div class="card p-5 bg-primary text-white" style="min-height: 150px">
               <h2>Courses [${totalCourses}]</h2>
            </div>
        </div>
    </div>
</div>
</body>
</html>
