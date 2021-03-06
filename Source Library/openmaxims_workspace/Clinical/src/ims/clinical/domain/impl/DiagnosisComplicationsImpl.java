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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.44 build 2245.22719)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.helper.Keywords;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.AppUserVo;
import ims.admin.vo.domain.AppUserShortVoAssembler;
import ims.clinical.configuration.domain.objects.DiagnosisHotlistItem;
import ims.clinical.domain.ClinicalDiAssociations;
import ims.clinical.domain.PastMedicalHistory;
import ims.clinical.domain.PatientSummary;
import ims.clinical.domain.base.impl.BaseDiagnosisComplicationsImpl;
import ims.clinical.vo.ClinicalDIAssociationVoCollection;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.CareSpellRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.domain.objects.PatientNoDiagInfoForCC;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PatientDiagnosisListVoCollection;
import ims.core.vo.PatientDiagnosisShortVo;
import ims.core.vo.PatientDiagnosisShortVoCollection;
import ims.core.vo.PatientDiagnosisVo;
import ims.core.vo.PatientDiagnosisVoCollection;
import ims.core.vo.PatientNoDiagInfoForCCVo;
import ims.core.vo.PatientPastMedicalHistoryVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.DiagLiteVoAssembler;
import ims.core.vo.domain.PatientDiagnosisListVoAssembler;
import ims.core.vo.domain.PatientDiagnosisShortVoAssembler;
import ims.core.vo.domain.PatientDiagnosisVoAssembler;
import ims.core.vo.domain.PatientNoDiagInfoForCCVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.edischarge.domain.objects.DischargeDetails;
import ims.edischarge.domain.objects.RTLSummary;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisComplicationsImpl extends BaseDiagnosisComplicationsImpl
{
	private static final long serialVersionUID = 1L;

	public PatientDiagnosisVo saveDiagnosisVo(PatientDiagnosisVo voDiagnosis, PatientShort patientShortVo, Boolean savePMH, PatientNoDiagInfoForCCVo patientNoDiagInfo) throws StaleObjectException, UnqViolationUncheckedException, DomainInterfaceException, UniqueKeyViolationException
	{
		if (patientShortVo == null)
			throw new  DomainRuntimeException("Patient not provided.");
		
		// Ensure the value object has been validated
		if (!voDiagnosis.isValidated())
			throw new DomainRuntimeException("Diagnosis has not been validated");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatDiag = PatientDiagnosisVoAssembler.extractPatientDiagnosis(factory, voDiagnosis);
		
		factory.save(doPatDiag);
		
		//WDEV-18627
		if (patientNoDiagInfo != null)
		{
			PatientNoDiagInfoForCC patientNoDiagInfoDo = PatientNoDiagInfoForCCVoAssembler.extractPatientNoDiagInfoForCC(factory, patientNoDiagInfo);
			factory.save(patientNoDiagInfoDo);
		}

		//WDEV-19847
		if (voDiagnosis != null)
		{
			DischargeDetails ddDO = getDischargeDetails(voDiagnosis);
		
			RTLSummary rtlSummary = getRTLSummaryToUpdate(voDiagnosis.getCareContext());
					
			if (ddDO != null)
			{
				if (Boolean.TRUE.equals(voDiagnosis.getIsComplication()))
				{
					if (rtlSummary != null)
						rtlSummary.setWereComplicationsEntered(Boolean.TRUE);
					ddDO.setHasNoComplications(Boolean.FALSE);
				}	
				if (!Boolean.TRUE.equals(voDiagnosis.getIsComplication()) && !Boolean.TRUE.equals(voDiagnosis.getIsComorbidity()))
				{
					if (rtlSummary != null)
						rtlSummary.setWereDiagnosisDetailsEntered(Boolean.TRUE);
					ddDO.setHasNoDiagnosis(Boolean.FALSE);
				}
					
				factory.save(ddDO);
				
				if (rtlSummary != null)
				{
					factory.save(rtlSummary);
				}
			}			
		}
		voDiagnosis = PatientDiagnosisVoAssembler.create(doPatDiag);//Create here to avoid possible StaleObj in PMH save
		
		if(savePMH != null && savePMH.booleanValue())	
		{
			//Save a PMH Procedure record.
			PatientPastMedicalHistoryVo voPMH = new PatientPastMedicalHistoryVo();

			PastMedicalHistory implPMH = (PastMedicalHistory) getDomainImpl(PastMedicalHistoryImpl.class);
			voPMH = implPMH.getPastMedicalHistory(patientShortVo);
			
			if (voPMH == null)
				voPMH = new PatientPastMedicalHistoryVo();
			
			PatientDiagnosisVoCollection voDiagnosisColl = voPMH.getDiagnosis();
			if (voDiagnosisColl == null)
				voDiagnosisColl = new PatientDiagnosisVoCollection();
			
			voDiagnosisColl.add(voDiagnosis);
			voPMH.setDiagnosis(voDiagnosisColl);
			voPMH.setPatient(patientShortVo);
			String[] arrErrors = voPMH.validate();
			if( arrErrors != null)
			{
				throw new DomainInterfaceException("Error validating PatientPastMedicalHistoryVo" + arrErrors.toString());
			}
			
			implPMH.savePMH(voPMH);
		}
		
		return voDiagnosis;
	}
	//WDEV-19847
	private RTLSummary getRTLSummaryToUpdate(CareContextLiteVo careContext)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
			return null;
		List<?> results  = getDomainFactory().find("select rtl from RTLSummary as rtl where rtl.careContext.id = :CC_ID", new String[]{"CC_ID"}, new Object[]{careContext.getID_CareContext()});
		
		if (results == null || results.isEmpty())
			return null;
		
		return (RTLSummary) results.get(0);
				
	}
	//WDEV-19847
	private DischargeDetails getDischargeDetails(PatientDiagnosisVo voDiagnosis)
	{
		if (voDiagnosis == null || voDiagnosis.getCareContext() == null || voDiagnosis.getCareContext().getEpisodeOfCare() == null)
			return null;
		
		StringBuilder hql = new StringBuilder();
		ArrayList<String> marques  = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		DomainFactory domainFactory = getDomainFactory();
		
 		hql.append("select dd from DischargeDetails as dd left join dd.careContext as ccontext left join ccontext.episodeOfCare as epis where dd.dischargeLetterStatus.id = :LETTER_STATUS and epis.id = :EPISODE_ID");
		
 		marques.add("LETTER_STATUS");
 		marques.add("EPISODE_ID");
 		 		
 		values.add(DischargeLetterStatus.IN_PROGRESS.getID());
 		values.add(voDiagnosis.getCareContext().getEpisodeOfCare().getID_EpisodeOfCare());
 		
 		List<?> ddList = domainFactory.find(hql.toString(),marques,values);
 		
 		if (ddList == null || ddList.isEmpty())
 			return null;
				
		return (DischargeDetails) ddList.get(0);
	}
	public PatientDiagnosisVo getDiagnosisVo(PatientDiagnosisRefVo patdiagrefVo)
	{
		if(patdiagrefVo == null)
			throw new DomainRuntimeException("Cannot get PatientDiagnosisVo for null PatientDiagnosisRefVo");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatientDiagnosis = (PatientDiagnosis)factory.getDomainObject(PatientDiagnosis.class,patdiagrefVo.getID_PatientDiagnosis());
		return PatientDiagnosisVoAssembler.create(doPatientDiagnosis);
	}
	
	public PatientDiagnosisShortVo getDiagnosisShortVo(PatientDiagnosisRefVo patientDiagnosisRefVo)
	{
		if(patientDiagnosisRefVo == null)
			throw new DomainRuntimeException("Cannot get PatientDiagnosisShortVo for null PatientDiagnosisRefVo");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatientDiagnosis = (PatientDiagnosis)factory.getDomainObject(PatientDiagnosis.class,patientDiagnosisRefVo.getID_PatientDiagnosis());
		return PatientDiagnosisShortVoAssembler.create(doPatientDiagnosis);
	}

	public PatientDiagnosisShortVoCollection listDiagnosisComplicationsContact(ClinicalContactRefVo clinicalcontactrefVo)
	{
		return listDiagnosesForContact(clinicalcontactrefVo, true, true);
	}

	public PatientDiagnosisShortVoCollection listDiagnosisComplicationsPatient(PatientRefVo patrefVo)
	{
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(patrefVo, true, true, false)).sort();
	}

	public MemberOfStaffShortVoCollection listMembersOfStaff(MemberOfStaffShortVo filter)
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdmin.listMembersOfStaff(filter);
	}

	public HcpCollection listMedics(HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(filter);
	}

	public PatientDiagnosisShortVoCollection listPatientComplications(PatientRefVo patrefvo)
	{
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(patrefvo, false, true, false)).sort();
	}

	public PatientDiagnosisShortVoCollection listPatientDiagnoses(PatientRefVo patrefvo)
	{
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(patrefvo, true, false, false)).sort();
	}

	private PatientDiagnosisShortVoCollection listDiagnosesForContact(ClinicalContactRefVo clinicalcontactrefVo, boolean boolDiagnosis, boolean boolComplication)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.clinicalContact.id = :contactId");
		markers.add("contactId");
		values.add(clinicalcontactrefVo.getID_ClinicalContact());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	private List listDiagnosesForPatient(PatientRefVo patrefvo, boolean boolDiagnosis, boolean boolComplication, boolean boolExcludeResolved)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";
 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		condStr.append(andStr + " patdiag.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patrefvo.getID_Patient());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}
		
		if (boolExcludeResolved)
		{
			condStr.append(andStr + " patdiag.isResolved = :excresolved");
			markers.add("excresolved");
			values.add(Boolean.FALSE);
		}

		hql += " where ";

		hql += condStr.toString();
		List list = factory.find(hql,markers,values);
		return list;		
	}

	public PatientDiagnosisShortVoCollection listContactComplications(ClinicalContactRefVo clinicalcontactrefVo)
	{
		return listDiagnosesForContact(clinicalcontactrefVo, false, true);
	}

	public PatientDiagnosisShortVoCollection listContactDiagnoses(ClinicalContactRefVo clinicalcontactrefVo)
	{
		return listDiagnosesForContact(clinicalcontactrefVo, true, false);
	}

	private PatientDiagnosisShortVoCollection listDiagnosesForCareContext(CareContextRefVo clinicalcontactrefVo, boolean boolDiagnosis, boolean boolComplication)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.careContext.id = :carecontextId");
		markers.add("carecontextId");
		values.add(clinicalcontactrefVo.getID_CareContext());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	public PatientDiagnosisShortVoCollection listCareContextComplications(CareContextRefVo careContextRefVo) 
	{
		return listDiagnosesForCareContext(careContextRefVo, false, true);
	}

	public PatientDiagnosisShortVoCollection listCareContextDiagnoses(CareContextRefVo careContextRefVo) 
	{
		return listDiagnosesForCareContext(careContextRefVo, true, false);
	}

	public PatientDiagnosisShortVoCollection listDiagnosisComplicationsCareContext(CareContextRefVo careContextRefVo) 
	{
		return listDiagnosesForCareContext(careContextRefVo, true, true);
	}

	private PatientDiagnosisShortVoCollection listDiagnosesForEpisodeOfCare(EpisodeOfCareRefVo episodeOfCareRefVo, boolean boolDiagnosis, boolean boolComplication)
	{
		return listDiagnosesByEpisodeOfCare(episodeOfCareRefVo, boolDiagnosis,	boolComplication, Boolean.FALSE);		
	}

	//Overload listDiagnosesForEpisodeOfCare : add isCancerDiagnosis
	public PatientDiagnosisShortVoCollection listDiagnosesForEpisodeOfCare(EpisodeOfCareRefVo episodeOfCareRefVo, boolean boolDiagnosis, boolean boolComplication, boolean isCancerDiagnosis)
	{
		return listDiagnosesByEpisodeOfCare(episodeOfCareRefVo, boolDiagnosis,	boolComplication, Boolean.TRUE);
	}
	
	
	
	private PatientDiagnosisShortVoCollection listDiagnosesByEpisodeOfCare
					(EpisodeOfCareRefVo episodeOfCareRefVo, 
							boolean boolDiagnosis,	
								boolean boolComplication, 
									boolean isCancerDiagnosis) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Comparable> values = new ArrayList<Comparable>();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.episodeOfCare.id = :episodeId");                     //wdev-13296
		markers.add("episodeId");
		values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication ");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication ");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}

		if (isCancerDiagnosis)
		{
			condStr.append(andStr + " patdiag.isCancerDiagonsis = :isCancerDiagnosis ");
			markers.add("isCancerDiagnosis");
			values.add(Boolean.TRUE);
		}
		
		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();
	}

	
	
	public PatientDiagnosisShortVoCollection listDiagnosisComplicationEpisodeOfCare(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		return listDiagnosesForEpisodeOfCare(episodeOfCareRefVo, true, true);
	}

	public PatientDiagnosisListVoCollection listDiagnosisComplicationEpisodeOfCareForCancerDiagnosis(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Comparable> values = new ArrayList<Comparable>();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.careContext.episodeOfCare.id = :episodeId");
		markers.add("episodeId");
		values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
		andStr = " and ";			

		condStr.append(andStr + " patdiag.isCancerDiagnosis = :isCancerDiagnosis ");
		markers.add("isCancerDiagnosis");
		values.add(Boolean.TRUE);
		
		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();
	}
	
	public PatientDiagnosisShortVoCollection listEpisodeOfCareComplications(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		return listDiagnosesForEpisodeOfCare(episodeOfCareRefVo, false, true);
	}

	public PatientDiagnosisShortVoCollection listEpisodeOfCareDiagnoses(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		return listDiagnosesForEpisodeOfCare(episodeOfCareRefVo, true, false);
	}

	private PatientDiagnosisShortVoCollection listDiagnosesForCareSpell(CareSpellRefVo careSpellRefVo, boolean boolDiagnosis, boolean boolComplication)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.episodeOfCare.careSpell.id = :carespellId");
		markers.add("carespellId");
		values.add(careSpellRefVo.getID_CareSpell());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	public PatientDiagnosisShortVoCollection listDiagnosisComplicationCareSpell(CareSpellRefVo careSpellRefVo) 
	{
		return listDiagnosesForCareSpell(careSpellRefVo, true, true);
	}

	public PatientDiagnosisShortVoCollection listCareSpellDiagnoses(CareSpellRefVo careSpellRefVo) 
	{
		return listDiagnosesForCareSpell(careSpellRefVo, true, false);
	}

	public PatientDiagnosisShortVoCollection listCareSpellComplications(CareSpellRefVo careSpellRefVo) 
	{
		return listDiagnosesForCareSpell(careSpellRefVo, false, true);
	}

	public DiagLiteVoCollection listHotListDiagnosis(String diagName, Specialty specialty) throws DomainInterfaceException
	{
		if(diagName == null)
			throw new DomainRuntimeException("Invalid Search criteria. Diagnosis name filter must be supplied.");
		
		if(specialty == null)
			throw new DomainRuntimeException("Invalid Search criteria. Specialty must be supplied.");

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("  select distinct item from DiagnosisHotlistItem item join item.diagnosis as diag join diag.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();

		hql.append(" where diag.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		hql.append(" and item.hotlist.specialty = :spec");
		names.add("spec");
		values.add(getDomLookup(specialty));			
	
		List hits = Keywords.searchByKeywords(factory, diagName, hql.toString(), names, values);		
		
		List diags = new ArrayList();		
		for (int i = 0; i < hits.size(); i++)
		{
			diags.add(((DiagnosisHotlistItem)hits.get(i)).getDiagnosis());
		}
		
		return DiagLiteVoAssembler.createDiagLiteVoCollectionFromDiagnosis(diags);
	}

	public PatientDiagnosisShortVoCollection listDiagnosisComplicationEpisodeOfCarePlusUnresolved(EpisodeOfCareRefVo episodeOfCareRefVo, PatientRefVo patient) 
	{
		List list = listDiagnComplicationEpisodeOfCareAndUnresolved(episodeOfCareRefVo, patient);
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(list).sort();		
	}
	/**
	 * @param episodeOfCareRefVo
	 * @param patient
	 * @return
	 */
	private List listDiagnComplicationEpisodeOfCareAndUnresolved(EpisodeOfCareRefVo episodeOfCareRefVo, PatientRefVo patient)
	{
		if(episodeOfCareRefVo == null)
			throw new RuntimeException("Cannot list PatientDiagnosisVoCollection for null EpisodeOfCareRefVo");
		if(patient == null)
			throw new RuntimeException("Cannot list PatientDiagnosisVoCollection for null PatientRefVo");
		
		DomainFactory factory = getDomainFactory();
				
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		condStr.append("patdiag.careContext.episodeOfCare.id = :episodeId");
		markers.add("episodeId");
		values.add(episodeOfCareRefVo.getID_EpisodeOfCare());

		condStr.append(" or (patdiag.careContext.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patient.getID_Patient());

		condStr.append(" and patdiag.careContext.episodeOfCare.id != :episodeId and patdiag.isResolved = :isResolved ) ");
		markers.add("isResolved");
		values.add(Boolean.FALSE);

		hql += " where ";
		hql += condStr.toString();
		List list = factory.find(hql,markers,values);
		return list;
	}
	
	public PatientDiagnosisListVoCollection listDiagnosisComplicationEpisodeOfCareAndUnresolved(EpisodeOfCareRefVo episodeOfCareRefVo, PatientRefVo patient)
	{
		List list = listDiagnComplicationEpisodeOfCareAndUnresolved(episodeOfCareRefVo, patient);
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(list).sort();
	}

	public ClinicalDIAssociationVoCollection saveClinicalDiAssociation(ClinicalDIAssociationVoCollection list) throws StaleObjectException
	{
		ClinicalDiAssociations clinicalDiAssocImpl = (ClinicalDiAssociations) getDomainImpl(ClinicalDiAssociationsImpl.class);
		return clinicalDiAssocImpl.saveClinicalDiAssociation(list);
	}

	public Boolean checkIfClinicalCDIAssociationsExist(PatientDiagnosisRefVo voPatientDiagnosis) 
	{
		ClinicalDiAssociations clinicalDiAssocImpl = (ClinicalDiAssociations) getDomainImpl(ClinicalDiAssociationsImpl.class);
		ClinicalDIAssociationVoCollection voColl = clinicalDiAssocImpl.listClinicalDiAssociation(voPatientDiagnosis);
		if (voColl.size() > 0)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}
	
	public PatientDiagnosisListVoCollection listDiagnosisComplicationsExcludeResolvedByPatient(PatientRefVo voPatRef)
	{
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(voPatRef, true, true, true)).sort();
	}
	public PatientDiagnosisListVoCollection listDiagnosisComplicationsByPatient(PatientRefVo voPatRef)
	{
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(listDiagnosesForPatient(voPatRef, true, true, false)).sort();
	}
	//wdev-13002
	public AppUserShortVo getAppUser(AppUserVo user) 
	{
		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "  from AppUser u ";
		
		boolean mosRequired = !ConfigFlag.GEN.ALLOW_NON_MOS_USERS.getValue();

		if (user.getUsername() != null && user.getUsername().length() > 0)
		{
			if (mosRequired)
			{
				hql = " select u from MemberOfStaff mos inner join mos.appUser u ";
				clause.append(" upper(mos.appUser.username) like :username");//name.upperSurname like :username");
				names.add("username");
				values.add(user.getUsername().trim().toUpperCase() + "%");		
				andStr = " and ";				
			}
			else
			{
				hql = " from AppUser u ";
				clause.append(" upper(u.username) like :username");
				names.add("username");
				values.add("%" + user.getUsername().trim().toUpperCase() + "%");
				andStr = " and ";
			}
		}		
		else if (user.getUsername() == null)
		{
			if (mosRequired)
				hql = " select u from MemberOfStaff mos inner join mos.appUser u ";
		}
			
		if (user.getIsActive() != null)
		{
			clause.append(andStr + " u.isActive = :isActive" );
			names.add("isActive");
			values.add(user.getIsActive());		
			andStr = " and ";
		}
				
		clause.append(andStr).append(" u.username != 'xxxxx'");  
		andStr=" and ";

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		hql += clause.toString();

		AppUserShortVoCollection ret = new AppUserShortVoCollection();
		List l = factory.find(hql, names, values);
		if(l != null && l.size() > 0)
		{
			AppUser domUser = (AppUser)l.get(0);
			AppUserShortVo voUser = AppUserShortVoAssembler.create(domUser);
			if (domUser.getMos() != null && domUser.getMos().getName() != null)
				voUser.setUserRealName(domUser.getMos().getName().toString());
		
			return voUser;
			
		}
		return null;

	}

	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		PatientSummary ps = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return ps.getPIDDiagnosisInfo(careContextRefVo, episodeRefVo, null);
	}

	public PatientNoDiagInfoForCCVo getPatientNoDiagInfoForCareContext(CareContextRefVo careContextRef)
	{
		if(careContextRef == null)
			   throw new CodingRuntimeException("Cannot get PatientNoDiagInfo on null careContext ");
		
		List<?> list = getDomainFactory().find("select patNoDiag from PatientNoDiagInfoForCC as patNoDiag left join patNoDiag.careContext as cc where cc.id = :careContextId)", 
				new String[] {"careContextId"}, new Object[] {careContextRef.getID_CareContext()});
		
		if (list == null || list.size() == 0)
			return null;
		
		return PatientNoDiagInfoForCCVoAssembler.createPatientNoDiagInfoForCCVoCollectionFromPatientNoDiagInfoForCC(list).get(0);
	}

	public void savePatientNoDiagInfo(PatientNoDiagInfoForCCVo patientNoDiagInfoToSave) throws StaleObjectException
	{
		if (patientNoDiagInfoToSave == null)
			throw new CodingRuntimeException("Cannot save null patientNoDiagInfo");
		
		DomainFactory factory = getDomainFactory();
		
		PatientNoDiagInfoForCC patientNoDiagInfoDo = PatientNoDiagInfoForCCVoAssembler.extractPatientNoDiagInfoForCC(factory, patientNoDiagInfoToSave);
		factory.save(patientNoDiagInfoDo);
	}
}
