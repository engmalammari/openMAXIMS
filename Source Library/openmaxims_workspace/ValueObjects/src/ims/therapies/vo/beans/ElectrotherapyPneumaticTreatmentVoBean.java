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

public class ElectrotherapyPneumaticTreatmentVoBean extends ims.vo.ValueObjectBean
{
	public ElectrotherapyPneumaticTreatmentVoBean()
	{
	}
	public ElectrotherapyPneumaticTreatmentVoBean(ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.machineused = vo.getMachineUsed() == null ? null : (ims.therapies.vo.beans.TreatmentEquipmentConfigVoBean)vo.getMachineUsed().getBean();
		this.startingposition = vo.getStartingPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getStartingPosition().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.splints = vo.getSplints() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplints().getBean();
		this.cycle = vo.getCycle() == null ? null : (ims.vo.LookupInstanceBean)vo.getCycle().getBean();
		this.duration = vo.getDuration();
		this.pressure = vo.getPressure();
		this.minpressure = vo.getMinPressure();
		this.maxpressure = vo.getMaxPressure();
		this.inflation = vo.getInflation();
		this.resttime = vo.getRestTime();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.machineused = vo.getMachineUsed() == null ? null : (ims.therapies.vo.beans.TreatmentEquipmentConfigVoBean)vo.getMachineUsed().getBean(map);
		this.startingposition = vo.getStartingPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getStartingPosition().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.splints = vo.getSplints() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplints().getBean();
		this.cycle = vo.getCycle() == null ? null : (ims.vo.LookupInstanceBean)vo.getCycle().getBean();
		this.duration = vo.getDuration();
		this.pressure = vo.getPressure();
		this.minpressure = vo.getMinPressure();
		this.maxpressure = vo.getMaxPressure();
		this.inflation = vo.getInflation();
		this.resttime = vo.getRestTime();
	}

	public ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.ElectrotherapyPneumaticTreatmentVo();
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
	public ims.therapies.vo.beans.TreatmentEquipmentConfigVoBean getMachineUsed()
	{
		return this.machineused;
	}
	public void setMachineUsed(ims.therapies.vo.beans.TreatmentEquipmentConfigVoBean value)
	{
		this.machineused = value;
	}
	public ims.vo.LookupInstanceBean getStartingPosition()
	{
		return this.startingposition;
	}
	public void setStartingPosition(ims.vo.LookupInstanceBean value)
	{
		this.startingposition = value;
	}
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public ims.vo.LookupInstanceBean getArea()
	{
		return this.area;
	}
	public void setArea(ims.vo.LookupInstanceBean value)
	{
		this.area = value;
	}
	public ims.vo.LookupInstanceBean getSplints()
	{
		return this.splints;
	}
	public void setSplints(ims.vo.LookupInstanceBean value)
	{
		this.splints = value;
	}
	public ims.vo.LookupInstanceBean getCycle()
	{
		return this.cycle;
	}
	public void setCycle(ims.vo.LookupInstanceBean value)
	{
		this.cycle = value;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.duration = value;
	}
	public Integer getPressure()
	{
		return this.pressure;
	}
	public void setPressure(Integer value)
	{
		this.pressure = value;
	}
	public Integer getMinPressure()
	{
		return this.minpressure;
	}
	public void setMinPressure(Integer value)
	{
		this.minpressure = value;
	}
	public Integer getMaxPressure()
	{
		return this.maxpressure;
	}
	public void setMaxPressure(Integer value)
	{
		this.maxpressure = value;
	}
	public Integer getInflation()
	{
		return this.inflation;
	}
	public void setInflation(Integer value)
	{
		this.inflation = value;
	}
	public Integer getRestTime()
	{
		return this.resttime;
	}
	public void setRestTime(Integer value)
	{
		this.resttime = value;
	}

	private Integer id;
	private int version;
	private ims.therapies.vo.beans.TreatmentEquipmentConfigVoBean machineused;
	private ims.vo.LookupInstanceBean startingposition;
	private ims.vo.LookupInstanceBean laterality;
	private ims.vo.LookupInstanceBean area;
	private ims.vo.LookupInstanceBean splints;
	private ims.vo.LookupInstanceBean cycle;
	private Integer duration;
	private Integer pressure;
	private Integer minpressure;
	private Integer maxpressure;
	private Integer inflation;
	private Integer resttime;
}