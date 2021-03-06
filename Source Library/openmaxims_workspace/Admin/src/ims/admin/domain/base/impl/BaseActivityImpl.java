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

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseActivityImpl extends DomainImpl implements ims.admin.domain.Activity, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistActivities(Boolean bActive)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAlert(ims.ntpf.vo.CodingAlertConfigurationVo alertVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetActivity(Integer activityId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistStaff(ims.core.vo.MemberOfStaffShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAlert(ims.core.vo.ActivityVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveActivity(ims.core.vo.ActivityVo activityVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSchedActivity(ims.core.vo.ActivitySchedVo activity)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistNTPFActivities(Boolean isActive, ims.vo.LookupInstanceCollection activityTypeInstancesToExclude)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSchedActivities(Boolean isActive)
	{
	}
}
