-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 27, 2017 at 12:16 AM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_info`
--

CREATE TABLE `account_info` (
  `account_no` varchar(10) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_info`
--

INSERT INTO `account_info` (`account_no`, `balance`) VALUES
('1234567890', 30900),
('2345678901', 29800),
('3456789012', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `tid` int(11) NOT NULL,
  `account_no` varchar(10) NOT NULL,
  `type` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`tid`, `account_no`, `type`, `amount`, `date`) VALUES
(1, '1234567890', 'deposit', 600, '2017-12-12'),
(2, '2345678901', 'withdraw', 600, '2017-12-12'),
(3, '3456789012', 'deposit', 600, '2017-12-12'),
(4, '1234567890', 'withdraw', 100, '2017-12-26'),
(5, '1234567890', 'withdraw', 100, '2017-12-26'),
(6, '1234567890', 'withdraw', 100, '2017-12-26'),
(7, '1234567890', 'withdraw', 100, '2017-12-26'),
(8, '1234567890', 'withdraw', 100, '2017-12-26'),
(9, '1234567890', 'withdraw', 100, '2017-12-26'),
(10, '1234567890', 'withdraw', 100, '2017-12-26'),
(11, '1234567890', 'deposit', 100, '2017-12-26'),
(12, '1234567890', 'withdraw', 100, '2017-12-26');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `account_no` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `pin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `account_no`, `name`, `lastname`, `pin`) VALUES
(1, '1234567890', 'sarandis', 'mitropoulos', 1234),
(2, '2345678901', 'dimitris', 'zerkelidis', 1234),
(3, '3456789012', 'bledi', 'gegaj', 1234);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_info`
--
ALTER TABLE `account_info`
  ADD UNIQUE KEY `account_no` (`account_no`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `account_no` (`account_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
