package com.company.epi262.string;

public class AntProblem {
    public static void main(String[] args) {

        System.out.println(lookAndSay(10));
    }

    public static String lookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextNumber(s);
        }
        return s;
    }

    private static String nextNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
                ++count;
            }
            result.append(count);
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
