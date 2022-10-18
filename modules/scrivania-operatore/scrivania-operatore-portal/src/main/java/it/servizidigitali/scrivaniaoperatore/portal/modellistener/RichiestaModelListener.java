package it.servizidigitali.scrivaniaoperatore.portal.modellistener;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AttivitaRichiestaLocalService;

/**
 * Model Listener per gestire gli eventi relativi al model {@link Richiesta}.
 *
 * @author pindi
 */
@Component(//
		immediate = true, //
		service = ModelListener.class) //
public class RichiestaModelListener extends BaseModelListener<Richiesta> {

	private static final Log log = LogFactoryUtil.getLog(RichiestaModelListener.class);

	@Reference
	private AttivitaRichiestaLocalService attivitaRichiestaLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Override
	public void onAfterCreate(Richiesta model) throws ModelListenerException {
		// Creazione log attività
		AttivitaRichiesta attivitaRichiesta = attivitaRichiestaLocalService.createAttivitaRichiesta(counterLocalService.increment());
		attivitaRichiesta.setCompanyId(model.getCompanyId());
		attivitaRichiesta.setGroupId(model.getGroupId());
		attivitaRichiesta.setUserId(model.getUserId());
		attivitaRichiesta.setUserName(model.getUserName());
		attivitaRichiesta.setStato(model.getStato());
		attivitaRichiesta.setRichiestaId(model.getRichiestaId());

		attivitaRichiesta.setNote("Nuovo inserimento");

		attivitaRichiestaLocalService.addAttivitaRichiesta(attivitaRichiesta);
	}

	@Override
	public void onBeforeUpdate(Richiesta originalModel, Richiesta model) throws ModelListenerException {

		String vecchioStato = originalModel.getStato();
		String nuovoStato = model.getStato();

		// Log aggiornamento stato
		if (!vecchioStato.equals(nuovoStato)) {
			AttivitaRichiesta attivitaRichiesta = attivitaRichiestaLocalService.createAttivitaRichiesta(counterLocalService.increment());
			attivitaRichiesta.setCompanyId(model.getCompanyId());
			attivitaRichiesta.setGroupId(model.getGroupId());
			attivitaRichiesta.setUserId(model.getUserId());
			attivitaRichiesta.setUserName(model.getUserName());
			attivitaRichiesta.setStato(nuovoStato);
			attivitaRichiesta.setRichiestaId(model.getRichiestaId());
			attivitaRichiestaLocalService.updateAttivitaRichiesta(attivitaRichiesta);
		}
	}

}