<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Моя первая Web страничка</title>
    <link href="image/mb.ico" rel="icon" type="image/x-icon" />
</head>
<body>

Добр<script language="JavaScript">
    <!--
    date = new Date();
    date = date.getHours();
    if (date >= 0 && date < 6) {document.write("ой ночи")}
    else {if (date >= 6 && date < 12) {document.write("ое утро")}
    else {if (date >= 12 && date < 18) {document.write("ый день")}
    else {document.write("ый вечер")}
    }
    }
    //-->
</script><noscript>о пожаловать</noscript>!

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
