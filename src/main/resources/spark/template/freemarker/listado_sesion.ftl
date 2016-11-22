<#include "master.ftl" />
<#macro head>

<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css'>


<style>
    /*body {
        line-height: 1;
        margin: 50px;
    }*/
    .ui-calendar {
        background: rgba(0, 0, 0, .1);
        border-radius: 5px;
        box-sizing: border-box;
        padding: 15px;
        width: 600px;
        margin: 25px auto;
    }
    .ui-calendar header {
        overflow: clear;
        position: relative;
    }
    .ui-calendar h2 {
        font-family: 'PT Sans Narrow', sans-serif;
        font-size: 18px;
        font-weight: 700;
        margin: 0 0 10px;
        text-align: center;
    }
    .ui-calendar button {
        position: absolute;
        top: -4px;
        background-color: #428BCA;
        color: #28567C;
        border: solid 1px #28567C;
    }

    .ui-calendar button:hover {
        background-color: #28567C;
        color: #428BCA;
        border: solid 1px #428BCA;

    }
    .ui-calendar button:first-child {
        left: 0;
    }
    .ui-calendar button:last-child {
        right: 0;
    }
    .ui-calendar table {
        background: #fff;
        border-collapse: collapse;
        color: #222;
        font-family: 'PT Sans', sans-serif;
        font-size: 13px;
        width: 100%;
    }
    .ui-calendar td {
        border: 1px solid #ccc;
        color: #444;
        line-height: 22px;
        text-align: center;

    }
    .ui-calendar tr:first-child td {
        color: #222;
        font-weight: 700;
    }
    .ui-calendar .selected {
        color: #fff;
        font-weight: bold;
        background: #428BCA;
        border: 0;
        box-shadow: 0 2px 6px rgba(0, 0, 0, .5) inset;
    }

    .ui-list{

        margin: 0 20px;
        padding: 0;
    }

    .ui-list-sesion{

        border: solid 1px #eeeeee;
        padding: 0;
        margin: 0;

    }
    .ui-list-sesion .ui-list-hora{
        margin: 0;
        padding: 0 20px;

        float: left;
        background-color: #66affe;
        border-right: solid 1px #cccccc;
    }
    .ui-sesion{
        font-size: 85%;
        /*border: solid 1px #cccccc;*/

        float: left;
        display: inline-block;
        background-color: #5fb9ca;

        position: absolute;
        width: 615px;

        padding: 5px;
        margin: 0 0 0 0px;
    }
    .ui-sesion:hover{
        cursor: pointer;
    }
    .clearing{
        clear: both;
    }

    .ui-boton{
        /*margin: 10px auto;*/
    }


</style>


<script src="http://momentjs.com/downloads/moment.min.js"></script>
<script>

    function getHorario(date){
        //$('.ui-list').fadeOut();
        //$('.ui-list').fadeIn();

        console.log(date);
        var params = {};

        params.fecha_reunion = date;

        $.getJSON( "/json/sesion/buscar", params ,function( data ) {


            $('.ui-sesion').remove();
            //console.log(data);
            /*$("#paciente_table tbody > tr").remove();
            */
            $.each(data, function(i, item) {
                //console.log(item);
                var paciente = "";
                $.getJSON( "/json/paciente/buscar", {codigo_paciente: item.codigo_paciente} ,function( data ) {
                    paciente = data[0].nombres+ " " +data[0].apellido_paterno+ " " +data[0].apellido_materno+ " " ;


                }).then(function(){
                    var duracion = item.duracion;
                    var height = (duracion/30)*32-12;

                    var d = moment(item.fecha_reunion, "MM/dd/yyyy HH:mm:ss");
                    var hora = d.format('HH');
                    var mins = d.format('mm');

                    $('<div>').append( "<div>" +
                                    "<b>"+paciente+"</b>" +
                                    "</div><div>" +
                                    "<a class='ui-boton' data-titulo='Agregar Observacion'>(+) Observacion</a>" +
                                    "<a class='ui-boton' data-titulo='Revisar Examenes'>(&) Examenes</a>" +
                                    "<a class='ui-boton' data-titulo='Agregar Medicamentos'>(+) Medicamento</a></div>")
                            .addClass("ui-sesion").css('height',height)
                            .insertAfter('span[data-hora=h'+hora+mins);


                    $( ".ui-boton" )
                            .button()
                            .click(function( event ) {
                                event.preventDefault();
                                $( "#dialog-form").dialog('option', 'title', $(this).attr('data-titulo'))

                                $( "#dialog-form" ).dialog("open");


                            });
                }).then(function(){
                    var ini = "#fff";
                    $( ".ui-sesion" ).each(function( index ) {

                        var color = new RColor;

                        if(ini != color.get(true)) ini = color.get(true);

                        //console.log( index + ": " + $( this ).text() );
                        $(this).css({ backgroundColor : ini });
                    });
                });


            });



        });

    }



    $(function() {
        $( "#datepicker" ).datepicker({
            changeMonth: true,
            changeYear: true,
            onSelect: function (date) {
                //console.log(date);
                getHorario(date);
                // Your CSS changes, just in case you still need them
                //$('a.ui-state-default').removeClass('ui-state-highlight');
                //$(this).addClass('ui-state-highlight');
            }
        });

        $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 300,
            width: 350,
            modal: true

        });

        /*$('.ui-sesion').click(function(){

            $( "#dialog-form" ).dialog("open");

        });*/

        //getHorario(moment().format('L'))






    });
</script>

<script src="/js/rcolor.js"></script>


<script>
/*
<if h == 13 &&  m == 1><div class="ui-sesion" style="height: ${3 * 32 -12}px">
                    <div><b>Cesar Gutierrez Tineo</b></div>
                    <div>
                    <a class="ui-boton">(+) Observacion</a>
                    <a class="ui-boton">(&) Examenes</a>
                    <a class="ui-boton">(+) Medicamento</a>
                    </div>
                </div></if>
                <if h == 16 &&  m == 0><div class="ui-sesion" style="height: ${4 * 32 -12}px">
                    <div><b>Cesar Gutierrez Tineo</b></div>
                    <div>
                        <a class="ui-boton">(+) Observacion</a>
                        <a class="ui-boton">(&) Examenes</a>
                        <a class="ui-boton">(+) Medicamento</a>
                    </div>
                </div></if>
                */



</script>

</#macro>

<#macro content>

<div style="margin: 20px auto; width: 320px;text-align: center">
    <div id="datepicker"></div>
</div>


<div class="ui-list">
    <#list 8..17 as h>
        <#list 0..1 as m>
            <#assign someTime = "${h}:${m*30}:00"?time("HH:mm:ss")>
            <#list dateutil.addMinutes(someTime,30) as addedTime >
                <#assign newTime = addedTime >
            </#list>
            <div class="ui-list-sesion" >
                <span class="ui-list-hora" data-hora="h${someTime?string["HHmm"]}">${someTime?string["HH:mm"]} - ${newTime?string["HH:mm"]}</span>

                <div class="clearing"></div>
            </div>
        </#list>
    </#list>

</div>


<div id="dialog-form" title="x">
    <div><textarea rows="9" style="width: 100%"></textarea></div>
    <div><button>Agregar</button></div>
</div>




</#macro>

<@display_page />