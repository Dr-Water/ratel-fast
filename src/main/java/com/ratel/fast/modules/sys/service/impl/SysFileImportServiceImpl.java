package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.modules.sys.dao.SysFileImportDao;
import com.ratel.fast.modules.sys.entity.SysFileImportEntity;
import com.ratel.fast.modules.sys.service.SysFileImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service("sysFileImportService")
public class SysFileImportServiceImpl extends ServiceImpl<SysFileImportDao, SysFileImportEntity> implements SysFileImportService {

    @Autowired
    private SysFileImportDao sysFileImportDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
      return null;
    }

    @Override
    public List<SysFileImportEntity> getFiles(Map<String, Object> params) {


        return null;
    }

    @Override
    public void updateAttr1ById(String template, Integer importFileId, Integer projectId, String uploadDate, String uploadName) {
        sysFileImportDao.updateAttr1ById(template, importFileId, projectId, uploadDate, uploadName);
    }

    @Override
    public List<SysFileImportEntity> getFileByInfo(String temp, Integer id) {
        return sysFileImportDao.getFileByInfo(temp, id);
    }

    @Override
    public void delFileById(Integer id) {
        sysFileImportDao.delFileById(id, null, null, null);
    }

}
