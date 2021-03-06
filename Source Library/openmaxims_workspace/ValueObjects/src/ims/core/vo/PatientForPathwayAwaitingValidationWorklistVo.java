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

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientForPathwayAwaitingValidationWorklistVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientForPathwayAwaitingValidationWorklistVo()
	{
	}
	public PatientForPathwayAwaitingValidationWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientForPathwayAwaitingValidationWorklistVo(ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientForPathwayAwaitingValidationWorklistVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("IDENTIFIERS"))
			return getIdentifiers();
		if(fieldName.equals("SEX"))
			return getSex();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getIdentifiersIsNotNull()
	{
		return this.identifiers != null;
	}
	public ims.core.vo.PatientIdCollection getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.identifiers = value;
	}
	public boolean getSexIsNotNull()
	{
		return this.sex != null;
	}
	public ims.core.vo.lookups.Sex getSex()
	{
		return this.sex;
	}
	public void setSex(ims.core.vo.lookups.Sex value)
	{
		this.isValidated = false;
		this.sex = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.PersonAddress getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.PersonAddress value)
	{
		this.isValidated = false;
		this.address = value;
	}
	/**
	* getDisplayId
	*/
	public ims.core.vo.PatientId getDisplayId()
	{
		String name = ims.configuration.ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue();
		ims.core.vo.lookups.PatIdType type = ims.core.vo.lookups.PatIdType.getNegativeInstance(name);
		
		if (type == null) type = ims.core.vo.lookups.PatIdType.HOSPNUM;
		return getPatientID(type);
	}
	/**
	* getNHSNo
	*/
	public ims.core.vo.PatientId getNHSNo()
	{
		return getPatientID(ims.core.vo.lookups.PatIdType.NHSN);
	}
	/**
	* getHospitalNo
	*/
	public ims.core.vo.PatientId getHospitalNo()
	{
		return getPatientID(ims.core.vo.lookups.PatIdType.HOSPNUM);
	}
	
	/**
	* getPatientID
	*/
	public ims.core.vo.PatientId getPatientID(ims.core.vo.lookups.PatIdType idType)
	{
		if (identifiers == null) return null;
		for (int i = 0; i < identifiers.size(); i++)
		{
			ims.core.vo.PatientId id = identifiers.get(i);
			if (id.getType().equals(idType))
			{
				return id;
			}
		}
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.identifiers != null)
		{
			if(!this.identifiers.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.identifiers != null)
		{
			String[] listOfOtherErrors = this.identifiers.validate();
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
	
		PatientForPathwayAwaitingValidationWorklistVo clone = new PatientForPathwayAwaitingValidationWorklistVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
		if(this.sex == null)
			clone.sex = null;
		else
			clone.sex = (ims.core.vo.lookups.Sex)this.sex.clone();
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.PersonAddress)this.address.clone();
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
		if (!(PatientForPathwayAwaitingValidationWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientForPathwayAwaitingValidationWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientForPathwayAwaitingValidationWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientForPathwayAwaitingValidationWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.identifiers != null)
			count++;
		if(this.sex != null)
			count++;
		if(this.address != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.PersonName name;
	protected ims.core.vo.PatientIdCollection identifiers;
	protected ims.core.vo.lookups.Sex sex;
	protected ims.core.vo.PersonAddress address;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
