<%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 15.05.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
        <h2>Books:</h2>

        <div>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Publisher</th>
                    <th>Prize</th>
                    <th>Category</th>
                    <th>Author</th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th>Update</th>
                        <th>Delete</th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        <th>Do koszyka</th>
                    </sec:authorize>

                </tr>
                <c:forEach var="book" items="${books}" >
                    <tr>
                        <td>${book.nazwa}</td>
                        <td>${book.wydawnictwo}</td>
                        <td>${book.cena}</td>
                        <td>${book.kategoria.nazwa}</td>
                        <td class="author-cell">
                            <c:forEach var="author" items="${book.autorzy}">
                                ${author.imie} ${author.nazwisko} <br />
                            </c:forEach>
                        </td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td>
                                <a class="link" href="${pageContext.request.contextPath}/books/updateBookForm?bookId=${book.id}">edit</a>
                            </td>
                            <td>
                                <a class="link" href="${pageContext.request.contextPath}/books/deleteBook?bookId=${book.id}">delete</a>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/add" method="post">
                            <input type="hidden" id="bookId" name="bookId" value="${book.id}"/>
                            <button type="submit" >Do koszyka</button>
                            </form>
                        </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <button class="button" onclick="window.location.href='formadd'; return false;">Add Book</button>
        </div>

        <div>
            <p>
                <a class="link" href="${pageContext.request.contextPath}/authors/list">list of authors</a>
            </p>
        </div>

        <div>
            <p>
                <a class="link" href="${pageContext.request.contextPath}/categories/list">list of categories</a>
            </p>
        </div>

        <div>
            <p>
                <a class="link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </p>
        </div>
</body>
</html>
