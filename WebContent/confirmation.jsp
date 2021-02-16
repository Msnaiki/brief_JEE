<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles </title>
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap-4.3.1-dist"> --> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
		
	<div class="container">
	<%@include file="header.jsp" %>
		<div class="panel  panel-primary">
			<div class="panel-heading">	Confirmation </div>
			<div class="panel-body">
			 
			 	<div class="form-group">
			 		<label>ID : </label>
			 		<label>${article.id}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Intitule : </label>
			 		<label>${article.intitule}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Prix : </label>
			 		<label>${article.prix}</label>
			 	</div>
			 	<div class="form-group">
			 		<label>Quantité en stock : </label>
			 		<label>${article.qteStock}</label>
			 	</div>
			 
			</div>
		
		
		</div>
	</div>
 

</body>
</html>