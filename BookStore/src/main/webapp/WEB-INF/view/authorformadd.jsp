<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.06.2023
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<form:form action="saveAuthor" modelAttribute="autor" method="POST">
    <table>
    <tbody>
    <tr>
    <td><label>Imie:</label></td>
    <td><form:input path="imie" /></td>
    </tr>

    <tr>
    <td><label>Nazwisko:</label></td>
    <td><form:input path="nazwisko" /></td>
    </tr>

    <tr>
    <td><label></label></td>
    <td><input type="submit" value="Save" class="save" /></td>
    </tr>

    </tbody>
    </table>
</form:form>
<p>
    <a href="${pageContext.request.contextPath}/authors/list "> return  </a>
</p>
</body>
</html>
