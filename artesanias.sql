-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 17, 2016 at 08:42 AM
-- Server version: 5.6.31-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artesanias`
--
CREATE DATABASE IF NOT EXISTS `artesanias` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `artesanias`;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` text,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `stock`) VALUES
(1, 'product 1', 25000, 'desc 2', 1),
(2, 'product 2', 150000, 'desc 3', 5),
(3, 'product 3', 1500000, 'desc 4', 8);

-- --------------------------------------------------------

--
-- Table structure for table `shopping`
--

DROP TABLE IF EXISTS `shopping`;
CREATE TABLE IF NOT EXISTS `shopping` (
  `id` int(11) NOT NULL,
  `date_shopping` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopping`
--

INSERT INTO `shopping` (`id`, `date_shopping`, `product_id`, `quantity`, `total_price`) VALUES
(2, '2016-11-17 05:01:48', 1, 4, 600000),
(3, '2016-11-17 05:02:16', 2, 5, 600000);

--
-- Triggers `shopping`
--
DROP TRIGGER IF EXISTS `sell_out`;
DELIMITER $$
CREATE TRIGGER `sell_out` AFTER INSERT ON `shopping`
 FOR EACH ROW update product set stock = stock - new.quantity where id = new.product_id
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shopping`
--
ALTER TABLE `shopping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `shopping`
--
ALTER TABLE `shopping`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `shopping`
--
ALTER TABLE `shopping`
  ADD CONSTRAINT `shopping_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
