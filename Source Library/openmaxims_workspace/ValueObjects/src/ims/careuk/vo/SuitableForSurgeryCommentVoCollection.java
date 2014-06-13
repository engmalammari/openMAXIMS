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

package ims.careuk.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to CAREUK.SuitableForSurgeryComment business object (ID: 1096100041).
 */
public class SuitableForSurgeryCommentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SuitableForSurgeryCommentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SuitableForSurgeryCommentVo> col = new ArrayList<SuitableForSurgeryCommentVo>();
	public String getBoClassName()
	{
		return "ims.careuk.domain.objects.SuitableForSurgeryComment";
	}
	public boolean add(SuitableForSurgeryCommentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SuitableForSurgeryCommentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(SuitableForSurgeryCommentVo instance)
	{
		return col.indexOf(instance);
	}
	public SuitableForSurgeryCommentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SuitableForSurgeryCommentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SuitableForSurgeryCommentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SuitableForSurgeryCommentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SuitableForSurgeryCommentVoCollection clone = new SuitableForSurgeryCommentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SuitableForSurgeryCommentVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public SuitableForSurgeryCommentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SuitableForSurgeryCommentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SuitableForSurgeryCommentVoCollection sort(SortOrder order)
	{
		return sort(new SuitableForSurgeryCommentVoComparator(order));
	}
	public SuitableForSurgeryCommentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SuitableForSurgeryCommentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SuitableForSurgeryCommentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.careuk.vo.SuitableForSurgeryCommentRefVoCollection toRefVoCollection()
	{
		ims.careuk.vo.SuitableForSurgeryCommentRefVoCollection result = new ims.careuk.vo.SuitableForSurgeryCommentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SuitableForSurgeryCommentVo[] toArray()
	{
		SuitableForSurgeryCommentVo[] arr = new SuitableForSurgeryCommentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SuitableForSurgeryCommentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SuitableForSurgeryCommentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SuitableForSurgeryCommentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SuitableForSurgeryCommentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SuitableForSurgeryCommentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SuitableForSurgeryCommentVo voObj1 = (SuitableForSurgeryCommentVo)obj1;
			SuitableForSurgeryCommentVo voObj2 = (SuitableForSurgeryCommentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean[] getBeanCollectionArray()
	{
		ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean[] result = new ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SuitableForSurgeryCommentVo vo = ((SuitableForSurgeryCommentVo)col.get(i));
			result[i] = (ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean)vo.getBean();
		}
		return result;
	}
	public static SuitableForSurgeryCommentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SuitableForSurgeryCommentVoCollection coll = new SuitableForSurgeryCommentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SuitableForSurgeryCommentVoCollection buildFromBeanCollection(ims.careuk.vo.beans.SuitableForSurgeryCommentVoBean[] beans)
	{
		SuitableForSurgeryCommentVoCollection coll = new SuitableForSurgeryCommentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}