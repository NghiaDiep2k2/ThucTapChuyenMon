<?php
include "connect.php";
$tensp = $_POST['tensp'];
$giasp = $_POST['giasp'];
$hinhanh = $_POST['hinhanh'];
$mota = $_POST['mota'];
$loai = $_POST['loai'];
$sltonkho = $_POST['slsp'];

$query = 'INSERT INTO `sanphammoi`( `tensp`, `giasp`, `hinhanh`, `mota`, `loai`, `sltonkho`) VALUES ("'.$tensp.'","'.$giasp.'","'.$hinhanh.'","'.$mota.'",'.$loai.', '.$sltonkho.')';
$data = mysqli_query($conn, $query);

if ($data == true) {
        $arr = [
            'success' => true,
            'message' => "Thêm sản phẩm thành công",
        ];
    }else{
        $arr = [
            'success' => false,
            'message' => "Thêm sản phẩm không thành công",
        ];
    }

print_r(json_encode($arr));
?>