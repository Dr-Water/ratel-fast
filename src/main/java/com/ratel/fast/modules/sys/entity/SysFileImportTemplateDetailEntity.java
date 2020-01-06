package com.ratel.fast.modules.sys.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件导入模板明细
 * 
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-03-04 19:34:44
 */
@TableName("sys_file_import_template_detail")
public class SysFileImportTemplateDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 物理主键
	 */
	@TableId
	private Integer id;
	/**
	 * 模板ID
	 */
	private Integer templateId;
	/**
	 * 模板名
	 */
	private String templateName;
	/**
	 * 字段名
	 */
	private String fieldName;
	/**
	 * 列名【对应的数据库字段】
	 */
	private String columnName;
	/**
	 * 字段类型
	 */
	private String fieldType;
	/**
	 * 字段格式
	 */
	private String fieldFormat;
	/**
	 * 顺序
	 */
	private String orderBy;
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
	 * 设置：模板ID
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板ID
	 */
	public Integer getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板名
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：模板名
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：字段名
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段名
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：列名【对应的数据库字段】
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * 获取：列名【对应的数据库字段】
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * 设置：字段类型
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	/**
	 * 获取：字段类型
	 */
	public String getFieldType() {
		return fieldType;
	}
	/**
	 * 设置：字段格式
	 */
	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}
	/**
	 * 获取：字段格式
	 */
	public String getFieldFormat() {
		return fieldFormat;
	}
	/**
	 * 设置：顺序
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * 获取：顺序
	 */
	public String getOrderBy() {
		return orderBy;
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
