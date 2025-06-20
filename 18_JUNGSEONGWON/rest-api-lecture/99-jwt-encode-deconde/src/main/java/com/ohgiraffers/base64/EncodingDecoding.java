package com.ohgiraffers.base64;

import java.util.Base64;

public class EncodingDecoding {

    public static void main(String[] args) {

        // java 8 버전에서 제공하는 기본 Base64 Encoder와 Decoder가 있다.
        Base64.Encoder encoder =  Base64.getEncoder();
        Base64.Decoder decoder =  Base64.getDecoder();

        /* encode */
        String teststr = "base64로 인코딩한 비밀키";
        byte[] encodeArr = teststr.getBytes();
        byte[] encodeByte = encoder.encode(encodeArr);
        String encodeStr = new String(encodeByte);
        System.out.println("encodeStr = " + encodeStr);

        /* decode */
        byte[] decodeArr = decoder.decode(encodeStr);
        String decodeStr = new String(decodeArr);
        System.out.println("decodeStr = " + decodeStr);
    }
}
