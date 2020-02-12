<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Popularnost online kupovine</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/AnketeVS/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.container {
	padding: 20px 20px;
	background-color: #f1f1f1;
	margin: 10px 100px;
}
.container2 {
	text-align: justify;
	padding: 20px 20px;
	background-color:#A0A0A0;
	margin: 50px 5px;
}

.container1 {
	text-align: left;
	border: 1px solid #73AD21;
	padding: 10px 5px;
	margin: 15px 15px;
}

input[type=text] {
	width: 25%;
	height: 10px;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 3px solid #ccc;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	outline: none;
}
input[type=submit] {
  width: 100%;
  padding: 12px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  background-color: green;
  color: white;
  border: none;
}
}
</style>
<body>
	<div class="w3-bar w3-grey">
		<a href="/AnketeVS/Pocetna.jsp"
			class="w3-bar-item w3-button w3-green w3-mobile"><i
			class="fa fa-commenting-o w3-margin-right"></i>Pocetna</a> <a
			href="/AnketeVS/SveAnkete.jsp"
			class="w3-bar-item w3-button  w3-green w3-mobile">Ankete</a> <a
			href="/AnketeVS/AnalizeAnketi.jsp"
			class="w3-bar-item w3-button w3-green w3-mobile">Analize anketi</a> <a
			href="/AnketeVS/PretplatiSe.jsp"
			class="w3-bar-item w3-button w3-right w3-green w3-mobile">Prijavi
			se</a>
	</div>
	${ poruka}
	<div class="container">
		<form action="/AnketeVS/Anketa/sacuvajOdgovor" method="post">
			<div class="container1">
				Izaberite pol:<br> <input type="radio" name="pol" value="muski" />Muski
				<br> <input type="radio" name="pol" value="zenski" checked />Zenski
				<br>
				<br> Unesite svoje godine: <br> <input type="text" name="godine" /><br> <br> 
				Vas status zaposlenja: <br>
			<input type="radio" name="statusZaposlenosti" value="zaposlen" checked/>Zaposlen<br>
			<input type="radio" name="statusZaposlenosti" value="nezaposlen"/>Nezaposlen<br>
			<input type="radio" name="statusZaposlenosti" value="student/ucenik"/>Student ili ucenik<br><br>
		
		Vasa prosecna mesecna primanja su:<br>
			<input type="text" name="mesecnaPrimanja"/>
			<br><br>
		
		Da li ste obavljali onlajn kupovinu?<br>
			<input type="radio" name="obavljenaKupovina" value="jesam" checked/>Jesam <br>
			<input type="radio" name="obavljenaKupovina" value="nisam" />Nisam 
			<br><br><br>
		
		Zasto jos niste koristili mogucnost onlajn kupovine?<br>
			<input type="radio" name="zastoJosNeOnlajnKupovina" value="nemamKarticu"/> Nemam kreditnu/debitnu karticu.<br>
			<input type="radio" name="zastoJosNeOnlajnKupovina" value="nemogucnostProceneKvaliteta"/>Nemogucnost procene kvaliteta.<br>
			<input type="radio" name="zastoJosNeOnlajnKupovina" value="rizik"/>Smatram da je onlajn kupovina rizicna<br>
			<input type="radio" name="zastoJosNeOnlajnKupovina" value="neinteresantnePonude"/>Nisam naisao na interesantnu ponudu.<br>
		
		<br><br>
		
		Kako ste culi za onlajn kupovinu?<br>
			<input type="radio" name="izvorSaznanjaZaOnlajnKupovinu" value="prijatelji"/> Preko prijatelja<br>
			<input type="radio" name="izvorSaznanjaZaOnlajnKupovinu" value="mediji"/> Preko medija<br>
			<input type="radio" name="izvorSaznanjaZaOnlajnKupovinu" value="drustveneMreze"/> Preko drustvenih mreza<br>
			<input type="radio" name="izvorSaznanjaZaOnlajnKupovinu" value="slucajno"/> Slucajno sam naisao/la<br><br>
			
		Sta najvise kupujete putem onlajn kupovine?<br>
			<input type="radio" name="proizvodi" value="hrana"/> Hrana<br>
			<input type="radio" name="proizvodi" value="tehnika"/> Tehnika<br>
			<input type="radio" name="proizvodi" value="odevniPredmeti"/> Odevni predmeti<br>
			<input type="radio" name="proizvodi" value="ostalo"/> Ostalo<br><br>
			
		
		Koliki je vas prosecan racun pri onlajn kupovini? <br>
			<input type="text"  name="najcesciIznosNovca"/><br><br>
		
		Koje metode placanja koristite?<br>
			<input type="radio" name="najcesceMetodePlacanja" value="kartica" />Debitna kartica<br>
			<input type="radio" name="najcesceMetodePlacanja" value="onlajnBankarstvo"/>Onlajn bankarstvo<br>
			<input type="radio" name="najcesceMetodePlacanja" value="uplataUBanci"/>Opsta uplata u banci<br><br>
		
		Koji Vam je najbitniji faktor kod onlajn kupovine? <br>
			<input type="radio" name="bitnost" value="cena" />Cena<br>
			<input type="radio" name="bitnost" value="sigurnost"/>Sigurnost<br>
			<input type="radio" name="bitnost" value="besplatnaDostava"/>Besplatna dostava<br>
			<input type="radio" name="bitnost" value="iskustvaDrugih"/>Pozitivna iskustva drugih<br><br>
		
		Da li se cesce opredeljujete za kupovinu na domacim web servisima? <br>
			<input type="radio" name="nasiSajtovi" value="da"/>Da<br>
			<input type="radio" name="nasiSajtovi" value="nemaPravila"/>Nema pravila<br>
			<input type="radio" name="nasiSajtovi" value="ne"/>Ne<br><br>
		
		Navedite sajt sa kog ste najvise kupovali, te imali pozitivna iskustva?<br>
			<input type="text" name="omiljenSajt"/><br><br>
		
		Zasto bi preporucili onlajn kupovinu?<br>
			<input type="radio" name="razloziDaOnljanKupovini" value="ustedaVremena"/>Usteda vremena.<br>
			<input type="radio" name="razloziDaOnljanKupovini" value="ustedaNovca"/>Usteda novca<br>
			<input type="radio" name="razloziDaOnljanKupovini" value="boljaPonuda"/>Raznovrsnija ponuda<br><br>
		
		Da li planirate ponovo vrsiti onlajn kupovinu? <br>
			<input type="checkbox" name="ponovnaOnlajnKupovina" value="da"/> Da <br>
			<input type="checkbox" name="ponovnaOnlajnKupovina" value="ne"/> Ne <br><br>
		
		<div class="container2">
		Da li ste kupovali preko AliExpress-a ili Amazon? <br>
			<input type="checkbox" name="aliAmazon" value="da"/> Da <br>
			<input type="checkbox" name="aliAmazon" value="ne"/> Ne <br><br>
		
		***ako je Vas odgovor pozitivan odgovorite na sledeca pitanja ***<br>
		Ocenite isplativost kupovanja sa AliExpress-a ili Amazon-a? <br>
			<input type="text" name="ocenaAA" /><br><br>
		
		Navedite koliko ste cekali na isporuku(prosecno broj dana):<br>
			<input type="text" name="isporuka"/><br><br>
		</div>
		<input type="submit" value="Sacuvaj odgovore"/><br>	
		</div>
	</form>
	</div>

</body>
</html>