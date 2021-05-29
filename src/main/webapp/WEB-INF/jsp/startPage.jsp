<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Severstal</title>
</head>
<div class="container">
    <body>
    <br>
    <h3>Severstal Test-task</h3>
    <br>
    <input type="button" class="btn btn-primary btn-lg btn-block" value="Приемка поставок"
           onclick="window.location.href = '/newsupply'"/>
    <br>
    <br>

    <div class="card-footer">
        <form:form action="history">
            Создать отчёт за период:<br>
            с <label>
            <input type="date" name="start" value="2021-05-01"/>
        </label>
            по <label>
            <input type="date" name="end" value="2021-05-01"/>
        </label>

            <input type="submit" class="btn btn-secondary" value="Показать">
        </form:form>
    </div>
    </body>
</div>
</html>