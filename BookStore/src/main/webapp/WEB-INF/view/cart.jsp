<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.06.2023
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <h2>Cart:</h2>

    <div>
        <table>
            <tr>
                <th>nazwa</th>
                <th>wydawnictwo</th>
                <th>cena</th>
                <th>kategoria</th>
                <th>autorzy</th>
                <th>delete</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                <td><c:out value="${book.nazwa}" /></td>
                <td><c:out value="${book.wydawnictwo}" /></td>
                <td><c:out value="${book.cena}" /></td>
                <td><c:out value="${book.kategoria.nazwa}" /></td>
                <td class="author-cell">
                <c:forEach var="author" items="${book.autorzy}">
                    ${author.imie} ${author.nazwisko} <br />
                </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart/delete" method="post">
                    <input type="hidden" name="bookId" value="${book.id}"/>
                    <button type="submit" class="btn btn-secondary">Usun</button>
                    </form>
                </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <p>
            <a class="link" href="${pageContext.request.contextPath}/books/list">Return</a>
        </p>
    </div>

    <div>
        <p>
            <a class="link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </p>
    </div>

</body>
</html>
