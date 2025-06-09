package com.ohgiraffers.base64;

import java.util.Base64;

public class EncodingDecoding {

    public static void main(String[] args) {

        // java 8에서 제공하는 기본 Base64 Encoder와 Decoder
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        /* encode */
        String testStr = "base64로인코딩한비밀키";
        byte[] encodeArr = testStr.getBytes();

        byte[] encodeByte = encoder.encode(encodeArr);
        String encodeStr = new String(encodeByte);
        System.out.println("encodeStr = " + encodeStr);

        /* decode */
        byte[] decodeByte = decoder.decode(encodeStr);
        System.out.println("decodeStr = " + new String (decodeByte));
    }
}
