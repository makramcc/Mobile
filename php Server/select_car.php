	<?php
	require("mysql/connect.php");
	mysqli_query("SET NAMES UTF8");
	$city=$_REQUEST['city'];
	$brand=$_REQUEST['brand'];
	$model=$_REQUEST['model'];
	$f_date=$_REQUEST['first_date'];
	$e_date=$_REQUEST['end_date'];

	//SELECT * FROM Car WHERE id_car= ANY
	//	(SELECT Car_id FROM Oder WHERE id_car=ANY(
	//	SELECT id_car FROM Car	 WHERE car_brand='HONDA' AND car_model='CIVIC' AND city='ลำปาง') AND first_date NOT BETWEEN '2001/1/3' AND '2001/2/9' AND end_date NOT BETWEEN '2001/1/3' AND '2001/2/9')
	
	$subsql1="SELECT id_car FROM Car";
	$c=0;
	if(isset($brand)){
		if($c==0){
			$subsql1 .= " WHERE car_brand='$brand'";
			$c++;
		}else{
			$subsql1 .= " AND car_brand='$brand'";
		}
	}
	if(isset($model)){
		if($c==0){
			$subsql1 .= " WHERE car_model='$model'";
			$c++;
		}else{
			$subsql1 .= " AND car_model='$model'";
		}
	}
	if(isset($city)){
		if($c==0){
			$subsql1 .= " WHERE city='$city'";
			$c++;
		}else{
			$subsql1 .= " AND city='$city'";
		}
	}
		
	$subsql2 = "SELECT Car_id FROM Oder WHERE Car_id=ANY ($subsql1) AND first_date NOT BETWEEN '$f_date' AND '$e_date' AND end_date NOT BETWEEN '$f_date' AND '$e_date' ";
	$subsql3="SELECT Car_id FROM Oder WHERE Car_id=ANY ($subsql1) AND first_date  BETWEEN '$f_date' AND '$e_date' AND end_date  BETWEEN '$f_date' AND '$e_date' ";
	
	$sql="SELECT id_car FROM Car WHERE id_car = ANY($subsql2)";
	$result=mysqli_query($link,$sql);
	while($arr=mysqli_fetch_array($result)){
		$result1[]=$arr[0];
		
	}
	
	$sql="SELECT id_car FROM Car WHERE id_car = ANY($subsql3)";
	$result=mysqli_query($link,$sql);
	while($arr=mysqli_fetch_array($result)){
		$result2[]=$arr[0];
		
	}
	
	$i=sizeof($result1);
	$j=sizeof($result2);
	if($i<$j){
		for($a=$i;$a<$j;$a++){
			$id[]=$result2[$a] ;
		}
	}else{
		for($a=$j;$a<$i;$a++){
			$id[]= $result1[$a];
		}
	}
	
	$j=sizeof($id);
	$i=0;
	while($i<$j){
		$sql = "SELECT * FROM Car WHERE id_car= $id[$i] ";
		$result=mysqli_query($link,$sql);
		while($arr=mysqli_fetch_assoc($result)){
		$resultJson[]=$arr;
		}
		$i++;
	}
	
	echo json_encode($resultJson);

	//require("mysql/uncon.php");
?>

