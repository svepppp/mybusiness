<%--
  Created by IntelliJ IDEA.
  User: Светлана
  Date: 29.11.2018
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Моя вторая страничка</title>
</head>
<body text="#FF33CC" bgcolor="#FFFF99" link="#449988" alink="#FF3300" vlink="#339999">
<div align="right">
    <a href="home" target="window-1" >Главная</a>
    <a href="my_flowers"  target="_top">Мои цветы</a>
    <button  title="Доступна!" onclick='open("frame", "displayWindow1",
 "width=380, height=240, status=no, toolbar=no, menubar=no");' >Зарегистрироваться</button>
    <button  title="Доступна!" onclick='open("enter", "displayWindow1",
 "width=380, height=240, status=no, toolbar=no, menubar=no");' >Войти</button>
</div>
<div align="center">
     <H3>
        Здравствуйте,
        <br>
        <p color="#00CC00">Это моя вторая страничка</p> :)
    </H3>
    <br>
    Добро пожаловать! :)
</div>

<p align="justify">
    <u>
        Я совсем недавно начал(а)</u> знакомиться <font size="+1">с виртуальной жизнью,</font> но мне по<b> давней традиции тоже </b>захотелось создать свою домашнюю страничку <i>для моих новых виртуальных друзей</i> и знакомых, чтобы они могли <a href="my_flowers.html" target="_blank"> посмотреть мои цветы</a>, почитать обо мне, черкнуть пару строчек в мою гостевую книгу. А может и просто случайный посетитель вдруг захочет познакомиться со мной, и у меня появится еще один виртуальный друг? :)
</p>

</body>
</html>
