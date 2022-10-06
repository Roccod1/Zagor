package it.servizidigitali.restservice.jwt.utility.internal.auth.verifier;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.security.auth.AuthVerifierPipeline;
import com.liferay.portal.security.service.access.policy.model.SAPEntry;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;

import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;

@Component(
		configurationPid = "it.servizidigitali.restservice.jwt.utility.internal.configuration.JwtAuthVerifierConfiguration",
		configurationPolicy = ConfigurationPolicy.REQUIRE, 
		service = {},
		immediate = true
		)
public class JwtAuthVerifierActivator {

	@Activate
	protected void activate(
			BundleContext bundleContext, Map<String, Object> properties) {

		Boolean enabled = GetterUtil.getBoolean(properties.get("enabled"));

		if ((enabled == null) || !enabled) {
			return;
		}

		AuthVerifier authVerifier = new JwtAuthVerifier(_jwtUtilityService);

		Class<?> clazz = authVerifier.getClass();

		String authVerifierPropertyName =
				AuthVerifierPipeline.getAuthVerifierPropertyName(clazz.getName());


		Dictionary<String, Object> authVerifierProperties = new Hashtable<>();

		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			String key = translateKey(authVerifierPropertyName, entry.getKey());
			authVerifierProperties.put(key, entry.getValue());
		}

		try {
			Long companyId = _portal.getDefaultCompanyId();
			Long userId = _userLocalService.getDefaultUserId(companyId);

			String name = JWTUtilityConstant.SAP_NAME;
			String allowedServiceSignatures = JWTUtilityConstant.SAP_DEFAULT_ALLOWED_SIGNATURE;

			SAPEntry sapEntry = _sapEntryLocalService.fetchSAPEntry(
					companyId, name);

			if (null == sapEntry) {

				Map<Locale, String> map = 
						ResourceBundleUtil.getLocalizationMap(ResourceBundleLoaderUtil.getResourceBundleLoaderByBundleSymbolicName(JWTUtilityConstant.BUNDLE_NAME), name);
				_sapEntryLocalService.addSAPEntry(userId, allowedServiceSignatures, false, true, name, map, new ServiceContext());
			}


		}catch (PortalException e) {
			_log.error("Impossibile registrare SAP ServiziDigitali JWT", e);
		}

		_authVerifierRegistration = bundleContext.registerService(AuthVerifier.class, authVerifier, authVerifierProperties);
	}

	@Deactivate
	protected void deactivate() {
		if (_authVerifierRegistration != null) {
			_authVerifierRegistration.unregister();

			_authVerifierRegistration = null;
		}
	}

	@Modified
	protected void modified(
			BundleContext bundleContext, Map<String, Object> properties) {

		deactivate();

		activate(bundleContext, properties);
	}

	protected String translateKey(String authVerifierPropertyName, String key) {
		if (key.equals("hostsAllowed")) {
			key = "hosts.allowed";
		}
		else if (key.equals("urlsExcludes")) {
			key = "urls.excludes";
		}
		else if (key.equals("urlsIncludes")) {
			key = "urls.includes";
		}

		return authVerifierPropertyName + key;
	}

	private ServiceRegistration<AuthVerifier> _authVerifierRegistration;

	@Reference(unbind = "-")
	private JwtUtilityService _jwtUtilityService;

	@Reference
	private SAPEntryLocalService _sapEntryLocalService;

	@Reference 
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(JwtAuthVerifierActivator.class);

}
