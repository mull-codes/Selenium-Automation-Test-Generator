<header>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <a automationid="btn_home_logo" class="navbar-brand" href="<?php echo $BASE_URL; ?>">Navbar</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item <?php if($active_page == "home"){echo "active";} ?>">
			        <a automationid="btn_home" class="nav-link" href="<?php echo $BASE_URL; ?>/index.php">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item <?php if($active_page == "contact"){echo "active";} ?>">
			        <a automationid="btn_contact_us" class="nav-link" href="<?php echo $BASE_URL; ?>/contact.php">Contact Us</a>
			      </li>
			      <li class="nav-item <?php if($active_page == "search_table"){echo "active";} ?>">
			        <a automationid="btn_search_table" class="nav-link" href="<?php echo $BASE_URL; ?>/search_table.php">Search Table</a>
			      </li>

			      <li class="nav-item <?php if($active_page == "about"){echo "active";} ?>">
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