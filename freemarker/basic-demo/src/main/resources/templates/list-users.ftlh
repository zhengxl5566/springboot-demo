<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <table border="1">
        <#if users?size<=0>
            no user
        </#if>
        <#list users as user>
            <tr>
                <td>${user.name}
                <td class="${user?item_cycle("")}">${user.age}
            </tr>
        </#list>
    </table>
</head>
<body>

</body>
</html>