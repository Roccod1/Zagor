package it.servizidigitali.common.utility;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

public class MessageUtility {
	
	private ResourceBundle resourceBundle;
	private Locale DEFAULT_LOCALE = Locale.ITALY;
	
	public MessageUtility(String bundleSymbolicName, Locale locale) {
		ResourceBundleLoader resourceBundleLoader = 
				ResourceBundleLoaderUtil.getResourceBundleLoaderByBundleSymbolicName(bundleSymbolicName);
		
		if(Validator.isNull(locale)) {
			locale = DEFAULT_LOCALE;
		}
		
		resourceBundle = resourceBundleLoader.loadResourceBundle(locale);
		
	}
	
	public String getMessage(String key, Object ...arguments) {
		String message = resourceBundle.getString(key);
		
		message = MessageFormat.format(message, arguments);
		
		return message;
	}
	
}
