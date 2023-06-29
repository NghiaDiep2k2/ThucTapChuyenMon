<?php
include "connect.php";
$id = $_POST['id'];
$trangthai = $_POST['trangthai'];

$query = 'UPDATE `donhang` SET `trangthai`='.$trangthai.' WHERE `id` ='.$id;
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