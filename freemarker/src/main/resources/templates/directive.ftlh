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

<#--返回值为集合的自定义指令-->
<@myDirective method="getAllUsers" ;users>
    <#list users as user>
        ${user.name}
    </#list>
</@myDirective>
<br>
<#--演示带参数的自定义指令-->
<@myDirective method="getUser" userName="zhengxl5566";user>
${user.name} ${user.age}
</@myDirective>


</body>
</html>