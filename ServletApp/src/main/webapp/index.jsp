<html>
<head>
<title>ServletApp</title>
</head>
<body>
    <h1>Hello JSP</h1>
    <form action="studentServlet" method="post">
    <table>
    <tr><td>Enter your Id: </td><td><input type="text" name=id size="5"></td></tr>
    <tr><td>Enter your name: </td><td><input type="text" name=name size="20"></td></tr>
    <tr><td>Enter your city: </td><td><input type="text" name=city size="20"></td></tr>
    <tr><td>Enter your age: </td><td><input type="text" name=age size="2"></td></tr>
    <tr><td>Enter your marks: </td><td><input type="text" name=marks size="3"></td></tr>
    </table>
    <input type="submit" value="Save" />
	</form>
</body>
</html>