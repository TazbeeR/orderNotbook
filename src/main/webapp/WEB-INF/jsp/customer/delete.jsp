<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Czy chcesz usunąć ${customer.name}?</h2>

<form method="post">
  <input type="hidden" name="id" value="${customer.id}">

  <button type="submit" value="yes" name="confirmed">TAK</button>
  <button type="submit" value="no" name="confirmed">NIE</button>
</form>