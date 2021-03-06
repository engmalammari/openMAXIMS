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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3467.22451)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.domain.base.impl.BaseICPCritcalEventsImpl;
import ims.icp.vo.PatientCriticalEventsVo;
import ims.icp.vo.PatientCriticalEventsVoCollection;
import ims.icp.vo.PatientICP_CriticalEventsVo;
import ims.icp.vo.domain.PatientCriticalEventsVoAssembler;
import ims.icp.vo.domain.PatientICP_CriticalEventsVoAssembler;
import ims.icps.instantiation.domain.objects.PatientCriticalEvents;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.vo.PatientCriticalEventsRefVo;
import ims.icps.instantiation.vo.PatientICPRefVo;

public class ICPCritcalEventsImpl extends BaseICPCritcalEventsImpl
{

	private static final long serialVersionUID = 1L;

	public PatientICP_CriticalEventsVo getPatientICP(PatientICPRefVo icp)
	{
		if (icp == null || icp.getID_PatientICP() == null)
			return null;
		
		return PatientICP_CriticalEventsVoAssembler.create((PatientICP) getDomainFactory().getDomainObject(PatientICP.class, icp.getID_PatientICP()));
	}

	public PatientCriticalEventsVo getCriticalEvent(PatientCriticalEventsRefVo event)
	{
		if (event == null || !event.getID_PatientCriticalEventsIsNotNull())
			return null;
		
		return PatientCriticalEventsVoAssembler.create((PatientCriticalEvents) getDomainFactory().getDomainObject(PatientCriticalEvents.class, event.getID_PatientCriticalEvents()));
	}

	/**
	* addCriticalEvent
	*/
	public void addCriticalEvent(PatientICP_CriticalEventsVo patientICP, PatientCriticalEventsVo criticalEvent) throws StaleObjectException
	{
		if(patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("PatientICP is null or has a null ID !");

		DomainFactory factory = getDomainFactory();
		
		if(patientICP.getCriticalEvents() == null)
			patientICP.setCriticalEvents(new PatientCriticalEventsVoCollection());
		
		patientICP.getCriticalEvents().add(criticalEvent);
		
		PatientICP bo = PatientICP_CriticalEventsVoAssembler.extractPatientICP(factory, patientICP);
		
		factory.save(bo);
	}

	/**
	* editCriticalEvent
	*/
	public void updateCriticalEvent(PatientCriticalEventsVo criticalEvent) throws StaleObjectException
	{
		if(criticalEvent == null)
			throw new CodingRuntimeException("Can't update a null Critical event !");
		
		if(!criticalEvent.isValidated())
			throw new CodingRuntimeException("The Critical event is not validated !");
		
		DomainFactory factory = getDomainFactory();
		
		PatientCriticalEvents bo = PatientCriticalEventsVoAssembler.extractPatientCriticalEvents(factory, criticalEvent);
		factory.save(bo);
	}

}
