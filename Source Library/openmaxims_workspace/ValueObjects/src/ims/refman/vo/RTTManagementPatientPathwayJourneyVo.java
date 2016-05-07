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

package ims.RefMan.vo;

/**
 * Linked to Pathways.PatientPathwayJourney business object (ID: 1088100000).
 */
public class RTTManagementPatientPathwayJourneyVo extends ims.pathways.vo.PatientPathwayJourneyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RTTManagementPatientPathwayJourneyVo()
	{
	}
	public RTTManagementPatientPathwayJourneyVo(Integer id, int version)
	{
		super(id, version);
	}
	public RTTManagementPatientPathwayJourneyVo(ims.RefMan.vo.beans.RTTManagementPatientPathwayJourneyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathway = bean.getPathway() == null ? null : bean.getPathway().buildVo();
		this.currentclock = bean.getCurrentClock() == null ? null : bean.getCurrentClock().buildVo();
		this.nextvalidationdate = bean.getNextValidationDate() == null ? null : bean.getNextValidationDate().buildDate();
		this.clockhistory = ims.pathways.vo.RTTManagementPathwayClockVoCollection.buildFromBeanCollection(bean.getClockHistory());
		this.referral = bean.getReferral() == null ? null : new ims.core.admin.vo.ReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.validationcompleteddt = bean.getValidationCompletedDT() == null ? null : bean.getValidationCompletedDT().buildDateTime();
		this.validationcompletedby = bean.getValidationCompletedBy() == null ? null : bean.getValidationCompletedBy().buildVo();
		this.lastvalidationdate = bean.getLastValidationDate() == null ? null : bean.getLastValidationDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.RTTManagementPatientPathwayJourneyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathway = bean.getPathway() == null ? null : bean.getPathway().buildVo(map);
		this.currentclock = bean.getCurrentClock() == null ? null : bean.getCurrentClock().buildVo(map);
		this.nextvalidationdate = bean.getNextValidationDate() == null ? null : bean.getNextValidationDate().buildDate();
		this.clockhistory = ims.pathways.vo.RTTManagementPathwayClockVoCollection.buildFromBeanCollection(bean.getClockHistory());
		this.referral = bean.getReferral() == null ? null : new ims.core.admin.vo.ReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.validationcompleteddt = bean.getValidationCompletedDT() == null ? null : bean.getValidationCompletedDT().buildDateTime();
		this.validationcompletedby = bean.getValidationCompletedBy() == null ? null : bean.getValidationCompletedBy().buildVo(map);
		this.lastvalidationdate = bean.getLastValidationDate() == null ? null : bean.getLastValidationDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.RTTManagementPatientPathwayJourneyVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.RTTManagementPatientPathwayJourneyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.RTTManagementPatientPathwayJourneyVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATHWAY"))
			return getPathway();
		if(fieldName.equals("CURRENTCLOCK"))
			return getCurrentClock();
		if(fieldName.equals("NEXTVALIDATIONDATE"))
			return getNextValidationDate();
		if(fieldName.equals("CLOCKHISTORY"))
			return getClockHistory();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("VALIDATIONCOMPLETEDDT"))
			return getValidationCompletedDT();
		if(fieldName.equals("VALIDATIONCOMPLETEDBY"))
			return getValidationCompletedBy();
		if(fieldName.equals("LASTVALIDATIONDATE"))
			return getLastValidationDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPathwayIsNotNull()
	{
		return this.pathway != null;
	}
	public ims.pathways.vo.PathwayLiteVo getPathway()
	{
		return this.pathway;
	}
	public void setPathway(ims.pathways.vo.PathwayLiteVo value)
	{
		this.isValidated = false;
		this.pathway = value;
	}
	public boolean getCurrentClockIsNotNull()
	{
		return this.currentclock != null;
	}
	public ims.pathways.vo.RTTManagementPathwayClockVo getCurrentClock()
	{
		return this.currentclock;
	}
	public void setCurrentClock(ims.pathways.vo.RTTManagementPathwayClockVo value)
	{
		this.isValidated = false;
		this.currentclock = value;
	}
	public boolean getNextValidationDateIsNotNull()
	{
		return this.nextvalidationdate != null;
	}
	public ims.framework.utils.Date getNextValidationDate()
	{
		return this.nextvalidationdate;
	}
	public void setNextValidationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.nextvalidationdate = value;
	}
	public boolean getClockHistoryIsNotNull()
	{
		return this.clockhistory != null;
	}
	public ims.pathways.vo.RTTManagementPathwayClockVoCollection getClockHistory()
	{
		return this.clockhistory;
	}
	public void setClockHistory(ims.pathways.vo.RTTManagementPathwayClockVoCollection value)
	{
		this.isValidated = false;
		this.clockhistory = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.core.admin.vo.ReferralRefVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.core.admin.vo.ReferralRefVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getValidationCompletedDTIsNotNull()
	{
		return this.validationcompleteddt != null;
	}
	public ims.framework.utils.DateTime getValidationCompletedDT()
	{
		return this.validationcompleteddt;
	}
	public void setValidationCompletedDT(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.validationcompleteddt = value;
	}
	public boolean getValidationCompletedByIsNotNull()
	{
		return this.validationcompletedby != null;
	}
	public ims.core.vo.MemberOfStaffVo getValidationCompletedBy()
	{
		return this.validationcompletedby;
	}
	public void setValidationCompletedBy(ims.core.vo.MemberOfStaffVo value)
	{
		this.isValidated = false;
		this.validationcompletedby = value;
	}
	public boolean getLastValidationDateIsNotNull()
	{
		return this.lastvalidationdate != null;
	}
	public ims.framework.utils.Date getLastValidationDate()
	{
		return this.lastvalidationdate;
	}
	public void setLastValidationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.lastvalidationdate = value;
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
		if(this.currentclock != null)
		{
			if(!this.currentclock.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.pathway == null)
			listOfErrors.add("Pathway is mandatory");
		if(this.currentclock != null)
		{
			String[] listOfOtherErrors = this.currentclock.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		RTTManagementPatientPathwayJourneyVo clone = new RTTManagementPatientPathwayJourneyVo(this.id, this.version);
		
		if(this.pathway == null)
			clone.pathway = null;
		else
			clone.pathway = (ims.pathways.vo.PathwayLiteVo)this.pathway.clone();
		if(this.currentclock == null)
			clone.currentclock = null;
		else
			clone.currentclock = (ims.pathways.vo.RTTManagementPathwayClockVo)this.currentclock.clone();
		if(this.nextvalidationdate == null)
			clone.nextvalidationdate = null;
		else
			clone.nextvalidationdate = (ims.framework.utils.Date)this.nextvalidationdate.clone();
		if(this.clockhistory == null)
			clone.clockhistory = null;
		else
			clone.clockhistory = (ims.pathways.vo.RTTManagementPathwayClockVoCollection)this.clockhistory.clone();
		clone.referral = this.referral;
		if(this.validationcompleteddt == null)
			clone.validationcompleteddt = null;
		else
			clone.validationcompleteddt = (ims.framework.utils.DateTime)this.validationcompleteddt.clone();
		if(this.validationcompletedby == null)
			clone.validationcompletedby = null;
		else
			clone.validationcompletedby = (ims.core.vo.MemberOfStaffVo)this.validationcompletedby.clone();
		if(this.lastvalidationdate == null)
			clone.lastvalidationdate = null;
		else
			clone.lastvalidationdate = (ims.framework.utils.Date)this.lastvalidationdate.clone();
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
		if (!(RTTManagementPatientPathwayJourneyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RTTManagementPatientPathwayJourneyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RTTManagementPatientPathwayJourneyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RTTManagementPatientPathwayJourneyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pathway != null)
			count++;
		if(this.currentclock != null)
			count++;
		if(this.nextvalidationdate != null)
			count++;
		if(this.clockhistory != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.validationcompleteddt != null)
			count++;
		if(this.validationcompletedby != null)
			count++;
		if(this.lastvalidationdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.pathways.vo.PathwayLiteVo pathway;
	protected ims.pathways.vo.RTTManagementPathwayClockVo currentclock;
	protected ims.framework.utils.Date nextvalidationdate;
	protected ims.pathways.vo.RTTManagementPathwayClockVoCollection clockhistory;
	protected ims.core.admin.vo.ReferralRefVo referral;
	protected ims.framework.utils.DateTime validationcompleteddt;
	protected ims.core.vo.MemberOfStaffVo validationcompletedby;
	protected ims.framework.utils.Date lastvalidationdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}