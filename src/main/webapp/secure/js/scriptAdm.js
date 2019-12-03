/**
 * very much a work in progress
 * HTML + CSS for a class demo in WIP400 at Platt College San Diego
 *
 *
 * @TODO:
 *  form inputs
 *  responsive tables
 *  more icons: trash
 *  matching login/register form
 *  toggle menus
 */



$('#example1').dataTable({
    dom: 'Bfrtip',
    searching: false,
    paging: false,
    ordering: false,
    info: false,
    buttons: [{
            extend: 'excelHtml5',
            customize: function (xlsx) {
                var sheet = xlsx.xl.worksheets['sheet1.xml'];

                $('row c[r^="C"]', sheet).attr('s', '2');
            }
        }]
});
$('#example2').dataTable({
    dom: 'Bfrtip',
    searching: false,
    paging: false,
    ordering: false,
    info: false,
    buttons: [{
            extend: 'excelHtml5',
            customize: function (xlsx) {
                var sheet = xlsx.xl.worksheets['sheet1.xml'];

                $('row c[r^="C"]', sheet).attr('s', '2');
            }
        }]
});
$('#example3').dataTable({
    dom: 'Bfrtip',
    searching: false,
    paging: false,
    ordering: false,
    info: false,
    buttons: [{
            extend: 'excelHtml5',
            customize: function (xlsx) {
                var sheet = xlsx.xl.worksheets['sheet1.xml'];

                $('row c[r^="C"]', sheet).attr('s', '2');
            }
        }]
});
$('#example4').dataTable({
    dom: 'Bfrtip',
    searching: false,
    paging: false,
    ordering: false,
    info: false,
    buttons: [{
            extend: 'excelHtml5',
            customize: function (xlsx) {
                var sheet = xlsx.xl.worksheets['sheet1.xml'];

                $('row c[r^="C"]', sheet).attr('s', '2');
            }
        }]
});


