var eventos = [];
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
        alert("Submitted");
        var values = {};
        $.each($('#add-event').serializeArray(), function (i, field) {
            values[field.name] = field.value;
        });
        console.log(
                values
                );
    });
});
if (!Date.prototype.toISOString) {
    (function () {

        function pad(number) {
            if (number < 10) {
                return '0' + number;
            }
            return number;
        }

        Date.prototype.toISOString = function () {
            return this.getUTCFullYear() +
                    '-' + pad(this.getUTCMonth() + 1) +
                    '-' + pad(this.getUTCDate()) +
                    'T' + pad(this.getUTCHours()) +
                    ':' + pad(this.getUTCMinutes()) +
                    ':' + pad(this.getUTCSeconds()) +
                    '.' + (this.getUTCMilliseconds() / 1000).toFixed(3).slice(2, 5) +
                    'Z';
        };

    }());
}

$.getJSON('/jsonGetEvents', {id: "1"}, function (events) {
    // `events` is a JSON string. Do your thing with it. This examples loops over it.

    $.each(events, function (index, event) {
        var id = event.id;

        var start = new Date(event.fechaInicioReserva);
        var end = new Date(event.fechaFinReserva);
        eventos.push({
            title: 'Reserva' + id,
            description: 'Lorem ipsum dolor sit amet',
            start: start,
            end: end,
            className: 'fc-bg-blue',
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
            minTime: '07:00:00',
            maxTime: '19:30:00',
            defaultView: 'month',
            // event dragging & resizing
            editable: true,
            // header
            header: {
                left: 'title',
                center: 'month,agendaWeek,agendaDay',
                right: 'today prev,next'
            },
            events: eventos,
            eventRender: function (event, element) {
                if (event.icon) {
                    element.find(".fc-title").prepend("<i class='fa fa-" + event.icon + "'></i>");
                }
            },
            dayClick: function (date, jsEvent, view, resourceObj) {
                var inputfechaini = document.getElementById('fechaInicio');
                inputfechaini.value = date.format("MM/DD/YYYY");
                var inputfechafin = document.getElementById('fechaFin');
                inputfechafin.value = date.format("MM/DD/YYYY");
                var inputhora = document.getElementById('horaInicio');
                var inputfin = document.getElementById('horaFin');
                if (date.format("HH:mm") === '00:00') {
                    inputhora.value = '07:00';
                    inputfin.value = '09:00'
                } else {
                    inputhora.value = date.format("HH:mm");
                    var horaFn = date.add(2, 'h');
                    inputfin.value = horaFn.format("HH:mm");
                }

                jQuery('#modal-view-event-add').modal();
            },
            eventClick: function (event, jsEvent, view) {
                jQuery('.event-icon').html("<i class='fa fa-" + event.icon + "'></i>");
                jQuery('.event-title').html(event.title);
                jQuery('.event-body').html(event.description);
                jQuery('.eventUrl').attr('href', event.url);
                jQuery('#modal-view-event').modal();
            }

        })
    });
})(jQuery);