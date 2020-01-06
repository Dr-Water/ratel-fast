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
@TableName("seq_gen_field")
public class SeqGenFieldEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * DESC
	 */
	@TableId
	private String id;
	/**
	 * 头表ID
	 */
	private String seqGenId;
	/**
	 * 序列名称
	 */
	private String seqName;
	/**
	 * 模块名称
	 */
	private String seqModuleName;
	/**
	 * 数据区域
	 */
	private String seqGfDomain;
	/**
	 * 数据区域开始位
	 */
	private String seqGfStart;
	/**
	 * 数据区域结束位
	 */
	private String seqGfEnd;
	/**
	 * 数据块生成规则【INCREMENT 自增，DATE 日期,AUTO 随机，STATIC 静态数据，PARAM_IN传入参数】
	 */
	private String seqGfRule;
	/**
	 * 数据块值【自增：当前数据，日期：格式，随机：基数，静态：默认数据，传入参数 无】
	 */
	private String seqGfValue;
	/**
	 * 数据块值【自增：步长】
	 */
	private String seqGfValue2;
	/**
	 * 数据块顺序
	 */
	private String seqGfOrder;
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
	 * 设置：头表ID
	 */
	public void setSeqGenId(String seqGenId) {
		this.seqGenId = seqGenId;
	}
	/**
	 * 获取：头表ID
	 */
	public String getSeqGenId() {
		return seqGenId;
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
	 * 设置：数据区域
	 */
	public void setSeqGfDomain(String seqGfDomain) {
		this.seqGfDomain = seqGfDomain;
	}
	/**
	 * 获取：数据区域
	 */
	public String getSeqGfDomain() {
		return seqGfDomain;
	}
	/**
	 * 设置：数据区域开始位
	 */
	public void setSeqGfStart(String seqGfStart) {
		this.seqGfStart = seqGfStart;
	}
	/**
	 * 获取：数据区域开始位
	 */
	public String getSeqGfStart() {
		return seqGfStart;
	}
	/**
	 * 设置：数据区域结束位
	 */
	public void setSeqGfEnd(String seqGfEnd) {
		this.seqGfEnd = seqGfEnd;
	}
	/**
	 * 获取：数据区域结束位
	 */
	public String getSeqGfEnd() {
		return seqGfEnd;
	}
	/**
	 * 设置：数据块生成规则【INCREMENT 自增，DATE 日期,AUTO 随机，STATIC 静态数据，PARAM_IN传入参数】
	 */
	public void setSeqGfRule(String seqGfRule) {
		this.seqGfRule = seqGfRule;
	}
	/**
	 * 获取：数据块生成规则【INCREMENT 自增，DATE 日期,AUTO 随机，STATIC 静态数据，PARAM_IN传入参数】
	 */
	public String getSeqGfRule() {
		return seqGfRule;
	}
	/**
	 * 设置：数据块值【自增：当前数据，日期：格式，随机：基数，静态：默认数据，传入参数 无】
	 */
	public void setSeqGfValue(String seqGfValue) {
		this.seqGfValue = seqGfValue;
	}
	/**
	 * 获取：数据块值【自增：当前数据，日期：格式，随机：基数，静态：默认数据，传入参数 无】
	 */
	public String getSeqGfValue() {
		return seqGfValue;
	}
	/**
	 * 设置：数据块值【自增：步长】
	 */
	public void setSeqGfValue2(String seqGfValue2) {
		this.seqGfValue2 = seqGfValue2;
	}
	/**
	 * 获取：数据块值【自增：步长】
	 */
	public String getSeqGfValue2() {
		return seqGfValue2;
	}
	/**
	 * 设置：数据块顺序
	 */
	public void setSeqGfOrder(String seqGfOrder) {
		this.seqGfOrder = seqGfOrder;
	}
	/**
	 * 获取：数据块顺序
	 */
	public String getSeqGfOrder() {
		return seqGfOrder;
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
