<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#assign myString = "abcde">

<#if myString?starts_with('abca')> <p>exits</p></#if>

<p>Hi,<#if name?contains("zheng")>our beloved boss </#if>${name}</p>
<p>HELLO,WORLD ${myString?cap_first}</p>

</body>
</html>