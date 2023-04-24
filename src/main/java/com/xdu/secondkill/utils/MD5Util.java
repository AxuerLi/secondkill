package com.xdu.secondkill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author : ruixueli
 * @date : 2023/4/24 8:12
 * @modyified By :
 */

@Component
public class MD5Util {

    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    private static final String salt = "1q2w3e4r";

    /**
     * @Author rxli
     * @Description 第一次加密
     * @Date 8:25 2023/4/24
     * @Param [inputPass]
     * @return java.lang.String
     **/
    public static String inputPassToFromPass(String inputPass) {
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * @Author rxli
     * @Description 第二次加密
     * @Date 8:30 2023/4/24
     * @Param [formPass, salt]
     * @return java.lang.String
     **/
    public static String fromPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }


}
