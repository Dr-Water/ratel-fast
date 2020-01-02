package com.ratel.fast.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.fast.modules.sys.entity.SysMessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-05-29 15:50:11
 */
@Mapper
public interface SysMessageDao extends BaseMapper<SysMessageEntity> {

    SysMessageEntity selectByKey(@Param("key") String key);
}
