<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <h2>Dodanie nowego klienta</h2>

    <form:form method="post" modelAttribute="customer">
        <form:hidden path="id"/>
        Klient: <form:input path="name"/>
        <form:errors path="name"/>
        <input type="submit" value="Zapisz"/>
    </form:form>


</div>
