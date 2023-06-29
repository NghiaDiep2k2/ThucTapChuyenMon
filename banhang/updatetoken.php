<?php
include "connect.php";
$token = $_POST['token'];
$id = $_POST['id'];

$query = 'UPDATE `user` SET `token`= "'.$token.'" WHERE `id` = '.$id;
$data = mysqli_query($conn, $query);

if ($data == true) {
        $arr = [
            'success' => true,
            'message' => "Sửa sản phẩm thành công",
        ];
    }else{
        $arr = [
            'success' => false,
            'message' => "Sửa sản phẩm không thành công",
        ];
    }

print_r(json_encode($arr));
?>