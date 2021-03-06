package aal.blog.util;

import java.util.Random;


public class RandomKeyUtil {
    private static Random random = new Random();
    private static String code;

    public static String generateCode() {
        code = "";

        for (int i = 0; i < 6; i++) {
            if (random.nextBoolean()) {
                code += random.nextInt(9);
            } else {
                code += (char) (random.nextInt(26) + 97);
            }
        }

        return code;
    }
}
