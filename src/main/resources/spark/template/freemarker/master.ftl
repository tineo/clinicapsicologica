<#macro title >Clínica Psicológica</#macro>
<#macro content></#macro>
<#macro nav><#include "nav.ftl"></#macro>
<#macro footer><#include "footer.ftl"></#macro>
<#macro head></#macro>

<#macro display_page>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title><@title >    </@title></title>
    <link href="https://fonts.googleapis.com/css?family=Cairo" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/stylesheets/estilos.css" />


    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/overcast/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <@head>    </@head>

</head>
<body>

<@nav> <#include "nav.ftl"> </@nav>
<div class="container">
    <div id="content">
    <@content></@content>
    </div>
</div>
<div id="footer">
    <@footer></@footer>
</div>
</body>
</#macro>