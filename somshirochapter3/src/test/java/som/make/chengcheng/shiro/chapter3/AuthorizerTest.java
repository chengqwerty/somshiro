package som.make.chengcheng.shiro.chapter3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 成成、 on 2017/7/24.
 */
public class AuthorizerTest extends BaseTest {

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-authorizer.ini","zhang","123");
        //
        Assert.assertTrue(subject().isPermitted("user1:update"));
        Assert.assertTrue(subject().isPermitted("user2:update"));
        //
        Assert.assertTrue(subject().isPermitted("+user1+2"));
        Assert.assertTrue(subject().isPermitted("+user1+8"));
        Assert.assertTrue(subject().isPermitted("+user2+10"));
        Assert.assertFalse(subject().isPermitted("+user1+4"));
//
        Assert.assertTrue(subject().isPermitted("menu:view"));
    }
}
