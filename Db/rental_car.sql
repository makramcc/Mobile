-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 12, 2018 at 04:14 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_car`
--

-- --------------------------------------------------------

--
-- Table structure for table `Car`
--

CREATE TABLE `Car` (
  `id_car` int(11) NOT NULL,
  `image` int(11) NOT NULL,
  `car_brand` text COLLATE utf8_bin NOT NULL,
  `car_model` text COLLATE utf8_bin NOT NULL,
  `car_detail` text COLLATE utf8_bin NOT NULL,
  `city` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Car`
--

INSERT INTO `Car` (`id_car`, `image`, `car_brand`, `car_model`, `car_detail`, `city`) VALUES
(1, 2131427328, 'HONDA', 'CIVIC', '5door', 'Lampang');

-- --------------------------------------------------------

--
-- Table structure for table `Oder`
--

CREATE TABLE `Oder` (
  `order_id` int(11) NOT NULL,
  `Car_id` int(11) NOT NULL,
  `name` text COLLATE utf8_bin NOT NULL,
  `id_passport` text COLLATE utf8_bin NOT NULL,
  `id_driving` text COLLATE utf8_bin NOT NULL,
  `tel` text COLLATE utf8_bin NOT NULL,
  `Email` text COLLATE utf8_bin NOT NULL,
  `first_date` date NOT NULL DEFAULT '0001-01-01',
  `end_date` date NOT NULL DEFAULT '0001-01-01',
  `city` text COLLATE utf8_bin NOT NULL,
  `time` text COLLATE utf8_bin NOT NULL,
  `place` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Oder`
--

INSERT INTO `Oder` (`order_id`, `Car_id`, `name`, `id_passport`, `id_driving`, `tel`, `Email`, `first_date`, `end_date`, `city`, `time`, `place`) VALUES
(1, 3, 's', '1', '!', '123', '11', '2001-01-03', '2001-02-08', 'Chanthaburi', '9:00', 'BMTA'),
(2, 2, 's', '1', '!', '123', '11', '2001-01-04', '2001-02-24', 'Lampang', '12:00', 'Airport'),
(3, 1, 'test', '1234', '456', '123', '11', '0001-01-01', '0001-01-01', 'Lampang', '14:00', 'BMTA'),
(4, 3, 's', '4', '!', '123', '11', '2001-03-01', '2001-03-10', 'Lampang', '17:00', 'BMTA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Car`
--
ALTER TABLE `Car`
  ADD PRIMARY KEY (`id_car`);

--
-- Indexes for table `Oder`
--
ALTER TABLE `Oder`
  ADD PRIMARY KEY (`order_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
