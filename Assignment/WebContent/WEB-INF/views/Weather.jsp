<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function submit(test) {
		document.weatherForm.submit();
	}
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<title><spring:message code="label.weather.title" /></title>
</head>

<body>
	<div class="form-container">
		<form:form method="POST" modelAttribute="weather" id="weatherForm"
			name="weatherForm" class="form-horizontal">

			<div class="row">
				<div class="form-group col-md-12">

					<div class="col-md-7">
						<form:select path="city" id="city" onchange="submit();"
							class="form-control input-sm">
							<form:option value="">
								<spring:message code="label.weather.selectCity" />
							</form:option>
							<form:options items="${cities}" />
						</form:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="City"><spring:message
							code="label.weather.city" /></label>
					<div class="col-md-7">${weatherVO.city}</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="Time"><spring:message
							code="label.weather.updatedTime" /></label>
					<div class="col-md-7">${weatherVO.updatedTime}</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="Weather"><spring:message
							code="label.weather.weather" /></label>
					<div class="col-md-7">${weatherVO.weather}</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="Temperature"><spring:message
							code="label.weather.temperature" /></label>
					<div class="col-md-7">${weatherVO.temperature}</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="Wind"><spring:message
							code="label.weather.wind" /></label>
					<div class="col-md-7">${weatherVO.wind}</div>
				</div>
			</div>

			<div></div>
		</form:form>
	</div>
</body>
</html>