-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2024 at 02:33 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quan_ly_thi_ptth`
--

-- --------------------------------------------------------

--
-- Table structure for table `coi_thi`
--

CREATE TABLE `coi_thi` (
  `ma_giam_thi` varchar(10) NOT NULL,
  `ma_phong_thi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coi_thi`
--

INSERT INTO `coi_thi` (`ma_giam_thi`, `ma_phong_thi`) VALUES
('001', 'K101'),
('002', 'K101'),
('003', 'K103'),
('004', 'K105');

-- --------------------------------------------------------

--
-- Table structure for table `giam_thi`
--

CREATE TABLE `giam_thi` (
  `ma_giam_thi` varchar(10) NOT NULL,
  `ten_giam_thi` varchar(50) NOT NULL,
  `gioi_tinh` tinyint(1) NOT NULL,
  `ngay_sinh` varchar(10) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `chuc_vu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giam_thi`
--

INSERT INTO `giam_thi` (`ma_giam_thi`, `ten_giam_thi`, `gioi_tinh`, `ngay_sinh`, `dia_chi`, `chuc_vu`) VALUES
('001', 'Huỳnh Công Pháp', 1, '14/05/1977', 'Quảng Nam', 'Hiệu Trưởng'),
('002', 'Huỳnh Ngọc Thọ', 1, '18/10/1982', 'Quảng Nam', 'Trường phòng Đào tạo'),
('003', 'Trần Ngọc Phương Thảo', 0, '13/09/1988', 'Quảng Nam', 'Giảng Viên'),
('004', 'Nguyễn Hữu Nhật Minh', 1, '29/09/1990', 'Quảng Nam', 'Giảng Viên');

-- --------------------------------------------------------

--
-- Table structure for table `phong_thi`
--

CREATE TABLE `phong_thi` (
  `ma_phong_thi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phong_thi`
--

INSERT INTO `phong_thi` (`ma_phong_thi`) VALUES
('K101'),
('K102'),
('K103'),
('K104'),
('K105');

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`id`, `email`, `pass`) VALUES
(1, 'tranphuongthanh@gmail.com', '06052005');

-- --------------------------------------------------------

--
-- Table structure for table `thi`
--

CREATE TABLE `thi` (
  `ma_thi_sinh` varchar(10) NOT NULL,
  `ma_phong_thi` varchar(10) NOT NULL,
  `to_hop` varchar(20) NOT NULL,
  `diem_so1` decimal(3,1) NOT NULL,
  `diem_so2` decimal(3,1) NOT NULL,
  `diem_so3` decimal(3,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thi`
--

INSERT INTO `thi` (`ma_thi_sinh`, `ma_phong_thi`, `to_hop`, `diem_so1`, `diem_so2`, `diem_so3`) VALUES
('25479635', 'K105', 'Xã Hội', 7.0, 10.0, 9.0),
('41573258', 'K102', 'Tự Nhiên', 8.0, 0.0, 0.0),
('46286475', 'K103', 'Xã Hội', 8.0, 0.0, 0.0),
('62178943', 'K104', 'Xã Hội', 9.0, 0.0, 0.0),
('73223710', 'K104', 'Xã Hội', 8.5, 9.0, 10.0),
('87561723', 'K105', 'Xã Hội', 7.0, 0.0, 0.0);

-- --------------------------------------------------------

--
-- Table structure for table `thi_sinh`
--

CREATE TABLE `thi_sinh` (
  `ma_thi_sinh` varchar(10) NOT NULL,
  `ten_thi_sinh` varchar(50) NOT NULL,
  `gioi_tinh` tinyint(1) NOT NULL,
  `ngay_sinh` varchar(10) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `doi_tuong` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thi_sinh`
--

INSERT INTO `thi_sinh` (`ma_thi_sinh`, `ten_thi_sinh`, `gioi_tinh`, `ngay_sinh`, `dia_chi`, `doi_tuong`) VALUES
('25479635', 'Đặng ', 1, '30/04/2006', 'Đồng Hới, Quảng B', '2N'),
('41573258', 'Trần Quốc Toàn', 1, '10/03/2005', 'Hải Châu, Đàng Nẵng', '1'),
('46286475', 'Trần Phương Thanh', 0, '06/05/2005', 'Ngũ Hành Sơn, Đà Nẵng', '2NT'),
('62178943', 'Lê Trà Giang', 0, '26/05/2005', 'Ngũ Hành Sơn,Đà Nẵng', '2'),
('73223710', 'Nguyễn Thị Thúy', 0, '22/12/2005', 'Quảng Nam', '2'),
('87561723', 'Võ Phước Duy', 1, '20/11/2005', 'Đà Nẵng, Việt Nam', '2NT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coi_thi`
--
ALTER TABLE `coi_thi`
  ADD PRIMARY KEY (`ma_giam_thi`,`ma_phong_thi`);

--
-- Indexes for table `giam_thi`
--
ALTER TABLE `giam_thi`
  ADD PRIMARY KEY (`ma_giam_thi`);

--
-- Indexes for table `phong_thi`
--
ALTER TABLE `phong_thi`
  ADD PRIMARY KEY (`ma_phong_thi`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thi`
--
ALTER TABLE `thi`
  ADD PRIMARY KEY (`ma_thi_sinh`,`ma_phong_thi`),
  ADD KEY `ma_phong_thi` (`ma_phong_thi`);

--
-- Indexes for table `thi_sinh`
--
ALTER TABLE `thi_sinh`
  ADD PRIMARY KEY (`ma_thi_sinh`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `coi_thi`
--
ALTER TABLE `coi_thi`
  ADD CONSTRAINT `coi_thi_ibfk_3` FOREIGN KEY (`ma_giam_thi`) REFERENCES `giam_thi` (`ma_giam_thi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coi_thi_ibfk_4` FOREIGN KEY (`ma_phong_thi`) REFERENCES `phong_thi` (`ma_phong_thi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `thi`
--
ALTER TABLE `thi`
  ADD CONSTRAINT `thi_ibfk_1` FOREIGN KEY (`ma_phong_thi`) REFERENCES `phong_thi` (`ma_phong_thi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `thi_ibfk_2` FOREIGN KEY (`ma_thi_sinh`) REFERENCES `thi_sinh` (`ma_thi_sinh`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
