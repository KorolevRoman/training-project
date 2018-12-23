$(document).ready(function () {
    $("#organizationList").click(function () {
        var org = {
            name : $("#name").val(),
            inn : $("#inn").val(),
            isActive : $("#isActive").val()
        }
        $.ajax({
            url:"/organization/list",
            type:"POST",
            data: JSON.stringify(org),
            contentType:"application/json; charset=utf-8",
            success: function(result ){
                alert(JSON.stringify(result));
            },
        });

        clearFields();
    });

    $("#addOrganization").click(function () {
        var org = {
            name : $("#name1").val(),
            fullName : $("#fullName").val(),
            inn : $("#inn1").val(),
            kpp : $("#kpp").val(),
            address : $("#address").val(),
            isActive : true,
        }

        $.ajax({
            url:"/organization/save",
            type:"POST",
            data: JSON.stringify(org),
            contentType:"application/json; charset=utf-8",
            success: function(){
                alert('Success');
            },
        });

        clearFields();
    });

    $("#updateOrganization").click(function () {
        var org = {
            id : $("#id2").val(),
            name : $("#name2").val(),
            fullName : $("#fullName2").val(),
            inn : $("#inn2").val(),
            kpp : $("#kpp2").val(),
            address : $("#address2").val(),
            isActive : true,
        }

        $.ajax({
            url:"/organization/update",
            type:"POST",
            data: JSON.stringify(org),
            contentType:"application/json; charset=utf-8",
            success: function(){
                alert('Success');
            },
        });

        clearFields();
    });
});

var clearFields = function () {
    $("#name").val('');
    $("#name1").val('');
    $("#fullName").val('');
    $("#inn").val('');
    $("#kpp").val('');
    $("#address").val('');
};