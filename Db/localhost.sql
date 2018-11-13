-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 10, 2018 at 12:08 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_car`
--
CREATE DATABASE IF NOT EXISTS `rental_car` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `rental_car`;

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
(1, 2131427328, 'HONDA', 'CIVIC', '5door', 'ลำปาง'),
(2, 2131427328, 'HONDA', 'CIVIC', 'w', 'จันทบุรี'),
(3, 2131427328, 'TOYOTA', 'CAMRY', 'w', 'ลำปาง');

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
  `place_x` int(11) NOT NULL,
  `place_y` int(11) NOT NULL,
  `city` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Oder`
--

INSERT INTO `Oder` (`order_id`, `Car_id`, `name`, `id_passport`, `id_driving`, `tel`, `Email`, `first_date`, `end_date`, `place_x`, `place_y`, `city`) VALUES
(1, 3, 's', '1', '!', '123', '11', '2001-01-03', '2001-02-08', 1, 1, 'จันทบุรี'),
(2, 2, 's', '1', '!', '123', '11', '2001-01-04', '2001-02-24', 1, 1, 'ลำปาง'),
(3, 1, 'test', '1234', '456', '123', '', '0001-01-01', '0001-01-01', 1, 1, 'ลำปาง'),
(4, 3, 's', '4', '!', '123', '11', '2001-03-01', '2001-03-10', 1, 1, 'ลำปาง');

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
