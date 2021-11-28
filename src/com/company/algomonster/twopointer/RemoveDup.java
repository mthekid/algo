package com.company.algomonster.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class RemoveDup {
    /**
     * 추가적인 메모리 사용없이 내부에서 중복된 값을 제거한 List로 변환.
     * @param arr : 정렬된 정수 List가 들어온다.
     * @return 중복된 값이 없는 List로 만들고 그 길이를 반환한다.
     */
    public static int removeDuplicates(List<Integer> arr) {
        int idx = 0;
        for(int p = 0; p < arr.size() - 1; p++) {
            int curv = arr.get(p);
            int nextv = arr.get(p + 1);

            if (curv != nextv) {
                idx += 1;
                arr.set(idx, nextv);
            }
        }
        return arr.subList(0, idx + 1).size();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> arr = splitWords(scanner.nextLine()).stream()
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        scanner.close();
        List<Integer> arr = Arrays.asList(0, 0, 1, 1, 2, 2);

        int res = removeDuplicates(arr);

        System.out.println(arr.stream().limit(res)
            .map(String::valueOf).collect(Collectors.joining()));
    }
}
