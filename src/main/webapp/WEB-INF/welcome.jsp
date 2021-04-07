<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

</head>
<body>
<div class="container">

    <h1>Welcome</h1>

    <c:if test="${pageContext.request.userPrincipal.login != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input  name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} |
            <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    <a href="/addcar" target="/addcar"><button>Add car</button></a><br>
    <a href="/departure" target="/departure"><button>Add departure</button></a><br>
    <a href="/cars" target=/cars"><button>Cars list</button></a><br>
    <a href="/departurelist" target="/departurelist"><button>Departures list</button></a><br>
    <a href="/adddamage" target="/adddamage"><button>Add damage</button></a><br>
    <a href="/damages" target="/damages"><button>Damage list</button></a><br>
    <a href="/update" target="/update"><button>Update car state</button></a><br>
    <a href="/cars/delete/" target="/cars/delete/"><button>Delete car</button></a><br>
    <a href="/driverslist" target="/driverslist"><button>User profile</button></a><br>
</div>

</body>
</html>