create table ServiziDigitaliGestioneServizi_servizio_tipologia (
	companyId LONG not null,
	servizioId LONG not null,
	tipologiaId LONG not null,
	primary key (servizioId, tipologiaId)
);