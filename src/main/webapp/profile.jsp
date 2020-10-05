<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Profile" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Профиль</legend>
        <div class="row">
            <b>
                <div class="col-md-1">ID</div>
                <div class="col-md-3">Логин пользователя</div>
                <div class="col-md-3">Пароль пользователя</div>
                <div class="col-md-3">Email пользователя</div>
            </b>
        </div>

        <br>
        <div class="row">
            <form class="update-user-${user.id}" action="do?command=Profile" method="post">
                <b>
                    <div class="col-md-1">
                        <input id="id1" class="form-control input-md" name="id" value="${user.id}"/>
                    </div>
                    <div class="col-md-3">
                        <input id="login" class="form-control input-md" name="login" value="${user.login}"/>
                    </div>
                    <div class="col-md-3">
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}"/>
                    </div>
                    <div class="col-md-3">
                        <input id="email" class="form-control input-md" name="email" value="${user.email}"/>
                    </div>

                    <div class="col-md-1">
                        <button id="Update" name="Update" class="btn btn-success">Изменить</button>
                    </div>
                </b>
            </form>
        </div>

        <br>
        <legend>Объявления пользователя</legend>
        <div class="row">
            <b>
                <div class="col-md-1">№</div>
                <div class="col-md-2">Вид животного</div>
                <div class="col-md-2">Порода</div>
                <div class="col-md-2">Имя(Кличка)</div>
                <div class="col-md-1">Вес</div>
                <div class="col-md-1">Возраст</div>
                <div class="col-md-2">Телефон</div>
            </b>
        </div>
        <c:forEach items="${adsList}" var="adsList">
            <br>
            <div class="row">
                <form class="update-user-${adsList.id}" action="do?command=Profile" method="post">
                    <b>
                        <div class="col-md-1">
                            <input id="id2" class="form-control input-md" name="id" value="${adsList.id}"/>
                        </div>
                        <div class="col-md-2">
                            <input id="animal" class="form-control input-md" name="animal" value="${adsList.animal}"/>
                        </div>
                        <div class="col-md-2">
                            <input id="breed" class="form-control input-md" name="breed" value="${adsList.breed}"/>
                        </div>
                        <div class="col-md-2">
                            <input id="name" class="form-control input-md" name="name" value="${adsList.name}"/>
                        </div>
                        <div class="col-md-1">
                            <input id="weight" class="form-control input-md" name="weight" value="${adsList.weight}"/>
                        </div>
                        <div class="col-md-1">
                            <input id="age" class="form-control input-md" name="age" value="${adsList.age}"/>
                        </div>
                        <div class="col-md-2">
                            <input id="numberPhone" class="form-control input-md" name="numberPhone" value="${adsList.numberPhone}"/>
                        </div>

                        <div class="col-md-1">
                            <button id="Change" name="Change" class="btn btn-success">Редактировать</button>
                        </div>
                    </b>
                </form>
            </div>
        </c:forEach>

        <!-- Button -->
        <br>
        <div class="form-group">
            <label class="col-md-4 control-label" for="logout"></label>
            <div class="col-md-4">
                <button id="logout" name="logout" class="btn btn-danger">Выход из профиля</button>
            </div>
        </div>

    </fieldset>
</form>




<%@ include file="include/head.htm" %>



