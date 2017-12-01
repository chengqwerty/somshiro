package som.make.chengcheng.shiro.chapter5.hash;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

public class CodecAndCryptoTest {

    @Test
    public void testBase64() {
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println(str);
        System.out.println(base64Encoded);
        System.out.println(str2);
    }

    @Test
    public void testMd5() {
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();
        System.out.println(md5);
    }

    @Test
    public void testSha512() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha512Hash(str, salt).toString();
        System.out.println(sha1);
    }

    @Test
    public void testHashService() {
        DefaultHashService defaultHashService = new DefaultHashService();
        defaultHashService.setHashAlgorithmName("SHA-512");
        defaultHashService.setPrivateSalt(new SimpleByteSource("123"));
        defaultHashService.setGeneratePublicSalt(true);
        defaultHashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        defaultHashService.setHashIterations(1);

        HashRequest hashRequest = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = defaultHashService.computeHash(hashRequest).toHex();
        System.out.println(hex);
    }
}
