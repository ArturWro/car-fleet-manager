<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Drivers</title>
</head>
<body>
<h1>Drivers</h1>


<c:forEach items="${driverForm}" var="driver">
    <table cellspacing="0" cellpadding="0" border="4" style="width: 25%;">
        <tbody>
        <tr>
            <td>${driver.id}</td>
            <td>${driver.login}</td>
            <td>${driver.email}</td>
            <td>${driver.firstName}</td>
            <td>${driver.lastName}</td>
            <td><a href="/driverslist/newemail" target="/driverslist/newmail"><button>change e-mail</button></a></td>
        </tr>
        </tbody>
    </table>
    <a href="/welcome" target="/welcome"><button>Back to welcome page</button></a><br>
</c:forEach>

</body>
</html>