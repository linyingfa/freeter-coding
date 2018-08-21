package com.freeter.modules.adverts.entity.model;

import com.freeter.modules.adverts.entity.AdvertsDetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import com.freeter.common.annotation.OwnerTable;
 

/**
 * 广告位详情
 * 接收传参的实体类  
 *（后台接收参数） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@OwnerTable(AdvertsDetailEntity.class)
@ApiModel(value = "AdvertsDetailModel")
public class AdvertsDetailModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 	
	/**
	 * 广告详情ID
	 */
	
	@ApiModelProperty(value = "广告详情ID") 
	private Long advertsDetailId;

	
	/**
	 * 广告位置
	 */
	
	@ApiModelProperty(value = "广告位置") 
	private String name;

	
	/**
	 * 广告位ID
	 */
	
	@ApiModelProperty(value = "广告位ID") 
	private Long advertsId;

	
	/**
	 * 标题
	 */
	
	@ApiModelProperty(value = "标题") 
	private String title;

	
	/**
	 * 排序
	 */
	
	@ApiModelProperty(value = "排序") 
	private Integer sort;

	
	/**
	 * 链接地址
	 */
	
	@ApiModelProperty(value = "链接地址") 
	private String href;

	
	/**
	 * 类型(0:图文，1：图片，2：视频）
	 */
	
	@ApiModelProperty(value = "类型(0:图文，1：图片，2：视频）") 
	private Integer type;

	
	/**
	 * 状态 0=显示/1=隐藏
	 */
	
	@ApiModelProperty(value = "状态 0=显示/1=隐藏") 
	private Integer status;

	
	/**
	 * 展示图片
	 */
	
	@ApiModelProperty(value = "展示图片") 
	private String picImg;

	
	/**
	 * 创建时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "创建时间") 
	private Date createTime;

	
	/**
	 * 创建者
	 */
	
	@ApiModelProperty(value = "创建者") 
	private String createBy;

	
	/**
	 * 更新时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "更新时间") 
	private Date updateTime;

	
	/**
	 * 更新者
	 */
	
	@ApiModelProperty(value = "更新者") 
	private String updateBy;

	
	/**
	 * 备注信息
	 */
	
	@ApiModelProperty(value = "备注信息") 
	private String remarks;

	
	/**
	 * 广告起始时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "广告起始时间") 
	private Date beginTime;

	
	/**
	 * 广告结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "广告结束时间") 
	private Date endTime;

	
	/**
	 * 广告内容
	 */
	
	@ApiModelProperty(value = "广告内容") 
	private String content;

 	
	
	/**
	 * 设置：广告详情ID
	 */
	 
	public void setAdvertsDetailId(Long advertsDetailId) {
		this.advertsDetailId = advertsDetailId;
	}
	
	/**
	 * 获取：广告详情ID
	 */
	public Long getAdvertsDetailId() {
		return advertsDetailId;
	}
 	 	
	
	/**
	 * 设置：广告位置
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：广告位置
	 */
	public String getName() {
		return name;
	}
 	 	
	
	/**
	 * 设置：广告位ID
	 */
	 
	public void setAdvertsId(Long advertsId) {
		this.advertsId = advertsId;
	}
	
	/**
	 * 获取：广告位ID
	 */
	public Long getAdvertsId() {
		return advertsId;
	}
 	 	
	
	/**
	 * 设置：标题
	 */
	 
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
 	 	
	
	/**
	 * 设置：排序
	 */
	 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
 	 	
	
	/**
	 * 设置：链接地址
	 */
	 
	public void setHref(String href) {
		this.href = href;
	}
	
	/**
	 * 获取：链接地址
	 */
	public String getHref() {
		return href;
	}
 	 	
	
	/**
	 * 设置：类型(0:图文，1：图片，2：视频）
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型(0:图文，1：图片，2：视频）
	 */
	public Integer getType() {
		return type;
	}
 	 	
	
	/**
	 * 设置：状态 0=显示/1=隐藏
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态 0=显示/1=隐藏
	 */
	public Integer getStatus() {
		return status;
	}
 	 	
	
	/**
	 * 设置：展示图片
	 */
	 
	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}
	
	/**
	 * 获取：展示图片
	 */
	public String getPicImg() {
		return picImg;
	}
 	 	
	
	/**
	 * 设置：创建时间
	 */
	 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
 	 	
	
	/**
	 * 设置：创建者
	 */
	 
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}
 	 	
	
	/**
	 * 设置：更新时间
	 */
	 
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
 	 	
	
	/**
	 * 设置：更新者
	 */
	 
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	/**
	 * 获取：更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}
 	 	
	
	/**
	 * 设置：备注信息
	 */
	 
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}
 	 	
	
	/**
	 * 设置：广告起始时间
	 */
	 
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/**
	 * 获取：广告起始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
 	 	
	
	/**
	 * 设置：广告结束时间
	 */
	 
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 获取：广告结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
 	 	
	
	/**
	 * 设置：广告内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：广告内容
	 */
	public String getContent() {
		return content;
	}
 		
}
