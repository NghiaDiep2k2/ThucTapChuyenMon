<?php
include "connect.php";
$sdt = $_POST['sdt'];
$gmail = $_POST['gmail'];
$tongtien = $_POST['tongtien'];
$iduser = $_POST['iduser'];
$diachi = $_POST['diachi'];
$soluong = $_POST['soluong'];
$chitiet = $_POST['chitiet'];

// Tạo câu truy vấn SQL và thực thi nó
$query = 'INSERT INTO `donhang` (`iduser`, `diachi`, `sodienthoai`, `gmail`, `soluong`, `tongtien`) VALUES ('.$iduser.', "'.$diachi.'", "'.$sdt.'", "'.$gmail.'", '.$soluong.', "'.$tongtien.'")';

$data = mysqli_query($conn, $query);
// Kiểm tra kết quả trả về từ câu truy vấn SQL
if ($data == true) {
    // Nếu thành công, trả về ID của đơn hàng vừa tạo
    $query = 'SELECT id AS iddonhang FROM `donhang` WHERE `iduser` = '.$iduser.' ORDER BY id DESC LIMIT 1';
    $data = mysqli_query($conn, $query);

    while ($row = mysqli_fetch_assoc($data)) {
        $iddonhang = $row["iddonhang"];
    }

    if (!empty($iddonhang)){
    // co don hang
        $chitiet = json_decode($chitiet, true);
        foreach ($chitiet as $key => $value) {
            $truyvan = 'INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`) VALUES ('.$iddonhang.', '.$value["idsp"].', '.$value["soluong"].', "'.$value["giasp"].'")';
            $data = mysqli_query($conn, $truyvan);

            // xu li sltonkho
            $truyvankho1 = 'SELECT `sltonkho` FROM `sanphammoi` WHERE `id` = '.$value["idsp"];
            $data1 = mysqli_query($conn, $truyvankho1);
            $sltrenkho = mysqli_fetch_assoc($data1);

            $truyvankho2 = 'UPDATE `sanphammoi` SET `sltonkho` = '.$sltrenkho["sltonkho"] - $value["soluong"].' WHERE `id` =  '.$value["idsp"];
            $data2 = mysqli_query($conn, $truyvankho2);

        }
        if($data == true){
            $arr = [
                'success' => true,
                'message' => "thanh cong",
            ];
        }else{
            $arr = [
                'success' => false,
                'message' => "khong thanh cong",
            ];
        }
        print_r(json_encode($arr));
    }

} else {
    // Nếu không thành công, trả về thông báo lỗi
    $arr = [
        'success' => false,
        'message' => "khong thanh cong",
    ];
    print_r(json_encode($arr));
}
?>
