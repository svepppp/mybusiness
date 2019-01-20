<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Моя первая Web страничка</title>
    <link href="image/mb.ico" rel="icon" type="image/x-icon" />
</head>
<body>
<p> Привет , <a href="sec" target="_blank"> ${name}</a></p>
<img src="image/autumn.jpg" title="Это картина Афремова">
<br>
    <a href="" target="window-1" >Главная</a>
    <br>
    <a href="sec" target="window-1" >Вторая страница</a>
    <br>
    <a href="my_flowers"  target="_top">Мои цветы</a>
<br>
<br>
<button  title="Доступна!" onclick='open("frame", "displayWindow1",
 "width=380, height=240, status=no, toolbar=no, menubar=no");' >Зарегистрироваться</button>
</body>
</html>
