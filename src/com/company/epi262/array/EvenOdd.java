package com.company.epi262.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정수 배열(리스트)가 주어졌을 때 짝수가 먼저 나오도록 재배열해 보라.
 * 배열의 길이가 n이라고 했을 때, 추가 공간을 O(n)만큼 사용하면 쉽게 풀 수 있따.
 */
public class EvenOdd {

    public static void main(String[] args) {
        // List.of(~~) 는 수정 불가능한 List를 반환한다.
        List<Integer> list = Arrays.asList(5, 3, 1, 2, 4, 9, 10);

        System.out.println("Before : " + list);
        evenOdd(list);
        System.out.println("After : " + list);
    }

    /**
     * 앞쪽에는 짝수를 뒤쪽에는 홀수가 있는 리스트를 만든다. [ 투포인터(Opposite) 패턴을 사용하여 푼다. ]
     * 배열은 투 포인터 기법이 깔끔하게 활용될 수 있는 자료구조이다.
     * @param list : 수정될 리스트
     */
    private static void evenOdd(List<Integer> list) {
        int nextEven = 0, nextOdd = list.size() - 1;

        while(nextEven < nextOdd) {
            if(list.get(nextEven) % 2 == 0) {
                nextEven++;
            } else {
                Collections.swap(list, nextEven, nextOdd--);
            }
        }
    }
}
