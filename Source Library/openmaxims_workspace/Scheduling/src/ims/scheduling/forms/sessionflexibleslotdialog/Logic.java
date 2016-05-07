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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.sessionflexibleslotdialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Time;
import ims.scheduling.forms.sessionflexibleslotdialog.GenForm.grdSlotsRow;
import ims.scheduling.forms.sessionflexibleslotdialog.GenForm.grdSlotsRowCollection;
import ims.scheduling.vo.SessionParentChildSlotVo;
import ims.scheduling.vo.SessionParentChildSlotVoCollection;
import ims.scheduling.vo.SessionShortVo;
import ims.scheduling.vo.SessionShortVoCollection;
import ims.scheduling.vo.Session_ListOwnerVo;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(args != null && args.length >= 1 && args[0] instanceof SessionShortVo)
		{
			form.getLocalContext().setSelectedSession((SessionShortVo)args[0]);
		}
		if (form.getGlobalContext().RefMan.getSelectedSessionsIsNotNull())
		{
			loadPreSelectedSessions(form.getGlobalContext().RefMan.getSelectedSessions());
		}
		
		initialise();
		
		form.setMode(FormMode.EDIT);
	}

	private void loadPreSelectedSessions(SessionShortVoCollection selectedSessions)
	{
		form.cmbSession().clear();
		if (selectedSessions == null)
			return;
		int size = selectedSessions.size();
		for (int i=0;i<size;i++)
		{
			form.cmbSession().newRow(selectedSessions.get(i), selectedSessions.get(i).getName());
		}
		
		if (form.getLocalContext().getSelectedSessionIsNotNull())
			form.cmbSession().setValue(form.getLocalContext().getSelectedSession());
		else if (size == 1)
			form.cmbSession().setValue(selectedSessions.get(0));		
	}

	private void initialise()
	{
		loadListOwners();
		
	}

	private void loadListOwners()
	{
		form.cmbListOwner().clear();
				
		SessionShortVo selectedSession = form.cmbSession().getValue();
		if(selectedSession != null && selectedSession.getListOwners() != null)
		{
			selectedSession.getListOwners().sort();
			for (Session_ListOwnerVo voListOwner : selectedSession.getListOwners())
				form.cmbListOwner().newRow(voListOwner, voListOwner.toString());	
		}			
		else if (form.getGlobalContext().Scheduling.getSelectedSessionListOwners() != null)
		{
			for (Session_ListOwnerVo voListOwner : form.getGlobalContext().Scheduling.getSelectedSessionListOwners())
				form.cmbListOwner().newRow(voListOwner, voListOwner.toString());	
		}
		
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdSlots().getRows().size() == 0)
		{
			engine.close(DialogResult.CANCEL);
		}
		else
		{
			populateScreenFromData(form.getLocalContext().getSelectedSlot());
			form.setMode(FormMode.VIEW);
		}
	}

	private void populateScreenFromData(SessionParentChildSlotVo selectedSlot)
	{
		clearFields();
		
		if (selectedSlot == null)
			return;
		
		form.cmbPriority().setValue(selectedSlot.getPriority());
		form.cmbListOwner().setValue(selectedSlot.getSlotResp());
		form.timStart().setValue(selectedSlot.getStartTime());
		form.intDuration().setValue(selectedSlot.getDuration());
		form.txtComment().setValue(selectedSlot.getComment());
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		SessionParentChildSlotVo voSessionSlot = populateDataFromScreen();
		
		String[] arrErrors = voSessionSlot.validate(validateUIRules()); 
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		
		addSlotToGrid(voSessionSlot);				
		getFlexibleSlotsToAdd();
		
		form.setMode(FormMode.VIEW);
		
	}

	private void addSlotToGrid(SessionParentChildSlotVo voSessionSlot)
	{
		grdSlotsRow row = null;
		
		if (form.getLocalContext().getSelectedSlot() != null)
			row = form.grdSlots().getSelectedRow();
		else
			row = form.grdSlots().getRows().newRow();
		
		row.setColPriority(voSessionSlot.getPriority() != null ? voSessionSlot.getPriority().getText() :"");
		row.setColOwner(voSessionSlot.getSlotResp() != null ? voSessionSlot.getSlotResp().toString() : "");
		row.setColStartTime(voSessionSlot.getStartTime() != null ? voSessionSlot.getStartTime().toString() : "");
		row.setColDuration(voSessionSlot.getDuration() != null ? voSessionSlot.getDuration().toString() : "");
		
		row.setValue(voSessionSlot);
		
		form.grdSlots().setValue(voSessionSlot);
		form.getLocalContext().setSelectedSlot(voSessionSlot);
		
	}

	private String[] validateUIRules()
	{
		List<String> errors = new ArrayList<String>();
				
		if(form.cmbPriority().getValue() == null)
			errors.add("Priority is mandatory");
		
		if(form.timStart().getValue() == null)
			errors.add("Start Time is mandatory");
		
		if(form.intDuration().getValue() == null)
			errors.add("Duration is mandatory");
		
		SessionShortVo tempvo = form.getLocalContext().getSelectedSession();
		
		if(form.intDuration().getValue() != null && tempvo != null && tempvo.getStartTmIsNotNull() && tempvo.getEndTmIsNotNull())
		{
			if(form.intDuration().getValue() > (tempvo.getEndTm().getTotalMinutes()- tempvo.getStartTm().getTotalMinutes()))
				errors.add("Duration should not be more than the session length .");
		}
		
		
		if(tempvo != null && form.timStart().getValue() != null)
		{
			if(tempvo.getStartTmIsNotNull() && tempvo.getStartTm().isGreaterThan(form.timStart().getValue()))
			{
				errors.add("Slot Start Time cannot be less than Sesion Start Time.");
			}
			
			if(tempvo.getEndTmIsNotNull())
			{
				if(tempvo.getEndTm().isLessThan(form.timStart().getValue()))
				{
					errors.add("Slot Start Time cannot be greater than Session End Time.");
				}
				else if(form.intDuration().getValue() != null)
				{
					Time slotDuration = (Time) form.timStart().getValue().clone();
					slotDuration.addMinutes(form.intDuration().getValue());
					
					if(tempvo.getEndTm().isLessThan(slotDuration))
					{
						errors.add("Slot End Time cannot be greater that Session End Time.");
					}
				}
			}
		}

		if(errors.size() == 0 && slotGoesIntoNextDay())
		{
			errors.add("Slot End Time Continues into the next Day - action not allowed");
		}
			
		return errors.size() > 0 ? errors.toArray(new String[0]) : null;
	}

	private boolean slotGoesIntoNextDay()
	{
		int totalminutes = form.timStart().getValue().getTotalMinutes();
		
		if (totalminutes + form.intDuration().getValue() > 1440)
			return true;
		
		return false;
	}
	
	private SessionParentChildSlotVo populateDataFromScreen()
	{
		SessionParentChildSlotVo slot =  new SessionParentChildSlotVo();
		
		slot.setPriority(form.cmbPriority().getValue());
		slot.setSlotResp(form.cmbListOwner().getValue());
		slot.setStartTime(form.timStart().getValue());
		slot.setDuration(form.intDuration().getValue());
		slot.setComment(form.txtComment().getValue());
		if (form.cmbSession().getValue() != null)
		{
			slot.setSession(form.cmbSession().getValue());
			form.getGlobalContext().RefMan.setSelectedSession(form.cmbSession().getValue());
		}
		else
			slot.setSession(form.getLocalContext().getSelectedSession());
		
		slot.setIsActive(true);
		slot.setAppointment(null);
		slot.setStatus(Status_Reason.SLOTOPENED);
		
		return slot;
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		getFlexibleSlotsToAdd();

		engine.close(DialogResult.OK);
		
	}

	private void getFlexibleSlotsToAdd()
	{
		grdSlotsRowCollection rows = form.grdSlots().getRows();

		SessionParentChildSlotVoCollection slotsColl = new SessionParentChildSlotVoCollection();

		for (int i = 0; i < rows.size(); i++)
		{
			if (rows.get(i).getValue() == null)
				continue;
			
			slotsColl.add(rows.get(i).getValue());
		}

		form.getGlobalContext().Scheduling.setFlexibleSessionSlots(slotsColl);
	}

	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
	}

	@Override
	protected void onBtnAddClick() throws PresentationLogicException
	{
		clearFields();
		form.grdSlots().setValue(null);
		form.getLocalContext().setSelectedSlot(null);
		form.setMode(FormMode.EDIT);
		
	}

	private void clearFields()
	{
		
		form.cmbPriority().setValue(null);
		form.cmbListOwner().setValue(null);
		form.timStart().setValue(null);
		form.intDuration().setValue(null);
		form.txtComment().setValue(null);
		
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}

	private void updateControlsState()
	{
		form.lblSession().setVisible(false);
		form.cmbSession().setVisible(false);		
		form.cmbSession().setEnabled(false);
		
		form.btnEdit().setEnabled(form.grdSlots().getSelectedRow() != null);
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()));
		
	}

	@Override
	protected void onGrdSlotsSelectionChanged() throws PresentationLogicException
	{
		form.getLocalContext().setSelectedSlot(form.grdSlots().getValue());
		populateScreenFromData(form.getLocalContext().getSelectedSlot());
		updateControlsState();
		
	}

	@Override
	protected void onCmbSessionValueChanged() throws PresentationLogicException
	{
		loadListOwners();
		
	}
}