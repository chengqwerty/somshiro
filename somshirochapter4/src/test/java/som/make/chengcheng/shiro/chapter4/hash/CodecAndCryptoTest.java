package som.make.chengcheng.shiro.chapter4.hash;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class CodecAndCryptoTest {

    @Test
    public void testBase64() {
        String str = "hellochengcheng";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println(base64Encoded);

        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println(str2);
    }

    @Test
    public void testHex() throws DecoderException{
        String str = "hellochengcheng";
        String base64Encoded = Hex.encodeHexString(str.getBytes());
        System.out.println(base64Encoded);

        String str2 = new String(Hex.decodeHex(base64Encoded.toCharArray()));
        System.out.println(str2);
    }

    @Test
    public void testMd5() {
        String str = "123";
        String salt = "";
        String md5 = new Md5Hash(str, salt).toString();
        System.out.println(md5);
    }
}
