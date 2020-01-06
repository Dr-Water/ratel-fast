package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SysFileImportTemplateDao;
import com.ratel.fast.modules.sys.entity.SysFileImportTemplateEntity;
import com.ratel.fast.modules.sys.service.SysFileImportTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysFileImportTemplateService")
public class SysFileImportTemplateServiceImpl extends ServiceImpl<SysFileImportTemplateDao, SysFileImportTemplateEntity> implements SysFileImportTemplateService {

    @Autowired
    private SysFileImportTemplateDao sysFileImportTemplateDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        return null;
    }

    @Override
    public Integer getCountByTem(String templateName) {
        return sysFileImportTemplateDao.getCountByTem(templateName);
    }

}
