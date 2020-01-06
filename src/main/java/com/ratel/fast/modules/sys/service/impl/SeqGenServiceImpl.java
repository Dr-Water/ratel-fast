package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SeqGenDao;
import com.ratel.fast.modules.sys.entity.SeqGenEntity;
import com.ratel.fast.modules.sys.service.SeqGenService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("seqGenService")
public class SeqGenServiceImpl extends ServiceImpl<SeqGenDao, SeqGenEntity> implements SeqGenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        /*Page<SeqGenEntity> page = this.selectPage(
                new Query<SeqGenEntity>(params).getPage(),
                new EntityWrapper<SeqGenEntity>()
        );*/

//        return new PageUtils(page);
        return null;
    }

}
