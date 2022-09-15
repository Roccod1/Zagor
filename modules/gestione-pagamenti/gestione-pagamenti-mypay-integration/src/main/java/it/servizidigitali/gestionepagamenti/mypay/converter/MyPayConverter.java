package it.servizidigitali.gestionepagamenti.mypay.converter;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionepagamenti.common.client.model.Pagamento;
import it.servizidigitali.gestionepagamenti.mypay.constant.MyPayConstants;
import it.servizidigitali.gestionepagamenti.mypay.util.GatewayUtil;
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
	 * @param pagamento
	 * @return
	 */
	public CtDovuti generaDovuti(Pagamento pagamento) {

		CtDovuti dovuti = CtDovuti.Factory.newInstance();

		CtSoggettoPagatore pagatore = CtSoggettoPagatore.Factory.newInstance();

		CtIdentificativoUnivocoPersonaFG idPagatore = CtIdentificativoUnivocoPersonaFG.Factory.newInstance();
		idPagatore.setCodiceIdentificativoUnivoco(pagamento.getIdFiscaleCliente());
		idPagatore.setTipoIdentificativoUnivoco(StTipoIdentificativoUnivocoPersFG.F);

		pagatore.setIdentificativoUnivocoPagatore(idPagatore);
		pagatore.setAnagraficaPagatore(pagamento.getDenominazioneCliente());
		pagatore.setEMailPagatore(pagamento.getEmailQuietanza());

		dovuti.setSoggettoPagatore(pagatore);

		CtDatiVersamentoDovuti datiVersamentoDovuti = CtDatiVersamentoDovuti.Factory.newInstance();

		// Se viene omesso, usa quello di default dell'ente
		datiVersamentoDovuti.setTipoVersamento("ALL");

		CtDatiSingoloVersamentoDovuti datiSingoloVersamento = CtDatiSingoloVersamentoDovuti.Factory.newInstance();
		datiSingoloVersamento.setImportoSingoloVersamento(pagamento.getImportoTotale());
		datiSingoloVersamento.setCausaleVersamento(pagamento.getCausale());

		// Calcolo IUD
		String iud = GatewayUtil.getIudByIdentificativoPagamento(pagamento.getIdPagamento());

		datiSingoloVersamento.setIdentificativoUnivocoDovuto(iud);
		datiSingoloVersamento.setIdentificativoTipoDovuto(pagamento.getCodiceCategoriaServizio());
		datiSingoloVersamento.setDatiSpecificiRiscossione("9/" + pagamento.getCodiceIdentificativoOrganizzazione());

		Map<String, Object> infoAggiuntive = pagamento.getInfoAggiuntive();

		if (infoAggiuntive != null) {
			boolean isPagamentoBollo = infoAggiuntive.containsKey(MyPayConstants.INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_HASH_DOCUMENTO_KEY)
					&& infoAggiuntive.containsKey(MyPayConstants.INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_PROVINCIA_RESIDENZA_KEY);
			if (isPagamentoBollo) {
				CtDatiMarcaBolloDigitale datiMarcaBolloDigitale = CtDatiMarcaBolloDigitale.Factory.newInstance();
				datiMarcaBolloDigitale.setTipoBollo(StTipoBollo.X_01);
				datiMarcaBolloDigitale.setHashDocumento((String) infoAggiuntive.get(MyPayConstants.INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_HASH_DOCUMENTO_KEY));
				datiMarcaBolloDigitale.setProvinciaResidenza((String) infoAggiuntive.get(MyPayConstants.INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_PROVINCIA_RESIDENZA_KEY));
				datiSingoloVersamento.setDatiMarcaBolloDigitale(datiMarcaBolloDigitale);

				datiVersamentoDovuti.setTipoVersamento("PO");
				datiSingoloVersamento.setDatiSpecificiRiscossione("0/" + pagamento.getCodiceIdentificativoOrganizzazione());
			}
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
