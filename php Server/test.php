	<?php
	require("mysql/connect.php");
	mysqli_query("SET NAMES UTF8");
	$city=$_REQUEST['city'];
	$arr=array();
	$arr=array("city",$city);
	echo json_encode($arr);

	//require("mysql/uncon.php");
?>
