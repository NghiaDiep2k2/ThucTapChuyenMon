-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 29, 2023 lúc 11:11 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `datafoodapp`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `iddonhang` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`) VALUES
(70, 29, 2, '200000'),
(70, 30, 1, '150000'),
(71, 29, 1, '200000'),
(71, 30, 1, '150000'),
(72, 42, 10, '90000'),
(73, 30, 1, '150000'),
(73, 41, 1, '123000'),
(74, 42, 1, '90000'),
(74, 41, 1, '123000'),
(75, 42, 1, '90000'),
(75, 31, 1, '50000'),
(75, 29, 1, '200000'),
(76, 42, 1, '90000'),
(76, 31, 1, '50000'),
(76, 30, 1, '150000'),
(77, 31, 1, '50000'),
(77, 42, 1, '90000'),
(78, 30, 1, '150000'),
(78, 29, 1, '200000'),
(79, 30, 1, '150000'),
(79, 42, 1, '90000'),
(80, 29, 1, '200000'),
(80, 31, 1, '50000'),
(81, 29, 1, '200000'),
(81, 30, 1, '150000'),
(82, 29, 1, '200000'),
(82, 30, 1, '150000'),
(83, 31, 1, '50000'),
(83, 42, 1, '90000'),
(84, 42, 1, '90000'),
(84, 30, 1, '150000'),
(85, 42, 1, '90000'),
(85, 28, 1, '55000'),
(86, 42, 1, '90000'),
(86, 31, 1, '50000'),
(87, 55, 1, '48000'),
(87, 54, 1, '54000'),
(88, 57, 1, '60000'),
(88, 52, 1, '68000'),
(89, 55, 1, '48000'),
(89, 53, 2, '38000'),
(90, 56, 1, '84000'),
(90, 51, 1, '60000'),
(91, 47, 2, '65000'),
(91, 55, 1, '48000'),
(92, 56, 1, '84000'),
(92, 50, 2, '35000'),
(93, 45, 2, '100000'),
(93, 54, 1, '54000'),
(94, 49, 1, '70000'),
(95, 55, 3, '48000'),
(96, 56, 4, '84000'),
(97, 56, 4, '84000'),
(98, 56, 4, '84000'),
(99, 56, 4, '84000'),
(100, 56, 4, '84000'),
(101, 56, 4, '84000'),
(102, 56, 4, '84000'),
(103, 56, 2, '84000'),
(104, 45, 1, '100000'),
(104, 44, 1, '110000'),
(105, 55, 1, '48000'),
(105, 54, 1, '54000'),
(106, 53, 1, '38000'),
(106, 50, 1, '35000'),
(107, 57, 1, '60000'),
(107, 56, 1, '84000'),
(108, 52, 1, '68000'),
(108, 57, 1, '60000'),
(109, 48, 2, '40000'),
(109, 56, 1, '84000'),
(110, 54, 1, '54000'),
(111, 55, 1, '48000'),
(111, 56, 1, '84000'),
(112, 52, 1, '68000'),
(112, 54, 1, '54000'),
(113, 55, 1, '48000'),
(113, 56, 1, '84000'),
(114, 53, 1, '38000'),
(114, 62, 1, '13000'),
(115, 52, 1, '68000'),
(115, 56, 1, '84000'),
(116, 52, 1, '68000'),
(116, 51, 2, '60000'),
(117, 54, 1, '54000'),
(118, 54, 3, '54000'),
(119, 45, 1, '100000'),
(120, 45, 2, '100000'),
(120, 49, 1, '70000'),
(121, 52, 2, '68000'),
(121, 49, 1, '70000'),
(122, 54, 1, '54000'),
(122, 51, 1, '60000'),
(123, 55, 1, '48000'),
(123, 45, 1, '100000'),
(124, 64, 1, '67000'),
(124, 53, 1, '38000'),
(125, 46, 1, '59000'),
(125, 45, 1, '100000'),
(126, 47, 1, '65000'),
(126, 52, 1, '68000'),
(127, 51, 1, '60000'),
(127, 50, 1, '35000'),
(128, 50, 1, '35000'),
(128, 49, 1, '70000'),
(129, 56, 1, '84000'),
(129, 57, 1, '60000'),
(130, 53, 1, '38000'),
(130, 56, 1, '84000'),
(131, 56, 1, '84000'),
(131, 53, 1, '38000'),
(132, 55, 1, '48000'),
(132, 57, 1, '60000'),
(133, 54, 1, '54000'),
(133, 55, 1, '48000'),
(134, 57, 1, '60000'),
(134, 55, 1, '48000'),
(135, 50, 1, '35000'),
(135, 49, 1, '70000'),
(136, 54, 1, '54000'),
(136, 49, 1, '70000'),
(137, 53, 1, '38000'),
(137, 51, 1, '60000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `diachi` text NOT NULL,
  `sodienthoai` varchar(255) NOT NULL,
  `gmail` varchar(255) NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` varchar(255) NOT NULL,
  `trangthai` int(2) NOT NULL DEFAULT 0,
  `ngaydat` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `iduser`, `diachi`, `sodienthoai`, `gmail`, `soluong`, `tongtien`, `trangthai`, `ngaydat`) VALUES
(82, 39, 'kkkkkkkk', '0987654321', 'user1@gmail.com', 2, '350000', 0, '2023-03-16'),
(83, 39, 'wwwwwww', '0987654321', 'user1@gmail.com', 2, '140000', 0, '2023-03-18'),
(85, 39, 'nnmnmn', '0987654321', 'user1@gmail.com', 2, '145000', 0, '2023-03-27'),
(86, 39, 'ghghghghg', '0987654321', 'user1@gmail.com', 2, '140000', 0, '2023-04-05'),
(87, 39, '28 le van viet', '0987654321', 'user1@gmail.com', 2, '102000', 0, '2023-04-11'),
(88, 39, '456 linh lung', '0987654321', 'user1@gmail.com', 2, '128000', 0, '2023-04-21'),
(89, 39, 'pham van dong', '0987654321', 'user1@gmail.com', 3, '124000', 3, '2023-04-23'),
(90, 39, 'thanh cong', '0987654321', 'user1@gmail.com', 2, '144000', 3, '2023-05-01'),
(91, 39, 'ly thai to', '0987654321', 'user1@gmail.com', 3, '178000', 3, '2023-05-05'),
(92, 39, '444 le van viet', '0987654321', 'user1@gmail.com', 3, '154000', 3, '2023-05-16'),
(93, 40, '999 le van viet', '123456789', 'user2@gmail.com', 3, '254000', 3, '2023-05-17'),
(94, 40, '555 le van viet', '123456789', 'user2@gmail.com', 1, '70000', 0, '2023-05-19'),
(95, 40, '16 hai ba trung', '123456789', 'user2@gmail.com', 3, '144000', 3, '2023-06-24'),
(96, 40, '44 le hong phong', '123456789', 'user2@gmail.com', 4, '336000', 0, '2023-06-24'),
(97, 39, 'levanviet', '123456', 'wwwwwwww', 3, '100000', 2, '2023-06-25'),
(102, 39, 'levanviet', '123456', 'wwwwwwww', 3, '100000', 0, '2023-06-25'),
(103, 40, 'la xuan oai', '123456789', 'user2@gmail.com', 2, '168000', 2, '2023-06-25'),
(104, 40, 'le van viet', '123456789', 'user2@gmail.com', 2, '210000', 0, '2023-06-25'),
(105, 39, '666 lê văn việt', '0987654321', 'user1@gmail.com', 2, '102000', 1, '2023-06-25'),
(106, 39, '444 le van viet', '0987654321', 'user1@gmail.com', 2, '73000', 4, '2023-06-25'),
(107, 40, 'le viet 345', '123456789', 'user2@gmail.com', 2, '144000', 2, '2023-06-25'),
(108, 40, 'ho chi minh', '123456789', 'user2@gmail.com', 2, '128000', 2, '2023-06-25'),
(109, 39, '449 le hong phong', '0987654321', 'user1@gmail.com', 3, '164000', 0, '2023-06-25'),
(110, 39, '444 lim lim', '0987654321', 'user1@gmail.com', 1, '54000', 3, '2023-06-25'),
(111, 40, 'mmmmm', '123456789', 'user2@gmail.com', 2, '132000', 1, '2023-06-26'),
(112, 40, 'nnnnnn', '123456789', 'user2@gmail.com', 2, '122000', 2, '2023-06-26'),
(113, 39, 'nnnnn', '0987654321', 'user1@gmail.com', 2, '132000', 0, '2023-06-26'),
(114, 39, 'mmmmmm', '0987654321', 'user1@gmail.com', 2, '51000', 0, '2023-06-26'),
(115, 39, 'ngngngng', '0987654321', 'user1@gmail.com', 2, '152000', 4, '2023-06-26'),
(116, 39, 'eeeeee', '0987654321', 'user1@gmail.com', 3, '188000', 2, '2023-06-26'),
(117, 39, 'ppppppp', '0987654321', 'user1@gmail.com', 1, '54000', 0, '2023-06-26'),
(118, 39, 'ooooooooooo', '0987654321', 'user1@gmail.com', 3, '162000', 3, '2023-06-26'),
(119, 39, 'Le Van Viet', '0987654321', 'user1@gmail.com', 1, '100000', 0, '2023-06-26'),
(120, 39, 'le van viet', '0987654321', 'user1@gmail.com', 3, '270000', 0, '2023-06-27'),
(121, 39, 'thanh cong', '0987654321', 'user1@gmail.com', 3, '206000', 3, '2023-06-27'),
(122, 39, '4444 le van viet', '0987654321', 'user1@gmail.com', 2, '114000', 1, '2023-06-27'),
(123, 40, '434 le van viet', '123456789', 'user2@gmail.com', 2, '148000', 2, '2023-06-27'),
(124, 42, '454 le van viet', '1234554321', 'user3@gmail.com', 2, '105000', 3, '2023-06-28'),
(125, 42, '777 tran van lieu', '1234554321', 'user3@gmail.com', 2, '159000', 3, '2023-06-28'),
(126, 42, '555 linh lung', '1234554321', 'user3@gmail.com', 2, '133000', 2, '2023-06-28'),
(127, 42, 'nmnmnm', '1234554321', 'user3@gmail.com', 2, '95000', 1, '2023-06-28'),
(128, 42, 'wwwwww', '1234554321', 'user3@gmail.com', 2, '105000', 0, '2023-06-28'),
(129, 42, 'qwertyu', '1234554321', 'user3@gmail.com', 2, '144000', 3, '2023-06-28'),
(130, 42, 'asdasdasd', '1234554321', 'user3@gmail.com', 2, '122000', 0, '2023-06-28'),
(131, 42, 'zxczxc', '1234554321', 'user3@gmail.com', 2, '122000', 0, '2023-06-28'),
(132, 42, 'zxczxc', '1234554321', 'user3@gmail.com', 2, '108000', 4, '2023-06-28'),
(133, 42, 'zxczxczxc', '1234554321', 'user3@gmail.com', 2, '102000', 3, '2023-06-28'),
(134, 42, 'asdasdasd', '1234554321', 'user3@gmail.com', 2, '108000', 3, '2023-06-28'),
(135, 42, 'qweqweqwe', '1234554321', 'user3@gmail.com', 2, '105000', 2, '2023-06-28'),
(136, 43, 'vvvvvvvv', '2342342345', 'user4@gmail.com', 2, '124000', 3, '2023-06-28'),
(137, 43, '499 le van viet', '2342342345', 'user4@gmail.com', 2, '98000', 1, '2023-06-29');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) NOT NULL,
  `hinhanh` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Trang chủ', 'https://media.istockphoto.com/id/1136261351/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-home-building-line-stroke-c%C3%B3-th%E1%BB%83-ch%E1%BB%89nh-s%E1%BB%ADa-pixel-ho%C3%A0n-h%E1%BA%A3o-d%C3%A0nh-cho-thi%E1%BA%BFt-b%E1%BB%8B-di.jpg?s=612x612&w=0&k=20&c=lV80FNg5A3Ko1WaKB-_Hm7OTNNIJ24DFERbgGZqg2jA='),
(4, 'Pizza', 'https://media.istockphoto.com/id/700176352/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-pizza-slice-vector.jpg?s=612x612&w=0&k=20&c=dDYAWYv3f1S0Zgc35A5xZiViRPHkkoToRK_ZBuEBcNw='),
(5, 'Hamburger', 'https://media.istockphoto.com/id/1184633031/vi/vec-to/phim-ho%E1%BA%A1t-h%C3%ACnh-burger-vector-c%C3%B4-l%E1%BA%ADp-minh-h%E1%BB%8Da.jpg?s=612x612&w=0&k=20&c=NhpZg4FMr-UowMaJS0bqh5CiDkIzGKMy0fuVYohu9hw='),
(6, 'Hotdog', 'https://media.istockphoto.com/id/1309574979/vi/vec-to/b%E1%BB%AFa-%C4%83n-nhanh-x%C3%BAc-x%C3%ADch-m%E1%BB%B9-v%E1%BB%9Bi-m%C3%B9-t%E1%BA%A1t-b%E1%BB%8B-c%C3%B4-l%E1%BA%ADp-tr%C3%AAn-n%E1%BB%81n-tr%E1%BA%AFng.jpg?s=612x612&w=0&k=20&c=04PGb7PefH9tRr3T_3mVEUbLR7BaYeDo0ZK7FLaERys=');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanphammoi`
--

CREATE TABLE `sanphammoi` (
  `id` int(11) NOT NULL,
  `tensp` varchar(250) NOT NULL,
  `giasp` varchar(100) NOT NULL,
  `hinhanh` text NOT NULL,
  `mota` text NOT NULL,
  `loai` int(3) NOT NULL,
  `sltonkho` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanphammoi`
--

INSERT INTO `sanphammoi` (`id`, `tensp`, `giasp`, `hinhanh`, `mota`, `loai`, `sltonkho`) VALUES
(1, 'Pizza Pepperoni', '170000', 'https://media.istockphoto.com/id/183889977/vi/anh/pepperoni-pizza-tr%C3%AAn-tr%E1%BA%AFng.jpg?s=612x612&w=0&k=20&c=oHfzDyIyl2ZS0kgtxJcR5tT0gh13JAITNb8jC5XPjzA=', 'Pepperoni là một phiên bản salami có xuất xứ từ Hoa Kỳ, được làm từ hỗn hợp thịt lợn và thịt bò ướp với Paprika hoặc các loại bột ớt khác. Đặc trưng của Pepperoni là mềm, hơi ám khói và có màu đỏ tươi. Pepperoni cắt lát mỏng là một loại topping pizza', 1, 9),
(2, 'Pizza Vegetable', '150000', 'https://media.istockphoto.com/id/635675852/vi/anh/pizza-tr%C3%AAn-n%E1%BB%81n-tr%E1%BA%AFng.jpg?s=612x612&w=0&k=20&c=NTN_bcth-lFGfWdo5_Cb9VKvxLiKoUKetVBfCIztap8=', 'Nó tươi và đầy hương vị, có cà chua bi, atisô, ớt chuông, ô liu, hành tím và một ít rau bina non (và tùy chọn). Tất nhiên, bạn sẽ tìm thấy một lớp nền là nước sốt cà chua đậm đà và phô mai mozzarella sủi bọt vàng óng bên dưới.', 1, 10),
(3, 'Chesses Hamburger', '50000', 'https://media.istockphoto.com/id/1125149183/vi/anh/burger-t%C6%B0%C6%A1i-b%E1%BB%8B-c%C3%B4-l%E1%BA%ADp.jpg?s=612x612&w=0&k=20&c=_rK8UMgUBe68r2Ww2aZHL9qx6uayLEsDAsjhPyKch_w=', 'Hamburger pho mát hay Burger phô mai là một loại hamburger với topping là pho mát. Theo truyền thống, miếng pho mát thường được đặt bên trên miếng thịt. Người ta thường cho thêm pho mát vào miếng thịt bò xay đang nấu trong thời gian ngắn, điều này tạo điều kiện cho pho mát tan chảy.', 2, 10),
(4, 'Chesse Hotdog ', '55000', 'https://media.istockphoto.com/id/157483425/vi/anh/hot-dog-v%E1%BB%9Bi-t%E1%BA%A5t-c%E1%BA%A3-c%C3%A1c-s%E1%BB%ADa-ch%E1%BB%AFa.jpg?s=612x612&w=0&k=20&c=nPn0SO_CFTBuSeKV0IrltrmbBwPIHFg4mYq12NlA0w4=', 'Chesse hotdog là loại xúc xích được nhồi với phô mai. Phô mai có thể được đặt vào giữa xúc xích hoặc nó có thể được bọc quanh bên ngoài xúc xích và sau đó được nấu chảy. ', 3, 10),
(44, 'Pizza Bò Băm', '110000', 'https://file.hstatic.net/1000389344/file/_5_beefy_42507a208610490e8f4582b3f90f2332_grande.jpg', 'Vị chua chua, ngọt ngọt của dứa kết hợp với vỏ bánh giòn xốp cùng với thịt bò băm có thể tạo nên hương vị pizza đặc trưng khiến bạn nhớ mãi chẳng quên. Cũng bởi vậy mà pizza bò băm luôn là \"best-seller\" trong menu của các tiệm bánh pizza nổi tiếng. Bạn hoàn toàn có thể thực hiện làm món ngon này ngay tại nhà để phục vụ những người thương yêu trong gia đình mình. ', 0, 10),
(45, 'Hamburger Cá Hồi', '100000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/burger-ca-hoi-500.jpg.webp', 'Hamburger Cá Hồi là một loại bánh hamburger được làm từ thịt cá hồi tươi, kết hợp với các nguyên liệu như bánh hamburger, rau xà lách, cà chua, hành tây và sốt. Thịt cá hồi được cắt thành miếng vừa phải, sau đó được nướng chín trên lò hoặc chiên giòn. Bánh hamburger có thể được sử dụng trong loại ăn này, hoặc bạn cũng có thể sử dụng bánh ướt cho món ăn này. Món ăn này mang lại hương vị thơm ngon của cá hồi kết hợp với các nguyên liệu tươi ngon khác, tạo nên một món ăn hamburger độc đáo và hấp dẫn.', 2, 10),
(46, 'Hotdog Sốt Ớt', '59000', 'https://media.istockphoto.com/id/912204990/vi/anh/x%C3%BAc-x%C3%ADch-%E1%BB%9Bt-m%E1%BB%9Bi-n%C6%B0%E1%BB%9Bng.jpg?s=612x612&w=0&k=20&c=onTrzyCm_CTuNoFVh9HW3HISCKlBkYMeTlsdhKW3xVQ=', 'Hotdog sốt ớt là một món ăn đường phố phổ biến và ngon miệng. Nó gồm một ổ bánh mì hình trụ chứa xúc xích hoặc lát thịt, được nướng chín tới vàng và giòn. Đặc điểm nổi bật của hotdog sốt ớt là sốt ớt, một loại sốt cay và thường có vị đậm đà. Sốt ớt trong hotdog thường được làm từ các thành phần như ớt cay, tỏi, hành và các gia vị khác nhau.', 3, 10),
(47, 'Pizza Hải Sản', '65000', 'https://file.hstatic.net/1000389344/file/hai_san_d85e63b59c784f2d84eb40cdeaba186d_grande.jpg', 'Mùa hạ như thôi thúc con người tìm đến những hương vị của biển cả. Chiếc pizza này có hương vị mặn, ngọt cân bằng. Khi ăn, thực khách sẽ cảm nhận được vị tươi ngon từ hải sản, vị béo ngậy của phô mai, vị thơm của vỏ bánh. Tín đồ của hải sản chắc chắn sẽ không thể bỏ lỡ chiếc pizza này.', 1, 10),
(48, 'Hamburger Trứng', '40000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/bugger-trung-ga-ap-chao-500.jpg.webp', 'Burger trứng là một loại bánh hamburger được làm từ thịt bò xay, bánh mì hamburger, trứng và các loại rau củ khác như cà chua, xà lách, hành tây... Thường được chiên trên bếp hoặc nướng trên lò để tạo ra một lớp vỏ giòn bên ngoài và phần ức gà mềm mại bên trong. Bánh burger trứng có vị ngọt thanh của thịt bò, vị béo của trứng và hương vị tươi mát của rau củ. Nó được ăn kèm với sốt mayonnaise hoặc các loại sốt khác để tăng thêm hương vị.', 2, 10),
(49, 'Pizza Hawaii', '70000', 'https://file.hstatic.net/1000389344/file/_2-pizza-hawaii__3__44ce0f70809e4cb3a312e4b07673b66b_grande.jpg', 'Pizza hawaii mang cái tên rất địa phương khiến nhiều người cho rằng loại bánh này có nguồn gốc từ Hawaii, tuy nhiên món ăn này lại có xuất xứ từ Canada do một người Hy Lạp nghĩ ra và đã nhanh chóng trở thành loại pizza không thể thiếu trong thực đơn của mọi cửa hàng đồ Âu. Khác với các loại pizza khác có thể đoán được nguyên liệu chính của chúng qua tên gọi thì Pizza Hawaii nghe thực sự lạ phải không nào. Pizza hawaii mang mùi hương nhiệt đới, với sự tương phản giữa vị chua, ngọt của dứa và mặn của dăm bông khiến nhiều thực khách bất ngờ.', 1, 10),
(50, 'Hamburger Bí Đỏ', '35000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/hamburger-bi-do_540-360.jpg.webp', 'Hamburger bí đỏ là một loại bánh hamburger được làm từ thịt bò xay, bánh mì hamburger và phần nhân bí đỏ. Bí đỏ được làm nát và trộn đều với phần thịt bò xay, tạo ra một hỗn hợp có màu sắc và hương vị đặc trưng của bí đỏ. Sau đó, hỗn hợp này được chia thành các miếng và chiên hoặc nướng trên lò để tạo ra một lớp vỏ giòn bên ngoài và phần nhân mềm mại bên trong.', 2, 10),
(51, 'Pizza Gà', '60000', 'https://file.hstatic.net/1000389344/file/pizza_ga_9ca9c67798fd4edd8093ffb00ad74b39_grande.jpg', 'Pizza gà có lẽ vô cùng quen thuộc với dân nghiện pizza bởi tính phổ thông và dễ ăn của loại pizza này. Thịt gà là một món ăn bổ dưỡng, giúp gia tăng vị giác của bất cứ món ăn nào mà chúng góp mặt. Đặc biệt những bạn đam mê gà thì không thể bỏ qua chiếc bánh pizza nhân gà phải không nào, chiếc bánh với gà là loại topping chính hòa quyện cùng sốt phô mai thơm lừng thực sự khó cưỡng.', 1, 10),
(52, 'Pizza Margherita', '68000', 'https://file.hstatic.net/1000389344/file/_1-pizza-maghetina__3__cafe82a393b745b8b71fee8e7e2c76b9_grande.jpg', 'Pizza margherita được coi là chiếc bánh nổi tiếng nhất thế giới do một đầu bếp vùng Naples, Italy sáng tạo ra với cái tên được lấy cảm hứng từ nữ hoàng Margherita . Pizza margherita là hiện thân của mùa hạ với hương vị đậm đà với sự tươi mới của sốt cà chua, độ dai dai của phomai mozzarella. Loại bánh này mang một hương vị rất riêng với các loại nguyên liệu tươi rói được tuyển chọn kỹ lưỡng chắc chắn sẽ làm bạn hài lòng. ', 1, 10),
(53, 'Hamburger Gà Xé', '38000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/Hamburger-ga-xe-540-360.jpg.webp', 'Hamburger gà xé là một món ăn rất ngon và phổ biến. Đây là một loại bánh hamburger được làm từ bánh mì nướng, thịt gà xé nhỏ và các loại rau củ tươi sống như cà chua, dưa leo, hành tây và rau xà lách.', 2, 10),
(54, 'Pizza Nhân Nhồi', '54000', 'https://file.hstatic.net/1000389344/file/nhan_nhoi_715fdb8626864457890c77c6ed147f03_grande.jpg', 'Khác với các loại pizza thông thường thì pizza nhân nhồi có kích thước khổng lồ với phần đế dày, nhiều nhân và  lượng phô mai Mozzarella của bánh nhiều gấp 3 lần các loại khác, hòa quyện cùng thịt và nước sốt thực sự là không thể cưỡng lại. Vì vậy, chỉ mới xuất hiện nhưng loại bánh này đã thu hút một lượng người hâm mộ không hề nhỏ, luôn trở thành món ăn đắt khách tại các quầy pizza.', 1, 10),
(55, 'Hamburger Mehico', '48000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/Hamburger-kieu-Mehico.webp', 'Hamburger Kiểu Mehico là một loại hamburger được lấy cảm hứng từ ẩm thực của Mexico. Thay vì sử dụng bánh mì trong suất ăn, loại hamburger này thường được đặt trên một miếng bánh tortilla mềm mại. Thịt bò xay được nấu chín với các gia vị như tỏi, hành tây, ớt và rau diếp cá. Sau khi nước sốt được thấm đều vào thịt bò, người ta cho pho mát cheddar nóng chảy lên trên. Cuối cùng, loại hamburger này thường được trang trí với các thành phần như salsa, guacamole hoặc kem tươi để tạo ra một món ăn burger vừa ngon miệng, lại vừa đậm đà hương vị Mexico.', 2, 10),
(56, 'Pizza Sốt Pesto', '84000', 'https://file.hstatic.net/1000389344/file/sot_pesto_bd33950bd55d4807a1d860d1d7f4445e_grande.jpg', 'Sốt Pesto có vị béo ngậy của phô mai, mùi thơm đặc trưng từ lá húng tây (basil), ngò rí và cuối cùng là vị mặn nhẹ của muối. Với hương bị béo ngậy của phô mai cùng với cà chua tươi và sốt Pesto đậm đà, món pizza hải sản trở nên hấp dẫn hơn bao giờ hết.', 1, 10),
(57, 'Burger Cá Ngừ', '60000', 'https://monngonmoingay.com/wp-content/uploads/2021/10/IMG_0031-burger-ca-ngu.png.webp', 'Burger cá ngừ là một loại burger được làm từ thịt cá ngừ tươi, cắt thành miếng nhỏ và trộn đều với các gia vị như hành tây, tỏi, ớt và các loại gia vị khác. Sau đó, hỗn hợp này được nấu chín trên bếp hoặc nướng trên lò nướng cho đến khi chín và vàng. Khi đã chín, thịt cá ngừ được đặt vào giữa 2 miếng bánh mì hamburger cùng với các loại rau và sốt tuỳ thích.', 2, 10),
(64, 'Pizza Gà', '70000', '58.jpg', 'Pizza gà có lẽ vô cùng quen thuộc với dân nghiện pizza bởi tính phổ thông và dễ ăn của loại pizza này. Thịt gà là một món ăn bổ dưỡng, giúp gia tăng vị giác của bất cứ món ăn nào mà chúng góp mặt. Đặc biệt những bạn đam mê gà thì không thể bỏ qua chiếc bánh pizza nhân gà phải không nào, chiếc bánh với gà là loại topping chính hòa quyện cùng sốt phô mai thơm lừng thực sự khó cưỡng.', 1, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `gmail` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `uid` text NOT NULL,
  `token` text NOT NULL,
  `status` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `gmail`, `pass`, `username`, `mobile`, `uid`, `token`, `status`) VALUES
(36, 'diepnghia111110@gmail.com', '123456', 'nghia diep', '1234598765', 'pEqEF5lWEwQDdoJ60s2cvtObFUv2', 'fLe1230bQ1Cg-S6oSFWgB3:APA91bEA_s8HNHryeVhm1tsjOTey-yoUbi7-vBTdrEEx5CQAe8fBt_z0Q1T-u97C0gX6jerZlylfevGs3TvTaiqU-qvU6cgZwhv6vNXD6EGBrUsLw4a5Qgl2djVYrRFkmeLzSAZfZLFQ', 1),
(39, 'user1@gmail.com', '123456', 'user 1', '0987654321', 'aD804tMUZreZ4lwRmGLEc2e33sg2', 'cNrmOAgZTs26FgLB3rrhq1:APA91bFq3TZihiereQR5DghyqeBTe5jZmNgJjmWyiJScLxBGlcn5d60_VHUDL_aWHMuSSgVKhGWrS2Q_VYb8iUu1EEQORR7kkKegmWZhoo5oeSgoNisI1sFBDzgqc-W7aaXJUCoAFEfW', 0),
(40, 'user2@gmail.com', '123456', 'user 2', '123456789', 'WEz319gzxsfwEoSzfXLjdhKyrii2', 'cNrmOAgZTs26FgLB3rrhq1:APA91bFq3TZihiereQR5DghyqeBTe5jZmNgJjmWyiJScLxBGlcn5d60_VHUDL_aWHMuSSgVKhGWrS2Q_VYb8iUu1EEQORR7kkKegmWZhoo5oeSgoNisI1sFBDzgqc-W7aaXJUCoAFEfW', 0),
(41, 'admin1@gmail.com', '1234567', 'admin 1', '0908070605', 'cfQVXdABZMZXVXu43g2NclO4utm1', 'eW56MVLdQMOHLs-aOFolcx:APA91bG9WtrIXaaCzu611BSJb7UrCglEt03H92F7fiJmaZGk2seBzasc5TQ8T6StLyh2fzq27i22kfMAhJLWtbfeSGllJaHfgAvfDgdftDGfMAtTl0d0DYf30eb3MIKKPmZVUjeO9D0R', 1),
(42, 'user3@gmail.com', '123456', 'user 3', '1234554321', 'A15b45NF20aPne53yEhzfYgCoeE2', 'cNrmOAgZTs26FgLB3rrhq1:APA91bFq3TZihiereQR5DghyqeBTe5jZmNgJjmWyiJScLxBGlcn5d60_VHUDL_aWHMuSSgVKhGWrS2Q_VYb8iUu1EEQORR7kkKegmWZhoo5oeSgoNisI1sFBDzgqc-W7aaXJUCoAFEfW', 0),
(43, 'user4@gmail.com', '123456', 'user 4', '2342342345', 'VcVjB8TvxscYzsHludkJkZs8Peh2', 'cNrmOAgZTs26FgLB3rrhq1:APA91bFq3TZihiereQR5DghyqeBTe5jZmNgJjmWyiJScLxBGlcn5d60_VHUDL_aWHMuSSgVKhGWrS2Q_VYb8iUu1EEQORR7kkKegmWZhoo5oeSgoNisI1sFBDzgqc-W7aaXJUCoAFEfW', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
