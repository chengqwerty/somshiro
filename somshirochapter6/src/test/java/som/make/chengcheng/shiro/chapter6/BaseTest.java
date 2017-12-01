package som.make.chengcheng.shiro.chapter6;

import org.junit.Before;
import som.make.chengcheng.shiro.chapter6.entity.Permission;
import som.make.chengcheng.shiro.chapter6.entity.Role;
import som.make.chengcheng.shiro.chapter6.entity.User;
import som.make.chengcheng.shiro.chapter6.service.*;

public abstract class BaseTest {

    protected PermissionService permissionService = new PermissionServiceImpl();
    protected RoleService roleService = new RoleServiceImpl();
    protected UserService userService = new UserServiceImpl();

    protected String password = "123";

    protected Permission permission1;
    protected Permission permission2;
    protected Permission permission3;

    protected Role role1;
    protected Role role2;
    protected User user1;
    protected User user2;
    protected User user3;
    protected User user4;

    @Before
    public void setUp() {
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles_permissions");

        permission1 = new Permission("user:create", "用户模块新增", "1");
        permission2 = new Permission("user:update", "用户模块修改", "1");
        permission3 = new Permission("menu:create", "菜单模块新增", "1");
        permissionService.createPermission(permission1);
        permissionService.createPermission(permission2);
        permissionService.createPermission(permission3);

        role1 = new Role("admin", "管理员", "1");
        role2 = new Role("user", "用户管理员", "1");
        roleService.createRole(role1);
        roleService.createRole(role2);

        roleService.correlationPermissions(role1.getId(), permission1.getId());
        roleService.correlationPermissions(role1.getId(), permission2.getId());
        roleService.correlationPermissions(role1.getId(), permission3.getId());

        roleService.correlationPermissions(role2.getId(), permission1.getId());
        roleService.correlationPermissions(role2.getId(), permission2.getId());

        user1 = new User("zhang", password);
        user2 = new User("li", password);
        user3 = new User("wu", password);
        user4 = new User("wang", password);
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);

        userService.correlationRoles(user1.getId(), role1.getId());
    }
}
