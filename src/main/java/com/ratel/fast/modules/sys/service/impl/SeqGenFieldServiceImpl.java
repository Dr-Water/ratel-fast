package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SeqGenFieldDao;
import com.ratel.fast.modules.sys.entity.SeqGenFieldEntity;
import com.ratel.fast.modules.sys.service.SeqGenFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("seqGenFieldService")
public class SeqGenFieldServiceImpl extends ServiceImpl<SeqGenFieldDao, SeqGenFieldEntity> implements SeqGenFieldService {

    @Autowired
    SeqGenFieldDao seqGenFieldDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
       // Page<SeqGenFieldEntity> page = this.selectPage(
          //      new Query<SeqGenFieldEntity>(params).getPage(),
           //     new Wrapper<SeqGenFieldEntity>()
       // );

        return null;
    }

    @Override
    @Transactional
    public int updateInitSeqByFlag() {
        return seqGenFieldDao.updateInitSeqByFlag();
    }

}
