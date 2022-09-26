package it.servizidigitali.common.utility;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import it.servizidigitali.common.utility.enumeration.UserCustomAttributes;
import it.servizidigitali.common.utility.exception.CommonUtilityException;
import it.servizidigitali.common.utility.model.IndirizzoResidenza;

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
	public IndirizzoResidenza getIndirizzoRedidenza(long companyId, String screenName) throws CommonUtilityException {
		try {
			IndirizzoResidenza indirizzoResidenza;
			
			User userByScreenName = userLocalService.getUserByScreenName(companyId, screenName);
			if (userByScreenName == null) {
				throw new CommonUtilityException("getUserByScreenName 0 results");
			}
			
			String residenza = (String) userByScreenName.getExpandoBridge().getAttribute(UserCustomAttributes.RESIDENZA.getNomeAttributo());
			
			if (residenza != null) {
				String[] split = residenza.split(StringPool.SPACE);
				
				//TODO formato della residenza?
				if (split.length >= 5) {
					indirizzoResidenza = new IndirizzoResidenza();
					indirizzoResidenza.setTipologia(split[0]);
					indirizzoResidenza.setIndirizzo(split[1]);
					indirizzoResidenza.setCivico(split[2]);
					indirizzoResidenza.setCap(split[3]);
					indirizzoResidenza.setLuogo(split[4]);
					if (split.length > 5) {
						indirizzoResidenza.setProvincia(split[5]);
					}
				} else {
					throw new CommonUtilityException("residenza str malformed");
				}
			} else {
				indirizzoResidenza = null;
			}
			
			return indirizzoResidenza;
		} catch (Exception e) {
			log.error("getIndirizzoRedidenzaMap :: " + e.getMessage(), e);
			throw new CommonUtilityException(e);
		}
	}
}
