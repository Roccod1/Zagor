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

-- 20220916
ALTER TABLE `servizi_digitali`.`allegato_richiesta` 
ADD COLUMN `interno` TINYINT(1) NOT NULL DEFAULT '0' AFTER `principale`,
ADD COLUMN `visibile` TINYINT(1) NOT NULL DEFAULT '1' AFTER `interno`;

CREATE TABLE `servizi_digitali`.`commento_richiesta` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `commentoRichiestaId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `testo` LONGTEXT NULL,
  `taskId` VARCHAR(75) NULL,
  `visibile` TINYINT(1) NOT NULL DEFAULT '0',
  `richiestaId` BIGINT NOT NULL,
  PRIMARY KEY (`commentoRichiestaId`));
  
-- 20220923
CREATE TABLE `servizi_digitali`.`attivita_richiesta` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `attivitaRichiestaId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `note` LONGTEXT NULL,
  `stato` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`attivitaRichiestaId`));
  
-- 20220927
ALTER TABLE `servizi_digitali`.`allegato_richiesta` 
DROP COLUMN `fileEntryId`,
CHANGE COLUMN `richiestaId` `allegatoRichiestaId` BIGINT NOT NULL ,
CHANGE COLUMN `idDocumentale` `idDocumentale` VARCHAR(255) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`allegatoRichiestaId`);

ALTER TABLE `servizi_digitali`.`allegato_richiesta` 
ADD COLUMN `richiestaId` BIGINT NOT NULL AFTER `visibile`;

-- 20221003
CREATE TABLE `destinazione_uso` (
  `uuid_` varchar(75) DEFAULT NULL,
  `destinazioneUsoId` bigint NOT NULL,
  `groupId` bigint DEFAULT NULL,
  `companyId` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `modifiedDate` datetime(6) DEFAULT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `descrizione` varchar(500) DEFAULT NULL,
  `pagamentoBollo` tinyint DEFAULT NULL,
  `importo` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`destinazioneUsoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `destinazione_uso_servizio_ente` (
  `uuid_` varchar(75) DEFAULT NULL,
  `destinazioneUsoId` bigint NOT NULL,
  `servizioId` bigint NOT NULL,
  `organizationId` bigint NOT NULL,
  `groupId` bigint DEFAULT NULL,
  `companyId` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `modifiedDate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`destinazioneUsoId`,`servizioId`,`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 20221005
ALTER TABLE `servizi_digitali`.`allegato_richiesta` 
ADD COLUMN `definizioneAllegatoId` BIGINT NULL AFTER `visibile`;