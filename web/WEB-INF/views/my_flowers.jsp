<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
       <title>Мои цветы </title>
</head>
<body text="#FF33CC" bgcolor="#FFFF99">
<div align="right">
    <a href="home" target="window-1" >Главная</a>
    <a href="sec" target="window-1" >Вторая страничка</a>
    <button  title="Доступна!" onclick='open("frame", "displayWindow1",
 "width=380, height=240, status=no, toolbar=no, menubar=no");' >Зарегистрироваться</button>
    <button  title="Доступна!" onclick='open("enter", "displayWindow1",
 "width=380, height=240, status=no, toolbar=no, menubar=no");' >Войти</button>
</div>
<div align="center">
    <H3>
        Здравствуйте,
        <br>
        <font color="#00CC00">Это мои хризантемы</font> :)
    </H3>
    <a href="image/my1.gif" target="_blank"> <img src="image/my11.gif"  border="3"
                                                  bordercolor="#CC0000"></a>
    <a href="image/my2.gif" target="_blank"> <img src="image/my21.gif"  border="3" ></a>
    <a href="image/my3.jpg" target="_blank"> <img src="image/my31.jpg"  border="3"></a>
    <a href="image/my4.jpg" target="_blank"> <img src="image/my41.jpg"  border="3"></a>
    <a href="image/my5.jpg" target="_blank"> <img src="image/my51.jpg"  border="3"> </a>
    <a href="image/my6.jpg" target="_blank"> <img src="image/my61.jpg"  border="3" ></a>
    <a href="image/my7.jpg" target="_blank"> <img src="image/my71.jpg"  border="3"></a>
    <a href="image/my8.jpg" target="_blank"> <img src="image/my81.jpg"  border="3"></a>
    <a href="image/my9.jpg" target="_blank"> <img src="image/my91.jpg"  border="3"> </a>
    <a href="image/x1.jpg" target="_blank"> <img src="image/x11.jpg"  border="3"> </a>
    <a href="image/x2.jpg" target="_blank"> <img src="image/x21.jpg"  border="3"> </a>
    <a href="image/x8.jpg" target="_blank"> <img src="image/x81.jpg"  border="3"> </a>
    <a href="image/x4.jpg" target="_blank"> <img src="image/x41.jpg"  border="3"> </a>
    <a href="image/x5.jpg" target="_blank"> <img src="image/x51.jpg"  border="3"> </a>
    <a href="image/x6.jpg" target="_blank"> <img src="image/x61.jpg"  border="3"> </a>
    <a href="image/x3.jpg" target="_blank"> <img src="image/x31.jpg"  border="3"> </a>
    <a href="image/x7.jpg" target="_blank"> <img src="image/x71.jpg"  border="3"> </a>

</div>
<form  name="comment" action="mailto:maminyaschik@gmail.com" method=post>

    Ваше имя:<br>
    <input type=text name="firstname" value="введите ваше имя" size="40" maxlength="20"><br><br>

    Ваш комментарий:<br>
    <textarea rows=7 cols=40 name="comments">введите ваш комментарий</textarea><br><br>
    <input type=submit value="ОК"> <input type=reset value="Отмена">
</form>
</body>
</html> 
