package com.ratel.fast.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.fast.modules.sys.entity.SeqGenFieldEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 *
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-19 21:26:15
 */
@Mapper
public interface SeqGenFieldDao extends BaseMapper<SeqGenFieldEntity> {

    @Update("UPDATE seq_gen_field t SET t.`seq_gf_value`=0 WHERE t.`base_grl_attr1`=1 AND t.`status`='ACTIVE'")
    public int updateInitSeqByFlag();
}
