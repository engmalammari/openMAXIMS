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

package ims.admin.vo.beans;

public class SystemLogVoBean extends ims.vo.ValueObjectBean
{
	public SystemLogVoBean()
	{
	}
	public SystemLogVoBean(ims.admin.vo.SystemLogVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.eventtype = vo.getEventType();
		this.eventlevel = vo.getEventLevel();
		this.user = vo.getUser();
		this.source = vo.getSource();
		this.computer = vo.getComputer();
		this.useragent = vo.getUserAgent();
		this.sessionid = vo.getSessionId();
		this.message = vo.getMessage();
		this.applicationserver = vo.getApplicationServer();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.SystemLogVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.eventtype = vo.getEventType();
		this.eventlevel = vo.getEventLevel();
		this.user = vo.getUser();
		this.source = vo.getSource();
		this.computer = vo.getComputer();
		this.useragent = vo.getUserAgent();
		this.sessionid = vo.getSessionId();
		this.message = vo.getMessage();
		this.applicationserver = vo.getApplicationServer();
	}

	public ims.admin.vo.SystemLogVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.SystemLogVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.SystemLogVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.SystemLogVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.SystemLogVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.eventdatetime = value;
	}
	public Integer getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(Integer value)
	{
		this.eventtype = value;
	}
	public Integer getEventLevel()
	{
		return this.eventlevel;
	}
	public void setEventLevel(Integer value)
	{
		this.eventlevel = value;
	}
	public String getUser()
	{
		return this.user;
	}
	public void setUser(String value)
	{
		this.user = value;
	}
	public String getSource()
	{
		return this.source;
	}
	public void setSource(String value)
	{
		this.source = value;
	}
	public String getComputer()
	{
		return this.computer;
	}
	public void setComputer(String value)
	{
		this.computer = value;
	}
	public String getUserAgent()
	{
		return this.useragent;
	}
	public void setUserAgent(String value)
	{
		this.useragent = value;
	}
	public String getSessionId()
	{
		return this.sessionid;
	}
	public void setSessionId(String value)
	{
		this.sessionid = value;
	}
	public String getMessage()
	{
		return this.message;
	}
	public void setMessage(String value)
	{
		this.message = value;
	}
	public String getApplicationServer()
	{
		return this.applicationserver;
	}
	public void setApplicationServer(String value)
	{
		this.applicationserver = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean eventdatetime;
	private Integer eventtype;
	private Integer eventlevel;
	private String user;
	private String source;
	private String computer;
	private String useragent;
	private String sessionid;
	private String message;
	private String applicationserver;
}
