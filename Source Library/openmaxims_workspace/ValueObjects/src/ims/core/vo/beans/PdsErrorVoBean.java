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

package ims.core.vo.beans;

public class PdsErrorVoBean extends ims.vo.ValueObjectBean
{
	public PdsErrorVoBean()
	{
	}
	public PdsErrorVoBean(ims.core.vo.PdsErrorVo vo)
	{
		this.id = vo.getId();
		this.creationtime = vo.getCreationTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationTime().getBean();
		this.interactionid = vo.getInteractionId();
		this.processingcode = vo.getProcessingCode();
		this.queryresponsecode = vo.getQueryResponseCode();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PdsErrorVo vo)
	{
		this.id = vo.getId();
		this.creationtime = vo.getCreationTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationTime().getBean();
		this.interactionid = vo.getInteractionId();
		this.processingcode = vo.getProcessingCode();
		this.queryresponsecode = vo.getQueryResponseCode();
	}

	public ims.core.vo.PdsErrorVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PdsErrorVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PdsErrorVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PdsErrorVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PdsErrorVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getId()
	{
		return this.id;
	}
	public void setId(String value)
	{
		this.id = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCreationTime()
	{
		return this.creationtime;
	}
	public void setCreationTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.creationtime = value;
	}
	public String getInteractionId()
	{
		return this.interactionid;
	}
	public void setInteractionId(String value)
	{
		this.interactionid = value;
	}
	public String getProcessingCode()
	{
		return this.processingcode;
	}
	public void setProcessingCode(String value)
	{
		this.processingcode = value;
	}
	public String getQueryResponseCode()
	{
		return this.queryresponsecode;
	}
	public void setQueryResponseCode(String value)
	{
		this.queryresponsecode = value;
	}

	private String id;
	private ims.framework.utils.beans.DateTimeBean creationtime;
	private String interactionid;
	private String processingcode;
	private String queryresponsecode;
}
