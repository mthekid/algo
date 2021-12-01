package com.company.algomonster.twopointer.samedirection;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 주어진 배열에서 0이 아닌 숫자들의 순서를 지킨 상태로 0을 맨뒤로 옮겨라.
 * 조건으로 추가적인 메모리 사용없이 array안에서 0을 뒤로 옮겨야 한다.
 */
public class MoveZeros {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(0);
        nums.add(2);
        nums.add(0);
        nums.add(0);
        nums.add(7);

        moveZeros(nums);
        System.out.println(nums.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" ")));
    }

    /**
     * @param nums 0과 0이 아닌 숫자들로 이루어져 있다.
     *             0이 아닌 숫자들의 순서를 유지한채 0을 맨 뒤로 보낸다.
     */
    private static void moveZeros(List<Integer> nums) {
        int slow = 0;
        int fast = 0;
//        int idx = 0;
        while(fast < nums.size()) {
//            idx++;
            int curv = nums.get(fast);
            int prev = nums.get(slow);
//            System.out.println("curv " + curv + " prev " + prev + " idx " + idx);
            if (curv != 0) {
                nums.set(slow, curv);
                slow++;
                nums.set(fast, prev);
                fast++;
            } else fast++;
        }
    }

    /**
     * 0이 아닌 숫자는 k개가 있다.
     * loop를 돌아 k개를 앞에 세팅한다. 이후 k index부터 0으로 채운다.
     * 깔끔한 정답이다.
     * @param nums
     */
    private static void solution(List<Integer> nums) {
        int i = 0;
        for(int n : nums) {
            if(n != 0) {
                nums.set(i, n);
                i++;
            }
        }
        // 나머지를 0으로 채운다
        for(; i< nums.size();i++) {
            nums.set(i, 0);
        }
    }
}
