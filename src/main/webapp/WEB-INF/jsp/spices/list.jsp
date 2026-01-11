<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<a href="/spice/add">dodaj</a><br />

<table>
    <c:forEach items="${spiceslist}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><a href="/spice/update/${item.id}">Edytuj</a> </td>
            <td><a href="/spice/delete/${item.id}">usun</a></td>
        </tr>
    </c:forEach>
</table>