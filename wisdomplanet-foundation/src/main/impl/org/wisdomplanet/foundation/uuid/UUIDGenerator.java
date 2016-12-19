package org.wisdomplanet.foundation.uuid;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by shixin on 2016/10/1.
 */
public class UUIDGenerator {

    private static char[] DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static int RADIX = DIGITS.length;

    private static String to62System(long value) {
        if (value == 0) {
            return "0";
        } else {
            char[] buf = new char[11];
            int charPos = 10;
            long i = value;
            while (i != 0) {
                buf[charPos--] = DIGITS[Math.abs((int) (i % RADIX))];
                i /= RADIX;
            }
            return new String(buf, charPos + 1, (10 - charPos));
        }
    }

    public static String randomUUID() {
        UUID uid=UUID.randomUUID();
        String shortId = to62System(uid.getMostSignificantBits()) + to62System(uid.getLeastSignificantBits());
        return shortId;
    }

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<1000;i++) {
            String uuid = UUIDGenerator.randomUUID();
            if(hs.contains(uuid)){
                System.out.println("===============================================================");
            }
            hs.add(uuid);
            System.out.println(">> " + uuid);
        }
        System.out.println(UUID.randomUUID().toString());
        System.out.println("DONE!!!!");
    }
}
