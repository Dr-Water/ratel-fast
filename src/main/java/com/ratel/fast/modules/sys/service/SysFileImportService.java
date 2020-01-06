package com.ratel.fast.modules.sys.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.entity.SysFileImportEntity;

import java.util.List;
import java.util.Map;

/**
 * 文件导入
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-18 19:18:03
 */
public interface SysFileImportService extends IService<SysFileImportEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateAttr1ById(String template, Integer importFileId, Integer projectId, String uploadDate, String uploadName);

    List<SysFileImportEntity> getFileByInfo(String temp, Integer id);

    void delFileById(Integer id);

    List<SysFileImportEntity> getFiles(Map<String, Object> params);
}

