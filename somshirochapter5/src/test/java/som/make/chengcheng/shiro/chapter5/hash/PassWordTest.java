package som.make.chengcheng.shiro.chapter5.hash;

import org.junit.Test;

public class PassWordTest extends BaseTest {

    @Test
    public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro-passwordservice.ini", "wu", "123");
    }
}
