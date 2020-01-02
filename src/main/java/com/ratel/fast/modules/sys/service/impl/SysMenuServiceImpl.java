

package com.ratel.fast.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.fast.common.utils.Constant;
import com.ratel.fast.common.utils.MapUtils;
import com.ratel.fast.modules.sys.dao.SysMenuDao;
import com.ratel.fast.modules.sys.entity.SysMenuEntity;
import com.ratel.fast.modules.sys.service.SysMenuService;
import com.ratel.fast.modules.sys.service.SysRoleMenuService;
import com.ratel.fast.modules.sys.service.SysUserService;
import com.ratel.fast.common.utils.Constant;
import com.ratel.fast.common.utils.MapUtils;
import com.ratel.fast.modules.sys.dao.SysMenuDao;
import com.ratel.fast.modules.sys.entity.SysMenuEntity;
import com.ratel.fast.modules.sys.service.SysMenuService;
import com.ratel.fast.modules.sys.service.SysRoleMenuService;
import com.ratel.fast.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;



	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	@Override
	public List<SysMenuEntity> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	/**
	 * 获取不包含按钮的菜单列表
	 */
	@Override
	public List<SysMenuEntity> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}
	/**
	 * 获取用户菜单列表
	 */
	@Override
	public List<SysMenuEntity> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == Constant.SUPER_ADMIN){
			return getAllMenuList(null);
		}
		
		//当前登录用户拥有的所有的菜单列表的id集合
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public void delete(Long menuId){
		//删除菜单
		this.removeById(menuId);
		//删除菜单与角色关联
		sysRoleMenuService.removeByMap(new MapUtils().put("menu_id", menuId));
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归查询子菜单
	 * @param menuList   根菜单集合
	 * @param menuIdList 当前登录用户拥有的所有的菜单列表的id集合
	 * @return
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();
		
		for(SysMenuEntity entity : menuList){
			//如果是目录则进行递归调用查询下一级菜单
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
			    //将查询到的子菜单放到list中
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  当前登录用户拥有的所有的菜单列表的id集合
     */
    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenuEntity> userMenuList = new ArrayList<>();
        //循环根据父菜单id查询出来的菜单集合 ，找到属于当前用户的菜单，并加到用户菜单的集合中
        for(SysMenuEntity menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }
}
