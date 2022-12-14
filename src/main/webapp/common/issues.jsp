
<%@include file="../inc/header.jsp" %>
	<h3 class="text-center">Known Issues</h3>
	<p class="lead">
		A list of known bugs/issues in the Application are listed below.
	</p>
	<div class="row">
		<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
			<caption>Known Issues</caption>
			<thead>
				<tr>
					<th>Sl No</th>
					<th>Item</th>
					<th>Date Raised</th>
					<th>Date Closed</th>
					<th>Version</th>
					<th>Status</th>
					<th>Owner</th>
					<th>Description</th>
					<th>Reference</th>
				</tr>				
			</thead>
			<tbody class="table-group-divider">
				<tr>
					<td>
						1
					</td>
					<td>
						MySQL Sequence Jump
					</td>
					<td>
						2022-12-01
					</td>
					<td>
						TBD
					</td>
					<td>
						1.0
					</td>
					<td>
						<p class="text-danger">Open</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						Whenever the insert query (DML) fails, the record does not get inserted as expected. However, the sequence value for the Auto Increment (PK field) gets incremented, which is unexpected.							
					</td>
					<td>
						Jira Ticket Ref.
					</td>
				</tr>	
				<tr>																						<tr>
					<td>
						2
					</td>
					<td>
						Bootstrap Sticky Footer Issue
					</td>
					<td>
						2022-12-23
					</td>
					<td>
						2022-12-25
					</td>
					<td>
						2.0
					</td>
					<td>
						<p class="text-success">Closed</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						The footer of the page is really sticky and not flexible.							
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-56">
							TMS-56
						</a>
					</td>
				</tr>
				<tr>																						<tr>
					<td>
						3
					</td>
					<td>
						Bootstrap Table Non-Responsive
					</td>
					<td>
						2022-12-23
					</td>
					<td>
						2022-12-26
					</td>
					<td>
						2.0
					</td>
					<td>
						<p class="text-success">Closed</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						The Table data is not responsive despite applying a css class <code>table-responsive</code>.							
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-57">
							TMS-57
						</a>
					</td>
				</tr>
				<tr>
					<td>
						4
					</td>
					<td>
						Emails sent to the Official Email Address from the Tomcat Server on 
						AWS EC2 are not delivered
					</td>
					<td>
						2022-12-23
					</td>
					<td>
						TBD
					</td>
					<td>
						2.0
					</td>
					<td>
						<p class="text-danger">Open</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						The emails being sent to the Official Email Id from the Tomcat inside the Eclipse is working fine,
						however the email being sent from the Tomcat on AWS EC2 Server are not delivered.							
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-53">
							TMS-53
						</a>
					</td>
				</tr>				
				<tr>																						<tr>
					<td>
						5
					</td>
					<td>
						Bootstrap Library packed via Maven
					</td>
					<td>
						2022-12-29
					</td>
					<td>
						TBD
					</td>
					<td>
						4.0
					</td>
					<td>
						<p class="text-success">WIP</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						The bootstrap library packed via Maven is bundled as a web jar and it is not helping the UI pages to pick up at runtime.
						It needs a  bit more exploration for the right orchestration to refer in the respective <code>.jsp</code> pages.
						<br/> <br/>
						<b>Workaround : </b> As of now, a temporary workraround has been applied in the shell script - <code>aws-ec2-deploy.sh</code>
						in such a way that it creates a <code>lib</code> directory inside the <code>~/soft/apache-tomcat-9.0.65/webapps/TMS</code> directory
						and copies the library folder <code>bootstrap-5.2.3-dist/</code> into it. The library is already placed in the <code>~/scp-files</code>
						directory via <code>scp</code> command. 							
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-60">
							TMS-60
						</a>
					</td>
				</tr>
				<tr>																						<tr>
					<td>
						6
					</td>
					<td>
						Bootstrap Library packed via Maven
					</td>
					<td>
						2022-12-29
					</td>
					<td>
						TBD
					</td>
					<td>
						4.0
					</td>
					<td>
						<p class="text-success">WIP</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						The bootstrap library packed via Maven is bundled as a web jar and it is not helping the UI pages to pick up at runtime.
						It needs a  bit more exploration for the right orchestration to refer in the respective <code>.jsp</code> pages.
						<br/> <br/>
						<b>Workaround : </b> As of now, a temporary workraround has been applied in the shell script - <code>aws-ec2-deploy.sh</code>
						in such a way that it creates a <code>lib</code> directory inside the <code>~/soft/apache-tomcat-9.0.65/webapps/TMS</code> directory
						and copies the library folder <code>bootstrap-5.2.3-dist/</code> into it. The library is already placed in the <code>~/scp-files</code>
						directory via <code>scp</code> command. 							
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-60">
							TMS-60
						</a>
					</td>
				</tr>	
				<tr>			
					<td>
						7
					</td>
					<td>
						JDBC Driver does not return the actual rows updated 
						for a DML (Update) for <code>is_active</code> column
					</td>
					<td>
						2023-01-05
					</td>
					<td>
						TBD
					</td>
					<td>
						5.0
					</td>
					<td>
						<p class="text-danger">Open</p>
					</td>
					<td>
						Raghavan
					</td>
					<td>
						JUnit Test case of EmployeeDAOTest for the testDeleteEmployeeById(int empId) method 
						which was ascertaining the rowsUpdated > 0 for a successful deletion. 
						<br/>
						However the employee was already inactive and hence there was NO update taking place in the DB 
						- as verified in the MySQL Console, with which the Test case should have failed. 
						But due to this bug, the JDBC Driver returned 1 making the assertion pass. 											
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-110">
							TMS-110
						</a>
					</td>					
				</tr>	
				<tr>			
					<td>
						8
					</td>
					<td>
						The deployment in the AWS EC2 has a permission issue on the files, 
						if it is performed by someone other than Raghavan.
					</td>
					<td>
						2023-01-05
					</td>
					<td>
						TBD
					</td>
					<td>
						5.0
					</td>
					<td>
						<p class="text-success">WIP</p>
					</td>
					<td>
						Raghavan
					</td>					
					<td>
						If anyone other than Raghavan performs a deployment in the Tomcat of the AWS EC2
						Server, we have permission issues either during or after the deployment.
						<br/>
						It results in a runtime error where the <code>jsp</code>  files are not being 
						accessible	
						<br/>
						<b>Workaround : </b> Issue <code>chmod -R</code> and <code>chgrp -R</code> 
						or change the ownership of deployment.												
					</td>
					<td>
						<a href="https://raghsonlinedotcom.atlassian.net/browse/TMS-111">
							TMS-111
						</a>
					</td>					
				</tr>										
			</tbody>
		</table>
	</div>

<%@include file="../inc/footer.jsp" %>