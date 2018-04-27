<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	
	
	 	<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
		<link rel="icon" href="../../../../favicon.ico">
			
			
	
	    <title>AI - Assistente Interpessoal</title>
	
	
		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		
		<!-- Custom styles for this template -->
		<link href="resources/css/login.css" rel="stylesheet">
	    
	    
		<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	</head>
	


	<body class="text-center">
	  <div class="login_wrapper" style="color: #ffffff">
	    <div style="margin-top: 100px; background: #344358; padding: 20px; border-radius: 20px; box-shadow: 2px 2px 40px #13293d; text-align: center;">
	      <div class="loginscreen-box" style="margin: 10px 10px 10px 10px">
	        <div class="loginscreen-imagebox" style="padding: 20px;">
	          <br> <br> <img class="mb-4" src="resources/images/ai.svg" alt="" width="72" height="72">
	        </div>
	        <p>Por favor, preencha os todos dados abaixo.</p>
	        <form:form  id="signup">
	          <div class="form-group">
	            <div class="input-group">
	              <input type="text" id="login" name="login" class="form-control" placeholder="Login"/>
	            </div>
	          </div>
	          <div class="form-group">
	            <div class="input-group">
	              <input type="text" id="name" name="name" class="form-control" placeholder="Nome"/>
	            </div>
	          </div>
	          <div class="form-group">
	            <div class="input-group">
	              <input type="text" id="email" name="email" class="form-control" placeholder="Email"/>
	            </div>
	          </div>
	          <div class="form-group">
	            <div class="input-group">
	              <input type="password" id="password" name="password" class="form-control" placeholder="Senha"/>
	            </div>
	          </div>
	          <p>Eu aceito as politicas de privacidade</p>
	          	<button id="sign" class="btn btn-primary">Registrar</button>
	          <p>
	            <small>2018 SYSTEM.</small>
	          </p>
	        </form:form>
	      </div>
	    </div>
	  </div>
	</body>
	
	
	
	<script type="text/javascript">
	$(document).ready(function(){

	    function resetForm(){

	        login:$('#login').val("");
	        name:$('#name').val("");
	        email:$('#email').val("");
	        password:$('#password').val("");

	    }

	    
	    function requestAJAX(method, url, data, token, header) {
	        
	    	data = data || null
	    	
	        $.ajax({
	            type: method,
	            contentType: "application/json",
	            url: url,
	            data: data,
	            beforeSend: function(xhr) {
	                xhr.setRequestHeader(header, token);
	            }
	        });
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
	</script>

</html>