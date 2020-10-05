<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=login" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Авторизация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="Your login" class="form-control input-md"
                       required="">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="Your password"
                       class="form-control input-md" required="">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submintButton"></label>
            <div class="col-md-4">
                <button id="submintButton" name="submintButton" class="btn btn-primary">Вход</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/head.htm" %>
