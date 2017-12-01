package som.make.chengcheng.shiro.chapter6.dao;

import som.make.chengcheng.shiro.chapter6.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
