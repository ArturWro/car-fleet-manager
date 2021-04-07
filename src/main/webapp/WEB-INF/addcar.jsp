<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 22.08.2019
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car</title>
</head>
<body>
 <h1>Dodaj auto</h1>
<form modelAttribute="car" method="post">

    <input type="hidden" name="id" value="${car.id}"/>

    <label for="carBrand"><b>Marka auta</b></label>
    <input type="text" placeholder="Podaj makrę" name="carBrand" required value="${car.carBrand}"><br>

    <label for="carModel"><b>Model</b></label>
    <input type="text" placeholder="Podaj model" name="carModel" required value="${car.carModel}"><br>

    <label for="initialMileage"><b>Początkowy stan licznika</b></label>
    <input type="text" placeholder="stan początkowy licznika" name="initialMileage" required value="${car.initialMileage}"><br>

    <label for="finaleMileage"><b>Końcowy stan licznika</b></label>
    <input type="text" placeholder="Enter final milage" name="finaleMileage" required value="${car.finaleMileage}"><br>

    <label for="vinNr"><b>Numer VIN</b></label>
    <input type="text" placeholder="Podaj nr VIN" name="vinNr" required value="${car.vinNr}"> <br>

    <label for="amountOfFuel"><b>Stan paliwa</b></label>
    <input type="amountOfFuel" placeholder="stan paliwa" name="amountOfFuel" required value="${car.amountOfFuel}"><br>
    <hr>
    <button type="submit" class="registerbtn">Zapisz auto</button>
 </form>
</body>
</html>
