//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3520.27738)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.forms.icpevaluationnotes;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.icp.vo.PatientICPEvaluationNoteVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Event handlers region
	//------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		setFormReadOnlyMode(args);

		open();
		
		updateControlsState();
	}

	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			engine.close(DialogResult.OK);
	}

	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation function
	//------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to set the form to read only.
	 * Used when ICP is completed or user chooses to view the Evaluation Note. 
	 */
	private void setFormReadOnlyMode(Object[] args)
	{
		// Check arguments to determine if the form should be in read-only mode
		boolean isReadOnly = (args != null) && (args.length > 0) && Boolean.TRUE.equals(args[0]);
		// Set appropriate mode to form
		form.setMode(isReadOnly ? FormMode.VIEW : FormMode.EDIT);
	}

	/**
	 * Function used to present / refresh screen
	 */
	private void open()
	{
		// Get Patient ICP record from domain
		form.getLocalContext().setPatientICP(domain.getPatientICP(form.getGlobalContext().ICP.getPatientICPRecord()));
		
		if (form.getLocalContext().getPatientICP().getVersion_PatientICP() > form.getGlobalContext().ICP.getPatientICPRecord().getVersion_PatientICP())
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);
			return;
		}
		
		// Get Evaluation Note record (can be null)
		form.getLocalContext().setPatientEvaluationNote(domain.getEvaluationNote(form.getGlobalContext().ICP.getEvaluationNote()));
		
		// Populate instance controls with Evaluation Note record data
		populateInstanceControlsFromData(form.getLocalContext().getPatientEvaluationNote());
	}


	/**
	 * Function used to clear instance controls.
	 * Will not clear data saved in local contexts
	 */
	private void clearInstanceControls()
	{
		form.cmbDiscipline().setValue(null);
		form.ccAutoringInfo().setValue(null);
		form.richTextNote().setValue(null);
		form.dtimEvalDate().setValue(null);
	}

	private boolean save()
	{
		// Populate record to save with data from screen
		PatientICPEvaluationNoteVo note = populateDataFromInstanceControls(form.getLocalContext().getPatientEvaluationNote());
		
		// Validate record to save
		String[] errors = note.validate();
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		
		if (note.getID_PatientICPEvaluationNote() == null)
		{
			try
			{
				domain.addEvaluationNote(form.getLocalContext().getPatientICP(), note);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.close(DialogResult.CANCEL);
				return false;
			}
		}
		else
		{
			try
			{
				domain.updateEvaluationNote(note);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open();
				return false;
			}
		}

		return true;
	}


	/**
	 * Function used to update controls state depending on context
	 */
	private void updateControlsState()
	{
		PatientICPEvaluationNoteVo note = form.getLocalContext().getPatientEvaluationNote();

		boolean isEditMode = FormMode.EDIT.equals(form.getMode());

		form.ccAutoringInfo().setEnabledAuthoringHCP(isEditMode && (note == null || !note.getID_PatientICPEvaluationNoteIsNotNull()));
		form.ccAutoringInfo().setEnabledDateTime(isEditMode && (note == null || !note.getID_PatientICPEvaluationNoteIsNotNull()));
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange functions
	//------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to populate an Evaluation Note record with data from screen
	 */
	private PatientICPEvaluationNoteVo populateDataFromInstanceControls(PatientICPEvaluationNoteVo evaluationNote)
	{
		if (evaluationNote == null)
		{
			evaluationNote = new PatientICPEvaluationNoteVo();
		}
		
		// Get data from screen into Evaluation Note instance
		evaluationNote.setDiscipline(form.cmbDiscipline().getValue());
		evaluationNote.setAuthoringInformation(form.ccAutoringInfo().getValue());
		evaluationNote.setNote(form.richTextNote().getValue());
		evaluationNote.setDateTime(form.dtimEvalDate().getValue());

		return evaluationNote;
	}

	
	/**
	 * Function used to populate Evaluation Note record to screen
	 */
	private void populateInstanceControlsFromData(PatientICPEvaluationNoteVo note)
	{
		// Clear instance control
		clearInstanceControls();
		
		// If Evaluation note is null, then set default values
		// into instance controls and terminate function
		if (note == null)
		{
			// Set default value to Authoring Info
			form.ccAutoringInfo().initializeComponent();
			form.ccAutoringInfo().setIsRequiredPropertyToControls(Boolean.TRUE);
			
			// Set default value to discipline
			if ((domain.getHcpLiteUser() instanceof HcpLiteVo))
			{
				form.cmbDiscipline().setValue(((HcpLiteVo) domain.getHcpLiteUser()).getHcpType());
			}
			
			return;
		}

		// Populate Instance controls with values from Evaluation Note
		form.cmbDiscipline().setValue(note.getDiscipline());
		form.ccAutoringInfo().setValue(note.getAuthoringInformation());
		form.richTextNote().setValue(note.getNote());
		form.dtimEvalDate().setValue(note.getDateTime());
	}

}