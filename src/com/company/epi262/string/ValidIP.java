package com.company.epi262.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 주어진 문자열에 대해서 마침표를 추가하여 가능한 모든 IP 주소를 출력하라. [ IPv4 버전을 기준으로 한다. ]
 */
public class ValidIP {
    public static void main(String[] args) {
        getValidIPAddress("19216811").forEach(System.out::println);
    }

    public static List<String> getValidIPAddress(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i < 4 && i < s.length(); i++) {
            final String first = s.substring(0, i);

            if(isValidPart(first)) {
                for(int j = 1; i + j < s.length() && j < 4; ++j) {
                    final String second = s.substring(i, i + j);
                    if(isValidPart(second)) {
                        for(int k = 1; i + j + k < s.length() && k < 4; ++k) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);

                            if(isValidPart(third) && isValidPart(fourth)) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValidPart(String s) {
        if(s.length() > 3) return false;

        // 0은 유효하나 01은 유효하지 않다. 이를 필터링
        if(s.startsWith("0") && s.length() > 1) return false;

        int value = Integer.parseInt(s);
        return 0 <= value && value <= 255;
    }
}
