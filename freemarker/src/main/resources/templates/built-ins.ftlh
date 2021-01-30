<#--字符串类型内置函数样例-->
<#--创建字符串-->
<#assign myStr = "Java 课代表">
<#--首字母小写-->
${myStr?uncap_first}<br>
<#--保留指定字符后面的字符串-->
${myStr?keep_after("Java")}<br>
<#--替换指定字符-->
${myStr?replace("Java","Freemarker")}<br>

<#--时间类型内置函数样例-->
<#--获取当前时间(如果是后端将时间传入data-model，只需要传Date类型即可)-->
<#assign currentDateTime = .now>
<#--展示日期部分-->
${currentDateTime?date}<br>
<#--展示时间部分-->
${currentDateTime?time}<br>
<#--展示日期和时间部分-->
${currentDateTime?datetime}<br>
<#--按指定格式展示时间日期-->
${currentDateTime?string("yyyy-MM-dd HH:mm a")}<br>

<#--序列类型内置函数样例-->
<#assign mySequence = ["Java 课代表","张三","李四","王五"]>
<#--将所有元素以指定分隔符分割，输出字符串-->
${mySequence?join(",")}<br>
<#--取序列中的第一个元素-->
${mySequence?first}<br>
<#--将序列排序后使用逗号分割输出为字符串-->
${mySequence?sort?join(",")}<br>

<#global g = 123>