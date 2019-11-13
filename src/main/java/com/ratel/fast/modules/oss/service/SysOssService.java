

package com.ratel.fast.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.oss.entity.SysOssEntity;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 *
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
