<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<section>
    <form method="post" action="users">
        Login as: <select name="userId">
        <option value="100000" selected>User</option>
        <option value="100001">Admin</option>
        <option value="100002">Operator</option>
    </select>
        <button type="submit">Select</button>
    </form>
</section>
</body>
</html>