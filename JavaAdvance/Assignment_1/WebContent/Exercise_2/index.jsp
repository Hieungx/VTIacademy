  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cong tru nhan chia</h1>
	<form name="myform" action="ketqua.jsp">
		So hang 1 <input type="text" name="so1"><br>
		So hang 2 <input type="text" name="so2"><br><br>
		<input type="submit" name="" value="+" onclick="cong()">
		<input type="submit" name="" value="-" onclick="tru()">
		<input type="submit" name="" value="*" onclick="nhan()">
		<input type="submit" name="" value="/" onclick="chia()"><br>
		<br> <input type="hidden" name="result">
		
		
	</form>

	<script type="text/javascript">
		function cong() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 + so2;
			myform.result.value = so1+" + "+so2+" = "+result;
		}
		function tru() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 - so2;
			myform.result.value = so1+" - "+so2+" = "+result;
		}
		function nhan() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 * so2;
			myform.result.value = so1+" * "+so2+" = "+result;
		}
		function chia() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 / so2;
			myform.result.value = so1+" / "+so2+" = "+result;
		}
	</script>
</body>
</html>