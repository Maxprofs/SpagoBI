/* SpagoBI, the Open Source Business Intelligence suite

 * Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0, without the "Incompatible With Secondary Licenses" notice. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package it.eng.spagobi.commons.metadata;

import java.util.HashSet;
import java.util.Set;





/**
 * SbiDomains generated by hbm2java
 */
public class SbiDomains  extends SbiHibernateModel {

    // Fields    

     private Integer valueId;
     private String domainCd;
     private String domainNm;
     private String valueCd;
     private String valueNm;
     private String valueDs;
//     private Set sbiExporterses = new HashSet(0);
	

    // Constructors

    /**
     * default constructor.
     */
    public SbiDomains() {
    }
    
    /**
     * constructor with id.
     * 
     * @param valueId the value id
     */
    public SbiDomains(Integer valueId) {
        this.valueId = valueId;
    }
   
    
    

    // Property accessors

    /**
     * Gets the value id.
     * 
     * @return the value id
     */
    public Integer getValueId() {
        return this.valueId;
    }
    
    /**
     * Sets the value id.
     * 
     * @param valueId the new value id
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    /**
     * Gets the domain cd.
     * 
     * @return the domain cd
     */
    public String getDomainCd() {
        return this.domainCd;
    }
    
    /**
     * Sets the domain cd.
     * 
     * @param domainCd the new domain cd
     */
    public void setDomainCd(String domainCd) {
        this.domainCd = domainCd;
    }

    /**
     * Gets the domain nm.
     * 
     * @return the domain nm
     */
    public String getDomainNm() {
        return this.domainNm;
    }
    
    /**
     * Sets the domain nm.
     * 
     * @param domainNm the new domain nm
     */
    public void setDomainNm(String domainNm) {
        this.domainNm = domainNm;
    }

    /**
     * Gets the value cd.
     * 
     * @return the value cd
     */
    public String getValueCd() {
        return this.valueCd;
    }
    
    /**
     * Sets the value cd.
     * 
     * @param valueCd the new value cd
     */
    public void setValueCd(String valueCd) {
        this.valueCd = valueCd;
    }

    /**
     * Gets the value nm.
     * 
     * @return the value nm
     */
    public String getValueNm() {
        return this.valueNm;
    }
    
    /**
     * Sets the value nm.
     * 
     * @param valueNm the new value nm
     */
    public void setValueNm(String valueNm) {
        this.valueNm = valueNm;
    }

    /**
     * Gets the value ds.
     * 
     * @return the value ds
     */
    public String getValueDs() {
        return this.valueDs;
    }
    
    /**
     * Sets the value ds.
     * 
     * @param valueDs the new value ds
     */
    public void setValueDs(String valueDs) {
        this.valueDs = valueDs;
    }

/*	public Set getSbiExporterses() {
		return sbiExporterses;
	}

	public void setSbiExporterses(Set sbiExporterses) {
		this.sbiExporterses = sbiExporterses;
	}

*/

}