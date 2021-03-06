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

package ims.oncology.vo.beans;

public class FollowUpShortVoBean extends ims.vo.ValueObjectBean
{
	public FollowUpShortVoBean()
	{
	}
	public FollowUpShortVoBean(ims.oncology.vo.FollowUpShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentdate = vo.getAssessmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAssessmentDate().getBean();
		this.patientfollowupstatus = vo.getPatientFollowUpStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientFollowUpStatus().getBean();
		this.treatmenttype = vo.getTreatmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentType().getBean();
		this.primarytumourstatus = vo.getPrimaryTumourStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryTumourStatus().getBean();
		this.nodalstatus = vo.getNodalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNodalStatus().getBean();
		this.metastaticstatus = vo.getMetastaticStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMetastaticStatus().getBean();
		this.markerresponsestatus = vo.getMarkerResponseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMarkerResponseStatus().getBean();
		this.performancestatus = vo.getPerformanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatus().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.morbiditycodesurgery = vo.getMorbidityCodeSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeSurgery().getBean();
		this.morbiditycodecancerchemotherapy = vo.getMorbidityCodeCancerChemotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerChemotherapy().getBean();
		this.morbiditycodecancerradiotherapy = vo.getMorbidityCodeCancerRadiotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerRadiotherapy().getBean();
		this.morbiditycodecancercombination = vo.getMorbidityCodeCancerCombination() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerCombination().getBean();
		this.dyspneascore = vo.getDyspneaScore() == null ? null : (ims.vo.LookupInstanceBean)vo.getDyspneaScore().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.FollowUpShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentdate = vo.getAssessmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAssessmentDate().getBean();
		this.patientfollowupstatus = vo.getPatientFollowUpStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientFollowUpStatus().getBean();
		this.treatmenttype = vo.getTreatmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentType().getBean();
		this.primarytumourstatus = vo.getPrimaryTumourStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrimaryTumourStatus().getBean();
		this.nodalstatus = vo.getNodalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNodalStatus().getBean();
		this.metastaticstatus = vo.getMetastaticStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMetastaticStatus().getBean();
		this.markerresponsestatus = vo.getMarkerResponseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMarkerResponseStatus().getBean();
		this.performancestatus = vo.getPerformanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatus().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean(map);
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.morbiditycodesurgery = vo.getMorbidityCodeSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeSurgery().getBean();
		this.morbiditycodecancerchemotherapy = vo.getMorbidityCodeCancerChemotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerChemotherapy().getBean();
		this.morbiditycodecancerradiotherapy = vo.getMorbidityCodeCancerRadiotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerRadiotherapy().getBean();
		this.morbiditycodecancercombination = vo.getMorbidityCodeCancerCombination() == null ? null : (ims.vo.LookupInstanceBean)vo.getMorbidityCodeCancerCombination().getBean();
		this.dyspneascore = vo.getDyspneaScore() == null ? null : (ims.vo.LookupInstanceBean)vo.getDyspneaScore().getBean();
	}

	public ims.oncology.vo.FollowUpShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.FollowUpShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.FollowUpShortVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.FollowUpShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.FollowUpShortVo();
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
	public ims.framework.utils.beans.DateBean getAssessmentDate()
	{
		return this.assessmentdate;
	}
	public void setAssessmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.assessmentdate = value;
	}
	public ims.vo.LookupInstanceBean getPatientFollowUpStatus()
	{
		return this.patientfollowupstatus;
	}
	public void setPatientFollowUpStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientfollowupstatus = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentType()
	{
		return this.treatmenttype;
	}
	public void setTreatmentType(ims.vo.LookupInstanceBean value)
	{
		this.treatmenttype = value;
	}
	public ims.vo.LookupInstanceBean getPrimaryTumourStatus()
	{
		return this.primarytumourstatus;
	}
	public void setPrimaryTumourStatus(ims.vo.LookupInstanceBean value)
	{
		this.primarytumourstatus = value;
	}
	public ims.vo.LookupInstanceBean getNodalStatus()
	{
		return this.nodalstatus;
	}
	public void setNodalStatus(ims.vo.LookupInstanceBean value)
	{
		this.nodalstatus = value;
	}
	public ims.vo.LookupInstanceBean getMetastaticStatus()
	{
		return this.metastaticstatus;
	}
	public void setMetastaticStatus(ims.vo.LookupInstanceBean value)
	{
		this.metastaticstatus = value;
	}
	public ims.vo.LookupInstanceBean getMarkerResponseStatus()
	{
		return this.markerresponsestatus;
	}
	public void setMarkerResponseStatus(ims.vo.LookupInstanceBean value)
	{
		this.markerresponsestatus = value;
	}
	public ims.vo.LookupInstanceBean getPerformanceStatus()
	{
		return this.performancestatus;
	}
	public void setPerformanceStatus(ims.vo.LookupInstanceBean value)
	{
		this.performancestatus = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.seenby = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getMorbidityCodeSurgery()
	{
		return this.morbiditycodesurgery;
	}
	public void setMorbidityCodeSurgery(ims.vo.LookupInstanceBean value)
	{
		this.morbiditycodesurgery = value;
	}
	public ims.vo.LookupInstanceBean getMorbidityCodeCancerChemotherapy()
	{
		return this.morbiditycodecancerchemotherapy;
	}
	public void setMorbidityCodeCancerChemotherapy(ims.vo.LookupInstanceBean value)
	{
		this.morbiditycodecancerchemotherapy = value;
	}
	public ims.vo.LookupInstanceBean getMorbidityCodeCancerRadiotherapy()
	{
		return this.morbiditycodecancerradiotherapy;
	}
	public void setMorbidityCodeCancerRadiotherapy(ims.vo.LookupInstanceBean value)
	{
		this.morbiditycodecancerradiotherapy = value;
	}
	public ims.vo.LookupInstanceBean getMorbidityCodeCancerCombination()
	{
		return this.morbiditycodecancercombination;
	}
	public void setMorbidityCodeCancerCombination(ims.vo.LookupInstanceBean value)
	{
		this.morbiditycodecancercombination = value;
	}
	public ims.vo.LookupInstanceBean getDyspneaScore()
	{
		return this.dyspneascore;
	}
	public void setDyspneaScore(ims.vo.LookupInstanceBean value)
	{
		this.dyspneascore = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean assessmentdate;
	private ims.vo.LookupInstanceBean patientfollowupstatus;
	private ims.vo.LookupInstanceBean treatmenttype;
	private ims.vo.LookupInstanceBean primarytumourstatus;
	private ims.vo.LookupInstanceBean nodalstatus;
	private ims.vo.LookupInstanceBean metastaticstatus;
	private ims.vo.LookupInstanceBean markerresponsestatus;
	private ims.vo.LookupInstanceBean performancestatus;
	private ims.core.vo.beans.HcpLiteVoBean seenby;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.LookupInstanceBean morbiditycodesurgery;
	private ims.vo.LookupInstanceBean morbiditycodecancerchemotherapy;
	private ims.vo.LookupInstanceBean morbiditycodecancerradiotherapy;
	private ims.vo.LookupInstanceBean morbiditycodecancercombination;
	private ims.vo.LookupInstanceBean dyspneascore;
}
