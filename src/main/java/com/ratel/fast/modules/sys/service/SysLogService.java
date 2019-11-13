

package com.ratel.fast.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 *
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
