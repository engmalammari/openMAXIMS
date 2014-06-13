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

package ims.therapies.vo.beans;

public class RoomDetailsVoBean extends ims.vo.ValueObjectBean
{
	public RoomDetailsVoBean()
	{
	}
	public RoomDetailsVoBean(ims.therapies.vo.RoomDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocation().getBean();
		this.access = vo.getAccess();
		this.doorwidth = vo.getDoorWidth();
		this.roomdetails = vo.getRoomDetails();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
		this.homevisitroomtype = vo.getHomeVisitRoomType() == null ? null : (ims.vo.LookupInstanceBean)vo.getHomeVisitRoomType().getBean();
		this.environmentvisitroomtype = vo.getEnvironmentVisitRoomType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEnvironmentVisitRoomType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.RoomDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocation().getBean();
		this.access = vo.getAccess();
		this.doorwidth = vo.getDoorWidth();
		this.roomdetails = vo.getRoomDetails();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
		this.homevisitroomtype = vo.getHomeVisitRoomType() == null ? null : (ims.vo.LookupInstanceBean)vo.getHomeVisitRoomType().getBean();
		this.environmentvisitroomtype = vo.getEnvironmentVisitRoomType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEnvironmentVisitRoomType().getBean();
	}

	public ims.therapies.vo.RoomDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.RoomDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.RoomDetailsVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.RoomDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.RoomDetailsVo();
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
	public ims.vo.LookupInstanceBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.vo.LookupInstanceBean value)
	{
		this.location = value;
	}
	public String getAccess()
	{
		return this.access;
	}
	public void setAccess(String value)
	{
		this.access = value;
	}
	public Integer getDoorWidth()
	{
		return this.doorwidth;
	}
	public void setDoorWidth(Integer value)
	{
		this.doorwidth = value;
	}
	public String getRoomDetails()
	{
		return this.roomdetails;
	}
	public void setRoomDetails(String value)
	{
		this.roomdetails = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.LookupInstanceBean getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.vo.LookupInstanceBean value)
	{
		this.unitofmeasure = value;
	}
	public ims.vo.LookupInstanceBean getHomeVisitRoomType()
	{
		return this.homevisitroomtype;
	}
	public void setHomeVisitRoomType(ims.vo.LookupInstanceBean value)
	{
		this.homevisitroomtype = value;
	}
	public ims.vo.LookupInstanceBean getEnvironmentVisitRoomType()
	{
		return this.environmentvisitroomtype;
	}
	public void setEnvironmentVisitRoomType(ims.vo.LookupInstanceBean value)
	{
		this.environmentvisitroomtype = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean location;
	private String access;
	private Integer doorwidth;
	private String roomdetails;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.LookupInstanceBean unitofmeasure;
	private ims.vo.LookupInstanceBean homevisitroomtype;
	private ims.vo.LookupInstanceBean environmentvisitroomtype;
}