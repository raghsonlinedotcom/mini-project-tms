<%@include file="../inc/header.jsp" %>
	<h3 class="text-center">Version History</h3>
	<p class="lead">
		A list of the version this Application has been developed under.
	</p>
	<div class="row table-responsive">
		<table class="table table-striped table-hover table-bordered  
				table-responsive">
			<caption>Version History</caption>
			<thead>
				<tr>
					<th>Sl No</th>
					<th>Version</th>
					<th>Date</th>
					<th>Sprint</th>
					<th>Release</th>
					<th>Features</th>
					<th>Remarks</th>
					<th>Known Issues</th>
					<th>Reference</th>
				</tr>				
			</thead>
			<tbody class="table-group-divider">
				<tr>
					<td>
						1
					</td>
					<td>
						1.0
					</td>
					<td>
						2022-12-20
					</td>
					<td>
						Sprint 1 - Create Member
					</td>
					<td>
						Release 1
					</td>
					<td>
						<ul>
							<li>Initial Version</li>
							<li>Create Member</li>
						</ul>
					</td>
					<td>
						Initial Version
					</td>
					<td>
						<ul>
							<li>MySQL Sequence Jump</li>
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10000/tab/release-report-all-issues">
							Jira Release Ref. for Release 1
						</a>
					</td>
				</tr>
				<tr>																									<tr>
					<td>
						2
					</td>
					<td>
						2.0
					</td>
					<td>
						2022-12-23
					</td>
					<td>
						Sprint 2 - Common Tasks
					</td>
					<td>
						Release 2
					</td>
					<td>
						<ul>
							<li>Email Framework</li>
							<li>Responsive Web Design</li>
							<li>Logging - Log4j</li>
							<li>JUnit (Unit Testing)</li>
							<li>Maven Packaging</li>
							<li>Global Readiness Check - Validation</li>
							<li>Best Practices</li>
						</ul>
					</td>
					<td>
						Incremental Version
					</td>
					<td>
						<ul>
							<li>Bootstrap Sticky Footer</li>
							<li>Bootstrap Table not responsive</li>
							<li>
								Emails sent to the Official Email Address from the Tomcat Server on the AWS EC2 environment are NOT 
								delivered, but it works in local Eclipse + Tomcat
							</li>
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10001/tab/release-report-all-issues">
							Jira Release Ref. for Release 2
						</a>
					</td>
				</tr>
				<tr>																	    <td>
						3
					</td>
					<td>
						3.0
					</td>
					<td>
						2022-12-26
					</td>
					<td>
						Sprint 3 - Common Tasks-2
					</td>
					<td>
						Release 3
					</td>
					<td>
						<ul>
							<li>RWD - Sticky Footer Issue</li>
							<li>RWD - Table not being responsive</li>
							<li>Bootstrap local copy</li>
							<li>Common Menus - Team, Issues, Version History etc.,</li>
							<li>Maven Surefire Test Reports</li>
						</ul>
					</td>
					<td>
						Incremental Version
					</td>
					<td>
						<ul>							
							<li>
								Bootstrap library packed via Maven to AWS EC2 - Halfway with a workaround
							</li>							
							<li>
								Emails sent to the Official Email Address from the Tomcat Server on the AWS EC2 environment are NOT 
								delivered, but it works in local Eclipse + Tomcat
							</li>							
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10002/tab/release-report-all-issues">
							Jira Release Ref. for Release 3
						</a>
					</td>
				</tr>	
				<tr>
					<td>
						4
					</td>
					<td>
						4.0
					</td>
					<td>
						2022-12-29
					</td>
					<td>
						Sprint 4 - View Edit Member
					</td>
					<td>
						Release 4
					</td>
					<td>
						<ul>
							<li>Login</li>
							<li>Logout</li>
							<li>View Member</li>
							<li>Edit Member</li>
							<li>Refactoring - JSP Pages into folders</li>
							<li>Bug Fixes</li>
						</ul>
					</td>
					<td>
						Incremental Version
					</td>
					<td>
						<ul>
							<li>
								Bootstrap library packed via Maven to AWS EC2 - Halfway with a workaround
							</li>
							<li>
								Emails sent to the Official Email Address from the Tomcat Server on the AWS EC2 environment are NOT 
								delivered, but it works in local Eclipse + Tomcat
							</li>							
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10003/tab/release-report-all-issues">
							Jira Release Ref. for Release 4
						</a>
					</td>
				</tr>	
				<tr>
					<td>
						5
					</td>
					<td>
						5.0
					</td>
					<td>
						2023-01-05
					</td>
					<td>
						Sprint 5 - Delete, ViewAll Members
					</td>
					<td>
						Release 5
					</td>
					<td>
						<ul>
							<li>Delete Member</li>
							<li>View All Members</li>
							<li>Validation on the Create and Update Member</li>
							<li>Enhancement to GRC (Global Readiness Check) - 
								Flag to Control the emails being sent on Application Startup
							</li>
							<li>Refactoring - Package Naming (added `miniprojects.tms`), JUnit Class</li>
							<li>Bug Fixes</li>
						</ul>
					</td>
					<td>
						Incremental Version
					</td>
					<td>
						<ul>
							<li>
								JDBC Driver does not give the right count for the DML Update - the Unit Testing was asserted with `rowsUpdated > 0'
								was supposed to fail but getting passed. 
							</li>
							<li>
								Bootstrap library packed via Maven to AWS EC2 - Halfway with a workaround
							</li>							
							<li>
								Emails sent to the Official Email Address from the Tomcat Server on the AWS EC2 environment are NOT 
								delivered, but it works in local Eclipse + Tomcat
							</li>	
							<li>
								The deployment in the AWS EC2 has a permission issue on the files, if it is performed by someone other than Raghavan.
							</li>						
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10004/tab/release-report-all-issues">
							Jira Release Ref. for Release 5
						</a>
					</td>
				</tr>
				<tr>
					<td>
						6
					</td>
					<td>
						6.0
					</td>
					<td>
						2023-01-18
					</td>
					<td>
						Sprint 6 - Manager, AuditTrial
					</td>
					<td>
						Release 6
					</td>
					<td>
						<ul>
							<li>Audit Trial</li>
							<li>Manager - Self - Edit/Delete with Audit Trial</li>
							<li>Manager - Others - View/Edit/Delete with Audit Trial</li>
							<li>JUnit Life Cycle Methods</li>
							<li>EmployeeDAOTest class inclined with the JUnit Lifecycle Methods</li>
							<li>Bug Fixes</li>
						</ul>
					</td>
					<td>
						Incremental Version
					</td>
					<td>
						<ul>
							<li>
								No new issues. All the previous issues still prevail.
							</li>						
						</ul>
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/projects/TMS/versions/10005/tab/release-report-all-issues">
							Jira Release Ref. for Release 6
						</a>
					</td>
				</tr>																		
			</tbody>
		</table>
	</div>

<%@include file="../inc/footer.jsp" %>
