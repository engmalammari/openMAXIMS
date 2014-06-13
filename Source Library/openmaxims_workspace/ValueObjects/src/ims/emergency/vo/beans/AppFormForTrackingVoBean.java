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

package ims.emergency.vo.beans;

public class AppFormForTrackingVoBean extends ims.vo.ValueObjectBean
{
	public AppFormForTrackingVoBean()
	{
	}
	public AppFormForTrackingVoBean(ims.emergency.vo.AppFormForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.namespace = vo.getNamespace() == null ? null : (ims.admin.vo.beans.AppNamespaceBean)vo.getNamespace().getBean();
		this.name = vo.getName();
		this.aliasname = vo.getAliasName();
		this.caption = vo.getCaption();
		this.isdialog = vo.getIsDialog();
		this.iscomponent = vo.getIsComponent();
		this.canbeinnavigation = vo.getCanBeInNavigation();
		this.canbeintopbuttons = vo.getCanBeInTopButtons();
		this.isalias = vo.getIsAlias();
		this.logicclass = vo.getLogicClass();
		this.accessclass = vo.getAccessClass();
		this.domainimpl = vo.getDomainImpl();
		this.helplink = vo.getHelpLink();
		this.rieboclassname = vo.getRieBoClassName();
		this.issystem = vo.getIsSystem();
		this.menuactions = vo.getMenuActions() == null ? null : vo.getMenuActions().getBeanCollection();
		this.informationbarvisible = vo.getInformationBarVisible();
		this.description = vo.getDescription();
		this.image = vo.getImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getImage().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AppFormForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.namespace = vo.getNamespace() == null ? null : (ims.admin.vo.beans.AppNamespaceBean)vo.getNamespace().getBean(map);
		this.name = vo.getName();
		this.aliasname = vo.getAliasName();
		this.caption = vo.getCaption();
		this.isdialog = vo.getIsDialog();
		this.iscomponent = vo.getIsComponent();
		this.canbeinnavigation = vo.getCanBeInNavigation();
		this.canbeintopbuttons = vo.getCanBeInTopButtons();
		this.isalias = vo.getIsAlias();
		this.logicclass = vo.getLogicClass();
		this.accessclass = vo.getAccessClass();
		this.domainimpl = vo.getDomainImpl();
		this.helplink = vo.getHelpLink();
		this.rieboclassname = vo.getRieBoClassName();
		this.issystem = vo.getIsSystem();
		this.menuactions = vo.getMenuActions() == null ? null : vo.getMenuActions().getBeanCollection();
		this.informationbarvisible = vo.getInformationBarVisible();
		this.description = vo.getDescription();
		this.image = vo.getImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getImage().getBean(map);
	}

	public ims.emergency.vo.AppFormForTrackingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AppFormForTrackingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AppFormForTrackingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AppFormForTrackingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AppFormForTrackingVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.admin.vo.beans.AppNamespaceBean getNamespace()
	{
		return this.namespace;
	}
	public void setNamespace(ims.admin.vo.beans.AppNamespaceBean value)
	{
		this.namespace = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getAliasName()
	{
		return this.aliasname;
	}
	public void setAliasName(String value)
	{
		this.aliasname = value;
	}
	public String getCaption()
	{
		return this.caption;
	}
	public void setCaption(String value)
	{
		this.caption = value;
	}
	public Boolean getIsDialog()
	{
		return this.isdialog;
	}
	public void setIsDialog(Boolean value)
	{
		this.isdialog = value;
	}
	public Boolean getIsComponent()
	{
		return this.iscomponent;
	}
	public void setIsComponent(Boolean value)
	{
		this.iscomponent = value;
	}
	public Boolean getCanBeInNavigation()
	{
		return this.canbeinnavigation;
	}
	public void setCanBeInNavigation(Boolean value)
	{
		this.canbeinnavigation = value;
	}
	public Boolean getCanBeInTopButtons()
	{
		return this.canbeintopbuttons;
	}
	public void setCanBeInTopButtons(Boolean value)
	{
		this.canbeintopbuttons = value;
	}
	public Boolean getIsAlias()
	{
		return this.isalias;
	}
	public void setIsAlias(Boolean value)
	{
		this.isalias = value;
	}
	public String getLogicClass()
	{
		return this.logicclass;
	}
	public void setLogicClass(String value)
	{
		this.logicclass = value;
	}
	public String getAccessClass()
	{
		return this.accessclass;
	}
	public void setAccessClass(String value)
	{
		this.accessclass = value;
	}
	public String getDomainImpl()
	{
		return this.domainimpl;
	}
	public void setDomainImpl(String value)
	{
		this.domainimpl = value;
	}
	public String getHelpLink()
	{
		return this.helplink;
	}
	public void setHelpLink(String value)
	{
		this.helplink = value;
	}
	public String getRieBoClassName()
	{
		return this.rieboclassname;
	}
	public void setRieBoClassName(String value)
	{
		this.rieboclassname = value;
	}
	public Boolean getIsSystem()
	{
		return this.issystem;
	}
	public void setIsSystem(Boolean value)
	{
		this.issystem = value;
	}
	public ims.admin.vo.beans.MenuActionVoBean[] getMenuActions()
	{
		return this.menuactions;
	}
	public void setMenuActions(ims.admin.vo.beans.MenuActionVoBean[] value)
	{
		this.menuactions = value;
	}
	public Boolean getInformationBarVisible()
	{
		return this.informationbarvisible;
	}
	public void setInformationBarVisible(Boolean value)
	{
		this.informationbarvisible = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.admin.vo.beans.AppImageVoBean getImage()
	{
		return this.image;
	}
	public void setImage(ims.admin.vo.beans.AppImageVoBean value)
	{
		this.image = value;
	}

	private Integer id;
	private int version;
	private ims.admin.vo.beans.AppNamespaceBean namespace;
	private String name;
	private String aliasname;
	private String caption;
	private Boolean isdialog;
	private Boolean iscomponent;
	private Boolean canbeinnavigation;
	private Boolean canbeintopbuttons;
	private Boolean isalias;
	private String logicclass;
	private String accessclass;
	private String domainimpl;
	private String helplink;
	private String rieboclassname;
	private Boolean issystem;
	private ims.admin.vo.beans.MenuActionVoBean[] menuactions;
	private Boolean informationbarvisible;
	private String description;
	private ims.admin.vo.beans.AppImageVoBean image;
}