<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.io.IOException"
	import="java.sql.SQLException"
	import="java.io.PrintWriter"

	import="javax.servlet.ServletException"
	import="javax.servlet.http.HttpServlet"
	import="javax.servlet.http.HttpServletRequest"
	import="javax.servlet.http.HttpServletResponse"
	import="java.util.ArrayList"
	import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<style>
	 .container:after, .container:before {
	  content: "";
	  display: block;
	  clear: both;
	}
	 .nav {
	  background-color: #f8f8f8;
	  border-bottom: 1px solid #ececec;
	  min-height: 50px;
	  height: auto;
	}
	.nav .nav-heading {float: left}
	.nav .nav-heading > a {
	  text-decoration: none;
	  color: #000;
	  line-height: 60px;
	  font-weight: 400;
	  font-size: 19px;
	}
	.user-avatar {
	  display: inline-block;
	  float: right;
	  width: 64px;
	  height: 64px;
	  border-radius: 50%;
	  background-size: cover;
	  color: white;
		  &.-large {
		    width: 64px;
		    height: 64px;
		  }
  	 }
 	</style>
</head>
<body>
 <header>
  	 <nav class="nav">
   	   <div class="container">
	   		<div class="nav-heading">
	        <a class="brand" href="#">Wanderlust</a>
	   		</div>
	   	  <div class="menu">
	   	 </div>   
 	   </div>
 	     <div class="col-md-12">
 	   <div class="container clearfix">
 	    <div class="user-avatar -large" style="background-image: url(https://cdn2.vectorstock.com/i/1000x1000/30/46/traveler-or-tourist-avatar-icon-image-vector-15543046.jpg)">
		 <input id="fileUpload" type="file" />
		  <svg version=1.1 id="camera" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x=0px y=0px viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space= "preserve" width="100" height="100">
			<defs>
			  <pattern id="image">
			     <path id="cameraFrame" fill="none" stroke="white" stroke-miterlimit="10"
			      d="M23.1,14.1H1.9c-0.6,0-1-0.4-1-1V1.9c0-0.6,0.4-1,1-1h21.2 c0.6,0,1,0.4,1,1v11.3C24.1,13.7,23.7,14.1,23.1,14.1z"/>
			    	<g id="plus">
				     <path id="circle" fill="none" id="plusLine" class="line" stroke="#ffffff" stroke-linecap="round" stroke-miterlimit="10" 
				     d="M17.7,7.5c0-2.8-2.3-5.2-5.2-5.2S7.3,4.7,7.3,7.5s2.3,5.2,5.2,5.2 S17.7,10.3,17.7,7.5z"/>
				     <path fill="none" class="line"stroke="#ffffff" stroke-linecap="round" stroke-miterlimit="10" d="M18.7,4.6h4.4"/>
			        </g>
		 </svg>
		 <div id="openModal">
		  <span>Drop here or</span>
		 </div>
 	    </div>
	   </div> 
	  </div>
 	 </nav>
 </header>
 <%  %>
</body>
</html>