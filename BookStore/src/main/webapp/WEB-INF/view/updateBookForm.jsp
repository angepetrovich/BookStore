<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.06.2023
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <h2>update BOOK</h2>

    <form:form action="saveBook" modelAttribute="bookDTO" method="POST">
        <table>
            <tbody>
            <form:hidden path="id"/>
            <tr>
                <td><label>nazwa:</label></td>
                <td><form:input path="nazwa" class="input" /></td>
            </tr>

            <tr>
                <td><label>wydawnictwo:</label></td>
                <td><form:input path="wydawnictwo" class="input" /></td>
            </tr>

            <tr>
                <td><label>cena:</label></td>
                <td><form:input path="cena" class="input" /></td>
            </tr>

            <tr>
                <td class="label"><label for="categories">Category:</label></td>
                <td>
                    <form:select path="kategoriaid" id="categories">
                        <form:options items="${categories}" itemValue="id" itemLabel="nazwa" />
                    </form:select>
                </td>
            </tr>

            <tr>
                <td class="label"><label for="authors">Autorzy:</label></td>
                <td>
                    <form:select path="autorzy" id="authors" multiple="true">
                        <form:options items="${authors}" itemValue="id" itemLabel="fullName" />
                    </form:select>
                </td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <p>
        <a class="link" href="${pageContext.request.contextPath}/books/list">Return</a>
    </p>
</body>
</html>
