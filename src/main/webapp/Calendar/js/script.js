var eventos = [];
var reservaId = document.getElementById('reservaId').value;
var horaMin = document.getElementById('hIni').value;
var horaMax = document.getElementById('hFin').value;
var tipo = document.getElementById('reservaTipo').value;
var usuario = document.getElementById('inputUsuario').value;
var tipoUsuario = document.getElementById('inputTipoUsuario').value;

function stoperror() {
    return true;
}
window.onerror = stoperror;

jQuery(document).ready(function () {
    jQuery('.datetimepicker').datepicker({
        timepicker: true,
        language: 'spanish',
        locale: 'es',
        range: true,
        multipleDates: true,
        multipleDatesSeparator: " - "
    });
    jQuery("#add-event").submit(function () {

        var values = {};
        $.each($('#add-event').serializeArray(), function (i, field) {
            values[field.name] = field.value;
        });

    });
    jQuery("#add-event-rec").submit(function () {

        var values = {};
        $.each($('#add-event-rec').serializeArray(), function (i, field) {
            values[field.name] = field.value;
        });

    });
});

$.getJSON('/jsonGetEvents', {id: reservaId}, function (events) {
    // `events` is a JSON string. Do your thing with it. This examples loops over it.

    $.each(events, function (index, event) {
        var id = event.id;

        var start = new Date(event.fechaInicioReserva);
        var end = new Date(event.fechaFinReserva);
        var classN;
        var descripcion;
        if (tipoUsuario === "administrador") {
            descripcion = '<strong>Reservado por: </strong>' + event.idUsuario +
                    '<br /><strong> Fecha de apartado: </strong>' + event.fechaReserva
                    + '<br /><strong> Fecha de reserva: </strong>' + event.fechaInicioReserva
                    + '<br /><strong> Fecha de entrega: </strong>' + event.fechaFinReserva
                    + '<br /><strong> Tipo de reserva: </strong>' + event.tipo
                    + '<br /><strong> Id del recurso: </strong>' + event.id;
        } else if (tipoUsuario === "comunidad") {
            descripcion = '<br /><strong> Fecha de reserva: </strong>' + event.fechaInicioReserva
                    + '<br /><strong> Fecha de entrega: </strong>' + event.fechaFinReserva
                    + '<br /><strong> Tipo de reserva: </strong>' + event.tipo
                    + '<br /><strong> Id del recurso: </strong>' + event.id;
        } else if (tipoUsuario === "none") {
            descripcion = '<br /><strong> Fecha de reserva: </strong>' + event.fechaInicioReserva
                    + '<br /><strong> Fecha de entrega: </strong>' + event.fechaFinReserva;

        }
        if (event.tipo === "Normal" || event.tipo === "normal") {
            classN = "fc-bg-blue";
        } else if (event.tipo === "Recurrente" || event.tipo === "recurrente") {
            classN = "fc-bg-pinkred";
        }
        
        eventos.push({
            title: 'Reservado',
            description: descripcion,
            start: start,
            end: end,
            className: classN,
            icon: "calendar"
        });
        $("#calendar").fullCalendar('removeEvents');
        $("#calendar").fullCalendar('addEventSource', eventos);
        $("#calendar").fullCalendar('rerenderEvents');

    });

});

(function () {
    'use strict';
    // ------------------------------------------------------- //
    // Calendar
    // ------------------------------------------------------ //
    jQuery(function () {
        console.log(eventos);

        // page is ready
        jQuery('#calendar').fullCalendar({
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
            dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi\u00E9rcoles', 'Jueves', 'Viernes', 'S\u00e1bado'],
            dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi\u00E9', 'Jue', 'Vie', 'S\u00e1b'],
            themeSystem: 'bootstrap4',
            locale: 'es',
            // emphasizes business hours
            businessHours: false,
            minTime: horaMin,
            maxTime: horaMax,
            defaultView: 'month',
            allDaySlot: false,
            slotDuration: '00:10:00',
            // event dragging & resizing

            // header
            header: {
                left: 'title',
                center: 'month,agendaWeek,agendaDay',
                right: 'today prev,next'
            },
            events: eventos,
            eventOverlap: false,
            selectOverlap: false,
            slotEventOverlap: false,
            eventRender: function (event, element) {
                if (event.icon) {
                    element.find(".fc-title").prepend("<i class='fa fa-" + event.icon + "'></i>");
                }
            },
            dayClick: function (date, jsEvent, view, resourceObj) {

                if (!(usuario === "")) {
                    if (!(tipo === "Libro")) {
                        $('#colFechaFin').hide();
                    }
                    var inputfechaini = document.getElementById('fechaInicio');
                    inputfechaini.value = date.format("MM/DD/YYYY");
                    var inputfechafin = document.getElementById('fechaFin');
                    inputfechafin.value = date.format("MM/DD/YYYY");
                    var inputhora = document.getElementById('horaInicio');
                    var inputfin = document.getElementById('horaFin');
                    if (date.format("HH:mm") === '00:00') {
                        inputhora.value = '07:00';
                        inputfin.value = '09:00';
                    } else {
                        inputhora.value = date.format("HH:mm");
                        var horaFn = date.add(2, 'h');
                        inputfin.value = horaFn.format("HH:mm");
                    }
                    var inputfechainiRec = document.getElementById('fechaInicioRec');
                    inputfechainiRec.value = date.format("MM/DD/YYYY");
                    var inputfechafinRec = document.getElementById('fechaFinRec');
                    inputfechafinRec.value = date.format("MM/DD/YYYY");
                    var inputhoraRec = document.getElementById('horaInicioRec');
                    var inputfinRec = document.getElementById('horaFinRec');
                    if (date.format("HH:mm") === '00:00') {
                        inputhoraRec.value = '07:00';
                        inputfinRec.value = '09:00';
                    } else {
                        inputhoraRec.value = date.format("HH:mm");
                        var horaFnRec = date.add(2, 'h');
                        inputfinRec.value = horaFnRec.format("HH:mm");
                    }

                    jQuery('#seleccionTipoReserva').modal();
                } else {
                    alert("Solo los usuarios registrados pueden realizar reservas.");
                }

            },
            eventClick: function (event, jsEvent, view) {
                jQuery('.event-icon').html("<i class='fa fa-" + event.icon + "'></i>");
                jQuery('.event-title').html(event.title);
                jQuery('.event-body').html(event.description);
                jQuery('.eventUrl').attr('href', event.url);
                jQuery('#modal-view-event').modal();
            }

        });
    });
})(jQuery);