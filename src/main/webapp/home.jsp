<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>


<form class="form-horizontal" action="do?command=Home" method="POST">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Список последних добавленных объявлений</h3>
                    <div class="pull-right">
                    </div>
                </div>
                <table class="table table-hover" id="dev-table">
                    <thead>
                    <tr>
                        <th>Вид</th>
                        <th>Порода</th>
                        <th>Кличка</th>
                        <th>Масса</th>
                        <th>Возраст</th>
                        <th>Телефонный номер</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${adsList}" var="adsList">
                        <tr>
                            <td>${adsList.animal}</td>
                            <td>${adsList.breed}</td>
                            <td>${adsList.name}</td>
                            <td>${adsList.weight}</td>
                            <td>${adsList.age}</td>
                            <td>${adsList.numberPhone}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</form>