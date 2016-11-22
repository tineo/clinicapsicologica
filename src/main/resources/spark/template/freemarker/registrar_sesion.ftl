<#include "master.ftl" />

<#function if cond then else="">
    <#if cond>
        <#return then>
    <#else>
        <#return else>
    </#if>
</#function>

<#macro head>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script>
    $(function() {
        $( "#datepicker" ).datepicker({
            changeMonth: true,
            changeYear: true
        });

        $( "#dialog-paciente" ).dialog({
            autoOpen: false,
            modal: true,
            width: 750,
            show: {
                effect: "blind",
                duration: 1000
            },
            hide: {
                effect: "explode",
                duration: 1000
            }
        });

        $( "#open_paciente").click(function(){

            $.getJSON( "/json/paciente/buscar" ,function( data ) {
                $("#paciente_table tbody > tr").remove();
                $.each(data, function(i, item) {

                    var $tr = $('<tr>').append(
                            $('<td>').text(item.codigo_paciente),
                            $('<td>').text(item.apellido_paterno),
                            $('<td>').text(item.apellido_materno),
                            $('<td>').text(item.nombres),
                            $('<td>').text(item.tipo),
                            $('<td>')
                                    .append("<a href='#' class='ui-select' " +
                                            "data-id='"+item.codigo_paciente+"'>Seleccionar</a>" )
                    ).appendTo('#paciente_table');
                    $( "#dialog-paciente").dialog( "open" );
                });
                $(".ui-select").on("click",function(){
                    $('input[name=codigo_paciente]').val($(this).attr("data-id"));
                    $('input[name=codigo_paciente_disabled]').val($(this).attr("data-id"));
                    $( "#dialog-paciente").dialog( "close" );
                });

            });
        });

        $( "#dialog-psicologo" ).dialog({
            autoOpen: false,
            modal: true,
            width: 750,
            show: {
                effect: "blind",
                duration: 600
            },
            hide: {
                effect: "explode",
                duration: 600
            }
        });




        $( "#open_psicologo").click(function(){
            $.getJSON( "/json/psicologo/buscar" ,function( data ) {
                $("#psicologo_table tbody > tr").remove();
                $.each(data, function(i, item) {

                    var $tr = $('<tr>').append(
                            $('<td>').text(item.codigo_psicologo),
                            $('<td>').text(item.apellido_paterno),
                            $('<td>').text(item.apellido_materno),
                            $('<td>').text(item.nombres),
                            $('<td>').text(item.especialidad),
                            $('<td>')
                                    .append("<a href='#' class='ui-select2' " +
                                            "data-id='"+item.codigo_psicologo+"'>Seleccionar</a>" )
                    ).appendTo('#psicologo_table');
                    $( "#dialog-psicologo").dialog( "open" );
                });
                $(".ui-select2").on("click",function(){
                    $('input[name=codigo_psicologo]').val($(this).attr("data-id"));
                    $('input[name=codigo_psicologo_disabled]').val($(this).attr("data-id"));
                    $( "#dialog-psicologo").dialog( "close" );
                });

            });
        });

        $( ".ui-boton" )
                .button()
                .click(function( event ) {
                    event.preventDefault();
                });


        /*$.get( "/json/sesion/buscar", { estado:2 } )
                .done(function( data ) {
                    alert( "Data Loaded: " + data );
                });

            */


        $(".buscar-paciente").click(function(){
            var params = {};

            if(!!$("#nombres").val()) params.nombres = $("#nombres").val()
            if(!!$("#apellido_paterno").val()) params.apellido_paterno = $("#apellido_paterno").val()
            if(!!$("#apellido_materno").val()) params.apellido_materno = $("#apellido_materno").val()

            $.getJSON( "/json/paciente/buscar", params ,function( data ) {
                $("#paciente_table tbody > tr").remove();
                $.each(data, function(i, item) {

                    var $tr = $('<tr>').append(
                            $('<td>').text(item.codigo_paciente),
                            $('<td>').text(item.apellido_paterno),
                            $('<td>').text(item.apellido_materno),
                            $('<td>').text(item.nombres),
                            $('<td>').text(item.tipo),
                            $('<td>')
                                    .append("<a href='#' class='ui-select' " +
                                            "data-id='"+item.codigo_paciente+"'>Seleccionar</a>" )
                    ).appendTo('#paciente_table');
                    $( "#dialog-paciente").dialog( "open" );
                });
                $(".ui-select").on("click",function(){
                    $('input[name=codigo_paciente]').val($(this).attr("data-id"));
                    $('input[name=codigo_paciente_disabled]').val($(this).attr("data-id"));
                    $( "#dialog-paciente").dialog( "close" );
                });
            });
        });

        $(".buscar-psicologo").click(function(){
            var params = {};

            if(!!$("#nombres_psico").val()) params.nombres = $("#nombres_psico").val()
            if(!!$("#apellido_paterno_psico").val()) params.apellido_paterno = $("#apellido_paterno_psico").val()
            if(!!$("#apellido_materno_psico").val()) params.apellido_materno = $("#apellido_materno_psico").val()
            if(!!$("#especialidad").val()) params.especialidad = $("#especialidad").val()

            console.log(params);

            $.getJSON( "/json/psicologo/buscar", params ,function( data ) {
                $("#psicologo_table tbody > tr").remove();
                $.each(data, function(i, item) {

                    var $tr = $('<tr>').append(
                            $('<td>').text(item.codigo_psicologo),
                            $('<td>').text(item.apellido_paterno),
                            $('<td>').text(item.apellido_materno),
                            $('<td>').text(item.nombres),
                            $('<td>').text(item.especialidad),
                            $('<td>')
                                    .append("<a href='#' class='ui-select2' " +
                                            "data-id='"+item.codigo_psicologo+"'>Seleccionar</a>" )
                    ).appendTo('#psicologo_table');
                    $( "#dialog-psicologo").dialog( "open" );
                });
                $(".ui-select2").on("click",function(){
                    $('input[name=codigo_psicologo]').val($(this).attr("data-id"));
                    $('input[name=codigo_psicologo_disabled]').val($(this).attr("data-id"));
                    $( "#dialog-psicologo").dialog( "close" );
                });
            });
        });


    });


</script>

<style>
    .ui-dialog { font-size: 70.5%; }
    .ui-dialog .ui-boton{ font-size: 100% !important; }
    .ui-dialog label, .ui-dialog input { display:block; }
    input.text { margin-bottom:12px; width:96%; padding: .4em; }
    .ui-dialog fieldset { padding:0; border:0; margin-top:25px; }
    .ui-dialog h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: auto; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
</style>
</#macro>


<#macro content>
<div class="container">



    <h1>Registrar Sesion</h1>

    <div class="form">

        <form action="/form/registrar_sesion" method="POST" id="commentForm" >

            <fieldset>


                <input type="hidden" name="codigo_paciente" />
                <input type="hidden" name="codigo_psicologo" />

                <div>
                    <label for="codigo_paciente"> Paciente </label>
                    <input type="text" name="codigo_paciente_disabled" disabled />
                    <a href="#" id="open_paciente" class="ui-boton">Buscar</a>
                </div>

                <div>
                    <label for="codigo_psicologo"> Piscologo </label>
                    <input type="text" name="codigo_psicologo_disabled" disabled />
                    <a href="#" id="open_psicologo" class="ui-boton">Buscar</a>
                </div>

                <div>
                    <label for="lugar"> Consultorio </label>
                    <input type="text" name="lugar" />
                </div>

                <div>
                    <label for="fecha_reunion"> Fecha de sesion </label>
                    <input type="text" name="fecha_reunion" id="datepicker"/>
                </div>

                <div>
                    <label for="hora"> Hora </label>
                    <select name="hora">
                        <#list 8..17 as x>
                            <#list 0..1 as y>
                                <option value="${x}">${if(x<10,'0'+x,''+x)}:${if(y<1,'00',''+y*30)}</option>
                            </#list>

                        </#list>
                    </select>
                </div>

                <div>
                    <label for="duracion"> Duracion </label>
                    <select name="duracion">
                        <#list 2..4 as x>
                            <option value="${x * 30}">${x * 30} min.</option>
                        </#list>
                    </select>
                </div>


                </div>

                <input type="submit" value="Registrar"/>
            </fieldset>
        </form>
    </div>





<div id="dialog-paciente" title="Buscar paciente">


    <form>
        <fieldset>
            <label for="nombres">Nombres</label>
            <input type="text" name="nombres" id="nombres" class="text ui-widget-content ui-corner-all">
            <label for="apellido_paterno">Apellido Paterno</label>
            <input type="text" name="apellido_paterno" id="apellido_paterno" class="text ui-widget-content ui-corner-all">
            <label for="apellido_materno">Apellido Materno</label>
            <input type="text" name="apellido_materno" id="apellido_materno" class="text ui-widget-content ui-corner-all">

            <div style="text-align: right;margin-right: 25px"><a class="ui-boton buscar-paciente"  > Buscar</a></div>

        </fieldset>
    </form>
    <div id="users-contain">
        <table id="paciente_table" class="ui-widget ui-widget-content">
            <thead>
            <tr class="ui-widget-header ">
                <th>Codigo</th>
                <th>Apellido paterno</th>
                <th>Apellido materno</th>
                <th>Nombres</th>
                <th>Tipo</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>


</div>

<div id="dialog-psicologo" title="Buscar paciente">


    <form>
        <fieldset>
            <label for="nombres">Nombres</label>
            <input type="text" name="nombres" id="nombres_psico" class="text ui-widget-content ui-corner-all">
            <label for="apellido_paterno">Apellido Paterno</label>
            <input type="text" name="apellido_paterno" id="apellido_paterno_psico" class="text ui-widget-content ui-corner-all">
            <label for="apellido_materno">Apellido Materno</label>
            <input type="text" name="apellido_materno" id="apellido_materno_psico" class="text ui-widget-content ui-corner-all">

            <label for="especialidad">Especialidad</label>
            <select name="especialidad" id="especialidad">
                <option value="A">Psicología de la Educación o Psicología Educacional</option>
                <option value="B">Psicología Clínica o de la Salud</option>
                <option value="C">Psicología Social Comunitaria</option>
                <option value="D">Psicología Organizacional</option>
            </select>

            <div style="text-align: right;margin-right: 25px"><a class="ui-boton buscar-psicologo" >Buscar</a></div>

        </fieldset>
    </form>
    <div id="users-contain">
        <table id="psicologo_table" class="ui-widget ui-widget-content">
            <thead>
            <tr class="ui-widget-header ">
                <th>Codigo</th>
                <th>Apellido paterno</th>
                <th>Apellido materno</th>
                <th>Nombres</th>
                <th>Especialidad</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>


</div>

</#macro>

<@display_page />
