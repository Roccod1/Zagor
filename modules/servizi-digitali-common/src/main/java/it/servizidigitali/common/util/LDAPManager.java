/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.servizidigitali.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.ContextNotEmptyException;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NameClassPair;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.AttributeInUseException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.NoSuchAttributeException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 * Classe Manager per le operazioni su LDAP.
 *
 * @author Gianluca Pindinelli
 *
 */
public class LDAPManager {

	private static final String ORCLRESOURCENAME_ATTRIBUTE_NAME = "orclresourcename";
	private static final String TOP_ATTRIBUTE_NAME = "top";
	private static final String OBJECTCLASS_ATTRIBUTE_NAME = "objectClass";

	private static final String CN_RESOURCE_ACCESS_DESCRIPTOR_NAME = "cn=Resource Access Descriptor";
	private static final String ORCL_FLEX_ATTRIBUTE_1_VALUE = "MIR04T";
	private static final String ORACLE_DB_VALUE = "oracleDB";
	private static final String ORCLPASSWORDATTRIBUTE_NAME = "orclpasswordattribute";
	private static final String ORCLOWNERGUID_ATTRIBUTE_NAME = "orclownerguid";

	private static final Log log = LogFactoryUtil.getLog(LDAPManager.class);

	/** The OU (organizational unit) to add users to */
	private final String users_ou;

	/** The OU (organizational unit) to add groups to */
	private final String groups_ou;

	/** The OU (organizational unit) to add permissions to */
	private final String permission_ou;

	/** The hostname connected to */
	private final String hostname;
	private final String username;
	private final String password;

	/** The port connected to */
	private final int port;

	private final boolean autoCloseContext;

	private DirContext context;

	public LDAPManager(String hostname, int port, String username, String password, String users_ou, String groups_ou, String permission_ou, boolean autoCloseContext) throws NamingException {

		// Only save data if we got connected
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.port = port;
		this.users_ou = users_ou;
		this.groups_ou = groups_ou;
		this.permission_ou = permission_ou;
		this.autoCloseContext = autoCloseContext;
	}

	private DirContext getInitialContext(String hostname, int port, String username, String password) throws NamingException {

		String providerURL = null;

		if (port != 0) {
			providerURL = new StringBuffer("ldap://").append(hostname).append(":").append(port).toString();
		}
		else {
			providerURL = new StringBuffer("").append(hostname).toString();
		}

		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		props.put(Context.PROVIDER_URL, providerURL);

		if ((username != null) && (!username.equals(""))) {
			props.put(Context.SECURITY_AUTHENTICATION, "simple");
			props.put(Context.SECURITY_PRINCIPAL, username);
			props.put(Context.SECURITY_CREDENTIALS, ((password == null) ? "" : password));
		}

		return new InitialDirContext(props);
	}

	public void closeContext() throws NamingException {
		if (context != null && !autoCloseContext) {
			context.close();
		}
	}

	public void addUser(String username, LinkedHashMap<String, String> attributesMap) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			// Create a container set of attributes
			Attributes container = new BasicAttributes();

			// Create the objectclass to add
			Attribute objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
			objClasses.add(TOP_ATTRIBUTE_NAME);
			objClasses.add("person");
			objClasses.add("organizationalPerson");
			objClasses.add("inetOrgPerson");
			objClasses.add("orclUser");
			objClasses.add("orclUserV2");

			container.put(objClasses);
			// Assign attributes
			if (attributesMap != null) {
				for (Map.Entry<String, String> entry : attributesMap.entrySet()) {
					Attribute attribute = new BasicAttribute(entry.getKey(), entry.getValue());
					container.put(attribute);
				}

				// Create the entry
				context.createSubcontext(getUserDN(username), container);
			}
			else {
				log.error("addUser :: attributes map is null");
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

	}

	public void updateUser(String oldUsername, String newUsername, LinkedHashMap<String, String> attributesMap) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			ModificationItem[] mods = null;

			if (attributesMap != null) {
				mods = new ModificationItem[attributesMap.size()];
				int counter = 0;
				for (Map.Entry<String, String> entry : attributesMap.entrySet()) {
					Attribute attribute = new BasicAttribute(entry.getKey(), entry.getValue());
					mods[counter] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attribute);
					counter++;
				}

				// Update the entry
				context.modifyAttributes(getUserDN(oldUsername), mods);
				if (!oldUsername.equals(newUsername)) {
					context.rename(getUserDN(oldUsername), getUserDN(newUsername));
				}
			}
			else {
				log.error("updateUser :: attributes map is null");
			}
		}
		catch (NoSuchAttributeException e) {
			log.warn("updateUser :: " + e.getMessage());
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void deleteUser(String username) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			context.destroySubcontext(getUserDN(username));
		}
		catch (NameNotFoundException e) {
			// If the user is not found, ignore the error
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public boolean isValidUser(String username, String password) throws NamingException {

		context = null;
		try {
			context = getInitialContext(hostname, port, getUserDN(username), password);
			context.close();
			return true;
		}
		catch (javax.naming.NameNotFoundException e) {
			throw new NameNotFoundException(username);
		}
		catch (NamingException e) {
			log.error(e);
			return false;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void addGroup(String name, String description) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			// Create a container set of attributes
			Attributes container = new BasicAttributes();

			// Create the objectclass to add
			Attribute objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
			objClasses.add(TOP_ATTRIBUTE_NAME);
			objClasses.add("groupOfUniqueNames");

			// Assign the name and description to the group
			Attribute cn = new BasicAttribute("cn", name);
			Attribute desc = new BasicAttribute("description", description);

			// Add these to the container
			container.put(objClasses);
			container.put(cn);
			container.put(desc);

			// Create the entry
			context.createSubcontext(getGroupDN(name), container);
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void deleteGroup(String name) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			context.destroySubcontext(getGroupDN(name));
		}
		catch (NameNotFoundException e) {
			// If the group is not found, ignore the error
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void addPermission(String name, String description) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			// Create a container set of attributes
			Attributes container = new BasicAttributes();

			// Create the objectclass to add
			Attribute objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
			objClasses.add(TOP_ATTRIBUTE_NAME);
			objClasses.add("forethoughtPermission");

			// Assign the name and description to the group
			Attribute cn = new BasicAttribute("cn", name);
			Attribute desc = new BasicAttribute("description", description);

			// Add these to the container
			container.put(objClasses);
			container.put(cn);
			container.put(desc);

			// Create the entry
			context.createSubcontext(getPermissionDN(name), container);
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void deletePermission(String name) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			context.destroySubcontext(getPermissionDN(name));
		}
		catch (NameNotFoundException e) {
			// If the permission is not found, ignore the error
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void assignUser(String username, String groupName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			ModificationItem[] mods = new ModificationItem[1];

			Attribute mod = new BasicAttribute("uniquemember", getUserDN(username));
			mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
			context.modifyAttributes(getGroupDN(groupName), mods);
		}
		catch (AttributeInUseException e) {
			// If user is already added, ignore exception
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void removeUser(String username, String groupName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			ModificationItem[] mods = new ModificationItem[1];

			Attribute mod = new BasicAttribute("uniquemember", getUserDN(username));
			mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, mod);
			context.modifyAttributes(getGroupDN(groupName), mods);
		}
		catch (NoSuchAttributeException e) {
			// If user is not assigned, ignore the error
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public boolean userInGroup(String username, String groupName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		// Set up attributes to search for
		try {
			String[] searchAttributes = new String[1];
			searchAttributes[0] = "uniquemember";

			Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
			if (attributes != null) {
				Attribute memberAtts = attributes.get("uniquemember");
				if (memberAtts != null) {
					for (NamingEnumeration<?> vals = memberAtts.getAll(); vals.hasMoreElements();) {
						if (username.equalsIgnoreCase(getUserUID((String) vals.nextElement()))) {
							return true;
						}
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return false;
	}

	public Map<String, List<Object>> getExtendedAttributes(String username, String[] userExtendedAttributes) throws NamingException {

		Map<String, List<Object>> results = new LinkedHashMap<String, List<Object>>();

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		// Set up attributes to search for
		try {
			SearchControls searchControls = new SearchControls();
			searchControls.setReturningAttributes(userExtendedAttributes);
			NamingEnumeration<SearchResult> namingEnumeration = context.search(users_ou, "(cn=" + username + ")", searchControls);
			if (namingEnumeration != null) {
				while (namingEnumeration.hasMore()) {
					SearchResult searchresult = namingEnumeration.next();
					Attributes attributes = searchresult.getAttributes();
					if (attributes != null) {
						for (NamingEnumeration<?> ae = attributes.getAll(); ae.hasMore();) {
							List<Object> attributesValue = new ArrayList<Object>();
							Attribute attr = (Attribute) ae.next();
							for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
								Object next = e.next();
								attributesValue.add(next);
							}
							results.put(attr.getID(), attributesValue);
						}
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return results;
	}

	public boolean userExists(String username) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			NamingEnumeration<?> namingEnum = context.search(users_ou, "(cn=" + username + ")", getSimpleSearchControls());
			boolean hasMoreElements = namingEnum.hasMoreElements();
			if (hasMoreElements) {
				namingEnum.close();
				return true;
			}
			namingEnum.close();
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return false;
	}

	private SearchControls getSimpleSearchControls() {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		searchControls.setTimeLimit(30000);
		// String[] attrIDs = {"objectGUID"};
		// searchControls.setReturningAttributes(attrIDs);
		return searchControls;
	}

	public List<String> getMembers(String groupName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		List<String> members;
		try {
			members = new LinkedList<String>();

			// Set up attributes to search for
			String[] searchAttributes = new String[1];
			searchAttributes[0] = "uniquemember";

			Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
			if (attributes != null) {
				Attribute memberAtts = attributes.get("uniquemember");
				if (memberAtts != null) {
					for (NamingEnumeration<?> vals = memberAtts.getAll(); vals.hasMoreElements(); members.add(getUserUID((String) vals.nextElement()))) {
						;
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return members;
	}

	public List<String> getGroups(String username) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		List<String> groups;
		try {
			groups = new LinkedList<String>();

			// Set up criteria to search on
			String filter = new StringBuffer().append("(&").append("(objectClass=groupOfUniqueNames)").append("(uniquemember=").append(getUserDN(username)).append(")").append(")").toString();

			// Set up search constraints
			SearchControls cons = new SearchControls();
			cons.setSearchScope(SearchControls.ONELEVEL_SCOPE);

			NamingEnumeration<?> results = context.search(groups_ou, filter, cons);

			while (results.hasMore()) {
				SearchResult result = (SearchResult) results.next();
				groups.add(getGroupCN(result.getName()));
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return groups;
	}

	public List<String> getGroups() throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		List<String> groups;
		try {
			groups = new LinkedList<String>();

			// Set up criteria to search on
			String filter = new StringBuffer().append("(objectClass=groupOfUniqueNames)").toString();

			// Set up search constraints
			SearchControls cons = new SearchControls();
			cons.setSearchScope(SearchControls.ONELEVEL_SCOPE);

			NamingEnumeration<?> results = context.search(groups_ou, filter, cons);

			while (results.hasMore()) {
				SearchResult result = (SearchResult) results.next();
				groups.add(getGroupCN(result.getName()));
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return groups;
	}

	public Map<String, Map<String, List<Object>>> getUsers(String[] userExtendedAttributes) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		Map<String, Map<String, List<Object>>> users = new HashMap<String, Map<String, List<Object>>>();
		try {
			// Set up criteria to search on
			String filter = new StringBuffer().append("(objectClass=inetOrgPerson)").toString();

			userExtendedAttributes = Arrays.copyOf(userExtendedAttributes, userExtendedAttributes.length + 1);
			userExtendedAttributes[userExtendedAttributes.length - 1] = "cn";

			// Set up search constraints
			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
			searchControls.setReturningAttributes(userExtendedAttributes);

			NamingEnumeration<?> namingEnumeration = context.search(users_ou, filter, searchControls);

			if (namingEnumeration != null) {
				while (namingEnumeration.hasMore()) {
					Map<String, List<Object>> results = new LinkedHashMap<String, List<Object>>();
					SearchResult searchresult = (SearchResult) namingEnumeration.next();
					Attributes attributes = searchresult.getAttributes();
					String username = null;
					if (attributes != null) {
						for (NamingEnumeration<?> ae = attributes.getAll(); ae.hasMore();) {
							List<Object> attributesValue = new ArrayList<Object>();
							Attribute attr = (Attribute) ae.next();
							for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
								Object next = e.next();
								if (attr.getID().equals("cn")) {
									username = (String) next;
								}
								attributesValue.add(next);
							}
							results.put(attr.getID(), attributesValue);
						}
					}
					users.put(username, results);
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return users;
	}

	public void assignPermission(String groupName, String permissionName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		try {
			ModificationItem[] mods = new ModificationItem[1];

			Attribute mod = new BasicAttribute("uniquePermission", getPermissionDN(permissionName));
			mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
			context.modifyAttributes(getGroupDN(groupName), mods);
		}
		catch (AttributeInUseException e) {
			// Ignore the attribute if it is already assigned
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void revokePermission(String groupName, String permissionName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		try {
			ModificationItem[] mods = new ModificationItem[1];

			Attribute mod = new BasicAttribute("uniquePermission", getPermissionDN(permissionName));
			mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, mod);
			context.modifyAttributes(getGroupDN(groupName), mods);
		}
		catch (NoSuchAttributeException e) {
			// Ignore errors if the attribute doesn't exist
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public boolean hasPermission(String groupName, String permissionName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		// Set up attributes to search for
		try {
			String[] searchAttributes = new String[1];
			searchAttributes[0] = "uniquePermission";

			Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
			if (attributes != null) {
				Attribute permAtts = attributes.get("uniquePermission");
				if (permAtts != null) {
					for (NamingEnumeration<?> vals = permAtts.getAll(); vals.hasMoreElements();) {
						if (permissionName.equalsIgnoreCase(getPermissionCN((String) vals.nextElement()))) {
							return true;
						}
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return false;
	}

	public List<String> getPermissions(String groupName) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		List<String> permissions;
		try {
			permissions = new LinkedList<String>();

			// Set up attributes to search for
			String[] searchAttributes = new String[1];
			searchAttributes[0] = "uniquePermission";

			Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
			if (attributes != null) {
				Attribute permAtts = attributes.get("uniquePermission");
				if (permAtts != null) {
					for (NamingEnumeration<?> vals = permAtts.getAll(); vals.hasMoreElements(); permissions.add(getPermissionCN((String) vals.nextElement()))) {
						;
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return permissions;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param orclOwnerGuid
	 * @param mainLDAPRadDN
	 * @param orclApplicationCommonName
	 * @param orclResourceNames
	 * @throws NamingException
	 */
	public void addRADEntry(String username, String password, String orclOwnerGuid, String mainLDAPRadDN, String orclApplicationCommonName, Set<String> orclResourceNames) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {
			addOracleRADEntry(username, password, orclOwnerGuid, mainLDAPRadDN, orclApplicationCommonName, orclResourceNames);
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param orclOwnerGuid
	 * @param mainLDAPRadDN
	 * @param orclApplicationCommonName
	 * @param orclResourceNames
	 * @param preservedOrclResourceNames
	 * @throws NamingException
	 */
	public void updateRADEntry(String username, String password, String orclOwnerGuid, String mainLDAPRadDN, String orclApplicationCommonName, Set<String> orclResourceNames,
			Set<String> preservedOrclResourceNames) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		try {

			deleteRADEntries(orclOwnerGuid, mainLDAPRadDN, preservedOrclResourceNames);

			// Creazione nuove entries RAD
			addOracleRADEntry(username, password, orclOwnerGuid, mainLDAPRadDN, orclApplicationCommonName, orclResourceNames);
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}
	}

	public void deleteRADEntries(String orclOwnerGuid, String mainLDAPRadDN, Set<String> preservedOrclResourceNames) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);
		// Eliminazione entryes RAD
		String orclownerguidDN = ORCLOWNERGUID_ATTRIBUTE_NAME + "=" + orclOwnerGuid + "," + mainLDAPRadDN;
		try {
			NamingEnumeration<NameClassPair> subList = context.list(CN_RESOURCE_ACCESS_DESCRIPTOR_NAME + "," + orclownerguidDN);
			while (subList.hasMoreElements()) {
				NameClassPair nameClassPair = subList.nextElement();
				if (canDeleteOrclResourceName(nameClassPair.getNameInNamespace(), preservedOrclResourceNames)) {
					context.destroySubcontext(nameClassPair.getNameInNamespace());
				}
			}

		}
		catch (NameNotFoundException e) {
			if (log.isDebugEnabled()) {
				log.warn(e.getMessage());
			}
		}

		try {
			context.destroySubcontext(CN_RESOURCE_ACCESS_DESCRIPTOR_NAME + "," + orclownerguidDN);
		}
		catch (NameNotFoundException | ContextNotEmptyException e) {
			if (log.isDebugEnabled()) {
				log.warn("Rimozione " + CN_RESOURCE_ACCESS_DESCRIPTOR_NAME + "," + orclownerguidDN + ": " + e.getMessage());
			}
		}

		try {
			context.destroySubcontext(orclownerguidDN);
		}
		catch (NameNotFoundException | ContextNotEmptyException e) {
			if (log.isDebugEnabled()) {
				log.warn("Rimozione " + orclownerguidDN + ": " + e.getMessage());
			}
		}

		if (context != null && autoCloseContext) {
			context.close();
		}
	}

	private boolean canDeleteOrclResourceName(String nameInNamespace, Set<String> preservedOrclResourceNames) throws NamingException {

		if (preservedOrclResourceNames == null) {
			return true;
		}

		Attributes attributes = context.getAttributes(nameInNamespace);
		if (attributes != null) {
			for (NamingEnumeration<?> ae = attributes.getAll(); ae.hasMore();) {
				Attribute attr = (Attribute) ae.next();
				for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
					Object next = e.next();
					String attributeId = attr.getID();

					if (attributeId.equals(ORCLRESOURCENAME_ATTRIBUTE_NAME)) {
						if (preservedOrclResourceNames.contains(next)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param orclOwnerGuid
	 * @param mainLDAPRadDN
	 * @param orclApplicationCommonName
	 * @param orclResourceNames
	 * @throws NamingException
	 */
	private void addOracleRADEntry(String username, String password, String orclOwnerGuid, String mainLDAPRadDN, String orclApplicationCommonName, Set<String> orclResourceNames)
			throws NamingException {

		String userDN = getUserDN(username);

		String orclownerguidDN = ORCLOWNERGUID_ATTRIBUTE_NAME + "=" + orclOwnerGuid + "," + mainLDAPRadDN;

		// Creazione contenitore con orclownerguid
		Attributes container = new BasicAttributes();

		Attribute objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
		objClasses.add(TOP_ATTRIBUTE_NAME);
		objClasses.add("orclreferenceobject");

		container.put(objClasses);

		container.put(new BasicAttribute(ORCLOWNERGUID_ATTRIBUTE_NAME, orclOwnerGuid));
		container.put(new BasicAttribute("seealso", userDN));

		try {
			context.createSubcontext(orclownerguidDN, container);
		}
		catch (NameAlreadyBoundException e) {
			if (log.isDebugEnabled()) {
				log.warn("Aggiunta " + orclownerguidDN + ": " + e.getMessage());
			}
		}

		String resourceAccessDescriptorDN = CN_RESOURCE_ACCESS_DESCRIPTOR_NAME + "," + orclownerguidDN;

		// Creazione contenitore cn=Resource Access Descriptor
		container = new BasicAttributes();

		objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
		objClasses.add(TOP_ATTRIBUTE_NAME);
		objClasses.add("orclcontainer");
		objClasses.add("orclauxiliaryguid");

		container.put(objClasses);

		container.put(new BasicAttribute(ORCLOWNERGUID_ATTRIBUTE_NAME, orclOwnerGuid));

		try {
			context.createSubcontext(resourceAccessDescriptorDN, container);
		}
		catch (NameAlreadyBoundException e) {
			if (log.isDebugEnabled()) {
				log.warn("Aggiunta " + resourceAccessDescriptorDN + ": " + e.getMessage());
			}
		}

		// Creazione DN per ciascuna configurazione applicativa
		for (String orclResourceName : orclResourceNames) {

			String orclResourceNameDN = ORCLRESOURCENAME_ATTRIBUTE_NAME + "=" + orclResourceName + "+orclresourcetypename=OracleDB," + resourceAccessDescriptorDN;

			container = new BasicAttributes();

			objClasses = new BasicAttribute(OBJECTCLASS_ATTRIBUTE_NAME);
			objClasses.add(TOP_ATTRIBUTE_NAME);
			objClasses.add("orclresourcedescriptor");

			container.put(objClasses);

			container.put(new BasicAttribute("orcluseridattribute", username));
			container.put(new BasicAttribute("orclresourceviewers", userDN));
			container.put(new BasicAttribute("orclresourceviewers", "orclApplicationCommonName=" + orclApplicationCommonName + ",cn=Forms,cn=Products, cn=OracleContext"));
			container.put(new BasicAttribute(ORCLOWNERGUID_ATTRIBUTE_NAME, orclOwnerGuid));
			container.put(new BasicAttribute(ORCLPASSWORDATTRIBUTE_NAME, password));
			container.put(new BasicAttribute("orclflexattribute1", ORCL_FLEX_ATTRIBUTE_1_VALUE));
			container.put(new BasicAttribute(ORCLRESOURCENAME_ATTRIBUTE_NAME, orclResourceName));
			container.put(new BasicAttribute("orclresourcetypename", ORACLE_DB_VALUE));
			container.put(new BasicAttribute("orclusermodifiable", "true"));

			try {
				context.createSubcontext(orclResourceNameDN, container);
			}
			catch (NameAlreadyBoundException e) {
				if (log.isDebugEnabled()) {
					log.warn("Aggiunta " + orclResourceNameDN + ": " + e.getMessage());
				}
			}
		}
	}

	/**
	 * 
	 * @param username
	 * @param orclOwnerGuid
	 * @param mainLDAPRadDN
	 * @return
	 * @throws NamingException
	 */
	public String getPasswordFromRADAttribute(String username, String orclOwnerGuid, String mainLDAPRadDN) throws NamingException {

		context = getInitialContext(this.hostname, this.port, this.username, this.password);

		String orclownerguidDN;
		try {
			orclownerguidDN = ORCLOWNERGUID_ATTRIBUTE_NAME + "=" + orclOwnerGuid + "," + mainLDAPRadDN;
			String resourceAccessDescriptorDN = CN_RESOURCE_ACCESS_DESCRIPTOR_NAME + "," + orclownerguidDN;

			NamingEnumeration<NameClassPair> subList = context.list(resourceAccessDescriptorDN);
			if (subList.hasMoreElements()) {
				NameClassPair nameClassPair = subList.nextElement();

				String nameInNamespace = nameClassPair.getNameInNamespace();

				Attributes attributes = context.getAttributes(nameInNamespace);
				if (attributes != null) {
					for (NamingEnumeration<?> ae = attributes.getAll(); ae.hasMore();) {
						Attribute attr = (Attribute) ae.next();
						for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
							Object next = e.next();
							String attributeId = attr.getID();
							if (attributeId.equals(ORCLPASSWORDATTRIBUTE_NAME)) {
								return (String) next;
							}
						}
					}
				}
			}
		}
		catch (NamingException e) {
			log.error(e);
			throw e;
		}
		finally {
			if (context != null && autoCloseContext) {
				context.close();
			}
		}

		return null;

	}

	private String getUserDN(String username) {
		if (!username.contains("cn=")) {
			return new StringBuffer().append("cn=").append(username).append(",").append(users_ou).toString();
		}
		else {
			return new StringBuffer().append(username).append(",").append(users_ou).toString();
		}
	}

	private String getUserUID(String userDN) {
		int start = userDN.indexOf("=");
		int end = userDN.indexOf(",");

		if (end == -1) {
			end = userDN.length();
		}

		return userDN.substring(start + 1, end);
	}

	private String getGroupDN(String name) {
		return new StringBuffer().append("cn=").append(name).append(",").append(groups_ou).toString();
	}

	private String getGroupCN(String groupDN) {
		int start = groupDN.indexOf("=");
		int end = groupDN.indexOf(",");

		if (end == -1) {
			end = groupDN.length();
		}

		return groupDN.substring(start + 1, end);
	}

	private String getPermissionDN(String name) {
		return new StringBuffer().append("cn=").append(name).append(",").append(permission_ou).toString();
	}

	private String getPermissionCN(String permissionDN) {
		int start = permissionDN.indexOf("=");
		int end = permissionDN.indexOf(",");

		if (end == -1) {
			end = permissionDN.length();
		}

		return permissionDN.substring(start + 1, end);
	}

}
