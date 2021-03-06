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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2265.41281)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.gait;

import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.GaitTestEnvironmentCollection;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.therapies.forms.gait.GenForm.grdGaitRow;
import ims.therapies.vo.GaitShortVo;
import ims.therapies.vo.GaitShortVoCollection;
import ims.therapies.vo.GaitTreatmentVo;
import ims.therapies.vo.GaitTreatmentVoCollection;
import ims.therapies.vo.GaitVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void open()
	{
		clear();
		resetContextVariables();		
							
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			populateParentNodes(domain.listByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));			
		}
									
		form.setMode(FormMode.VIEW);
		reselectUpdatedNode();
	}
	private void reselectUpdatedNode()
	{
		// Pattern demands that the last updated node is displayed
		if (form.getLocalContext().getUpdatedChildIsNotNull())
		{
			form.grdGait().setValue(form.getLocalContext().getUpdatedChild());
			getSelectedInstance();
			form.getLocalContext().setUpdatedChild(null);
		}
	}
	private void getSelectedInstance()
	{
		// In update mode we can select nodes without displaying anything but the context
		// menus can change based on what's selected so we need to update them
		if (form.getMode().equals(FormMode.EDIT)) 
		{
			updateContextMenusState();
			return;
		}		
		
		GenForm.grdGaitRow parentRow = null;
		
		//expand the selected parent
		if(form.grdGait().getValue() instanceof GaitShortVo)
		{									 
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((GaitShortVo) form.grdGait().getValue()));
			parentRow = form.grdGait().getSelectedRow();
			populateParentInstanceControls(form.getLocalContext().getSelectedParentInstance());
			form.getLocalContext().setSelectedChildInstance(null);
			clearChildInstanceControls();
		}		
		else if(form.grdGait().getValue() instanceof GaitTreatmentVo)
		{
			form.getLocalContext().setSelectedChildInstance((GaitTreatmentVo) form.grdGait().getValue());
			populateChildInstanceControls(form.getLocalContext().getSelectedChildInstance());			
			form.getLocalContext().setSelectedParentInstance(getParentFromDomain((GaitShortVo) form.grdGait().getSelectedRow().getParentRow().getValue()));
			parentRow = form.grdGait().getSelectedRow().getParentRow(); 			
		}
 
		if (form.getGlobalContext().Core.getCurrentClinicalContact() == null)
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		else
		{
			GaitShortVo voGaitShort = (GaitShortVo)parentRow.getValue();
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact().
					equals(voGaitShort.getClinicalContact().getID_ClinicalContact())));
		}
		
		updateControlsState();
	}
	private void updateControlsState()
	{
		// The new button
		form.bNew().setVisible(form.getMode().equals(FormMode.VIEW) 
				&& form.getLocalContext().getGoldenInstanceFound().booleanValue() == false
				&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull());

		// The collapsible container
		form.ctnGait().setCollapsed(form.getLocalContext().getSelectedParentInstance() == null);						

		// The empty tab
		if (form.grdGait().getValue() == null)
			form.ctnGait().lyrGait().showtabEmpty();

		// The Parent tab
		setParentTabVisability();						

		// The details tab
		setDetailsTabVisibility();		

		// Pick a tab to show
		showHeaderOrDetailsTab();																				

		// The context menus
		updateContextMenusState();	
	}
	private void showHeaderOrDetailsTab()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			// In view mode just show the selected node 
			if (form.grdGait().getValue() instanceof GaitShortVo)		
				form.ctnGait().lyrGait().showtabHeader();
			else if (form.grdGait().getValue() instanceof GaitTreatmentVo)
				form.ctnGait().lyrGait().showtabDetail();
			else
				form.ctnGait().lyrGait().showtabEmpty();
		}
		else
		{
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.TRUE))
				form.ctnGait().lyrGait().showtabHeader();
			else
				form.ctnGait().lyrGait().showtabDetail();
		}
	}
	private void setDetailsTabVisibility()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{	
			// In view mode, make the details tab visible if a detail instance is selected in the hierarchy grid.  
			form.ctnGait().lyrGait().tabDetail().setHeaderVisible(form.grdGait().getValue() instanceof GaitTreatmentVo);									
		}
		else
		{			
			// In edit mode, make the details tab visible if a hierarchy item has been selected and we're not
			// editing a parent.
			form.ctnGait().lyrGait().tabDetail().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull() && 
					form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE));
			
			setAddApplyCaption();			
		}			

		enableDetailsButtons();	
	}
	private void enableDetailsButtons()
	{
		boolean boolVisible = (form.getMode().equals(FormMode.EDIT) &&
				  form.ctnGait().lyrGait().tabDetail().isHeaderVisible() &&
				  form.getLocalContext().getSelectedChildInstance() == null);

		form.ctnGait().lyrGait().tabDetail().bOkDetails().setVisible(boolVisible);
		form.ctnGait().lyrGait().tabDetail().bClearDetails().setVisible(boolVisible);
	}
	private void setAddApplyCaption()
	{
		form.ctnGait().lyrGait().tabDetail().bOkDetails().setText("Add");
		
		if (form.getLocalContext().getSelectedChildInstance() == null &&
			 (form.grdGait().getValue() instanceof GaitTreatmentVo))
				form.ctnGait().lyrGait().tabDetail().bOkDetails().setText("Apply");
	}
	private void setParentTabVisability()
	{
		form.ctnGait().lyrGait().tabHeader().setHeaderVisible(form.getLocalContext().getSelectedParentInstanceIsNotNull());					
		enableParentControls();
	}
	private void enableParentControls()
	{
		//boolean boolEnabled = (form.getMode().equals(FormMode.EDIT) && 
		//		  form.grdGait().getValue() instanceof GaitShortVo);
		boolean boolEnabled = (form.getMode().equals(FormMode.EDIT));
		form.ctnGait().lyrGait().tabHeader().dtimAuthoring().setEnabled(boolEnabled);
		form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().setEnabled(boolEnabled);
	}
	private void populateChildInstanceControls(GaitTreatmentVo voGaitTreat)
	{
		if (voGaitTreat == null ) return;
		
		form.ctnGait().lyrGait().tabDetail().cmbEnvironment().setValue(voGaitTreat.getEnvironment());
		form.ctnGait().lyrGait().tabDetail().cmboGaitTech().setValue(voGaitTreat.getGaitTechnique());
		form.ctnGait().lyrGait().tabDetail().cmbOrthosis().setValue(voGaitTreat.getOrthosis());
		form.ctnGait().lyrGait().tabDetail().cmbSupervision().setValue(voGaitTreat.getSupervisionLevel());
		form.ctnGait().lyrGait().tabDetail().txtGaitPractice().setValue(voGaitTreat.getGaitPractice());
		form.ctnGait().lyrGait().tabDetail().txtStairPractice().setValue(voGaitTreat.getStairPractice());
		form.ctnGait().lyrGait().tabDetail().txtSummary().setValue(voGaitTreat.getGaitSummary());
		form.ctnGait().lyrGait().tabDetail().intWalkTest().setValue(voGaitTreat.getWalkTestTime());
	}
	private void populateParentInstanceControls(GaitVo voGaitParent)
	{
		if(voGaitParent != null)
		{
			form.ctnGait().lyrGait().tabHeader().dtimAuthoring().setValue(voGaitParent.getAuthoringDateTime());

			if (voGaitParent.getAuthoringHCP() != null)
			{
				form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().newRow(voGaitParent.getAuthoringHCP(), voGaitParent.getAuthoringHCP().toString());
				form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().setValue(voGaitParent.getAuthoringHCP());				
			}

		}
	}
	private GaitVo getParentFromDomain(GaitShortVo voGaitShort)
	{
		return domain.getGait(voGaitShort.getClinicalContact());
	}
	private void updateContextMenusState()
	{
		
		boolean bByClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull();
		
		if(form.getLocalContext().getGoldenInstanceSelected().booleanValue())
		{
			// If the golden instance is currently selected we change the text of the update context menu
			// based on whether a parent or child node is selected in the grid.
			if (form.grdGait().getValue() instanceof GaitShortVo)
				form.getContextMenus().getGenericGridUpdateItem().setVisible(false);						
			else if (form.grdGait().getValue() instanceof GaitTreatmentVo)
				form.getContextMenus().getGenericGridUpdateItem().setText("Edit gait Treatment");
			
			// If the golden node is selected we can now only add child nodes so set the menu text accordingly.
			form.getContextMenus().getGenericGridAddItem().setText("Add Gait Treatment");			

			form.getContextMenus().getGenericGridUpdateItem().setVisible((form.getMode().equals(FormMode.VIEW)&& 
																		 form.grdGait().getSelectedRowIndex()>=0) &&
																		 form.grdGait().getValue() instanceof GaitTreatmentVo ||
																		 (form.getMode().equals(FormMode.EDIT) &&
																		 form.grdGait().getValue() instanceof GaitTreatmentVo &&
																		 ((GaitTreatmentVo)form.grdGait().getValue()).getID_GaitTreatment() == null));																								
		}
		else
		{
			// If the golden instance has been found but NOT selected hide the context menu's 
			if (form.getLocalContext().getGoldenInstanceFound().booleanValue() == true)
			{
				form.getContextMenus().hideAllGenericGridMenuItems();
				return;
			}
			else
			{
				form.getContextMenus().getGenericGridAddItem().setText("New Gait");
				form.getContextMenus().getGenericGridUpdateItem().setVisible(false);				
			}
		}
		
		form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW)
																&& bByClinicalContact);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(form.getMode().equals(FormMode.EDIT) &&
				bByClinicalContact &&  
				form.grdGait().getValue() instanceof GaitTreatmentVo &&
				 ((GaitTreatmentVo)form.grdGait().getValue()).getID_GaitTreatment() == null);
		
	}
	private void populateParentNodes(GaitShortVoCollection voCollGaitParents)
	{
		if (voCollGaitParents == null || voCollGaitParents.size() <= 0 ) return;
		
		for(int i=0; i<voCollGaitParents.size(); i++)
		{
			populateParentNode(voCollGaitParents.get(i));			
		}
	}
	private void populateParentNode(GaitShortVo voGaitParent)
	{
		GenForm.grdGaitRow parRow = form.grdGait().getRows().newRow();
		parRow.setColEnvironment(voGaitParent.getAuthoringDateTime().toString()+ " - " + voGaitParent.getAuthoringHCP().toString());
		
		parRow.setValue(voGaitParent);			
					
		if (form.getGlobalContext().Core.getCurrentClinicalContact() != null &&		
			voGaitParent.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			form.grdGait().setValue(voGaitParent);			
		}
		
		expandParentNode(parRow);		
	}
	private void expandParentNode(grdGaitRow selectedRow)
	{
		if (selectedRow.getValue() instanceof GaitShortVo == false ) return;
		
		form.getLocalContext().setSelectedParentInstance(getParentFromDomain((GaitShortVo) selectedRow.getValue()));		
		if (form.getLocalContext().getSelectedParentInstance() == null ) return; 				

		GaitVo voParentInstance = form.getLocalContext().getSelectedParentInstance();				
		
		if (form.getGlobalContext().Core.getCurrentClinicalContact() != null  &&
				voParentInstance.getClinicalContact().getID_ClinicalContact().equals
				(form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact()))
		{
			// If this is the Golden Node then we'll colour it golden (ok then beige).
			form.getLocalContext().setGoldenInstanceFound(new Boolean(true));
			form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
			selectedRow.setBackColor(Color.Beige);			
		}
		
		if (voParentInstance.getGaitTreatment() != null)  
		{
			selectedRow.setExpanded(true);
			populateChildNodes(selectedRow, voParentInstance.getGaitTreatment());
		}
		
		populateParentInstanceControls(voParentInstance);
	}
	private void populateChildNodes(grdGaitRow parRow, GaitTreatmentVoCollection voGaitTreatColl)
	{
		if (voGaitTreatColl == null || voGaitTreatColl.size()<=0) return;		
		
		voGaitTreatColl.sort();
		for(int i=0; i<voGaitTreatColl.size(); i++)
		{
			if (parRow != null)
			{
				GenForm.grdGaitRow childRow = parRow.getRows().newRow();
				populateChildNode(childRow, voGaitTreatColl.get(i));				
			}
		}
	}
	private void populateChildNode(grdGaitRow childRow, GaitTreatmentVo voGaitTreat)
	{
		if (voGaitTreat == null) return;		
		
		if(voGaitTreat.getEnvironment() != null)
			childRow.setColEnvironment(voGaitTreat.getEnvironment().toString());
		if(voGaitTreat.getGaitTechnique() != null)
			childRow.setColTechnique(voGaitTreat.getGaitTechnique().toString());
		if(voGaitTreat.getOrthosis() != null)
			childRow.setColOrthosis(voGaitTreat.getOrthosis().toString());
		if(voGaitTreat.getSupervisionLevel() != null)
			childRow.setColSupervision(voGaitTreat.getSupervisionLevel().toString());
		if(voGaitTreat.getGaitSummary() != null)
			childRow.setColSummary(voGaitTreat.getGaitSummary());
		childRow.setValue(voGaitTreat);
	
		//if not saved then set the colour
		if(voGaitTreat.getID_GaitTreatment() == null)
			childRow.setTextColor(Color.Red);
	}
	private void resetContextVariables()
	{
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(false));
		form.getLocalContext().setGoldenInstanceFound(new Boolean(false));
		form.getLocalContext().setUpdatingParent(new Boolean(false));
		form.getLocalContext().setSelectedParentInstance(null);
		form.getLocalContext().setSelectedChildInstance(null);
	}
	private void clear()
	{
		form.grdGait().getRows().clear();		
		clearChildInstanceControls();
	}
	private void clearChildInstanceControls()
	{
		form.ctnGait().lyrGait().tabDetail().cmbEnvironment().setValue(null);
		form.ctnGait().lyrGait().tabDetail().cmboGaitTech().setValue(null);
		form.ctnGait().lyrGait().tabDetail().cmbOrthosis().setValue(null);
		form.ctnGait().lyrGait().tabDetail().cmbSupervision().setValue(null);
		form.ctnGait().lyrGait().tabDetail().txtGaitPractice().setValue(null);
		form.ctnGait().lyrGait().tabDetail().txtStairPractice().setValue(null);
		form.ctnGait().lyrGait().tabDetail().txtSummary().setValue(null);
		form.ctnGait().lyrGait().tabDetail().intWalkTest().setValue(null);
	}
	private void initialize() throws PresentationLogicException
	{
		form.ctnGait().setCollapsed(true);
		form.ctnGait().lyrGait().tabEmpty().setHeaderVisible(false);
		checkEnvironmentLookup();
	}
	private void checkEnvironmentLookup() throws PresentationLogicException
	{
		GaitTestEnvironmentCollection environmentColl = LookupHelper.getGaitTestEnvironment(domain.getLookupService());
		if(environmentColl == null || environmentColl.size() == 0)
			throw new PresentationLogicException("Please configure GaitTestEnvironment lookup");
	}
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	protected void onQmbAuthoringHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		setAuthoringCP(value);	
	}
	private void setAuthoringCP(String value)
	{
		form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().newRow(med, med.toString());			
		}
		
		if (coll.size() == 1)
			form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().setValue(coll.get(0));
		else if (coll.size() > 1)
			form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().showOpened();
	}
	protected void onBOkDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addOrUpdateChild();
	}
	private boolean addOrUpdateChild()
	{
		if (form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))			
			newParentNode(form.getLocalContext().getSelectedParentInstance());			
				
		GaitTreatmentVo voGaitTreatment = form.getLocalContext().getSelectedChildInstance();
		
		if (voGaitTreatment == null)
			voGaitTreatment = new GaitTreatmentVo(); 

		populateChildInstanceData(voGaitTreatment);

		if (form.grdGait().getValue() instanceof GaitTreatmentVo)
		{
			promoteUpdatedChild(voGaitTreatment);
			newChildInstance();
			updateControlsState();
		}
		else
		{
			if(newChildNode(voGaitTreatment))
				return true;
		}
		return false;
	}
	private boolean newChildNode(GaitTreatmentVo voGaitTreatment)
	{
		if (form.getLocalContext().getSelectedChildInstance() != null) return false;
		
		if (voGaitTreatment.countFieldsWithValue() >= 1)
		{
			String strErrors[] = voGaitTreatment.validate();
		
			if(strErrors != null && strErrors.length > 0)
			{
				engine.showErrors(strErrors);
				return true;
			}
	 				
			promoteChild(voGaitTreatment);			
			clearChildInstanceControls();
		}
		return false;
	}
	private void promoteChild(GaitTreatmentVo voGaitTreatment)
	{
		if (voGaitTreatment == null) return;
		GenForm.grdGaitRow childRow = form.grdGait().getSelectedRow().getRows().newRow();		
		populateChildNode(childRow, voGaitTreatment);
	}
	private void newChildInstance()
	{
		clearChildInstanceControls();
		form.getLocalContext().setSelectedChildInstance(null);
				
		if (form.grdGait().getSelectedRow() == null) 
			throw new CodingRuntimeException("No Row Selected");
		
		if (form.grdGait().getSelectedRow().getValue() != null && form.grdGait().getSelectedRow().getValue() instanceof GaitTreatmentVo && form.grdGait().getSelectedRow().getParentRow() != null && form.grdGait().getSelectedRow().getParentRow().getValue() != null)
			form.grdGait().setValue(form.grdGait().getSelectedRow().getParentRow().getValue());					
	}
	private void promoteUpdatedChild(GaitTreatmentVo voGaitTreatment)
	{
		if (voGaitTreatment == null) return;
		populateChildNode(form.grdGait().getSelectedRow(),voGaitTreatment);	
	}
	private void populateChildInstanceData(GaitTreatmentVo voGaitTreatment)
	{
		voGaitTreatment.setEnvironment(form.ctnGait().lyrGait().tabDetail().cmbEnvironment().getValue());
		voGaitTreatment.setGaitPractice(form.ctnGait().lyrGait().tabDetail().txtGaitPractice().getValue());
		voGaitTreatment.setGaitSummary(form.ctnGait().lyrGait().tabDetail().txtSummary().getValue());
		voGaitTreatment.setGaitTechnique(form.ctnGait().lyrGait().tabDetail().cmboGaitTech().getValue());
		voGaitTreatment.setOrthosis(form.ctnGait().lyrGait().tabDetail().cmbOrthosis().getValue());
		voGaitTreatment.setStairPractice(form.ctnGait().lyrGait().tabDetail().txtStairPractice().getValue());
		voGaitTreatment.setSupervisionLevel(form.ctnGait().lyrGait().tabDetail().cmbSupervision().getValue());
		voGaitTreatment.setWalkTestTime(form.ctnGait().lyrGait().tabDetail().intWalkTest().getValue());
	}
	private void newParentNode(GaitVo voNewParent)
	{
		if (voNewParent == null) return;
		
		GaitShortVo voParentShort = new GaitShortVo();
		voParentShort.setAuthoringHCP(voNewParent.getAuthoringHCP());
		voParentShort.setAuthoringDateTime(voNewParent.getAuthoringDateTime());
		voParentShort.setClinicalContact((ClinicalContactShortVo) voNewParent.getClinicalContact());
		
		GenForm.grdGaitRow parentRow = form.grdGait().getRows().newRow();			
		if(voParentShort.getAuthoringHCPIsNotNull() && voParentShort.getAuthoringDateTimeIsNotNull())
			parentRow.setColEnvironment(voParentShort.getAuthoringDateTime().toString()+ " - " + voParentShort.getAuthoringHCP().toString());			
		parentRow.setValue(voParentShort);
		parentRow.setBackColor(Color.Beige);
		form.getLocalContext().setGoldenInstanceSelected(new Boolean(true));
		parentRow.setExpanded(true);
		form.grdGait().setValue(voParentShort);	
	}
	protected void onBClearDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearChildInstanceControls();
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();	
	}
	private boolean save()
	{
		if(checkForUnsavedChild())
			return false;
		
		GaitVo voGait  = populateInstanceData(form.getLocalContext().getSelectedParentInstance());
		
		if(voGait.getID_Gait() == null)
		{
			//check for another gait for this clinical contact
			GaitVo oldGait = domain.getGait(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			if(oldGait != null)
			{
				engine.showMessage("A record exists for this clinical contact, the screen will be refreshed.");
				open();
				return false;
			}
		}
		
		if (voGait.getClinicalContact() == null)
			voGait.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		String[] arrErrors =  voGait.validate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedParentInstance(domain.save(voGait));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A Gait record already exists for this SOAP clinical contact. " + e.getMessage());
			open();
			return false;
		}
		
		setUpdatedChild();
		return true;		
	}
	private void setUpdatedChild()
	{
		// Straight child update - Select the currently being updated child as the one so show - post save
		if (form.grdGait().getValue() instanceof GaitTreatmentVo)		
		{
			form.getLocalContext().setUpdatedChild((GaitTreatmentVo) form.grdGait().getValue());
		}
		else
		{
			// Find the most recently added child
			if (form.getLocalContext().getUpdatingParent().equals(Boolean.FALSE))
			{
				if (form.getLocalContext().getSelectedParentInstance() != null && form.getLocalContext().getSelectedParentInstance().getGaitTreatment() != null)
				{
					form.getLocalContext().getSelectedParentInstance().getGaitTreatment().sort();
					if (form.getLocalContext().getSelectedParentInstance().getGaitTreatment().size() > 0)
					{
						form.getLocalContext().setUpdatedChild(
								form.getLocalContext().getSelectedParentInstance().getGaitTreatment().get(
										form.getLocalContext().getSelectedParentInstance().getGaitTreatment().size() - 1));
								
					}
					
				}
			}
			
		}
	}
	private String[] validateUIRules()
	{
		return null;
	}
	private GaitVo populateInstanceData(GaitVo voGait)
	{
		if (voGait == null)
			voGait = new GaitVo();
				
		populateParentInstanceData(voGait);						

		if (form.getLocalContext().getSelectedChildInstance() == null)
		{
			populateChildCollectionFromGrid(voGait);			
		}
		else 		// Update child instance.
		{
			GaitTreatmentVo voGaitTreat = form.getLocalContext().getSelectedChildInstance();
			populateChildInstanceData(voGaitTreat);
			form.getLocalContext().setSelectedChildInstance(voGaitTreat);
			
			for (int i=0; i < voGait.getGaitTreatment().size(); i++)
			{
				if (voGait.getGaitTreatment().get(i).getID_GaitTreatment().equals(form.getLocalContext().getSelectedChildInstance().getID_GaitTreatment()))
				{						
					voGait.getGaitTreatment().set(i, form.getLocalContext().getSelectedChildInstance());
				}
			}								
		}
		return voGait;	
	}
	private void populateChildCollectionFromGrid(GaitVo voGait)
	{
		if (form.grdGait().getValue() == null) return;

		if (voGait.getGaitTreatment() == null)
			voGait.setGaitTreatment(new GaitTreatmentVoCollection());
		
		GenForm.grdGaitRow parentRow = form.grdGait().getValue() instanceof GaitShortVo ? 
										    form.grdGait().getSelectedRow() : form.grdGait().getSelectedRow().getParentRow();		
		
        if (parentRow.getRows().size() > 0 )
        	voGait.getGaitTreatment().clear();
										    
		for (int i=0; i < parentRow.getRows().size(); i++)
        {
			voGait.getGaitTreatment().add((GaitTreatmentVo) parentRow.getRows().get(i).getValue());
        }
	}
	private void populateParentInstanceData(GaitVo voGait)
	{
		voGait.setAuthoringHCP(form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().getValue());
		voGait.setAuthoringDateTime(form.ctnGait().lyrGait().tabHeader().dtimAuthoring().getValue());
	}
	private boolean checkForUnsavedChild()
	{
		if (form.getLocalContext().getSelectedChildInstance() == null)
		{				
			if(addOrUpdateChild())
				return true;
		}
		return false;
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	private void newInstance()
	{
		// New instance has been invoked for a parent instance with no current selection made OR
		// with a parent that is not the Golden node..
		if (form.grdGait().getValue() == null || ((form.getLocalContext().getSelectedParentInstanceIsNotNull() 
				&& form.getLocalContext().getGoldenInstanceSelected().equals(Boolean.FALSE))))
		{
			newParentInstance();			
			form.setMode(FormMode.EDIT);		
		}
		else
		{
			newChildInstance();
			form.setMode(FormMode.EDIT);		
			disableHeaderInfo();
		}
	}
	private void newParentInstance()
	{
		GaitVo voNewParent = new GaitVo(); 	
		voNewParent.setAuthoringHCP((Hcp) domain.getHcpUser());
		voNewParent.setAuthoringDateTime(new DateTime());
		voNewParent.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNewParent.setGaitTreatment(new GaitTreatmentVoCollection());
		populateParentInstanceControls(voNewParent);		
		form.getLocalContext().setSelectedParentInstance(voNewParent);	
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeChild();
		}
	}
	private void removeChild()
	{
		GaitShortVo voParent = (GaitShortVo) form.grdGait().getSelectedRow().getParentRow().getValue();
		form.grdGait().removeSelectedRow();
		form.grdGait().setValue(voParent);
		updateContextMenusState();
	}
	private void updateInstance()
	{
		form.getLocalContext().setUpdatingParent(new Boolean(form.grdGait().getValue() instanceof GaitShortVo));
		
		if (form.grdGait().getValue() instanceof GaitTreatmentVo)			
		{
			GaitTreatmentVo voCachedChild = (GaitTreatmentVo) form.grdGait().getValue(); 
			if ( voCachedChild.getID_GaitTreatment() == null)
			{
				populateChildInstanceControls(voCachedChild);
			}
			form.getLocalContext().setSelectedChildInstance(voCachedChild);			
		}

		form.setMode(FormMode.EDIT);
		disableHeaderInfo();
	}
	private void disableHeaderInfo() 
	{
		form.ctnGait().lyrGait().tabHeader().dtimAuthoring().setEnabled(false);
		form.ctnGait().lyrGait().tabHeader().qmbAuthoringHCP().setEnabled(false);
	}
	protected void onGrdGaitSelectionChanged() throws PresentationLogicException
	{
		getSelectedInstance();
	}
}
