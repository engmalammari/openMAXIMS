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

package ims.core.vo;


public class WardTransferDetailsForConsultantStayVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardTransferDetailsForConsultantStayVo()
	{
	}
	public WardTransferDetailsForConsultantStayVo(ims.core.vo.beans.WardTransferDetailsForConsultantStayVoBean bean)
	{
		this.wardstaydetails = bean.getWardStayDetails() == null ? null : bean.getWardStayDetails().buildVo();
		this.transferdetails = bean.getTransferDetails() == null ? null : bean.getTransferDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardTransferDetailsForConsultantStayVoBean bean)
	{
		this.wardstaydetails = bean.getWardStayDetails() == null ? null : bean.getWardStayDetails().buildVo(map);
		this.transferdetails = bean.getTransferDetails() == null ? null : bean.getTransferDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardTransferDetailsForConsultantStayVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardTransferDetailsForConsultantStayVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardTransferDetailsForConsultantStayVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getWardStayDetailsIsNotNull()
	{
		return this.wardstaydetails != null;
	}
	public ims.RefMan.vo.WardStayForPatientCodingListVo getWardStayDetails()
	{
		return this.wardstaydetails;
	}
	public void setWardStayDetails(ims.RefMan.vo.WardStayForPatientCodingListVo value)
	{
		this.isValidated = false;
		this.wardstaydetails = value;
	}
	public boolean getTransferDetailsIsNotNull()
	{
		return this.transferdetails != null;
	}
	public ims.core.vo.TransferHistoryVo getTransferDetails()
	{
		return this.transferdetails;
	}
	public void setTransferDetails(ims.core.vo.TransferHistoryVo value)
	{
		this.isValidated = false;
		this.transferdetails = value;
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
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof WardTransferDetailsForConsultantStayVo))
			return false;
		WardTransferDetailsForConsultantStayVo compareObj = (WardTransferDetailsForConsultantStayVo)obj;
		if(this.getWardStayDetails() == null && compareObj.getWardStayDetails() != null)
			return false;
		if(this.getWardStayDetails() != null && compareObj.getWardStayDetails() == null)
			return false;
		if(this.getWardStayDetails() != null && compareObj.getWardStayDetails() != null)
			if(!this.getWardStayDetails().equals(compareObj.getWardStayDetails()))
				return false;
		if(this.getTransferDetails() == null && compareObj.getTransferDetails() != null)
			return false;
		if(this.getTransferDetails() != null && compareObj.getTransferDetails() == null)
			return false;
		if(this.getTransferDetails() != null && compareObj.getTransferDetails() != null)
			return this.getTransferDetails().equals(compareObj.getTransferDetails());
		return super.equals(obj);
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
	
		WardTransferDetailsForConsultantStayVo clone = new WardTransferDetailsForConsultantStayVo();
		
		if(this.wardstaydetails == null)
			clone.wardstaydetails = null;
		else
			clone.wardstaydetails = (ims.RefMan.vo.WardStayForPatientCodingListVo)this.wardstaydetails.clone();
		if(this.transferdetails == null)
			clone.transferdetails = null;
		else
			clone.transferdetails = (ims.core.vo.TransferHistoryVo)this.transferdetails.clone();
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
		if (!(WardTransferDetailsForConsultantStayVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardTransferDetailsForConsultantStayVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardTransferDetailsForConsultantStayVo compareObj = (WardTransferDetailsForConsultantStayVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWardStayDetails() == null && compareObj.getWardStayDetails() != null)
				return -1;
			if(this.getWardStayDetails() != null && compareObj.getWardStayDetails() == null)
				return 1;
			if(this.getWardStayDetails() != null && compareObj.getWardStayDetails() != null)
				retVal = this.getWardStayDetails().compareTo(compareObj.getWardStayDetails());
		}
		if (retVal == 0)
		{
			if(this.getTransferDetails() == null && compareObj.getTransferDetails() != null)
				return -1;
			if(this.getTransferDetails() != null && compareObj.getTransferDetails() == null)
				return 1;
			if(this.getTransferDetails() != null && compareObj.getTransferDetails() != null)
				retVal = this.getTransferDetails().compareTo(compareObj.getTransferDetails());
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
		if(this.wardstaydetails != null)
			count++;
		if(this.transferdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.RefMan.vo.WardStayForPatientCodingListVo wardstaydetails;
	protected ims.core.vo.TransferHistoryVo transferdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
