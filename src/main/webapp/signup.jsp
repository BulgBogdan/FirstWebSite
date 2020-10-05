<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=SignUp" method="post">
    <fieldset>

        <!-- Registration -->
        <legend>Регистрация</legend>

        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="Enter your login" class="form-control input-md">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="Enter your password"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Почта</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" placeholder="Enter your Email" class="form-control input-md">
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Choice User</label>
            <div class="col-md-4">
                <select id="role" name="FK_roles" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.id}">${role.role}</option>
                    </c:forEach>
                </select>
                <%--<select id="Choice" name="Choice" class="form-control">--%>
                <%--<c:forEach items="${rolesList}" var="rolesList">--%>
                <%--<option value="${rolesList.id}">${rolesList.role}</option>--%>
                <%--</c:forEach>--%>
                <%--<option value="1">Admin</option>--%>
                <%--<option value="2">User</option>--%>
                <%--</select>--%>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" name="submit" class="btn btn-primary">Зарегестрироваться</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Sign-up: ${message}</p>
<%@ include file="include/head.htm" %>


