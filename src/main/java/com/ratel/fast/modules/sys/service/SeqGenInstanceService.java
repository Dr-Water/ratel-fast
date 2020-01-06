package com.ratel.fast.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.entity.SeqGenInstanceEntity;

import java.util.Map;

/**
 * 
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-19 21:26:15
 */
public interface SeqGenInstanceService extends IService<SeqGenInstanceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

