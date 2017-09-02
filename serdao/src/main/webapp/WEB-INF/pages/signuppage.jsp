<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="navbar.jsp" %>
<body>

<div class="container">
		<div class="col-sm-4" style="background-color: #00ffff; border-radius:15px; padding-bottom:10px">
			<div align="center" style="color: black; font-size: 30px">
				<b>Signup Page</b>
			</div>
			<xyz:form commandName="userObject" action="reqSendSignupData"
				enctype="multipart/form-data">

				<div class="form-group">
					<b>UserName</b> <br>
					
					<xyz:input path="username" class="form-control" placeholder="Enter User Name"/>
				</div>
				<div class="form-group">
					<b>Password</b> <br>
					<xyz:password path="password" class="form-control" />
				</div>
				<div class="form-group">
					<b>EmailID</b> <br>
					<xyz:input path="emailid" class="form-control" />
				</div>
				<div class="form-group">
					<b>Mobileno</b> <br>
					<xyz:input path="mobileno" class="form-control" />
				</div>
				<div class="form-group">
					<b>Address</b> <br>
					<xyz:input path="address" class="form-control" />
				</div>


				<div class="form-group">
					<b>Browse profile picture </b><br>
					<xyz:input type="file" path="userImage" class="form-control" />
				</div>
				
				<br>
				<xyz:button>SignUp</xyz:button>
			</xyz:form>
		</div>
	</div>
</body>
</html>