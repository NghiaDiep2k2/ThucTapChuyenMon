<?php
include "connect.php";

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/Exception.php';
require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';

$gmail = $_POST['gmail'];
$query = 'SELECT * FROM `user` WHERE `gmail` = "'.$gmail.'"';
$data = mysqli_query($conn, $query);
$result = array();
while ($row = mysqli_fetch_assoc($data)) {
    $result[] = ($row);
    // code...
}

  if (empty($result)) {
    $arr = [
        'success' => false,
        'message' => "Gmail không chính xác",
        'result' => $result
    ];
  }else{
    // send mail
      $email=($result['gmail']);
      $pass=($result['pass']);

      $link="<a href='http://192.168.1.25/banhang/reset_pass.php?key=".$gmail."&reset=".$pass."'>Click To Reset password</a>";
    $mail = new PHPMailer();
    $mail->CharSet =  "utf-8";
    $mail->IsSMTP();
    // enable SMTP authentication
    $mail->SMTPAuth = true;                  
    // GMAIL username
    $mail->Username = "dinhthekiet5199@gmail.com";
    // GMAIL password
    $mail->Password = "12345";
    $mail->SMTPSecure = "ssl";  
    // sets GMAIL as the SMTP server
    $mail->Host = "smtp.gmail.com";
    // set the SMTP port for the GMAIL server
    $mail->Port = "465";
    $mail->From = "dinhthekiet5199@gmail.com"; // mail nguoi nhan
    $mail->FromName='App ban hang';
    $mail->AddAddress($gmail, 'reciever_name');
    $mail->Subject  =  'Reset Password';
    $mail->IsHTML(true);
    $mail->Body    = 'Click On This Link to Reset Password '.$pass.'';
    if($mail->Send())
    {
      echo "Check Your Email and Click on the link sent to your email";
    }
    else
    {
      echo "Mail Error - >".$mail->ErrorInfo;
    }
  }
  print_r($arr);

?>