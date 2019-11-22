
var table = $('#example').DataTable({
    language: {
        "decimal": "",
        "emptyTable": "No hay información",
        "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
        "infoEmpty": "Mostrando 0 de 0 Entradas",
        "infoFiltered": "(Filtrado de _MAX_ total entradas)",
        "infoPostFix": "",
        "thousands": ",",
        "lengthMenu": "Mostrar _MENU_ Entradas",
        "loadingRecords": "Cargando...",
        "processing": "Procesando...",
        "search": "Buscar:",
        "zeroRecords": "Sin resultados encontrados",
        "paginate": {
            "first": "Primero",
            "last": "Ultimo",
            "next": "Siguiente",
            "previous": "Anterior"
        }
    }
});

$(document).on("click", ".modificarEstado", function () {
    var idStatus = $(this).data('id');


    var input = document.getElementById('modifyStatus:idStatus');
    input.value = idStatus;

});

$(document).ready(function () {
    var table = $('#example').DataTable();

    $('#example tbody').on('click', 'td.details', function () {
        var tr = $(this).closest('tr');
        var sp = $(this).children().eq(1);
        var row = table.row(tr);
        if (row.child.isShown()) {
            $(this).children().children().first().removeClass("fa-minus-square").addClass("fa-plus-square");
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child(sp.html()).show();
            tr.addClass('shown');
            $(this).children().children().first().removeClass("fa-plus-square").addClass("fa-minus-square");
        }
    });
});