<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<a href="/sheepcasing/add">dodaj</a><br />

<table>
    <c:forEach items="${sheepcasings}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.caliber}</td>
            <td><a href="/hogcasing/update/${item.id}">Edytuj</a> </td>
            <td><a href="/hogcasing/delete/${item.id}">usun</a></td>
        </tr>
    </c:forEach>
</table>