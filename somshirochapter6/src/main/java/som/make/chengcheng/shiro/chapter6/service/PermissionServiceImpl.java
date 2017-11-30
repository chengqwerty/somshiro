package som.make.chengcheng.shiro.chapter6.service;

import som.make.chengcheng.shiro.chapter6.dao.PermissionDao;
import som.make.chengcheng.shiro.chapter6.dao.PermissionDaoImpl;
import som.make.chengcheng.shiro.chapter6.entity.Permission;

public class PermissionServiceImpl implements PermissionService{

    private PermissionDao permissionDao = new PermissionDaoImpl();

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
