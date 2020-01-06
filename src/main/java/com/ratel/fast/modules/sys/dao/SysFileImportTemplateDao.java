package com.ratel.fast.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.fast.modules.sys.entity.SysFileImportTemplateEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件导入模板
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-03-04 19:34:44
 */
@Mapper
public interface SysFileImportTemplateDao extends BaseMapper<SysFileImportTemplateEntity> {

    Integer getCountByTem(String templateName);
}
