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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseCaseNoteFolderRequestsCancellationTaskSettingsImpl;
import ims.admin.vo.CaseNoteTrackingConfigVo;
import ims.admin.vo.domain.CaseNoteFolderRequestsCancellationSettingsVoAssembler;
import ims.admin.vo.domain.CaseNoteTrackingConfigVoAssembler;
import ims.core.configuration.domain.objects.CancelRequestsSchedule;
import ims.core.configuration.domain.objects.CaseNoteTrackingConfig;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class CaseNoteFolderRequestsCancellationTaskSettingsImpl extends BaseCaseNoteFolderRequestsCancellationTaskSettingsImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.CaseNoteFolderRequestsCancellationSettingsVo getConfiguration(ims.admin.vo.ConfiguredJobVo jobVo)
	{
		if (jobVo == null)
			throw new CodingRuntimeException("The job is null or invalid.");
		
		DomainFactory df = getDomainFactory();
		CancelRequestsSchedule settingsDO =  CancelRequestsSchedule.getCancelRequestsScheduleFromConfiguredJobDetails(df, jobVo.getBoId());
		
		return CaseNoteFolderRequestsCancellationSettingsVoAssembler.create(settingsDO);
	}

	public ims.admin.vo.CaseNoteFolderRequestsCancellationSettingsVo saveConfiguration(ims.admin.vo.CaseNoteFolderRequestsCancellationSettingsVo recordVo) throws StaleObjectException
	{	
		if (recordVo == null)
			throw new CodingRuntimeException("Invalid Configuration.");
		if (!recordVo.isValidated())
			throw new CodingRuntimeException("Configuration not validated.");
		
		DomainFactory domainFactory = getDomainFactory();
		
		CancelRequestsSchedule settingsDO = CaseNoteFolderRequestsCancellationSettingsVoAssembler.extractCancelRequestsSchedule(domainFactory, recordVo);
		domainFactory.save(settingsDO);
		
		return CaseNoteFolderRequestsCancellationSettingsVoAssembler.create(settingsDO);
		
	}

	public CaseNoteTrackingConfigVo getCaseNoteTrackingConfig()
	{
		List<?> results = getDomainFactory().find("from CaseNoteTrackingConfig as cnconf");
		
		if (results == null || results.isEmpty())
			return null;
		return CaseNoteTrackingConfigVoAssembler.create((CaseNoteTrackingConfig) results.get(0));
	}
}