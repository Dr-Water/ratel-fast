

package com.ratel.fast.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.exception.RRException;
import com.ratel.fast.common.validator.Assert;
import com.ratel.fast.modules.app.dao.UserDao;
import com.ratel.fast.modules.app.entity.UserEntity;
import com.ratel.fast.modules.app.form.LoginForm;
import com.ratel.fast.modules.app.service.UserService;
import com.ratel.fast.common.exception.RRException;
import com.ratel.fast.common.validator.Assert;
import com.ratel.fast.modules.app.dao.UserDao;
import com.ratel.fast.modules.app.entity.UserEntity;
import com.ratel.fast.modules.app.form.LoginForm;
import com.ratel.fast.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
