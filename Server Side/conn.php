<?php

$db_name = "user_sql_database";
$mysql_username = "root";
$mysql_password = "";  // insert root's password
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);

if($conn) {
	echo "Connection success";
}
else {
	echo "Connection not success";
}

?>