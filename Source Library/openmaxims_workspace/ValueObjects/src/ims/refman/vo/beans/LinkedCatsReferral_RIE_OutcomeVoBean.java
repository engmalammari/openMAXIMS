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

package ims.RefMan.vo.beans;

public class LinkedCatsReferral_RIE_OutcomeVoBean extends ims.vo.ValueObjectBean
{
	public LinkedCatsReferral_RIE_OutcomeVoBean()
	{
	}
	public LinkedCatsReferral_RIE_OutcomeVoBean(ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferral_RIE_OutcomeVoBean)vo.getReferral().getBean();
		this.referralrelationtype = vo.getReferralRelationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralRelationType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferral_RIE_OutcomeVoBean)vo.getReferral().getBean(map);
		this.referralrelationtype = vo.getReferralRelationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralRelationType().getBean();
	}

	public ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.LinkedCatsReferral_RIE_OutcomeVo();
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
	public ims.RefMan.vo.beans.CatsReferral_RIE_OutcomeVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.beans.CatsReferral_RIE_OutcomeVoBean value)
	{
		this.referral = value;
	}
	public ims.vo.LookupInstanceBean getReferralRelationType()
	{
		return this.referralrelationtype;
	}
	public void setReferralRelationType(ims.vo.LookupInstanceBean value)
	{
		this.referralrelationtype = value;
	}

	private Integer id;
	private int version;
	private ims.RefMan.vo.beans.CatsReferral_RIE_OutcomeVoBean referral;
	private ims.vo.LookupInstanceBean referralrelationtype;
}