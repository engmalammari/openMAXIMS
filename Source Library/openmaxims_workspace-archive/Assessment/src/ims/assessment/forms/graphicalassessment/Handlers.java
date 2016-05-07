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

package ims.assessment.forms.graphicalassessment;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdImagesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSelectImageClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDrawingBodyChartEdited(int index) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDrawingBodyChartRemoved(int index) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDrawingBodyChartNote(ims.framework.controls.DrawingControlShape shape) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdQuestionsCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
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
		this.form.lyrAssessment().tabSelectImage().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrAssessmenttabSelectImageActivated();
			}
		});
		this.form.lyrAssessment().tabDrawing().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrAssessmenttabDrawingActivated();
			}
		});
		this.form.lyrAssessment().tabQuestions().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrAssessmenttabQuestionsActivated();
			}
		});
		this.form.lyrAssessment().tabStages().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrAssessmenttabStagesActivated();
			}
		});
		this.form.lyrAssessment().tabSelectImage().grdImages().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdImagesSelectionChanged();
			}
		});
		this.form.lyrAssessment().tabSelectImage().btnSelectImage().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSelectImageClick();
			}
		});
		this.form.lyrAssessment().tabDrawing().drawingBodyChart().setDrawingControlShapeEditedEvent(new DrawingControlShapeEdited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int index) throws ims.framework.exceptions.PresentationLogicException
			{
				onDrawingBodyChartEdited(index);
			}
		});
		this.form.lyrAssessment().tabDrawing().drawingBodyChart().setDrawingControlShapeRemovedEvent(new DrawingControlShapeRemoved()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int index) throws ims.framework.exceptions.PresentationLogicException
			{
				onDrawingBodyChartRemoved(index);
			}
		});
		this.form.lyrAssessment().tabDrawing().drawingBodyChart().setDrawingControlNoteEvent(new DrawingControlNote()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DrawingControlShape shape) throws ims.framework.exceptions.PresentationLogicException
			{
				onDrawingBodyChartNote(shape);
			}
		});
		this.form.lyrAssessment().tabQuestions().dyngrdQuestions().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdQuestionsCellButtonClicked(cell);
			}
		});
		this.form.getContextMenus().getAnswerGraphicStageADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AnswerGraphicStage.ADD, sender);
			}
		});
	}
	private void onlyrAssessmenttabSelectImageActivated()
	{
		this.form.lyrAssessment().showtabSelectImage();
	}
	private void onlyrAssessmenttabDrawingActivated()
	{
		this.form.lyrAssessment().showtabDrawing();
	}
	private void onlyrAssessmenttabQuestionsActivated()
	{
		this.form.lyrAssessment().showtabQuestions();
	}
	private void onlyrAssessmenttabStagesActivated()
	{
		this.form.lyrAssessment().showtabStages();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}