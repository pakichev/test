<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<section>
    <h2>Create</h2>
    <hr>
    <jsp:useBean id="order" type="test.model.Order" scope="request"/>
    <form:form method="post" action="${pageContext.request.contextPath}/orders/save" modelAttribute="order">
        <form:hidden path="id"/>
        <dl>
            <dt>Number</dt>
            <dd><form:input path="num"/></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form:form>
</section>
</body>
</html>
