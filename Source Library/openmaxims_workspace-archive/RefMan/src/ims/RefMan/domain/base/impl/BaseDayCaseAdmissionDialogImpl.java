// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseDayCaseAdmissionDialogImpl extends DomainImpl implements ims.RefMan.domain.DayCaseAdmissionDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validateadmitPatient(ims.core.vo.PatientShort patVo, ims.core.vo.InpatientEpisodeVo episVo, ims.scheduling.vo.Booking_AppointmentRefVo bookingApptVoRef, ims.RefMan.vo.CatsReferralWizardVo voCats, ims.RefMan.vo.PatientElectiveListBedAdmissionVo electiveList, ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection electiveListToBeCancelled)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveMedics(String szName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferralWizardVoForCareContext(ims.core.admin.vo.CareContextRefVo voCarecontext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo voBookingRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferralSpecialty(ims.scheduling.vo.Booking_AppointmentRefVo bookingAppointment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientElectiveListForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasPatientElectiveListsToBeCancelled(ims.core.patient.vo.PatientRefVo patient, ims.RefMan.vo.PatientElectiveListRefVo patientElectiveList, ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDifferentPatientElectiveListForService(ims.core.patient.vo.PatientRefVo patient, ims.RefMan.vo.PatientElectiveListRefVo electiveList, ims.core.clinical.vo.ServiceRefVo service)
	{
	}
}
