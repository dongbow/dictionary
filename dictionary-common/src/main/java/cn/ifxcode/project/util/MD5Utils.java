package cn.ifxcode.project.util;

import java.security.MessageDigest;

/**
 * MD5
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class MD5Utils {

    public static String md5(String input) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] bytes = md.digest();
            int i;
            for (int offset = 0; offset < bytes.length; offset++) {
                i = bytes[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
   }
    
   public static void main(String[] args){
       System.out.println(md5("123456"));
   }
}
