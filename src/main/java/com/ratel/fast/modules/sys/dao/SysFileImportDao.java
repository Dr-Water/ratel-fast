package com.ratel.fast.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.fast.modules.sys.entity.SysFileImportEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件导入
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-18 19:18:03
 */
@Mapper
public interface SysFileImportDao extends BaseMapper<SysFileImportEntity> {

    void updateAttr1ById(@Param("template") String template, @Param("importFileId") Integer importFileId, @Param("projectId") Integer projectId, @Param("uploadDate") String uploadDate, @Param("uploadName") String uploadName);

    List<SysFileImportEntity> getFileByInfo(@Param("temp") String temp, @Param("id") Integer id);

    void delFileById(@Param("id") Integer id, @Param("attr1") String attr1, @Param("attr2") String attr2, @Param("attr3") String attr3);

    List<Integer> getSolutionFileById(Integer solutionId);

    List<Integer> getSolutionAduioFileById(Integer solutionId);
}
