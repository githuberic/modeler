package com.lgq.modeler.bk.unixsocket.exec_codec.codec.exec_01;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class Index {
    public static void main(String[] args) throws Exception {
        String str = "老刘lgq";
        byte[] bStr = str.getBytes("UTF-8");
        String base64Str = Base64.encodeBase64String(bStr);
        String base64 = base64Encode("ricky");
        System.out.println("base64 encode=" + base64);
    }
}
