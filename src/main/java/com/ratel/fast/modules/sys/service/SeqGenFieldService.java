package com.ratel.fast.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.entity.SeqGenFieldEntity;

import java.util.Map;

/**
 *
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-19 21:26:15
 */
public interface SeqGenFieldService extends IService<SeqGenFieldEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int updateInitSeqByFlag();
}

