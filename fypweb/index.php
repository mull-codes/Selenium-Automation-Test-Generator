<?php
	$BASE_URL = "http://localhost/fyp";

	$active_page = "home";
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
		<?php include 'main_menu_test.php'; ?>

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

		<?php include 'footer.php'; ?>
	</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>