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
 * Linked to EAS.ElectronicActionSheet business object (ID: 1113100000).
 */
public class DiagnosticImageTransferVo extends ims.eas.vo.ElectronicActionSheetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DiagnosticImageTransferVo()
	{
	}
	public DiagnosticImageTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public DiagnosticImageTransferVo(ims.eas.vo.beans.DiagnosticImageTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.imagetransfer = bean.getImageTransfer() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getImageTransfer());
		this.easstatus = bean.getEASStatus() == null ? null : bean.getEASStatus().buildVo();
		this.removedstat = bean.getRemovedStat();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.DiagnosticImageTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.imagetransfer = bean.getImageTransfer() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getImageTransfer());
		this.easstatus = bean.getEASStatus() == null ? null : bean.getEASStatus().buildVo(map);
		this.removedstat = bean.getRemovedStat();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.DiagnosticImageTransferVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.DiagnosticImageTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.DiagnosticImageTransferVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("DATESEEN"))
			return getDateSeen();
		if(fieldName.equals("DATEDECISIONTOTREAT"))
			return getDateDecisionToTreat();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("IMAGETRANSFER"))
			return getImageTransfer();
		if(fieldName.equals("EASSTATUS"))
			return getEASStatus();
		if(fieldName.equals("REMOVEDSTAT"))
			return getRemovedStat();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getDateSeenIsNotNull()
	{
		return this.dateseen != null;
	}
	public ims.framework.utils.Date getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateseen = value;
	}
	public boolean getDateDecisionToTreatIsNotNull()
	{
		return this.datedecisiontotreat != null;
	}
	public ims.framework.utils.Date getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datedecisiontotreat = value;
	}
	public boolean getSeenByIsNotNull()
	{
		return this.seenby != null;
	}
	public ims.core.vo.HcpLiteVo getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.seenby = value;
	}
	public boolean getImageTransferIsNotNull()
	{
		return this.imagetransfer != null;
	}
	public ims.core.vo.lookups.YesNo getImageTransfer()
	{
		return this.imagetransfer;
	}
	public void setImageTransfer(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.imagetransfer = value;
	}
	public boolean getEASStatusIsNotNull()
	{
		return this.easstatus != null;
	}
	public ims.eas.vo.EasStatusLiteVo getEASStatus()
	{
		return this.easstatus;
	}
	public void setEASStatus(ims.eas.vo.EasStatusLiteVo value)
	{
		this.isValidated = false;
		this.easstatus = value;
	}
	public boolean getRemovedStatIsNotNull()
	{
		return this.removedstat != null;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.isValidated = false;
		this.removedstat = value;
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
		if(this.easstatus != null)
		{
			if(!this.easstatus.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.dateseen == null)
			listOfErrors.add("DateSeen is mandatory");
		if(this.datedecisiontotreat == null)
			listOfErrors.add("DateDecisionToTreat is mandatory");
		if(this.seenby == null)
			listOfErrors.add("SeenBy is mandatory");
		if(this.imagetransfer == null)
			listOfErrors.add("ImageTransfer is mandatory");
		if(this.easstatus == null)
			listOfErrors.add("EasStatus is mandatory");
		if(this.easstatus != null)
		{
			String[] listOfOtherErrors = this.easstatus.validate();
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
	
		DiagnosticImageTransferVo clone = new DiagnosticImageTransferVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.dateseen == null)
			clone.dateseen = null;
		else
			clone.dateseen = (ims.framework.utils.Date)this.dateseen.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.core.vo.HcpLiteVo)this.seenby.clone();
		if(this.imagetransfer == null)
			clone.imagetransfer = null;
		else
			clone.imagetransfer = (ims.core.vo.lookups.YesNo)this.imagetransfer.clone();
		if(this.easstatus == null)
			clone.easstatus = null;
		else
			clone.easstatus = (ims.eas.vo.EasStatusLiteVo)this.easstatus.clone();
		clone.removedstat = this.removedstat;
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
		if (!(DiagnosticImageTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiagnosticImageTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DiagnosticImageTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DiagnosticImageTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.dateseen != null)
			count++;
		if(this.datedecisiontotreat != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.imagetransfer != null)
			count++;
		if(this.easstatus != null)
			count++;
		if(this.removedstat != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.framework.utils.Date dateseen;
	protected ims.framework.utils.Date datedecisiontotreat;
	protected ims.core.vo.HcpLiteVo seenby;
	protected ims.core.vo.lookups.YesNo imagetransfer;
	protected ims.eas.vo.EasStatusLiteVo easstatus;
	protected Boolean removedstat;
	private boolean isValidated = false;
	private boolean isBusy = false;
}