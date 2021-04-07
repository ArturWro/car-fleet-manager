<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
</head>
<body>
<form:form method="post" modelAttribute="driverForm">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label path="login"><b>Login</b></label>
        <input path="login" type="text" placeholder="Enter Login" name="login"/><br>

        <label path="email"><b>Email</b></label>
        <input path="email" type="text" placeholder="Enter Email" name="email"/><br>

        <label path="password"><b>Password</b></label>
        <input path="password" type="password" placeholder="Enter Password" name="password"/><br>

        <label path="passwordConfirm"><b>Repeat Password</b></label>
        <input path="passwordConfirm" type="password" placeholder="Repeat Password" name="passwordConfirm"/><br>

        <label path="pesel"><b>Pesel</b></label>
        <input path="pesel" type="text" placeholder="Enter PESEL" name="pesel"/><br>

        <label path="firstName"><b>First Name</b></label>
        <input path="firstName" type="text" placeholder="Name" name="firstName"/><br>

        <label path="lastName"><b>Last Name</b></label>
        <input path="lastName" type="text" placeholder="Last Name" name="lastName"/><br>

        <label path="jobTitle"><b>Occupation</b></label>
        <input path="jobTitle" type="text" placeholder="Occupation" name="jobTitle"/><br>
        <hr>
        <input type="submit" class="registration" value="Register">
    </div>
</form:form>
</body>
</html>