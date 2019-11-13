

package com.ratel.fast.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.job.entity.ScheduleJobLogEntity;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 *
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
