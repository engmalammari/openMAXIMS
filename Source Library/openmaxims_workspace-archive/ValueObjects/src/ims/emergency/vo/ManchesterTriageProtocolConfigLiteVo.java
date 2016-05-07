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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.emergency.vo;

/**
 * Linked to emergency.Configuration.ManchesterTriageProtocolConfiguration business object (ID: 1087100010).
 */
public class ManchesterTriageProtocolConfigLiteVo extends ims.emergency.configuration.vo.ManchesterTriageProtocolConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ManchesterTriageProtocolConfigLiteVo()
	{
	}
	public ManchesterTriageProtocolConfigLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ManchesterTriageProtocolConfigLiteVo(ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.protocoldescription = bean.getProtocolDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.protocoldescription = bean.getProtocolDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean();
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
		if(fieldName.equals("PROTOCOLNAME"))
			return getProtocolName();
		if(fieldName.equals("PROTOCOLDESCRIPTION"))
			return getProtocolDescription();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("PROBLEM"))
			return getProblem();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProtocolNameIsNotNull()
	{
		return this.protocolname != null;
	}
	public String getProtocolName()
	{
		return this.protocolname;
	}
	public static int getProtocolNameMaxLength()
	{
		return 100;
	}
	public void setProtocolName(String value)
	{
		this.isValidated = false;
		this.protocolname = value;
	}
	public boolean getProtocolDescriptionIsNotNull()
	{
		return this.protocoldescription != null;
	}
	public String getProtocolDescription()
	{
		return this.protocoldescription;
	}
	public static int getProtocolDescriptionMaxLength()
	{
		return 500;
	}
	public void setProtocolDescription(String value)
	{
		this.isValidated = false;
		this.protocoldescription = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getProblemIsNotNull()
	{
		return this.problem != null;
	}
	public ims.clinical.vo.ClinicalProblemShortVo getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.clinical.vo.ClinicalProblemShortVo value)
	{
		this.isValidated = false;
		this.problem = value;
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
		if(this.protocolname == null || this.protocolname.length() == 0)
			listOfErrors.add("ProtocolName is mandatory");
		else if(this.protocolname.length() > 100)
			listOfErrors.add("The length of the field [protocolname] in the value object [ims.emergency.vo.ManchesterTriageProtocolConfigLiteVo] is too big. It should be less or equal to 100");
		if(this.protocoldescription == null || this.protocoldescription.length() == 0)
			listOfErrors.add("ProtocolDescription is mandatory");
		else if(this.protocoldescription.length() > 500)
			listOfErrors.add("The length of the field [protocoldescription] in the value object [ims.emergency.vo.ManchesterTriageProtocolConfigLiteVo] is too big. It should be less or equal to 500");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.problem == null)
			listOfErrors.add("Problem is mandatory");
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
	
		ManchesterTriageProtocolConfigLiteVo clone = new ManchesterTriageProtocolConfigLiteVo(this.id, this.version);
		
		clone.protocolname = this.protocolname;
		clone.protocoldescription = this.protocoldescription;
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.problem == null)
			clone.problem = null;
		else
			clone.problem = (ims.clinical.vo.ClinicalProblemShortVo)this.problem.clone();
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
		if (!(ManchesterTriageProtocolConfigLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ManchesterTriageProtocolConfigLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ManchesterTriageProtocolConfigLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ManchesterTriageProtocolConfigLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.protocolname != null)
			count++;
		if(this.protocoldescription != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.problem != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String protocolname;
	protected String protocoldescription;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.clinical.vo.ClinicalProblemShortVo problem;
	private boolean isValidated = false;
	private boolean isBusy = false;
}