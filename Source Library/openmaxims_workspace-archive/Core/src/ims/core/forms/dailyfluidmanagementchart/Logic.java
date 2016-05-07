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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2272.27859)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.dailyfluidmanagementchart;

import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportVo;
import ims.admin.vo.ReportVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ShiftDetailsVo;
import ims.core.vo.ShiftDetailsVoCollection;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		ShiftDetailsVoCollection shiftDetailsColl = domain.listShiftDetailsByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		form.recbrRecords().clear();
		for (int i = 0; i < shiftDetailsColl.size(); i++)
			form.recbrRecords().newRow(shiftDetailsColl.get(i), "Shift from " + shiftDetailsColl.get(i).getStartDateTime().toString() + " to " + shiftDetailsColl.get(i).getEndDateTime().toString());

		if(shiftDetailsColl.size() > 0)
			previewReport(form.recbrRecords().getValue());
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.htmView().setHTML("");
		engine.open(form.getForms().Core.TotalFluidBalanceDetails);
	}

	protected void onRecbrRecordsValueChanged() throws PresentationLogicException
	{
		previewReport(form.recbrRecords().getValue());
	}

	private void previewReport(ShiftDetailsVo shiftDetailsVo)
	{
		if(shiftDetailsVo == null)
			return;
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		ReportVoCollection coll = domain.listAssignedReports(new Integer(engine.getFormName().getID()));

		if(coll != null && coll.size() > 0)
		{
			//this form must have a single report asigned to it and single template
			ReportVo rep = coll.get(0);
			
			if(rep.getTemplatesIsNotNull() && rep.getTemplates().size() > 0)
			{
				ReportTemplateVo template = rep.getTemplates().get(0);
				
				String[] obj = null;
				obj = domain.getReportAndTemplate(rep.getID_ReportBo(), template.getID_TemplateBo());
				
				if(obj == null || obj.length == 0)
				{
					engine.showMessage("Could not get the report and template !");
					return;
				}

				QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
				
				client.addSeed(new SeedValue("SHIFTID", shiftDetailsVo.getID_ShiftDetails(), Integer.class));
				
				String resultUrl = "";
				try
				{
					resultUrl = client.buildReportAsUrlInlineFrame(obj[0], obj[1], urlReportServer, "PDF", "", 1);
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error creating report: " + e1.getMessage());
					return;
				}
				
				form.htmView().setHTML(resultUrl);
			}
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		previewReport(form.recbrRecords().getValue());
	}
}