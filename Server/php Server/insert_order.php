<?php
	require("mysql/connect.php");
	
	$car_id = $_REQUEST['car_id'];
	$f_date = $_REQUEST['first_date'];//y-m-d
	$e_date = $_REQUEST['end_date'];
	$place_x = $_REQUEST['place_x'];
	$place_y = $_REQUEST['place_y'];
	$name = $_REQUEST['name'];
	$tel = $_REQUEST['tel'];
	$id_pass=$_REQUEST['passport'];
	$id_no=$_REQUEST['id_driving'];
	$Email=$_REQUEST['Email'];
	$time=$_REQUEST['time'];
	$city=$_REQUEST['city'];

	
	$sql="SELECT order_id FROM Oder";
	
	$result=mysqli_query($link,$sql);
	while($arr = mysqli_fetch_array($result)){
	$order_id=$arr[0];
	}
	$order_id++;
	$sql = "INSERT INTO `Oder`(`order_id`, `Car_id`, `name`, `id_passport`, `id_driving`, `tel`, `Email`, `first_date`, `end_date`, `place_x`, `place_y`,city,time) VALUES ($order_id,$car_id,'$name','$id_pass','$id_no','$tel','$Email','$f_date','$e_date',$place_x,$place_y,'$city','$time')";
	$result=mysqli_query($link,$sql);
	

			
	if($result){
		echo $order_id;
	}
	//require("mysql/uncon.php");
?>