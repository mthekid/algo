package com.company.epi262.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlag {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 0, 2, 1, 1, 3);

        System.out.println("before " + list);
        dutchFlagPartition(2, list);
        System.out.println("After " + list );
    }

    private static void dutchFlagPartition(int pIdx, List<Integer> list) {
        int pivotValue = list.get(pIdx);


        // 피벗보다 작은 경우 해당 값들을 앞으로 가져온다. smaller 변수로 인덱스를 기록
        int smaller = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < pivotValue) {
                // 피벗 값보다 작은 경우의 index는 smaller 위치로 옮긴다. smaller 인덱스를 높인다.
                Collections.swap(list, smaller++, i);
            }
        }

        // 피벗보다 큰 경우 해당 값들을 뒤로 가져온다. larger 변수로 인덱스를 기록. [ 피벗보다 작은 값을 만나면 for문을 종료한다.(앞으로 배치한 피벗들은 로직처리가 필요없다.) ]
        int larger = list.size() - 1;
        for(int i = list.size() - 1; i >= 0 && list.get(i) >= pivotValue; --i) {
            if(list.get(i) > pivotValue) {
                Collections.swap(list, larger--, i);
            }
        }
    }
}
