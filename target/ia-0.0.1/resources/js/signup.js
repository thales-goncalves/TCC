$(document).ready(function(){

    function resetForm(){

        login:$('#login').val("");
        name:$('#name').val("");
        email:$('#email').val("");
        password:$('#password').val("");

    }


    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $("#sign-up").submit(function(event){

        event.preventDefault();

        var formData = {

            login:$('#login').val(),
            name:$('#name').val(),
            email:$('#email').val(),
            password:$('#password').val(),
    
        }
    
        var ajaxData = JSON.stringify(formData);
    
        requestAJAX("POST", "/sign-up", ajaxData, token, header)
        resetForm()
    });
    

})