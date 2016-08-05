CREATE TABLE `WorkLog` (
  `id` INT NOT NULL,
  `issueId` INT NOT NULL,
  `userId` INT NOT NULL,
  `time` DATE NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`)
);