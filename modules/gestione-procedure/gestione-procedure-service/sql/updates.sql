CREATE TABLE `servizi_digitali`.`template_pdf` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `templatePdfId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `fileEntryId` BIGINT NULL DEFAULT NULL,
  `attivo` TINYINT(1) NULL DEFAULT '0',
  `proceduraId` BIGINT NULL DEFAULT NULL,
  `templatePdfParentId` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`templatePdfId`));

  -- 20220929
ALTER TABLE `servizi_digitali`.`template_pdf` 
DROP COLUMN `attivo`;