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

package ims.admin.vo.beans;

public class Icd10AmProcVoBean extends ims.vo.ValueObjectBean
{
	public Icd10AmProcVoBean()
	{
	}
	public Icd10AmProcVoBean(ims.admin.vo.Icd10AmProcVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.code_id = vo.getCode_id();
		this.block = vo.getBlock() == null ? null : (ims.admin.vo.beans.Icd10AmBlockVoBean)vo.getBlock().getBean();
		this.ascii_desc = vo.getAscii_desc();
		this.ascii_short_desc = vo.getAscii_short_desc();
		this.effective_from = vo.getEffective_from() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffective_from().getBean();
		this.inactive = vo.getInactive() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInactive().getBean();
		this.sex = vo.getSex();
		this.stype = vo.getStype();
		this.agel = vo.getAgeL();
		this.agelh = vo.getAgelH();
		this.atype = vo.getAtype();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.Icd10AmProcVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.code_id = vo.getCode_id();
		this.block = vo.getBlock() == null ? null : (ims.admin.vo.beans.Icd10AmBlockVoBean)vo.getBlock().getBean(map);
		this.ascii_desc = vo.getAscii_desc();
		this.ascii_short_desc = vo.getAscii_short_desc();
		this.effective_from = vo.getEffective_from() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffective_from().getBean();
		this.inactive = vo.getInactive() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInactive().getBean();
		this.sex = vo.getSex();
		this.stype = vo.getStype();
		this.agel = vo.getAgeL();
		this.agelh = vo.getAgelH();
		this.atype = vo.getAtype();
	}

	public ims.admin.vo.Icd10AmProcVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.Icd10AmProcVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.Icd10AmProcVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.Icd10AmProcVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.Icd10AmProcVo();
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
	public String getCode_id()
	{
		return this.code_id;
	}
	public void setCode_id(String value)
	{
		this.code_id = value;
	}
	public ims.admin.vo.beans.Icd10AmBlockVoBean getBlock()
	{
		return this.block;
	}
	public void setBlock(ims.admin.vo.beans.Icd10AmBlockVoBean value)
	{
		this.block = value;
	}
	public String getAscii_desc()
	{
		return this.ascii_desc;
	}
	public void setAscii_desc(String value)
	{
		this.ascii_desc = value;
	}
	public String getAscii_short_desc()
	{
		return this.ascii_short_desc;
	}
	public void setAscii_short_desc(String value)
	{
		this.ascii_short_desc = value;
	}
	public ims.framework.utils.beans.DateBean getEffective_from()
	{
		return this.effective_from;
	}
	public void setEffective_from(ims.framework.utils.beans.DateBean value)
	{
		this.effective_from = value;
	}
	public ims.framework.utils.beans.DateBean getInactive()
	{
		return this.inactive;
	}
	public void setInactive(ims.framework.utils.beans.DateBean value)
	{
		this.inactive = value;
	}
	public Integer getSex()
	{
		return this.sex;
	}
	public void setSex(Integer value)
	{
		this.sex = value;
	}
	public Integer getStype()
	{
		return this.stype;
	}
	public void setStype(Integer value)
	{
		this.stype = value;
	}
	public Integer getAgeL()
	{
		return this.agel;
	}
	public void setAgeL(Integer value)
	{
		this.agel = value;
	}
	public Integer getAgelH()
	{
		return this.agelh;
	}
	public void setAgelH(Integer value)
	{
		this.agelh = value;
	}
	public Integer getAtype()
	{
		return this.atype;
	}
	public void setAtype(Integer value)
	{
		this.atype = value;
	}

	private Integer id;
	private int version;
	private String code_id;
	private ims.admin.vo.beans.Icd10AmBlockVoBean block;
	private String ascii_desc;
	private String ascii_short_desc;
	private ims.framework.utils.beans.DateBean effective_from;
	private ims.framework.utils.beans.DateBean inactive;
	private Integer sex;
	private Integer stype;
	private Integer agel;
	private Integer agelh;
	private Integer atype;
}