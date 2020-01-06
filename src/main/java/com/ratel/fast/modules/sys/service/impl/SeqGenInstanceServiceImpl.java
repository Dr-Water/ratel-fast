package com.ratel.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SeqGenInstanceDao;
import com.ratel.fast.modules.sys.entity.SeqGenInstanceEntity;
import com.ratel.fast.modules.sys.service.SeqGenInstanceService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("seqGenInstanceService")
public class SeqGenInstanceServiceImpl extends ServiceImpl<SeqGenInstanceDao, SeqGenInstanceEntity> implements SeqGenInstanceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
       /* Page<SeqGenInstanceEntity> page = this.selectPage(
                new Query<SeqGenInstanceEntity>(params).getPage(),
                new EntityWrapper<SeqGenInstanceEntity>()
        );*/

        return null;
    }

}
