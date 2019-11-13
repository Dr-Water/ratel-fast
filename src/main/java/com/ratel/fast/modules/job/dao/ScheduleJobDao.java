

package com.ratel.fast.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.fast.modules.job.entity.ScheduleJobEntity;
import com.ratel.fast.modules.job.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 定时任务
 *
 *
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
