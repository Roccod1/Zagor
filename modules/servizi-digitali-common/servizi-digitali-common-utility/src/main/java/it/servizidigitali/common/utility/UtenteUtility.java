package it.servizidigitali.common.utility;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.SezioneIndirizzoUtenteSPID;
import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;

/**
 * @author pindi
 *
 */

@Component(name = "utenteUtility", service = UtenteUtility.class)
public class UtenteUtility {

	private static final Log log = LogFactoryUtil.getLog(UtenteUtility.class.getName());

	@Reference
	private UserLocalService userLocalService;

	/**
	 *
	 * @param companyId
	 * @param screenName
	 * @return
	 * @throws CommonUtilityException
	 */
	public Map<String, String> getIndirizzoRedidenzaMap(long companyId, String screenName) throws CommonUtilityException {

		try {
			User userByScreenName = userLocalService.getUserByScreenName(companyId, screenName);
			Serializable residenza = userByScreenName.getExpandoBridge().getAttribute(UserCustomAttributes.RESIDENZA.getNomeAttributo());
			Map<String, String> indirizzoUtenteMap = new HashMap<String, String>();
			if (residenza != null) {
				String residenzaString = (String) residenza;
				String[] split = residenzaString.split(StringPool.SPACE);
				indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.TIPOLOGIA.name(), split[0]);
				indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.INDIRIZZO.name(), split[1]);
				indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.CIVICO.name(), split[2]);
				indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.CAP.name(), split[3]);
				indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.LUOGO.name(), split[4]);
				if (split.length > 5) {
					indirizzoUtenteMap.put(SezioneIndirizzoUtenteSPID.PROVINCIA.name(), split[5]);
				}
			}
			return indirizzoUtenteMap;
		}
		catch (Exception e) {
			log.error("getIndirizzoRedidenzaMap :: " + e.getMessage(), e);
			throw new CommonUtilityException(e);
		}
	}
}
