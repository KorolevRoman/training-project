$(document).ready(function () {
    $("#organizationList").click(function () {
        var org = $("#name").val();

        $.ajax({
            url:"/organization/list",
            type:"POST",
            data: org,
            contentType:"text/javascript; charset=utf-8",
            success: function(result ){
                alert(JSON.stringify(result));
            },
        });

        clearFields();
    });
});

var clearFields = function () {
    $("#name").val('');
};