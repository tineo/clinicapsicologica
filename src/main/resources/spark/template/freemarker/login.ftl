<#include "master.ftl">
<#macro nav></#macro>
<#macro content>
<div class="container">

    <h1>Login</h1>

    <div class="form">
        <form action="/validar" method="POST">
            <fieldset>
                <div>
                    <label for="username"> Usuario </label>
                    <input type="text" name="username"/>
                </div>

                <div>
                    <label for="password"> Contraseña </label>
                    <input type="password" name="password"/>
                </div>

                <div>
                    <input type="submit" value="Ingresar"/>
                </div>
            </fieldset>

        </form>
    </div>

</div>
</#macro>

<@display_page />

