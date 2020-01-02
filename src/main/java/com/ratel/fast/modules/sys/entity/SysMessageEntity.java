package com.ratel.fast.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-05-29 15:50:11
 */
@TableName("sys_message")
public class SysMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 区分key
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String key;
	/**
	 * 消息标题
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String title;
	/**
	 * 消息正文
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String content;
	/**
	 * 消息附件路径
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String files;
	/**
	 * 消息图片路径
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String img;
	/**
	 * 消息描述
	 */
	@TableField(fill = FieldFill.UPDATE)
	private String desc;
	/**
	 * 状态：0禁用  1正常
	 */
	private Integer status;
	/**
	 * 是否删除【0未删除，1删除】
	 */
	private String isDelete;
	/**
	 * 创建人
	 */
	private String createrName;
	/**
	 * 创建人Id
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
	 * 修改人Id
	 */
	private Integer modifyId;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：区分key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：区分key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：消息标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：消息标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：消息正文
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息正文
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：消息附件路径
	 */
	public void setFiles(String files) {
		this.files = files;
	}
	/**
	 * 获取：消息附件路径
	 */
	public String getFiles() {
		return files;
	}
	/**
	 * 设置：消息图片路径
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：消息图片路径
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：消息描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：消息描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：状态：0禁用  1正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态：0禁用  1正常
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：创建人Id
	 */
	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}
	/**
	 * 获取：创建人Id
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
	 * 设置：修改人Id
	 */
	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}
	/**
	 * 获取：修改人Id
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
