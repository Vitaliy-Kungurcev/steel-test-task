<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<html>

<head>
    <title>Supply</title>
</head>
<div class="container">
    <body>
    <h2>Новая поставка </h2>

    <form:form action="save" modelAttribute="supply">
    <p>
        Дата поставки:
        c <label>
        <input type="date" name="start" value="2021-05-01"/>
    </label>
        по<label>
        <input type="date" name="end" value="2021-05-01"/>
    </label>
    <p>
        Поставщик:
        <form:select path="provider">
            <form:option value="АО 'Краснодарские дары'"/>
            <form:option value="ОАО 'Дарина'"/>
            <form:option value="АО 'Fruit'"/>
        </form:select>
    <p>
        Тип продукта:
        <form:select path="type">
            <form:option value="Груша 1 "/>
            <form:option value="Груша 2"/>
            <form:option value="Яблоко 1"/>
            <form:option value="Яблоко 2"/>
        </form:select>
    <p>
        Наименование :
            <form:input path="name"/>
            <form:errors path="name"/>
    <p>
        Вес поставки в день (кг) :
            <form:input path="weight"/>
            <form:errors path="weight"/>
    <p>
        Цена за 1 кг (руб) :
            <form:input path="price"/>
            <form:errors path="price"/>
    <p>
        <input type="submit" value="Сохранить">
        <input type="button" onclick="window.location.href='/'" value="На главную"/>
        <br><br>
        </form:form>
    </body>
</div>
</html>