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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.AdmissionDetail;
import ims.core.admin.pas.domain.objects.BedSpaceState;
import ims.core.admin.pas.domain.objects.HealthyLodger;
import ims.core.admin.pas.domain.objects.PendingTransfers;
import ims.core.admin.pas.domain.objects.WardBayConfig;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.PatientAlert;
import ims.core.clinical.domain.objects.PatientAllergy;
import ims.core.domain.Alerts;
import ims.core.domain.BayLayoutConfig;
import ims.core.domain.BedAdmissionComponent;
import ims.core.domain.BedInfoDialog;
import ims.core.layout.domain.objects.BedSpace;
import ims.core.layout.domain.objects.FloorBedSpaceLayout;
import ims.core.layout.vo.BedSpaceRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.AdmissionDetailMotherVo;
import ims.core.vo.BayConfigVo;
import ims.core.vo.BedSpaceStateLiteVo;
import ims.core.vo.BedSpaceStateLiteVoCollection;
import ims.core.vo.BedSpaceStateShortVo;
import ims.core.vo.BedSpaceVo;
import ims.core.vo.BedSpaceVoCollection;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.FloorBedSpaceLayoutVo;
import ims.core.vo.FloorBedSpaceLayoutVoCollection;
import ims.core.vo.HealthyLodgerVo;
import ims.core.vo.InpatientEpisodeLiteVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientElectiveListForWardViewVoCollection;
import ims.core.vo.PatientLite_IdentifiersVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PendingElectiveAdmissionAdmitVoCollection;
import ims.core.vo.PendingEmergencyAdmissionAdmitVoCollection;
import ims.core.vo.PendingTransferForBedReadyDetailsVo;
import ims.core.vo.PendingTransfersLiteVo;
import ims.core.vo.PendingTransfersLiteVoCollection;
import ims.core.vo.TrackingForPendingEmergencyAdmitVo;
import ims.core.vo.TrackingForPendingEmergencyAdmitVoCollection;
import ims.core.vo.WardBayConfigForWardViewVo;
import ims.core.vo.WardBedStateVo;
import ims.core.vo.WardBedStateVoCollection;
import ims.core.vo.domain.AdmissionDetailMotherVoAssembler;
import ims.core.vo.domain.BedSpaceStateLiteVoAssembler;
import ims.core.vo.domain.BedSpaceStateShortVoAssembler;
import ims.core.vo.domain.BedSpaceVoAssembler;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.FloorBedSpaceLayoutLiteVoAssembler;
import ims.core.vo.domain.FloorBedSpaceLayoutVoAssembler;
import ims.core.vo.domain.HealthyLodgerVoAssembler;
import ims.core.vo.domain.InpatientEpisodeLiteVoAssembler;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PatientElectiveListForWardViewVoAssembler;
import ims.core.vo.domain.PatientLite_IdentifiersVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.domain.PendingElectiveAdmissionAdmitVoAssembler;
import ims.core.vo.domain.PendingTransferForBedReadyDetailsVoAssembler;
import ims.core.vo.domain.PendingTransfersLiteVoAssembler;
import ims.core.vo.domain.WardBayConfigForWardViewVoAssembler;
import ims.core.vo.lookups.BedStatus;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.ElectiveAdmissionStatus;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.TransferStatus;
import ims.core.vo.lookups.WaitingListStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.dto.DTODomainImplementation;
import ims.dto.Result;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.StaleStateException;
import org.hibernate.exception.LockAcquisitionException;



public class WardViewImpl extends DTODomainImplementation implements ims.core.domain.WardView, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;


	/**
	* Lists all floor layouts
	*/
	public ims.core.vo.FloorBedSpaceLayoutLiteVoCollection list()
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from FloorBedLayout fbl where fbl.status.id = " + PreActiveActiveInactiveStatus.ACTIVE.getID();
		return FloorBedSpaceLayoutLiteVoAssembler.createFloorBedSpaceLayoutLiteVoCollectionFromFloorBedSpaceLayout(factory.find(hql)).sort();
	}

	public ims.core.vo.FloorBedSpaceLayoutVo get(ims.core.layout.vo.FloorBedSpaceLayoutRefVo id)
	{
		if(id == null)
			throw new DomainRuntimeException("Invalid Floor Bed Layout");
		
		return FloorBedSpaceLayoutVoAssembler.create((FloorBedSpaceLayout)getDomainFactory().getDomainObject(id));
	}
	
	public ims.core.vo.LocationLiteVoCollection listWardsForCurrentLocation(ILocation location)
	{
		if(location == null)
			return null;
		
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocationRefVo voRef = new LocationRefVo();
		voRef.setID_Location(location.getID());
		return implLoc.listActiveWardsForHospitalLite(voRef).sort();
	}
	
	public ims.core.vo.LocationLiteVoCollection listBaysForCurrentWard(ILocation location)
	{
		if(location == null )
			throw new DomainRuntimeException("Invalid ILocation");
		
		String hql = "from Location loc where loc.type = " + LocationType.BAY.getId() + " and loc.isActive = 1 and loc.parentLocation.id = " + location.getID();		
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(getDomainFactory().find(hql));
	}
	
	public FloorBedSpaceLayoutVo listLayoutForCurrentBay(ILocation location)
	{
 		if(location == null )
			throw new DomainRuntimeException("Invalid ILocation");
		
		String hql = "select layout from BayConfig as bc left join bc.bay as bay left join bc.floorBedSpaceLayout as layout where layout.status.id = " + PreActiveActiveInactiveStatus.ACTIVE.getID() +  " and  bay.id = " + location.getID();
		List<?> layout = getDomainFactory().find(hql);
		
		FloorBedSpaceLayoutVoCollection voColl = FloorBedSpaceLayoutVoAssembler.createFloorBedSpaceLayoutVoCollectionFromFloorBedSpaceLayout(layout);
		
		if (voColl != null &&
				voColl.size() > 0)
			return voColl.get(voColl.size()-1);		
		
		return null;
	}

	public BedSpaceStateLiteVo getBedSpaceState(BedSpaceRefVo bed) 
	{
		if(bed == null )
			throw new DomainRuntimeException("Invalid BedRefVo");
		
		String hql = "select bs,(select adm.healthyLodger from AdmissionDetail as adm where adm.pasEvent.id = bs.inpatientEpisode.pasEvent.id) from BedSpaceState as bs left join bs.bedSpace as bed where bed.id = " + bed.getID_BedSpace();
		
		List<?> bedState = null;
		
		//WDEV-23014 - Catch the Lock error and retry the entire transaction. After two retries, throw a SOE message. 

		try
		{
			bedState = getDomainFactory().find(hql);
		}
		catch (RuntimeException e) {
			if (e instanceof LockAcquisitionException) 
			{
				try
				{
					bedState = getDomainFactory().find(hql);
				}
				catch (RuntimeException e1) 
				{
					if (e1 instanceof LockAcquisitionException) 
					{
						throw new StaleStateException(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					}
				}
			}
		}
		//WDEV-23014 ends here
		
		//WDEV-11039
		boolean hasAlerts = false;
		BedSpaceStateLiteVoCollection voColl  = new BedSpaceStateLiteVoCollection();
		if (bedState != null && bedState.size() > 0 && bedState.get(0) instanceof Object[])
		{
			Object[] recordDO = (Object[]) bedState.get(0);
			BedSpaceStateLiteVo bs = null;
			for (int i =0;i<recordDO.length;i++)
			{				
				if (recordDO[0] instanceof BedSpaceState)
				{	
					BedSpaceState doBed = (BedSpaceState)recordDO[0];
					if(doBed.getInpatientEpisode() != null && doBed.getInpatientEpisode().getPasEvent() != null && doBed.getInpatientEpisode().getPasEvent().getPatient() != null && doBed.getInpatientEpisode().getPasEvent().getPatient().getPatientAlerts() != null)
						if(doBed.getInpatientEpisode().getPasEvent().getPatient().getPatientAlerts().size() > 0 && isOneActive(doBed.getInpatientEpisode().getPasEvent().getPatient().getPatientAlerts(), true))
							hasAlerts = true;

					bs  = BedSpaceStateLiteVoAssembler.create((BedSpaceState)recordDO[0]);
				}	
				if (bs.getInpatientEpisodeIsNotNull() && recordDO[1] != null && recordDO[1] instanceof HealthyLodger)
					bs.getInpatientEpisode().setHealthyLodgerDetails(HealthyLodgerVoAssembler.create((HealthyLodger)recordDO[1]));
			}
			if (bs != null)
				voColl.add(bs);

		}
		//BedSpaceStateLiteVoCollection voColl = BedSpaceStateLiteVoAssembler.createBedSpaceStateLiteVoCollectionFromBedSpaceState(bedState);
		
		if (voColl != null && voColl.size() > 0)
		{
			if(voColl.get(0).getInpatientEpisodeIsNotNull() && voColl.get(0).getInpatientEpisode().getPasEventIsNotNull() && voColl.get(0).getInpatientEpisode().getPasEvent().getPatientIsNotNull())
				voColl.get(0).getInpatientEpisode().getPasEvent().getPatient().setHasAlerts(hasAlerts);
			
			return voColl.get(0);		
		}
		return null;
	}

	private boolean isOneActive(Set setAlertsOrAllergies, boolean isAlert)
	{
		if(isAlert)
		{
			Iterator it = setAlertsOrAllergies.iterator();
			while(it.hasNext())
			{
				PatientAlert doAlert = (PatientAlert) it.next();
				if(doAlert.isIsCurrentlyActiveAlert() != null && doAlert.isIsCurrentlyActiveAlert() && (doAlert.getIsRIE() == null || !doAlert.getIsRIE()))
					return true;
			}
		}
		else if(!isAlert) //allergy
		{
			Iterator it = setAlertsOrAllergies.iterator();
			while(it.hasNext())
			{
				PatientAllergy doAllergy = (PatientAllergy) it.next();
				if(doAllergy.isIsCurrentlyActiveAllergy() != null && doAllergy.isIsCurrentlyActiveAllergy() && (doAllergy.getIsRIE() == null || !doAllergy.getIsRIE()))
					return true;
			}
		}
		
		return false;
	}

	public InpatientEpisodeLiteVoCollection listInpatientEpisodeByWard(LocationRefVo ward)
	{
		if(ward == null || ward.getID_Location() == null)
			throw new CodingRuntimeException("ward is null or id not provide in method listInpatientEpisodeByWard");
		
		String hql = "from InpatientEpisode inpat join fetch inpat.bed as bed where (inpat.pasEvent.location.id = :idWard and bed is not null) order by bed.bay asc, inpat.pasEvent.patient.name.upperSurname asc,inpat.pasEvent.patient.name.upperForename asc";
		List inpatEpis = getDomainFactory().find(hql, new String[]{"idWard"}, new Object[]{ward.getID_Location()});
		return InpatientEpisodeLiteVoAssembler.createInpatientEpisodeLiteVoCollectionFromInpatientEpisode(inpatEpis);
	}

	public PendingEmergencyAdmissionAdmitVoCollection listEmergencyAdmission(LocationRefVo location)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		TrackingForPendingEmergencyAdmitVoCollection listEmergencyAdmission = impl.listEmergencyAdmission(location);
		
		if (listEmergencyAdmission == null)
			return null;
		
		PendingEmergencyAdmissionAdmitVoCollection results = new PendingEmergencyAdmissionAdmitVoCollection();
		
		for (TrackingForPendingEmergencyAdmitVo tracking : listEmergencyAdmission)
		{
			if (tracking.getAssociatedPendingEmergencyAdmission() != null)
				results.add(tracking.getAssociatedPendingEmergencyAdmission());
		}
		
		
		return results;
	}

	public PendingElectiveAdmissionAdmitVoCollection listPendingElectiveAdmission(LocationRefVo voLocation)
	{
		if(voLocation == null)
			throw new CodingRuntimeException("voLocation is null in method listPendingElectiveAdmission");
		
		DomainFactory factory = getDomainFactory();
		List pendingElectives = factory.find("from PendingElectiveAdmission pea where (pea.tCIDate = :today or pea.tCIDate = :yesterday) and pea.allocatedWard.id = :idWard and pea.electiveAdmissionStatus = :status", new String[]{"today","yesterday", "idWard","status"}, new Object[]{new Date().getDate(), new Date().addDay(-1).getDate(),voLocation.getID_Location(), getDomLookup(ElectiveAdmissionStatus.TCI)});
		return PendingElectiveAdmissionAdmitVoAssembler.createPendingElectiveAdmissionAdmitVoCollectionFromPendingElectiveAdmission(pendingElectives);
	}

	public PendingTransfersLiteVoCollection listPendingTransfersInByWard(LocationRefVo destWard)
	{
		if(destWard == null || destWard.getID_Location() == null)
			throw new CodingRuntimeException("destWard is null or id not provided in method listPendingTransfersInByWard");
		
		String hql = "from PendingTransfers pend where pend.destinationWard.id = :idWard and pend.currentStatus = :status";
		List pendingTrans = getDomainFactory().find(hql, new String[]{"idWard","status"}, new Object[]{destWard.getID_Location(), getDomLookup(TransferStatus.PENDING)});
		return PendingTransfersLiteVoAssembler.createPendingTransfersLiteVoCollectionFromPendingTransfers(pendingTrans);
	}

	public PendingTransfersLiteVoCollection listPendingTransfersOutByWard(LocationRefVo currentLocation)
	{
		if(currentLocation == null || currentLocation.getID_Location() == null)
			throw new CodingRuntimeException("currentLocation is null or id not provided in method listPendingTransfersOutByWard");
		
		String hql = "from PendingTransfers pend where pend.inpatientEpisode.pasEvent.location.id = :idWard and pend.currentStatus = :status order by pend.inpatientEpisode.pasEvent.patient.name.upperSurname asc, pend.inpatientEpisode.pasEvent.patient.name.upperForename asc";
		List pendingTrans = getDomainFactory().find(hql, new String[]{"idWard","status"}, new Object[]{currentLocation.getID_Location(), getDomLookup(TransferStatus.PENDING)});
		return PendingTransfersLiteVoAssembler.createPendingTransfersLiteVoCollectionFromPendingTransfers(pendingTrans);
	}

	public LocationLiteVoCollection listActiveHospitalsLite()
	{
		BedInfoDialog impl = (BedInfoDialog) getDomainImpl(BedInfoDialogImpl.class);
		return impl.listActiveHospitalsLite();
	}

	public WardBayConfigForWardViewVo getWardBayConfigByWard(LocationRefVo ward) //WDEV-20328
	{
		BayLayoutConfig impl = (BayLayoutConfig) getDomainImpl(BayLayoutConfigImpl.class);
		return impl.getWardBayConfigurationByWard(ward);
	}

	public InpatientEpisodeLiteVoCollection listWaitingAreaPatientsByWard(LocationRefVo ward)
	{
		if(ward == null || ward.getID_Location() == null)
			throw new CodingRuntimeException("ward is null or id not provided in method listWaitingAreaPatientsByWard");
		
		String hql = "from InpatientEpisode inpat left join fetch inpat.bed as bedspace where inpat.pasEvent.location.id = :idWard and bedspace is null and (inpat.isOnHomeLeave is null or inpat.isOnHomeLeave = :bFalse) and (inpat.isReadyToLeave is null or inpat.isReadyToLeave = :bFalse) and inpat.id not in (select inp.id from PendingTransfers pt left join pt.inpatientEpisode as inp where inp.pasEvent.location.id = :idWard) order by inpat.pasEvent.patient.name.upperSurname ";
		List<?> inpatEpis = getDomainFactory().find(hql, new String[]{"idWard", "bFalse"}, new Object[]{ward.getID_Location(), Boolean.FALSE});
		return InpatientEpisodeLiteVoAssembler.createInpatientEpisodeLiteVoCollectionFromInpatientEpisode(inpatEpis);
	}

	public LocMostVo getLocation(LocationRefVo voLocRef)
	{
		DomainFactory factory = getDomainFactory();
		return LocMostVoAssembler.create((Location) factory.getDomainObject(Location.class, voLocRef.getID_Location()));
	}

	public int countInfants(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("patient is null or id not provided in method countInfants");
		
		String hql = "select count (inpatEpis.id) from InpatientEpisode as inpatEpis left join inpatEpis.pasEvent as pE where (pE.patient.id in (select pat.id from Patient as pat where (pat.clientParent.id = " + patient.getID_Patient() + ")))";
		List lstCount = getDomainFactory().find(hql);
		if(lstCount != null && lstCount.size() == 1)
			return ((Long)lstCount.get(0)).intValue();
		
		return 0;
	}
	//WDEV-20326
	public void cancelTransfer(PendingTransfersLiteVo voTransfer, LocationRefVo voCancellingfromWard) throws StaleObjectException, ForeignKeyViolationException
	{
		BedInfoDialog impl = (BedInfoDialog) getDomainImpl(BedInfoDialogImpl.class);
		impl.cancelTransfer(voTransfer,voCancellingfromWard);
	}

	public AdmissionDetailMotherVo getMothersAdmission(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("patient is null or id not provided in method getMothersAdmission");
		
		//get the patient to read ClientParent value
		Patient doPatient = (Patient) getDomainFactory().getDomainObject(patient); 		
		
		if(doPatient != null && doPatient.getClientParent() != null)
		{
			List<?> admissions = getDomainFactory().find("from AdmissionDetail adm left join fetch adm.pasEvent as pe left join fetch pe.patient as pat where pat.id = " + doPatient.getClientParent().getId()  + "order by adm.systemInformation.creationDateTime desc");
			if(admissions != null && admissions.size() > 0)
				return AdmissionDetailMotherVoAssembler.create((AdmissionDetail) admissions.get(0));
		}
		
		return null;
	}
	//WDEV-22256 //WDEV-22503
	public CareContextShortVo getCareContextForPasEvent(PASEventRefVo pasEvent)
	{
		if (pasEvent == null || pasEvent.getID_PASEvent() == null)
			return null;

		List<?> ccList = getDomainFactory().find(" select cc from CareContext as cc where cc.pasEvent.id = :PASEVENT_ID", new String[]{"PASEVENT_ID"}, new Object[]{pasEvent.getID_PASEvent()});
		CareContextShortVo careContextShort = null;
		if (ccList != null && !ccList.isEmpty())
		{	
			if (!ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS") && ccList.size() == 1)
				return CareContextShortVoAssembler.create((CareContext) ccList.get(0));

			else if (ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS"))
			{	
				if (ConfigFlag.FW.USE_REFERRAL_CARECONTEXT.getValue())
				{	
					careContextShort = getCareContext(ccList,ContextType.REFERRAL);
					if (careContextShort == null)
					{
						careContextShort = getCareContext(ccList,ContextType.INPATIENT);
					}
				}
				else
				{
					careContextShort = getCareContext(ccList,ContextType.INPATIENT);
				}				
			}
		}	 
		return careContextShort;
	}
	private CareContextShortVo getCareContext(List<?> ccList,	ContextType context)
	{
		if (ccList == null || ccList.isEmpty() || context == null)
			return null;
		for (int i=0;i<ccList.size();i++)
		{
			if (!(ccList.get(i) instanceof CareContext))
				continue;

			if (context.getId() == ((CareContext)ccList.get(i)).getContext().getId())
			{	
				return CareContextShortVoAssembler.create((CareContext) ccList.get(i));				
			}				
		}
		return null;
	}

	//WDEV-22256  -- end

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	
	//wdev-13343
	public ims.dto.client.Patient getPatient(String pid, String identifier) throws DomainInterfaceException
	{
		ims.dto.client.Patient patient = (ims.dto.client.Patient)getDTOInstance(ims.dto.client.Patient.class);
		patient.Filter.clear();
		if (pid != null && pid.equals("-549"))
			patient.Filter.Nhsn = identifier;
		else
			patient.Filter.Hospnum = identifier;
		
		Result result = patient.get();
		
		if (result != null)
		{
			throw new DomainInterfaceException(result.getMessage());
		}
		
		return patient;
		
	}

	//wdev-13343
	public ims.dto.client.Patient getCCODTOPatient(String pkey)	throws DomainInterfaceException 
	{
		if(pkey == null)
			throw new DomainRuntimeException("Cannot get Patient for null pkey");
		
		ims.dto.client.Patient patient = (ims.dto.client.Patient)getDTOInstance(ims.dto.client.Patient.class);
		patient.Filter.clear();
		patient.Filter.Pkey = pkey;
		
		Result result = patient.get();
		if (result != null)
		{
			if(result.getId() == -2)
				throw new DomainInterfaceException("Error Getting Patient Details for pkey = " + pkey);

			throw new DomainInterfaceException(result.getMessage());
		}

		if (patient.DataCollection.count()!= 1)
			throw new DomainInterfaceException("Failed to get patient record.");
		
		return patient;
	}

	public InpatientEpisodeLiteVoCollection listHomeLeaveByWard(LocationRefVo ward) 
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.listHomeLeavesByWard(ward);
	}

	//WDEV-14476
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		Alerts impl = (Alerts) getDomainImpl(AlertsImpl.class);
		return impl.getPIDDiagnosisInfo(careContextRefVo, episodeRefVo);
	}

	//WDEV-15908
	public LocationLiteVo getCurrentHospital(ILocation location) 
	{
		if(location == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		Location currentHospital = getHospital((Location) factory.getDomainObject(Location.class, location.getID()));
		
		if(currentHospital instanceof LocSite)
			return LocationLiteVoAssembler.create((Location) currentHospital);
		
		return null;
	}
	
	//WDEV-15908
	private Location getHospital(Location doLocation)
	{
		if(doLocation == null)
			return null;
		
		if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return doLocation;
	
		while(doLocation.getParentLocation() != null) 
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return doLocation;
		}
		
		return null;
	}

	//wdev-18936
	public PatientElectiveListForWardViewVoCollection listPatientElectiveListForWardViewVo(LocationRefVo ward, Date tcidate)
	{
		StringBuilder query = new StringBuilder();
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("SELECT pel FROM PatientElectiveList AS pel ");
		query.append("LEFT JOIN pel.electiveListStatus AS els LEFT JOIN els.electiveListStatus AS elStatus ");
		query.append("LEFT JOIN pel.tCIDetails AS tci LEFT JOIN tci.tCIWard AS ward ");
		query.append("LEFT JOIN pel.patient AS patient ");
		
		query.append("WHERE ward.id = :WARD AND elStatus.id = :TCI_GIVEN AND tci.isActive = 1 AND tci.currentOutcome is null ");
		paramNames.add("WARD");
		paramValues.add(ward.getID_Location());
		paramNames.add("TCI_GIVEN");
		paramValues.add(WaitingListStatus.TCI_GIVEN.getId());
		if( tcidate != null)	//wdev-19115
		{
			query.append(" AND tci.tCIDate = :CURRENT_DATE");
			paramNames.add("CURRENT_DATE");
			paramValues.add(tcidate.getDate());
		}
		
				
		query.append(" ORDER BY patient.name.surname, patient.name.forename");

		return PatientElectiveListForWardViewVoAssembler.createPatientElectiveListForWardViewVoCollectionFromPatientElectiveList(getDomainFactory().find(query.toString(), paramNames, paramValues));
		
	}

	public InpatientEpisodeLiteVoCollection listInpatientEpisodeByWard(LocationRefVo ward, PatientRefVo patient)
	{
		if(ward == null || ward.getID_Location() == null)
			throw new CodingRuntimeException("ward is null or id not provide in method listInpatientEpisodeByWard");
	
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String hql = "from InpatientEpisode inpat join fetch inpat.bed as bed where inpat.pasEvent.location.id = :idWard and bed is not null";
		paramNames.add("idWard");
		paramValues.add(ward.getID_Location());
		
		if(patient != null && patient.getID_Patient() != null)
		{
			hql += " and inpat.pasEvent.patient.id <> :PatientId";
			paramNames.add("PatientId");
			paramValues.add(patient.getID_Patient());
		}
		
		hql += " order by bed.bay asc, inpat.pasEvent.patient.name.upperSurname asc,inpat.pasEvent.patient.name.upperForename asc";
		
		List inpatEpis = getDomainFactory().find(hql, paramNames, paramValues);
		return InpatientEpisodeLiteVoAssembler.createInpatientEpisodeLiteVoCollectionFromInpatientEpisode(inpatEpis);
	}

	//WDEV-20217
	public void updateOccupiedBedsForWardAndBay(LocationRefVo ward, LocationRefVo bayOne, LocationRefVo bayTwo) throws StaleObjectException
	{
		if (ward == null || bayOne == null)
			return;
		
		// this is a move from one bed to another in the same bay - no need to update the occupied beds
		if (bayOne != null && bayTwo != null && bayOne.getID_Location().equals(bayTwo.getID_Location()))
			return;
		
		int bayOneOccupiedBeds = 0;
		int bayTwoOccupiedBeds = 0;
		int wardOccupiedBeds = 0;
		
		WardBayConfigForWardViewVo wardBayConfig = getWardBayConfigByWard(ward);
		
		if (wardBayConfig != null && wardBayConfig.getBays() != null)
		{
			for (int j = 0; j < wardBayConfig.getBays().size(); j++)
			{
				BayConfigVo wardBay = wardBayConfig.getBays().get(j);
				
				if (wardBay == null)
					continue;
				
				if (wardBay.getBay() != null)
				{
					if (wardBay.getBay().getID_Location().equals(bayOne.getID_Location()))
					{
						bayOneOccupiedBeds = getNumberOfOccupiedBedsInBay(bayOne);
					
						wardBay.setNumOfOccupiedBeds(bayOneOccupiedBeds);
						wardOccupiedBeds += bayOneOccupiedBeds;
					}
					else if (bayTwo != null && wardBay.getBay().getID_Location().equals(bayTwo.getID_Location()))
					{
						bayTwoOccupiedBeds = getNumberOfOccupiedBedsInBay(bayTwo);
					
						wardBay.setNumOfOccupiedBeds(bayTwoOccupiedBeds);
						wardOccupiedBeds += bayTwoOccupiedBeds;
					}
				}
				else
					wardOccupiedBeds += wardBay.getNumOfBeds();
			}
		}
		
		//transfer has been made from 2 bays in the same ward - no need to update the ward occupied beds 
		if ( !(bayOne != null && bayTwo != null))
			wardBayConfig.setNumOfOccupiedBeds(wardOccupiedBeds);

		DomainFactory factory = getDomainFactory();
		
		WardBayConfig doWardBayConfig = WardBayConfigForWardViewVoAssembler.extractWardBayConfig(factory, wardBayConfig);
		factory.save(doWardBayConfig);
	}

	private int getNumberOfOccupiedBedsInBay(LocationRefVo bay)
	{
		int occupiedBeds = 0;
		
		FloorBedSpaceLayoutVo layout = listLayoutForCurrentBay((ILocation) bay);
		
		if (layout != null && layout.getFloorLayout() != null && layout.getBedSpaces() != null)
		{

			for (int x = 0; x < layout.getBedSpaces().size(); x++)
			{
				BedSpaceVo bedVo = layout.getBedSpaces().get(x);

				BedSpaceStateLiteVo state = getBedSpaceState(bedVo);

				if (state != null && state.getCurrentBedStatus() != null && BedStatus.OCCUPIED.equals(state.getCurrentBedStatus().getBedStatus()))
				{
					occupiedBeds += 1;
				}
			}
		}
		
		return occupiedBeds;
	}

	public WardBedStateVoCollection listBedSpacesState(BedSpaceVoCollection bedSpaces) throws DomainInterfaceException
	{
		if (bedSpaces == null || bedSpaces.size() == 0)
			return null;


		StringBuilder query = new StringBuilder("SELECT bedSpace, bedSpaceState, ");
		query.append(" (select adm.healthyLodger from AdmissionDetail as adm where adm.pasEvent.id = bedSpaceState.inpatientEpisode.pasEvent.id), ");
		query.append(" (select pt from PendingTransfers as pt LEFT JOIN pt.inpatientEpisode as inpt where inpt.id = bedSpaceState.inpatientEpisode.id)");
		query.append(" FROM BedSpaceState AS bedSpaceState RIGHT JOIN bedSpaceState.bedSpace AS bedSpace ");
		
		query.append("WHERE bedSpace.id IN (");
		
		for (int i = 0; i < bedSpaces.size(); i++)
		{
			query.append(bedSpaces.get(i).getID_BedSpace());
			
			if (i < bedSpaces.size() - 1)
				query.append(", ");
		}
		
		query.append(")");
		
		try
		{
			List<?> results = getDomainFactory().find(query.toString());

			if (results == null || results.size() == 0)
				return null;

			WardBedStateVoCollection bedStates = new WardBedStateVoCollection();

			for (int i = 0; i < results.size(); i++)
			{
				Object[] resultItem = (Object[]) results.get(i);

				if (resultItem[0] instanceof BedSpace)
				{
					BedSpaceVo bedSpace = BedSpaceVoAssembler.create((BedSpace) resultItem[0]);

					WardBedStateVo bedStateResult = new WardBedStateVo();
					bedStateResult.setBedSpace(bedSpace);


					if (resultItem[1] instanceof BedSpaceState)
					{
						BedSpaceStateShortVo bedSpaceState = BedSpaceStateShortVoAssembler.create((BedSpaceState) resultItem[1]);
						bedStateResult.setBedSpaceState(bedSpaceState);

						//WDEV-22567
						if (bedSpaceState.getInpatientEpisode() != null && bedSpaceState.getInpatientEpisode().getPasEvent() != null && bedSpaceState.getInpatientEpisode().getPasEvent().getPatient() != null)
						{					
							if (bedSpaceState.getInpatientEpisode().getPasEvent().getPatient().getAssociatedPatientIsNotNull())
							{
								bedSpaceState.getInpatientEpisode().getPasEvent().setPatient(getPatientLite(bedSpaceState.getInpatientEpisode().getPasEvent().getPatient().getAssociatedPatient()));
							}
							// Set the has alerts boolean in Patient
							if (bedSpaceState.getInpatientEpisode().getPasEvent().getPatient().getPatientAlerts() != null)
							{
								bedSpaceState.getInpatientEpisode().getPasEvent().getPatient().setHasAlerts(bedSpaceState.getInpatientEpisode().getPasEvent().getPatient().getPatientAlerts().size() > 0);
							}					
						}
						if (resultItem[2] instanceof HealthyLodger
								&& bedStateResult.getBedSpaceState() != null && bedStateResult.getBedSpaceState().getInpatientEpisode() != null)
						{
							HealthyLodgerVo healthyLodger = HealthyLodgerVoAssembler.create((HealthyLodger) resultItem[2]);
							bedStateResult.getBedSpaceState().getInpatientEpisode().setHealthyLodgerDetails(healthyLodger);
						}
						if (resultItem[3] instanceof PendingTransfers //WDEV-21083
								&& bedStateResult.getBedSpaceState() != null && bedStateResult.getBedSpaceState().getInpatientEpisode() != null)
						{
							PendingTransferForBedReadyDetailsVo pendingTransf = PendingTransferForBedReadyDetailsVoAssembler.create((PendingTransfers)resultItem[3]);
							bedStateResult.getBedSpaceState().getInpatientEpisode().setAssociatedPendingTransfer(pendingTransf);
						}
					}

					bedStates.add(bedStateResult);
				}
			}

			return bedStates;
		}
		catch (Exception ex)
		{
			throw new DomainInterfaceException("Search failed while trying to retrieve results. Please search again.");
		}
	}

	private PatientLite_IdentifiersVo getPatientLite(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		return PatientLite_IdentifiersVoAssembler.create(((Patient) getDomainFactory().getDomainObject(Patient.class, patient.getID_Patient())));
	}
	
	public PatientShort getPatientShort(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patient.getID_Patient()));
	}
}
