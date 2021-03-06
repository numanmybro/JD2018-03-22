<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" name = "formOrder" action="do?command=createorder">
<fieldset>
    <script type="text/javascript">
           function OnSelectionChange (s) {
            var selectedOption = s.options[s.selectedIndex];
            document.getElementById('totalmoney').value = "${work.price}";
        }
    </script>

<!-- Form Name -->
<legend>Заявка на оказание услуг ЖКХ</legend>
<p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectkindofworks">Услуга</label>
  <div class="col-md-4">
    <select id="selectkindofworks" name="selectkindofworks" class="form-control" onchange="OnSelectionChange (this)">
        <c:forEach var="work" items="${listWork}">
            <option value = ${work.id}>${work.name}</option>
        </c:forEach>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Количество</label>
  <div class="col-md-4">
  <input id="amount" name="amount" type="text" placeholder="1" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address" >Адрес</label>
  <div class="col-md-4">
  <input id="address" name="address" type="text" value = "${user.address}" placeholder="0" class="form-control input-md" type="disabled">

  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">Оставить заказ</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Отмена</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
