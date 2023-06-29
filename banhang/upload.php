<?php 
include "connect.php";

$target_dir = "images/";  
 
// Get the highest id from the table
$query = "SELECT max(id) as id from sanphammoi";
$data = mysqli_query($conn, $query);
$result = mysqli_fetch_assoc($data);

// Determine the filename for the uploaded image
if ($result['id'] == null) {
   $name = 1;
} else {
   $name = ++$result['id'];
}
$name = $name . ".jpg";
$target_file_name = $target_dir . $name;

if (isset($_FILES["file"])) {  
   if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file_name)) {  
      $arr = [
         'success' => true,
         'message' => "Upload thành công",
         'name' => $name
      ];
   } else {  
      $arr = [
         'success' => false,
         'message' => "Upload không thành công",
      ];
   }  
} else {  
   $arr = [
      'success' => false,
      'message' => "Lỗi",
   ];
}  

echo json_encode($arr);  
?>
