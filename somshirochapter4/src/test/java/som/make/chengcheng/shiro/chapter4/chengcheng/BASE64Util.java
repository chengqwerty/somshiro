package som.make.chengcheng.shiro.chapter4.chengcheng;

import org.apache.commons.codec.binary.Base64;

public class BASE64Util {

    /**
     *
     * @param source
     * @return
     */
    public static String encode(String source) {
        return encodeByte(source.getBytes());
    }

    /**
     *
     * @param source
     * @return
     */
    public static String decode(String source) {
        return new String(decodeToByte(source));
    }

    /**
     *
     * @param b
     * @return
     */
    public static String encodeByte(byte[] b) {
        return new String(new Base64().encode(b));
    }

    /**
     *
     * @param source
     * @return
     */
    public static byte[] decodeToByte(String source) {
        return new Base64().decode(source.getBytes());
    }

    public static void main(String[] args) {
        String source = "啊多发点收费的";

        String encodedStr = BASE64Util.encode(source);
        System.out.println("BASE64加密结果：");
        System.out.println(encodedStr);

        String decodedStr = BASE64Util.decode(encodedStr);
        System.out.println("BASE64解密结果：");
        System.out.println(decodedStr);
    }
}
