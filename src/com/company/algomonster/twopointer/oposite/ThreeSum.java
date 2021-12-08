package com.company.algomonster.twopointer.oposite;

import java.util.*;

/**
 * 3개의 정수를 더해서 0이 되는 리스트를 구해라. 해당 리스트는 정렬된 순서로 처리되어야 한다.
 * 결과값들은 lexicograhpically하게 정렬되어야 한다.
 * 난이도 상.
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-1, 0, 1, 2, -1, -4);
        List<List<Integer>> res = tripletsWithSum0(nums);
        System.out.println(res);
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
//        System.out.println(numCount);

        // 고유한 정보들을 key로 둔다. [ 여기까지가 전처리 과정이다. ]
        List<Integer> uniqueNums = new ArrayList<>(numCount.keySet());
        Collections.sort(uniqueNums);
//        System.out.println(uniqueNums);

        // 실제 알고리즘 처리 과정
        /**
         * 정렬된 고유 값들을 기반으로 triplet의 포인터를 구한다.
         * i는 첫번쨰 pointer이고
         * j는 두번째 포인터이다.
         * third num 은 -i -j의 값이다. map자료구조를 사용했기에 thirdNum이 존재하는지 여부를 쉽게 조회할 수 있따.
         */
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < uniqueNums.size(); i++) {
            int firstNum = uniqueNums.get(i);

            // -1을 처리해서 두번째 세번째 포인터에서 참조하지 못하게끔 만든다.
            numCount.merge(firstNum, -1, Integer::sum);

            for(int j = i; j < uniqueNums.size(); j++) {
                int secondNum = uniqueNums.get(j);
                // 세번째 Num의 경우가 존재하는지를 체크해야 한다.
                int thirdNum = -firstNum - secondNum;

                // 정렬되었기에 thirdNum이 secondNum보다 작은 경우 second 포인터 다음으로 존재하지 않음을 알 수 있다.
                if(thirdNum < secondNum) break;

                // secondNum 존재하지 않는 경우(firstNum과 중복되면서 여분이 없는 경우)
                if(numCount.get(secondNum) <= 0) continue;

                // 존재하는 경우로 firstNum, secondNum, thirdNum으로 triplet을 얻을 수 있다.
                numCount.merge(secondNum, -1, Integer::sum);

                // thirdNum이 존재하지 않는 경우 혹은 2번째 값과 동일한 경우이다.
                // 이 경우는 thirdNum을 사용해서는 안된다. 다음으로 넘어간다.
                if(numCount.getOrDefault(thirdNum, 0) <= 0) {
                    numCount.merge(secondNum, 1, Integer::sum);
                    continue;
                }

                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(firstNum);
                newList.add(secondNum);
                newList.add(thirdNum);
                res.add(newList);
                numCount.merge(secondNum, 1, Integer::sum);
            }
        }

        return res;
    }
}
