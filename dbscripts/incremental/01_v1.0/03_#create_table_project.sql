CREATE TABLE `Project` (
  `id` INT NOT NULL,
  `title` varchar(100) NOT NULL,
  `projectManagerId` INT NOT NULL,
  `guestView` BOOLEAN NOT NULL,
  `guestCreateIssues` BOOLEAN NOT NULL,
  `guestAddComment` BOOLEAN NOT NULL,
  `description` varchar(10000),
  PRIMARY KEY (`id`)
);