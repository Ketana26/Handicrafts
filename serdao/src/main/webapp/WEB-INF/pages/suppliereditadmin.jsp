<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<br><br><br>
	<div class="container" style="padding-top:20px">
		<div class="col-sm-6"
			style="background-color: #0db9f2; border-radius: 30px; padding-bottom: 15px;padding-top: 5px;">


			<div align="center" style="font-size: 30px; color: green">
				<b>Edit Supplier Page </b>
			</div>




			<xyz:form commandName="supplier" action="reqSendUpdatedSupplierToDB"
				enctype="multipart/form-data">



<xyz:hidden path="supplierid"/>

				<div class="form-group">
					<b> Enter Supplier Name </b> <br>
					<xyz:input class="form-control" path="suppliername" />
				</div>
				
				
				<div class="form-group">
					<b> Enter Supplier Description </b> <br>
					<xyz:input class="form-control"	path="supplierdesc" />
				</div>				

				<%-- <div class="form-group">
					<b>Browse Image</b> <br>
					<xyz:input class="form-control" placeholder="Browse Picture"
						type="file" path="productImage" />
				</div> --%>

				<div class="form-group">
					<b>Supplier Available</b> <br>
					True <xyz:radiobutton path="issupplieravailable" value="true"/>  
 					False <xyz:radiobutton path="issupplieravailable" value="false"/> 
				</div>

				<div align="right">
					<xyz:button class="btn btn-primary">Update Supplier</xyz:button>
				</div>
				
				
				
				
<%-- <br>Product Name <xyz:input path="productname"/>
<br>Product Description <xyz:input path="productdesc"/>
<br>Product Available  True 
<xyz:radiobutton path="isproductavailable" value="true"/>  
 False <xyz:radiobutton path="isproductavailable" value="false"/> --%>

</xyz:form>
</div>
</div>

</body>
</html>