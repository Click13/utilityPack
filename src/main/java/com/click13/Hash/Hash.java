package com.click13.Hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String getSHAValue_SHA_512(String text, HashingAlgorithms algorithm){
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm.name());
            byte[] encodedHash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return new String(encodedHash, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
