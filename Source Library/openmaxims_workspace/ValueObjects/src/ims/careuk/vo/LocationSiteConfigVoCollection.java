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
 * Linked to core.resource.place.Location business object (ID: 1007100007).
 */
public class LocationSiteConfigVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<LocationSiteConfigVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<LocationSiteConfigVo> col = new ArrayList<LocationSiteConfigVo>();
	public String getBoClassName()
	{
		return "ims.core.resource.place.domain.objects.Location";
	}
	public boolean add(LocationSiteConfigVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, LocationSiteConfigVo value)
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
	public int indexOf(LocationSiteConfigVo instance)
	{
		return col.indexOf(instance);
	}
	public LocationSiteConfigVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, LocationSiteConfigVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(LocationSiteConfigVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(LocationSiteConfigVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		LocationSiteConfigVoCollection clone = new LocationSiteConfigVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((LocationSiteConfigVo)this.col.get(x).clone());
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
	public LocationSiteConfigVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public LocationSiteConfigVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public LocationSiteConfigVoCollection sort(SortOrder order)
	{
		return sort(new LocationSiteConfigVoComparator(order));
	}
	public LocationSiteConfigVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new LocationSiteConfigVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public LocationSiteConfigVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.resource.place.vo.LocationRefVoCollection toRefVoCollection()
	{
		ims.core.resource.place.vo.LocationRefVoCollection result = new ims.core.resource.place.vo.LocationRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public LocationSiteConfigVo[] toArray()
	{
		LocationSiteConfigVo[] arr = new LocationSiteConfigVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<LocationSiteConfigVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class LocationSiteConfigVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public LocationSiteConfigVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public LocationSiteConfigVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public LocationSiteConfigVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			LocationSiteConfigVo voObj1 = (LocationSiteConfigVo)obj1;
			LocationSiteConfigVo voObj2 = (LocationSiteConfigVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.careuk.vo.beans.LocationSiteConfigVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.careuk.vo.beans.LocationSiteConfigVoBean[] getBeanCollectionArray()
	{
		ims.careuk.vo.beans.LocationSiteConfigVoBean[] result = new ims.careuk.vo.beans.LocationSiteConfigVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			LocationSiteConfigVo vo = ((LocationSiteConfigVo)col.get(i));
			result[i] = (ims.careuk.vo.beans.LocationSiteConfigVoBean)vo.getBean();
		}
		return result;
	}
	public static LocationSiteConfigVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		LocationSiteConfigVoCollection coll = new LocationSiteConfigVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.careuk.vo.beans.LocationSiteConfigVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static LocationSiteConfigVoCollection buildFromBeanCollection(ims.careuk.vo.beans.LocationSiteConfigVoBean[] beans)
	{
		LocationSiteConfigVoCollection coll = new LocationSiteConfigVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}