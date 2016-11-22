<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="container">


    <form action="ingresar" method="get">
        Nombre:
        <input type="text" name="nombre" />

        <input type="submit" />

    </form>

  <h1>Resultados Output</h1>
    <ul>
    <#list results as x>
      <li> ${x} </li>
    </#list>
    </ul>

</div>

</body>
</html>
