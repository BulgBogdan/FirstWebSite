<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=FoundedAds" method="POST">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Объявления</h3>
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
                    <c:forEach items="${adsFind}" var="adsFind">
                        <tr>
                            <td>${adsFind.animal}</td>
                            <td>${adsFind.breed}</td>
                            <td>${adsFind.name}</td>
                            <td>${adsFind.weight}</td>
                            <td>${adsFind.age}</td>
                            <td>${adsFind.numberPhone}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>

<%@ include file="include/head.htm" %>