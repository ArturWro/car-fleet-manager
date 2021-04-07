<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Damage</title>
</head>
<body>
<h1>Add Damage</h1>
<form:form modelAttribute="damage" method="post">

    <label for="description"><b>Damage</b></label>
    <input type="text" placeholder="Damage" name="description" required><p></p>

    <label for="damageType"><b>DamageType</b></label>
    <form:select path="damageType">
        <c:forEach var="item" items="${damageTypes}">
            <option value="${item.type}">${item.label}</option>
        </c:forEach>
    </form:select>
    <p></p>



    </br>
    <label for="Car"><b>Car</b></label>
    <form:select path="carId">
        <c:forEach var="item" items="${cars}">
            <option value="${item.id}">${item.label}</option>
        </c:forEach>
    </form:select>

    <p></p>
    <button type="submit" class="registerbtn"> Create </button>
</form:form>
</body>
</html>
