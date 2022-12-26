<%@include file="header.jsp" %>
	<h3 class="text-center">Commands</h3>
	<p class="lead">
		A list of frequently used commands for a quick reference is given below.
	</p>
	<div class="row">
		<div class="col-6">
			<code>
				mvn clean package install test site surefire-report:report
			</code>
		</div>
		<div class="col-6">
			Maven command to clean, package, run the Unit Test and install the package.
			Alongside, it would also generate the report for the entire project (site
			and for the Unit Test Reports (surefire-report)
		</div>
		<br/><br/>
		<div class="row">
			<div class="col-6">
				<code>
					cp -r ~/raghs/official/training/SketchWow-Images-Docs/24Dec2022-Sat-Images
				</code>
			</div>
			<div class="col-6"> 
				Copy the screenshots from local directory to the Github (Version Control) Directory
			</div>
		</div>
		<br/><br/>
		<div class="row">
			<div class="col-6">
				<code>
					git push --set-upstream origin feature/common-tasks-2
				</code>
			</div>
			<div class="col-6">
				A git command to set the upstream directory (remote) to the local feature branch
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<code>
					
				</code>
			</div>
			<div class="col-6">
			</div>
		</div>				
	</div>
<%@include file="footer.jsp" %>