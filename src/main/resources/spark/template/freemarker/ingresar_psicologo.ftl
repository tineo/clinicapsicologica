<#include "master.ftl" />
<#macro head>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script>
    $(function() {
        $( "#datepicker" ).datepicker({
            changeMonth: true,
            changeYear: true
        });
    });

    $("#commentForm").validate();
</script>
</#macro>


<#macro content>
<div class="container">



    <h1>Ingresar Psicologo</h1>

    <div class="form">

    <form action="/form/ingresar_psicologo" method="POST" id="commentForm" >

        <fieldset>

        <div>
            <label for="nombres"> Nombres </label>
            <input type="text" name="nombres" />
        </div>

        <div>
            <label for="apellido_paterno"> Apellido Paterno </label>
            <input type="text" name="apellido_paterno"/>
        </div>

        <div>
            <label for="apellido_materno"> Apellido Materno </label>
            <input type="text" name="apellido_materno"/>
        </div>

        <div>
            <label for="fecha_nacimiento"> Fecha de Nacimiento </label>
            <input type="text" name="fecha_nacimiento" id="datepicker"/>
        </div>

        <div>
            <label for="dni"> DNI </label>
            <input type="text" name="dni" required/>
        </div>

        <div>
            <label for="direccion"> Direccion </label>
            <input type="text" name="direccion"/>
        </div>

        <div>
            <label for="email"> Email </label>
            <input type="text" name="email"/>
        </div>

        <div>
             <label for="especialidad"> Especialidad </label>
             <select name="especialidad">
                 <option value="A">Psicología de la Educación o Psicología Educacional</option>
                 <option value="B">Psicología Clínica o de la Salud</option>
                 <option value="C">Psicología Social Comunitaria</option>
                 <option value="D">Psicología Organizacional</option>
             </select>
        </div>

        <div>
             <label for="username"> Username </label>
             <input type="text" name="username"/>
        </div>

        <div>
             <label for="password"> Contraseña </label>
             <input type="text" name="password"/>
        </div>

        <input type="submit" value="Registrar"/>
        </fieldset>
    </form>
    </div>

</div>
</#macro>

<@display_page />
