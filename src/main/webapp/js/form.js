$(document).ready(function () {
    $("#organizationList").click(function () {
        var org = $("#name").val();

        $.ajax({
            url:"/organization/list",
            type:"POST",
            data: org,
            contentType:"text/javascript; charset=utf-8",
            dataType:"text",
            success: function(result ){
                alert(result);
            },
        });

        clearFields();
    });
});

var clearFields = function () {
    $("#name").val('');
};