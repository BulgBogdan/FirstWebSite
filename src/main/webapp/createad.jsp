<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=CreateAd" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Создать Объявление</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="animal">Вид</label>
            <div class="col-md-4">
                <input id="animal" name="animal" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="breed">Порода</label>
            <div class="col-md-4">
                <input id="breed" name="breed" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Имя(Кличка)</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="weight">Масса</label>
            <div class="col-md-4">
                <input id="weight" name="weight" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="age">Возраст</label>
            <div class="col-md-4">
                <input id="age" name="age" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="numberPhone">Телефонный Номер</label>
            <div class="col-md-4">
                <input id="numberPhone" name="numberPhone" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for=""></label>
            <div class="col-md-4">
                <button id="" name="" class="btn btn-primary">Создать</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/head.htm" %>