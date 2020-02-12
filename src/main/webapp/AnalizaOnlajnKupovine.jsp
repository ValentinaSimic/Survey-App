<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Razlozi ne koriscenja onlajn kupovine"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: true,
		toolTipContent: "{name}: <strong>{y}%</strong>",
		indexLabel: "{name} - {y}%",
		dataPoints: [
			{ y: ${kartica}, name: "Nemam debitnu karticu", exploded: true },
			{ y: ${rizik}, name: "Izlaganje riziku" },
			{ y: ${procena}, name: "Nemogucnost procene kvaliteta" },
			{ y: ${ponuda}, name: "Neinteresantna ponuda" },
			
		]
	}]
});

var chart1 = new CanvasJS.Chart("chartContainer1", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Odakle su culi za onaljn kupovinu"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: true,
		toolTipContent: "{name}: <strong>{y}%</strong>",
		indexLabel: "{name} - {y}%",
		dataPoints: [
			{ y: ${pp}, name: "Prijatelji", exploded: true },
			{ y: ${mp}, name: "Mediji" },
			{ y: ${dmp}, name: "Drustvene mreze" },
			{ y: ${sp}, name: "Slucajno" },
			
		]
	}]
});
var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	theme: "light2",
	title:{
		text: "Bitni faktori"
	},
	axisY: {
		title: "bitnost u %"
	},
	data: [{        
		type: "column",  
		showInLegend: true, 
		legendMarkerColor: "grey",
		legendText: "faktori",
		dataPoints: [      
			{ y: ${cena}, label: "Cena" },
			{ y: ${sigurnost},  label: "Sigurnost" },
			{ y: ${dostava},  label: "Besplatna dostava" },
			{ y: ${iskustva},  label: "Iskustva drugih" },
			
		]
	}]
});
var chart3= new CanvasJS.Chart("chartContainer3", {
	animationEnabled: true,
	theme: "light1",
	title:{
		text: "Najvise se kupuje"
	},
	axisY: {
		title: "%"
	},
	data: [{        
		type: "column",  
		showInLegend: true, 
		legendMarkerColor: "grey",
		legendText: "proizvod",
		dataPoints: [      
			{ y: ${hrana}, label: "Hrana" },
			{ y: ${odeca},  label: "Odevni predmeti" },
			{ y: ${tehnika},  label: "Tehnika" },
			{ y: ${ostalo},  label: "Ostalo" },
			
		]
	}]
});
chart.render();
chart1.render();
chart2.render();
chart3.render();
}

function explodePie (e) {
	if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
	} else {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
	}
	e.chart.render();

}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/AnketeVS/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
.container {
	text-align: justify;
	padding: 20px 20px;
	background-color: #f1f1f1;
	margin: 10px 100px;
}
.container1 {
	text-align: justify;
	padding: 20px 20px;
	background-color:#bdb76b;
	margin: 50px 5px;
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
	<div class="container">
	<h1><center><b>Analize ankete onlajn kupovine i navikama potrosaca<b></b></center> </h1><br><br><br>
	
	<h5> Od ukupno ispitanih njih <b>${procenatKupovao } %</b> je koristilo usluge onlajn kupovine.</h5><br><br>
	<div id="chartContainer" style="height: 250px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> <br><br> 
	<div id="chartContainer1" style="height: 250px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script><br>
	<h5> Onlajn kupovina je popularna u starosnoj dobi ${rasponGodina }, medju kojima <b>${pol }</b>.</h5><br>
	<h5>Prosecna zarada ispitanika iznosi: <b>${prosecnaZarada }</b> dinara,dok 
	prosecan racun pri onlajn kupovini iznos <b>${prosecnaPotrosnja }</b> dinara.</h5><br>
	<div id="chartContainer2" style="height: 250px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> <br><br> 
	<div id="chartContainer3" style="height: 250px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> <br><br> 
	<h5>Vecina ispitanika je rekla da pre koristi kupovinu sa <b>${domacaStranaKupovina }</b> veb sajtova. <br>
	Neki od domacih veb sajtova : <br>
	1. <b>${sajt1 }</b><br>
	2. <b>${sajt2 }</b><br>
	3. <b>${sajt3 }</b></h5>
	<br>
	<h5>${kupovinaBuducnost } </h5><br>
	<div class="container1">
	<h5>Isplativost kupovine preko AliExpress-a i Amazona je ocenjena sa <b>${isplativost }</b>.<br>
	Najmanji i najveci broj dana cekanja na isporuku kod AliExpress-a i Amazona<b> ${rasponDana }</b>.<br>
	
	</div>
	
	</div>
</body>
</html>