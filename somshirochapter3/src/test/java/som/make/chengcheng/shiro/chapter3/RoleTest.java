package som.make.chengcheng.shiro.chapter3;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Think on 2017/7/17.
 */
public class RoleTest extends BaseTest{

    @Test
    public void testHashRole(){
        login("classpath:shiro-role.ini","zhang","123");
        Assert.assertTrue(subject().hasRole("role1"));

        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));

        boolean[] result=subject().hasRoles(Arrays.asList("role1","role2","role3"));
        Assert.assertEquals(true,result[0]);
        Assert.assertEquals(true,result[1]);
        Assert.assertEquals(false,result[2]);
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole(){
        login("classpath:shiro-role.ini","zhang","123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1","role3");
    }
}
