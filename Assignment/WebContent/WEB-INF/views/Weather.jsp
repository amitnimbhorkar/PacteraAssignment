<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todays weather</title>
</head>
<body>
<h2>${message}</h2>
<h2>City : ${weatherVO.city}</h2>
<h2>Updated TIme : ${weatherVO.updatedTime}</h2>
<h2>Weather : ${weatherVO.weather}</h2>
<h2>Temperature : ${weatherVO.temperature}</h2>
<h2>Wind : ${weatherVO.wind}</h2>
</body>
</html>