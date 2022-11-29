CREATE TABLE ente (
  uuid_ varchar(75) DEFAULT NULL,
  enteId bigint NOT NULL,
  groupId bigint DEFAULT NULL,
  companyId bigint DEFAULT NULL,
  userId bigint DEFAULT NULL,
  userName varchar(75) DEFAULT NULL,
  createDate datetime(6) DEFAULT NULL,
  modifiedDate datetime(6) DEFAULT NULL,
  denominazione varchar(75) NOT NULL,
  strutturaRiferimento varchar (250) DEFAULT NULL,
  sitoWeb varchar (250) DEFAULT NULL,
  tipo varchar(75) NOT NULL,
  codiceIPA varchar(6) NOT NULL,
  pec varchar(75) NOT NULL,

  PRIMARY KEY (enteId)
);