<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>All users of our application:</h1>
    <div style="margin: 10px">
        <table class="table">
            <tr>
                <th>Name</th>
                <th>Login</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getName()}</td>
                    <td>${user.getLogin()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
