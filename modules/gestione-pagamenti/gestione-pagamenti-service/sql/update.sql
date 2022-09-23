CREATE TABLE `pagamento` (
  `uuid_` varchar(75) DEFAULT NULL,
  `pagamentoId` bigint NOT NULL,
  `groupId` bigint DEFAULT NULL,
  `companyId` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `modifiedDate` datetime(6) DEFAULT NULL,
  `idCredito` varchar(75) DEFAULT NULL,
  `idFiscaleCliente` varchar(16) DEFAULT NULL,
  `denominazioneCliente` varchar(100) DEFAULT NULL,
  `emailQuietanza` varchar(75) DEFAULT NULL,
  `causale` varchar(255) DEFAULT NULL,
  `descrizioneServizio` varchar(75) DEFAULT NULL,
  `importo` decimal(19,2) DEFAULT NULL,
  `commissioni` decimal(19,2) DEFAULT NULL,
  `canale` varchar(75) DEFAULT NULL,
  `iud` varchar(100) DEFAULT NULL,
  `iuv` varchar(100) DEFAULT NULL,
  `idSessione` varchar(100) DEFAULT NULL,
  `pathAvviso` longtext,
  `emailInviata` tinyint(1) DEFAULT '0',
  `stato` varchar(75) DEFAULT NULL,
  `richiestaId` bigint DEFAULT NULL,
  PRIMARY KEY (`pagamentoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
