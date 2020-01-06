package com.ratel.fast.modules.sys.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-19 21:26:15
 */
@TableName("seq_gen")
public class SeqGenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * DESC
	 */
	@TableId
	private String id;
	/**
	 * 序列名称
	 */
	private String seqName;
	/**
	 * 模块名称
	 */
	private String seqModuleName;
	/**
	 * 校验类型【unique 唯一,normal 常规】
	 */
	private String seqValType;
	/**
	 * 序列长度
	 */
	private String seqLen;
	/**
	 * 扩展属性1
	 */
	private String baseGrlAttr1;
	/**
	 * 扩展属性2
	 */
	private String baseGrlAttr2;
	/**
	 * 扩展属性3
	 */
	private String baseGrlAttr3;
	/**
	 * 扩展属性4
	 */
	private Date baseGrlAttr4;
	/**
	 * 扩展属性5
	 */
	private Date baseGrlAttr5;
	/**
	 * 版本
	 */
	private Long version;
	/**
	 * 状态【ACTIVE("激活")，UNACTIVE("冻结");】
	 */
	private String status;
	/**
	 * 创建人
	 */
	private String creater;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 修改人
	 */
	private String editor;
	/**
	 * 修改时间
	 */
	private Date edittime;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：DESC
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：DESC
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：序列名称
	 */
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	/**
	 * 获取：序列名称
	 */
	public String getSeqName() {
		return seqName;
	}
	/**
	 * 设置：模块名称
	 */
	public void setSeqModuleName(String seqModuleName) {
		this.seqModuleName = seqModuleName;
	}
	/**
	 * 获取：模块名称
	 */
	public String getSeqModuleName() {
		return seqModuleName;
	}
	/**
	 * 设置：校验类型【unique 唯一,normal 常规】
	 */
	public void setSeqValType(String seqValType) {
		this.seqValType = seqValType;
	}
	/**
	 * 获取：校验类型【unique 唯一,normal 常规】
	 */
	public String getSeqValType() {
		return seqValType;
	}
	/**
	 * 设置：序列长度
	 */
	public void setSeqLen(String seqLen) {
		this.seqLen = seqLen;
	}
	/**
	 * 获取：序列长度
	 */
	public String getSeqLen() {
		return seqLen;
	}
	/**
	 * 设置：扩展属性1
	 */
	public void setBaseGrlAttr1(String baseGrlAttr1) {
		this.baseGrlAttr1 = baseGrlAttr1;
	}
	/**
	 * 获取：扩展属性1
	 */
	public String getBaseGrlAttr1() {
		return baseGrlAttr1;
	}
	/**
	 * 设置：扩展属性2
	 */
	public void setBaseGrlAttr2(String baseGrlAttr2) {
		this.baseGrlAttr2 = baseGrlAttr2;
	}
	/**
	 * 获取：扩展属性2
	 */
	public String getBaseGrlAttr2() {
		return baseGrlAttr2;
	}
	/**
	 * 设置：扩展属性3
	 */
	public void setBaseGrlAttr3(String baseGrlAttr3) {
		this.baseGrlAttr3 = baseGrlAttr3;
	}
	/**
	 * 获取：扩展属性3
	 */
	public String getBaseGrlAttr3() {
		return baseGrlAttr3;
	}
	/**
	 * 设置：扩展属性4
	 */
	public void setBaseGrlAttr4(Date baseGrlAttr4) {
		this.baseGrlAttr4 = baseGrlAttr4;
	}
	/**
	 * 获取：扩展属性4
	 */
	public Date getBaseGrlAttr4() {
		return baseGrlAttr4;
	}
	/**
	 * 设置：扩展属性5
	 */
	public void setBaseGrlAttr5(Date baseGrlAttr5) {
		this.baseGrlAttr5 = baseGrlAttr5;
	}
	/**
	 * 获取：扩展属性5
	 */
	public Date getBaseGrlAttr5() {
		return baseGrlAttr5;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	public Long getVersion() {
		return version;
	}
	/**
	 * 设置：状态【ACTIVE("激活")，UNACTIVE("冻结");】
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态【ACTIVE("激活")，UNACTIVE("冻结");】
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：修改人
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
	 * 获取：修改人
	 */
	public String getEditor() {
		return editor;
	}
	/**
	 * 设置：修改时间
	 */
	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getEdittime() {
		return edittime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
