package com.ohgiraffers.base64;

import java.util.Base64;

public class EncodingDecoding {
    public static void main(String[] args) {
        // java 8에서 제공하는 기본 base64 Encoder와 Decoder
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        /* 인코딩 */
        String testStr = "base64로 인코딩한 비밀키";
        byte[] encodeArr = testStr.getBytes();

        byte[] encodeByte = encoder.encode(encodeArr);
        String encodeStr = new String(encodeByte);
        System.out.println("encodeStr = " + encodeStr);

        /* 디코딩 */
        byte[] decodeByte = decoder.decode(encodeStr);
        String decodeStr = new String(decodeByte);
        System.out.println("decodeStr = " + decodeStr);
    }
}
