<?php
include "connect.php";
$tensp = $_POST['tensp'];
$giasp = $_POST['giasp'];
$hinhanh = $_POST['hinhanh'];
$mota = $_POST['mota'];
$loai = $_POST['loai'];
$id = $_POST['id'];
$sl = $_POST['slsp'];

$query = 'UPDATE `sanphammoi` SET `tensp`="'.$tensp.'",`giasp`="'.$giasp.'", `sltonkho`="'.$sl.'", `hinhanh`="'.$hinhanh.'",`mota`="'.$mota.'",`loai`="'.$loai.'" WHERE `id` = '.$id;
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