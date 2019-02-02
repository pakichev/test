<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://localhost/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<section>
    <h3>Orders</h3>
    <form method="post" action="${pageContext.request.contextPath}/orders/filter">
        <dl>
            <dt>Number</dt>
            <dd><input type="text" name="num" value="${param.num}"></dd>
        </dl>
        <button type="submit">Filter</button>
    </form>
    <hr/>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Number</th>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <jsp:useBean id="order" scope="page" type="test.model.Order"/>
            <tr>
                <td>${order.num}</td>
                <td>${fn:formatDateTime(order.dateTime)}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>