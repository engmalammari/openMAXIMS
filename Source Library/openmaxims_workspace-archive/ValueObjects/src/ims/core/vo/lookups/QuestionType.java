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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class QuestionType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public QuestionType()
	{
		super();
	}
	public QuestionType(int id)
	{
		super(id, "", true);
	}
	public QuestionType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public QuestionType(int id, String text, boolean active, QuestionType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public QuestionType(int id, String text, boolean active, QuestionType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public QuestionType(int id, String text, boolean active, QuestionType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static QuestionType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new QuestionType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (QuestionType)super.getParentInstance();
	}
	public QuestionType getParent()
	{
		return (QuestionType)super.getParentInstance();
	}
	public void setParent(QuestionType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		QuestionType[] typedChildren = new QuestionType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (QuestionType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof QuestionType)
		{
			super.addChild((QuestionType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof QuestionType)
		{
			super.removeChild((QuestionType)child);
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
		QuestionTypeCollection result = new QuestionTypeCollection();
		result.add(PRIMARY);
		result.add(SECONDARY);
		result.add(FINDING);
		result.add(SCORINGASSESSEMNTQUESTION);
		return result;
	}
	public static QuestionType[] getNegativeInstances()
	{
		QuestionType[] instances = new QuestionType[4];
		instances[0] = PRIMARY;
		instances[1] = SECONDARY;
		instances[2] = FINDING;
		instances[3] = SCORINGASSESSEMNTQUESTION;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "PRIMARY";
		negativeInstances[1] = "SECONDARY";
		negativeInstances[2] = "FINDING";
		negativeInstances[3] = "SCORINGASSESSEMNTQUESTION";
		return negativeInstances;
	}
	public static QuestionType getNegativeInstance(String name)
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
	public static QuestionType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		QuestionType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021150;
	public static final QuestionType PRIMARY = new QuestionType(-746, "Primary Question", true, null, null, Color.Default);
	public static final QuestionType SECONDARY = new QuestionType(-747, "Secondary", true, null, null, Color.Default);
	public static final QuestionType FINDING = new QuestionType(-748, "Graphic Finding", true, QuestionType.SECONDARY, null, Color.Default);
	public static final QuestionType SCORINGASSESSEMNTQUESTION = new QuestionType(-750, "Scoring Assessement Question", true, QuestionType.SECONDARY, null, Color.Default);
}
