<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>

<body>
<%--@elvariable id="driverLog" type="java"--%>
<form method="post" action="/authenticate">

    <div class="container">
        <h1>LOGIN</h1>
        <p>Please fill in this form to log</p>
        <hr>
        <div class="form-group ${error != null ? 'has-error' : ''}">

            <span>${message}</span>
            <label path="username"><b>Login</b></label>
            <input path="username" type="text" placeholder="Enter Login" name="username"/><br>

            <label path="password"><b>Password</b></label>
            <input path="password" type="password" placeholder="Enter Password" name="password"/><br>

            <span>${error}</span>

            <input type="submit" class="login" value="Login">
        </div>

    </div>
</form>

</body>
</html>