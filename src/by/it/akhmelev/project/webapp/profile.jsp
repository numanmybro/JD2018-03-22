<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>User:<br> ${user}</p>


    <div class="page-header">
        <h1>Все объявления пользователя ${user.login}</h1>
    </div>

    <div class="row">
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>
        <div class="col-md-4">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>

    </div>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-1">${ad.price} </div>
            <div class="col-md-3">${ad.address} </div>
            <div class="col-md-4">${ad.description} </div>
            <div class="col-md-1">${ad.rooms} </div>
            <div class="col-md-1">${ad.area} </div>
            <div class="col-md-1">${ad.flat} </div>
            <div class="col-md-1">${ad.flats} </div>
        </div>
    </c:forEach>

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="LogoutTrue" class="btn btn-success">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
