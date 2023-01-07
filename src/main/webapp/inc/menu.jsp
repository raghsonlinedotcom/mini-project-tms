		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">TMS</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarCollapse">
		      <ul class="navbar-nav me-auto mb-2 mb-md-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Home</a>
		        </li>
		  		<!-- <li class="nav-item">
		        	<a class="nav-link" href="sticky-footer/sticky-footer.html">Sticky Footer</a>
		        </li>-->		        
		       <li class="nav-item dropdown">
		         <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		           Employee
		         </a>
		         <ul class="dropdown-menu">
		           <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ViewMyDetails">View My Details</a></li>
		           <li><a class="dropdown-item" href="<%=request.getContextPath()%>/EditEmployee">Edit My Details</a></li>
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/EmployeeListServlet">View All Employees</a></li>
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/member/delete.jsp">Delete My Profile</a></li>
		           <li><hr class="dropdown-divider"></li>
		           <li><a class="dropdown-item" href="#">Apply Leave</a></li>
		         </ul>
		       </li>
		       <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/techstack.jsp">Tech. Stack</a>
		        </li>
		       <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/issues.jsp">Issues</a>
		        </li>		
		        <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/commands.jsp">Commands</a>
		        </li>  
		        <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/paths.jsp">Paths</a>
		        </li>
		       <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/team.jsp">Members</a>
		        </li>
		       <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/version.jsp">Version History</a>
		        </li>		        		        
		       <li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/common/references.jsp">References</a>
		        </li>		        
		       <!-- <li class="nav-item">
		         <a class="nav-link disabled">Disabled</a>
		       </li>-->
		       <li class="nav-item">
		         <a class="nav-link" href="<%=request.getContextPath()%>/Logout">Logout</a>
		       </li>
		      </ul>
		      <form class="d-flex" role="search">
		        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form>
		    </div>
		  </div>
		</nav>