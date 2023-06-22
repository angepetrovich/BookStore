<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.06.2023
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
      <h2>Categories:</h2>

      <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
        </tr>
        <c:forEach var="kategoria" items="${kategorie}">
          <tr>
            <td>${kategoria.id}</td>
            <td>${kategoria.nazwa}</td>
          </tr>
        </c:forEach>
      </table>

      <div>
        <input type="button" value="Add Category" onclick="window.location.href='formadd'; return false;" />
      </div>

      <p>
          <a class="link" href="${pageContext.request.contextPath}/books/list">Return</a>
      </p>

</body>
</html>
