package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SysFileImportTemplateDetailDao;
import com.ratel.fast.modules.sys.entity.SysFileImportTemplateDetailEntity;
import com.ratel.fast.modules.sys.service.SysFileImportTemplateDetailService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysFileImportTemplateDetailService")
public class SysFileImportTemplateDetailServiceImpl extends ServiceImpl<SysFileImportTemplateDetailDao, SysFileImportTemplateDetailEntity> implements SysFileImportTemplateDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

}
