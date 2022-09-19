package it.servizidigitali.gestionepagamenti.mypay.converter;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.common.client.model.Dovuto;
import it.servizidigitali.gestionepagamenti.common.client.model.MarcaDaBollo;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDatiMarcaBolloDigitale;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDatiSingoloVersamentoDovuti;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDatiVersamentoDovuti;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtDovuti;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtIdentificativoUnivocoPersonaFG;
import it.veneto.regione.schemas.x2012.pagamenti.ente.CtSoggettoPagatore;
import it.veneto.regione.schemas.x2012.pagamenti.ente.StTipoBollo;
import it.veneto.regione.schemas.x2012.pagamenti.ente.StTipoIdentificativoUnivocoPersFG;

/**
 * @author pindi
 *
 */
@Component(name = "myPayConverter", service = MyPayConverter.class, immediate = true)
public class MyPayConverter {

	/**
	 *
	 * @param dovuto
	 * @return
	 */
	public CtDovuti generaCtDovuti(Dovuto dovuto) {

		CtDovuti dovuti = CtDovuti.Factory.newInstance();

		CtSoggettoPagatore pagatore = CtSoggettoPagatore.Factory.newInstance();

		CtIdentificativoUnivocoPersonaFG idPagatore = CtIdentificativoUnivocoPersonaFG.Factory.newInstance();
		idPagatore.setCodiceIdentificativoUnivoco(dovuto.getIdFiscaleCliente());
		idPagatore.setTipoIdentificativoUnivoco(StTipoIdentificativoUnivocoPersFG.F);

		pagatore.setIdentificativoUnivocoPagatore(idPagatore);
		pagatore.setAnagraficaPagatore(dovuto.getDenominazioneCliente());
		pagatore.setEMailPagatore(dovuto.getEmailQuietanza());

		dovuti.setSoggettoPagatore(pagatore);

		CtDatiVersamentoDovuti datiVersamentoDovuti = CtDatiVersamentoDovuti.Factory.newInstance();

		// Se viene omesso, usa quello di default dell'ente
		datiVersamentoDovuti.setTipoVersamento("ALL");

		CtDatiSingoloVersamentoDovuti datiSingoloVersamento = CtDatiSingoloVersamentoDovuti.Factory.newInstance();
		datiSingoloVersamento.setImportoSingoloVersamento(dovuto.getImporto());
		datiSingoloVersamento.setCausaleVersamento(dovuto.getCausale());

		// Calcolo IUD
		String iud = dovuto.getIud();

		datiSingoloVersamento.setIdentificativoUnivocoDovuto(iud);
		datiSingoloVersamento.setIdentificativoTipoDovuto(dovuto.getCodiceDovuto());
		datiSingoloVersamento.setDatiSpecificiRiscossione("9/" + dovuto.getCodiceOrganizzazione());

		if (dovuto instanceof MarcaDaBollo) {
			MarcaDaBollo marcaDaBollo = (MarcaDaBollo) dovuto;
			CtDatiMarcaBolloDigitale datiMarcaBolloDigitale = CtDatiMarcaBolloDigitale.Factory.newInstance();
			datiMarcaBolloDigitale.setTipoBollo(StTipoBollo.X_01);
			datiMarcaBolloDigitale.setHashDocumento(marcaDaBollo.getHashDocumento());
			datiMarcaBolloDigitale.setProvinciaResidenza(marcaDaBollo.getProvinciaResidenza());
			datiSingoloVersamento.setDatiMarcaBolloDigitale(datiMarcaBolloDigitale);

			datiVersamentoDovuti.setTipoVersamento("PO");
			datiSingoloVersamento.setDatiSpecificiRiscossione("0/" + dovuto.getCodiceOrganizzazione());
		}
		// Codice per la contabilita
		// richPagamento.getCodiceCategoriaServizio()

		CtDatiSingoloVersamentoDovuti[] datiSingoloVersamentoArray = new CtDatiSingoloVersamentoDovuti[1];
		datiSingoloVersamentoArray[0] = datiSingoloVersamento;
		datiVersamentoDovuti.setDatiSingoloVersamentoArray(datiSingoloVersamentoArray);

		dovuti.setDatiVersamento(datiVersamentoDovuti);
		dovuti.setVersioneOggetto("6_2_0");

		return dovuti;
	}

}
