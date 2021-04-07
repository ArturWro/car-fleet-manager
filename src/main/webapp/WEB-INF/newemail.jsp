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
    <h1>Change e-mail</h1>
    <hr>
    <label path="newemail"><b>Enter new e-mail</b></label>
    <input path="newemail" type="text" placeholder="Enter new e-mail" name="email"/><br>

    <input type="submit" class="update" value="Update">
</form:form>

</body>
</html>