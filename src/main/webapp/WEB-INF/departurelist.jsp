<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Departures</title>
</head>
<body>
<h1>Departures</h1>


<c:forEach items="${departureForm}" var="departureRepository">
    <table cellspacing="0" cellpadding="0" border="4" style="width: 25%;">
        <tbody>
        <tr>
            <td>${departureRepository.id}</td>
            <td>${departureRepository.depFrom}</td>
            <td>${departureRepository.depTo}</td>
            <td>${departureRepository.distance}</td>
            <td><a href="/departurelist/delete/${departureRepository.id}">Delete</a></td>
        </tr>
        </tbody>
    </table>
    <a href="/welcome" target="/welcome"><button>Back to welcome page</button></a><br>
</c:forEach>

</body>
</html>