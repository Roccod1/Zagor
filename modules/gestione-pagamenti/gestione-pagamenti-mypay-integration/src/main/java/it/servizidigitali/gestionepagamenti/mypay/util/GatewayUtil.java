package it.servizidigitali.gestionepagamenti.mypay.util;

public final class GatewayUtil {

	public static String getIudByIdentificativoPagamento(final String idPagamento) {

		if ((idPagamento.length() != 36) || (idPagamento.charAt(8) != '-')) {
			throw new RuntimeException("Il formator per l'identificativo del pagamento non risulta valido.");
		}

		return idPagamento.substring(0, 8) + idPagamento.substring(9);
	}

	public static String getIdentificativoPagamentoByIud(final String iud) {

		if (iud.length() != 35) {
			throw new RuntimeException("Il formato dello IUD non risulta corretto");
		}

		return iud.substring(0, 8) + "-" + iud.substring(8);
	}

}
