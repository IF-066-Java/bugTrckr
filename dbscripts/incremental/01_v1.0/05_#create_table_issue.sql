CREATE TABLE `Issue` (
	`id` INT NOT NULL,
	`title` varchar(25) NOT NULL,
	`type` varchar(25) NOT NULL,
	`priority` varchar(25) NOT NULL,
	`status` VARCHAR(255) NOT NULL,
	`releaseId` INT NOT NULL,
	`assigneeId` INT NOT NULL,
	`createTime` DATE NOT NULL,
	`dueDate` DATE NOT NULL,
	`lastUpdateDate` DATE NOT NULL,
	`estimateTime` INT NOT NULL,
	`parentId` INT,
	PRIMARY KEY (`id`)
);
