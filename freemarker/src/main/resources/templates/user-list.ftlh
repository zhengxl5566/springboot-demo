<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#if users??>
    <#list users as user>
        <ol>
            <li>
                username:${user.name},age:${user.age}
            </li>
        </ol>
    </#list>

</#if>



</body>
</html>