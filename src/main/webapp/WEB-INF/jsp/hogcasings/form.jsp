<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
<h2>Dodanie nowego kalibru</h2>

    <form:form method="post" modelAttribute="hogcasing">
        <form:hidden path="id"/>
        Caliber: <form:input path="caliber"/>
        <form:errors path="caliber"/>
        <input type="submit" value="Zapisz"/>
    </form:form>


</div>
