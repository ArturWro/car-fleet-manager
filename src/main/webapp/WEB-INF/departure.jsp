<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Add Departure</title>
</head>
<body>
<h1>Add departure</h1>

<form modelAttribute="departure" method="post">

    <label for="depFrom"><b>Departure from</b></label>
    <input type="text" placeholder="from" name="depFrom" required><p></p>

    <label for="depTo"><b>Departure to</b></label>
    <input type="text" placeholder="to" name="depTo" required><p></p>

    <label for="distance"><b>Distance</b></label>
    <input type="text" placeholder="Distance" name="distance" required><p></p>

    <button type="submit" class="register">Save</button>

</form>
<a href="/welcome" target="/welcome"><button>Back to welcome page</button></a><br>
</body>
</html>