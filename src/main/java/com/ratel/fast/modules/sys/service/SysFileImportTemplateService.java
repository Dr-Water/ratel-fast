package com.ratel.fast.modules.sys.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.entity.SysFileImportTemplateEntity;

import java.util.Map;

/**
 * 文件导入模板
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-03-04 19:34:44
 */
public interface SysFileImportTemplateService extends IService<SysFileImportTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer getCountByTem(String templateName);
}

