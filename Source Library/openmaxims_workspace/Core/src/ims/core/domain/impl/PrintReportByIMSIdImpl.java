//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.documents.domain.objects.PatientDocument;
import ims.core.domain.base.impl.BasePrintReportByIMSIdImpl;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

import java.util.List;

public class PrintReportByIMSIdImpl extends BasePrintReportByIMSIdImpl
{
	private static final long serialVersionUID = 1L;

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List<?> lst = factory.find("select r.reportXml, t.templateXml from ReportBo as r left join r.templates as t where (r.imsId= :imsid and t.isActive = 1) order by t.name", new String[] {"imsid"}, new Object[] {imsId});//wdev-21262
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}

	public void savePatientDocument(PatientDocumentVo patientDocument) throws StaleObjectException
	{
		if (patientDocument == null)
			throw new DomainRuntimeException("Cannot save a null PatientDocument");
		
    	if (!patientDocument.isValidated())
    		throw new DomainRuntimeException("PatientDocument record not validated");
    		
    	DomainFactory factory = getDomainFactory();
    	PatientDocument domainPatientDocument = PatientDocumentVoAssembler.extractPatientDocument(factory, patientDocument);
    	factory.save(domainPatientDocument);
	}
}
