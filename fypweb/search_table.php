<?php
	$BASE_URL = "http://localhost/fyp";

	$active_page = "search_table";
?>

<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- Bootstrap Font Awesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<title>Test Web Page Search Table</title>

	<style type="text/css">
		body {
			background-color: #787878;
		}
	</style>
</head>
<body>
	<div class="container bg-white mb-4 mt-4 p-0">
		<?php include 'main_menu.php'; ?>

		<main class="main" id="main">
			<div class="p-3">
				<h1 class="display-4">Search Table</h1>
				<p><small class="text-muted">This page will be used to analyse a search form along with a table which may display some results!</small></p>
				<p class="text-danger"><small><i class="fa fa-info-circle"></i> Search Table without nested div</small></p>
				<hr>
				<!-- Search table without nested div -->
				<form class="pr-0" action="<?php echo $BASE_URL; ?>/search" method="POST">
					<div class="form-group row no-gutters float-right clearfix">
						<div class="col-sm-8">
							<input style="border-bottom-right-radius: 0px; border-top-right-radius: 0px;" type="search" name="searchInput" id="searchInput" automationid="input_search_without_nested" class="form-control" placeholder="Enter keywords">
						</div>
						<input style="border-top-left-radius: 0px; border-bottom-left-radius: 0px;" type="submit" name="submitSearch" id="submitSearch" automationid="btn_submit_search_without_nested" class="btn btn-primary col-sm-4" value="Search">
					</div>
				</form>
				
				<table automationid="tbl_search_without_nested" class="table bg-light">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">First</th>
				      <th scope="col">Last</th>
				      <th scope="col">Handle</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				    </tr>
				    <tr>
				      <th scope="row">2</th>
				      <td>Jacob</td>
				      <td>Thornton</td>
				      <td>@fat</td>
				    </tr>
				    <tr>
				      <th scope="row">3</th>
				      <td>Larry</td>
				      <td>the Bird</td>
				      <td>@twitter</td>
				    </tr>
				  </tbody>
				</table>

				<!-- Search table with nested divs -->
				<div class="mt-4 bg-warning p-3 rounded">
					<p class="text-dark"><small><i class="fa fa-info-circle"></i> <b>Search Table with nested div</b></small></p>
					<hr class="bg-dark">

					<div id="search">
						<div class="form">
							<form class="pr-0" action="<?php echo $BASE_URL; ?>/search" method="POST">
								<div class="form-group row no-gutters float-right clearfix">
									<div class="col-sm-8">
										<input style="border-bottom-right-radius: 0px; border-top-right-radius: 0px;" type="search"  placeholder="Enter keywords">
									</div>
									<input style="border-top-left-radius: 0px; border-bottom-left-radius: 0px;" type="submit"  value="Search">
								</div>
							</form>
						</div>
						<div id="table">
							<table automationid="tbl_search_nested" class="table table-dark ">
							  <thead>
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">First</th>
							      <th scope="col">Last</th>
							      <th scope="col">Handle</th>
							    </tr>
							  </thead>
							  <tbody>
							    <tr>
							      <th scope="row">1</th>
							      <td>Mark</td>
							      <td>Otto</td>
							      <td>@mdo</td>
							    </tr>
							    <tr>
							      <th scope="row">2</th>
							      <td>Jacob</td>
							      <td>Thornton</td>
							      <td>@fat</td>
							    </tr>
							    <tr>
							      <th scope="row">3</th>
							      <td>Larry</td>
							      <td>the Bird</td>
							      <td>@twitter</td>
							    </tr>
							  </tbody>
							</table>
						</div>
					</div>
				</div>
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