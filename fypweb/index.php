<?php
	$BASE_URL = "http://localhost/fyp";
?>

<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

	<title>Test Web Page Home</title>

	<style type="text/css">
		body {
			background-color: #787878;
		}
	</style>
</head>
<body>
	<div class="container bg-white mb-4 mt-4 p-0">
		<header>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <a automationid="btn_home_logo" class="navbar-brand" href="<?php echo $BASE_URL; ?>">Navbar</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			        <a automationid="btn_home" class="nav-link" href="<?php echo $BASE_URL; ?>/index.php">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item">
			        <a automationid="btn_contact_us" class="nav-link" href="<?php echo $BASE_URL; ?>/contact.php">Contact Us</a>
			      </li>

			      <li class="nav-item">
			        <a automationid="btn_about_us" class="nav-link" href="<?php echo $BASE_URL; ?>/about.php">About Us</a>
			      </li>
			    </ul>
			    <form class="form-inline my-2 my-lg-0" automationid="form_search">
			      <input name="search" id="search" automationid="form_search_input_search" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			      <button name="btn_search" id="btn_search" automationid="form_search_btn_search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
			  </div>
			</nav>
		</header>

		<main class="main" id="main">
			<div class="p-3">
				<article id="article1" automationid="fyp_article_1">
					<header>
						<h1>Lorem Ipsum Dolar Soleh 1</h1>
					</header>
					<content>
						<p automationid="fyp_article_date">Posted on 13th August 2019 by mull.codes</p>
						<p automationid="fyp_article_description">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
					</content>
				</article>


				<article id="article2" automationid="fyp_article_2">
					<header>
						<h1>Lorem Ipsum Dolar Soleh 1</h1>
					</header>
					<content>
						<p automationid="fyp_article_date">Posted on 13th August 2019 by mull.codes</p>
						<p automationid="fyp_article_description">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
					</content>
				</article>


				<article id="article3" automationid="fyp_article_3">
					<header>
						<h1>Lorem Ipsum Dolar Soleh 1</h1>
					</header>
					<content>
						<p automationid="fyp_article_date">Posted on 13th August 2019 by mull.codes</p>
						<p automationid="fyp_article_description">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

						<form automationid="form_article" action="<?php echo $BASE_URL; ?>/index.php#mailto" method="post">
							<label>First Name: 
								<input type="text" automationid="form_article_input_fname" name="fname" id="fname" placeholder="Enter first name">
							</label>

							<label>Last Name: 
								<input type="text" automationid="form_article_input_lname" name="lname" id="lname" placeholder="Enter last name">
							</label>
							<input type="submit" automationid="form_article_btn_submit" name="btnSubmit" id="btnSubmit" value="Submit Data">
						</form>
					</content>
				</article>
			</div>
		</main>

		<footer class="copy" id="copy">
			<p class="text-muted text-center p-3">Copyright &copy; <?php echo date('Y'); ?>. All rights reserved</p>
		</footer>
	</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>