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

package ims.pathways.vo;


public class PatientJourneySearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientJourneySearchCriteriaVo()
	{
	}
	public PatientJourneySearchCriteriaVo(ims.pathways.vo.beans.PatientJourneySearchCriteriaVoBean bean)
	{
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.selectedreferral = bean.getSelectedReferral() == null ? null : bean.getSelectedReferral().buildVo();
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo();
		this.journeyhistory = bean.getJourneyHistory() == null ? null : bean.getJourneyHistory().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneySearchCriteriaVoBean bean)
	{
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.selectedreferral = bean.getSelectedReferral() == null ? null : bean.getSelectedReferral().buildVo(map);
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo(map);
		this.journeyhistory = bean.getJourneyHistory() == null ? null : bean.getJourneyHistory().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneySearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneySearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneySearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getSelectedReferralIsNotNull()
	{
		return this.selectedreferral != null;
	}
	public ims.core.vo.ReferralLiteVo getSelectedReferral()
	{
		return this.selectedreferral;
	}
	public void setSelectedReferral(ims.core.vo.ReferralLiteVo value)
	{
		this.isValidated = false;
		this.selectedreferral = value;
	}
	public boolean getJourneyIsNotNull()
	{
		return this.journey != null;
	}
	public ims.pathways.vo.PatientJourneyDummyVo getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.pathways.vo.PatientJourneyDummyVo value)
	{
		this.isValidated = false;
		this.journey = value;
	}
	public boolean getJourneyHistoryIsNotNull()
	{
		return this.journeyhistory != null;
	}
	public ims.pathways.vo.PatwayHistoryDummyVo getJourneyHistory()
	{
		return this.journeyhistory;
	}
	public void setJourneyHistory(ims.pathways.vo.PatwayHistoryDummyVo value)
	{
		this.isValidated = false;
		this.journeyhistory = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientJourneySearchCriteriaVo clone = new PatientJourneySearchCriteriaVo();
		
		clone.catsreferral = this.catsreferral;
		clone.patient = this.patient;
		if(this.selectedreferral == null)
			clone.selectedreferral = null;
		else
			clone.selectedreferral = (ims.core.vo.ReferralLiteVo)this.selectedreferral.clone();
		if(this.journey == null)
			clone.journey = null;
		else
			clone.journey = (ims.pathways.vo.PatientJourneyDummyVo)this.journey.clone();
		if(this.journeyhistory == null)
			clone.journeyhistory = null;
		else
			clone.journeyhistory = (ims.pathways.vo.PatwayHistoryDummyVo)this.journeyhistory.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientJourneySearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientJourneySearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientJourneySearchCriteriaVo compareObj = (PatientJourneySearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.catsreferral != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.selectedreferral != null)
			count++;
		if(this.journey != null)
			count++;
		if(this.journeyhistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.RefMan.vo.CatsReferralRefVo catsreferral;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.ReferralLiteVo selectedreferral;
	protected ims.pathways.vo.PatientJourneyDummyVo journey;
	protected ims.pathways.vo.PatwayHistoryDummyVo journeyhistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
