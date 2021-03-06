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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.eas.vo.beans;

public class ElectronicActionSheetVoBean extends ims.vo.ValueObjectBean
{
	public ElectronicActionSheetVoBean()
	{
	}
	public ElectronicActionSheetVoBean(ims.eas.vo.ElectronicActionSheetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.easstatus = vo.getEasStatus() == null ? null : (ims.eas.vo.beans.EASStatusRecordVoBean)vo.getEasStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.recordinginfo = vo.getRecordingInfo() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInfo().getBean();
		this.authorisedby = vo.getAuthorisedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthorisedBy().getBean();
		this.authoriseddatetime = vo.getAuthorisedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthorisedDateTime().getBean();
		this.responsiblehcp = vo.getResponsibleHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHcp().getBean();
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getSeenBy().getBean();
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.eas.vo.beans.PrimaryTumourInsVoBean)vo.getPrimaryTumour().getBean();
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.eas.vo.beans.TreatmentSiteInsVoBean)vo.getTreatmentSite().getBean();
		this.firsttherapeuticintervention = vo.getFirstTherapeuticIntervention();
		this.clinicaltrialpatient = vo.getClinicalTrialPatient();
		this.protocolused = vo.getProtocolUsed();
		this.patientconsent = vo.getPatientConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientConsent().getBean();
		this.planconssession = vo.getPlanConsSession() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanConsSession().getBean();
		this.appropcccl = vo.getAppropCCCL() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppropCCCL().getBean();
		this.imagetransfer = vo.getImageTransfer() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTransfer().getBean();
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
		this.concurrentsystemictreatment = vo.getConcurrentSystemicTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentSystemicTreatment().getBean();
		this.seenat = vo.getSeenAt() == null ? null : (ims.vo.LookupInstanceBean)vo.getSeenAt().getBean();
		this.intent = vo.getIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntent().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.delayed = vo.getDelayed();
		this.delayedcomment = vo.getDelayedComment();
		this.readytotreatdate = vo.getReadyToTreatDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getReadyToTreatDate().getBean();
		this.delayedreason = vo.getDelayedReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayedReason().getBean();
		this.treatsitelaterality = vo.getTreatSiteLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatSiteLaterality().getBean();
		this.anatomicalsite = vo.getAnatomicalSite();
		this.clinicaltrial = vo.getClinicalTrial() == null ? null : (ims.vo.LookupInstanceBean)vo.getClinicalTrial().getBean();
		this.protocol = vo.getProtocol() == null ? null : (ims.eas.vo.beans.ProtocolLiteInsVoBean)vo.getProtocol().getBean();
		this.offprotocolreason = vo.getOffProtocolReason();
		this.eascomment = vo.getEasComment();
		this.imagetransfers = vo.getImageTransfers() == null ? null : vo.getImageTransfers().getBeanCollection();
		this.planningct = vo.getPlanningCT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanningCT().getBean();
		this.planningcttext = vo.getPlanningCTText();
		this.mriforcoreg = vo.getMRIforCoReg() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRIforCoReg().getBean();
		this.dentistrequired = vo.getDentistRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getDentistRequired().getBean();
		this.pegrequired = vo.getPegRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getPegRequired().getBean();
		this.simulationrequired = vo.getSimulationRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getSimulationRequired().getBean();
		this.ivcontrast = vo.getIVContrast() == null ? null : (ims.vo.LookupInstanceBean)vo.getIVContrast().getBean();
		this.investigationdate = vo.getInvestigationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInvestigationDate().getBean();
		this.creatininelevel = vo.getCreatinineLevel();
		this.oralcontrast = vo.getOralContrast() == null ? null : vo.getOralContrast().getBeanCollection();
		this.gatingoptions = vo.getGatingOptions() == null ? null : (ims.vo.LookupInstanceBean)vo.getGatingOptions().getBean();
		this.imrt = vo.getIMRT() == null ? null : (ims.vo.LookupInstanceBean)vo.getIMRT().getBean();
		this.petct = vo.getPetCT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPetCT().getBean();
		this.immobtype = vo.getImmobType() == null ? null : (ims.vo.LookupInstanceBean)vo.getImmobType().getBean();
		this.mouldroomactivity = vo.getMouldRoomActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getMouldRoomActivity().getBean();
		this.agent = vo.getAgent() == null ? null : (ims.vo.LookupInstanceBean)vo.getAgent().getBean();
		this.planningapptdate = vo.getPlanningApptDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPlanningApptDate().getBean();
		this.planningtransport = vo.getPlanningTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanningTransport().getBean();
		this.treatmenttransport = vo.getTreatmentTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentTransport().getBean();
		this.ip_op_planning = vo.getIP_OP_Planning() == null ? null : (ims.vo.LookupInstanceBean)vo.getIP_OP_Planning().getBean();
		this.ip_op_treatment = vo.getIP_OP_Treatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getIP_OP_Treatment().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.generateddocument = vo.getGeneratedDocument() == null ? null : (ims.core.vo.beans.ServerDocumentVoBean)vo.getGeneratedDocument().getBean();
		this.annotation = vo.getAnnotation() == null ? null : vo.getAnnotation().getBeanCollection();
		this.graphicassessment = vo.getGraphicAssessment() == null ? null : new ims.vo.RefVoBean(vo.getGraphicAssessment().getBoId(), vo.getGraphicAssessment().getBoVersion());
		this.recentcreatinine = vo.getRecentCreatinine();
		this.planningctrequired = vo.getPlanningCTRequired();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.ElectronicActionSheetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.easstatus = vo.getEasStatus() == null ? null : (ims.eas.vo.beans.EASStatusRecordVoBean)vo.getEasStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.recordinginfo = vo.getRecordingInfo() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInfo().getBean(map);
		this.authorisedby = vo.getAuthorisedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthorisedBy().getBean(map);
		this.authoriseddatetime = vo.getAuthorisedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthorisedDateTime().getBean();
		this.responsiblehcp = vo.getResponsibleHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHcp().getBean(map);
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getSeenBy().getBean(map);
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.eas.vo.beans.PrimaryTumourInsVoBean)vo.getPrimaryTumour().getBean(map);
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.eas.vo.beans.TreatmentSiteInsVoBean)vo.getTreatmentSite().getBean(map);
		this.firsttherapeuticintervention = vo.getFirstTherapeuticIntervention();
		this.clinicaltrialpatient = vo.getClinicalTrialPatient();
		this.protocolused = vo.getProtocolUsed();
		this.patientconsent = vo.getPatientConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientConsent().getBean();
		this.planconssession = vo.getPlanConsSession() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanConsSession().getBean();
		this.appropcccl = vo.getAppropCCCL() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppropCCCL().getBean();
		this.imagetransfer = vo.getImageTransfer() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTransfer().getBean();
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
		this.concurrentsystemictreatment = vo.getConcurrentSystemicTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentSystemicTreatment().getBean();
		this.seenat = vo.getSeenAt() == null ? null : (ims.vo.LookupInstanceBean)vo.getSeenAt().getBean();
		this.intent = vo.getIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntent().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.delayed = vo.getDelayed();
		this.delayedcomment = vo.getDelayedComment();
		this.readytotreatdate = vo.getReadyToTreatDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getReadyToTreatDate().getBean();
		this.delayedreason = vo.getDelayedReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayedReason().getBean();
		this.treatsitelaterality = vo.getTreatSiteLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatSiteLaterality().getBean();
		this.anatomicalsite = vo.getAnatomicalSite();
		this.clinicaltrial = vo.getClinicalTrial() == null ? null : (ims.vo.LookupInstanceBean)vo.getClinicalTrial().getBean();
		this.protocol = vo.getProtocol() == null ? null : (ims.eas.vo.beans.ProtocolLiteInsVoBean)vo.getProtocol().getBean(map);
		this.offprotocolreason = vo.getOffProtocolReason();
		this.eascomment = vo.getEasComment();
		this.imagetransfers = vo.getImageTransfers() == null ? null : vo.getImageTransfers().getBeanCollection();
		this.planningct = vo.getPlanningCT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanningCT().getBean();
		this.planningcttext = vo.getPlanningCTText();
		this.mriforcoreg = vo.getMRIforCoReg() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRIforCoReg().getBean();
		this.dentistrequired = vo.getDentistRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getDentistRequired().getBean();
		this.pegrequired = vo.getPegRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getPegRequired().getBean();
		this.simulationrequired = vo.getSimulationRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getSimulationRequired().getBean();
		this.ivcontrast = vo.getIVContrast() == null ? null : (ims.vo.LookupInstanceBean)vo.getIVContrast().getBean();
		this.investigationdate = vo.getInvestigationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInvestigationDate().getBean();
		this.creatininelevel = vo.getCreatinineLevel();
		this.oralcontrast = vo.getOralContrast() == null ? null : vo.getOralContrast().getBeanCollection();
		this.gatingoptions = vo.getGatingOptions() == null ? null : (ims.vo.LookupInstanceBean)vo.getGatingOptions().getBean();
		this.imrt = vo.getIMRT() == null ? null : (ims.vo.LookupInstanceBean)vo.getIMRT().getBean();
		this.petct = vo.getPetCT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPetCT().getBean();
		this.immobtype = vo.getImmobType() == null ? null : (ims.vo.LookupInstanceBean)vo.getImmobType().getBean();
		this.mouldroomactivity = vo.getMouldRoomActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getMouldRoomActivity().getBean();
		this.agent = vo.getAgent() == null ? null : (ims.vo.LookupInstanceBean)vo.getAgent().getBean();
		this.planningapptdate = vo.getPlanningApptDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPlanningApptDate().getBean();
		this.planningtransport = vo.getPlanningTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getPlanningTransport().getBean();
		this.treatmenttransport = vo.getTreatmentTransport() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentTransport().getBean();
		this.ip_op_planning = vo.getIP_OP_Planning() == null ? null : (ims.vo.LookupInstanceBean)vo.getIP_OP_Planning().getBean();
		this.ip_op_treatment = vo.getIP_OP_Treatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getIP_OP_Treatment().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.generateddocument = vo.getGeneratedDocument() == null ? null : (ims.core.vo.beans.ServerDocumentVoBean)vo.getGeneratedDocument().getBean(map);
		this.annotation = vo.getAnnotation() == null ? null : vo.getAnnotation().getBeanCollection();
		this.graphicassessment = vo.getGraphicAssessment() == null ? null : new ims.vo.RefVoBean(vo.getGraphicAssessment().getBoId(), vo.getGraphicAssessment().getBoVersion());
		this.recentcreatinine = vo.getRecentCreatinine();
		this.planningctrequired = vo.getPlanningCTRequired();
	}

	public ims.eas.vo.ElectronicActionSheetVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.ElectronicActionSheetVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.ElectronicActionSheetVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.ElectronicActionSheetVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.ElectronicActionSheetVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.eas.vo.beans.EASStatusRecordVoBean getEasStatus()
	{
		return this.easstatus;
	}
	public void setEasStatus(ims.eas.vo.beans.EASStatusRecordVoBean value)
	{
		this.easstatus = value;
	}
	public ims.eas.vo.beans.EASStatusRecordVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.eas.vo.beans.EASStatusRecordVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getRecordingInfo()
	{
		return this.recordinginfo;
	}
	public void setRecordingInfo(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.recordinginfo = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAuthorisedBy()
	{
		return this.authorisedby;
	}
	public void setAuthorisedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.authorisedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthorisedDateTime()
	{
		return this.authoriseddatetime;
	}
	public void setAuthorisedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoriseddatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHcp()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHcp(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public Boolean getTPCreated()
	{
		return this.tpcreated;
	}
	public void setTPCreated(Boolean value)
	{
		this.tpcreated = value;
	}
	public Boolean getActionRequired()
	{
		return this.actionrequired;
	}
	public void setActionRequired(Boolean value)
	{
		this.actionrequired = value;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.removedstat = value;
	}
	public ims.vo.LookupInstanceBean getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.vo.LookupInstanceBean value)
	{
		this.removalreason = value;
	}
	public ims.core.vo.beans.HcpBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpBean value)
	{
		this.seenby = value;
	}
	public ims.framework.utils.beans.DateBean getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.beans.DateBean value)
	{
		this.dateseen = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.eas.vo.beans.PrimaryTumourInsVoBean getPrimaryTumour()
	{
		return this.primarytumour;
	}
	public void setPrimaryTumour(ims.eas.vo.beans.PrimaryTumourInsVoBean value)
	{
		this.primarytumour = value;
	}
	public ims.eas.vo.beans.TreatmentSiteInsVoBean getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.eas.vo.beans.TreatmentSiteInsVoBean value)
	{
		this.treatmentsite = value;
	}
	public Boolean getFirstTherapeuticIntervention()
	{
		return this.firsttherapeuticintervention;
	}
	public void setFirstTherapeuticIntervention(Boolean value)
	{
		this.firsttherapeuticintervention = value;
	}
	public Boolean getClinicalTrialPatient()
	{
		return this.clinicaltrialpatient;
	}
	public void setClinicalTrialPatient(Boolean value)
	{
		this.clinicaltrialpatient = value;
	}
	public Boolean getProtocolUsed()
	{
		return this.protocolused;
	}
	public void setProtocolUsed(Boolean value)
	{
		this.protocolused = value;
	}
	public ims.vo.LookupInstanceBean getPatientConsent()
	{
		return this.patientconsent;
	}
	public void setPatientConsent(ims.vo.LookupInstanceBean value)
	{
		this.patientconsent = value;
	}
	public ims.vo.LookupInstanceBean getPlanConsSession()
	{
		return this.planconssession;
	}
	public void setPlanConsSession(ims.vo.LookupInstanceBean value)
	{
		this.planconssession = value;
	}
	public ims.vo.LookupInstanceBean getAppropCCCL()
	{
		return this.appropcccl;
	}
	public void setAppropCCCL(ims.vo.LookupInstanceBean value)
	{
		this.appropcccl = value;
	}
	public ims.vo.LookupInstanceBean getImageTransfer()
	{
		return this.imagetransfer;
	}
	public void setImageTransfer(ims.vo.LookupInstanceBean value)
	{
		this.imagetransfer = value;
	}
	public ims.eas.vo.beans.EASPhaseVoBean[] getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.eas.vo.beans.EASPhaseVoBean[] value)
	{
		this.phases = value;
	}
	public ims.vo.LookupInstanceBean getConcurrentSystemicTreatment()
	{
		return this.concurrentsystemictreatment;
	}
	public void setConcurrentSystemicTreatment(ims.vo.LookupInstanceBean value)
	{
		this.concurrentsystemictreatment = value;
	}
	public ims.vo.LookupInstanceBean getSeenAt()
	{
		return this.seenat;
	}
	public void setSeenAt(ims.vo.LookupInstanceBean value)
	{
		this.seenat = value;
	}
	public ims.vo.LookupInstanceBean getIntent()
	{
		return this.intent;
	}
	public void setIntent(ims.vo.LookupInstanceBean value)
	{
		this.intent = value;
	}
	public ims.vo.LookupInstanceBean getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.vo.LookupInstanceBean value)
	{
		this.priority = value;
	}
	public Boolean getDelayed()
	{
		return this.delayed;
	}
	public void setDelayed(Boolean value)
	{
		this.delayed = value;
	}
	public String getDelayedComment()
	{
		return this.delayedcomment;
	}
	public void setDelayedComment(String value)
	{
		this.delayedcomment = value;
	}
	public ims.framework.utils.beans.PartialDateBean getReadyToTreatDate()
	{
		return this.readytotreatdate;
	}
	public void setReadyToTreatDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.readytotreatdate = value;
	}
	public ims.vo.LookupInstanceBean getDelayedReason()
	{
		return this.delayedreason;
	}
	public void setDelayedReason(ims.vo.LookupInstanceBean value)
	{
		this.delayedreason = value;
	}
	public ims.vo.LookupInstanceBean getTreatSiteLaterality()
	{
		return this.treatsitelaterality;
	}
	public void setTreatSiteLaterality(ims.vo.LookupInstanceBean value)
	{
		this.treatsitelaterality = value;
	}
	public String getAnatomicalSite()
	{
		return this.anatomicalsite;
	}
	public void setAnatomicalSite(String value)
	{
		this.anatomicalsite = value;
	}
	public ims.vo.LookupInstanceBean getClinicalTrial()
	{
		return this.clinicaltrial;
	}
	public void setClinicalTrial(ims.vo.LookupInstanceBean value)
	{
		this.clinicaltrial = value;
	}
	public ims.eas.vo.beans.ProtocolLiteInsVoBean getProtocol()
	{
		return this.protocol;
	}
	public void setProtocol(ims.eas.vo.beans.ProtocolLiteInsVoBean value)
	{
		this.protocol = value;
	}
	public String getOffProtocolReason()
	{
		return this.offprotocolreason;
	}
	public void setOffProtocolReason(String value)
	{
		this.offprotocolreason = value;
	}
	public String getEasComment()
	{
		return this.eascomment;
	}
	public void setEasComment(String value)
	{
		this.eascomment = value;
	}
	public ims.eas.vo.beans.EASImageTransferVoBean[] getImageTransfers()
	{
		return this.imagetransfers;
	}
	public void setImageTransfers(ims.eas.vo.beans.EASImageTransferVoBean[] value)
	{
		this.imagetransfers = value;
	}
	public ims.vo.LookupInstanceBean getPlanningCT()
	{
		return this.planningct;
	}
	public void setPlanningCT(ims.vo.LookupInstanceBean value)
	{
		this.planningct = value;
	}
	public String getPlanningCTText()
	{
		return this.planningcttext;
	}
	public void setPlanningCTText(String value)
	{
		this.planningcttext = value;
	}
	public ims.vo.LookupInstanceBean getMRIforCoReg()
	{
		return this.mriforcoreg;
	}
	public void setMRIforCoReg(ims.vo.LookupInstanceBean value)
	{
		this.mriforcoreg = value;
	}
	public ims.vo.LookupInstanceBean getDentistRequired()
	{
		return this.dentistrequired;
	}
	public void setDentistRequired(ims.vo.LookupInstanceBean value)
	{
		this.dentistrequired = value;
	}
	public ims.vo.LookupInstanceBean getPegRequired()
	{
		return this.pegrequired;
	}
	public void setPegRequired(ims.vo.LookupInstanceBean value)
	{
		this.pegrequired = value;
	}
	public ims.vo.LookupInstanceBean getSimulationRequired()
	{
		return this.simulationrequired;
	}
	public void setSimulationRequired(ims.vo.LookupInstanceBean value)
	{
		this.simulationrequired = value;
	}
	public ims.vo.LookupInstanceBean getIVContrast()
	{
		return this.ivcontrast;
	}
	public void setIVContrast(ims.vo.LookupInstanceBean value)
	{
		this.ivcontrast = value;
	}
	public ims.framework.utils.beans.DateBean getInvestigationDate()
	{
		return this.investigationdate;
	}
	public void setInvestigationDate(ims.framework.utils.beans.DateBean value)
	{
		this.investigationdate = value;
	}
	public Float getCreatinineLevel()
	{
		return this.creatininelevel;
	}
	public void setCreatinineLevel(Float value)
	{
		this.creatininelevel = value;
	}
	public java.util.Collection getOralContrast()
	{
		return this.oralcontrast;
	}
	public void setOralContrast(java.util.Collection value)
	{
		this.oralcontrast = value;
	}
	public void addOralContrast(java.util.Collection value)
	{
		if(this.oralcontrast == null)
			this.oralcontrast = new java.util.ArrayList();
		this.oralcontrast.add(value);
	}
	public ims.vo.LookupInstanceBean getGatingOptions()
	{
		return this.gatingoptions;
	}
	public void setGatingOptions(ims.vo.LookupInstanceBean value)
	{
		this.gatingoptions = value;
	}
	public ims.vo.LookupInstanceBean getIMRT()
	{
		return this.imrt;
	}
	public void setIMRT(ims.vo.LookupInstanceBean value)
	{
		this.imrt = value;
	}
	public ims.vo.LookupInstanceBean getPetCT()
	{
		return this.petct;
	}
	public void setPetCT(ims.vo.LookupInstanceBean value)
	{
		this.petct = value;
	}
	public ims.vo.LookupInstanceBean getImmobType()
	{
		return this.immobtype;
	}
	public void setImmobType(ims.vo.LookupInstanceBean value)
	{
		this.immobtype = value;
	}
	public ims.vo.LookupInstanceBean getMouldRoomActivity()
	{
		return this.mouldroomactivity;
	}
	public void setMouldRoomActivity(ims.vo.LookupInstanceBean value)
	{
		this.mouldroomactivity = value;
	}
	public ims.vo.LookupInstanceBean getAgent()
	{
		return this.agent;
	}
	public void setAgent(ims.vo.LookupInstanceBean value)
	{
		this.agent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getPlanningApptDate()
	{
		return this.planningapptdate;
	}
	public void setPlanningApptDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.planningapptdate = value;
	}
	public ims.vo.LookupInstanceBean getPlanningTransport()
	{
		return this.planningtransport;
	}
	public void setPlanningTransport(ims.vo.LookupInstanceBean value)
	{
		this.planningtransport = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentTransport()
	{
		return this.treatmenttransport;
	}
	public void setTreatmentTransport(ims.vo.LookupInstanceBean value)
	{
		this.treatmenttransport = value;
	}
	public ims.vo.LookupInstanceBean getIP_OP_Planning()
	{
		return this.ip_op_planning;
	}
	public void setIP_OP_Planning(ims.vo.LookupInstanceBean value)
	{
		this.ip_op_planning = value;
	}
	public ims.vo.LookupInstanceBean getIP_OP_Treatment()
	{
		return this.ip_op_treatment;
	}
	public void setIP_OP_Treatment(ims.vo.LookupInstanceBean value)
	{
		this.ip_op_treatment = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public ims.core.vo.beans.ServerDocumentVoBean getGeneratedDocument()
	{
		return this.generateddocument;
	}
	public void setGeneratedDocument(ims.core.vo.beans.ServerDocumentVoBean value)
	{
		this.generateddocument = value;
	}
	public ims.eas.vo.beans.EASAnnotationVoBean[] getAnnotation()
	{
		return this.annotation;
	}
	public void setAnnotation(ims.eas.vo.beans.EASAnnotationVoBean[] value)
	{
		this.annotation = value;
	}
	public ims.vo.RefVoBean getGraphicAssessment()
	{
		return this.graphicassessment;
	}
	public void setGraphicAssessment(ims.vo.RefVoBean value)
	{
		this.graphicassessment = value;
	}
	public Boolean getRecentCreatinine()
	{
		return this.recentcreatinine;
	}
	public void setRecentCreatinine(Boolean value)
	{
		this.recentcreatinine = value;
	}
	public Boolean getPlanningCTRequired()
	{
		return this.planningctrequired;
	}
	public void setPlanningCTRequired(Boolean value)
	{
		this.planningctrequired = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.eas.vo.beans.EASStatusRecordVoBean easstatus;
	private ims.eas.vo.beans.EASStatusRecordVoBean[] statushistory;
	private ims.core.vo.beans.RecordingUserInformationVoBean recordinginfo;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean authorisedby;
	private ims.framework.utils.beans.DateTimeBean authoriseddatetime;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private Boolean tpcreated;
	private Boolean actionrequired;
	private Boolean removedstat;
	private ims.vo.LookupInstanceBean removalreason;
	private ims.core.vo.beans.HcpBean seenby;
	private ims.framework.utils.beans.DateBean dateseen;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.eas.vo.beans.PrimaryTumourInsVoBean primarytumour;
	private ims.eas.vo.beans.TreatmentSiteInsVoBean treatmentsite;
	private Boolean firsttherapeuticintervention;
	private Boolean clinicaltrialpatient;
	private Boolean protocolused;
	private ims.vo.LookupInstanceBean patientconsent;
	private ims.vo.LookupInstanceBean planconssession;
	private ims.vo.LookupInstanceBean appropcccl;
	private ims.vo.LookupInstanceBean imagetransfer;
	private ims.eas.vo.beans.EASPhaseVoBean[] phases;
	private ims.vo.LookupInstanceBean concurrentsystemictreatment;
	private ims.vo.LookupInstanceBean seenat;
	private ims.vo.LookupInstanceBean intent;
	private ims.vo.LookupInstanceBean priority;
	private Boolean delayed;
	private String delayedcomment;
	private ims.framework.utils.beans.PartialDateBean readytotreatdate;
	private ims.vo.LookupInstanceBean delayedreason;
	private ims.vo.LookupInstanceBean treatsitelaterality;
	private String anatomicalsite;
	private ims.vo.LookupInstanceBean clinicaltrial;
	private ims.eas.vo.beans.ProtocolLiteInsVoBean protocol;
	private String offprotocolreason;
	private String eascomment;
	private ims.eas.vo.beans.EASImageTransferVoBean[] imagetransfers;
	private ims.vo.LookupInstanceBean planningct;
	private String planningcttext;
	private ims.vo.LookupInstanceBean mriforcoreg;
	private ims.vo.LookupInstanceBean dentistrequired;
	private ims.vo.LookupInstanceBean pegrequired;
	private ims.vo.LookupInstanceBean simulationrequired;
	private ims.vo.LookupInstanceBean ivcontrast;
	private ims.framework.utils.beans.DateBean investigationdate;
	private Float creatininelevel;
	private java.util.Collection oralcontrast;
	private ims.vo.LookupInstanceBean gatingoptions;
	private ims.vo.LookupInstanceBean imrt;
	private ims.vo.LookupInstanceBean petct;
	private ims.vo.LookupInstanceBean immobtype;
	private ims.vo.LookupInstanceBean mouldroomactivity;
	private ims.vo.LookupInstanceBean agent;
	private ims.framework.utils.beans.DateTimeBean planningapptdate;
	private ims.vo.LookupInstanceBean planningtransport;
	private ims.vo.LookupInstanceBean treatmenttransport;
	private ims.vo.LookupInstanceBean ip_op_planning;
	private ims.vo.LookupInstanceBean ip_op_treatment;
	private ims.vo.LookupInstanceBean patientstatus;
	private ims.core.vo.beans.ServerDocumentVoBean generateddocument;
	private ims.eas.vo.beans.EASAnnotationVoBean[] annotation;
	private ims.vo.RefVoBean graphicassessment;
	private Boolean recentcreatinine;
	private Boolean planningctrequired;
}
