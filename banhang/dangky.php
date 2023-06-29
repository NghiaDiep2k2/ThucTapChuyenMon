<?php
include "connect.php";
$gmail = $_POST['gmail'];
$pass = $_POST['pass'];
$username = $_POST['username'];
$mobile = $_POST['mobile'];
$uid = $_POST['uid'];

// Check if user already exists
$query = 'SELECT * FROM `user` WHERE `gmail` = "'.$gmail.'"';
$data = mysqli_query($conn, $query);
$numrow = mysqli_num_rows($data);

if ($numrow > 0){
    $arr = [
        'success' => false,
        'message' => "Gmail đã tồn tại",
    ];
}else{
    // Insert user data into the database
    $query = 'INSERT INTO `user`(`gmail`, `username`, `pass`, `mobile`, `uid`) VALUES ("'.$gmail.'","'.$pass.'","'.$username.'","'.$mobile.'", "'.$uid.'")';
    $data = mysqli_query($conn, $query);

    if ($data == true) {
        $arr = [
            'success' => true,
            'message' => "Thêm người dùng thành công",
        ];
    }else{
        $arr = [
            'success' => false,
            'message' => "Không thể thêm người dùng",
        ];
    }
}

print_r(json_encode($arr));
?>