<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#--内部方法调用展示-->

<#--String 内部方法调用展示-->
<#assign myString = "this is a very long string">
长度：${myString?length}<br>
首字母大写：${myString?cap_first}<br>
全部大写：${myString?upper_case}<br>
查找指定字符串：${myString?index_of("long")}<br>


</body>
</html>