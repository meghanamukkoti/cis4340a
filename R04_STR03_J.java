package main;

import java.math.BigInteger;
import java.util.Base64;

public class BigIntegerSerialization {
    public static void main(String[] args) {
        BigInteger bigInt = new BigInteger("530500452766");

        String decimalString = bigInt.toString(); 
        bigInt = new BigInteger(decimalString);
        System.out.println("BigInteger using direct string: " + bigInt);

        byte[] bigIntBytes = bigInt.toByteArray();
        String base64Encoded = Base64.getEncoder().encodeToString(bigIntBytes);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        bigInt = new BigInteger(decodedBytes);
        System.out.println("BigInteger using Base64: " + bigInt);
    }
}
