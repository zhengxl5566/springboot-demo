<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
${users[0].name?length}
<#list users as user>
    <ol>
        <li>
            username:${user.name},age:${user.age}
        </li>
    </ol>
</#list>
</body>
</html>