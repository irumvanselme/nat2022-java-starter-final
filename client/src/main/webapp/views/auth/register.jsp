<%--
  Created by IntelliJ IDEA.
  User: anselme
  Date: 2022-07-10
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register - SMS</title>
    <%@ include file="../components/layout/page-header.jsp" %>
</head>
<body>
<%@ include file="../components/atoms/navbar.jsp" %>

<div class="container mt-5" style="width: 100%;max-width: 700px">
    <h1 class="text-primary fw-bold">Hello. Create an Account Here</h1>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>

    <div class="mt-5">
        <form action="/auth/register" method="post">
            <div class="form-group mt-3">
                <label for="fullNames">Full name</label>
                <input type="text" class="form-control" id="fullNames" name="fullNames"
                       placeholder="Enter the Full Names">
            </div>
            <div class="form-group mt-3">
                <label for="nationalId">National ID</label>
                <input type="text" class="form-control" id="nationalId" name="nationalId"
                       placeholder="Enter the National ID">
            </div>
            <div class="form-group mt-3">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                       placeholder="Enter the Phone Number">
            </div>
            <div class="form-group mt-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
            </div>
            <div class="form-group mt-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="mt-5">
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>
    </div>

    <div class="mt-5">
        <a href="/auth/login">Already have an acconunt ? Login</a>
    </div>
</div>

<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
