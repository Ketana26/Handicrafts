
<%@include file="links.jsp" %>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      margin: auto;
      height:400px;
  }
   .carousel-control.left, .carousel-control.right {
  background-image: none;opacity:0.4;
}
  </style>
</head>

<body>
<%@ include file="navbar.jsp" %>
<c:if test="${signupmsg!=null}">
		<div class="container">
			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-success alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">�</a>
					${signupmsg}
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${errormessage!=null}">
		<div class="container">
			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">�</a>
					${errormessage}
				</div>
			</div>
		</div>
	</c:if>

	<div class="container">
		<div class="col-sm-3" style="background-color: #39c6c6;border-radius:15px; padding-bottom:10px"">
			<div align="center" style="color: blue; font-size: 30px">
				<b>LoginPage</b>
			</div>
			
		 <form name="loginForm" action="<c:url value="/j_spring_security_check"></c:url>" method="POST">

	<div class="form-group">
	<b> User ID </b> <br><input type="text" name="j_username" /> <br> </div>

	<div class="form-group">
	<b>Password</b> <br><input type="password" name="j_password" /> <br> </div>

	Forgot Password?<a href=""> Click Here</a>
	<div align="right">
		<input type="submit" value="Login" />
	</div>
</form> 
			
			<%-- <xyz:form commandName="userObject" action="reqLoginCheck">
			
			<div class="form-group">
				<b>UserID </b>
				<br>
				<xyz:input path="userid" placeholder="Enter User Id" class="form-control" />
			</div>	
			
			<div class="form-group">
			<b>Password </b>
				<br>
				 <xyz:password path="password" class="form-control"/>
			</div>

				<br>
				<xyz:button>Login</xyz:button>
			</xyz:form> --%>
			
			</div>
			
			<div class="col-sm-9">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/images/carousel/CRS00004.jpg" alt="buddha">
      <div class="carousel-caption">
        <h3>Buddha</h3>
        </div>
    </div>

    <div class="item">
      <img src="resources/images/carousel/CRS00005.jpg" alt="decorative">
      <div class="carousel-caption">
        <h3>Decorative</h3>
      </div>
    </div>

    <div class="item">
      <img src="resources/images/carousel/CRS00006.jpg" alt="wood design">
      <div class="carousel-caption">
        <h3>Wood Design</h3>
        </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


			
		</div>
	</div>
</body>
</html>