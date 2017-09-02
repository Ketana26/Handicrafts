<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});

</script>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<br><br><br>
  <c:if test="${suppliermessage!=null}">
	<div class="container">
    
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-success alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${suppliermessage}
    </div>
  </div>
  </div>
  </c:if>
<div class="container">

<table class="table table-stripped fixed_headers" style="font-weight:bold;background-color:green" >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Supplier Id</th>
<th style="text-align:center">Image</th>
<th style="text-align:center">Supplier Name</th>
<th style="text-align:center">Supplier Description</th>
<th style="text-align:center">Is Available</th>
<th style="text-align:center">Options</th>
</tr>
</thead>

<tbody>

<c:forEach var="s" items="${allsuppliers}">

<tr>
<td style="text-align:center;vertical-align: middle;">${s.supplierid}</td>
<td style="text-align:center;vertical-align: middle;"><img src="resources/images/suppliers/${s.supplierid}.jpg" height="100px" width="130px" /> </td>
<td style="text-align:center;vertical-align: middle;">${s.suppliername}</td>
<td style="text-align:center;vertical-align: middle;">${s.supplierdesc}</td>
<td style="text-align:center;vertical-align: middle;">${s.issupplieravailable}</td>
<td style="text-align:center;vertical-align: middle;">
<a href="reqEditSupplierPageAdmin?sid=${s.supplierid}">
<span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
</a> / 
<a href="reqDeleteSupplierAdmin?sid=${s.supplierid}">
<span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
</a>
</td>


</tr>

</c:forEach>
</tbody>
</table>
</div>
</body>
</html>