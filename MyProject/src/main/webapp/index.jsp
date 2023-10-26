<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="conPkg.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="overflow-x: hidden;">
	<%
	Connection cn = ConnectionProvider.getCon();
	PreparedStatement ps = cn.prepareStatement("SELECT * FROM cources");
	ResultSet rs = ps.executeQuery();
	%>
	<div class="container">
		<nav class="navbar navbar-expand-lg bg-light rounded"
			aria-label="Eleventh navbar example">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">Center Name</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarsExample09"
					aria-controls="navbarsExample09" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarsExample09">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.jsp" >Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="newStudent.jsp">Student</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							data-bs-toggle="dropdown" aria-expanded="false">Courses</a>
							<%
							ps=cn.prepareStatement("SELECT * FROM cources ORDER BY RAND() LIMIT 10");
							rs=ps.executeQuery();
							%>
							<ul class="dropdown-menu">
							<% while(rs.next()){ %>
								<li class="dropdown-item"><%=rs.getString("course_name") %></li>
								<% } %>
							</ul></li>
					</ul>
					<form role="search">
						<input class="form-control" type="search" placeholder="Search"
							aria-label="Search">
					</form>
				</div>
			</div>
		</nav>
		<main>
			<div class="row">
				<form class="col-md-4 mt-5 mb-5" id="AddCourse">
					<h4 class="display-5">Add Course</h4>
					<div class="form-floating mb-2">
						<input type="text" class="form-control" id="course" name="course"
							placeholder="course name" required> <label for="course">Enter
							Course Name</label>
					</div>
					<div class="form-floating mb-2 ">
						<input type="text" class="form-control" id="courseFees"
							name="courseFees" placeholder="course name" required> <label
							for="courseFees">Enter Course Fees</label>
					</div>
					<div id="msgCourse" class="mb-2 bt-2"></div>
					<button class="w-100 btn btn-lg btn-primary" type="submit">Add
						Course</button>
				</form>

				<div class="col-md-1"></div>
				<div class="col-md-6 mt-5 mb-5">
				<h5 class="display-5">Available Courses</h5>
					<%
					 cn = ConnectionProvider.getCon();
					 ps = cn.prepareStatement("SELECT * FROM cources");
					 rs = ps.executeQuery();
					%>
					<table class="table table-striped table-hover table-responsive">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">Name</th>
								<th scope="col">Fees</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody>
							<%
							while (rs.next()) {
							%>
							<tr>
								<th scope="row"><%=rs.getString(1)%></th>
								<td><%=rs.getString(2)%></td>
								<td><%=rs.getString(3)%></td>
								<td><button class="btn btn-sm btn-danger coursedel"
										data-cid="<%=rs.getString(1)%>"
										data-cname="<%=rs.getString(2)%>">Delete</button></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</main>

	</div>
<footer class="row py-5 my-5 border-top d-flex justify-content-center">
    <div class="col-md-4 mb-3">
      <a href="index.jsp" class="d-flex align-items-center mb-3 link-dark text-decoration-none">
        CENTER NAME OR IMAGE
      </a>
      <p class="text-muted">© 2022</p>
    </div>


    <div class="col-md-3 mb-3">
      <ul class="nav flex-column">
        <li class="nav-item mb-2"><a href="index.jsp" class="nav-link p-0 text-muted">Home</a></li>
        <li class="nav-item mb-2"><a href="newStudent.jsp" class="nav-link p-0 text-muted">Student</a></li>
      </ul>
    </div>

    <div class="col-md-3 mb-3">
      <h5 class="h5">Courses</h5>
      <ul class="nav flex-column">
      	<%
		ps=cn.prepareStatement("SELECT * FROM cources ORDER BY RAND() LIMIT 5");
		rs=ps.executeQuery();
		%>
		<% while(rs.next()){ %>
			<li class="nav-item mb-2"><%=rs.getString("course_name") %></li>
		<% } %>
        
      </ul>
    </div>
  </footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-confirm.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$("#AddCourse").on("submit", function(e) {
								e.preventDefault();
								$.ajax({
									url : "AddCourse",
									type : "POST",
									data : $(this).serialize(),
									success : function(data) {
										$("#msgCourse").hide();
										$("#msgCourse").html(data);
										$("#msgCourse").fadeIn("slow");
										$("#AddCourse").trigger("reset");
									}
								});
							});
							$(document)
									.on(
											"click",
											".coursedel",
											function() {
												let dvid = $(this).data("cid");
												let dvname = $(this).data(
														"cname");
												let element = this;
												$
														.confirm({
															title : '<p><small>Do yo Really Want To Delete <b class="text-danger">'
																	+ dvname
																	+ '</b> ? </small></p>',
															buttons : {
																confirm : function() {
																	$
																			.ajax({
																				url : "DeleteCourse",
																				type : "POST",
																				data : {
																					dvid : dvid
																				},
																				success : function(
																						data) {
																					if (data == 1) {
																						$
																								.alert('Course Deleted SuccessFully');
																						$(
																								element)
																								.closest(
																										"tr")
																								.fadeOut();
																					} else {
																						$
																								.alert("Internal Error Can't Delete Course");
																					}
																				}
																			});
																},
																cancel : function() {
																	$
																			.alert('Operation Aborted!');
																}
															}
														});
											});
						});
	</script>
</body>
</html>