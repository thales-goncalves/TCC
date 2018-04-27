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
    
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
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
	        <p>Por favor, entre com seu login e senha.</p>
	        <form:form  action="login" method="POST" modelAttribute="user">
	          <div class="form-group">
	            <div class="input-group">
	              <input type="text" id="login" name="username" class="form-control" placeholder="Login"/>
	            </div>
	          </div>
	          <div class="form-group">
	            <div class="input-group">
	              <input type="password" id="password" name="password" class="form-control" placeholder="Senha"/>
	            </div>
	          </div>
	          <button type="submit" class="btn btn-primary">Entrar</button>
	          <p>
	            <small>2018 SYSTEM.</small>
	          </p>
	        </form:form>
	      </div>
	    </div>
	  </div>
	</body>

</html>