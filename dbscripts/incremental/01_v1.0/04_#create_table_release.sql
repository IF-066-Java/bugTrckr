CREATE TABLE `Release` (
  `id` INT NOT NULL,
  `projectId` INT NOT NULL,
  `vesrion` varchar(32) NOT NULL,
  `status` varchar(25) NOT NULL,
  `description` varchar(10000),
  PRIMARY KEY (`id`)
);