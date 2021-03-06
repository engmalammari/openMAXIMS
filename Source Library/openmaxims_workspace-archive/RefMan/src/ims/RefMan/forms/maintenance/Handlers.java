// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.maintenance;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrMaintenanceTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdBookDetSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbBookClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbBookSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbBookSpecialtyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdCancelDetSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbCancelClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbCancelSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbCancelSpecialtyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbPollSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSlotClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSlotPollSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdPdsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbPdsSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbPdsClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSdsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchSdsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearSdsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.lyrMaintenance().tabBookExc().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintenancetabBookExcActivated();
			}
		});
		this.form.lyrMaintenance().tabCancelExc().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintenancetabCancelExcActivated();
			}
		});
		this.form.lyrMaintenance().tabSlotPoll().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintenancetabSlotPollActivated();
			}
		});
		this.form.lyrMaintenance().tabPdsRequests().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintenancetabPdsRequestsActivated();
			}
		});
		this.form.lyrMaintenance().tabSdsRequests().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrMaintenancetabSdsRequestsActivated();
			}
		});
		this.form.lyrMaintenance().tabBookExc().grdBookDet().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdBookDetSelectionChanged();
			}
		});
		this.form.lyrMaintenance().tabBookExc().imbBookClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbBookClearClick();
			}
		});
		this.form.lyrMaintenance().tabBookExc().imbBookSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbBookSearchClick();
			}
		});
		this.form.lyrMaintenance().tabBookExc().cmbBookSpecialty().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbBookSpecialtyValueChanged();
			}
		});
		this.form.lyrMaintenance().tabCancelExc().grdCancelDet().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdCancelDetSelectionChanged();
			}
		});
		this.form.lyrMaintenance().tabCancelExc().imbCancelClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbCancelClearClick();
			}
		});
		this.form.lyrMaintenance().tabCancelExc().imbCancelSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbCancelSearchClick();
			}
		});
		this.form.lyrMaintenance().tabCancelExc().cmbCancelSpecialty().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbCancelSpecialtyValueChanged();
			}
		});
		this.form.lyrMaintenance().tabSlotPoll().imbPollSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbPollSearchClick();
			}
		});
		this.form.lyrMaintenance().tabSlotPoll().imbSlotClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSlotClearClick();
			}
		});
		this.form.lyrMaintenance().tabSlotPoll().grdSlotPoll().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSlotPollSelectionChanged();
			}
		});
		this.form.lyrMaintenance().tabPdsRequests().grdPds().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPdsSelectionChanged();
			}
		});
		this.form.lyrMaintenance().tabPdsRequests().imbPdsSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbPdsSearchClick();
			}
		});
		this.form.lyrMaintenance().tabPdsRequests().imbPdsClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbPdsClearClick();
			}
		});
		this.form.lyrMaintenance().tabSdsRequests().grdSds().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSdsSelectionChanged();
			}
		});
		this.form.lyrMaintenance().tabSdsRequests().imbSearchSds().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchSdsClick();
			}
		});
		this.form.lyrMaintenance().tabSdsRequests().imbClearSds().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearSdsClick();
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceCONFIRMAPPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.CONFIRMAPPT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceDISCARDAPPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.DISCARDAPPT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceCANCELAPPTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.CANCELAPPT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceUNDOAPPTCANCELItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.UNDOAPPTCANCEL, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceCANCELSLOTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.CANCELSLOT, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceUNDOSLOTCANCELItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.UNDOSLOTCANCEL, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_SLOTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_SLOTS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_PDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_PDS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_ALL_PDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_ALL_PDS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_SELECTED_PDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_SELECTED_PDS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_SDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_SDS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_ALL_SDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_ALL_SDS, sender);
			}
		});
		this.form.getContextMenus().Scheduling.getMaintenanceRESUBMIT_SELECTED_SDSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SchedulingNamespace.Maintenance.RESUBMIT_SELECTED_SDS, sender);
			}
		});
	}
	private void onlyrMaintenancetabBookExcActivated()
	{
		this.form.lyrMaintenance().showtabBookExc();
		onlyrMaintenanceTabChanged(this.form.lyrMaintenance().tabBookExc());
	}
	private void onlyrMaintenancetabCancelExcActivated()
	{
		this.form.lyrMaintenance().showtabCancelExc();
		onlyrMaintenanceTabChanged(this.form.lyrMaintenance().tabCancelExc());
	}
	private void onlyrMaintenancetabSlotPollActivated()
	{
		this.form.lyrMaintenance().showtabSlotPoll();
		onlyrMaintenanceTabChanged(this.form.lyrMaintenance().tabSlotPoll());
	}
	private void onlyrMaintenancetabPdsRequestsActivated()
	{
		this.form.lyrMaintenance().showtabPdsRequests();
		onlyrMaintenanceTabChanged(this.form.lyrMaintenance().tabPdsRequests());
	}
	private void onlyrMaintenancetabSdsRequestsActivated()
	{
		this.form.lyrMaintenance().showtabSdsRequests();
		onlyrMaintenanceTabChanged(this.form.lyrMaintenance().tabSdsRequests());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
