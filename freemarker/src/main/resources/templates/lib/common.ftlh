<#macro ulList seq>
    <#list seq>
        <ul>
            <#items as item>
                <li>
                    ${item}
                </li>
            </#items>
        </ul>
    </#list>

</#macro>

<#macro olList seq>
    <#list seq>
        <ol>
            <#items as item>
                <li>
                    ${item}
                </li>
            </#items>
        </ol>
    </#list>
</#macro>