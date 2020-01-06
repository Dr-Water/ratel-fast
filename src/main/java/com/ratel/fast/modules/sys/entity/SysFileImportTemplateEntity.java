package com.ratel.fast.modules.sys.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件导入模板
 * 
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-03-04 19:34:44
 */
@TableName("sys_file_import_template")
public class SysFileImportTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 物理主键
	 */
	@TableId
	private Integer id;
	/**
	 * 模块
	 */
	private String module;
	/**
	 * 模板
	 */
	private String templateCode;
	/**
	 * 模板名
	 */
	private String templateDesc;
	/**
	 * 限制文件格式【*表示不限制，多个格式用,分开】
	 */
	private String limitFormat;
	/**
	 * 限制大小
	 */
	private Integer limitSize;
	/**
	 * 属性1
	 */
	private String attr1;
	/**
	 * 属性2
	 */
	private String attr2;
	/**
	 * 属性3
	 */
	private String attr3;
	/**
	 * 属性4
	 */
	private String attr4;
	/**
	 * 创建人ITcode
	 */
	private String createrItcode;
	/**
	 * 是否删除【0未删除，1删除】
	 */
	private String isDelete;
	/**
	 * 组织
	 */
	private String orgName;
	/**
	 * 组织ID
	 */
	private Integer orgId;
	/**
	 * 创建人
	 */
	private String createrName;
	/**
	 * 创建人ID
	 */
	private Integer createrId;
	/**
	 * 创建时间
	 */
	private Date createrTime;
	/**
	 * 修改人
	 */
	private String modifyName;
	/**
	 * 修改人ID
	 */
	private Integer modifyId;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 设置：物理主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：物理主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：模块
	 */
	public void setModule(String module) {
		this.module = module;
	}
	/**
	 * 获取：模块
	 */
	public String getModule() {
		return module;
	}
	/**
	 * 设置：模板
	 */
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	/**
	 * 获取：模板
	 */
	public String getTemplateCode() {
		return templateCode;
	}
	/**
	 * 设置：模板名
	 */
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}
	/**
	 * 获取：模板名
	 */
	public String getTemplateDesc() {
		return templateDesc;
	}
	/**
	 * 设置：限制文件格式【*表示不限制，多个格式用,分开】
	 */
	public void setLimitFormat(String limitFormat) {
		this.limitFormat = limitFormat;
	}
	/**
	 * 获取：限制文件格式【*表示不限制，多个格式用,分开】
	 */
	public String getLimitFormat() {
		return limitFormat;
	}
	/**
	 * 设置：限制大小
	 */
	public void setLimitSize(Integer limitSize) {
		this.limitSize = limitSize;
	}
	/**
	 * 获取：限制大小
	 */
	public Integer getLimitSize() {
		return limitSize;
	}
	/**
	 * 设置：属性1
	 */
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	/**
	 * 获取：属性1
	 */
	public String getAttr1() {
		return attr1;
	}
	/**
	 * 设置：属性2
	 */
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	/**
	 * 获取：属性2
	 */
	public String getAttr2() {
		return attr2;
	}
	/**
	 * 设置：属性3
	 */
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	/**
	 * 获取：属性3
	 */
	public String getAttr3() {
		return attr3;
	}
	/**
	 * 设置：属性4
	 */
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}
	/**
	 * 获取：属性4
	 */
	public String getAttr4() {
		return attr4;
	}
	/**
	 * 设置：创建人ITcode
	 */
	public void setCreaterItcode(String createrItcode) {
		this.createrItcode = createrItcode;
	}
	/**
	 * 获取：创建人ITcode
	 */
	public String getCreaterItcode() {
		return createrItcode;
	}
	/**
	 * 设置：是否删除【0未删除，1删除】
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除【0未删除，1删除】
	 */
	public String getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：组织
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：组织
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：组织ID
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：组织ID
	 */
	public Integer getOrgId() {
		return orgId;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreaterName() {
		return createrName;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}
	/**
	 * 获取：创建人ID
	 */
	public Integer getCreaterId() {
		return createrId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreaterTime() {
		return createrTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifyName() {
		return modifyName;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}
	/**
	 * 获取：修改人ID
	 */
	public Integer getModifyId() {
		return modifyId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
