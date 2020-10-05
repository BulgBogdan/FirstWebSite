<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Search" method="post">
    <div class="input-group">
        <!--Text input-->
        <label class="control-label" for="search"></label>
        <input id="search" name="search" type="text" class="form-control input-md" placeholder="Search"/>
        <span class="input-group-btn">
        <button type="submit" class="btn btn-primary btn-md">Search</button>
        </span>
    </div>
    <br>

<%@ include file="include/head.htm" %>