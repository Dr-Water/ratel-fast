

package com.ratel.fast.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.common.utils.Query;
import com.ratel.fast.modules.oss.entity.SysOssEntity;
import com.ratel.fast.modules.oss.service.SysOssService;
import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.common.utils.Query;
import com.ratel.fast.modules.oss.dao.SysOssDao;
import com.ratel.fast.modules.oss.entity.SysOssEntity;
import com.ratel.fast.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<SysOssEntity> page = this.page(
			new Query<SysOssEntity>().getPage(params)
		);

		return new PageUtils(page);
	}
	
}
