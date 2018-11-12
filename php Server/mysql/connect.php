<?php
require("mysql/config.php");
$link = mysqli_connect($dbhost,$dbuser,$dbpass,$dbname);
mysqli_select_db($link,$dbname);
?>