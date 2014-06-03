package com.tl.myspring;

import java.security.MessageDigest;

/**
 * Created by tlnacl on 25/04/14.
 */
public class Util {

    public static String doMD5(String account){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((account+ System.currentTimeMillis()).getBytes());
            byte[] md5byte = md.digest();
            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < md5byte.length; offset++) {
                i = md5byte[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
