CREATE TABLE `servizi_digitali`.`istanza_form` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `istanzaFormId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `json` LONGTEXT NULL,
  `formId` BIGINT NOT NULL,
  `richiestaId` BIGINT NOT NULL,
  PRIMARY KEY (`istanzaFormId`));

CREATE TABLE `servizi_digitali`.`allegato_richiesta` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `richiestaId` BIGINT NOT NULL,
  `fileEntryId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `nome` VARCHAR(75) NULL DEFAULT NULL,
  `principale` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`richiestaId`, `fileEntryId`));
  
ALTER TABLE `servizi_digitali`.`allegato_richiesta` 
ADD COLUMN `idDocumentale` VARCHAR(255) NULL AFTER `nome`,
ADD COLUMN `url` VARCHAR(255) NULL AFTER `idDocumentale`;

ALTER TABLE `servizi_digitali`.`richiesta` 
ADD COLUMN `numeroProtocolloEsterno` VARCHAR(75) NULL AFTER `dataProtocollo`,
ADD COLUMN `dataProtocolloEsterno` TIMESTAMP NULL AFTER `numeroProtocolloEsterno`;

ALTER TABLE `servizi_digitali`.`richiesta` 
ADD COLUMN `processInstanceId` VARCHAR(75) NULL AFTER `delegaId`;

