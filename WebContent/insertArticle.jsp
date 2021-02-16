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
		
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<%@include file="header.jsp" %>
		<div class="panel  panel-primary">
			<div class="panel-heading">	L'ajout d'un article </div>
			<div class="panel-body">
				<form action="saveArticle.php" method="post">
					<div class="form-group">
						<label class="control-label">Intitulé</label>
						<input type="text" name="intitule" value="${article.intitule}" class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label>
						<input type="text" name="prix" value="${article.prix}" class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantité en stock</label>
						<input type="text" value="${article.qteStock}"  name="qstock" required="required" class="form-control"/>
						<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
				</form>
		 
			 
			</div>
		
		
		</div>
	</div>
 

</body>
</html>