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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 4636.24738)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.ccosched.forms.printletter;

import ims.admin.vo.ReportSeedParsedVo;
import ims.admin.vo.ReportSeedParsedVoCollection;
import ims.admin.vo.ReportSeedVo;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.admin.vo.ReportVo;
import ims.admin.vo.ReportVoCollection;
import ims.ccosched.forms.printletter.GenForm.grdGPLettersRow;
import ims.ccosched.forms.printletter.GenForm.grdGeneralTemplateRow;
import ims.ccosched.forms.printletter.GenForm.grdPatientLettersRow;
import ims.configuration.gen.ConfigFlag;
import ims.domain.FormName;
import ims.framework.IReportField;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.PrinterScope;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.tree.DefaultElement;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int PREVIEW_REPORT = 1;
	private static final int PRINT_REPORT = 2;
	
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		
		form.ccPrinters().initialize(domain.getCurrentLocation(), PrinterScope.DEFAULT, false);	
		
		// WDEV-16406
		form.ccPrinters().setIsRequired(Boolean.TRUE);
						
		if(form.getGlobalContext().Core.getPrepareForPrintingIsNotNull() && form.getGlobalContext().Core.getPrepareForPrinting().equals(Boolean.TRUE))
		{
			form.btnPreview().setEnabled(false);
		}
		
		if (args != null && args.length>=3)
		{
			if (args[0] instanceof String)
				form.getLocalContext().setOrderBy((String)args[0]);
			if (args[1] instanceof Date)
				form.getLocalContext().setstartDate((Date)args[1]);
			if (args[2] instanceof String)
				form.getLocalContext().setClinic((String)args[2]);
		}
		open();
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.ccPrinters().getSelectedPrinter() == null)
		{
			engine.showMessage("Please select a printer !");
			return;
		}

		if (form.getGlobalContext().CcoSched.LetterType.getGPLetterIsNotNull() && form.getGlobalContext().CcoSched.LetterType.getGPLetter())
		{
			if(!(form.grdGPLetters().getValue() instanceof ReportTemplateVo))
			{
				engine.showMessage("Please select a GP Letter template !");
				return;
			}
		}

		if (form.getGlobalContext().CcoSched.LetterType.getPatientLetterIsNotNull() && form.getGlobalContext().CcoSched.LetterType.getPatientLetter())
		{
			if(!(form.grdPatientLetters().getValue() instanceof ReportTemplateVo))
			{
				engine.showMessage("Please select a Patient Letter template !");
				return;
			}
		}
				
		if(buildReport(PRINT_REPORT))
		{
			engine.close(DialogResult.OK);
		}
	}
	protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		buildReport(PREVIEW_REPORT);
	}
	private boolean buildReport(int action)
	{
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		//GP Letters
		if (form.getGlobalContext().CcoSched.LetterType.getGPLetterIsNotNull())
		{
			ReportTemplateVo template = (ReportTemplateVo)form.grdGPLetters().getValue();
			
			if (template != null)
			{
			
				QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
				
				ReportSeedVo voReportSeed = new ReportSeedVo();
				FormName frmName = null;
				
				if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
					frmName = new FormName(128112);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
					frmName = new FormName(128141);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKINGCONFIRM"))
					frmName = new FormName(128156);				
				
				IReportField[] reportField = 
						engine.getFormData(frmName, voReportSeed.getIseeds(template.getReport().getSeeds()));
				
				if (reportField != null)
				{
					String seedName;
					
					ReportSeedParsedVoCollection seeds = null;
					
					try
					{
						seeds = parseSeedsFromXML(template.getReport().getReportXml());
					}
					catch (DocumentException e)
					{
						e.printStackTrace();
						
						engine.showMessage(e.getMessage());
						return false;
					}
					
					for (int i = 0; i < reportField.length; i++)
					{
						try
						{
							seedName = getSeedName(reportField[i], seeds);
							
							client.addSeed(new SeedValue(seedName, reportField[i].getValue(), Class.forName(reportField[i].getType())));
						} 
						catch (ClassNotFoundException e)
						{
							engine.showMessage("Error building the report: " + e.toString());
						}
					}		
					
					//add first appointment date for printing rebooking letters
					if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
					{
						Date firstApptDate = null;
						try {
						
							if (form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDateIsNotNull() && !form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate().equals(""))
							{				
								firstApptDate = new Date(form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate(),DateFormat.ISO);
							}
						} catch (ParseException e) {
							engine.showMessage(e.getMessage());
							return false;
						}
						
						client.addSeed(new SeedValue("First_appt_date", firstApptDate==null?"":firstApptDate.getDate(), java.util.Date.class));
					}
					
				}
		
				
				if(action == PREVIEW_REPORT)
				{
					String result = "";
					try
					{
						result = client.buildReportAsUrl(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
					} 
					catch (QueryBuilderClientException e1)
					{
						engine.showMessage("Error building the report: " + e1.toString());
						return false;
					} 
			
					engine.openUrl(result);
				}
				else if(action == PRINT_REPORT)
				{
					byte[] result = null;
					
					try
					{					
						//client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", form.ccPrinters().getSelectedPrinter().getIPrinterName(),1);
						result = client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
						client.printReport(result, urlReportServer, form.ccPrinters().getSelectedPrinter().getIPrinterName(), 1);
					}  
					catch (QueryBuilderClientException e1)
					{
						engine.showMessage("Error building the report: " + e1.toString());
						return false;
					} 
				}
			}
		}
		
		//Patient Letters
		if (form.getGlobalContext().CcoSched.LetterType.getPatientLetterIsNotNull())
		{
			ReportTemplateVo template = (ReportTemplateVo)form.grdPatientLetters().getValue();
			
			if (template != null)
			{
			
				QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
				
				ReportSeedVo voReportSeed = new ReportSeedVo();
				FormName frmName = null;
				
				if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
					frmName = new FormName(128112);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
					frmName = new FormName(128141);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKINGCONFIRM"))
					frmName = new FormName(128156);				
				
				IReportField[] reportField = 
						engine.getFormData(frmName, voReportSeed.getIseeds(template.getReport().getSeeds()));
	
				
				if (reportField != null)
				{
					String seedName;
					
					ReportSeedParsedVoCollection seeds = null;
					
					try
					{
						seeds = parseSeedsFromXML(template.getReport().getReportXml());
					}
					catch (DocumentException e)
					{
						e.printStackTrace();
						
						engine.showMessage(e.getMessage());
						return false;
					}
					
					for (int i = 0; i < reportField.length; i++)
					{
						try
						{
							seedName = getSeedName(reportField[i], seeds);
 
							
							client.addSeed(new SeedValue(seedName, reportField[i].getValue(), Class.forName(reportField[i].getType())));
						} 
						catch (ClassNotFoundException e)
						{
							engine.showMessage("Error building the report: " + e.toString());
						}
					}	
					
					//add first appointment date for printing rebooking letters
					if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
					{
						Date firstApptDate = null;
						try {
						
							if (form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDateIsNotNull() && !form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate().equals(""))
							{				
								firstApptDate = new Date(form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate(),DateFormat.ISO);
							}
						} catch (ParseException e) {
							engine.showMessage(e.getMessage());
							return false;
						}
						
						client.addSeed(new SeedValue("First_appt_date", firstApptDate==null?"":firstApptDate.getDate(), java.util.Date.class));
					}					
				}
		
				
				if(action == PREVIEW_REPORT)
				{
					String result = "";
					try
					{
						result = client.buildReportAsUrl(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
					} 
					catch (QueryBuilderClientException e1)
					{
						engine.showMessage("Error building the report: " + e1.toString());
						return false;
					} 
			
					engine.openUrl(result);
				}
				else if(action == PRINT_REPORT)
				{
					byte[] result = null;
					
					try
					{					
						//client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", form.ccPrinters().getSelectedPrinter().getIPrinterName(),1);
						result = client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
						client.printReport(result, urlReportServer, form.ccPrinters().getSelectedPrinter().getIPrinterName(), 1);
					}  
					catch (QueryBuilderClientException e1)
					{
						engine.showMessage("Error building the report: " + e1.toString());
						return false;
					} 
				}
			}
		}		

		//Patient Appointments
		if (!form.getGlobalContext().CcoSched.LetterType.getPatientLetterIsNotNull() 
				&& !form.getGlobalContext().CcoSched.LetterType.getGPLetterIsNotNull()
				&& !form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull())
		{
			ReportTemplateVo template = (ReportTemplateVo)form.grdGeneralTemplate().getValue();
			QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

			Date stDate = null;
			Date endDate = null;
			
			try {
			
				if (form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDateIsNotNull() && !form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate().equals(""))
				{				
					stDate = new Date(form.getGlobalContext().CcoSched.PatientAppointments.getApptStartDate(),DateFormat.ISO);
				}
				if (form.getGlobalContext().CcoSched.PatientAppointments.getApptEndDateIsNotNull() && !form.getGlobalContext().CcoSched.PatientAppointments.getApptEndDate().equals(""))
				{
					endDate = new Date(form.getGlobalContext().CcoSched.PatientAppointments.getApptEndDate(),DateFormat.ISO);
				}
			} catch (ParseException e) {
				engine.showMessage(e.getMessage());
				return false;
			}
			
			client.addSeed(new SeedValue("startDate",stDate==null?null:stDate.getDate(),java.util.Date.class));				
			client.addSeed(new SeedValue("endDate",endDate==null?null:endDate.getDate(),java.util.Date.class));	
			client.addSeed(new SeedValue("Patient_id",form.getGlobalContext().Core.getPatientShort().getID_Patient(),Integer.class));
			
			if(action == PREVIEW_REPORT)
			{
				String result = "";
				try
				{
					result = client.buildReportAsUrl(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error building the report: " + e1.toString());
					return false;
				} 
		
				engine.openUrl(result);
			}
			else if(action == PRINT_REPORT)
			{
				byte[] result = null;
				
				try
				{					
					//client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", form.ccPrinters().getSelectedPrinter().getIPrinterName(),1);
					result = client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
					client.printReport(result, urlReportServer, form.ccPrinters().getSelectedPrinter().getIPrinterName(), 1);
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error building the report: " + e1.toString());
					return false;
				} 
			}			
		}
		
		if ((form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-24"))
				|| (form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-29")))
		{
			ReportTemplateVo template = (ReportTemplateVo)form.grdGeneralTemplate().getValue();
			QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
			
			if (form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-24"))
			{
				//get selected clinic details
				String[] tmp = form.getGlobalContext().CcoSched.ClinicView.getClinicDetails();
				if (tmp == null || tmp.length == 0)
				{
					engine.showMessage("Can not print Patients as Clinic Details has no data.");
					return false;
				}
				
				//String prfile_sess_id = tmp[0];//test value - 5482
				
				String prfiled_id = null;
				if (!tmp[1].equals("-1"))
					prfiled_id = tmp[1];
				
				client.addSeed(new SeedValue("OrderBy", form.getLocalContext().getOrderBy(), Integer.class));
				client.addSeed(new SeedValue("Clinic", new Integer(form.getLocalContext().getClinic()), Integer.class));
				client.addSeed(new SeedValue("AppStat", form.getGlobalContext().CcoSched.ClinicView.getAppt_stat(), String.class));
				client.addSeed(new SeedValue("startDate", form.getLocalContext().getstartDateIsNotNull()?form.getLocalContext().getstartDate().getDate():null,java.util.Date.class));				
			}
			
			if(action == PREVIEW_REPORT)
			{
				String result = "";
				try
				{
					result = client.buildReportAsUrl(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error building the report: " + e1.toString());
					return false;
				} 
		
				engine.openUrl(result);
			}
			else if(action == PRINT_REPORT)
			{
				byte[] result = null;
				
				try
				{					
					result = client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
					client.printReport(result, urlReportServer, form.ccPrinters().getSelectedPrinter().getIPrinterName(), 1);
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error building the report: " + e1.toString());
					return false;
				} 
			}						
		}
		
		
		return true;
	}
	
	private void open()
	{
		
		ReportVoCollection coll = null;
		
		form.grdPatientLetters().setVisible(false);
		form.grdGPLetters().setVisible(false);
		form.grdGeneralTemplate().setVisible(false);		
		
		
		//ClinicView and AppointmentOverview templates
		if (form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-24"))
		{
			coll = domain.listReports(128116);
			coll.sort(SortOrder.ASCENDING);//WDEV-18311
			addGeneralTemplates(coll);
			form.grdGeneralTemplate().setVisible(true);
		}
		else if (form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-29"))
		{
			coll = domain.listReports(128104);
			coll.sort(SortOrder.ASCENDING);//WDEV-18311
			addGeneralTemplates(coll);
			form.grdGeneralTemplate().setVisible(true);			
		}
		else if (!form.getGlobalContext().CcoSched.LetterType.getGPLetterIsNotNull() && !form.getGlobalContext().CcoSched.LetterType.getPatientLetterIsNotNull())
		{			
			coll = domain.listReports(128134);
			coll.sort(SortOrder.ASCENDING);//WDEV-18311
			addGeneralTemplates(coll);
			form.grdGeneralTemplate().setVisible(true);
		}
		else
		{
			if (form.getGlobalContext().CcoSched.getSelectLetterTypeIsNotNull())
			{
				if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
					coll = domain.listReports(128112);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
					coll = domain.listReports(128141);
				else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKINGCONFIRM"))
					coll = domain.listReports(128156);			
			}
			else
				return;
			
			coll.sort(SortOrder.ASCENDING);//WDEV-18311
			
			//check Reports for Patient Letters
			if (form.getGlobalContext().CcoSched.LetterType.getPatientLetterIsNotNull())
			{
				addPatientReportLetter(coll);
				form.grdPatientLetters().setVisible(true);
			}
			//check Reports for GP Letters
			if (form.getGlobalContext().CcoSched.LetterType.getGPLetterIsNotNull())
			{
				addGpReportLetter(coll);
				form.grdGPLetters().setVisible(true);
			}
		}					

	}

	private void addClinicView(ReportVoCollection coll) 
	{
		if (coll != null)
		{
			for(int i = 0; i < coll.size(); i++)
			{
				ReportVo report = coll.get(i);
				
				if (report.getReportNameIsNotNull() 
						&& (report.getReportName().equalsIgnoreCase("Scheduler - Clinic View")))
				{
					if(report.getTemplatesIsNotNull() && report.getTemplates().size() > 0)
					{
						
						grdPatientLettersRow row = form.grdPatientLetters().getRows().newRow();
						
						row.setBackColor(Color.Beige);
						row.setcolName(report.getReportName());
						row.setcolDescription(report.getReportDescription());
						row.setValue(report);
						
						for (int j = 0; j < report.getTemplates().size(); j++)
						{
							ReportTemplateVo template = report.getTemplates().get(j);
							
							grdPatientLettersRow templateRow = row.getRows().newRow();
							templateRow.setcolName(template.getName());
							templateRow.setcolDescription(template.getDescription());
							templateRow.setValue(template);
						}
						
						row.setExpanded(true);
					}
				}
			}
			
			if(form.grdPatientLetters().getRows().size() == 1 && form.grdPatientLetters().getRows().get(0).getRows().size() == 1)
				form.grdPatientLetters().setValue(form.grdPatientLetters().getRows().get(0).getRows().get(0).getValue());
		}
	}

	private void addGeneralTemplates(ReportVoCollection coll) 
	{
		if (coll != null)
		{
			for(int i = 0; i < coll.size(); i++)
			{
				ReportVo report = coll.get(i);
				
				if(canBeSeeded(report) && report.getTemplatesIsNotNull() && report.getTemplates().size() > 0)
				{
					
					grdGeneralTemplateRow row = form.grdGeneralTemplate().getRows().newRow();
					
					row.setBackColor(Color.Beige);
					row.setcolName(report.getReportName());
					row.setcolDescription(report.getReportDescription());
					row.setValue(report);
					
					//WDEV-18311
					ReportTemplateVoCollection collTemplates = report.getTemplates().sort( new TemplatesComparator(SortOrder.ASCENDING)); 
					
					for (int j = 0; j < collTemplates.size(); j++)
					{
						ReportTemplateVo template = collTemplates.get(j);
						
						grdGeneralTemplateRow templateRow = row.getRows().newRow();
						templateRow.setcolName(template.getName());
						templateRow.setcolDescription(template.getDescription());
						templateRow.setValue(template);
					}
					
					row.setExpanded(true);
				}
			}
			
			if(form.grdGeneralTemplate().getRows().size() == 1 && form.grdGeneralTemplate().getRows().get(0).getRows().size() == 1)
				form.grdGeneralTemplate().setValue(form.grdGeneralTemplate().getRows().get(0).getRows().get(0).getValue());
			
		}		
	}

	private void addPatientReportLetter(ReportVoCollection coll) 
	{
		if (coll != null)
		{
			for(int i = 0; i < coll.size(); i++)
			{
				ReportVo report = coll.get(i);
				
				if (report.getReportNameIsNotNull() 
						&& ((report.getReportName().equalsIgnoreCase("Scheduler - Patient Letters") && form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
								|| (report.getReportName().equalsIgnoreCase("Scheduler - Rebooking Patient Letters") && form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
								|| (report.getReportName().equalsIgnoreCase("Scheduler - Patient Letters") && form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKINGCONFIRM")))
								)
				{
					if(canBeSeeded(report) && report.getTemplatesIsNotNull() && report.getTemplates().size() > 0)
					{
						
						grdPatientLettersRow row = form.grdPatientLetters().getRows().newRow();
						
						row.setBackColor(Color.Beige);
						row.setcolName(report.getReportName());
						row.setcolDescription(report.getReportDescription());
						row.setValue(report);
						
						//WDEV-18311
						ReportTemplateVoCollection collTemplates = report.getTemplates().sort( new TemplatesComparator(SortOrder.ASCENDING));
						for (int j = 0; j < collTemplates.size(); j++)
						{
							ReportTemplateVo template = collTemplates.get(j);
							
							grdPatientLettersRow templateRow = row.getRows().newRow();
							templateRow.setcolName(template.getName());
							templateRow.setcolDescription(template.getDescription());
							templateRow.setValue(template);
						}
						
						row.setExpanded(true);
					}
				}
			}
			
			if(form.grdPatientLetters().getRows().size() == 1 && form.grdPatientLetters().getRows().get(0).getRows().size() == 1)
				form.grdPatientLetters().setValue(form.grdPatientLetters().getRows().get(0).getRows().get(0).getValue());
			
		}
		
	}

	private void addGpReportLetter(ReportVoCollection coll) 
	{
		if (coll != null)
		{
			for(int i = 0; i < coll.size(); i++)
			{
				ReportVo report = coll.get(i);
				
				if (report.getReportNameIsNotNull() 
						&& ((report.getReportName().equalsIgnoreCase("Scheduler - GP Letters") && form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
								|| (report.getReportName().equalsIgnoreCase("Scheduler - Rebooking GP Letters") && form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING")))
								)					
				{
				
					if(canBeSeeded(report) && report.getTemplatesIsNotNull() && report.getTemplates().size() > 0)
					{
						
						grdGPLettersRow row = form.grdGPLetters().getRows().newRow();
						
						row.setBackColor(Color.Beige);
						row.setcolName(report.getReportName());
						row.setcolDescription(report.getReportDescription());
						row.setValue(report);
						
						//WDEV-18311
						ReportTemplateVoCollection collTemplates = report.getTemplates().sort(new TemplatesComparator(SortOrder.ASCENDING));
						for (int j = 0; j < collTemplates.size(); j++)
						{
							ReportTemplateVo template = collTemplates.get(j);
							
							grdGPLettersRow templateRow = row.getRows().newRow();
							templateRow.setcolName(template.getName());
							templateRow.setcolDescription(template.getDescription());
							templateRow.setValue(template);
						}
						
						row.setExpanded(true);
					}
				}
			}
			
			if(form.grdGPLetters().getRows().size() == 1 && form.grdGPLetters().getRows().get(0).getRows().size() == 1)
				form.grdGPLetters().setValue(form.grdGPLetters().getRows().get(0).getRows().get(0).getValue());
			
		}		
	}

	private boolean canBeSeeded(ReportVo report)
	{
		//reports without seeds can always be printed
		if(!report.getSeedsIsNotNull())
			return true;
		
		if(report.getSeeds().size() == 0)
			return true;

		ReportSeedVo voReportSeed = new ReportSeedVo();
		
		FormName frmName = null;
		
		if (form.getGlobalContext().CcoSched.getSelectLetterTypeIsNotNull())
		{
			if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKING"))
				frmName = new FormName(128112);
			else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("REBOOKING"))
				frmName = new FormName(128141);
			else if (form.getGlobalContext().CcoSched.getSelectLetterType().equals("BOOKINGCONFIRM"))
				frmName = new FormName(128156);
		}
		else if (form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-24"))
			frmName = new FormName(128116);
		else if (form.getGlobalContext().CcoSched.getTemplateCategoryIDListIsNotNull() && form.getGlobalContext().CcoSched.getTemplateCategoryIDList().equals("-29"))
			frmName = new FormName(128104);
		else
			frmName = new FormName(128134);
		
		return engine.formHasData(frmName, voReportSeed.getIseeds(report.getSeeds()));
	}
	
	private String getSeedName(IReportField field, ReportSeedParsedVoCollection seeds)
	{
		String ret = "";

		int pos = field.getName().lastIndexOf('.');
		ret = field.getName().substring(pos + 1);
		
		if(seeds != null)
		{
			for (int i = 0; i < seeds.size(); i++)
			{
				if(field.getName().equalsIgnoreCase(seeds.get(i).getBOName() + "_" + seeds.get(i).getBOField()))
				{
					ret = seeds.get(i).getName();
					break;
				}
			}
		}
		
		return  ret;
	}
	
	private ReportSeedParsedVoCollection parseSeedsFromXML(String reportXML) throws DocumentException
	{
		Document document = DocumentHelper.parseText(reportXML);

		ReportSeedParsedVoCollection seeds = new ReportSeedParsedVoCollection();
		List list = document.selectNodes("//Project/Seeds/Seed");
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			DefaultElement attribute = (DefaultElement) iter.next();

			ReportSeedParsedVo seed = new ReportSeedParsedVo();
			seed.setName(attribute.valueOf("Name"));
			seed.setType(attribute.valueOf("Type"));
			seed.setBOName(attribute.valueOf("BOName"));
			seed.setBOField(attribute.valueOf("BOField"));
			seed.setCanBeNull(new Boolean(attribute.valueOf("CanBeNull").equalsIgnoreCase("true")));
			seeds.add(seed);
		}

		return seeds;
	}
	
	//WDEV-18311
	public class TemplatesComparator implements Comparator
	{
		private int direction = 1;
		
		public TemplatesComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public TemplatesComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String pdate1 = null;
			String pdate2 = null;
			if(ob1 instanceof ReportTemplateVo )
			{
				ReportTemplateVo ps1 = (ReportTemplateVo)ob1;
				pdate1 = ps1.getName().toUpperCase();
			}
			if(ob2 instanceof ReportTemplateVo)
			{
				ReportTemplateVo ps2 = (ReportTemplateVo)ob2;
				pdate2 = ps2.getName().toUpperCase();
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
	
}

