-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2018 at 04:39 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bloodbag`
--

CREATE TABLE `bloodbag` (
  `Bno` int(6) NOT NULL,
  `Bgroup` varchar(3) NOT NULL,
  `DId` int(6) NOT NULL,
  `Dname` varchar(25) NOT NULL,
  `Bvolume` int(11) NOT NULL,
  `Ddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodbag`
--

INSERT INTO `bloodbag` (`Bno`, `Bgroup`, `DId`, `Dname`, `Bvolume`, `Ddate`) VALUES
(1, 'O-', 2, 'Vijay', 300, '2018-07-04');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `id` int(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(40) NOT NULL,
  `contact` int(10) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `bloodGroup` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`id`, `name`, `email`, `address`, `contact`, `gender`, `dateOfBirth`, `bloodGroup`) VALUES
(1, 'Karshan', 'karshan@gmail.com', 'Wattala', 777561423, 'male', '2011-03-06', 'B+'),
(2, 'Vijay', 'vj44@gmail.com', 'Colombo', 777865489, 'male', '2014-12-02', 'O-');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `id` int(6) NOT NULL,
  `hosName` varchar(20) NOT NULL,
  `hosContact` int(10) NOT NULL,
  `address` varchar(40) NOT NULL,
  `disFromHere` float NOT NULL,
  `cheifDocName` varchar(20) NOT NULL,
  `cheifDocCon` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`id`, `hosName`, `hosContact`, `address`, `disFromHere`, `cheifDocName`, `cheifDocCon`) VALUES
(1, 'Hemas', 1158469521, 'Wattala', 15.2, 'K.J.Perera', 777569532),
(2, 'Nawaloka', 115689742, 'Colombo', 54.3, 'D.Silva', 758964213);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` char(6) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `password`) VALUES
('ADM001', 'admin001@bb');

-- --------------------------------------------------------

--
-- Table structure for table `receiver`
--

CREATE TABLE `receiver` (
  `patientName` varchar(15) NOT NULL,
  `hospital` varchar(15) NOT NULL,
  `hospitalAddress` varchar(25) NOT NULL,
  `chiefDoctor` varchar(15) NOT NULL,
  `bloodGroup` varchar(3) NOT NULL,
  `donorId` int(11) NOT NULL,
  `donorName` varchar(15) NOT NULL,
  `bagNo` int(11) NOT NULL,
  `transactionDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloodbag`
--
ALTER TABLE `bloodbag`
  ADD PRIMARY KEY (`Bno`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
