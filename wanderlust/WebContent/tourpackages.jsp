<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.aspire.travelexploration.entity.TourPackage"
    import="java.util.ArrayList"
	import="java.util.List"
	import="java.util.Iterator"
	import="java.lang.StringBuffer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tour packages</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="userprofile.css">
</head>
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
$blue: #2B2F3F
$pinkish: #C68587
$reddish: #BA4773

html {
  background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/176026/noise.png)
  background-color: #fff
  }
.avatar{
  float: left
  display: inline-block
  overflow: hidden
  width: 10vw
  height: 10vw
  border-radius: 100%
  background: $pinkish
  border: 6px solid #B3C9CB
  background-image: url(https://scontent-vie1-1.cdninstagram.com/hphotos-ash/t51.2885-19/10932224_821299211264682_1488190390_a.jpg)
  background-size: cover
  background-position: 50% 25%
  -webkit-transition: border 0.5s linear
  -moz-transition: border 0.5s linear
  -o-transition: border 0.5s linear
  transition: border 0.5s linear
 }   
  &:after{
    content: ""
    position: absolute
    background: -webkit-gradient(linear, left top, right bottom, color-stop(0%,rgba(240,227,199,1)), color-stop(100%,rgba(107,202,180,1)))
    width: 10vw
    height: 10vw
    border-radius: 100%
    border: 1px solid white
    left: 4px
    top: 4px
    opacity: 0
    -webkit-transition: opacity 0.3s linear
    -moz-transition: opacity 0.3s linear
    -o-transition: opacity 0.3s linear
    transition: opacity 0.3s linear
    cursor: pointer
    -webkit-transform-style: preserve-3d
  }  
.avatar:hover:after{opacity: 0.7}
.avatar.open:hover:after{opacity: 0}
.container{
  text-align: center
  left: 50%
  -webkit-transform: translate3d(-50%,-50%,0)
  -moz-transition: translate3d(-50%,-50%,0)
  -o-transition: translate3d(-50%,-50%,0)
  transition: translate3d(-50%,-50%,0)
  position: absolute
  top: 50%
  }
#camera{
  -webkit-transform: scale(0.4)
  position: relative
  z-index: 9999
  cursor: pointer
  top: 18%
  overflow: hidden
  }

#circle{
  -webkit-transform: scale(0.75)
  -webkit-transform-origin: 50% 50%
  -webkit-transition: all 0.3s linear
  stroke-dashoffset: 33px
  stroke-dasharray: 33px
  }
#cameraFrame{
  -webkit-transition: all 0.5s linear
  stroke-dashoffset: 72px
  stroke-dasharray: 72px
  }
#plus{
  -webkit-transition: all 0.3s linear
  stroke-dashoffset: 5px
  stroke-dasharray: 5px
 } 
#fileUpload{
  overflow: hidden
  position: absolute
  width: 70px
  padding: 10px
  opacity: 0
  left: 50%
  top: 70%
  -webkit-transform: translate3d(-50%,-50%,0)
  z-index: 9999
  -webkit-transition: 250ms cubic-bezier(.7,0,.36,1)
  transition: 250ms cubic-bezier(.7,0,.36,1)
  &:focus
    outline: none
    background: transparent
    }
#openModal {  
  width: 100%
  height: 100%
  position: absolute
  left: 0
  top: 0
  border-radius: 100%
  -webkit-transform: scale(0)
  z-index: 8888
  -webkit-transition: 250ms cubic-bezier(.7,0,.36,1)
  transition: 250ms cubic-bezier(.7,0,.36,1)
  -webkit-transition-delay: 250ms
  transition-delay: 250ms
  background-color: rgba(255,255,255,0.9)
}  
#openModal{
  > span
    font-family: raleway
    font-size: 1.2vw
    top: 40%
    position: absolute
    left: 50%
    white-space: nowrap
    -webkit-transform: translate3d(-50%,0,0)
    color: rgba(0,0,0,0.7)
    }
.separatorLine{
  margin-top: 15px
  width: 300%
  position: absolute
  height: 1px
  background: rgba(0,0,0,0.6)
  }
.clearfix:after {
  clear: both
  content: "."
  display: block
  height: 0
  visibility: hidden
}
.clearfix {  display: inline-block	}

.clearfix{  display: block }
.right{
  margin-left: 12.5vw
  bottom: 0
  position: absolute
  float: right
  }
.right > p{
  font-size: 2vw
  text-align: left
  text-transform: none
  font-family: Raleway
  margin-top: 0.5vw
  color: rgba(0,0,0,0.7)
  &:last-child
    margin-top: 0.2vw
    font-size: 0.9vw
    text-align: right
    color: rgba(0,0,0,0.5)
   }    
.avatar:hover{
  > #camera 
    > #cameraFrame
      stroke-dashoffset: 0
}
.avatar:hover{
  > #camera 
    > #circle
      stroke-dashoffset: 0px
}
.avatar:hover{
  > #camera 
    > #plus
      stroke-dashoffset: 0px
 }     
.avatar:active{
  > #camera
    > #cameraFrame
      -webkit-transition: none
      stroke: rgba(255,255,255,0.7)
}
.avatar:active{
  > #camera
    > #circle
      -webkit-transition: none
      stroke: rgba(255,255,255,0.7)
}
.avatar:active{
  > #camera
    > #plus
      -webkit-transition: none
      stroke: rgba(255,255,255,0)
}
.src{
  font-family: raleway
  position: absolute
  display: inline-block
  right: 0
  bottom: 0
  padding: 10px
  }
#camera{
  -webkit-transition: 250ms cubic-bezier(.7,0,.36,1)
  transition: 250ms cubic-bezier(.7,0,.36,1)
  }
.avatar.open{
  > #camera
    -webkit-transform: scale(0)
    fill: white
    }
.avatar.open{
  > #openModal
    -webkit-transform: scale(0.95)
    }
.avatar.open{
  > #fileUpload
    opacity: 1
    -webkit-transition-delay: 250ms
    }
.avatar.open{
  > #camera
    visibility: hidden
}  	 </style>
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
 	</nav>
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
</header>
</body>
<h3>Filter</h3>
 <form  action="SelectPackageCountry" method="post">
	 <span class="dropdown appendRight5">
	   <select name="country" class="btn btn-Light dropdown-toggle .form-control"  type="button" id ="element1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item" >Singapore</option>
	       <option class="dropdown-item" >China</option>
	       <option class="dropdown-item" >Thailand</option>
	       <option class="dropdown-item" >Japan</option>
	       </div>
	   </select>
	   	 	<button type="submit" class="btn btn-dark">Country</button>
	  </span>
</form>
 <form  action="SelectPackagesByType" method="post">
 	  <span class="dropdown appendRight5">
	   <select name="package_type" class="btn btn-Light dropdown-toggle .form-control"  type="button" id ="element2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item">Friends</option>
	       <option class="dropdown-item">Family</option>
	       <option class="dropdown-item">Business</option>
	       </div>
	   </select>
	    <button class="btn btn-dark" >Package Type</button>
	  </span>
 </form>
<form  action="SelectPackageByPrice" method="post">

  	  <span class="dropdown appendRight5">
	   <select name="price" class="btn btn-Light dropdown-toggle .form-control"  type="button" id ="element3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	       <option class="dropdown-item" >less than 20000</option>
	       <option class="dropdown-item" >less than 30000</option>
	       <option class="dropdown-item" >less than 40000</option>
	       <option class="dropdown-item" >less than 50000</option>
	       <option class="dropdown-item" >less than 70000</option>
	       </div>
	   </select>
	     <button class="btn btn-dark"  >Price</button>
	  </span>
</form>
<table class="table">
 	<tr>
 		<th>TagLine</th>
 		<th>AgencyName</th>
 		<th>Place</th>
 		<th>Days</th>
 		<th>Nights</th>
 		<th>PackageType</th>
 		<th>Price</th>
 	</tr>
	<%
	List<Object> tourPackages=new ArrayList<Object>();
	tourPackages=(List<Object>)request.getAttribute("tour_packages");
		Iterator <Object> iterator=(Iterator<Object>) tourPackages.iterator();
		while(iterator.hasNext()){
			TourPackage tourPackage=(TourPackage)iterator.next();
		%>
			<tr>
				<td><%=tourPackage.getTagline1() %></td>
				<td><%=tourPackage.getAgency_name()%></td>
				<td><%=tourPackage.getPlace() %></td>
				<td><%=tourPackage.getDays() %></td>
				<td><%=tourPackage.getNights() %></td>
				<td><%=tourPackage.getPackage_type() %></td>
				<td><%=tourPackage.getPricing() %></td>
				<td><button onClick="openPackage('<%=tourPackage.getPackage_id()%>')">view</button></td>
			</tr>
	<%
	}
	%>
	

	<div>
		<form id="hidden_details" style="display:none" >
		  <input type="hidden"  name="packageId" id="packageId" value="Flight Not Selected" >
		  <%StringBuffer string=new StringBuffer("<script>document.getElementById('packageId').value</script>");
	while(iterator.hasNext()){
		TourPackage tourPackage=(TourPackage)iterator.next();
		if(tourPackage.getPackage_id()==Integer.parseInt(string.toString())){
		%>
		 	<table class="table">
 	<tr>
 		<th>Country</th>
 		<th>itinerary</th>
 		<th>Period of package </th>
 		<th>Holiday Type </th>
 	</tr>
			<table  class="table">
					<tr>
					<%if(string!=null){ %>
						<td><%=string %>
					<%} %>
						<td><%=tourPackage.getCountry() %></td>
						<td><%=tourPackage.getItinerary() %></td>
						<td><%=tourPackage.getPeriod_of_Package() %></td>
						<td><%=tourPackage.getHoliday_type() %></td>
						<td><button onClick="reDirect()">Book flights</button></td>
					</tr>
		<%
			}
		}
		%>
						</table>
		</form>
	</div>
  	
<script>
function openPackage(packageId){
		document.getElementById("packageId").value=packageId;
		document.getElementById("hidden_details").style.display="block";
	}
function reDirect(){
		<%response.sendRedirect("userpage.jsp");%>
}
</script>
<script>	
# Display the images to be uploaded.
$('#photos').on 'change', (e) ->
  multiPhotoDisplay(this);

@readURL = (input) ->
  #
  # Read the contents of the image file to be uploaded and display it.
  #
  if (input.files && input.files[0])
    reader = new FileReader()

    reader.onload = (e) ->
      $('.image_to_upload').attr('src', e.target.result)
      $preview = $('.preview')
      if $preview.hasClass('hide')
        $preview.toggleClass('hide');

    reader.readAsDataURL(input.files[0]);
    
multiPhotoDisplay = (input) ->
  #
  # Read the contents of the image file to be uploaded and display it.
  #
  if (input.files && input.files[0])
    for file in input.files
      reader = new FileReader()

      reader.onload = (e) ->
        image_html = """<li><a class="th" href="#{e.target.result}"><img width="75" src="#{e.target.result}"></a></li>"""

        $('#photos_clearing').append(image_html)

        if $('.pics-label.hide').length != 0
          $('.pics-label').toggle('hide').removeClass('hide')

        $(document).foundation('reflow')

      reader.readAsDataURL(file)

    window.post_files = input.files
    if window.post_files != undefined
      input.files = $.merge(window.post_files, input.files)
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>