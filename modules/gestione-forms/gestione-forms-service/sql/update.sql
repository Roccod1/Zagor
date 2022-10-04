-- 20221004
DROP TABLE `servizi_digitali`.`definizione_allegato`;

CREATE TABLE `servizi_digitali`.`definizione_allegato` (
  `uuid_` varchar(75) DEFAULT NULL,
  `definizioneAllegatoId` bigint NOT NULL,
  `groupId` bigint DEFAULT NULL,
  `companyId` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `modifiedDate` datetime(6) DEFAULT NULL,
  `denominazione` varchar(2000) DEFAULT NULL,
  `fileEntryId` bigint DEFAULT NULL,
  `filenameModello` varchar(255) DEFAULT NULL,
  `tipiFileAmmessi` varchar(255) DEFAULT NULL,
  `codiciTipologiaDocumento` varchar(255) DEFAULT NULL,
  `obbligatorio` tinyint(1) DEFAULT '0',
  `formId` bigint NOT NULL,
  `organizationId` bigint DEFAULT NULL,
  PRIMARY KEY (`definizioneAllegatoId`),
  KEY `formId_idx` (`formId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
