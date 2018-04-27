<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
	


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html">

    
<title>TCC | Artificial Intelligence with Recomendation System</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.1/animate.min.css">

<link href="resources/css/blog.css" rel="stylesheet">
<link href="resources/css/slider.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">



<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<script src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
    <header>
      <div class="blog-masthead">
        <div class="container">
          <nav class="nav">
            <a class="nav-link active" href="/ia/">Home</a>
            <!-- <a class="nav-link" href="https://github.com/thales-goncalves">Conheça o projeto</a> -->
           
          </nav>
        </div>
      </div>
<!-- 
      <div class="blog-header">
        <div class="container">
          <h1>TCC</h1>
          <button class="btn btn-danger"></button>
          <button class="btn btn-success"></button>
        </div>
      </div> -->
    </header>
	
	<div>
		<div class="container">
		  <div class="header">
		    <h1 class="text-muted">A Basic Slider</h1>
		  </div>
		
		  <div id="slider">
		    <ul class="slides ">
		      <li class="slide slide1"><img class="mb-1" src="resources/images/slide/1.jpg"></li>
		      <li class="slide slide2"><img class="mb-2" src="resources/images/slide/2.jpg"></li>
		      <li class="slide slide3"><img class="mb-3" src="resources/images/slide/3.jpeg"></li>
		      <li class="slide slide4"><img class="mb-4" src="resources/images/slide/4.jpg"></li>
		      <li class="slide slide5"><img class="mb-5" src="resources/images/slide/5.jpg"></li>
		    </ul>
		  </div>
		  
		  <div class="row text-center">
		  	 <div class="col-md-6 col-sm-6 col-xs-12"> 
		  		 <a href="#" class="btn btn-sm animated-button thar-one">Deslike</a> 
		  	 </div>
		  	 <div class="col-md-6 col-sm-6 col-xs-12"> 
		  	 	<a href="#" class="btn btn-sm animated-button thar-two">Like</a> 
		  	 </div>
         	
		  </div>
		  
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		//using setInterval() to make an image slider

		//function newDate(){
		//console.log(new Date());};
		//setInterval(newDate, 3000);  

		//the above code would console.log the date every 3seconds 

		//$(selector).animate(obj,time,callback);
		//callback-do something after the animation is complete

		$(document).ready(function() {
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

		  function startSlider() {
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

		  startSlider();
		});
		
	});

</script>

</html>