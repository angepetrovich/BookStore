<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.06.2023
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
     <title>Add Category</title></head>
<body>
<h2>Add Category:</h2>

  <form action="${pageContext.request.contextPath}/categories/saveCategory" method="post">
    <label for="nazwa">Name:</label>
    <input type="text" id="nazwa" name="nazwa" required />

    <input type="submit" value="Save" />
  </form>

</body>
</html>
