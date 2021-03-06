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
 * Linked to EAS.Configuration.TreatmentSites business object (ID: 1114100000).
 */
public class TreatmentSiteNameVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TreatmentSiteNameVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TreatmentSiteNameVo> col = new ArrayList<TreatmentSiteNameVo>();
	public String getBoClassName()
	{
		return "ims.eas.configuration.domain.objects.TreatmentSites";
	}
	public boolean add(TreatmentSiteNameVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TreatmentSiteNameVo value)
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
	public int indexOf(TreatmentSiteNameVo instance)
	{
		return col.indexOf(instance);
	}
	public TreatmentSiteNameVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TreatmentSiteNameVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TreatmentSiteNameVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TreatmentSiteNameVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TreatmentSiteNameVoCollection clone = new TreatmentSiteNameVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TreatmentSiteNameVo)this.col.get(x).clone());
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
	public TreatmentSiteNameVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TreatmentSiteNameVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TreatmentSiteNameVoCollection sort(SortOrder order)
	{
		return sort(new TreatmentSiteNameVoComparator(order));
	}
	public TreatmentSiteNameVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TreatmentSiteNameVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TreatmentSiteNameVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.eas.configuration.vo.TreatmentSitesRefVoCollection toRefVoCollection()
	{
		ims.eas.configuration.vo.TreatmentSitesRefVoCollection result = new ims.eas.configuration.vo.TreatmentSitesRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TreatmentSiteNameVo[] toArray()
	{
		TreatmentSiteNameVo[] arr = new TreatmentSiteNameVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TreatmentSiteNameVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TreatmentSiteNameVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TreatmentSiteNameVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TreatmentSiteNameVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TreatmentSiteNameVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TreatmentSiteNameVo voObj1 = (TreatmentSiteNameVo)obj1;
			TreatmentSiteNameVo voObj2 = (TreatmentSiteNameVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.eas.vo.beans.TreatmentSiteNameVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.eas.vo.beans.TreatmentSiteNameVoBean[] getBeanCollectionArray()
	{
		ims.eas.vo.beans.TreatmentSiteNameVoBean[] result = new ims.eas.vo.beans.TreatmentSiteNameVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TreatmentSiteNameVo vo = ((TreatmentSiteNameVo)col.get(i));
			result[i] = (ims.eas.vo.beans.TreatmentSiteNameVoBean)vo.getBean();
		}
		return result;
	}
	public static TreatmentSiteNameVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TreatmentSiteNameVoCollection coll = new TreatmentSiteNameVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.eas.vo.beans.TreatmentSiteNameVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TreatmentSiteNameVoCollection buildFromBeanCollection(ims.eas.vo.beans.TreatmentSiteNameVoBean[] beans)
	{
		TreatmentSiteNameVoCollection coll = new TreatmentSiteNameVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
