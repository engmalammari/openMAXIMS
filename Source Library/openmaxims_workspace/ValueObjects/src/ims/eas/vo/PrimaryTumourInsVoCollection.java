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

package ims.eas.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to EAS.Configuration.PrimaryTumour business object (ID: 1114100002).
 */
public class PrimaryTumourInsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PrimaryTumourInsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PrimaryTumourInsVo> col = new ArrayList<PrimaryTumourInsVo>();
	public String getBoClassName()
	{
		return "ims.eas.configuration.domain.objects.PrimaryTumour";
	}
	public boolean add(PrimaryTumourInsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PrimaryTumourInsVo value)
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
	public int indexOf(PrimaryTumourInsVo instance)
	{
		return col.indexOf(instance);
	}
	public PrimaryTumourInsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PrimaryTumourInsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PrimaryTumourInsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PrimaryTumourInsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PrimaryTumourInsVoCollection clone = new PrimaryTumourInsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PrimaryTumourInsVo)this.col.get(x).clone());
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
	public PrimaryTumourInsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PrimaryTumourInsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PrimaryTumourInsVoCollection sort(SortOrder order)
	{
		return sort(new PrimaryTumourInsVoComparator(order));
	}
	public PrimaryTumourInsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PrimaryTumourInsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PrimaryTumourInsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.eas.configuration.vo.PrimaryTumourRefVoCollection toRefVoCollection()
	{
		ims.eas.configuration.vo.PrimaryTumourRefVoCollection result = new ims.eas.configuration.vo.PrimaryTumourRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PrimaryTumourInsVo[] toArray()
	{
		PrimaryTumourInsVo[] arr = new PrimaryTumourInsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IPrimaryTumour[] toIPrimaryTumourArray()
	{
		ims.vo.interfaces.IPrimaryTumour[] arr = new ims.vo.interfaces.IPrimaryTumour[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PrimaryTumourInsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PrimaryTumourInsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PrimaryTumourInsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PrimaryTumourInsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PrimaryTumourInsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PrimaryTumourInsVo voObj1 = (PrimaryTumourInsVo)obj1;
			PrimaryTumourInsVo voObj2 = (PrimaryTumourInsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.eas.vo.beans.PrimaryTumourInsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.eas.vo.beans.PrimaryTumourInsVoBean[] getBeanCollectionArray()
	{
		ims.eas.vo.beans.PrimaryTumourInsVoBean[] result = new ims.eas.vo.beans.PrimaryTumourInsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PrimaryTumourInsVo vo = ((PrimaryTumourInsVo)col.get(i));
			result[i] = (ims.eas.vo.beans.PrimaryTumourInsVoBean)vo.getBean();
		}
		return result;
	}
	public static PrimaryTumourInsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PrimaryTumourInsVoCollection coll = new PrimaryTumourInsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.eas.vo.beans.PrimaryTumourInsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PrimaryTumourInsVoCollection buildFromBeanCollection(ims.eas.vo.beans.PrimaryTumourInsVoBean[] beans)
	{
		PrimaryTumourInsVoCollection coll = new PrimaryTumourInsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}