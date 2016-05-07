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

package ims.ocrr.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class OrderMessageStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public OrderMessageStatus()
	{
		super();
	}
	public OrderMessageStatus(int id)
	{
		super(id, "", true);
	}
	public OrderMessageStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public OrderMessageStatus(int id, String text, boolean active, OrderMessageStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public OrderMessageStatus(int id, String text, boolean active, OrderMessageStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public OrderMessageStatus(int id, String text, boolean active, OrderMessageStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static OrderMessageStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new OrderMessageStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (OrderMessageStatus)super.getParentInstance();
	}
	public OrderMessageStatus getParent()
	{
		return (OrderMessageStatus)super.getParentInstance();
	}
	public void setParent(OrderMessageStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		OrderMessageStatus[] typedChildren = new OrderMessageStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (OrderMessageStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof OrderMessageStatus)
		{
			super.addChild((OrderMessageStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof OrderMessageStatus)
		{
			super.removeChild((OrderMessageStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		OrderMessageStatusCollection result = new OrderMessageStatusCollection();
		result.add(CREATED);
		result.add(SENT);
		result.add(FAILED);
		result.add(PENDING);
		result.add(CANCEL_REQUEST);
		result.add(CANCELLED_BY_PLACER);
		result.add(CANCELLED_BY_FILLER);
		result.add(RESPONDED);
		return result;
	}
	public static OrderMessageStatus[] getNegativeInstances()
	{
		OrderMessageStatus[] instances = new OrderMessageStatus[8];
		instances[0] = CREATED;
		instances[1] = SENT;
		instances[2] = FAILED;
		instances[3] = PENDING;
		instances[4] = CANCEL_REQUEST;
		instances[5] = CANCELLED_BY_PLACER;
		instances[6] = CANCELLED_BY_FILLER;
		instances[7] = RESPONDED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "CREATED";
		negativeInstances[1] = "SENT";
		negativeInstances[2] = "FAILED";
		negativeInstances[3] = "PENDING";
		negativeInstances[4] = "CANCEL_REQUEST";
		negativeInstances[5] = "CANCELLED_BY_PLACER";
		negativeInstances[6] = "CANCELLED_BY_FILLER";
		negativeInstances[7] = "RESPONDED";
		return negativeInstances;
	}
	public static OrderMessageStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static OrderMessageStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		OrderMessageStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1161039;
	public static final OrderMessageStatus CREATED = new OrderMessageStatus(-782, "Created", true, null, null, Color.Default);
	public static final OrderMessageStatus SENT = new OrderMessageStatus(-783, "Sent", true, null, null, Color.Default);
	public static final OrderMessageStatus FAILED = new OrderMessageStatus(-784, "Failed", true, null, null, Color.Default);
	public static final OrderMessageStatus PENDING = new OrderMessageStatus(-785, "Pending", true, null, null, Color.Default);
	public static final OrderMessageStatus CANCEL_REQUEST = new OrderMessageStatus(-786, "Cancel Requested", true, null, null, Color.Default);
	public static final OrderMessageStatus CANCELLED_BY_PLACER = new OrderMessageStatus(-787, "Cancelled By Placer", true, null, null, Color.Default);
	public static final OrderMessageStatus CANCELLED_BY_FILLER = new OrderMessageStatus(-788, "Cancelled By Filler", true, null, null, Color.Default);
	public static final OrderMessageStatus RESPONDED = new OrderMessageStatus(-789, "Responded", true, null, null, Color.Default);
}