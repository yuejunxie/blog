package com.drawinds.blog.portal;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/6 2:09
 * Description:
 */
public class Test {

    public static void main(String[] args) {
//        Map<String, String> valueMap = new HashMap<>(1);
//        valueMap.put("xxx", "xxx");
//        valueMap.put("ass", "xxx");
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(1);
//        map.put("aa","ds");
//        map.putAll(valueMap);
//        map.forEach((k, v) -> System.out.println(k + v));
        for (int i = 1; i < (1 << 10); i = i << 1) {
            int sc = Integer.numberOfLeadingZeros(i) | (1 << (16 - 1));
            System.out.println(i + "-" + sc);
            print(i);
            System.out.print("-");
            print(sc);
            System.out.println();
        }


    }

    private static void print(int num) {
        int count = 0;
        char[] bytes = new char[32];
        while (num > 0) {
            num = num >> 1;
            bytes[count] = '1';
            count++;
        }
        while (count < 32) {
            bytes[count] = '0';
            count++;
        }
        for (int i = bytes.length - 1; i >= 0; i--) {
            if (i == 16) {
                System.out.print('*');
            }
            System.out.print("" + bytes[i]);
        }
    }
}
