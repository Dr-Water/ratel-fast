package com.ratel.fast.modules.sys.entity;



import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件导入
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-25 10:26:37
 */
@TableName("sys_file_import")
public class SysFileImportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 物理主键
	 */
	@TableId
	private Integer id;
	/**
	 * 导入批次号
	 */
	private String batchNo;
	/**
	 * 导入模板
	 */
	private String templateName;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 文件位置
	 */
	private String filePath;
	/**
	 * 文件格式
	 */
	private String fileExt;
	/**
	 * 文件大小
	 */
	private String fileSize;
	/**
	 * 处理状态【1处理中，2处理成功，3 处理失败】
	 */
	private String processStatus;
	/**
	 * 上传状态【1成功，2失败】
	 */
	private String uploadStatus;
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
	 * 原始文件名
	 */
	private String orginFileName;
	/**
	 * 属性1
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String attr1;
	/**
	 * 属性2
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String attr2;
	/**
	 * 属性3
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String attr3;
	/**
	 * 属性4
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String attr4;

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
	 * 设置：导入批次号
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	/**
	 * 获取：导入批次号
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * 设置：导入模板
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：导入模板
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件位置
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：文件位置
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 设置：文件格式
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	/**
	 * 获取：文件格式
	 */
	public String getFileExt() {
		return fileExt;
	}
	/**
	 * 设置：文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * 获取：文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * 设置：处理状态【1处理中，2处理成功，3 处理失败】
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	/**
	 * 获取：处理状态【1处理中，2处理成功，3 处理失败】
	 */
	public String getProcessStatus() {
		return processStatus;
	}
	/**
	 * 设置：上传状态【1成功，2失败】
	 */
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	/**
	 * 获取：上传状态【1成功，2失败】
	 */
	public String getUploadStatus() {
		return uploadStatus;
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
	/**
	 * 设置：原始文件名
	 */
	public void setOrginFileName(String orginFileName) {
		this.orginFileName = orginFileName;
	}
	/**
	 * 获取：原始文件名
	 */
	public String getOrginFileName() {
		return orginFileName;
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
}
