CREATE TABLE `servizi_digitali`.`richiesta_certificato` (
  `uuid_` VARCHAR(75) NULL DEFAULT NULL,
  `richiestaCertificatoId` BIGINT NOT NULL,
  `groupId` BIGINT NULL DEFAULT NULL,
  `companyId` BIGINT NULL DEFAULT NULL,
  `userId` BIGINT NULL DEFAULT NULL,
  `userName` VARCHAR(75) NULL DEFAULT NULL,
  `createDate` DATETIME(6) NULL DEFAULT NULL,
  `modifiedDate` DATETIME(6) NULL DEFAULT NULL,
  `codiceFiscale` VARCHAR(16) NULL DEFAULT NULL,
  `stato` VARCHAR(75) NULL,
  `errore` LONGTEXT NULL,
  `servizioId` BIGINT NULL,
  `organizationId` BIGINT NULL,
  PRIMARY KEY (`richiestaCertificatoId`));
  
ALTER TABLE `servizi_digitali`.`richiesta_certificato` 
CHANGE COLUMN `organizationId` `destinazioneUsoId` BIGINT NULL DEFAULT NULL ;

-- 20221028
ALTER TABLE `servizi_digitali`.`richiesta_certificato` 
ADD COLUMN `richiestaId` BIGINT NULL AFTER `destinazioneUsoId`;
