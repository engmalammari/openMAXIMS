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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.65 build 3210.27143)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.ocrr.domain.base.impl.BaseRejectedInvestigationDetailsImpl;
import ims.ocrr.vo.domain.OrderInvestigationLiteVoAssembler;
import ims.ocrr.vo.lookups.OrderInvStatus;

import java.util.ArrayList;
import java.util.List;

public class RejectedInvestigationDetailsImpl extends BaseRejectedInvestigationDetailsImpl
{

	private static final long serialVersionUID = 1L;

	public ims.ocrr.vo.OrderInvestigationLiteVoCollection listRejectedInvestigations(ims.careuk.vo.CatsReferralRefVo catsRefVo)
	{
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		StringBuffer sb = new StringBuffer();
		
		sb.append(" catsref.id = :idCats");
		sb.append(" and invs.ordInvCurrentStatus.ordInvStatus = :id1");
		
		markers.add("idCats");
		values.add(catsRefVo.getID_CatsReferral());
		markers.add("id1");
		values.add(getDomLookup(OrderInvStatus.REJECTED));
		
		String hql = "select invs from CatsReferral as catsref join catsref.investigationOrders as invOrd join invOrd.investigations as invs";
	
		sb.append(" and catsref.isRIE is null");
		hql += " where ";
		
		hql += sb.toString();
		hql += " order by invs.orderDetails.systemInformation.creationDateTime";

		List list = getDomainFactory().find(hql.toString(), markers, values);
		return OrderInvestigationLiteVoAssembler.createOrderInvestigationLiteVoCollectionFromOrderInvestigation(list);
	}
}