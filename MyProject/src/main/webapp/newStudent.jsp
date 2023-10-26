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
						<li class="nav-item"><a class="nav-link"
							aria-current="page" href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="newStudent.jsp">Student</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							data-bs-toggle="dropdown" aria-expanded="false">Courses</a>
							<%
							ps=cn.prepareStatement("SELECT * FROM cources");
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
				<form class="col-md-4 mt-5 mb-5" id="AddStudent">
					<h4 class="display-5">Add Student</h4>
					<div class="form-floating mb-2">
						<input type="text" class="form-control" id="student"
							name="student" placeholder="course name" required> <label
							for="course">Enter student Name</label>
					</div>
					<div class="form-floating mb-2">
						<textarea class="form-control" id="address" name="address"
							placeholder="course name" style="height: 100px" required></textarea>
						<label for="address">Enter student Address</label>
					</div>
					<div class="form-floating mb-2">
						<select class="form-select" id="course" name="course"
							onchange="getFees(this)" required>
							<option value>Select course</option>
							<%
							ps=cn.prepareStatement("SELECT * FROM cources");
							rs=ps.executeQuery();
							while (rs.next()) {
							%>
							<option value="<%=rs.getString("course_id")%>"><%=rs.getString("course_name")%></option>
							<%
							}
							%>
						</select> <label for="course" class="form-label">Course</label>
					</div>
					<div class="mb-2">
						Fees Payable: <label id="payable">-</label> <input type="hidden"
							name="hdnpay" id="hdnpay" />
						<div id="warning"></div>
					</div>
					<div class="form-floating mb-2">
						<input type="number" class="form-control" id="advPay" name="advPay"
							placeholder="course name" onkeyup="checkFee(this)" required>
						<label for="advPay">Advance pay</label>
					</div>
					<div class="form-floating mb-2">
						<input type="text" class="form-control" id="ref" name="ref"
							placeholder="reference" required> <label for="ref">Referenceed
							By</label>
					</div>
					<div id="msgCourse" class="mb-2 bt-2"></div>
					<button class="w-100 btn btn-lg btn-primary" type="submit">Add
						Student</button>
				</form>

				<div class="col-md-1"></div>
				<div class="col-md-7 mt-5 mb-5">
					<h5 class="display-5">Students</h5>
					<%
					cn = ConnectionProvider.getCon();
					ps = cn.prepareStatement("SELECT * FROM student");
					rs = ps.executeQuery();
					%>

					<table class="table table-striped table-hover table-responsive">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">Name</th>
								<th scope="col">Address</th>
								<th scope="col">Fees Paid</th>
								<th scope="col">Fees Due</th>
								<th scope="col">Course</th>
								<th scope="col">Reference</th>
								<th scope="col">Delete</th>
								<th scope="col">Edit</th>
								<th scope="col">Generate Inovance</th>
							</tr>
						</thead>
						<tbody>
							<%
							while (rs.next()) {
								ps = cn.prepareStatement("SELECT course_name from cources WHERE course_id=?");
								ps.setString(1, rs.getString("course_id"));
								ResultSet rs1 = ps.executeQuery();
								rs1.next();
							%>
							<tr>
								<th scope="row"><%=rs.getString(1)%></th>
								<td><%=rs.getString("student_name")%></td>
								<td title="<%=rs.getString("address")%>"><% if(rs.getString("address").length()>20){out.print(rs.getString("address").substring(0,20).trim()+"...");}else{out.print(rs.getString("address"));}%></td>
								<td><%=rs.getString("Fees_paid")%></td>
								<td><%=rs.getString("Fees_due")%></td>
								<td><%=rs1.getString("course_name")%></td>
								<td><%=rs.getString("Reference")%></td>
								<td title="Delete"><button class="btn btn-sm btn-danger coursedel"
										data-cid="<%=rs.getString("student_id")%>"
										data-cname="<%=rs.getString("student_name")%>">Delete</button></td>
										<td><button class="btn btn-sm btn-warning editstud" data-bs-toggle="modal" data-bs-target="#updateModal" data-cid="<%=rs.getString("student_id")%>"
										data-cname="<%=rs.getString("student_name")%>">Edit</button></td>
								<td title="Inovance"><a class="btn btn-sm btn-success"
									href="GeneratePdf?sid=<%=rs.getString("student_id")%>">Inovance</a></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>

				</div>
			</div>
		</main>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Edit</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <form id="mdlBody">
       
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
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
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-confirm.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#AddStudent").on("submit", function(e) {
				e.preventDefault();
				$.ajax({
					url : "AddStudent",
					type : "POST",
					data : $(this).serialize(),
					success : function(data) {
						$("#msgCourse").hide();
						$("#msgCourse").html(data);
						$("#msgCourse").fadeIn("slow");
						$("#AddStudent").trigger("reset");
					}
				});
		});
		
		$(document).on("click",".editstud",function(){
			let sid=$(this).data("cid");
			let sname=$(this).data("cname");
			let element=this;
			$.ajax({
				url:"UpdateStudent",
				type:"POST",
				data:{sid},
				success:function(data){
					$("#mdlBody").hide();
					$("#mdlBody").html(data);
					$("#mdlBody").fadeIn("slow");
				}
			});
		});
			
		$(document).on("click",".coursedel",function() {
			let dvid = $(this).data("cid");
			let dvname = $(this).data("cname");
			let element = this;
			$.confirm({
				title : '<p><small>Do yo Really Want To Remove <b class="text-danger">'
				+ dvname+ '</b> ? </small></p>',
				buttons : {
					confirm : function() {
						$.ajax({
							url : "DeleteStudent",
							type : "POST",
							data : {dvid : dvid},
							success : function(data) {
								if (data == 1) {			
									$.alert('Student Removed SuccessFully');
									$(element).closest("tr").fadeOut();
								} else {
									$.alert("Internal Error Can't Remove Student");
								}
							}
						});
					},
					cancel : function() {
						$.alert('Operation Aborted!');
					}
				}
			});
		});
	});
		$("#payable").hide();
		function getFees(element) {
			let val = $(element).val();
			$.ajax({
				url : "GetFees",
				type : "POST",
				data : {
					val : val
				},
				success : function(data) {
					$("#payable").html(data);
					$("#hdnpay").val(data);
					$("#payable").fadeIn("slow");
				}
			});
		}

		function checkFee(element) {
			let val = $(element).val();
			let pay = $("#payable").text();
			if (pay < val) {
				$("#warning").html("<p class='text-danger'>Invalid value</p>")
			} else {
				$("#warning").html("");
			}
		}
		$("#mdlBody").on("submit",function(e){
			e.preventDefault();
			$.ajax({
				url:"UpdateStudentModel",
				type:"POST",
				data:$(this).serialize(),
				success:function(data){
					$("#mdlmsgCourse").hide();
					$("#mdlmsgCourse").html(data);
					$("#mdlmsgCourse").fadeIn("slow");
				}
			});
		});
		</script>
</body>
</html>