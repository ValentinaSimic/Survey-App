<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pretplata</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/AnketeVS/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

form {
  border: 3px solid #f1f1f1;
  font-family: Arial;
}

.container {
  padding: 20px;
  background-color: #f1f1f1;
}

input[type=text], input[type=submit] {
  width: 100%;
  padding: 12px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=checkbox] {
  margin-top: 16px;
}

input[type=submit] {
  background-color: green;
  color: white;
  border: none;
}

input[type=submit]:hover {
  opacity: 0.8;
}
</style>
<body>
	<div class="w3-bar w3-grey">
		<a href="/AnketeVS/Pocetna.jsp"
			class="w3-bar-item w3-button w3-green w3-mobile"><i class="fa fa-commenting-o w3-margin-right"></i>Pocetna</a> <a
			href="/AnketeVS/SveAnkete.jsp"
			class="w3-bar-item w3-button  w3-green w3-mobile">Ankete</a> <a
			href="/AnketeVS/AnalizeAnketi.jsp"
			class="w3-bar-item w3-button w3-green w3-mobile">Analize anketi</a> <a
			href="/AnketeVS/PretplatiSe.jsp"
			class="w3-bar-item w3-button w3-right w3-green w3-mobile">Prijavi se</a>
	</div>
	
${poruka }
<form action="/AnketeVS/Korisnik/pretplata" method="post">
  <div class="container">
    <h2>Pretplati se za nase ankete</h2>
    <p>Pretplatom dobijas nove ankete na mejl kao i nove rezultate. Pretplata je besplatna.</p>
  </div>

  <div class="container" style="background-color:white">
    <input type="text" placeholder="Ime" name="ime" required>
    <input type="text" placeholder="Email adresa" name="email" required>
  </div>

  <div class="container">
    <input type="submit" value="Pretplati se">
  </div>
</form>
	
</body>
</html>