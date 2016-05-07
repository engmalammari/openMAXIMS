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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5176.19432)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.forms.patientclinicalnotessettingsforevolveingestion;

import java.util.ArrayList;

import ims.core.vo.ClinicalNotesForEvolveTaskSettingsVo;
import ims.framework.interfaces.IDynamicFormDataOperations;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic implements IDynamicFormDataOperations
{
	private static final long serialVersionUID = 1L;

	
	//----------------------------------------------------------- public methods
	

	public ClinicalNotesForEvolveTaskSettingsVo getData()
	{
		ClinicalNotesForEvolveTaskSettingsVo settingsVo = populateDataFromScreen(form.getLocalContext().getConfigRecord());
		settingsVo.setConfiguredJob(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		return settingsVo;
		
	}
	
	public String[] validateData() 
	{
		return getData().validate(getUIErrors());
	}
	
	public void saveData() throws Exception
	{
		ClinicalNotesForEvolveTaskSettingsVo record  = getData();
		
		String[] errors = record.validate(getUIErrors());
		if(errors != null && errors.length > 0)
			throw new Exception("Validation Errors");
		
		domain.saveSettings(record);
		
	}
	//---------------------------------------------------------------------------------------------	
	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		loadData(args);
	}
	

	protected void onIntNoOfHoursValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.intNoOfHours().getValue() == null)
			form.intNoOfHours().setValue(new Integer(24));
		form.lblNoteHours().setValue(String.valueOf(form.intNoOfHours().getValue()) + " hours since execution time.");
	}
	
	private void loadData(Object[] args)
	{
		initialize(args);
		open();
		
	}
	private void initialize(Object[] args)
	{
		if (args != null && args.length >=1)
		{
			if (args[0] != null && args[0] instanceof DateTime)
				form.getLocalContext().setConfiguredJobStartDate((DateTime) args[0]);
		}
		
	}

	private void open() 
	{
		form.getLocalContext().setConfigRecord(domain.getSettings(form.getGlobalContext().Admin.getCurrentJobConfiguration()));
		
		if (form.getLocalContext().getConfigRecord() == null)
		{	
			setDefaultValuesToControls();
		}	
		else
			populateScreenFromData(form.getLocalContext().getConfigRecord());
	}
	private void setDefaultValuesToControls()
	{
		form.intNoOfHours().setValue(new Integer(24));
		form.dtimStartJobAt().setValue(form.getLocalContext().getConfiguredJobStartDate() == null ? new DateTime(new Date().addDay(1), new Time(2, 0, 0)) : form.getLocalContext().getConfiguredJobStartDate());
		form.lblNoteHours().setValue((form.intNoOfHours().getValue() != null ? String.valueOf(form.intNoOfHours().getValue()) : "") + " hours since execution time.");
	}
	private void populateScreenFromData(ClinicalNotesForEvolveTaskSettingsVo configRecord)
	{
		clearScreen();
		if (configRecord == null)
			return;
		form.dtimStartJobAt().setValue(configRecord.getInitialJobToRun());
		form.intNoOfHours().setValue(configRecord.getPeriodForJob());
		form.intFailed().setValue(configRecord.getFailedProcessed());
		form.intSuccess().setValue(configRecord.getSuccessfulProcessed());
		form.lblNoteHours().setValue((form.intNoOfHours().getValue() != null ? String.valueOf(form.intNoOfHours().getValue()) : "") + " hours since execution time.");
	}
	private void clearScreen()
	{
		form.dtimStartJobAt().setValue(null);
		form.intNoOfHours().setValue(null);
		form.intFailed().setValue(null);
		form.intSuccess().setValue(null);
		
		
	}
	private  ClinicalNotesForEvolveTaskSettingsVo populateDataFromScreen(ClinicalNotesForEvolveTaskSettingsVo recordVo)
	{
		 if (recordVo == null) 
			 recordVo = new ClinicalNotesForEvolveTaskSettingsVo();
		
		recordVo.setInitialJobToRun(form.dtimStartJobAt().getValue());		 
		recordVo.setPeriodForJob(form.intNoOfHours().getValue());
		
		return recordVo;
	}
	
	private String[] getUIErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.dtimStartJobAt().getValue() == null)
		{
			errors.add ("'Start Date/Time' is mandatory.");
		}
		if (form.intNoOfHours().getValue() == null)
		{
			errors.add ("Number of Hours' is mandatory.");
		}			
		if (form.dtimStartJobAt().getValue() != null && form.getLocalContext().getConfiguredJobStartDateIsNotNull() && form.dtimStartJobAt().getValue().isLessThan(form.getLocalContext().getConfiguredJobStartDate()))
		{
			errors.add ("'Start Date/Time' cannot be earlier than the date set for 'Start job at'.");
		}
		if (form.intNoOfHours().getValue() != null && form.intNoOfHours().getValue().intValue() ==0)
		{
			errors.add ("'Number of Hours' must be greater than 0.");
		}
				
		if (errors.size() > 0) 
		{
			String[] uiErrors = new String[errors.size()];
			errors.toArray(uiErrors);
			engine.showErrors("Invalid Job Settings Record", uiErrors);
			return uiErrors;
		}
		return null;
	}	
}