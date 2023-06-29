<?php
include "connect.php";
$gmail = $_POST['gmail'];
$pass = $_POST['pass'];

$query = 'SELECT * FROM `user` WHERE `gmail` = "'.$gmail.'" AND `pass` = "'.$pass.'"';
$data = mysqli_query($conn, $query);
$result = array();
while ($row = mysqli_fetch_assoc($data)) {
    $result[] = ($row);
    // code...
}
if (!empty($result)) {
    $arr = [
        'success' => true,
        'message' => "thanh cong",
        'result' => $result
    ];
}else{
    $arr = [
        'success' => false,
        'message' => " khong thanh cong",
        'result' => $result
    ];
}
print_r(json_encode($arr));

?>