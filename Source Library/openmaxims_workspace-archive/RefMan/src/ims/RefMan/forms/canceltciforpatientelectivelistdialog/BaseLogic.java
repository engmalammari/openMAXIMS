// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.canceltciforpatientelectivelistdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.RefMan.domain.CancelTCIForPatientElectiveListDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.RefMan.domain.CancelTCIForPatientElectiveListDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbCancellationTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCancellationType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.AdmissionOfferOutcome existingInstance = (ims.RefMan.vo.lookups.AdmissionOfferOutcome)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCancellationTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.RefMan.vo.lookups.AdmissionOfferOutcome)
		{
			ims.RefMan.vo.lookups.AdmissionOfferOutcome instance = (ims.RefMan.vo.lookups.AdmissionOfferOutcome)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCancellationTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.AdmissionOfferOutcome existingInstance = (ims.RefMan.vo.lookups.AdmissionOfferOutcome)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCancellationType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCancellationTypeLookup()
	{
		this.form.cmbCancellationType().clear();
		ims.RefMan.vo.lookups.AdmissionOfferOutcomeCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getAdmissionOfferOutcome(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCancellationType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCancellationTypeLookupValue(int id)
	{
		ims.RefMan.vo.lookups.AdmissionOfferOutcome instance = ims.RefMan.vo.lookups.LookupHelper.getAdmissionOfferOutcomeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCancellationType().setValue(instance);
	}
	protected final void defaultcmbCancellationTypeLookupValue()
	{
		this.form.cmbCancellationType().setValue((ims.RefMan.vo.lookups.AdmissionOfferOutcome)domain.getLookupService().getDefaultInstance(ims.RefMan.vo.lookups.AdmissionOfferOutcome.class, engine.getFormName().getID(), ims.RefMan.vo.lookups.AdmissionOfferOutcome.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.RefMan.domain.CancelTCIForPatientElectiveListDialog domain;
}
