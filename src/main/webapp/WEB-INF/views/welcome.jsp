<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<div class="container">
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <h2 class="navbar-brand">Menu</h2>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <form action="/users" method="post" class="nav-link">
                            <input type="submit" class="btn btn-light" value="Users"/>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="/logout" method="post" class="nav-link">
                            <input type="submit" class="btn btn-light" value="Log out"/>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div>
        <span style="color: red; ">${errorMessage}</span>
        <h1>Welcome, ${user.getName()} !</h1>
        <h2>Your login: ${user.getLogin()}</h2>
    </div>
</div>

</body>

</html>
