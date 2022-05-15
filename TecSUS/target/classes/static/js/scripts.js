$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

});

document.querySelector("#basicToastBtn").onclick = function() {
    new bootstrap.Toast(document.querySelector('#basicToast')).show();
   }
   