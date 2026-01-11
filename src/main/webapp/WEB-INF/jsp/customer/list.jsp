<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<a href="/customer/add">dodaj</a><br />

<table>
  <c:forEach items="${customers}" var="item">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td><a href="/customer/update/${item.id}">Edytuj</a> </td>
      <td><a href="/customer/delete/${item.id}">usun</a></td>
    </tr>
  </c:forEach>
</table>