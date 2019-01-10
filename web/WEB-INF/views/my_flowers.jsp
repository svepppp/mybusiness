<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои цветы </title>
</head>
<body text="#FF33CC" bgcolor="#FFFF99">
<div align="center">
    <H3>
        Здравствуйте,
        <br>
        <font color="#00CC00">Это мои хризантемы</font> :)
    </H3>
    <a href="image/my1.gif" target="_blank"> <img src="image/my11.gif"  border="3"
                                                  bordercolor="#CC0000"></a>

    <a href="image/my2.gif" target="_blank"> <img src="image/my21.gif"  border="3" ></a>

    <a href="image/my3.jpg" target="_blank"> <img src="image/my31.jpg"  border="3"> </a>
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
