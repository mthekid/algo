package com.company.epi262.string;

/**
 * 스프레드 시트의 열 표기법은 다음과 같다. A-Z이후 AA .. ZZ 이후 AAA, AAB - ZZZ로 표현한다.
 * 스프레드시트의 열값이 문자열로 주어졌을 때 이를 정수값으로 변환하는 함수를 작성하라.
 * "AA"는 27에 해당하고 ZZ는 702으로 표현된다. [ 밑이 26 수라고 봐도 된다. ]
 */
public class CalcSpreadSheetColumn {

    public static void main(String[] args) {
        String s = "A";
        assert ssDecodeColID(s) == 1;

        String s2 = "ZZ";
        System.out.println(ssDecodeColID(s2));
        assert ssDecodeColID(s2) == 702;
    }

    private static int ssDecodeColID(final String col) {
        int res = 0;
        for(int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
