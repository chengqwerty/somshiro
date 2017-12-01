package som.make.chengcheng.shiro.chapter3;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Think on 2017/7/17.
 */
public class PermissionTest extends BaseTest{

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-permission.ini","zhang","123");
        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //判断拥有权限：delete:update
        Assert.assertTrue(subject().isPermitted("delete:update"));
        //判断拥有权限：user:delete:update.(注意这里是因为有了user:delete的权限，自动获取了user:delete:update的权限"
        Assert.assertTrue(subject().isPermitted("user:delete:update"));
        //判断拥有权限：user:update and user:delete
        Assert.assertTrue(subject().isPermittedAll("user:create","user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject().isPermitted("user:view"));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission(){
        login("classpath:shiro-permission.ini","zhang","123");
        //断言拥有权限：user:create
        subject().checkPermission("user:create");
        //断言拥有权限：user:delete and user:update
        subject().checkPermissions("user:delete","user:update");
        //断言拥有权限：user:view 失败抛出异常
        subject().checkPermissions("user:view");
    }

    @Test
    public void testWildcardPermission1(){
        login("classpath:shiro-permission.ini","li","123");

        subject().checkPermissions("system:user:update","system:user:delete");
        //subject().checkPermissions("system:user:update,delete");
    }

    @Test
    public void testWildcardPermission2(){
        login("classpath:shiro-permission.ini","li","123");
        subject().checkPermissions("system:user:*");
    }

    @Test
    public void testChengchengRole43(){
        login("classpath:shiro-permission.ini","chengcheng","123");
        //subject().checkPermissions("system:user:update");
        subject().checkPermissions("system:user:update,delete");
        subject().isPermitted("system:user:update");
    }
}
