<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<script>
    var service = 'http://localhost:8080/user';
    var RestPost = function (name, login, password) {
        var JSONObject = {
            'name': name,
            'login': login,
            'password': password
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            contentType: 'application/json;utf-8',
            dataType: 'json',
            accept: 'json',
            data: JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

</script>
<body>
<h1>Регистрация</h1>
<table class="table">
    <tr>
          <td>
            <form class="form-inline">
                Ваше имя : <input id="postName" value=" name">
                <br>
                Логин : <input id="postLogin" value=" login">
                <br>
                Пароль : <input id="postPassword" value=" password">
                <br>
                <button type="button"
                        onclick="RestPost($('#postName').val(),$('#postLogin').val(), $('#postPassword').val())">OK
                </button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
