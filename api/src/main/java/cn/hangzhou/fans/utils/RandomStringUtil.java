package cn.hangzhou.fans.utils;


import java.util.Random;

public class RandomStringUtil {
    final private static int LENGTH = 32;
    private static String charPool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String random() {
        return random(LENGTH);
    }

    public static String random(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while (length -- > 0) {
            int index = random.nextInt(charPool.length());
            stringBuffer.append(charPool.charAt(index));
        }

        return stringBuffer.toString();
    }
}
