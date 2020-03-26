<?php
	$BASE_URL = "http://localhost/fyp";

	$active_page = "contact";
?>

<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

	<title>Test Web Page Contact</title>

	<style type="text/css">
		body {
			background-color: #787878;
		}
	</style>
</head>
<body>
	<div class="container bg-white mb-4 mt-4 p-0">
		<?php include 'main_menu.php'; ?>

		<main automationid="main_dom" class="main" id="main">
			<div class="contact p-3">
				<h1 automationid="page_title">Contact Us</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
				quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
				consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
				cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
				proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

				<form automationid="form_contact" action="<?php echo $BASE_URL; ?>/contactus.php" method="post">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email address</label>
				    <input automationid="input_email" name="input_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password</label>
				    <input automationid="input_password" name="input_password" type="password" class="form-control" id="exampleInputPassword1">
				  </div>
				  <div class="form-group form-check">
				    <input automationid="input_checkbox" name="input_checkbox" type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Check me out</label>
				  </div>
				  <button automationid="button_submit_contact" name="button_submit_contact" type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</main>

		<?php include 'footer.php'; ?>
	</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>