<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Cats</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/cat';
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
    var RestPost = function (description,name,year) {
        var JSONObject = {
            'description': description,
            'name': name,
            'year': year
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
    var RestPut = function (id,description,name,year) {
        var JSONObject = {
            'id': id,
            'description': description,
            'name': name,
            'year': year
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
<h1>Cat's info</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>

    <tr>
        <td>Get cat by id <code><strong>GET</strong></code></td>
        <td>/cat/get/{id}</td>
        <td>
            id: <input id="getCatID" value="">
            <button type="button" onclick="RestGet($('#getCatID').val())">try</button>
        </td>
    </tr>

    <tr>
        <td>Get all cats<code><strong>GET</strong></code></td>
        <td>/cat/get/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>

    <tr>
        <td>Add cat<code><strong>POST</strong></code></td>
        <td>/cat/add</td>
        <td>
            <form class="form-inline">
                description: <input id="postDescription" value="default description">
                name: <input id="postName" value="default name">
                year: <input id="postYear" value="default year">

                <button type="button" onclick="RestPost($('#postDescription').val(),$('#postName').val(),$('#postYear').val())">try</button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Update cat<code><strong>PUT</strong></code></td>
        <td>/cat/update</td>
        <td>
            <form class="form-inline">
                id: <input id="inputId" value="">
                description: <input id="putDescription" value="default description">
                name: <input id="putName" value="default name">
                year: <input id="putYear" value="default year">

                <button type="button" onclick="RestPut($('#inputId').val(),$('#putDescription').val(),$('#putName').val(),$('#putYear').val())">try</button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Delete cat by id <code><strong>DELETE</strong></code></td>
        <td>/cat/delete/{id}</td>
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