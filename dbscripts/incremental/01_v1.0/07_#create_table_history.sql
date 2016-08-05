CREATE TABLE `History` (
  `id` INT NOT NULL,
  `issueId` INT NOT NULL,
  `assigneeId` INT NOT NULL,
  `parentId` INT NOT NULL,
  `changedById` INT NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);