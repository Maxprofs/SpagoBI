/*
 * SpagoBI, the Open Source Business Intelligence suite
 * � 2005-2015 Engineering Group
 *
 * This file is part of SpagoBI. SpagoBI is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 2.1 of the License, or any later version. 
 * SpagoBI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details. You should have received
 * a copy of the GNU Lesser General Public License along with SpagoBI. If not, see: http://www.gnu.org/licenses/.
 * The complete text of SpagoBI license is included in the COPYING.LESSER file. 
 */
package it.eng.spagobi.commons.initializers.metadata;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.eng.spago.base.SourceBean;
import it.eng.spago.init.InitializerIFace;
import it.eng.spagobi.behaviouralmodel.check.metadata.SbiChecks;
import it.eng.spagobi.commons.dao.AbstractHibernateDAO;
import it.eng.spagobi.commons.metadata.SbiDomains;
import it.eng.spagobi.utilities.exceptions.SpagoBIRuntimeException;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class ChecksInitializer extends SpagoBIInitializer {

	static private Logger logger = Logger.getLogger(ChecksInitializer.class);

	public ChecksInitializer() {
		targetComponentName = "Checks";
		configurationFileName = "it/eng/spagobi/commons/initializers/metadata/config/checks.xml";
	}
	
	public void init(SourceBean config, Session hibernateSession) {
		logger.debug("IN");
		try {
			String hql = "from SbiChecks";
			Query hqlQuery = hibernateSession.createQuery(hql);
			List checks = hqlQuery.list();
			if (checks.isEmpty()) {
				logger.info("Checks table is empty. Starting populating predefined checks...");
				writeChecks(hibernateSession);
			} else {
				logger.debug("Checks table is already populated");
			}
		} catch (Throwable t) {
			throw new SpagoBIRuntimeException("Ab unexpected error occured while initializeng Checks", t);
		} finally {
			logger.debug("OUT");
		}
	}
	
	private void writeChecks(Session aSession) throws Exception {
		logger.debug("IN");
		SourceBean checksSB = getConfiguration();
		if (checksSB == null) {
			logger.info("Configuration file for predefined checks not found");
			return;
		}
		List checksList = checksSB.getAttributeAsList("CHECK");
		if (checksList == null || checksList.isEmpty()) {
			logger.info("No predefined checks available from configuration file");
			return;
		}
		Iterator it = checksList.iterator();
		while (it.hasNext()) {
			SourceBean aChecksSB = (SourceBean) it.next();
			SbiChecks aCheck = new SbiChecks();
			aCheck.setLabel((String) aChecksSB.getAttribute("label"));
			aCheck.setName((String) aChecksSB.getAttribute("name"));
			aCheck.setDescr((String) aChecksSB.getAttribute("descr"));

			String valueTypeCd = (String) aChecksSB.getAttribute("valueTypeCd");
			SbiDomains domainValueType = findDomain(aSession, valueTypeCd, "PRED_CHECK");
			aCheck.setCheckType(domainValueType);
			aCheck.setValueTypeCd(valueTypeCd);

			aCheck.setValue1((String) aChecksSB.getAttribute("value1"));
			aCheck.setValue2((String) aChecksSB.getAttribute("value2"));

			logger.debug("Inserting Check with label = [" + aChecksSB.getAttribute("label") + "] ...");

			aSession.save(aCheck);
		}
		logger.debug("OUT");
	}

}
