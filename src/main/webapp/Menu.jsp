<%@ page import="java.io.*,java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web site của DAI</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand"
			href="http://localhost:8080/WatchWebSite/trang-chu"><img src="images/logo.jpg" width="80px" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
			<li class="nav-item"><a class="nav-link" href="">About Us</a></li>
			<c:if test="${sessionScope.acc !=null }">
					<li class="nav-item"><a class="nav-link" href="#">Hello
						${sessionScope.acc.user }</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">logout</a>
				</li>
				</c:if>
				<c:if test="${sessionScope.acc.isAdmin == 1 }">
				<li class="nav-item"><a class="nav-link" href="managerAccount">Manager
						Account</a></li>
						</c:if>
				<c:if test="${sessionScope.acc.isAdmin == 1 }">
				<li class="nav-item"><a class="nav-link" href="managerProduct">Manager
						Product</a></li>
				</c:if>
				<c:if test="${sessionScope.acc ==null }">
					<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
					</li>
				</c:if>
				
			</ul>
			<form action="search" method="post" class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input name="txt" type="text" class="form-control"
						aria-label="Small" aria-describedby="inputGroup-sizing-sm"
						placeholder="Search...">
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="cart.jsp"> <i
					class="fa fa-shopping-cart"></i> Cart <span
					class="badge badge-light">3</span>
				</a>
			</form>
		</div>
	</div>
</nav>
<!--end of menu-->