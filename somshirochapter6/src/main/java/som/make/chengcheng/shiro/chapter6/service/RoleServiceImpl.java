package som.make.chengcheng.shiro.chapter6.service;

import som.make.chengcheng.shiro.chapter6.dao.RoleDao;
import som.make.chengcheng.shiro.chapter6.dao.RoleDaoImpl;
import som.make.chengcheng.shiro.chapter6.entity.Role;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
