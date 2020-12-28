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
<#--展示模板中调用java静态方法-->
<#--UserStaticTool 已通过配置类加载到共享变量中，可查看 FreemarkerConfig 相关配置-->
<#assign user = UserStaticTool.getUser("zhangsan")>
姓名：${user.name} 年龄：${user.age}

</body>
</html>