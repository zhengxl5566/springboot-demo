<#import "lib/example.ftlh" as e>
<#import "lib/common.ftlh" as common>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>



<#macro greet>
    <h1>hello 课代表</h1>
</#macro>

<@greet></@>

<p>你好，
    <#if userName == "Java 课代表">
    <strong>${userName}</strong>
    <#elseif userName == "zhengxl5566">
<h1>${userName}</h1>
<#else>
    ${userName}
</#if>
</p>


<#assign myName = "Java 课代表">
<#assign myName = "课代表">
<#--实际输出的是“课代表”-->
${myName}
<#assign email = "other@example.com">

<#include "lib/example.ftlh">
${email}

<hr>
<#--使用命名空间 e 中的 copyright-->
<@e.copyright date = .now?date/>

<#--使用命名空间 common 中的 olList-->
<@common.olList allUsers />

<#--List中的空值处理-->
<#assign x = 20>
<#list xs as x>
    ${x!'Missing'}
</#list>


${.now?string("yyyy-MM-dd HH:mm a")}

<#list "some,,test,text,"?split(",") as x>
    - "${x}"
    <br>
</#list>
<h2>插值</h2>
<#--插值用法-->
<p>你好，${userName}</p>

<#--if elseif else 用法-->
<p>你好，
    <#if userName == "Java 课代表">
    <strong>${userName}</strong>
    <#elseif userName == "zhengxl5566">
    <h1>${userName}</h1>
<#else>
    ${userName}
</#if>
</p>

<hr>

<#assign x = 10>
<#list xs as x>
    ${x!'Missing'}
</#list>


<h2>遍历集合</h2>
<#--根据下标访问集合中的单个元素-->
${allUsers[0].name}

<h3>遍历集合1</h3>
<#--遍历集合样例1-->
<ol>
    <#list allUsers as user>
        <li>
            姓名：${user.name}，年龄：${user.age}
        </li>
    </#list>
</ol>
<h3>遍历集合2</h3>
<#--遍历集合样例2-->
<#list allUsers>
    <ol>
        <#items as user>
            <li>
                姓名：${user.name}，年龄：${user.age}
            </li>
        </#items>
    </ol>
</#list>
<hr>

<#--隔行变色-->
<#assign mySequence = ["Java 课代表","张三","李四","王五"]>
<#list mySequence as name>
    <span style="color:  ${name?item_cycle("red","blue","yellow")}">   ${name}<br/> </span>

</#list>

<br>
<#--将include使用import代替-->
<#--<#include "footer.ftlh">-->
<@common.myFooter/>

</body>
</html>