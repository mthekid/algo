package com.company.epi262.string;

/**
 * Java에서 제공하는 라이브러리를 사용하지 않고
 * 문자열로 주어진 정수형 숫자값을 정수형 숫자로 바꾸는 프로그램을 작성하라.
 */
public class Convert {
    public static void main(String[] args) {
        String input = "1234";
        System.out.println(stringToint(input));

        int x = 1234;
        System.out.println(intToString(x));

        int x2 = -1234;
        System.out.println(intToString(x));
    }

    private static int stringToint(String s) {
        int res = 0;
        // -인경우 인덱스가 1부터 시작한다. 아닌 경우는 0부터 시작. for문에 넣어서 이해하기 힘든 코드이지만 우아하다.
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length() ; ++i) {
            final int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        }
        return s.charAt(0) == '-' ? -res : res;
    }

    private static String intToString(int x) {
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append( (char) ('0' + Math.abs(x % 10)));
            x /= 10;
        } while (x != 0);

        if(isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }
}
