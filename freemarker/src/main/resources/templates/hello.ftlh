<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#assign names = userService.allUser>
<#list names as name>
    <ul>
        <li>
            ${name.name}
        </li>
    </ul>

</#list>

<#--<#assign myString = "abcde">-->
<#--<#if myString?starts_with('abca')> <p>exits</p></#if>-->
<#--    <#assign name="zhengxl">-->

<#--<p>HELLO,WORLD ${myString?cap_first}</p>-->

<#--<#macro greet title="professor2" color="blue">-->
<#--    <p>Hi,<#if name?contains("zheng")>our beloved boss </#if> <span style="color: ${color}">${name}</span> ${title}</p>-->
<#--    <p>Hello,there!232</p>-->
<#--</#macro>-->
<#--&lt;#&ndash;带参数 宏指令演示&ndash;&gt;-->
<#--<@greet color="red"/>-->

<#--<#macro border>-->
<#--    <table border=4 cellspacing=0 cellpadding=4>-->
<#--        <tr>-->
<#--            <td>-->
<#--                <#nested><br/>-->
<#--                <#nested>-->
<#--            </td>-->
<#--        </tr>-->
<#--    </table>-->
<#--</#macro>-->

<#--<@border> this is nested content</@border>-->

<#--${myDate?string('MM-dd HH:mm:ss')}-->
<#--now:${.now?date}-->
<#--date:${myDate?datetime};-->
<#--<br>-->
<#--<#if myDate?date?string == .now?date?string> today ${myDate?string('MM-dd HH:mm:ss')} </#if>-->


</body>
</html>