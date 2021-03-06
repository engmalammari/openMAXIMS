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


public class ChartValueVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IChartValue
{
	private static final long serialVersionUID = 1L;

	public ChartValueVo()
	{
	}
	public ChartValueVo(ims.core.vo.beans.ChartValueVoBean bean)
	{
		this.value = bean.getValue();
		this.isabnormal = bean.getIsAbnormal();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDateTime();
		this.comments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getComments());
		this.istimesuplied = bean.getIsTimeSuplied();
		this.investigationcomments = bean.getInvestigationComments() == null ? null : bean.getInvestigationComments().buildVo();
		this.specimencomments = bean.getSpecimenComments() == null ? null : bean.getSpecimenComments().buildVo();
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.isreceiveddatetime = bean.getIsReceivedDateTime();
		this.valuestring = bean.getValueString();
		this.refrange = bean.getRefRange();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartValueVoBean bean)
	{
		this.value = bean.getValue();
		this.isabnormal = bean.getIsAbnormal();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDateTime();
		this.comments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getComments());
		this.istimesuplied = bean.getIsTimeSuplied();
		this.investigationcomments = bean.getInvestigationComments() == null ? null : bean.getInvestigationComments().buildVo(map);
		this.specimencomments = bean.getSpecimenComments() == null ? null : bean.getSpecimenComments().buildVo(map);
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.isreceiveddatetime = bean.getIsReceivedDateTime();
		this.valuestring = bean.getValueString();
		this.refrange = bean.getRefRange();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartValueVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartValueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartValueVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getValueIsNotNull()
	{
		return this.value != null;
	}
	public Float getValue()
	{
		return this.value;
	}
	public void setValue(Float value)
	{
		this.isValidated = false;
		this.value = value;
	}
	public boolean getIsAbnormalIsNotNull()
	{
		return this.isabnormal != null;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isValidated = false;
		this.isabnormal = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.DateTime getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public ims.core.vo.ChartValueCommentVoCollection getComments()
	{
		return this.comments;
	}
	public void setComments(ims.core.vo.ChartValueCommentVoCollection value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getIsTimeSupliedIsNotNull()
	{
		return this.istimesuplied != null;
	}
	public Boolean getIsTimeSuplied()
	{
		return this.istimesuplied;
	}
	public void setIsTimeSuplied(Boolean value)
	{
		this.isValidated = false;
		this.istimesuplied = value;
	}
	public boolean getInvestigationCommentsIsNotNull()
	{
		return this.investigationcomments != null;
	}
	public ims.core.vo.ChartInvestigationCommentsVo getInvestigationComments()
	{
		return this.investigationcomments;
	}
	public void setInvestigationComments(ims.core.vo.ChartInvestigationCommentsVo value)
	{
		this.isValidated = false;
		this.investigationcomments = value;
	}
	public boolean getSpecimenCommentsIsNotNull()
	{
		return this.specimencomments != null;
	}
	public ims.core.vo.ChartSpecimenCommentsVo getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.core.vo.ChartSpecimenCommentsVo value)
	{
		this.isValidated = false;
		this.specimencomments = value;
	}
	public boolean getResultSpecimenTypeIsNotNull()
	{
		return this.resultspecimentype != null;
	}
	public ims.vo.LookupInstVo getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstVo value)
	{
		this.isValidated = false;
		this.resultspecimentype = value;
	}
	public boolean getSpecimenSourceIsNotNull()
	{
		return this.specimensource != null;
	}
	public ims.ocrr.vo.lookups.SpecimenType getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.ocrr.vo.lookups.SpecimenType value)
	{
		this.isValidated = false;
		this.specimensource = value;
	}
	public boolean getIsReceivedDateTimeIsNotNull()
	{
		return this.isreceiveddatetime != null;
	}
	public Boolean getIsReceivedDateTime()
	{
		return this.isreceiveddatetime;
	}
	public void setIsReceivedDateTime(Boolean value)
	{
		this.isValidated = false;
		this.isreceiveddatetime = value;
	}
	public boolean getValueStringIsNotNull()
	{
		return this.valuestring != null;
	}
	public String getValueString()
	{
		return this.valuestring;
	}
	public static int getValueStringMaxLength()
	{
		return 255;
	}
	public void setValueString(String value)
	{
		this.isValidated = false;
		this.valuestring = value;
	}
	public boolean getRefRangeIsNotNull()
	{
		return this.refrange != null;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public static int getRefRangeMaxLength()
	{
		return 255;
	}
	public void setRefRange(String value)
	{
		this.isValidated = false;
		this.refrange = value;
	}
	public boolean getUnitOfMeasureIsNotNull()
	{
		return this.unitofmeasure != null;
	}
	public ims.ocrr.vo.lookups.ResultUnitOfMeasure getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.ocrr.vo.lookups.ResultUnitOfMeasure value)
	{
		this.isValidated = false;
		this.unitofmeasure = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Chart Value: ");
		if(this.value != null)
			sb.append(this.value);
		return sb.toString();
	}
	/**
	* IChartValue methods
	*/
	public String getIChartValue()
	{
		if (value != null)
			return value.toString();
		else
			return valuestring;
	}
	public Float getIChartValueValue() 
	{		
		return getValue();
	}
	public Boolean getIChartValueIsAbnormal() 
	{
		return getIsAbnormal();
	}
	public ims.framework.utils.DateTime getIChartValueDateTime() 
	{
		return getDate();
	}
	public Boolean getIChartValueTimeSupplied()
	{
		return getIsTimeSuplied();
	}
	public ims.vo.interfaces.IChartValueComment[] getIChartValueComments()
	{
		if(comments == null)
			return new ims.vo.interfaces.IChartValueComment[0];
		ims.vo.interfaces.IChartValueComment[] result = new ims.vo.interfaces.IChartValueComment[comments.size()];
		for(int x = 0; x < comments.size(); x++)
		{
			result[x] = comments.get(x);		
		}
			
		return result;
	}
	
	public ims.vo.interfaces.IChartValueInvestigation getIChartValueInvestigation()
	{
		return investigationcomments;
	}
	public ims.vo.interfaces.IChartValueComment[] getIChartValueInvestigationComments()
	{
		if (investigationcomments == null)
			return null;
		
		if (investigationcomments.getInvestigationComments() == null)
			return null;
		
		ims.vo.interfaces.IChartValueComment[] result = new ims.vo.interfaces.IChartValueComment[investigationcomments.getInvestigationComments().size()];
		
		for (int x = 0; x < investigationcomments.getInvestigationComments().size(); x++)
		{
			result[x] = investigationcomments.getInvestigationComments().get(x);
		}
		
		return result;
	}
	public String getIChartValueInvestigationName()
	{
		if (investigationcomments == null)
			return null;
		
		return investigationcomments.getInvestigationName();
	}
	public String getIChartValueLabOrder()
	{
		if (investigationcomments == null)
			return null;
			
		return investigationcomments.getLabOrderNo();
	}
	public ims.framework.utils.DateTime getIChartValueDisplayDate()
	{
		if (investigationcomments == null)
			return null;
			
		return investigationcomments.getDate();
	}
	public String getIChartValueDisplayFlag()
	{
		if (investigationcomments == null)
			return null;
			
		return investigationcomments.getDisplayFlag();
	}
	public ims.vo.interfaces.IChartValueComment[] getIChartValueSpecimenComments()
	{
		if (specimencomments == null)
			return null;
		
		if (specimencomments.getSpecimenComments() == null)
			return null;
		
		ims.vo.interfaces.IChartValueComment[] result = new ims.vo.interfaces.IChartValueComment[specimencomments.getSpecimenComments().size()];
		
		for (int x = 0; x < specimencomments.getSpecimenComments().size(); x++)
		{
			result[x] = specimencomments.getSpecimenComments().get(x);
		}
		
		return result;
	}
	public String getIChartValueSpecimenType()
	{
		if (specimencomments == null)
			return null;
		
		return specimencomments.getSpecimenType();
	}
	
	public String getIChartValueLabSpecimentType()
	{
		if (resultspecimentype == null)
			return null;
		
		return resultspecimentype.getText();
	}
	public ims.ocrr.vo.lookups.SpecimenType getIChartValueOrderSpecimen()
	{
		return this.specimensource;
	}
	public ims.vo.LookupInstVo getIChartValueLabSpecimen()
	{
		return this.resultspecimentype;
	}
	public Boolean getIChartValueIsReceivedDateTime()
	{
		return this.isreceiveddatetime;
	}
	public String getIChartValueRefRange()
	{
		return refrange;
	}
	public ims.ocrr.vo.lookups.ResultUnitOfMeasure getIChartValueUnitOfMeasure()
	{
		return this.unitofmeasure;
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
		if(this.value == null)
			listOfErrors.add("Chart value is invalid");
		if(this.isabnormal == null)
			listOfErrors.add("Chart value abnormal flag is invalid");
		if(this.date == null)
			listOfErrors.add("Chart value date is invalid");
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
	
		ChartValueVo clone = new ChartValueVo();
		
		clone.value = this.value;
		clone.isabnormal = this.isabnormal;
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.DateTime)this.date.clone();
		if(this.comments == null)
			clone.comments = null;
		else
			clone.comments = (ims.core.vo.ChartValueCommentVoCollection)this.comments.clone();
		clone.istimesuplied = this.istimesuplied;
		if(this.investigationcomments == null)
			clone.investigationcomments = null;
		else
			clone.investigationcomments = (ims.core.vo.ChartInvestigationCommentsVo)this.investigationcomments.clone();
		if(this.specimencomments == null)
			clone.specimencomments = null;
		else
			clone.specimencomments = (ims.core.vo.ChartSpecimenCommentsVo)this.specimencomments.clone();
		clone.resultspecimentype = this.resultspecimentype;
		if(this.specimensource == null)
			clone.specimensource = null;
		else
			clone.specimensource = (ims.ocrr.vo.lookups.SpecimenType)this.specimensource.clone();
		clone.isreceiveddatetime = this.isreceiveddatetime;
		clone.valuestring = this.valuestring;
		clone.refrange = this.refrange;
		if(this.unitofmeasure == null)
			clone.unitofmeasure = null;
		else
			clone.unitofmeasure = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)this.unitofmeasure.clone();
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
		if (!(ChartValueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartValueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartValueVo compareObj = (ChartValueVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getValue() == null && compareObj.getValue() != null)
				return -1;
			if(this.getValue() != null && compareObj.getValue() == null)
				return 1;
			if(this.getValue() != null && compareObj.getValue() != null)
				retVal = this.getValue().compareTo(compareObj.getValue());
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
		if(this.value != null)
			count++;
		if(this.isabnormal != null)
			count++;
		if(this.date != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.istimesuplied != null)
			count++;
		if(this.investigationcomments != null)
			count++;
		if(this.specimencomments != null)
			count++;
		if(this.resultspecimentype != null)
			count++;
		if(this.specimensource != null)
			count++;
		if(this.isreceiveddatetime != null)
			count++;
		if(this.valuestring != null)
			count++;
		if(this.refrange != null)
			count++;
		if(this.unitofmeasure != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected Float value;
	protected Boolean isabnormal;
	protected ims.framework.utils.DateTime date;
	protected ims.core.vo.ChartValueCommentVoCollection comments;
	protected Boolean istimesuplied;
	protected ims.core.vo.ChartInvestigationCommentsVo investigationcomments;
	protected ims.core.vo.ChartSpecimenCommentsVo specimencomments;
	protected ims.vo.LookupInstVo resultspecimentype;
	protected ims.ocrr.vo.lookups.SpecimenType specimensource;
	protected Boolean isreceiveddatetime;
	protected String valuestring;
	protected String refrange;
	protected ims.ocrr.vo.lookups.ResultUnitOfMeasure unitofmeasure;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
