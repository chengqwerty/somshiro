package som.make.chengcheng.shiro.chapter6.service;

import som.make.chengcheng.shiro.chapter6.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
