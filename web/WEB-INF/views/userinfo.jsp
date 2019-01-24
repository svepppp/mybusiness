<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/user';

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/get/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPost = function (name,login,password) {
        var JSONObject = {
            'name': name,
            'login': login,
            'password':password
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

    var RestPut = function (id, name, login,password) {
        var JSONObject = {
            'id': id,
            'name': name,
            'login': login,
            'password':password
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update',
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
    }

</script>

<body>
    <h1>user's info</h1>

    <table class="table">
        <tr>
            <th>Request type</th>
            <th>URL</th>
            <th>Value</th>
        </tr>

        <tr>
            <td>Get user by id <code><strong>GET</strong></code></td>
            <td>/user/get/{id}</td>
            <td>
                id: <input id="getuserID" value="">
                <button type="button" onclick="RestGet($('#getuserID').val())">try</button>
            </td>
        </tr>

        <tr>
            <td>Get all users<code><strong>GET</strong></code></td>
            <td>/user/get/all</td>
            <td>
                <button type="button" onclick="RestGetAll()">try</button>
            </td>
        </tr>

        <tr>
            <td>Add user<code><strong>POST</strong></code></td>
            <td>/user/add</td>
            <td>
                <form class="form-inline">
                    name: <input id="postName" value="default name">
                    login: <input id="postLogin" value="default login">
                    password: <input id="postPassword" value="default password">

                    <button type="button" onclick="RestPost($('#postName').val(),$('#postLogin').val(), $('#postPassword').val())">try</button>
                </form>
            </td>
        </tr>

        <tr>
            <td>Update user<code><strong>PUT</strong></code></td>
            <td>/user/update</td>
            <td>
                <form class="form-inline">
                    id: <input id="inputId" value="">
                    name: <input id="putName" value="default name">
                    login: <input id="putLogin" value="default login">
                    password: <input id="putPassword" value="default password">
                    <button type="button" onclick="RestPut($('#inputId').val(), $('#putName').val(), $('#putLogin').val(), $('#putPassword').val())">try</button>
                </form>
            </td>
        </tr>

        <tr>
            <td>Delete user by id <code><strong>GET</strong></code></td>
            <td>/user/delete/{id}</td>
            <td>
                id: <input id="deleteId" value="">
                <button type="button" onclick="RestDelete($('#deleteId').val())">try</button>
            </td>
        </tr>
    </table>

    <div class="panel panel-default">
        <div class="page-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
    </div>
</body>
</html>
