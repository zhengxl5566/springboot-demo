<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <table border="1">
        <@myTag method = "getUsers";tagList>
        <#list tagList as user>
            <tr>
                <td>${user.name}
                <td class="${user?item_cycle("")}">${user.age}
            </tr>
        </#list>
        </@myTag>
    </table>
</head>
<body>

</body>
</html>