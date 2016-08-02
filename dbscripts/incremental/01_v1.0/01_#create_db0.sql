CREATE SCHEMA IF NOT EXISTS `agilesoftware` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(512) NOT NULL,
  `role` varchar(15) NOT NULL,
  `description` TEXT,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `Projects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `projectManagerId` INT NOT NULL,
  `guestView` BOOLEAN NOT NULL DEFAULT FALSE,
  `guestCreateIssues` BOOLEAN NOT NULL DEFAULT FALSE,
  `guestAddComment` BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `Releases` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `projectId` INT NOT NULL,
  `vesrion` varchar(10) NOT NULL,
  `status` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `Issues` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `type` varchar(25) NOT NULL,
  `priority` varchar(10) NOT NULL,
  `projectId` INT NOT NULL,
  `assigneeId` INT NOT NULL,
  `createTime` DATE NOT NULL,
  `dueDate` DATE NOT NULL,
  `lastUpdateDate` DATE NOT NULL,
  `estimateTime` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `Labels` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `issueId` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `History` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `issueId` INT NOT NULL,
  `userId` INT NOT NULL,
  `parentId` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE `WorkLogs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `issueId` INT NOT NULL,
  `userId` INT NOT NULL,
  `time` DATE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB;


ALTER TABLE `Projects` ADD CONSTRAINT `Projects_fk0` FOREIGN KEY (`projectManagerId`) REFERENCES `Users`(`id`);
ALTER TABLE `Releases` ADD CONSTRAINT `Releases_fk0` FOREIGN KEY (`projectId`) REFERENCES `Projects`(`id`);
ALTER TABLE `Issues` ADD CONSTRAINT `Issues_fk0` FOREIGN KEY (`projectId`) REFERENCES `Projects`(`id`);
ALTER TABLE `Issues` ADD CONSTRAINT `Issues_fk1` FOREIGN KEY (`assigneeId`) REFERENCES `Users`(`id`);
ALTER TABLE `Labels` ADD CONSTRAINT `Labels_fk0` FOREIGN KEY (`issueId`) REFERENCES `Issues`(`id`);
ALTER TABLE `WorkLogs` ADD CONSTRAINT `WorkLogs_fk0` FOREIGN KEY (`issueId`) REFERENCES `Issues`(`id`);
ALTER TABLE `WorkLogs` ADD CONSTRAINT `WorkLogs_fk1` FOREIGN KEY (`userId`) REFERENCES `Users`(`id`);