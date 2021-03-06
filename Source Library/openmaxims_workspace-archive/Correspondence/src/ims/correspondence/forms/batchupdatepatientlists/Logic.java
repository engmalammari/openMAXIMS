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
// This code was generated by Peter Martin using IMS Development Environment (version 1.62 build 3100.30141)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.batchupdatepatientlists;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.DischargedEpisodeVoCollection;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.InpatientEpisodeVoCollection;
import ims.core.vo.MedicWithMappingsLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.OutPatientAttendanceVo;
import ims.core.vo.OutPatientAttendanceVoCollection;
import ims.core.vo.OutPatientListSearchCriteriaVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.PatientListsFilterVo;
import ims.core.vo.lookups.DocumentStatus;
import ims.correspondence.vo.CorrespondencePatientListsVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}
	
	private void initialise() {
		PatientListsFilterVo voPatientListsFilter = form.getGlobalContext().Correspondence.getPatientListSearchCriteria();
		OutPatientListSearchCriteriaVo  voOutPatientList = form.getGlobalContext().Core.getOutPatientSearchCriteria();
		DocumentStatus newDocumentStatus = form.getGlobalContext().Correspondence.getPatientListsBatchUpdateType();
		if(newDocumentStatus == DocumentStatus.DICTATED)
			form.pnlBatchUpdate().setValue("Batch Update Of Status To 'Dictated'");
		else if(newDocumentStatus == DocumentStatus.NOLETTERREQUIRED)
			form.pnlBatchUpdate().setValue("Batch Update Of Status To 'No Letter Required'");
		else if(newDocumentStatus == DocumentStatus.SIGNED)
			form.pnlBatchUpdate().setValue("Batch Update Of Status To 'Signed'");

		if(voPatientListsFilter!=null)
			populateListControl(domain.listInPatients(voPatientListsFilter,(newDocumentStatus==DocumentStatus.DICTATED)));
		else if(voOutPatientList!=null)
			populateListControl(domain.listOutpatients(voOutPatientList, (newDocumentStatus==DocumentStatus.DICTATED)));
	}

	private void populateListControl(CorrespondencePatientListsVoCollection voCorrespondencePatientListsEpisColl)
	{
			if (voCorrespondencePatientListsEpisColl != null)
			{
				if (voCorrespondencePatientListsEpisColl.size() == 0)
				{
					engine.showMessage("No matching patients found.");
					return;
				}
				GenForm.grdPatientListRow row = null;
				for (int i = 0; i < voCorrespondencePatientListsEpisColl.size(); i++)
				{
					InpatientEpisodeVo voInpatient = voCorrespondencePatientListsEpisColl.get(i).getInpatientEpisodeVo();
					DischargedEpisodeVo voDischargedEpisode = voCorrespondencePatientListsEpisColl.get(i).getDischargeEpisodeVo();
					OutPatientAttendanceVo voOutpatientAttendance = voCorrespondencePatientListsEpisColl.get(i).getOutpatientAttendanceVo();
					PasEventVo voPasEvent  = null;
					if(voInpatient != null && voInpatient.getPasEventIsNotNull())
						voPasEvent = voInpatient.getPasEvent();
					else if(voDischargedEpisode != null && voDischargedEpisode.getPasEventIsNotNull())
						voPasEvent = voDischargedEpisode.getPasEvent();
					else if(voOutpatientAttendance != null && voOutpatientAttendance.getPasEventIsNotNull())
						voPasEvent = voOutpatientAttendance.getPasEvent();
					
					/*if(form.grdPatientList().getValue()==null && form.getLocalContext().getUserAccessVoIsNotNull()){
						boolean bIsUserAccessConsultant = false;
						UserAccessVo voUserAccess = form.getLocalContext().getUserAccessVo();
						ConsultantAccessVoCollection  collConsultantAccessVo = voUserAccess.getConsultantAccess();
						MedicLiteVo med = null;
						
						if (collConsultantAccessVo != null)
						{
							for (int j = 0; j < collConsultantAccessVo.size(); j++)
							{
								med = collConsultantAccessVo.get(j).getConsultant();
								if(med.getID_Hcp().equals(voInpatient.getPasEvent().getConsultant().getID_Hcp()))
									bIsUserAccessConsultant=true;
							}
						}
						if(!bIsUserAccessConsultant)
							continue;
					}*/
					if (voPasEvent.getPatientIsNotNull())
					{
						row = form.grdPatientList().getRows().newRow();
						
						if(voInpatient != null && voInpatient.getIsOnLeaveIsNotNull() && voInpatient.getIsOnLeave().equals(Boolean.TRUE))
						{
							row.setcolLeave(form.getImages().Core.Home);
							row.setTooltipForcolLeave("Patient is currently on Leave");
						}
						
						
						if (voPasEvent.getPatient().getNameIsNotNull())
						{
							if (voPasEvent.getPatient().getName().getForenameIsNotNull())
								row.setcolForename(voPasEvent.getPatient().getName().getForename());
							if (voPasEvent.getPatient().getName().getSurnameIsNotNull())
								row.setcolSurname(voPasEvent.getPatient().getName().getSurname());
						}
						voPasEvent.getPatient().calculateAge();
						if (voPasEvent.getPatient().getAgeIsNotNull())
							row.setColAge(voPasEvent.getPatient().getAge().toString());

						ims.core.vo.PatientId voPatId = voPasEvent.getPatient().getDisplayId();
						if (voPatId != null)
							row.setcolHospnum(voPatId.getValue());

						if (voPasEvent.getPatient().getDobIsNotNull())
							row.setcolDob(voPasEvent.getPatient().getDob().toString());

						if (voPasEvent.getPatient().getAgeIsNotNull())
							row.setColAge(voPasEvent.getPatient().getAge().toString());

						if (voPasEvent.getPatient().getSexIsNotNull())
							row.setcolSex(voPasEvent.getPatient().getSex().getText());

						if (voPasEvent.getLocationIsNotNull())
							row.setcolWard(voPasEvent.getLocation().getName());

						if (voPasEvent.getPatient().getIsDead() != null && voPasEvent.getPatient().getIsDead().booleanValue())
							row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());
						
						if (voPasEvent.getEventDateTime() != null)
							row.setcolAdmissionDate(voPasEvent.getEventDateTime().getDate().toString());
						
						if (voPasEvent.getConsultant() != null)
							row.setcolConsultant(voPasEvent.getConsultant().getName().toString());
							
						if(voPasEvent.getCspDocumentStatusIsNotNull()){
							row.setcolDocStatus(voPasEvent.getCspDocumentStatus().getImage());
							row.setTooltipForcolDocStatus(voPasEvent.getCspDocumentStatus().getText());
						}
												
						if(voInpatient != null)
							row.setValue(voInpatient);	
						else if(voDischargedEpisode != null){
							row.setcolDischarged(form.getImages().NTPF.Discharge);
							row.setTooltipForcolDischarged("Discharged");
							row.setValue(voDischargedEpisode);
						}
						else if(voOutpatientAttendance != null)
							row.setValue(voOutpatientAttendance);
					}
				}
			}
	}

	@Override
	protected void onBtnCancel() throws PresentationLogicException {
		engine.close(DialogResult.CANCEL);		
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException {
		
		InpatientEpisodeVoCollection collInpatientEpisodeVo = new InpatientEpisodeVoCollection ();
		DischargedEpisodeVoCollection collDischargedEpisodeVo = new DischargedEpisodeVoCollection ();
		OutPatientAttendanceVoCollection collOutPatientAttendanceVo = new OutPatientAttendanceVoCollection ();
		InpatientEpisodeVo voInpatientListRow = null;
		DischargedEpisodeVo voDischargedEpisode = null;
		OutPatientAttendanceVo voOutPatientAttendance = null;
		PasEventVo voPasEvent = null;
		
		for(int i=0; i< form.grdPatientList().getRows().size(); i++){
			if(form.grdPatientList().getRows().get(i).getcolSelect()){
				if(form.grdPatientList().getRows().get(i).getValue() instanceof InpatientEpisodeVo){
					voInpatientListRow = (InpatientEpisodeVo) form.grdPatientList().getRows().get(i).getValue();
					voPasEvent = voInpatientListRow.getPasEvent();
					DocumentStatus documentStatus = form.getGlobalContext().Correspondence.getPatientListsBatchUpdateType();
					voPasEvent.setCspDocumentStatus(documentStatus);
					voInpatientListRow.setPasEvent(voPasEvent);	
									
					String[] errors = voInpatientListRow.validate();
					if (errors != null)
					{
						engine.showErrors(errors);
						return;
					}
					
					collInpatientEpisodeVo.add(voInpatientListRow);
				}
				else if(form.grdPatientList().getRows().get(i).getValue() instanceof DischargedEpisodeVo){
					voDischargedEpisode = (DischargedEpisodeVo) form.grdPatientList().getRows().get(i).getValue();
					voPasEvent = voDischargedEpisode.getPasEvent();
					DocumentStatus documentStatus = form.getGlobalContext().Correspondence.getPatientListsBatchUpdateType();
					voPasEvent.setCspDocumentStatus(documentStatus);
					voDischargedEpisode.setPasEvent(voPasEvent);	
									
					String[] errors = voDischargedEpisode.validate();
					if (errors != null)
					{
						engine.showErrors(errors);
						return;
					}
					
					collDischargedEpisodeVo.add(voDischargedEpisode);
				}
				else if(form.grdPatientList().getRows().get(i).getValue() instanceof OutPatientAttendanceVo){
					voOutPatientAttendance = (OutPatientAttendanceVo) form.grdPatientList().getRows().get(i).getValue();
					voPasEvent = voOutPatientAttendance.getPasEvent();
					DocumentStatus documentStatus = form.getGlobalContext().Correspondence.getPatientListsBatchUpdateType();
					voPasEvent.setCspDocumentStatus(documentStatus);
					voOutPatientAttendance.setPasEvent(voPasEvent);	
									
					String[] errors = voOutPatientAttendance.validate();
					if (errors != null)
					{
						engine.showErrors(errors);
						return;
					}
					
					collOutPatientAttendanceVo.add(voOutPatientAttendance);
				}
			}
		}
		
		if(collInpatientEpisodeVo.size()==0 && collDischargedEpisodeVo.size()==0 && collOutPatientAttendanceVo.size()==0){
			engine.showMessage("Select at least 1 Episode to be updated.");
			return;
		}
		
		if(collInpatientEpisodeVo.size()>0){
			try {
				domain.saveInpatientEpisodes(collInpatientEpisodeVo, (MemberOfStaffShortVo) domain.getMosUser());
			} catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
		}
		if(collDischargedEpisodeVo.size()>0){
			try {
				domain.saveDischargeEpisodes(collDischargedEpisodeVo, (MemberOfStaffShortVo) domain.getMosUser());
			} catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
		}
		if(collOutPatientAttendanceVo.size()>0){
			try {
				domain.saveOutPatientEpisodes(collOutPatientAttendanceVo, (MemberOfStaffShortVo) domain.getMosUser());
			} catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
		}
		
		engine.close(DialogResult.OK);		
	}
}
