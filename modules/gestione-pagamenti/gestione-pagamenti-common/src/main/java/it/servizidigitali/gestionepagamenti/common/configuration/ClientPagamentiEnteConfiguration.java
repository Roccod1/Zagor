package it.servizidigitali.gestionepagamenti.common.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.math.BigDecimal;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration", name = "Configurazione parametri accesso client pagamenti Ente")
public interface ClientPagamentiEnteConfiguration {

	@Meta.AD(required = false, deflt = "MYPAY", name = "Tipo client pagamenti")
	String tipoPagamentiClient();

	@Meta.AD(required = false)
	String clientUsername();

	@Meta.AD(required = false)
	String clientPassword();

	@Meta.AD(required = false)
	String clientWsdlUrl();

	@Meta.AD(required = false)
	BigDecimal importoPagamentoMarcaBolloDigitale();

	@Meta.AD(required = false, name = "Codice dovuto Pagamento Bollo Digitale")
	String codiceDovutoPagamentoMarcaBolloDigitale();

	@Meta.AD(required = false, name = "Prefisso causale Pagamento Bollo Digitale", deflt = "MARCA_BOLLO_DIGITALE")
	String prefissoCausalePagamentoMarcaBolloDigitale();
}