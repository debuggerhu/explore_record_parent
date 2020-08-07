package com.hhx;

/**
 * @author huhaixaing
 * @date 2020/8/7 16:34
 * @Description: com.hhx
 */
public class IntegerTest {
    public static void main(String[] args) {
        int hello = Integer.parseInt("1240", 10);
        System.out.println(hello);

        int hello1 = Integer.parseInt("1240", 16);
        System.out.println(hello1);

        Integer.parseInt("");//默认为十进制
        /**
         * public static int parseInt(String s) throws NumberFormatException {
         *         return parseInt(s,10);
         *     }
         */
    }
}
