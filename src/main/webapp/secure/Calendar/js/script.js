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

(function () {
    'use strict';
    // ------------------------------------------------------- //
    // Calendar
    // ------------------------------------------------------ //
    jQuery(function () {
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
            
            events: [
                {
                    title: 'Barber',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-07-07',
                    end: '2019-07-07',
                    className: 'fc-bg-default',
                    icon: "circle"
                },
                {
                    title: 'Flight Paris',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-08-08T14:00:00',
                    end: '2019-08-08T20:00:00',
                    className: 'fc-bg-deepskyblue',
                    icon: "cog",
                    allDay: false
                },
                {
                    title: 'Team Meeting',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-07-10T13:00:00',
                    end: '2019-07-10T16:00:00',
                    className: 'fc-bg-pinkred',
                    icon: "group",
                    allDay: false
                },
                {
                    title: 'Meeting',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-08-12',
                    className: 'fc-bg-lightgreen',
                    icon: "suitcase"
                },
                {
                    title: 'Conference',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-08-13',
                    end: '2019-08-15',
                    className: 'fc-bg-blue',
                    icon: "calendar"
                },
                {
                    title: 'Baby Shower',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-08-13',
                    end: '2019-08-14',
                    className: 'fc-bg-default',
                    icon: "child"
                },
                {
                    title: 'Birthday',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-09-13',
                    end: '2019-09-14',
                    className: 'fc-bg-default',
                    icon: "birthday-cake"
                },
                {
                    title: 'Restaurant',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-10-15T09:30:00',
                    end: '2019-10-15T11:45:00',
                    className: 'fc-bg-default',
                    icon: "glass",
                    allDay: false
                },
                {
                    title: 'Dinner',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-11-15T20:00:00',
                    end: '2019-11-15T22:30:00',
                    className: 'fc-bg-default',
                    icon: "cutlery",
                    allDay: false
                },
                {
                    title: 'Shooting',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-08-25',
                    end: '2019-08-25',
                    className: 'fc-bg-blue',
                    icon: "camera"
                },
                {
                    title: 'Go Space :)',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-12-27',
                    end: '2019-12-27',
                    className: 'fc-bg-default',
                    icon: "rocket"
                },
                {
                    title: 'Dentist',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
                    start: '2019-12-29T11:30:00',
                    end: '2019-12-29T012:30:00',
                    className: 'fc-bg-blue',
                    icon: "medkit",
                    allDay: false
                }
            ],
            eventRender: function (event, element) {
                if (event.icon) {
                    element.find(".fc-title").prepend("<i class='fa fa-" + event.icon + "'></i>");
                }
            },
            dayClick: function (date, jsEvent, view, resourceObj) {

                var inputhora = document.getElementById('horaInicio');
                if (date.format("HH:mm") === '00:00'){
                   inputhora.value = '07:00';  
                }else{
                   inputhora.value = date.format("HH:mm"); 
                }      

                jQuery('#modal-view-event-add').modal();
            },
            eventClick: function (event, jsEvent, view) {
                jQuery('.event-icon').html("<i class='fa fa-" + event.icon + "'></i>");
                jQuery('.event-title').html(event.title);
                jQuery('.event-body').html(event.description);
                jQuery('.eventUrl').attr('href', event.url);
                jQuery('#modal-view-event').modal();
            },
        })
    });

})(jQuery);