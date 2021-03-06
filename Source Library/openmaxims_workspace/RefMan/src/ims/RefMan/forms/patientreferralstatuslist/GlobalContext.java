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

package ims.RefMan.forms.patientreferralstatuslist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		RefMan = new RefManContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");
		public boolean getIsConsultationStartedIsNotNull()
		{
			return !cx_RefManIsConsultationStarted.getValueIsNull(context);
		}
		public Boolean getIsConsultationStarted()
		{
			return (Boolean)cx_RefManIsConsultationStarted.getValue(context);
		}
		public void setIsConsultationStarted(Boolean value)
		{
			cx_RefManIsConsultationStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsConsultationStarted = new ims.framework.ContextVariable("RefMan.IsConsultationStarted", "_cv_RefMan.IsConsultationStarted");
		public boolean getIsClinicalContactStartedIsNotNull()
		{
			return !cx_RefManIsClinicalContactStarted.getValueIsNull(context);
		}
		public Boolean getIsClinicalContactStarted()
		{
			return (Boolean)cx_RefManIsClinicalContactStarted.getValue(context);
		}
		public void setIsClinicalContactStarted(Boolean value)
		{
			cx_RefManIsClinicalContactStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsClinicalContactStarted = new ims.framework.ContextVariable("RefMan.IsClinicalContactStarted", "_cv_RefMan.IsClinicalContactStarted");
		public boolean getIsProviderCancellationIsNotNull()
		{
			return !cx_RefManIsProviderCancellation.getValueIsNull(context);
		}
		public Boolean getIsProviderCancellation()
		{
			return (Boolean)cx_RefManIsProviderCancellation.getValue(context);
		}
		public void setIsProviderCancellation(Boolean value)
		{
			cx_RefManIsProviderCancellation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsProviderCancellation = new ims.framework.ContextVariable("RefMan.IsProviderCancellation", "_cvp_RefMan.IsProviderCancellation");
		public boolean getSpecimenWorkListItemForReportsIsNotNull()
		{
			return !cx_RefManSpecimenWorkListItemForReports.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenWorkListItemVo getSpecimenWorkListItemForReports()
		{
			return (ims.ocrr.vo.SpecimenWorkListItemVo)cx_RefManSpecimenWorkListItemForReports.getValue(context);
		}
		public void setSpecimenWorkListItemForReports(ims.ocrr.vo.SpecimenWorkListItemVo value)
		{
			cx_RefManSpecimenWorkListItemForReports.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSpecimenWorkListItemForReports = new ims.framework.ContextVariable("RefMan.SpecimenWorkListItemForReports", "_cv_RefMan.SpecimenWorkListItemForReports");
		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_RefManReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_RefManReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_RefManReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralContractTypeForPatient = new ims.framework.ContextVariable("RefMan.ReferralContractTypeForPatient", "_cvp_RefMan.ReferralContractTypeForPatient");
		public boolean getPatientElectiveListRefIsNotNull()
		{
			return !cx_RefManPatientElectiveListRef.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientElectiveListRefVo getPatientElectiveListRef()
		{
			return (ims.RefMan.vo.PatientElectiveListRefVo)cx_RefManPatientElectiveListRef.getValue(context);
		}
		public void setPatientElectiveListRef(ims.RefMan.vo.PatientElectiveListRefVo value)
		{
			cx_RefManPatientElectiveListRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManPatientElectiveListRef = new ims.framework.ContextVariable("RefMan.PatientElectiveListRef", "_cv_RefMan.PatientElectiveListRef");
		public boolean getOpenApptAndInvTabIsNotNull()
		{
			return !cx_RefManOpenApptAndInvTab.getValueIsNull(context);
		}
		public Boolean getOpenApptAndInvTab()
		{
			return (Boolean)cx_RefManOpenApptAndInvTab.getValue(context);
		}
		public void setOpenApptAndInvTab(Boolean value)
		{
			cx_RefManOpenApptAndInvTab.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManOpenApptAndInvTab = new ims.framework.ContextVariable("RefMan.OpenApptAndInvTab", "_cv_RefMan.OpenApptAndInvTab");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public RefManContext RefMan;
}
