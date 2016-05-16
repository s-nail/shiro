<!DOCTYPE html>
<html>
	<body>
		<script>
			document.write("<h1> This is a heading </h1>");
			document.write("nihaoma")
		</script>
		<p id="demo">
		I am fine!
		</p>
		<script>		
		function myFunction()
		{
			//alert("nihao");
			x=document.getElementById("demo");
			x.innerHTML="Hello World!";
			x.style.color="#ff0000"; 
			//x.append("HAHA");
		}
		</script>
		<button type="button" onclick="myFunction()">click here</button>
	</body>
</html>