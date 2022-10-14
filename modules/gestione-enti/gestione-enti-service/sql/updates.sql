  -- 20221014
  
ALTER TABLE `servizi_digitali`.`servizio_ente` 
ADD COLUMN `richiestaFirma` TINYINT(1) NULL DEFAULT NULL AFTER `attivo`,
ADD COLUMN `formatiFirmaDigitale` VARCHAR(75) NULL DEFAULT NULL AFTER `richiestaFirma`;
