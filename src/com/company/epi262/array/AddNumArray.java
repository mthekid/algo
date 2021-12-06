package com.company.epi262.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 십진수 D를 나타낸 배열 A가 주어졌을 때 D+1의 결과를 다시 배열 A에 갱신하는 코드를 작성하라.
 * 999인 경우 상당히 난감할 것이다.
 */
public class AddNumArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);

//        List<Integer> list2 = Arrays.asList(1, 0 , 0, 9);

        System.out.println("Before " + list);
        System.out.println("After " + plusOneSol(list));
//        System.out.println(plusOne(list2));
    }

    // solution
    public static List<Integer> plusOneSol(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        // 조건문을 같이 처리했다.
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if(A.get(0) == 10) {
            // 최상위 숫자에 올림수가 존재하기에, 결과 저장을 위해 한 자리가 더 필요하다.
            // 첫 번쨰 항목을 1로 업데이트하고 배열 끝에 0을 추가한다.
            A.set(0, 1);
            A.add(0);
        }
        return A;
    }

    private static List<Integer> plusOne(List<Integer> list) {
        int lastIdx = list.size() - 1;
        int mvcnt = 0;
        // 9를 어떻게 처리할 것인지가 중요한 포인트이다. 9가 아니라면 신경쓸 필요가 없다.
        while(list.get(lastIdx) == 9 && lastIdx > 0) {
            --lastIdx;
            mvcnt++;
        }

        for (int i = 0; i < mvcnt; i++) {
            list.set(list.size() -1 - i, 0);
        }

        list.set(lastIdx, list.get(lastIdx) + 1);
        return list;
    }
}
