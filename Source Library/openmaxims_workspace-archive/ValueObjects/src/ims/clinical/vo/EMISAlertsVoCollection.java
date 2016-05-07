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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;


public class EMISAlertsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<EMISAlertsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EMISAlertsVo> col = new ArrayList<EMISAlertsVo>();
	public String getBoClassName()
	{
		return null;
	}
	public boolean add(EMISAlertsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EMISAlertsVo value)
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
	public int indexOf(EMISAlertsVo instance)
	{
		return col.indexOf(instance);
	}
	public EMISAlertsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EMISAlertsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EMISAlertsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EMISAlertsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EMISAlertsVoCollection clone = new EMISAlertsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EMISAlertsVo)this.col.get(x).clone());
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
	public EMISAlertsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EMISAlertsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public EMISAlertsVoCollection sort(SortOrder order)
	{
		return sort(new EMISAlertsVoComparator(order));
	}
	public EMISAlertsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new EMISAlertsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public EMISAlertsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public EMISAlertsVo[] toArray()
	{
		EMISAlertsVo[] arr = new EMISAlertsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<EMISAlertsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EMISAlertsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public EMISAlertsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EMISAlertsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public EMISAlertsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			EMISAlertsVo voObj1 = (EMISAlertsVo)obj1;
			EMISAlertsVo voObj2 = (EMISAlertsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.EMISAlertsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.EMISAlertsVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.EMISAlertsVoBean[] result = new ims.clinical.vo.beans.EMISAlertsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			EMISAlertsVo vo = ((EMISAlertsVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.EMISAlertsVoBean)vo.getBean();
		}
		return result;
	}
	public static EMISAlertsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		EMISAlertsVoCollection coll = new EMISAlertsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.EMISAlertsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static EMISAlertsVoCollection buildFromBeanCollection(ims.clinical.vo.beans.EMISAlertsVoBean[] beans)
	{
		EMISAlertsVoCollection coll = new EMISAlertsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}