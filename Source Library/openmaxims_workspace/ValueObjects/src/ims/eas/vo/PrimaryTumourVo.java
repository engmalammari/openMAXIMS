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

package ims.eas.vo;

/**
 * Linked to EAS.Configuration.PrimaryTumour business object (ID: 1114100002).
 */
public class PrimaryTumourVo extends ims.eas.vo.PrimaryTumourLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPrimaryTumour
{
	private static final long serialVersionUID = 1L;

	public PrimaryTumourVo()
	{
	}
	public PrimaryTumourVo(Integer id, int version)
	{
		super(id, version);
	}
	public PrimaryTumourVo(ims.eas.vo.beans.PrimaryTumourVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.primarytumour = bean.getPrimaryTumour() == null ? null : ims.eas.vo.lookups.PrimaryTumour.buildLookup(bean.getPrimaryTumour());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.treatmentsites = ims.eas.vo.TreatmentSiteNameVoCollection.buildFromBeanCollection(bean.getTreatmentSites());
		this.clinicaltrials = ims.eas.vo.ClinicalTrialLinkVoCollection.buildFromBeanCollection(bean.getClinicalTrials());
		this.agents = ims.eas.vo.lookups.AgentsCollection.buildFromBeanCollection(bean.getAgents());
		this.defaultagent = bean.getDefaultAgent() == null ? null : ims.eas.vo.lookups.Agents.buildLookup(bean.getDefaultAgent());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.PrimaryTumourVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.primarytumour = bean.getPrimaryTumour() == null ? null : ims.eas.vo.lookups.PrimaryTumour.buildLookup(bean.getPrimaryTumour());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.treatmentsites = ims.eas.vo.TreatmentSiteNameVoCollection.buildFromBeanCollection(bean.getTreatmentSites());
		this.clinicaltrials = ims.eas.vo.ClinicalTrialLinkVoCollection.buildFromBeanCollection(bean.getClinicalTrials());
		this.agents = ims.eas.vo.lookups.AgentsCollection.buildFromBeanCollection(bean.getAgents());
		this.defaultagent = bean.getDefaultAgent() == null ? null : ims.eas.vo.lookups.Agents.buildLookup(bean.getDefaultAgent());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.PrimaryTumourVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.PrimaryTumourVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.PrimaryTumourVoBean();
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
		if(fieldName.equals("AGENTS"))
			return getAgents();
		if(fieldName.equals("DEFAULTAGENT"))
			return getDefaultAgent();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAgentsIsNotNull()
	{
		return this.agents != null;
	}
	public ims.eas.vo.lookups.AgentsCollection getAgents()
	{
		return this.agents;
	}
	public void setAgents(ims.eas.vo.lookups.AgentsCollection value)
	{
		this.isValidated = false;
		this.agents = value;
	}
	public boolean getDefaultAgentIsNotNull()
	{
		return this.defaultagent != null;
	}
	public ims.eas.vo.lookups.Agents getDefaultAgent()
	{
		return this.defaultagent;
	}
	public void setDefaultAgent(ims.eas.vo.lookups.Agents value)
	{
		this.isValidated = false;
		this.defaultagent = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	/**
	* IPrimaryTumour
	*/
		public String getName() 
		{
			return this.getPrimaryTumour().getText();
		}
		public Integer getId() 
		{
			return this.getId();
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
		if(this.treatmentsites != null)
		{
			if(!this.treatmentsites.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicaltrials != null)
		{
			if(!this.clinicaltrials.isValidated())
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
		if(this.primarytumour == null)
			listOfErrors.add("PrimaryTumour is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.treatmentsites == null || this.treatmentsites.size() == 0)
			listOfErrors.add("TreatmentSites are mandatory");
		if(this.treatmentsites != null)
		{
			String[] listOfOtherErrors = this.treatmentsites.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicaltrials != null)
		{
			String[] listOfOtherErrors = this.clinicaltrials.validate();
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
	
		PrimaryTumourVo clone = new PrimaryTumourVo(this.id, this.version);
		
		if(this.primarytumour == null)
			clone.primarytumour = null;
		else
			clone.primarytumour = (ims.eas.vo.lookups.PrimaryTumour)this.primarytumour.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.treatmentsites == null)
			clone.treatmentsites = null;
		else
			clone.treatmentsites = (ims.eas.vo.TreatmentSiteNameVoCollection)this.treatmentsites.clone();
		if(this.clinicaltrials == null)
			clone.clinicaltrials = null;
		else
			clone.clinicaltrials = (ims.eas.vo.ClinicalTrialLinkVoCollection)this.clinicaltrials.clone();
		if(this.agents == null)
			clone.agents = null;
		else
			clone.agents = (ims.eas.vo.lookups.AgentsCollection)this.agents.clone();
		if(this.defaultagent == null)
			clone.defaultagent = null;
		else
			clone.defaultagent = (ims.eas.vo.lookups.Agents)this.defaultagent.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(PrimaryTumourVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PrimaryTumourVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PrimaryTumourVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PrimaryTumourVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.agents != null)
			count++;
		if(this.defaultagent != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.eas.vo.lookups.AgentsCollection agents;
	protected ims.eas.vo.lookups.Agents defaultagent;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
