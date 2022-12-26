
<%@include file="header.jsp" %>
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
						2
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
			</tbody>
		</table>
	</div>

<%@include file="footer.jsp" %>