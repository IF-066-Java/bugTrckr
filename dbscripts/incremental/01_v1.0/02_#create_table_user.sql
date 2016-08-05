CREATE TABLE `User` (
  `id` INT NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role` varchar(15) NOT NULL,
  `projectId` INT,
  `description` TEXT(10000),
  PRIMARY KEY (`id`)
);