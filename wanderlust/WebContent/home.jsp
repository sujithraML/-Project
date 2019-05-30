<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.aspire.travelexploration.daoimpl.FlightDealsDAO"
	import="java.util.ArrayList"
	import="java.util.List"
	import="java.sql.Date"
	import="com.aspire.travelexploration.manager.FlightManager"
	import="com.aspire.travelexploration.entity.FlightDeal"
	import="com.aspire.travelexploration.manager.FlightDealsManager"
	import="com.aspire.travelexploration.entity.Flight"
	import="com.aspire.travelexploration.enums.FlightE"
	import="com.aspire.travelexploration.manager.FlightManager"
	import="java.util.Iterator"
	import="javax.servlet.http.HttpServletResponse"
	import="javax.servlet.http.HttpSession"
	import="javax.servlet.RequestDispatcher"
	import="java.util.Iterator"
	%>
	<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>homeBootstrap</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<style>
	.sidenav {
	  height: 100%;
	  width: 0;
	  position: fixed;
	  z-index: 1;
	  top: 0;
	  left: 0;
	  background-color: #111;
	  overflow-x: hidden;
	  transition: 0.5s;
	  padding-top: 60px;
	}
	
	.sidenav a {
	  padding: 8px 8px 8px 32px;
	  text-decoration: none;
	  font-size: 25px;
	  color: #818181;
	  display: block;
	  transition: 0.3s;
	}
	
	.sidenav a:hover {
	  color: #f1f1f1;
	}
	
	.sidenav .closebtn {
	  position: absolute;
	  top: 0;
	  right: 25px;
	  font-size: 36px;
	  margin-left: 50px;
	}
	
	@media screen and (max-height: 450px) {
	  .sidenav {padding-top: 15px;}
	  .sidenav a {font-size: 18px;}
	}
	.makeFlex.vrtlCenter {
		    -webkit-box-pack: center;
		    -webkit-justify-content: center;
		    -moz-box-pack: center;
		    -ms-flex-pack: center;
		    justify-content: center;
		}
		.makeFlex {
		    display: -webkit-box;
		    display: -webkit-flex;
		    display: -moz-box;
		    display: -ms-flexbox;
		    display: flex;
		}
	.makeFlex.column, .makeFlex.row {
	    -webkit-box-direction: normal;
	    -moz-box-direction: normal;
	}
	.makeFlex.column {
	    -webkit-box-orient: vertical;
	    -webkit-flex-direction: column;
	    -moz-box-orient: vertical;
	    -ms-flex-direction: column;
	    flex-direction: column;
	}
	/*componenets of footer*/
	.footerLinks ul {
	    width: 180px;
	}
	.appendTop30 {
	    margin-top: 30px;
	}
	.landingContainer {
	    width: 1200px;
	    margin: 0 auto;
	}
	.footer {
      margin-top:40px;
      margin-bottom:40px;
    }
    /* add 5 pixels at the bottom*/
    .appendBottom5 {
	    margin-bottom: 5px;
	}
	 /* add 5 pixels at the right side*/
	.appendRight5 {
    	margin-right: 5px;
	}
	 /* add 5 pixels at the right side*/
	.appendBottom10 {
	    margin-bottom: 10px;
	}
	.footerLinks {
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-box-pack: justify;
	    -webkit-justify-content: space-between;
	    -moz-box-pack: justify;
	    -ms-flex-pack: justify;
	    justify-content: space-between;
	}
	.makeFlex {
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: -ms-flexbox;
	    display: flex;
	}
	.pushRight {
	    margin-left: auto;
	}
	.fswTabs li.selected .tabsCircle {
    	border: 1px solid #000;
    	background: #000;
	}
	.fswTabs li .tabsCircle {
    	width: 12px;
    	height: 12px;
    	-webkit-border-radius: 100%;
    	-moz-border-radius: 100%;
    	border-radius: 100%;
    	border: 1px solid #9b9b9b;
	}
		 /* add 5 pixels at the right side*/
	.appendRight5 {
    	margin-right: 5px;
	}
		 /* add 10 pixels at the bottom*/
	.appendBottom10 {
	    margin-bottom: 10px;
	}
	.fsw_inputBox.dates input, .fsw_inputBox.reDates input {
	    opacity: 0!important;
	    position: absolute;
	    z-index: -1;
	}
	.font20 {
	    font-size: 20px;
	    line-height: 20px;
	}
	.blackText {
	    color: #000;
	}
	.fsw .lbl_input {
	    text-transform: uppercase;
	}
	.fsw .fsw_inputBox.flightTravllers {
	    width: 230px;
	    -webkit-border-radius: 0 10px 10px 0;
	    -moz-border-radius: 0 10px 10px 0;
	    border-radius: 0 10px 10px 0;
	}
	.flightTravllers input {
	    opacity: 0;
	    position: absolute;
	    width: 100%;
	    height: 100%;
	    font-size: 0;
	    top: 0;
	    left: 0;
	    z-index: -1;
	}
	.appendRight10 {
	    margin-right: 10px;
	}
	.tabsCircle {
    	display: inline-block;
	}.fswTabs li.selected {
    	background: #e7e7e7;
    	color: #000;
	}

	.fswTabs li {
    	-webkit-box-align: center;
    	-webkit-align-items: center;
    	-moz-box-align: center;
    	-ms-flex-align: center;
    	align-items: center;
    	text-transform: uppercase;
    	cursor: pointer;
    	margin: 0 10px;
    	padding: 2px 6px;
    	-webkit-border-radius: 20px;
    	-moz-border-radius: 20px;
    	border-radius: 20px;
	}
	user agent stylesheet
		li {
   		 display: list-item;
    	text-align: -webkit-match-parent;
	}

	.latoBlack {
    	font-weight: 800;
	}
	.appendBottom5 {
	    margin-bottom: 5px;
	}
	.latoBold {
	    font-weight: 700;
	}
	.greyText {
   	 	color: #9b9b9b;
	}
	.tabsCircle:after {
    	content: "";
   		display: block;
    	width: 3px;
    	height: 6px;
    	border: solid #fff;
    	border-width: 0 1px 1px 0;
    	-webkit-transform: rotate(45deg);
    	-moz-transform: rotate(45deg);
    	-ms-transform: rotate(45deg);
    	-o-transform: rotate(45deg);
    	transform: rotate(45deg);
    	margin-top: 1px;
    	margin-left: 3px;
	}
	.appendBottom40 {
    	margin-bottom: 40px!important;
	}
	.widgetSection {
	    width: 1200px;
	    margin: 0 auto;
	    position: relative;
	    z-index: 10;
	    -webkit-border-radius: 8px;
	    -moz-border-radius: 8px;
	    border-radius: 8px;
	    -webkit-box-shadow: 0 1px 5px 0 rgba(0,0,0,.1);
	    -moz-box-shadow: 0 1px 5px 0 rgba(0,0,0,.1);
	    box-shadow: 0 1px 5px 0 rgba(0,0,0,.1);
	    background-color: #fff;
	    padding: 50px 20px 0;
	}
	h1, h2, h3, h4, h5, h6, p, ul {
	    margin: 0;
	    list-style: none;
	    padding: 0;
	}
	*, html {
	    -webkit-box-sizing: border-box;
	    -moz-box-sizing: border-box;
	    box-sizing: border-box;
	}
	ul, menu, dir {
	    display: block;
	    list-style-type: disc;
	    margin-block-start: 1em;
	    margin-block-end: 1em;
	    margin-inline-start: 0px;
	    margin-inline-end: 0px;
	    padding-inline-start: 40px;
	}
	body, html {
	    background: #f2f2f2;
	    padding: 0;
	    margin: 0;
	    color: #4a4a4a;
	    font-size: 14px;
	    font-family: lato;
	    font-weight: 400;
	}
	.latoBlack {
	    font-weight: 800;
	}
	.greyText {
	    color: #9b9b9b;
	}
	.fswTabs, .fswTabs li {
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: -ms-flexbox;
	    display: flex;
	}
	.fswTabs {
	    width: 800px;
	}
	.latoBlack {
	    font-weight: 800;
	}
	.greyText {
	    color: #9b9b9b;
	}
	.center{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.lightedpathway{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.poolundersky{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.massagetable{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.wineglasses{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.emptychairsvintage{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.emptychairsbeach{
	background-color: rgba(255, 255, 255, 0.3);
	height: 100%;
	width: 100%;
	}
	.fsw {
	    background: #fff;
	    padding: 11px 0;
	}
	.fsw .fsw_inner, .fsw .fsw_inputBox {
	    display: -webkit-box;
	    display: -ms-flexbox;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: flex;
	    position: relative;
	}
	.fsw .fsw_inner {
	    width: 100%;
	    margin: 0 auto 20px;
	    -webkit-border-radius: 10px;
	    -moz-border-radius: 10px;
	    border-radius: 10px;
	    -webkit-align-items: center;
	    -moz-box-align: center;
	    -webkit-box-align: center;
	    -ms-flex-align: center;
	    align-items: center;
	    border: 1px solid #e7e7e7;
	    z-index: 0;
	}
	
	.fsw_inputBox.searchCity, .widgetSection .fsw .fsw_inputBox.searchToCity {
	    width: 300px;
	    height: 95px;
	    border-right: 1px solid #e7e7e7;
	}
	.widgetSection .fsw .fsw_inputBox.searchToCity {
	    padding-left: 20px;
	    margin-left: -18px;
	}
	.widgetSection .fsw .fsw_inputBox {
	    height: 95px;
	    -webkit-border-radius: 0;
	    -moz-border-radius: 0;
	    border-radius: 0;
	    margin-right: 0;
	    -webkit-transition: all .2s linear;
	    -o-transition: all .2s linear;
	    -moz-transition: all .2s linear;
	    transition: all .2s linear;
	}
	.fsw .fsw_inputBox {
	    background: hsla(0,0%,100%,.1);
	    -webkit-box-orient: vertical;
	    -webkit-box-direction: normal;
	    -ms-flex-direction: column;
	    -webkit-flex-direction: column;
	    -moz-box-orient: vertical;
	    -moz-box-direction: normal;
	    flex-direction: column;
	}
	.fsw_inputBox.dates, .fsw_inputBox.reDates {
	    height: 95px;
	    border-right: 1px solid #e7e7e7;
	}
	.fsw_inputBox.dates {
	    width: 157px;
	}
	.fsw .fsw_inner, .fsw .fsw_inputBox {
	    display: -webkit-box;
	    display: -ms-flexbox;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: flex;
	    position: relative;
	}
	.widgetSection .fsw .fsw_inputBox label {
	    padding: 10px 20px;
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-box-orient: vertical;
	    -webkit-box-direction: normal;
	    -webkit-flex-direction: column;
	    -moz-box-orient: vertical;
	    -moz-box-direction: normal;
	    -ms-flex-direction: column;
	    flex-direction: column;
	    cursor: pointer;
	}
	user agent stylesheet
	input {
	    padding: 1px 0px;
	}
	user agent stylesheet
	input {
	    -webkit-appearance: textfield;
	    background-color: white;
	    -webkit-rtl-ordering: logical;
	    cursor: text;
	    padding: 1px;
	    border-width: 2px;
	    border-style: inset;
	    border-color: initial;
	    border-image: initial;
	}
	user agent stylesheet
	input, textarea, select {
	    text-rendering: auto;
	    color: initial;
	    letter-spacing: normal;
	    word-spacing: normal;
	    text-transform: none;
	    text-indent: 0px;
	    text-shadow: none;
	    display: inline-block;
	    text-align: start;
	    margin: 0em;
	    font: 400 13.3333px Arial;
	}
	user agent stylesheet
	input, textarea, select, button, meter, progress {
	    -webkit-writing-mode: horizontal-tb !important;
	}
	.swipIcon {
	    width: 15px;
	    height: 11px;
	    background-position: -149px -111px;
	}
	
	.landingSprite {
	    background: url(http://imgak.mmtcdn.com/pwa_v3/pwa_commons_assets/desktop/landingSprite.png) no-repeat;
	    display: inline-block;
	    -webkit-background-size: 200px 500px;
	    -moz-background-size: 200px 500px;
	    -o-background-size: 200px 500px;
	    background-size: 200px 500px;
	    font-size: 0;
	    -webkit-flex-shrink: 0;
	    -ms-flex-negative: 0;
	    flex-shrink: 0;
	}
		.swipCircle {
	    width: 40px;
	    height: 40px;
	    -webkit-flex-shrink: 0;
	    -ms-flex-negative: 0;
	    flex-shrink: 0;
	    margin-left: -22px;
	    -webkit-border-radius: 100%;
	    -moz-border-radius: 100%;
	    border-radius: 100%;
	    background: #fff;
	    display: -webkit-box;
	    display: -webkit-flex;
	    display: -moz-box;
	    display: -ms-flexbox;
	    display: flex;
	    -webkit-box-align: center;
	    -webkit-align-items: center;
	    -moz-box-align: center;
	    -ms-flex-align: center;
	    align-items: center;
	    -webkit-box-pack: center;
	    -webkit-justify-content: center;
	    -moz-box-pack: center;
	    -ms-flex-pack: center;
	    justify-content: center;
	    -webkit-box-shadow: 0 1px 30px 0 rgba(0,0,0,.1);
	    -moz-box-shadow: 0 1px 30px 0 rgba(0,0,0,.1);
	    box-shadow: 0 1px 30px 0 rgba(0,0,0,.1);
	    z-index: 1;
	    cursor: pointer;
	}
		.minHeight70 {
	    	min-height: 70px;
	}
		p {
		    display: block;
		    margin-block-start: 1em;
		    margin-block-end: 1em;
		    margin-inline-start: 0px;
		    margin-inline-end: 0px;
		}
		.makeFlex.vrtlCenter {
		    -webkit-box-pack: center;
		    -webkit-justify-content: center;
		    -moz-box-pack: center;
		    -ms-flex-pack: center;
		    justify-content: center;
		}
		.makeFlex {
		    display: -webkit-box;
		    display: -webkit-flex;
		    display: -moz-box;
		    display: -ms-flexbox;
		    display: flex;
		}
	.makeFlex.column, .makeFlex.row {
	    -webkit-box-direction: normal;
	    -moz-box-direction: normal;
	}
	.makeFlex.column {
	    -webkit-box-orient: vertical;
	    -webkit-flex-direction: column;
	    -moz-box-orient: vertical;
	    -ms-flex-direction: column;
	    flex-direction: column;
	}
	.footerLinks ul {
	    width: 180px;
	}
	.font12 {
	    font-size: 12px;
	    line-height: 12px;
	}
		.widgetSection .widgetSearchBtn {
	    width: 216px;
	    padding: 10px;
	    margin-bottom: -32px;
	}
	a.primaryBtn {
	    color: #fff;
	}
	.primaryBtn {
	    -webkit-border-radius: 34px;
	    -moz-border-radius: 34px;
	    border-radius: 34px;
	    background-image: -webkit-linear-gradient(354deg,#53b2fe,#065af3);
	    background-image: -moz-linear-gradient(354deg,#53b2fe,#065af3);
	    background-image: -o-linear-gradient(354deg,#53b2fe,#065af3);
	    background-image: linear-gradient(96deg,#53b2fe,#065af3);
	    -webkit-box-shadow: 0 1px 7px 0 rgba(0,0,0,.2);
	    -moz-box-shadow: 0 1px 7px 0 rgba(0,0,0,.2);
	    box-shadow: 0 1px 7px 0 rgba(0,0,0,.2);
	    display: inline-block;
	    -webkit-flex-shrink: 0;
	    -ms-flex-negative: 0;
	    flex-shrink: 0;
	    color: #fff;
	    text-transform: uppercase;
	    font-weight: 900;
	    cursor: pointer;
	    outline: 0;
	    border: 0;
	    text-align: center;
	}
	.latoBlack {
	    font-weight: 800;
	}
	.font24 {
	    font-size: 24px;
	    line-height: 24px;
	}
	a, a:focus, a:hover {
	    text-decoration: none;
	}
	a {
	    color: #008cff;
	    cursor: pointer;
	}
	label {
	    cursor: default;
	}
	.fsw .lbl_input {
	    text-transform: uppercase;
	}
	
	
	.fsw_inputBox .lineHeight36 {
	    line-height: 36px;
	}
	.fsw .fsw_inputField {
	    border: 0;
	    outline: 0;
	    background: none;
	    min-width: 140px;
	    max-height: 33px;
	    cursor: pointer;
	}
	.fsw_inputBox input {
	    font-family: lato;
	}
	.font30 {
	    font-size: 30px;
	    line-height: 30px;
	}
	.reg {
	  display:none;
	}
	.log{
	  display:none;
	}
	.stylish-form1 
    { 
      background-image:url('https://images.pexels.com/photos/721169/pexels-photo-721169.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'); 
      padding:10px;
    }
    .stylish-form2 
    { 
      background-image:url('https://images.pexels.com/photos/721169/pexels-photo-721169.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'); 
      padding:10px;
    }
    .inside-form h1 {
      color:#ffffff;
      margin-top:50px;
	  font-size: 150%;
    }
    .font_white {
      color:#fff !important;
    }
    .mar20 
    {
      margin:20px;
    }
    .inner-section {
      background-color:#9C33FF;
      width:350px;
      display:block;
      margin:0 auto;
      float:right;
    }
    .inside-form{
      border-radius:8px;
      padding-top:30px;
      padding-bottom:30px;
    }
    .inside-form h2 {
      font-weight:700;
    }
    .inside-form ul {
      list-style-type:none;
      text-align:center;
      margin-top:30px;
    }
    .inside-form ul >li {
      display:inline-block;
    }
    .inside-form ul >li > i {
      margin-top:18px;
    }

    .dsp-flex {
      display: -webkit-flex; 
      align-items: center;
      -webkit-align-items: center;
      justify-content: center
    }
    .input-group, .form-group {
      margin-bottom: 10px;
    }
    .input-group-addon {
      background-color: rgba(255, 255, 255, 0.1);
      border: none;
      color: #FFFFFF;
      border-radius:25px;
    }
    .form-control,.form-control:focus,.form-control:hover
    {
      background-color: rgba(255, 255, 255, 0.1);
      color: #FFFFFF;
      border-radius:25px;
      border:none;
      font-size:14px;
    }
    ::-webkit-input-placeholder { 
      color: #fff !important;
    }

    .footer {
      margin-top:40px;
      margin-bottom:40px;
    }
    input::placeholder {
      color: #fff !important;
    }
    .btn-lg {
      font-size: 1em;
      border-radius: 0.25rem;
      padding: 15px 48px;
    }
    .btn-round {
      border-width: 1px;
      border-radius: 30px !important;
      padding: 11px 23px;
    }
    .btn-neutral,.btn-neutral:focus,.btn-neutral:hover {
      background-color: #FFFFFF;
      color: #f96332;
    }
    
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
	.nav .list {
	  float: right;
	  margin: 0;
	}
	.nav .list > li {
		  float: left;
		  list-style: none;
		}
	.nav .list > li > a {
		  color: #555;
		  text-decoration: none;
		  display: block;
		  line-height: 60px;
		  padding: 0 10px;
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
	    	<ul class="list">
	      		<li><a href="#"><button class="btn btn-info" onClick=signup_t() name="btnsignup" style="margin-top: 8px">Create a new Account</button></a></li>
	      		<li><a href="#"><button class="btn btn-info" onClick=login_t() name="btnlogin" style="margin-top: 8px">Login</button></a></li>
	   	    </ul>
	   	 </div>   
 		</div>
 	</nav>
</header>
 		<div id="mysignup" class="reg">
		 <script src="https://use.fontawesome.com/1dec14be15.js"></script>
		    <div class="container-fluid stylish-form1">
		      <div class="row mar20" >
		        <div class="col-md-12 col-sm-12 col-xs-12">
		          <div class="inner-section">
		            <form name="form" method="post" action="registration" onsubmit="return check_pwd(this)";>
		              <div class="mar20 inside-form">
		               <h1 class= "font_white text-center">Be a travel Influencer</h1>
		                <h2 class="font_white text-center">Join Us</h2>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-pencil"></i></span>
		                  <input id="name" name="name" type="text" class="form-control"  pattern="[A-Za-z]{3,}" title="3 to 20 characters" placeholder="First Name" required autocomplete="off">
		                </div>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-pencil"></i></span>
		                  <input id="username" name="username" type="text" class="form-control" pattern="{3,}" title="3 to 20 characters" placeholder="User Name" required autocomplete="off">
		                </div>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
		                  <input id="email" name="email" type="email" class="form-control" placeholder="Your Email"pattern="[a-z0-9]+@gmail.com" title="enter valid gmail account not exceeding 40 charaters" required autocomplete="off">
		                </div>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-lock"></i></span>
		                  <input id="password" name="password" type="password" class="form-control"  pattern="{8,}" title="Eight or more characters" placeholder="Set a Password" required autocomplete="off">
		                </div>
		                 <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-lock"></i></span>
		                  <input id="passwordduplicate" name="passwordduplicate" type="password" class="form-control"  pattern="{8,}" title="Eight or more characters" placeholder="Re-enter Password" required autocomplete="off">
		                </div>
		                 <div class="footer text-center">
		                  <input type="submit" value="Get Started"class="btn btn-neutral btn-round btn-lg">
		                 </div>
		              </div><!-- mar20 inside-form -->
		            </form>
		          </div><!-- inner-section -->
		        </div><!-- col-md-12 col-sm-12 col-xs-12 -->
		      </div><!--row mar20-->
		    </div><!--container-fluid stylish-form-->
 		</div>
 		<div id="mylogin" class="log">
 		<script src="https://use.fontawesome.com/1dec14be15.js"></script>
		    <div class="container-fluid stylish-form2">
		      <div class="row mar20" >
		        <div class="col-md-12 col-sm-12 col-xs-12">
		          <div class="inner-section">
		            <form name="form" method="post" action=login_controller>
		              <div class="mar20 inside-form">
		                <h2 class="font_white text-center">Welcome Back!</h2>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-pencil"></i></span>
		                  <input id="username" name="username" type="text" class="form-control" pattern="{3,}" title="three or more characters" placeholder="User Name" required autocomplete="off">
		                </div>
		                <div class="input-group">
		                  <span class="input-group-addon"><i class="fa fa-lock"></i></span>
		                  <input id="password" name="password" type="password" class="form-control"  pattern="{8,}" title="Eight or more characters" placeholder="Set a Password" required autocomplete="off">
		                </div>
		                 <div class="footer text-center">
		                  <input type="submit" value="Dive In"class="btn btn-neutral btn-round btn-lg">
		                 </div>
		              </div><!-- mar20 inside-form -->
		            </form>
		          </div><!-- inner-section -->
		        </div><!-- col-md-12 col-sm-12 col-xs-12 -->
		      </div><!--row mar20-->
		    </div><!--container-fluid stylish-form-->
 		</div>
 	 <div class="makeFlex">
   	  <ul class="fswTabs latoBlack greyText">
	    <li class="selected">
	     <span class="tabsCircle appendRight5">
	     
	     </span>
	     "Oneway"
	    </li>
	    <li>
	     <span class="tabsCircle appendRight5">
	     
	     </span>
	     "RoundTrip"
	    </li>
	    <li>
	     <span class="tabsCircle appendRight5">
	     
	     </span>
	     "Multi-city"
	    </li>
   	  </ul>
   	 </div>
   	<div id="navbar" class="sidenav" >
   	   <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	   	 <a href="/wanderlust/ViewTickets">Tickets</a>
	   	 <a href="/wanderlust/select_packages">TourPackages</a>
	   	 <a href="trips.jsp">Trips</a>
   	</div>
   	<span style="font-size:30px;cursor:pointer" onClick="openNav()">&#9776;Navigate</span>
  	<div class="form-group">
  	 <form action="select_flights" method="post" >
  	  <span class="dropdown appendTop30 appendRight5">
  	   <label>From</label>
	   <select name="from" class="btn btn-Light dropdown-toggle .form-control"  type="button" id="element1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	     From
	      <div class="dropdown-menu"  aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item" value="BOM" >BOM Mumbai  Chatrapati Shivaji International Airport</option>
	       <option class="dropdown-item" value="DEL" >DEL Delhi Indira Gandhi International Airport</option>
	       <option class="dropdown-item" value="BKK" >BKK Bangkok Suvarnabhumi Airport</option>
	       <option class="dropdown-item" value="BLR" >BLR Bangalore Bengaluru International Airport</option>
	       <option class="dropdown-item" value="PNQ" >PNQ Pune Airport</option>
	       <option class="dropdown-item" value="HYD" >HYD Hyderabad Rajiv Gandhi International Airport</option>
	   </select>
	  </span>
	  <span class="dropdown appendRight5">
	  <label>To</label>
	   <select name="to" class="btn btn-Light dropdown-toggle .form-control"  type="button" id ="element2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      To
	      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item" value="BOM">BOM Mumbai  Chatrapati Shivaji International Airport</option>
	       <option class="dropdown-item" value="DEL">DEL Delhi Indira Gandhi International Airport</option>
	       <option class="dropdown-item" value="BKK">BKK Bangkok Suvarnabhumi Airport</option>
	       <option class="dropdown-item" value="BLR">BLR Bangalore Bengaluru International Airport</option>
	       <option class="dropdown-item" value="PNQ">PNQ Pune Airport</option>
	       <option class="dropdown-item" value="HYD">HYD Hyderabad Rajiv Gandhi International Airport</option>
	   </select>
	  </span>
	  
	  <input id="date" type="date" name="departure" required>
	  
	  	  <span class="dropdown appendRight5">
	   <select name="class" class="btn btn-Light dropdown-toggle .form-control" type="button" id ="element2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      Class
	      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item" value="ECONOMY">ECONOMY</option>
	       <option class="dropdown-item" value="BUSINESS">BUSINESS</option>
	       <option class="dropdown-item" value="PREMIUMECONOMY">PREMIUMECONOMY</option>
	       <option class="dropdown-item" value="FIRSTCLASS">FIRSTCLASS</option>
	   </select>
	   <input name="hidden_guest" hidden >
	  </span>
	 	<button type="submit" onClick="check_location()" class="btn btn-info">Search</button>

  	 </form>
	</div>
 	
 	<div>
 	<%
 	if(request.getAttribute("flights")!=null){
 		List <Object> flights=new ArrayList<Object>();
 		
 		flights=(List <Object>) request.getAttribute("flights");
 	
 	%>
 	<table class="table">
 	<tr>
 		<th>Flight Id </th>
 		<th>airLineName </th>
 		<th>from </th>
 		<th>To </th>
 		<th>departureTime</th>
 		<th>arrivalTime </th>
 		<th>duration </th>
 		<th>baggageAllowance </th>
 		<th>flightClass </th>
 		<th>price </th>
 		<th>availableSeats </th>
 	</tr>
 	
 	<%! int i=0; %>
 	<%
		Iterator <Object> iterator=(Iterator<Object>)flights.iterator();
 	while(iterator.hasNext()){
 	 	Flight flight=new Flight();
 		flight=(Flight)iterator.next();
 		++i;
			%>
			<tr>
				<td><%= i %></td>
				<td><%=flight.getFlightId() %> </td>
				<td><%=flight.getAirLineName() %> </td>
				<td><%=flight.getFromLocation() %> </td>
				<td><%=flight.getToLocation() %> </td>
				<td><%=flight.getDepartureTime() %> </td>
				<td><%=flight.getArrivalTime() %> </td>
				<td><%=flight.getDuration() %> </td>
				<td><%=flight.getBaggageAllowance() %> </td>
				<td><%=flight.getFlightClass() %> </td>
				<td><%=flight.getPrice() %> </td>
				<td><%=flight.getAvailableSeats() %> </td>
				<td>
		<% if(session.getAttribute("userid")!=null ) 
	  {
	  %> 
					 <span>
						<button class="btn btn-info" onClick="openBooking('<%=flight.getFlightId() %>','<%=i%>')">Book</button>
					 </span>
	 	 <% 
	 	 } %>
				</div>
				</td>
			</tr>
	<%	
		 }
 	i=-1;
 	}
 	%>	
 	</table>
  	 <form style="display: none" id="booking" action="TicketBooking" method="post">
  	 <span>
	  	  <div id="passengers">
	  	   <input type="text" hidden name="flightid" id="flightid" value="Flight Not Selected" >
	  	   <input type="text" hidden name="number" id="number" value="serial no" >
	  	   <label>Passenger Name:</label>
	 	   <input type="text" name="passenger" placeholder="passengername..." required>
	  	  </div>
	 </span>
	 <span><button class="btn btn-dark" type="button" onClick="javascript:add_fields();">Add more</button></span>
	 <span> <button class="btn btn-dark" type="submit" >Continue Booking</button></span>
  	 </form>	
 	</div>
 	
 	  	<!--<img class=center" alt="home" src="https://images.pexels.com/photos/672358/pexels-photo-672358.jpeg?auto=compress&cs=tinysrgb&h=650&w=940">
<img class="emptychairsvintage" src="https://images.pexels.com/photos/1579739/pexels-photo-1579739.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	<img class="emptychairsbeach" src="https://images.pexels.com/photos/988508/pexels-photo-988508.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	<img class="lightedpathway" alt="hotel1" src="https://images.pexels.com/photos/573552/pexels-photo-573552.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	<img class="poolundersky" alt="resort1" src="https://images.pexels.com/photos/189296/pexels-photo-189296.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	<img class="massagetable" alt="resort2" src="https://images.pexels.com/photos/1531672/pexels-photo-1531672.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	<img class="wineglasses" alt="hotel2" src="https://images.pexels.com/photos/941861/pexels-photo-941861.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
  	  -->
  	  
  	<footer class="appendTop30">
 <div class="landingContainer">
  <div class="makeFlex appendBottom40 footerLinks">
   <ul class="makeFlex column font12">
    <li class="appendBottom10">
     <span class="latoBlack darkGreyText font10 captext"> Service Offering </span>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Flight Deals</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Flights</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Tour Packages </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Holidays in India </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> International holidays </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Cheap tickets to India </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Flight Status </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Route planner </a>
    </li>
     <li class="appendBottom5">
     <a class="darkGreyText"> Mobile Apps </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Cabs </a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText"> Rails </a>
    </li>
   </ul>
   <ul class="makeFlex column font12">
    <li class="appendBottom10">
     <span class="latoBlack darkGreyText font10 capText">About the Site</span>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Complaints</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Contact Us</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Payment Security</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Privacy Policy</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">User Agreement</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Visa Information</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">More Offices</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">File Rail TDR</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Make A Payment</a>
    </li>
    <li class="appendBottom5">
     <a class="darkGreyText">Submit Account Details</a>
    </li>
   </ul>
   <ul class="makeFlex column font12">
    <li class="appendBottom10"><span class="latoBlack darkGreyText font10 capText">More Links</span></li>
    <li class="appendBottom5"><a class="darkGreyText">Low Budget Holidays</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Delhi Mumbai Flights</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Domestic Airlines</a></li>
    <li class="appendBottom5"><a class="darkGreyText">International Airlines</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Indigo</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Spicejet</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Jet Airways</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Air Asia</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Air India</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Delhi Hotels</a></li>
    <li class="appendBottom5"><a class="darkGreyText">Mumbai Hotels</a></li>
  </div>
 </div>
</footer>
	<script type="text/javascript">
	function signup_t(){
		var x = document.getElementById("mysignup");
		  if (x.style.display === "block") {
		    x.style.display = "none";
		  } else {
		    x.style.display = "block";
		  }
	}
	function login_t(){
		var x = document.getElementById("mylogin");
		  if (x.style.display === "block") {
		    x.style.display = "none";
		  } else {
		    x.style.display = "block";
		  }
	}
	function check_pwd(form){
		var pwd1 = document.getElementById("password");
		var pwd2 = document.getElementById("passwordduplicate");
		if(!pwd1.equals(pwd2)){
			alert("Passwords did not match")
			form.password.focus();
			return false;
		}
	}
	function check_location(){
		var a = document.getElementById("element1");
		var b = document.getElementById("element2");
		var from=a.options[a.selectedIndex].value;
		var to=b.options[b.selectedIndex].value;
		if(a == b){
			alert("choose different airports");
		}			
	}
	function openBooking(flightid, i){
		document.getElementById("flightid").value=flightid;
		document.getElementById("number").value=i;
	  document.getElementById("booking").style.display="block";
	  
	}
	function openNav() {
	  document.getElementById("navbar").style.width = "250px";
	}
	function closeNav() {
	  document.getElementById("navbar").style.width = "0";
	}
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear();
	
	if (dd < 10) {
	  dd = '0' + dd;
	}
	
	if (mm < 10) {
	  mm = '0' + mm;
	}
	
	today = yyyy + '-' +mm + '-' + dd ;
	var a= document.getElementById("date");
	a.setAttribute("min",today);
	</script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>