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

package ims.oncology.vo.beans;

public class InternalReferralListFilterVoBean extends ims.vo.ValueObjectBean
{
	public InternalReferralListFilterVoBean()
	{
	}
	public InternalReferralListFilterVoBean(ims.oncology.vo.InternalReferralListFilterVo vo)
	{
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.referredby = vo.getReferredBy() == null ? null : new ims.vo.RefVoBean(vo.getReferredBy().getBoId(), vo.getReferredBy().getBoVersion());
		this.activeonly = vo.getActiveOnly();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.InternalReferralListFilterVo vo)
	{
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.referredby = vo.getReferredBy() == null ? null : new ims.vo.RefVoBean(vo.getReferredBy().getBoId(), vo.getReferredBy().getBoVersion());
		this.activeonly = vo.getActiveOnly();
	}

	public ims.oncology.vo.InternalReferralListFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.InternalReferralListFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.InternalReferralListFilterVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.InternalReferralListFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.InternalReferralListFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}
	public ims.vo.LookupInstanceBean getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.vo.LookupInstanceBean value)
	{
		this.referraltype = value;
	}
	public ims.vo.RefVoBean getReferredBy()
	{
		return this.referredby;
	}
	public void setReferredBy(ims.vo.RefVoBean value)
	{
		this.referredby = value;
	}
	public Boolean getActiveOnly()
	{
		return this.activeonly;
	}
	public void setActiveOnly(Boolean value)
	{
		this.activeonly = value;
	}

	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
	private ims.vo.LookupInstanceBean referraltype;
	private ims.vo.RefVoBean referredby;
	private Boolean activeonly;
}