


<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<!-- <div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div> -->

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li> -->
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Admin
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/admin-add-user">Add User</a></li>
							<li><a href="/admin-delete-user">View Users</a></li>
							<!-- <li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li> -->
						</ul></li>
				</security:authorize>


				<security:authorize access="hasRole('ROLE_USER')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">User
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/user-add-customer">Add Client</a></li>
							<li><a href="/user-get-all-customers">View Clients</a></li>

						</ul></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Account
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/account-add">Add Account</a></li>
							<li><a href="/account-view">View Accounts</a></li>
							<li><a href="/transfer">Transfer money</a></li>
							<li><a href="/max-transfer">Set maximum transferable ammount</a></li>

						</ul></li>
				</security:authorize>
				
					<security:authorize access="hasRole('ROLE_USER')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Linked Account
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/linked-account-add">Add Linked Account</a></li>
							<li><a href="/linked-account-view">View Accounts</a></li>
							
							

						</ul></li>
				</security:authorize>
				
				
				<security:authorize access="hasRole('ROLE_USER')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Credits
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/add-overdraft">Overdraft</a></li>
							<li><a href="/add-cash-credit">Cash Credit</a></li>
							<li><a href="/add-loan">Loan</a></li>
							<li><a href="/view-all-credits">View all credits</a></li>

						</ul></li>
				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/password-reset">Password Reset</a></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/export-xml">Export Operations in XML</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/export-json">Export Operation in JSON</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/import-xml">Import Operations in XML</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="/profile">Profile</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="/transfer">Transfer</a></li>
				</security:authorize>
				<li><a href="/logout">Log out</a></li>
				<!-- 	<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li> -->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
