<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
<title>Kalkulator Kredytowy</title>
</head>
<body>
<script type="text/javascript">
    function validateForm()
    {
        var kwotakredytu=document.forms["Form"]["kwotakredytu"].value;
        var iloscrat=document.forms["Form"]["iloscrat"].value;
        var oprocentowanie=document.forms["Form"]["oprocentowanie"].value;
        var oplatastala=document.forms["Form"]["oplatastala"].value;
        if (kwotakredytu==null || kwotakredytu=="",iloscrat==null || iloscrat=="",oprocentowanie==null || oprocentowanie=="",oplatastala==null || oplatastala=="")
        {
            alert("Prosze uzupelnic wszystkie pola");
            return false;
        }
    }
</script>
	<form action="calculator" method="post" onSubmit="validateForm()">
		<div>Kwota kredytu:</div>
		<div><input type="number" id="kwotakredytu" name="kwotakredytu" min="10000" /></div> 
		<div>Ilosc rat:</div>
		<div><input type="number" id="iloscrat" name="iloscrat" min="2"/></div>
		<div>Oprocentowanie:</div>
		<div><input type="number" id="oprocentowanie" name="oprocentowanie" min="0" step="0.05"/></div>
		<div>Oplata stala:</div>
		<div><input type="number" id="oplatastala" name="oplatastala" min="0" step="0.01"/></div>
		<div>Rodzaj rat:</div>
		<select id="rodzajrat" name="rodzajrat">
 		<option value="stala">Stale</option>
  		<option value="malejaca">Malejace</option>
		</select>
		<hr> 
		<div><input type="submit" value="Oblicz">
		<input type="reset" value="Wyczysc"></div>
	</form>
</body>
</html>