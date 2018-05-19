<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>



	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html">

			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">
			<link rel="icon" href="../../../../favicon.ico">

			<meta name="_csrf" content="${_csrf.token}" />
			<meta name="_csrf_header" content="${_csrf.headerName}" />


			<title>AI - Assistente Interpessoal</title>

			<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.1/animate.min.css">

			<link href="resources/css/login.css" rel="stylesheet">
			<link href="resources/css/slider.css" rel="stylesheet">
			<link href="resources/css/blog.css" rel="stylesheet">

			<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      
	</head>
	<body>
		<header>
			<div class="blog-masthead">
				<div class="container">
					<nav class="nav">
						<a class="nav-link active" href="/ia/">Home</a>
						<a class="nav-link" href="https://github.com/thales-goncalves">Conheça o projeto</a>

					</nav>
				</div>
			</div>
		</header>

		<div class="main">
			<div class="container">
				<div class="header">
					<h1 class="text-muted">Avaliador</h1>
				</div>
				<div class="form-group">
					<input type="hidden" id="id" value="0">
				</div>

				<div id="slider">
					<ul class="slides ">
						<li class="slide slide1">
							<img id="slider_image" class="mb-1" src="resources/images/slide/1.jpg">
							<input type="hidden" id="img_no" value="1">
						</li>
					</ul>
				</div>

				<div class="row text-center">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<a id="deslike" class="btn btn-sm animated-button thar-one">Deslike</a>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<a id="like" class="btn btn-sm animated-button thar-two">Like</a>
					</div>
				</div>
				<div class="row text-center">
					<div class="col-md-6 col-sm-6 col-xs-12 offset-3">
						<a id="result" style="background-color: blueviolet" class="btn btn-sm animated-button thar-two">Result</a>
					</div>
				</div>

			</div>
		</div>
		<div></div>
		<div class="footer-dark">
<!-- 			<footer>
				<div class="container">
					<div class="row">
						<div class="col item social">
							<a href="#">
								<i class="icon ion-social-facebook"></i>
							</a>
							<a href="#">
								<i class="icon ion-social-twitter"></i>
							</a>
							<a href="#">
								<i class="icon ion-social-snapchat"></i>
							</a>
							<a href="#">
								<i class="icon ion-social-instagram"></i>
							</a>
						</div>
					</div>
					<p class="copyright">Company Name © 2017</p>
				</div>
			</footer> -->
		</div>
	</body>

	<script type="text/javascript">
		$(document).ready(function() {
		
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
			 
			var obj = [];
		
			$("#result").click(function(){
				console.log(obj)
				console.log(JSON.stringify(obj))
				
			
				var formData = {
					id : $("#id").val(),
					value : JSON.stringify(obj)
				}
		
				 var ajaxData = JSON.stringify(formData)
				 console.log(formData)
				 console.log(ajaxData)
				 requestAJAX("POST","save",ajaxData,token,header);
			});
		
			$("#like").click(function() {
		
				console.log('like image -> ' + document.getElementById("img_no").value)
				like();
			});
		
			$("#deslike").click(function() {
		
				console.log('deslike')
				deslike();
			});
		
			function like() {
				$("#slider_image").fadeOut(
						300,
						function() {
		
							var next_val = document.getElementById("img_no").value;
		
							var item = {
		
								image : next_val,
								record : 1
		
							}
		
							obj.push(item)
		
							var next_val = Number(next_val) + 1;
		
							$('#slider_image').attr('src',
									'resources/images/slide/' + next_val + '.jpg');
							document.getElementById("img_no").value = next_val;
						});
				$("#slider_image").fadeIn(700);
			}
		
			function deslike() {
				$("#slider_image").fadeOut(
						300,
						function() {
		
							var next_val = document.getElementById("img_no").value;
		
							var item = {
		
								image : next_val,
								record : 0
		
							}
		
							obj.push(item)
		
							var next_val = Number(next_val) + 1;
		
							$('#slider_image').attr('src',
									'resources/images/slide/' + next_val + '.jpg');
							document.getElementById("img_no").value = next_val;
						});
				$("#slider_image").fadeIn(700);
			}
		
			//using setInterval() to make an image slider
		
			//function newDate(){
			//console.log(new Date());};
			//setInterval(newDate, 3000);  
		
			//the above code would console.log the date every 3seconds 
		
			//$(selector).animate(obj,time,callback);
			//callback-do something after the animation is complete
		
			
				
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				
				
				//seInterval animate margin-left and the last slide go to the first position (0px) 
		
				var width = 720;
				var animationSpeed = 1000;
				var pause = 1500;
				var currentSlide = 1;
				// try and configure all the variables so that you can change it at any point( things of the same type at the same place)
		
				var $slider = $("#slider");
				var $slideContainer = $slider.find('.slides');
				var $slides = $slideContainer.find('.slide');
		
				//the jQuery selector is used only once and the code is very efficient as you are CACHING THE DOM
				var interval;
				//have to define the variable outside startSlider() to have it in the scope of a function call
		
				/*  function startSlider() {
				 interval =  setInterval(function() {
					 $($slideContainer).animate({
					   "margin-left": "-=" + width
					 }, animationSpeed, firstSlide);
				   }, pause);
		
				   function firstSlide() {
					 currentSlide++;
					 if (currentSlide === $slides.length) {
					   currentSlide = 1;
					   $slideContainer.css("margin-left", 0);
					 }
				   }
				 }
				 
				 function stopSlider(){
				   clearInterval(interval);
				 }
				 $slider.on("mouseenter", stopSlider).on("mouseleave", startSlider);
		
				 startSlider(); */
			});
		</script>

	</html>
	