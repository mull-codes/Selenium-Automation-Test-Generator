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

	<title>Test Web Page About</title>

	<style type="text/css">
		body {
			background-color: #787878;
		}
	</style>
</head>
<body>
	<div class="container bg-white mb-4 mt-4 p-0">
		<header automationid="main_menu">
			<nav automationid="main_menu_nav" class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <a automationid="main_menu_home" class="navbar-brand" href="<?php echo $BASE_URL; ?>">Navbar</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul automationid="main_ul" class="navbar-nav mr-auto">
			      <li class="nav-item ">
			        <a automationid="main_ul_home" class="nav-link" href="<?php echo $BASE_URL; ?>/index.php">Home</a>
			      </li>
			      <li class="nav-item">
			        <a automationid="main_ul_contact" class="nav-link" href="<?php echo $BASE_URL; ?>/contact.php">Contact Us</a>
			      </li>

			      <li class="nav-item active">
			        <a automationid="main_ul_about" class="nav-link" href="<?php echo $BASE_URL; ?>/about.php">About Us</a>
			      </li>
			    </ul>
			    <form automationid="search_form" class="form-inline my-2 my-lg-0">
			      <input automationid="inputSearch" name="inputSearch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			      <button automationid="button_search" name="button_search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
			  </div>
			</nav>
		</header>

		<main class="main" id="main">
			<div class="p-3">
				<h1>About Us</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
				quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
				consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
				cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
				proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
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