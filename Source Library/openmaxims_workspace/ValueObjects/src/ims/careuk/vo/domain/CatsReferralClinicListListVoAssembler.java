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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.careuk.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Calin Perebiceanu
 */
public class CatsReferralClinicListListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.CatsReferralClinicListListVo copy(ims.careuk.vo.CatsReferralClinicListListVo valueObjectDest, ims.careuk.vo.CatsReferralClinicListListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_CatsReferral(valueObjectSrc.getID_CatsReferral());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// hasInvestigations
		valueObjectDest.setHasInvestigations(valueObjectSrc.getHasInvestigations());
		// hasAppointments
		valueObjectDest.setHasAppointments(valueObjectSrc.getHasAppointments());
		// hasReferralLetter
		valueObjectDest.setHasReferralLetter(valueObjectSrc.getHasReferralLetter());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// isCAB
		valueObjectDest.setIsCAB(valueObjectSrc.getIsCAB());
		// hasConsultationDetails
		valueObjectDest.setHasConsultationDetails(valueObjectSrc.getHasConsultationDetails());
		// LastApptArrivedDate
		valueObjectDest.setLastApptArrivedDate(valueObjectSrc.getLastApptArrivedDate());
		// OnwardReferralStatus
		valueObjectDest.setOnwardReferralStatus(valueObjectSrc.getOnwardReferralStatus());
		// ReferralDetails
		valueObjectDest.setReferralDetails(valueObjectSrc.getReferralDetails());
		// ProviderCancellation
		valueObjectDest.setProviderCancellation(valueObjectSrc.getProviderCancellation());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createCatsReferralClinicListListVoCollectionFromCatsReferral(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.CatsReferral objects.
	 */
	public static ims.careuk.vo.CatsReferralClinicListListVoCollection createCatsReferralClinicListListVoCollectionFromCatsReferral(java.util.Set domainObjectSet)	
	{
		return createCatsReferralClinicListListVoCollectionFromCatsReferral(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.CatsReferral objects.
	 */
	public static ims.careuk.vo.CatsReferralClinicListListVoCollection createCatsReferralClinicListListVoCollectionFromCatsReferral(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.CatsReferralClinicListListVoCollection voList = new ims.careuk.vo.CatsReferralClinicListListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.CatsReferral domainObject = (ims.careuk.domain.objects.CatsReferral) iterator.next();
			ims.careuk.vo.CatsReferralClinicListListVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.careuk.domain.objects.CatsReferral objects.
	 */
	public static ims.careuk.vo.CatsReferralClinicListListVoCollection createCatsReferralClinicListListVoCollectionFromCatsReferral(java.util.List domainObjectList) 
	{
		return createCatsReferralClinicListListVoCollectionFromCatsReferral(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.CatsReferral objects.
	 */
	public static ims.careuk.vo.CatsReferralClinicListListVoCollection createCatsReferralClinicListListVoCollectionFromCatsReferral(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.CatsReferralClinicListListVoCollection voList = new ims.careuk.vo.CatsReferralClinicListListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.CatsReferral domainObject = (ims.careuk.domain.objects.CatsReferral) domainObjectList.get(i);
			ims.careuk.vo.CatsReferralClinicListListVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.careuk.domain.objects.CatsReferral set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractCatsReferralSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVoCollection voCollection) 
	 {
	 	return extractCatsReferralSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractCatsReferralSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.CatsReferralClinicListListVo vo = voCollection.get(i);
			ims.careuk.domain.objects.CatsReferral domainObject = CatsReferralClinicListListVoAssembler.extractCatsReferral(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.careuk.domain.objects.CatsReferral list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractCatsReferralList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVoCollection voCollection) 
	 {
	 	return extractCatsReferralList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractCatsReferralList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.CatsReferralClinicListListVo vo = voCollection.get(i);
			ims.careuk.domain.objects.CatsReferral domainObject = CatsReferralClinicListListVoAssembler.extractCatsReferral(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.careuk.domain.objects.CatsReferral object.
	 * @param domainObject ims.careuk.domain.objects.CatsReferral
	 */
	 public static ims.careuk.vo.CatsReferralClinicListListVo create(ims.careuk.domain.objects.CatsReferral domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.CatsReferral object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.CatsReferralClinicListListVo create(DomainObjectMap map, ims.careuk.domain.objects.CatsReferral domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.CatsReferralClinicListListVo valueObject = (ims.careuk.vo.CatsReferralClinicListListVo) map.getValueObject(domainObject, ims.careuk.vo.CatsReferralClinicListListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.CatsReferralClinicListListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.CatsReferral
	 */
	 public static ims.careuk.vo.CatsReferralClinicListListVo insert(ims.careuk.vo.CatsReferralClinicListListVo valueObject, ims.careuk.domain.objects.CatsReferral domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.CatsReferral
	 */
	 public static ims.careuk.vo.CatsReferralClinicListListVo insert(DomainObjectMap map, ims.careuk.vo.CatsReferralClinicListListVo valueObject, ims.careuk.domain.objects.CatsReferral domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_CatsReferral(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// hasInvestigations
		valueObject.setHasInvestigations( domainObject.isHasInvestigations() );
		// hasAppointments
		valueObject.setHasAppointments( domainObject.isHasAppointments() );
		// hasReferralLetter
		valueObject.setHasReferralLetter( domainObject.isHasReferralLetter() );
		// CurrentStatus
		valueObject.setCurrentStatus(ims.careuk.vo.domain.CatsReferralStatusLiteVoAssembler.create(map, domainObject.getCurrentStatus()) );
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
		// isCAB
		valueObject.setIsCAB( domainObject.isIsCAB() );
		// hasConsultationDetails
		valueObject.setHasConsultationDetails( domainObject.isHasConsultationDetails() );
		// LastApptArrivedDate
		java.util.Date LastApptArrivedDate = domainObject.getLastApptArrivedDate();
		if ( null != LastApptArrivedDate ) 
		{
			valueObject.setLastApptArrivedDate(new ims.framework.utils.Date(LastApptArrivedDate) );
		}
		// OnwardReferralStatus
		ims.domain.lookups.LookupInstance instance9 = domainObject.getOnwardReferralStatus();
		if ( null != instance9 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance9.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance9.getImage().getImageId(), instance9.getImage().getImagePath());
			}
			color = instance9.getColor();
			if (color != null) 
				color.getValue();

			ims.careuk.vo.lookups.OnwardReferralStatus voLookup9 = new ims.careuk.vo.lookups.OnwardReferralStatus(instance9.getId(),instance9.getText(), instance9.isActive(), null, img, color);
			ims.careuk.vo.lookups.OnwardReferralStatus parentVoLookup9 = voLookup9;
			ims.domain.lookups.LookupInstance parent9 = instance9.getParent();
			while (parent9 != null)
			{
				if (parent9.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent9.getImage().getImageId(), parent9.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent9.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup9.setParent(new ims.careuk.vo.lookups.OnwardReferralStatus(parent9.getId(),parent9.getText(), parent9.isActive(), null, img, color));
				parentVoLookup9 = parentVoLookup9.getParent();
								parent9 = parent9.getParent();
			}			
			valueObject.setOnwardReferralStatus(voLookup9);
		}
				// ReferralDetails
		valueObject.setReferralDetails(ims.careuk.vo.domain.ReferralLetterDetailsClinicListListVoAssembler.create(map, domainObject.getReferralDetails()) );
		// ProviderCancellation
		if (domainObject.getProviderCancellation() != null)
		{
			if(domainObject.getProviderCancellation() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getProviderCancellation();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setProviderCancellation(new ims.careuk.vo.ProviderCancellationRefVo(id, -1));				
			}
			else
			{
				valueObject.setProviderCancellation(new ims.careuk.vo.ProviderCancellationRefVo(domainObject.getProviderCancellation().getId(), domainObject.getProviderCancellation().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.CatsReferral extractCatsReferral(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVo valueObject) 
	{
		return 	extractCatsReferral(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.CatsReferral extractCatsReferral(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.CatsReferralClinicListListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_CatsReferral();
		ims.careuk.domain.objects.CatsReferral domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.CatsReferral)domMap.get(valueObject);
			}
			// ims.careuk.vo.CatsReferralClinicListListVo ID_CatsReferral field is unknown
			domainObject = new ims.careuk.domain.objects.CatsReferral();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_CatsReferral());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.CatsReferral)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.CatsReferral) domainFactory.getDomainObject(ims.careuk.domain.objects.CatsReferral.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_CatsReferral());

		domainObject.setHasInvestigations(valueObject.getHasInvestigations());
		domainObject.setHasAppointments(valueObject.getHasAppointments());
		domainObject.setHasReferralLetter(valueObject.getHasReferralLetter());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.careuk.domain.objects.CATSReferralStatus value4 = null;
		if ( null != valueObject.getCurrentStatus() ) 
		{
			if (valueObject.getCurrentStatus().getBoId() == null)
			{
				if (domMap.get(valueObject.getCurrentStatus()) != null)
				{
					value4 = (ims.careuk.domain.objects.CATSReferralStatus)domMap.get(valueObject.getCurrentStatus());
				}
			}
			else
			{
				value4 = (ims.careuk.domain.objects.CATSReferralStatus)domainFactory.getDomainObject(ims.careuk.domain.objects.CATSReferralStatus.class, valueObject.getCurrentStatus().getBoId());
			}
		}
		domainObject.setCurrentStatus(value4);
		ims.core.admin.domain.objects.CareContext value5 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value5 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value5 = domainObject.getCareContext();	
			}
			else
			{
				value5 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value5);
		domainObject.setIsCAB(valueObject.getIsCAB());
		domainObject.setHasConsultationDetails(valueObject.getHasConsultationDetails());
		java.util.Date value8 = null;
		ims.framework.utils.Date date8 = valueObject.getLastApptArrivedDate();		
		if ( date8 != null ) 
		{
			value8 = date8.getDate();
		}
		domainObject.setLastApptArrivedDate(value8);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value9 = null;
		if ( null != valueObject.getOnwardReferralStatus() ) 
		{
			value9 =
				domainFactory.getLookupInstance(valueObject.getOnwardReferralStatus().getID());
		}
		domainObject.setOnwardReferralStatus(value9);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.ReferralLetterDetails value10 = null;
		if ( null != valueObject.getReferralDetails() ) 
		{
			if (valueObject.getReferralDetails().getBoId() == null)
			{
				if (domMap.get(valueObject.getReferralDetails()) != null)
				{
					value10 = (ims.core.clinical.domain.objects.ReferralLetterDetails)domMap.get(valueObject.getReferralDetails());
				}
			}
			else
			{
				value10 = (ims.core.clinical.domain.objects.ReferralLetterDetails)domainFactory.getDomainObject(ims.core.clinical.domain.objects.ReferralLetterDetails.class, valueObject.getReferralDetails().getBoId());
			}
		}
		domainObject.setReferralDetails(value10);
		ims.careuk.domain.objects.ProviderCancellation value11 = null;
		if ( null != valueObject.getProviderCancellation() ) 
		{
			if (valueObject.getProviderCancellation().getBoId() == null)
			{
				if (domMap.get(valueObject.getProviderCancellation()) != null)
				{
					value11 = (ims.careuk.domain.objects.ProviderCancellation)domMap.get(valueObject.getProviderCancellation());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value11 = domainObject.getProviderCancellation();	
			}
			else
			{
				value11 = (ims.careuk.domain.objects.ProviderCancellation)domainFactory.getDomainObject(ims.careuk.domain.objects.ProviderCancellation.class, valueObject.getProviderCancellation().getBoId());
			}
		}
		domainObject.setProviderCancellation(value11);

		return domainObject;
	}

}