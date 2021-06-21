<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        <form method="post">

            <label>Username: </label>
            <input type="text" name="in_username" value=${username} ><br>


            <label>Password: </label>
            <input type="text" name="in_password" value=${password} ><br>


            <input type="submit" name="login" value="Login">
        </form>
        <p>${errorMsg}</p>  

    </body>
</html>