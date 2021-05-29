<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<body>

<h2>Отчет по поставкам за ${start} - ${end} </h2>

<br><br>
<div class="table-responsive">
    <table class="table table-bordered">
        <div class="row">
            <tr>
                <th>Поставщик</th>
                <th>Тип</th>
                <th>Название</th>
                <th>кг в день</th>
                <th>Цена за 1 кг</th>
                <th>Общий вес<br> за выбранный период</th>
                <th>Общая стоимость<br> за выбранный период</th>
                <th>Количество дней<br> поставки из периода</th>
            </tr>
            <c:forEach var="historySupply" items="${history}">

            <tr>
                <td>${historySupply.provider}</td>
                <td>${historySupply.type}</td>
                <td>${historySupply.name}</td>
                <td>${historySupply.weight} кг</td>
                <td>${historySupply.price} руб</td>
                <td>${historySupply.sum_weight} кг</td>
                <td>${historySupply.sum_price} руб</td>
                <td>${historySupply.count} дней</td>
            </tr>

            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>Итого:</td>
                <td>${rezult.get(0)} кг</td>
                <td>${rezult.get(1)} руб</td>
                <td></td>
            </tr>
    </table>

    <button onclick="window.history.back()" type="button">На главную</button>
</div>
</body>
</html>