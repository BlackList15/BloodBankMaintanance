-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 10, 2018 at 02:12 PM
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
  `bId` char(2) NOT NULL DEFAULT 'BB',
  `Bno` int(3) UNSIGNED ZEROFILL NOT NULL,
  `Bgroup` varchar(3) NOT NULL,
  `DId` varchar(6) NOT NULL,
  `Dname` varchar(25) NOT NULL,
  `Bvolume` int(11) NOT NULL,
  `Ddate` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodbag`
--

INSERT INTO `bloodbag` (`bId`, `Bno`, `Bgroup`, `DId`, `Dname`, `Bvolume`, `Ddate`) VALUES
('BB', 001, 'A+', 'DON010', 'Sureshkumar', 300, '2018-Sep-10'),
('BB', 003, 'B+', 'DON005', 'Karshan', 300, '2018-Sep-05');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `dId` char(3) NOT NULL DEFAULT 'DON',
  `id` int(3) UNSIGNED ZEROFILL NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(40) NOT NULL,
  `contact` int(10) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dateOfBirth` varchar(15) NOT NULL,
  `bloodGroup` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`dId`, `id`, `name`, `email`, `address`, `contact`, `gender`, `dateOfBirth`, `bloodGroup`) VALUES
('DON', 005, 'Karshan', 'karshan96@gmail.com', 'Wattala', 775846932, 'male', '1996-Mar-01', 'O+'),
('DON', 006, 'vijay', 'vj@gmail.com', 'Matale', 758469521, 'male', '2008-Jun-24', 'AB+'),
('DON', 008, 'Kumar', 'kumar45@gmail.com', 'Mannar', 778496321, 'male', '1993-May-05', 'A+'),
('DON', 009, 'Ravikumar', 'ravikumar23@gmail.com', 'Negombo', 758469325, 'male', '1982-Nov-09', 'O-'),
('DON', 010, 'Sureshkumar', 'suresh95@gmail.com', 'Kaluthara', 789564123, 'male', '1995-Aug-08', 'A+'),
('DON', 011, 'Samantha', 'samu30@gmail.com', 'Gampaha', 778549625, 'female', '1985-Jun-21', 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hId` char(1) NOT NULL DEFAULT 'H',
  `id` int(3) UNSIGNED ZEROFILL NOT NULL,
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

INSERT INTO `hospital` (`hId`, `id`, `hosName`, `hosContact`, `address`, `disFromHere`, `cheifDocName`, `cheifDocCon`) VALUES
('H', 002, 'Nawaloka', 115689742, 'Colombo', 54.3, 'D.Silva', 758964213),
('H', 004, 'Hemas', 115469321, 'Wattala', 21.2, 'J.K.Bandara', 785469325),
('H', 005, 'Ragama GH', 115486214, 'Ragama', 10.21, 'S.Shankar', 774856932),
('H', 006, 'Colombo North GH', 115846932, 'Colombo', 32.2, 'Jayasuriya', 784596325);

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
('ADM001', 'admin001@bb'),
('ADM002', '#Karshan96');

-- --------------------------------------------------------

--
-- Table structure for table `receiver`
--

CREATE TABLE `receiver` (
  `patientName` varchar(20) NOT NULL,
  `hospital` varchar(20) NOT NULL,
  `hospitalAddress` varchar(40) NOT NULL,
  `chiefDoctor` varchar(20) NOT NULL,
  `bloodGroup` varchar(3) NOT NULL,
  `donorId` varchar(6) NOT NULL,
  `donorName` varchar(20) NOT NULL,
  `bagNo` varchar(5) NOT NULL,
  `transactionDate` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiver`
--

INSERT INTO `receiver` (`patientName`, `hospital`, `hospitalAddress`, `chiefDoctor`, `bloodGroup`, `donorId`, `donorName`, `bagNo`, `transactionDate`) VALUES
('Kumar', 'Hemas', 'Wattala', 'J.K.Bandara', 'A+', 'DON008', 'kumar', 'BB007', '2018-Sep-06'),
('Manoj', 'Colombo North GH', 'Colombo', 'Jayasuriya', 'O-', 'DON009', 'Ravikumar', 'BB002', '2018-Sep-10');

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
  MODIFY `id` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `id` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
