package com.company.algomonster.twopointer.oposite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 3개의 정수를 더해서 0이 되는 리스트를 구해라. 해당 리스트는 정렬된 순서로 처리되어야 한다.
 * 결과값들은 lexicograhpically하게 정렬되어야 한다.
 * 난이도 상.
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-1, 0, 1, 2, -1, -4);
        List<List<Integer>> res = tripletsWithSum0(nums);
    }

    /**
     *
     * @param nums 정수로 이루어진 리스트 값
     * @return lexicographically하게 정렬된 triplet을 반환해야한다. [how?]
     * unique해야 한다 => Set?
     * brute force => 3중 for-loop?
     */
    private static List<List<Integer>> tripletsWithSum0(List<Integer> nums) {
        // 중복된 값들을 제거해야 한다.
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums) {
            numCount.merge(num, 1, Integer::sum);
        }
        System.out.println(numCount);

        // 고유한 정보들을 key로 둔다.
        List<Integer> uniqueNums = new ArrayList<>(numCount.keySet());
        Collections.sort(uniqueNums);
        System.out.println(uniqueNums);

        return List.of();
    }
}
