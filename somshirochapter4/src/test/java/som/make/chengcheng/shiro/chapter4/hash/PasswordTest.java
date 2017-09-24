package som.make.chengcheng.shiro.chapter4.hash;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class PasswordTest extends BaseTest {

    @Test
    public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro-passwordservice.ini", "wu", "123");
    }

    @Test
    public void testGeneratePassword() {
        String algorithmName = "md5";
        String username = "liu";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;

        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodePassword = simpleHash.toHex();
        System.out.println(salt2);
        System.out.println(encodePassword);
    }

    @Test
    public void testHashedCredentialMatcherWithMyRealm2() {
        login("classpath:shiro-hashedCredentialsMatcher.ini", "liu", "123");
    }
}
